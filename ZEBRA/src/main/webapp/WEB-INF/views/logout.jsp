<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
// 		세션 정보 삭제 2가지 방법
// 		1. removeAttribute() : 특정 키에 대한 정보를 삭제
// 		2. invalidate() : 현재 세션 정보를 제거 후 새로운 세션 열기
		
		String nowID = (String)session.getAttribute("logOk");

		session.removeAttribute("logOk");
		session.removeAttribute("sessionLoginMember");
		
		session.invalidate();	
// 		=> 로그 아웃의 경우, 보통 특정 클라이언트에 대한 
// 			웹 서비스의 종료를 의미하므로,
// 			세션 객체를 새로 제공하는 invalidate()가 이용된다.

		String msg = null;
		msg = nowID + "님 안녕히 가세요";
	%>
	
	<script type="text/javascript">
		alert("<%= msg %>");
		location.href="/ZEBRA";
	</script>



</body>
</html>