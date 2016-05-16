package cn.hncu.bookStore.out.business.ebi;

import java.util.List;
import java.util.Map;

import cn.hncu.bookStore.out.dao.dao.OutDetailDAO;
import cn.hncu.bookStore.out.vo.OutDetailModel;
import cn.hncu.bookStore.out.vo.OutDetailQueryModel;
import cn.hncu.bookStore.out.vo.OutMainModel;
import cn.hncu.bookStore.out.vo.OutMainQueryModel;

public interface OutMainEbi {
	public boolean addOutMain(OutMainModel outMain, List<OutDetailModel> details);
	
	public Map<OutMainModel, List<OutDetailModel>>getAll();
	public Map<OutMainModel, List<OutDetailModel>> getByCondition(OutMainQueryModel omqm,OutDetailQueryModel odqm);
}
