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


	자사 최다스캔 상품 페이지


</br>
	<c:forEach var="ourMostScanProducts" items="${ourMostScanProducts}">

			<c:out value="${ourMostScanProducts}"></c:out></br>

		</c:forEach>

</body>
</html>