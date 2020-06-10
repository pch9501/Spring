package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 *  Controller: Spring에서는 Model을 'Controller'라고 부름 ex) BoardController 
 *  VO
 *  DAO 
 *  Service
 *  Manager
 *  ==================================================================================================
 *  얘네를 전부 Model이라고 한다. 이 중 VO를 제외한 나머지 모두는 Spring에서 관리해준다. (객체 생성/소멸 등을 Spring에서 관리해줌) 
 */
@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	
	public List<MemberVO> memberAllData()
	{
		return mapper.memberAllData();
	}
	public MemberVO memberDetailData(int no)
	{
		return mapper.memberDetailData(no);
	}
	public void memberInsert(MemberVO vo)
	{
		mapper.memberInsert(vo);
	}
}

/*
 * <순서> (Spring의 객체 관리 생명주기) 
 * 		0. (메모리 할당 전) c: 또는 <constructor-arg>태그가 있는지 확인 
 * 		1. 메모리 할당 => 등록된 모든 클래스 => Map에 저장 
 * 		2. p: 또는 <property>태그가 있는지 확인  (DI 존재여부 확인)
 * 		3. 존재하면 => setXxx() 메소드에 주입  
 * 		4. 메소드 DI가 존재하는지 여부 확인 (init-method)
 * 		5. 존재하면 => 메소드 호출 
 * 		=======================================================
 * 		6. 프로그래머가 필요한 메소드 호출(사용자가 사용) 
 * 			==> 프로그램 종료, 사이트 이동 ==> Container가 닫힌다. ==> 모든 객체가 소멸된다. 
 * 		=======================================================
 * 		7. 메소드 존재여부 확인 (destroy-method) 
 * 		8. 객체 소멸 
 */
