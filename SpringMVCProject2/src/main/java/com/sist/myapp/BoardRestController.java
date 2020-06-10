package com.sist.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;

//[Controller vs RestController 차이점] 
// - Controller: 파일명 
// - RestController: ★★★★스크립트 파일, JSON ==> 일반 문자열★★★★
// - ※참고) @ResponseBody의 업그레이드 버젼(?)이 @ResController임. 

@RestController
public class BoardRestController {
	
	@Autowired
	private BoardDAO dao;  // 수정/삭제 시에 DAO 사용되므로 바깥에다 갖다놓고 쓰자  
	
	@PostMapping("board/update_ok.do")
	public String board_update_ok(BoardVO vo)
	{
		String result="";
		
		boolean bCheck=dao.boardUpdate(vo); // dao연결
		
		if(bCheck==true) // 비밀번호가 맞다면
		{
			result="<script>location.href=\"detail.do?no="+vo.getNo()+"\"</script>";
		}
		else // 비밀번호가 틀렸다면
		{
			result="<script>alert(\"Password is Wrong!!\");history.back();</script>";
		}
		
		return result;
	}
	
	@PostMapping("board/delete_ok.do")
	public String board_delete_ok(int no,String pwd)
	{
		String result="";
		
		boolean bCheck=dao.boardDelete(no, pwd); // dao연결
		
		if(bCheck==true) // 비밀번호가 맞다면
		{
			result="<script>location.href=\"list.do\"</script>";
		}
		else // 비밀번호가 틀렸다면
		{
			result="<script>alert(\"Password is Wrong!!\");history.back();</script>";
		}
		
		return result;
	}
}
