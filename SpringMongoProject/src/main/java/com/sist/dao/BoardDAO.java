package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class BoardDAO {
	
	@Autowired
	private MongoTemplate mt;
	
	public List<BoardVO> boardListData(int page)
	{
		List<BoardVO> list=new ArrayList<BoardVO>();
		// 오라클 연동시 String sql="SELECT~" 과 같은 역할수행
		// 형태는 find({no:1}) << json형식
		Query query=new Query(); 
		// page나누기
		int rowSize=10;
		int skip=(rowSize*page)-rowSize;
		query.skip(skip).limit(rowSize);
		// 정렬하기 / 3.0.0 버전에서는 구동되지않아 2.0.0버전으로 변경(pom.xml에서)
		query.with(new Sort(Sort.Direction.DESC,"no"));
		// == ORDER BY no DESC / MyBatis의 selectList()와 같은 수행
		list=mt.find(query, BoardVO.class,"board"); // List<BoardVO>
		
		return list;
	}
	public int boardTotalPage()
	{
		int total=0;
		
		Query query=new Query(); // 조건(where절)이 없는 경우에는 다음과같이 괄호 안이 공백이다.
		// == SELECT COUNT(*) FROM board
		int count=(int)mt.count(query, "board");
		total=(int)(Math.ceil(count/10.0));
		
		return total;
	}
	public void boardInsert(BoardVO vo)
	{
		Query query=new Query();
		// no로 정렬해라!, ASC하고싶으면 DESC를 바꾸면된다 / == ORDER BY no DESC
		query.with(new Sort(Sort.Direction.DESC,"no"));
		// 맨 위의 컬럼들을 가져온다.(no가 가장 큰 녀석)
		BoardVO rvo=mt.findOne(query, BoardVO.class,"board");
		// desc로 가장 큰 no를 가져온 후, +1을 해준다.
		vo.setNo(rvo.getNo()+1);
		// 오늘 날짜를 가져온다 (=SYSDATE)
		vo.setRegdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		vo.setHit(0);
		
		
		mt.insert(vo, "board");
	}
	
	
}
