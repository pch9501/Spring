package com.sist.spring2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Spring5.0 ==> XML 없이 코딩 가능 
//Java로만 하다보니 DI가 없음 ==> 아래와 같이 직접 코딩해줘야함..

@Configuration
public class Config {
	@Bean // ==> XML에서의 bean 태그를 대체함 
	public EmpDAO empDAO() // ==> XML에서의 <bean id="empDAO" class="com.sist.spring2.EmpDAO">와 같은 코딩.   
							//즉, XML에서의 bean id가 Spring5.0에서는 메소드 이름이 된다. 
	{
		EmpDAO dao=new EmpDAO();
		
		dao.setDriverName("oracle.jdbc.driver.OracleDriver");
		dao.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dao.setUserName("hr");
		dao.setPassword("happy");
		dao.init();
		
		return dao;
	}
}
