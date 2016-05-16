package cn.hncu.bookStore.in.business.ebo;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cn.hncu.bookStore.book.business.ebi.BookEbi;
import cn.hncu.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.bookStore.common.UuidModelConstance;
import cn.hncu.bookStore.common.uuid.dao.dao.UuidDAO;
import cn.hncu.bookStore.common.uuid.dao.factory.UuidDAOFactory;
import cn.hncu.bookStore.in.business.ebi.InMainEbi;
import cn.hncu.bookStore.in.dao.dao.InDetailDAO;
import cn.hncu.bookStore.in.dao.dao.InMainDAO;
import cn.hncu.bookStore.in.dao.factory.InDetailDAOFactory;
import cn.hncu.bookStore.in.dao.factory.InMainDAOFactory;
import cn.hncu.bookStore.in.vo.InDetailModel;
import cn.hncu.bookStore.in.vo.InDetailQueryModel;
import cn.hncu.bookStore.in.vo.InMainModel;
import cn.hncu.bookStore.in.vo.InMainQueryModel;
import cn.hncu.bookStore.store.dao.dao.StockDAO;
import cn.hncu.bookStore.store.dao.factory.StockDAOFactory;
import cn.hncu.bookStore.store.vo.StockModel;
import cn.hncu.bookStore.store.vo.StockQueryModel;

public class InMainEbo implements InMainEbi{
	//注入DAO
	InMainDAO inMainDao=InMainDAOFactory.getInMainDAO();
	InDetailDAO inDetailDao=InDetailDAOFactory.getInDetailDAO();
	UuidDAO uuidDao=UuidDAOFactory.getUuidDAO();
	BookEbi bookEbi=BookEbiFactory.getBookEbi();
	@Override
	public boolean addInMain(InMainModel inMain,List<InDetailModel> details) {
		
		////1存储inMain
		//先要补全对象:
		//需要： uuid进货单编号 进货时间 进货人员编号
		//已有: 进货人员编号
		//还需： uuid进货单编号 进货时间
		
		//1 
		String inUuid=uuidDao.getNextUuid(UuidModelConstance.IN_Main);
		inMain.setUuid(inUuid);
		inMain.setInDate(System.currentTimeMillis());
		inMainDao.addInMain(inMain);
		
		/////2存储inDetail信息
		for(InDetailModel inDetail:details ){
			//需要： uuid进货明细编号 inId进货编号 bookId图书编号 sumNum进货数量 sumMoney进货总价
			//已有:bookId图书编号  sumNum进货数量
			//还需:uuid进货明细编号 inId进货编号 sumMoney进货总价
			inDetail.setUuid(uuidDao.getNextUuid(UuidModelConstance.In_Detail));
			inDetail.setInId(inUuid);
			double sumMoney=inDetail.getSumNum()* bookEbi.getSingle(inDetail.getBookId()).getInPrice();
			inDetail.setSumMoney(sumMoney);
			inDetailDao.addInDetail(inDetail);
			
			//图书入库操作
			putInStock(inDetail.getBookId(),inDetail.getSumNum());
			
		}
		return true;
	}
	
	
	
	private void putInStock(String bookId, int sumNum) {
		//注入StockDAO 
		StockDAO stockDao=StockDAOFactory.getStockDAO();
		
		//遍历，看库存中是否存在此图书，如果存在就加上sumNum；否则自己创建添加
		StockQueryModel sqm=new StockQueryModel();
		sqm.setBookUuid(bookId);
		List<StockModel> list=stockDao.getByCondition(sqm);
		
		if(list==null || list.size()==0){//库存中没有,自己添加创建
			StockModel stock =new StockModel();
			String uuid=UuidDAOFactory.getUuidDAO().getNextUuid(UuidModelConstance.STACK);
			stock.setUuid(uuid);
			stock.setBookUuid(bookId);
			stock.setSumNum(sumNum);
			stock.setBookName(BookEbiFactory.getBookEbi().getSingle(bookId).getName());
			stockDao.addStock(stock);
		}else{//已有 在此图书的基础上加
			StockModel stock =list.get(0);
			stock.setSumNum(stock.getSumNum()+sumNum);
			stockDao.updateStock(stock);
		}
		
	}



	@Override
	public Map<InMainModel, List<InDetailModel>> getAll() {
		Map<InMainModel, List<InDetailModel>> map=new TreeMap<InMainModel, List<InDetailModel>>();
		List<InMainModel> inMains=inMainDao.getAll();
		for(InMainModel inMain:inMains){
			InDetailQueryModel idqm=new InDetailQueryModel();
			idqm.setInId(inMain.getUuid());
			List<InDetailModel> inDetails=inDetailDao.getByCondition(idqm);
			map.put(inMain, inDetails);
		}
		return map;
	}



	@Override
	public Map<InMainModel, List<InDetailModel>> getByCondition(
			InMainQueryModel imqm, InDetailQueryModel idqm) {
		Map<InMainModel, List<InDetailModel>> map=new TreeMap<InMainModel, List<InDetailModel>>();
		List<InMainModel> inMains=inMainDao.getByCondition(imqm);
		for(InMainModel model:inMains){
			idqm.setInId(model.getUuid());
			List<InDetailModel> inDetails=inDetailDao.getByCondition(idqm);
			if(inDetails.size()!=0){
				map.put(model, inDetails);
			}
		}
		return map;
	}




	
}
