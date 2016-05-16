package cn.hncu.bookStore.out.business.factory;

import cn.hncu.bookStore.out.business.ebi.OutMainEbi;
import cn.hncu.bookStore.out.business.ebo.OutMainEbo;

public class OutMainEbiFactory {
	public static OutMainEbi getOutMainEbi(){
		return new OutMainEbo();
	}
}
