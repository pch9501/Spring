package com.sist.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		//xml파싱
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		// ApplicationContext: 클래스 관리자. 
		// 메모리 생성과 소멸은 Spring이 알아서 해줌 
		
		Sawon sa=(Sawon)app.getBean("sa5"); // �̰� DL(dependency lookup/������ �˻�) / getBean�� �� ������ ��.
		System.out.println("sa: "+sa);
		System.out.println("사번: "+sa.getSabun());
		System.out.println("이름: "+sa.getName());
		System.out.println("주소: "+sa.getDept());
//		sa.display();
//		sa.setSabun(1);
//		sa.setName("ȫ�浿");
//		sa.setDept("���ߺ�");
		
//		Sawon sa1=(Sawon)app.getBean("sa");
//		System.out.println("sa1�� �ּ�: "+sa1);
//		sa1.display();
//		sa1.setSabun(2);
//		sa1.setName("��û��");
//		sa1.setDept("������");
//		
//		System.out.println(sa.getName());
//		System.out.println(sa1.getName());
	}

}
