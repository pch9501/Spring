package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;

//[XML 안 쓰고 Java Annotation만으로 DB 연동하기] 
/* [app.xml](SpringBasicProject4) 에서의 아래의 코드를 Annotation을 써서 만들어보자
* <!-- 5. SqlSessionFactory를 DAO에 전송 -->
	<bean id="dao" class="com.sist.dao.EmpDAO"
		p:sqlSessionFactory-ref="ssf"
	/>
*/

@Repository
//@Repository //메모리 할당: @Repositiry("id") - 만약 id를 안 주면 클래스명(앞글자는 소문자로 변경됨)이 자동으로 ID로 지정됨.
//위의 어노테이션은 아래의 XML 코드와 동일하다
//<bean id="eDao" class="com.sist.dao.EmpDAO"/>
public class EmpDAO extends SqlSessionDaoSupport{
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public List<EmpVO> empAllData()
	{
		return getSqlSession().selectList("empAllData");
	}
	public EmpVO empFindData(int empno)
	{
		return getSqlSession().selectOne("empFindData",empno);
	}
}
