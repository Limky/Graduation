<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>



	�ڻ� �ִٸ��� ��ǰ ������


</br>
	<c:forEach var="ourMostReviewProducts" items="${ourMostReviewProducts}">

			<c:out value="${ourMostReviewProducts}"></c:out></br>

		</c:forEach>


</body>
</html>