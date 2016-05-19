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


<%-- 
    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" >

    <!-- Custom CSS -->
	<link href="${pageContext.request.contextPath}/resources/css/3-col-portfolio.css" rel="stylesheet" >
 --%>

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

	<div class="container">
		<div class="row">
			<div class="col-md-4" align="center">
				<h3 id="" style="font-family: fantasy;">Popularity</h3>
				<hr align="center" style="border: solid 3px #A91717; width: 30%;">
			</div>
			<div class="col-md-4" align="center">
				<h3 id="" style="font-family: fantasy; color: #7A7A7A">MostReview</h3>
				<hr align="center" style="border: solid 2px #F15F5F; width: 30%;">
			</div>
			<div class="col-md-4" align="center">
				<h3 id="" style="font-family: fantasy; color: #7A7A7A">MostScan</h3>
				<hr align="center" style="border: solid 2px #F15F5F; width: 30%;">
			</div>
		</div>
	</div>



	<!-- Page Content -->
	<div class="container">
		<h1 align="center" style="font-family: fantasy; padding: 30px">
			<small>Popularity</small>
		</h1>
		<!-- /.row -->

		<!-- Projects Row -->
		<div class="row">

			<c:forEach var="popularProduct" items="${popularProductModel}">

				<div class="col-md-4 portfolio-item">
					<a href="#"> <img class="img-responsive"
						src="http://placehold.it/700x400" alt=""></a>
					<h1>
						<small style="font-weight: 800"><c:out
								value="${popularProduct.productName}"></c:out></small>
					</h1>
					<p>
						<c:out value="${popularProduct.description}"></c:out>
					</p>
					<button type="button" class="btn btn-danger">Danger</button>
				</div>

			</c:forEach>


		</div>
		<!-- /.row -->
		<hr>


		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Your Website 2014</p>
				</div>
			</div>
			<!-- /.row -->
		</footer>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

</body>

</html>
