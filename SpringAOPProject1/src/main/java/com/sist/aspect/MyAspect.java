package com.sist.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // @Aspect는 '공통'이라는 뜻
@Component // Aspect와 별개로 메모리할당을 해주어야한다.
public class MyAspect {
	
	// [@Before]=메소드 호출 전
	@Before("execution(* com.sist.dao.EmpDAO.emp_*(..))")
	public void getConnection()
	{
		System.out.println("getConnection: 오라클 연결");
	}
	
	// [@After]=메소드 호출 후
	@After("execution(* com.sist.dao.EmpDAO.emp_*(..))")
	public void disConnection()
	{
		System.out.println("disConnection: 오라클 연결 해제");
	}
	
	// [@AfterReturning]= 정상수행이 된 경우 (return후)
	@AfterReturning(value="execution(* com.sist.dao.EmpDAO.emp_*(..))",returning="ret") // returning="변수명" <= 리턴값
	public void returnValue(Object ret)
	{
		if(ret!=null)
			System.out.println("return value= "+ret);
	}
	
	// [@AfterThrowing]= 메소드 수행과정에서 오류가 발생한 경우 
	@AfterThrowing(value="execution(* com.sist.dao.EmpDAO.emp_*(..))",throwing="ex") // throwing="변수명" <= 오류났을 때 
	public void exceptionValue(Throwable ex)
	{
		System.out.println("exception value="+ex.getMessage());
	}
	
	// [@Around]= 로그파일 만들 때 등에 많이 사용
	@Around("execution(* com.sist.dao.EmpDAO.display())")
	public Object display(ProceedingJoinPoint jp) throws Throwable
	{
		System.out.println(jp.getSignature().getName());
		long start=System.currentTimeMillis();
		// setAutoCommit(false)
		Object obj=jp.proceed(); // display
		// conn.commit()
		long end=System.currentTimeMillis();
		System.out.println("수행시간: "+(end-start));
		return obj;
	}
	
	/* [AOP] JoinPoint, PointCut
	 * EmpDAO를 보면, 각 메소드에서, sysout 전에는 getConnection을, sysout 후에는 disConnection을 호출함
	 *  ==> getConnection(): @Before,  disConnection: @After
	 *  ==> 어느 메소드에서 전/후에 얘네 호출하는지 명시해줘야함 
	 *      @JoinPoint("execution(리턴형 패키지명.메소드명(매개변수))")   
	 *  	ex) 'emp_로 시작하는 메소드에서는 얘네 호출해줘라.'는걸 명시해줘야함.
	 *  	     @Before("execution(* com.sist.dao.EmpDAO.emp_*(..))")
	 *                              ==						    == 매개변수가 없거나/있거나(단수,복수) 다 ok 
	 *                              리턴형 ===> 어떤 리턴형이든 상관없다.   
	 */
	
	// @Before("execution(String com.sist.dao.EmpDAO.emp_*(..))")
	// =======  ===============================================
	// JoinPoint        PointCut
}
