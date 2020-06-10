package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // dao는 @repository, model은 @controller, 그 외의 클래스는 @component
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	
	// 1. 글 목록 가져오그
	public List<BoardVO> boardListData(Map map)
	{
		return mapper.boardListData(map);
	}
	// 2. 총 페이지 가져오기
	public int boardTotalPage()
	{
		return mapper.boardTotalPage();
	}
	// 글 작성시
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
	// 상세보기
	public BoardVO boardDetailData(int no)
	{
		// 조회수 증가
		mapper.hitIncrement(no);
		
		return mapper.boardDetailData(no);
	}
	// 1.수정하기 화면에 이전 입력되어있던 정보(상세보기페이지 정보들) 넣기
	public BoardVO boardUpdateData(int no)
	{
		return mapper.boardDetailData(no);
	}
	// 2. 비밀번호 체크후, 비밀번호 맞으면 업데이트
	public boolean boardUpdate(BoardVO vo)
	{
		boolean bCheck=false;
		String db_pwd=mapper.boardGetPwd(vo.getNo());
		
		if(db_pwd.equals(vo.getPwd()))
		{
			bCheck=true;
			mapper.boardUpdate(vo);
		}
		else
		{
			bCheck=false;
		}
		return bCheck;
	}
	
	public boolean boardDelete(int no,String pwd)
	{
		boolean bCheck=false;
		String db_pwd=mapper.boardGetPwd(no);
		
		if(db_pwd.equals(pwd))
		{
			bCheck=true;
			mapper.boardDelete(no);
		}
		else
		{
			bCheck=false;
		}
		return bCheck;
	}
}
