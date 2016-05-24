<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">


<html>

<head>
<meta charset="utf-8">
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Popular</title>

<spring:url value="/resources/core/css/bootstrap.min.css" var="coreCss" />
<spring:url value="/resources/core/css/3-col-portfolio.css"
	var="bootstrapCss" />
<spring:url value="/resources/core/css/heroic-features.css"
	var="heroicfeatures" />

<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
<link href="${heroicfeatures}" rel="stylesheet" />
<!-- 
<script src="js/jquery.js"></script>

	Bootstrap Core JavaScript
	<script src="js/bootstrap.min.js"></script>

 -->
<style>
#titles {
	color: black;
}
</style>

</head>
<body>

	<!---------------------------------네비게이션 바 시작-------------------------  -->
	<jsp:include page="topNavigation.jsp" flush="false"></jsp:include>
	<!---------------------------------네비게이션 바 끝-------------------------  -->

			<c:out value="${productInfo}"></c:out>
	


	<c:forEach var="reviewList" items="${reviewList}">
		<p>
			<c:out value="${reviewList}">
			</c:out>
		</p>

	</c:forEach>



</body>

</html>
