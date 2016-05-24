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


	<!---------------------------------네비게이션 바 시작-------------------------  -->
	<jsp:include page="Search.jsp" flush="false"></jsp:include>
	<!---------------------------------네비게이션 바 끝-------------------------  -->




	
	<!---------------------------------카테고리 바 시작-------------------------  -->
	<jsp:include page="Category.jsp"></jsp:include>
	<!---------------------------------카테고리 바 끝-------------------------  -->
<%


	request.setCharacterEncoding("UTF-8");
	String currentCategory= (String)session.getAttribute("currentCategory");


%>
<%=currentCategory %>

	<div class="container" style="padding:15px">
		<div class="row">
			<div class="col-md-4" align="center">
				<h4 id="" style="font-family: fantasy;"><a href="/ZEBRA/PopularProduct?category=<%=currentCategory%>">Popularity</a></h4>
				<hr align="center" style="border: solid 3px #A91717; width: 30%;">
			</div>
			<div class="col-md-4" align="center">
				<h4 id="" style="font-family: fantasy; color: #7A7A7A"><a href="/ZEBRA/MostReview?category=<%=currentCategory%>">MostReview</a></h4>
				<hr align="center" style="border: solid 2px #F15F5F; width: 30%;">
			</div>
			<div class="col-md-4" align="center">
				<h4 id="" style="font-family: fantasy; color: #7A7A7A"><a href="/ZEBRA/MostScan?category=<%=currentCategory%>">MostScan</a></h4>
				<hr align="center" style="border: solid 2px #F15F5F; width: 30%;">
			</div>
		</div>
	</div>



	<!-- Page Content -->
	<div class="container">
		<h3 align="center" style="font-family: fantasy; padding: 30px">
			<small>Popularity</small>
		</h3>
		<!-- /.row -->

		<!-- Projects Row -->
		<div class="row">

			<c:forEach var="popularProduct" items="${popularProductModel}">
				

				<div class="col-md-4 portfolio-item">
					<a href="#"> <img class="img-responsive" src="${popularProduct.productUrl}" alt=""  style="width: 700px; height:400px;"></a>
					<h1>
						<small style="font-weight: 800"><c:out
								value="${popularProduct.productName}"></c:out></small>
					</h1>
					<div>
					<p>
						<c:out value="${popularProduct.description}"></c:out><br>
					</p>
					
		<%-- 			<c:url var="addUrl" value="review" /> --%>
				<form action="review" method="GET">
					<button type="submit" class="btn btn-danger" name="barcode" value="${popularProduct.barcode}">Review</button>
					</form>
					</div>
					
				</div>

			</c:forEach>


		</div>
		<!-- /.row -->
		<hr>


		<hr>

	

	</div>
	
	

</body>

</html>
