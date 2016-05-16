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
	//ע��DAO
	BookEbi bookEbi=BookEbiFactory.getBookEbi();
	OutMainDAO outMainDao=OutMainDAOFactory.getOutMainDAO();
	OutDetailDAO outDetailDao=OutDetailDAOFactory.getOutDetailDAO();
	UuidDAO uuidDao=UuidDAOFactory.getUuidDAO();
	
	@Override
	public boolean addOutMain(OutMainModel outMain, List<OutDetailModel> details) {
		//������棬��������Ƿ��д�ͼ�飬�еĻ������Ƿ�������������
		//ע��dao
		StockDAO stockDao=StockDAOFactory.getStockDAO();
		for(OutDetailModel outDetail:details){
			StockQueryModel sqm=new StockQueryModel();
			sqm.setBookUuid(outDetail.getBookUuid());
			List<StockModel> list=stockDao.getByCondition(sqm);
			if(list==null || list.size()==0){
				JOptionPane.showMessageDialog(null, "����в����ڴ�ͼ��");
				return false;
			}else{
				StockModel stock =list.get(0);
				if(outDetail.getSumNum()>stock.getSumNum()){
					JOptionPane.showMessageDialog(null, "��ͼ���治��");
					return false;
				}
			}
		}
		
		
		
		//1�洢OutMain
		//��ȫ����
		//��Ҫ�����۵���� ����ʱ�� ������Ա���
		//���� ������Ա���
		//���� ���۵���� ����ʱ��
		String outUuid=uuidDao.getNextUuid(UuidModelConstance.OUT_Main);
		outMain.setUuid(outUuid);
		outMain.setOutDate(System.currentTimeMillis());
		outMainDao.addOutMain(outMain);
		
		//2�洢OutDetail
		//��ȫ����
		for(OutDetailModel outDetail:details){
			//��Ҫ�� uuid������ϸ��� inId���۱�� bookIdͼ���� sumNum�������� sumMoney�����ܼ�
			//����:bookIdͼ����  sumNum��������
			//����:uuid������ϸ��� OutId���۱�� sumMoney�����ܼ�
			String OutDetailuuid=uuidDao.getNextUuid(UuidModelConstance.OUT_Detail);
			outDetail.setUuid(OutDetailuuid);
			outDetail.setOutId(outUuid);
			outDetail.setSumMoney(outDetail.getSumNum()* bookEbi.getBookByName(outDetail.getBookName()).getSalePrice());
			outDetailDao.addOutDetail(outDetail);
			
			//���¿�����
			//��������ķ�����������һ���ܹ�����ȥ��
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
