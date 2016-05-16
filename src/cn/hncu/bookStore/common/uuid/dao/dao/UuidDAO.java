package cn.hncu.bookStore.common.uuid.dao.dao;

import cn.hncu.bookStore.common.UuidModelConstance;

public interface UuidDAO {
	public String getNextUuid(UuidModelConstance uuidEnum);
}
