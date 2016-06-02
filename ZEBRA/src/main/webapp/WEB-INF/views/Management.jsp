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


<META HTTP-EQUIVE="CONTENT-TYPE" CONTENT="TEXT/HTML; CHARSET=KSC5601">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>

</head>
<body>

	<!---------------------------------네비게이션 바 시작-------------------------  -->
	<jsp:include page="topNavigation.jsp"></jsp:include>
	<!---------------------------------네비게이션 바 끝-------------------------  -->





	<style>
blockquote {
	border-left: 2px solid #CC0000;
	padding: 0.5em 10px;
	color: #FFF;
}
</style>

<div class="container" align="center" style="padding-top: 80px">

		<img src="/ZEBRA/resources/image/ourproduct.png"
			style="width: 1000px; height: 300px;" >
	</div>


	<div class="container" style="padding-top: 10px">
		<h2 align="left">Requested Product Table</h2>
		<blockquote style="background: FF3300">
			<table class="table table-striped" id="testTable">
				<thead>
					<tr>
						<th>Index</th>
						<th>Applied Barcode</th>
						<th>ProductName</th>
						<th>Requester</th>
						<th>Approval</th>
					</tr>
				</thead>
				<tbody>
					<%
						int index = 1;
					%>

					<c:forEach var="applyList" items="${applyListModel}">
						<tr>
							<td><%=index%></td>
							<td><c:out value="${applyList.barcode}"></c:out></td>
							<td><c:out value="${applyList.productName}"></c:out></td>
							<td><c:out value="${applyList.id}"></c:out></td>
							<td><a
								href="/ZEBRA/Confirm?barcode=${applyList.barcode}&productName=${applyList.productName}&id=${applyList.id}">Confirm</a></td>
						</tr>
						<%
							index++;
						%>
					</c:forEach>


				</tbody>
			</table>


		</blockquote>



		<!-- Page Content -->
		<div class="container">




			<!-- /.row -->
			<hr>


			<hr>

			<!-- Footer -->
			<footer>
				<div class="row">
					<div class="col-lg-12">
						<p>Copyright &copy; Your Website 2016</p>
					</div>
				</div>
				<!-- /.row -->
			</footer>

		</div>

		<!-- /.container -->
</body>

</html>
