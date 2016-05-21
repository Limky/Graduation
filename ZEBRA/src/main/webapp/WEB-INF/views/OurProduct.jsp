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







	<div class="container">
		<h2>전 상품</h2>
		<p>The .table-striped class adds zebra-stripes to a table:</p>
		<table class="table table-striped" id="testTable2">
			<thead>
				<tr>
					<th>ProductName</th>
					<th>Review</th>
					<th>StarPoint</th>
					<th>Scan</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="ourProducts" items="${ourProductsModel}">
					<tr>
						<td>&nbsp;<c:out value="${ourProducts.productName}"></c:out></td>
						<td>&nbsp;<c:out value="${ourProducts.totalReviewCount}"></c:out></td>
						<td>&nbsp;<c:out value="${ourProducts.starPoint}"></c:out></td>
						<td>&nbsp;<c:out value="${ourProducts.scanCount}"></c:out></td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
	</div>



	<h1>tableToExcel Demo</h1>
	<p>Exporting the W3C Example Table</p>

	<input type="button"
		onclick="tableToExcel('testTable2', 'W3C Example Table')"
		value="Export to Excel2">

	<table id="testTable"
		summary="Code page support in different versions of MS Windows."
		rules="groups" frame="hsides" border="2">
		<caption>CODE-PAGE SUPPORT IN MICROSOFT WINDOWS</caption>
		<colgroup align="center"></colgroup>
		<colgroup align="left"></colgroup>
		<colgroup span="2" align="center"></colgroup>
		<colgroup span="3" align="center"></colgroup>
		<thead valign="top">
			<tr>
				<th>Code-Page<br>ID
				</th>
				<th>Name</th>
				<th>ACP</th>
				<th>OEMCP</th>
				<th>Windows<br>NT 3.1
				</th>
				<th>Windows<br>NT 3.51
				</th>
				<th>Windows<br>95
				</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1200</td>
				<td style="background-color: #00f; color: #fff">Unicode (BMP of
					ISO/IEC-10646)</td>
				<td></td>
				<td></td>
				<td>X</td>
				<td>X</td>
				<td>*</td>
			</tr>
			<tr>
				<td>1250</td>
				<td style="font-weight: bold">Windows 3.1 Eastern European</td>
				<td>X</td>
				<td></td>
				<td>X</td>
				<td>X</td>
				<td>X</td>
			</tr>
			<tr>
				<td>1251</td>
				<td>Windows 3.1 Cyrillic</td>
				<td>X</td>
				<td></td>
				<td>X</td>
				<td>X</td>
				<td>X</td>
			</tr>
			<tr>
				<td>1252</td>
				<td>Windows 3.1 US (ANSI)</td>
				<td>X</td>
				<td></td>
				<td>X</td>
				<td>X</td>
				<td>X</td>
			</tr>
			<tr>
				<td>1253</td>
				<td>Windows 3.1 Greek</td>
				<td>X</td>
				<td></td>
				<td>X</td>
				<td>X</td>
				<td>X</td>
			</tr>
			<tr>
				<td>1254</td>
				<td>Windows 3.1 Turkish</td>
				<td>X</td>
				<td></td>
				<td>X</td>
				<td>X</td>
				<td>X</td>
			</tr>
			<tr>
				<td>1255</td>
				<td>Hebrew</td>
				<td>X</td>
				<td></td>
				<td></td>
				<td></td>
				<td>X</td>
			</tr>
			<tr>
				<td>1256</td>
				<td>Arabic</td>
				<td>X</td>
				<td></td>
				<td></td>
				<td></td>
				<td>X</td>
			</tr>
			<tr>
				<td>1257</td>
				<td>Baltic</td>
				<td>X</td>
				<td></td>
				<td></td>
				<td></td>
				<td>X</td>
			</tr>
			<tr>
				<td>1361</td>
				<td>Korean (Johab)</td>
				<td>X</td>
				<td></td>
				<td></td>
				<td>**</td>
				<td>X</td>
			</tr>
		</tbody>
		<tbody>
			<tr>
				<td>437</td>
				<td>MS-DOS United States</td>
				<td></td>
				<td>X</td>
				<td>X</td>
				<td>X</td>
				<td>X</td>
			</tr>
			<tr>
				<td>708</td>
				<td>Arabic (ASMO 708)</td>
				<td></td>
				<td>X</td>
				<td></td>
				<td></td>
				<td>X</td>
			</tr>
			<tr>
				<td>709</td>
				<td>Arabic (ASMO 449+, BCON V4)</td>
				<td></td>
				<td>X</td>
				<td></td>
				<td></td>
				<td>X</td>
			</tr>
			<tr>
				<td>710</td>
				<td>Arabic (Transparent Arabic)</td>
				<td></td>
				<td>X</td>
				<td></td>
				<td></td>
				<td>X</td>
			</tr>
			<tr>
				<td>720</td>
				<td>Arabic (Transparent ASMO)</td>
				<td></td>
				<td>X</td>
				<td></td>
				<td></td>
				<td>X</td>
			</tr>
		</tbody>
	</table>







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
