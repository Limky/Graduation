<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">


<html>

<head>
<meta charset="utf-8">
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<title>Bootstrap Example</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<spring:url value="/resources/core/js/tableToExcel.js"
	var="tableToExceljs" />
<script src="${tableToExceljs}"></script>

<META HTTP-EQUIVE="CONTENT-TYPE" CONTENT="TEXT/HTML; CHARSET=KSC5601">

</head>
<body>

	<!---------------------------------네비게이션 바 시작-------------------------  -->
	<jsp:include page="topNavigation.jsp"></jsp:include>
	<!---------------------------------네비게이션 바 끝-------------------------  -->

	<!---------------------------------네비게이션 바 시작-------------------------  -->
	<jsp:include page="Search.jsp" flush="false"></jsp:include>
	<!---------------------------------네비게이션 바 끝-------------------------  -->





	<%
		request.setCharacterEncoding("UTF-8");
		String currentCategory = (String) request.getAttribute("currentCategory");
	%>
	<%=currentCategory%>
	<h1 style="padding: 50px"></h1>



	<div class="container" style="padding: 15px">
		<div class="row">
			<div class="col-xs-6 col-sm-3" align="center">
				<h4 id="" style="font-family: fantasy;">
					<a href="/ZEBRA/OurProduct?filter=All">All</a>
				</h4>
				<hr align="center" style="border: solid 3px #A91717; width: 30%;">
			</div>
			<div class="col-xs-6 col-sm-3" align="center">
				<h4 id="" style="font-family: fantasy;">
					<a href="/ZEBRA/OurProduct?filter=Popularity">Popularity</a>
				</h4>
				<hr align="center" style="border: solid 3px #A91717; width: 30%;">
			</div>
			<div class="col-xs-6 col-sm-3" align="center">
				<h4 id="" style="font-family: fantasy; color: #7A7A7A">
					<a href="/ZEBRA/OurProduct?filter=MostReview">MostReview</a>
				</h4>
				<hr align="center" style="border: solid 2px #F15F5F; width: 30%;">
			</div>
			<div class="col-xs-6 col-sm-3" align="center">
				<h4 id="" style="font-family: fantasy; color: #7A7A7A">
					<a href="/ZEBRA/OurProduct?filter=MostScan">MostScan</a>
				</h4>
				<hr align="center" style="border: solid 2px #F15F5F; width: 30%;">
			</div>
		</div>
	</div>


	<style>
blockquote {
	border-left: 2px solid #CC0000;
	padding: 0.5em 10px;
	color: #FFF;
}
</style>




	<div class="container">
		<h2 align="left">Consumer indicators</h2>
		<blockquote style="background: FF3300">
			<table class="table table-striped" id="testTable">
				<thead>
					<tr>
						<th>ProductName</th>
						<th>ReviewCount</th>
						<th>StarPoint</th>
						<th>ScanCount</th>
						<th>Reviews</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="ourProducts" items="${ourProductsModel}">
						<tr>
							<td>&nbsp;<c:out value="${ourProducts.productName}"></c:out></td>
							<td>&nbsp;<c:out value="${ourProducts.totalReviewCount}"></c:out></td>
							<td>&nbsp;<c:out value="${ourProducts.starPoint}"></c:out></td>
							<td>&nbsp;<c:out value="${ourProducts.scanCount}"></c:out></td>
							<td>&nbsp;<a>ReviewList</a></td>
						</tr>
					</c:forEach>


				</tbody>
			</table>


		</blockquote>

		<h4 align="left" style="border: 4px">Download Table To Excel</h4>
		<input type="button"
			onclick="tableToExcel('testTable', 'W3C Example Table')"
			value="Export to Excel" type="button" class="btn btn-info">



		<div class="row">
			<div class="col-md-6">
				<table class="table table-striped" id="testTable">
					<thead>
						<tr>
							<th>ProductName</th>
							<th>ReviewCount</th>
							<th>StarPoint</th>
							<th>ScanCount</th>
							<th>Reviews</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="ourProducts" items="${ourProductsModel}">
							<tr>
								<td>&nbsp;<c:out value="${ourProducts.productName}"></c:out></td>
								<td>&nbsp;<c:out value="${ourProducts.totalReviewCount}"></c:out></td>
								<td>&nbsp;<c:out value="${ourProducts.starPoint}"></c:out></td>
								<td>&nbsp;<c:out value="${ourProducts.scanCount}"></c:out></td>
								<td>&nbsp;<a>ReviewList</a></td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
			<div class="col-md-6">
				<table class="table table-striped" id="testTable">
					<thead>
						<tr>
							<th>ProductName</th>
							<th>ReviewCount</th>
							<th>StarPoint</th>
							<th>ScanCount</th>
							<th>Reviews</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="ourProducts" items="${ourProductsModel}">
							<tr>
								<td>&nbsp;<c:out value="${ourProducts.productName}"></c:out></td>
								<td>&nbsp;<c:out value="${ourProducts.totalReviewCount}"></c:out></td>
								<td>&nbsp;<c:out value="${ourProducts.starPoint}"></c:out></td>
								<td>&nbsp;<c:out value="${ourProducts.scanCount}"></c:out></td>
								<td>&nbsp;<a>ReviewList</a></td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
		</div>

	</div>



	<!-- Page Content -->
	<div class="container">




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

</body>

</html>
