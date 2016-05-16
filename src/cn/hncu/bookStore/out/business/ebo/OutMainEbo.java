package cn.hncu.bookStore.out.business.ebo;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import cn.hncu.bookStore.book.business.ebi.BookEbi;
import cn.hncu.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.bookStore.book.dao.dao.BookDAO;
import cn.hncu.bookStore.common.UuidModelConstance;
import cn.hncu.bookStore.common.uuid.dao.dao.UuidDAO;
import cn.hncu.bookStore.common.uuid.dao.factory.UuidDAOFactory;
import cn.hncu.bookStore.out.business.ebi.OutMainEbi;
import cn.hncu.bookStore.out.dao.dao.OutDetailDAO;
import cn.hncu.bookStore.out.dao.dao.OutMainDAO;
import cn.hncu.bookStore.out.dao.factory.OutDetailDAOFactory;
import cn.hncu.bookStore.out.dao.factory.OutMainDAOFactory;
import cn.hncu.bookStore.out.vo.OutDetailModel;
import cn.hncu.bookStore.out.vo.OutDetailQueryModel;
import cn.hncu.bookStore.out.vo.OutMainModel;
import cn.hncu.bookStore.out.vo.OutMainQueryModel;
import cn.hncu.bookStore.store.business.factory.StockEbiFactory;
import cn.hncu.bookStore.store.dao.dao.StockDAO;
import cn.hncu.bookStore.store.dao.factory.StockDAOFactory;
import cn.hncu.bookStore.store.vo.StockModel;
import cn.hncu.bookStore.store.vo.StockQueryModel;

public class OutMainEbo implements OutMainEbi{
	//注入DAO
	BookEbi bookEbi=BookEbiFactory.getBookEbi();
	OutMainDAO outMainDao=OutMainDAOFactory.getOutMainDAO();
	OutDetailDAO outDetailDao=OutDetailDAOFactory.getOutDetailDAO();
	UuidDAO uuidDao=UuidDAOFactory.getUuidDAO();
	
	@Override
	public boolean addOutMain(OutMainModel outMain, List<OutDetailModel> details) {
		//遍历库存，看库存中是否有此图书，有的话数量是否够卖出的数量；
		//注入dao
		StockDAO stockDao=StockDAOFactory.getStockDAO();
		for(OutDetailModel outDetail:details){
			StockQueryModel sqm=new StockQueryModel();
			sqm.setBookUuid(outDetail.getBookUuid());
			List<StockModel> list=stockDao.getByCondition(sqm);
			if(list==null || list.size()==0){
				JOptionPane.showMessageDialog(null, "库存中不存在此图书");
				return false;
			}else{
				StockModel stock =list.get(0);
				if(outDetail.getSumNum()>stock.getSumNum()){
					JOptionPane.showMessageDialog(null, "此图书库存不够");
					return false;
				}
			}
		}
		
		
		
		//1存储OutMain
		//补全对象
		//需要：销售单编号 销售时间 销售人员编号
		//已有 销售人员编号
		//还需 销售单编号 销售时间
		String outUuid=uuidDao.getNextUuid(UuidModelConstance.OUT_Main);
		outMain.setUuid(outUuid);
		outMain.setOutDate(System.currentTimeMillis());
		outMainDao.addOutMain(outMain);
		
		//2存储OutDetail
		//补全对象
		for(OutDetailModel outDetail:details){
			//需要： uuid销售明细编号 inId销售编号 bookId图书编号 sumNum销售数量 sumMoney销售总价
			//已有:bookId图书编号  sumNum销售数量
			//还需:uuid销售明细编号 OutId销售编号 sumMoney销售总价
			String OutDetailuuid=uuidDao.getNextUuid(UuidModelConstance.OUT_Detail);
			outDetail.setUuid(OutDetailuuid);
			outDetail.setOutId(outUuid);
			outDetail.setSumMoney(outDetail.getSumNum()* bookEbi.getBookByName(outDetail.getBookName()).getSalePrice());
			outDetailDao.addOutDetail(outDetail);
			
			//更新库存操作
			//经过上面的防护，这里是一定能够卖出去的
			StockQueryModel sqm =new StockQueryModel();
			sqm.setBookUuid(outDetail.getBookUuid());
			List<StockModel> list=stockDao.getByCondition(sqm);
			StockModel stock =list.get(0);
			stock.setSumNum(stock.getSumNum()-outDetail.getSumNum());
			stockDao.updateStock(stock);
			
		}
		return true;
	}

	@Override
	public Map<OutMainModel, List<OutDetailModel>> getAll() {
		Map<OutMainModel, List<OutDetailModel>> map=new TreeMap<OutMainModel, List<OutDetailModel>>();
		List<OutMainModel> outMains = outMainDao.getAll();
		for(OutMainModel outMain:outMains){
			OutDetailQueryModel odqm =new OutDetailQueryModel();
			odqm.setOutId(outMain.getUuid());
			
			
			List<OutDetailModel> outDetails=outDetailDao.getByCondition(odqm);
			map.put(outMain, outDetails);
		}
		return map;
	}

	@Override
	public Map<OutMainModel, List<OutDetailModel>> getByCondition(
			OutMainQueryModel omqm, OutDetailQueryModel odqm) {
		Map<OutMainModel, List<OutDetailModel>> map=new TreeMap<OutMainModel, List<OutDetailModel>>();
		List<OutMainModel> outMains = outMainDao.getByCondition(omqm);
		for(OutMainModel outMain:outMains){
			odqm.setOutId(outMain.getUuid());
			List<OutDetailModel> outDetails=outDetailDao.getByCondition(odqm);
			if(outDetails.size()>0){
				map.put(outMain, outDetails);
			}
		}
		return map;
	}

}
