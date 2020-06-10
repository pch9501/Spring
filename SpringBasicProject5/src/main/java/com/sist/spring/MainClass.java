package com.sist.spring;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;

@Component
public class MainClass {
	// [방법2]
	@Autowired
	private EmpDAO dao;
	
	public static void main(String[] args) {
		// <Main에서 DAO 쓰는 법> 
		// [방법1]. 내가 직접 갖다쓰거나 - getBean
		/*
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml"); 
		EmpDAO dao=(EmpDAO)app.getBean("empDAO"); 
		List<EmpVO> list=dao.empAllData();
		
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEname()+" "+vo.getJob()+" "+vo.getSal());
		}*/
				
		// [방법2]. Spring한테 넘겨달라고 함
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		
		MainClass mc=(MainClass)app.getBean("mainClass");
		List<EmpVO> list=mc.dao.empAllData();
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEname()+" "+vo.getJob()+" "+vo.getSal());
		}
	}

}
