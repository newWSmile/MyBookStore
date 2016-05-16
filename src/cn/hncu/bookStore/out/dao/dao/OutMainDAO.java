package cn.hncu.bookStore.out.dao.dao;

import java.util.List;

import cn.hncu.bookStore.out.vo.OutMainModel;
import cn.hncu.bookStore.out.vo.OutMainQueryModel;

public interface OutMainDAO {
	public boolean addOutMain(OutMainModel outMain);
	public boolean deleteOutMain(String uuid);
	public boolean updateOutMain(OutMainModel outMain);
	
	
	public OutMainModel getSingle(String uuid);
	public List<OutMainModel> getAll();
	public List<OutMainModel> getByCondition(OutMainQueryModel omqm);
	
}
