package com.sist.dao;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

//[XML 안 쓰고 Java Annotation만으로 DB 연동하기] 
/*[app.xml](SpringBasicProject4) 에서의 아래의 코드를 Annotation을 써서 만들어보자
* <!-- 4. SqlSessionFactory 생성 -->
	<bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
		p:dataSource-ref="ds"
		p:configLocation="classpath:Config.xml"
	/>
*/
@Component("ssf")
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean{
	// 1. @Autowired 만 사용
		// 자동주입 - Spring에서 생성된 객체의 주소값을 자동으로 넣어줌 ==> @Qualifier("ds") 따로 적어주지 않아도 알아서 ds 찾아서 넣어줌
		// @Autowired  
		
		// 2. @Autowired + @Qualifier("ds")
		// - 뭘 찾아오는지 명확하게 한정해줌 
		// @Autowired  
		// @Qualifier("ds")
		
		// 3. @Resource(name="ds")
		// - 얘는 @Autowired + @Qualifier("ds") 와 같다 
		// @Resource(name="ds")
	@Autowired
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}

	public MySqlSessionFactoryBean()
	{
		try {
			org.springframework.core.io.Resource res=
					new ClassPathResource("Config.xml");
			// Q. Resource가 저렇게 긴 이유?
			// A. 이미 사용중인 Annotation @Resource와 이름이 같으므로, 혼동되지 않기 위해서 Resource앞에 패키지명을 붙인다.
			setConfigLocation(res);
			
		} catch (Exception e) {
			
		}
	}
}

/* @Autowired  // 자동주입: 클래스의 메모리 주소만 주입 가능. ==> 클래스 위에서 사용한다.
 * @ => TYPE 
 * public class A
 * {
 * 		@
 * 		MyDAO dao; ==> FIELD
 * 
 * 		@
 * 		public A(MyDAO dao){}  ==> CONSTRUCTOR
 * 
 * 		@
 * 		public void setMyDAO(MyDAO dao){}  ==> PARAMETER
 * 
 * 		@
 * 		public void display(MyDAO dao){}
 * 
 * }
 */

/* 
 * => 클래스 메모리 할당 (클래스 관리자)  
 * => 멤버 변수에 값을 주입
 * => 클래스의 메모리 해제 
 * => 반복적인 코딩을 제거 => 소스 간결화
 * 
 */
