package com.sist.temp;

import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO implements MyDAO{

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("NoticeDAO:select() call..");
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("NoticeDAO:insert() call..");
	}

}
