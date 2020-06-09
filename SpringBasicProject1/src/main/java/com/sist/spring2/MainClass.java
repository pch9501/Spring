package com.sist.spring2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.*;

//Spring5.0 ==> XML 없이 Java로만 코딩 가능 
public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(Config.class);
		// 방법1. 형변환 
		// EmpDAO dao=(EmpDAO)ctx.getBean("empDAO");
		// 방법2. 형변환X
		EmpDAO dao=(EmpDAO)ctx.getBean("empDAO");
		List<EmpVO> list=dao.empAllData();
		for(EmpVO vo:list)
		{
//			System.out.println(vo.getEmpno()+" "
//					+vo.getEname()+" "
//					+vo.getJob()+" " 
//					+vo.getHiredate().toString()+" "
//					+vo.getSal());
			System.out.println(vo.getEname()+" "+vo.getJob()+" "+vo.getSal());
		}
	}

}
