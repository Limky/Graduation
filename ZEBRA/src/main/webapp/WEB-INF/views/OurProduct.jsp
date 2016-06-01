<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%@page import="java.util.*"%>

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

<title>Admin Home Page</title>
<!-- Bootstrap -->
<link href="resources/Graph/bootstrap/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<link
	href="resources/Graph/bootstrap/bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet" media="screen">
<link
	href="resources/Graph/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.css"
	rel="stylesheet" media="screen">
<link href="resources/Graph/bootstrap/assets/styles.css"
	rel="stylesheet" media="screen">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
<script
	src="resources/Graph/bootstrap/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
</head>
<body style="background-color: white;">
	<!---------------------------------네비게이션 바 시작-------------------------  -->
	<jsp:include page="topNavigation.jsp"></jsp:include>
	<!---------------------------------네비게이션 바 끝-------------------------  -->

	<%
		List<Integer> listCount = (List<Integer>) request.getAttribute("listCount");
	%>



	<div class="container" align="center">

		<img src="https://image.jimcdn.com/app/cms/image/transf/dimension=980x10000:format=jpg/path/s0785f1a12dd449fe/image/id39faad715eff34d/version/1457349086/how-to-create-a-website.jpg"
			style="width: 1130px; height: 450px">
	</div>


	<div class="container" style="padding:; padding-top:">
		<div class="row-fluid" style="padding: ; padding-top: ">
			<!-- block -->
			<div class="block">
				<div class="navbar navbar-inner block-header">
					<div class="muted pull-left">
						<h4>Persent of Scanning Contrast review</h4>
					</div>
				</div>
				<div class="block-content collapse in" style="padding-bottom: 20px">
					<div class="span3">
						<h4 style="padding-left: 20px">Scan Count</h4>
						<br />
						<h2 style="padding-left: 50px"><%=listCount.get(1)%></h2>
					</div>
					<div class="span3">
						<h4>Review Count</h4>
						<br />
						<h2 style="padding-left: 30px"><%=listCount.get(0)%></h2>
					</div>
					<div class="span3">
						<h4>Scanning Contrast review</h4>
						<br />
						<h2 style="padding-left: 70px"><%=listCount.get(2)%>%
						</h2>
					</div>
					<div class="span3">
						<div class="chart" data-percent=<%=listCount.get(2)%>><%=listCount.get(2)%>%
						</div>
						<div class="chart-bottom-heading">
							<span class="label label-info">Persent</span>
						</div>
					</div>



				</div>
				<div>
					</br>
				</div>
			</div>
			<!-- /block -->
		</div>

	</div>


	<!--/.fluid-container-->
	<script src="resources/Graph/bootstrap/vendors/jquery-1.9.1.min.js"></script>
	<script src="resources/Graph/bootstrap/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="resources/Graph/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.js"></script>
	<script src="resources/Graph/bootstrap/assets/scripts.js"></script>
	<script>
		$(function() {
			// Easy pie charts
			$('.chart').easyPieChart({
				animate : 1000
			});
		});
	</script>
	<div class="container" style="padding: 15px; padding-top: 20px">

		<div class="row">
			<div class="col-xs-6 col-sm-3" align="center">
				<h4 id="" style="font-family: fantasy; color: #7A7A7A">
					<a href="/ZEBRA/OurProduct?filter=All">All</a>
				</h4>
				<hr align="center" style="border: solid 2px #F15F5F; width: 30%;">
			</div>
			<div class="col-xs-6 col-sm-3" align="center">
				<h4 id="" style="font-family: fantasy; color: #7A7A7A">
					<a href="/ZEBRA/OurProduct?filter=Popularity">Popularity</a>
				</h4>
				<hr align="center" style="border: solid 2px #F15F5F; width: 30%;">
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
							<td>&nbsp;<a
								href="/ZEBRA/review?barcode=${ourProducts.barcode}">Review
									Detail</a></td>
						</tr>
					</c:forEach>


				</tbody>
			</table>


		</blockquote>

		<h4 align="left" style="border: 4px">Download Table To Excel</h4>
		<input type="button"
			onclick="tableToExcel('testTable', 'W3C Example Table')"
			value="Export to Excel" type="button" class="btn btn-info">







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
