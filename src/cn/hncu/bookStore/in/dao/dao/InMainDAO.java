package cn.hncu.bookStore.in.dao.dao;

import java.util.List;

import cn.hncu.bookStore.in.vo.InMainModel;
import cn.hncu.bookStore.in.vo.InMainQueryModel;

public interface InMainDAO {
	public boolean addInMain(InMainModel inMain);
	public boolean deleteInMain(String uuid);
	public boolean updateInMain(InMainModel inMain);
	
	public InMainModel getSingle(String uuid);
	public List<InMainModel> getAll();
	public List<InMainModel> getByCondition(InMainQueryModel imqm);
	
}
