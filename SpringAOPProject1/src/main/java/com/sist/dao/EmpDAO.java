package com.sist.dao;

import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {
	// [getConnection,disConnection]
	// - 아래의 선언+반복되는 호출을 없애고 자동호출하게 만들거임
	// ====> com.sist.aspect에 'MyAspect' 파일을 만들었음
	/*
	public void getConnection()
	{
		System.out.println("오라클 연결");
	}
	public void disConnection()
	{
		System.out.println("오라클 연결 해제");
	}
	*/
	
	public void emp_select()
	{
//		getConnection();
		System.out.println("emp테이블에서 데이터를 가지고 온다.");
//		disConnection();
	}
	public void emp_insert(String name)
	{
//		getConnection();
		System.out.println(name+"을 추가");
//		disConnection();
	}
	public void emp_update(int sabun,String name)
	{
//		getConnection();
//		int a=10/0;
		System.out.println(sabun+"에 해당되는"+name+"을 수정하였습니다");
//		disConnection();
	}
	public String emp_delete(int sabun)
	{
//		getConnection();
		System.out.println(sabun+"을 삭제하였습니다");
//		disConnection();
		
		return "삭제완료";
	}
	public void driverClassNameConfig()
	{
		System.out.println("오라클 드라이버 등록");
	}
	public void display()
	{
		for(int i=0;i<=1000000000;i++)
		{
			
		}
		System.out.println("for문 종료..");
	}
}
