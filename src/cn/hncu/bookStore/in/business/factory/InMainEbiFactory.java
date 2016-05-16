package cn.hncu.bookStore.in.business.factory;

import cn.hncu.bookStore.in.business.ebi.InMainEbi;
import cn.hncu.bookStore.in.business.ebo.InMainEbo;

public class InMainEbiFactory {
	public static InMainEbi getInMainEbi(){
		return new InMainEbo();
	}
}
