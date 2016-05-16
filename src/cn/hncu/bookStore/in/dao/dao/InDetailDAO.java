package cn.hncu.bookStore.in.dao.dao;

import java.util.List;

import cn.hncu.bookStore.in.vo.InDetailModel;
import cn.hncu.bookStore.in.vo.InDetailQueryModel;

public interface InDetailDAO {
	public boolean addInDetail(InDetailModel inDetail);
	public boolean deleteInMain(String uuid);
	public boolean updateInMain(InDetailModel inDetail);
	
	public InDetailModel getSingle(String uuid);
	public List<InDetailModel> getAll();
	public List<InDetailModel> getByCondition(InDetailQueryModel idqm );
}
