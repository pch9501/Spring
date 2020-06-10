package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
public class EmpDAO extends SqlSessionDaoSupport{
	public List<EmpVO> empAllData()
	{
		return getSqlSession().selectList("empAllData");
		/* 
		 * 위의 코드에는 아래의 openSession, close Session 코드가 포함되어 있다.
		 * 즉, 우리가 이전에 아래와 같이 길게 코딩했던 것을 위와 같이 간단하게 코딩할 수 있다. 
		 * 
		 * try
		 * {
		 * 		session=ssf.openSession()l
		 * 		session.selectList("");
		 * }catch(Exception ex)
		 * {
		 * 		System.out.println(ex.getMessage());
		 * }
		 * finally
		 * {
		 * 		if(session!=null)
		 * 			session.close()l
		 * } 
		 * 
		 */
	}
	public EmpVO empFindData(int empno)
	{
		return getSqlSession().selectOne("empFindData",empno);
	}
}
