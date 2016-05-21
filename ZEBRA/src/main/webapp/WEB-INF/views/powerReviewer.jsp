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




	<h1>여기는 파워 리뷰어 페이지 입니다.</h1>


	<%-- 
	<c:forEach var="firstGrade" items="${firstGrade}">
		<p>
			<c:out value="${firstGrade}"></c:out>
			</br>
		</p>
	</c:forEach>

	<c:forEach var="secondGrade" items="${secondGrade}">
		<p>
			<c:out value="${secondGrade}"></c:out>
			</br>
		</p>
	</c:forEach>

	<c:forEach var="thirdGrade" items="${thirdGrade}">
		<p>
			<c:out value="${thirdGrade}"></c:out>
			</br>
		</p>
	</c:forEach>
 --%>


	<!-- Page Content -->
	<div class="container">

		<!-- Introduction Row -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					About Us <small>It's Nice to Meet You!</small>
				</h1>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
					Sint, explicabo dolores ipsam aliquam inventore corrupti eveniet
					quisquam quod totam laudantium repudiandae obcaecati ea consectetur
					debitis velit facere nisi expedita vel?</p>
			</div>
		</div>

		<!-- Team Members Row -->
		<div class="row">
			<div class="col-lg-12">
				<h2 class="page-header">Our Team</h2>
			</div>

			<c:forEach var="firstGrade" items="${firstGrade}">

				<div class="col-lg-4 col-sm-6 text-center">
					<img class="img-circle img-responsive img-center"
						src="http://placehold.it/200x200" alt="">
					<h3>
						<c:out value="${firstGrade.name}"></c:out>
						<small><c:out value="${firstGrade.totalReviewCount}"></c:out></small>
					</h3>
					<p>
						<c:out value="${firstGrade.reviewCount}"></c:out>
					</p>
				</div>

			</c:forEach>


			<div class="col-lg-12">
				<h2 class="page-header">Our Team</h2>
			</div>
			<c:forEach var="thirdGrade" items="${thirdGrade}">

				<div class="col-lg-4 col-sm-6 text-center">
					<img class="img-circle img-responsive img-center"
						src="http://placehold.it/200x200" alt="">
					<h3>
						<c:out value="${thirdGrade.name}"></c:out>
						<small><c:out value="${thirdGrade.totalReviewCount}"></c:out></small>
					</h3>
					<p>
						<c:out value="${thirdGrade.reviewCount}"></c:out>
					</p>
				</div>

			</c:forEach>



			<div class="col-lg-12">
				<h2 class="page-header">Our Team</h2>
			</div>

			<c:forEach var="secondGrade" items="${secondGrade}">

				<div class="col-lg-4 col-sm-6 text-center">
					<img class="img-circle img-responsive img-center"
						src="http://placehold.it/200x200" alt="">
					<h3>
						<c:out value="${secondGrade.name}"></c:out>
						<small><c:out value="${secondGrade.totalReviewCount}"></c:out></small>
					</h3>
					<p>
						<c:out value="${secondGrade.reviewCount}"></c:out>
					</p>
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