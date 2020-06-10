<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   margin: 0px auto;
   width:300px;
}
h1 {
  text-align: center;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#delBtn').click(function(){
		var no=$('#no').val();
		var pwd=$('#pwd').val();
		
		$.ajax({
			type:"POST",
			url:"delete_ok.do",
			data:{"no":no,"pwd":pwd},
			success:function(res)
			{
				if(res=="NOPWD")
				{
					alert("틀렸음");
					$('#pwd').val("");
					$('#pwd').focus();
				}
				else
				{
					location.href="list.do";
				}
			}
		})
		
		
	})
})
</script>
</head>
<body>
  <div class="container">
    <h1>삭제하기</h1>
    <div class="row">
	      <table class="table">
	        <tr>
	          <td width="30%" class="text-right">비밀번호</td>
	          <td width="70%">
	            <input type="password" name="pwd" size="15" id="pwd">
	            <input type="hidden" name="no" value="${no }" id="no">
	          </td>
	        </tr>
	        <tr>
	          <td colspan="2" class="text-center">
	            <input type="button" class="btn btn-sm btn-primary" value="삭제" id="delBtn">
	            <input type="button" class="btn btn-sm btn-danger" value="취소" onclick="javascript:history.back()">
	          </td>
	        </tr>
	      </table>
    </div>
  </div>
</body>
</html>