package com.sist.temp;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component // 메모리할당
public class MainClass {
//  ↓ 자동주입. 주소값을 자동으로 찾아서 넘겨주게 해줌 ==> getBean할 필요X. (SpringBasicProject4의 MainClass 참고: getBean으로 직접 찾아서 가져옴) 
//	@Autowired
//	@Qualifier("boardDAO") 
	@Resource(name="noticeDAO") 
	private MyDAO dao;
	
	// @Component없으면 @Autowired 쓸 수 X.
	// @Component가 있어야 Spring에 등록이 되기 때문. 
	// private인데 제어가 가능 ==> OOP에서의 캡슐화 개념에 위배되는거 아님?
		
	// @Qualifier("boardDAO") 해주지 않으면 에러남 
	// - 왜냐면, @Autowired가 자동주입 하려고 할 때, boardDAO,noticeDAO 둘 중 뭘 써야 할지 Spring이 알 수 없어서 에러남. 
	// - boardDAO,noticeDAO 둘 다 implements MyDAO 한거니까. 
		
	// 혹은, @Autowired + @Qualifier("boardDAO") 대신에 @Resource(name="boardDAO") 이거 써줘도 된다. 
	// @Autowired + @Qualifier("boardDAO") =  @Resource(name="boardDAO")
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		mc.dao.select();
	}

}
