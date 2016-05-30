<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<title>Round About - Start Bootstrap Template</title>

<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrap" />
<spring:url value="/resources/core/css/round-about.css" var="round" />
<spring:url value="/resources/core/js/jquery.js" var="jquery" />
<spring:url value="/resources/core/js/bootstrap.min.js"
	var="bootstrapjs" />

<link href="${bootstrap}" rel="stylesheet" />
<link href="${round}" rel="stylesheet" />

<script src="${jquery}"></script>
<script src="${bootstrapjs}"></script>


</head>
<body>

	<!---------------------------------네비게이션 바 시작-------------------------  -->
	<jsp:include page="topNavigation.jsp" flush="false"></jsp:include>
	<!---------------------------------네비게이션 바 끝-------------------------  -->




<div class="jumbotron">
  <h1 align="center">Bootstrap Tutorial</h1>      
  <p align="center">Bootstrap is the most popular HTML, CSS, and JS framework for developing responsive, mobile-first projects on the web.</p>
</div>

<style>
#reviewerDiv {
	-webkit-box-shadow: 2px 4px 5px 0px rgba(0, 0, 0, 0.29);
	-moz-box-shadow: 2px 4px 5px 0px rgba(0, 0, 0, 0.29);
	box-shadow: 2px 4px 5px 0px rgba(0, 0, 0, 0.29);
}
</style>


	<!-- Page Content -->
	<div class="container" style="padding-top: 20px">



		<!-- Team Members Row -->
		<div class="row">
			<div class="col-lg-12" >
				<h2 class="page-header">Gold Level <img src="/ZEBRA/resources/image/Gold.PNG" alt="" width="50px" height="50px"></h2>
			</div>

			<c:forEach var="firstGrade" items="${firstGrade}">

				<div class="col-lg-4 col-sm-6 text-center" >
					<img class="img-circle img-responsive img-center"
						src="http://placehold.it/200x200" alt="">
					<h3>
						<c:out value="${firstGrade.name}"></c:out>
						<small><c:out value="${firstGrade.totalReviewCount}"></c:out></small>
					</h3>
					
				</div>

			</c:forEach>


			<div class="col-lg-12">
				<h2 class="page-header">Silver Level <img src="/ZEBRA/resources/image/Silver.PNG" alt="" width="50px" height="50px"></h2>
			</div>
			<c:forEach var="thirdGrade" items="${thirdGrade}">

				<div class="col-lg-4 col-sm-6 text-center">
					<img class="img-circle img-responsive img-center"
						src="http://placehold.it/200x200" alt="">
					<h3>
						<c:out value="${thirdGrade.name}"></c:out>
						<small><c:out value="${thirdGrade.totalReviewCount}"></c:out></small>
					</h3>
					
				</div>

			</c:forEach>



			<div class="col-lg-12">
				<h2 class="page-header">Bronze Level <img src="/ZEBRA/resources/image/Bronze.PNG" alt="" width="50px" height="50px"></h2>
			</div>

			<c:forEach var="secondGrade" items="${secondGrade}">

				<div class="col-lg-4 col-sm-6 text-center">
					<img class="img-circle img-responsive img-center"
						src="http://placehold.it/200x200" alt="">
					<h3>
						<c:out value="${secondGrade.name}"></c:out>
						<small><c:out value="${secondGrade.totalReviewCount}"></c:out></small>
					</h3>
			
				</div>

			</c:forEach>
		</div>












		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Your Website 2014</p>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</footer>

	</div>
	<!-- /.container -->




</body>
</html>