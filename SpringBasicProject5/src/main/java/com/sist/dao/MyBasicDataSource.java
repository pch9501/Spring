package com.sist.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;

//[XML 안 쓰고 Java Annotation만으로 DB 연동하기] 
/*[app.xml](SpringBasicProject4) 에서의 아래의 코드를 Annotation을 써서 만들어보자 
* <!-- 2. DataBase 정보 전송 -->
* <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
		p:driverClassName="oracle.jdbc.driver.OracleDriver"
		p:url="jdbc:oracle:thin:@localhost:1521:XE"
		p:username="hr"
		p:password="happy"
		p:maxActive="20"
		p:maxIdle="10"
		p:maxWait="-1" 
	/>
*/
@Component("ds")
public class MyBasicDataSource extends BasicDataSource{
	public MyBasicDataSource()
	{
		setDriverClassName("oracle.jdbc.driver.OracleDriver");
		setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		setUsername("hr");
		setPassword("happy");
		setMaxActive(20);
		setMaxIdle(10);
		setMaxWait(-1);
	}
}

/* 
 * [클래스 메모리 할당해주는 Annotation]
 * @Component: 일반 클래스.
 * @Repository: DAO 등 데이터베이스 관련 클래스들.
 * @Service: BI(Business Integration) => DAO+DAO  ==>    
 * @Controller: Model: JSP 파일명 보내서 forward하거나 또는 sendRedirect 함 
 * @RestController: Restful: 필요한 데이터 전송(AJAX)★. JSON이나 XML 보낼 때 사용. ★
 * @ControllerAdvice: AOP 관련. 
 * 
 * ※ [참고]
 * Q. Service VS DAO의 차이점? (빈출 질문)★★★
 *  - Service: DAO 여러개를 묶어서 사용할  'Service'라고 부름. DAO가 여러개 합쳐진 것.
 *  - DAO: DAO 한 개 단독으로 쓸 .
 *  - ex) 게시판  - 테이블 마다마다 따로따로 한 다음에 뭉쳐놓음. 
 */
