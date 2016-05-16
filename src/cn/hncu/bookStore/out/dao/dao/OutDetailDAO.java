package cn.hncu.bookStore.out.dao.dao;

import java.util.List;

import cn.hncu.bookStore.out.vo.OutDetailModel;
import cn.hncu.bookStore.out.vo.OutDetailQueryModel;

public interface OutDetailDAO {
	public boolean addOutDetail(OutDetailModel outDetail);
	public boolean deleteOutDetail(String uuid);
	public boolean updateOutDetail(OutDetailModel outDetail);
	
	public OutDetailModel getSingle(String uuid);
	public List<OutDetailModel> getAll();
	public List<OutDetailModel> getByCondition(OutDetailQueryModel odqm);
}
