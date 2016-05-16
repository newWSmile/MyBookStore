package cn.hncu.bookStore.in.business.ebi;

import java.util.List;
import java.util.Map;

import cn.hncu.bookStore.in.vo.InDetailModel;
import cn.hncu.bookStore.in.vo.InDetailQueryModel;
import cn.hncu.bookStore.in.vo.InMainModel;
import cn.hncu.bookStore.in.vo.InMainQueryModel;

public interface InMainEbi {
	public boolean addInMain(InMainModel inMain,List<InDetailModel> detais);
	
	public Map<InMainModel, List<InDetailModel>> getAll();

	public Map<InMainModel, List<InDetailModel>> getByCondition(
			InMainQueryModel imqm, InDetailQueryModel idqm);
}
