package com.sist.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// 컨테이너에 XML 파일 전송 ==> 파싱 ==> 등록된 클래스의 메모리 할당 
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
	
		/* [순서]
		 * 1. 클래스 메모리 할당
		 * 2. setXxx()에 값을 채운다
		 * 3. list-method가 존재하면 호출
		 * =============================
		 * (프로그래머가 필요한 메소드를 호출) 
		 * =============================
		 * 4. destroy-method를 호출
		 * 5. 메모리 해제
		 */
		
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		List<EmpVO> list=dao.empAllData();
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEname()+" "+vo.getSal()+" "+vo.getJob());
		}
	}

}
