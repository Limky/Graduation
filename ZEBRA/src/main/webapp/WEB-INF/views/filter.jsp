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
<%


	request.setCharacterEncoding("UTF-8");
	String currentCategory= (String)request.getAttribute("currentCategory");


%>
<%=currentCategory %>

	<div class="container" style="padding:15px">
		<div class="row">
			<div class="col-md-4" align="center">
				<h4 id="" style="font-family: fantasy;"><a href="/ZEBRA/PopularProduct?category=<%=currentCategory%>">Popularity</a></h4>
				<hr align="center" style="border: solid 3px #A91717; width: 30%;">
			</div>
			<div class="col-md-4" align="center">
				<h4 id="" style="font-family: fantasy; color: #7A7A7A"><a href="/ZEBRA/AllMostReview?category=<%=currentCategory%>">MostReview</a></h4>
				<hr align="center" style="border: solid 2px #F15F5F; width: 30%;">
			</div>
			<div class="col-md-4" align="center">
				<h4 id="" style="font-family: fantasy; color: #7A7A7A"><a href="/ZEBRA/AllMostScan?=<%=currentCategory%>">MostScan</a></h4>
				<hr align="center" style="border: solid 2px #F15F5F; width: 30%;">
			</div>
		</div>
	</div>





</body>

</html>
