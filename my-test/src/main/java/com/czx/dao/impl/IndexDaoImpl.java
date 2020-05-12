package com.czx.dao.impl;

import com.czx.dao.IndexDao;
import org.springframework.stereotype.Repository;

@Repository
public class IndexDaoImpl implements IndexDao {

	@Override
	public void query() {
		System.out.println("dao");
	}

}
