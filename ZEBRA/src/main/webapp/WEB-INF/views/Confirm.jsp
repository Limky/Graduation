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

<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#imgInp").on('change', function() {
			readURL(this);
		});
	});

	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#blah').attr('src', e.target.result);
			}

			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
<link href='https://fonts.googleapis.com/css?family=Roboto:900'
	rel='stylesheet' type='text/css'>

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


	<%
		String barcode = request.getParameter("barcode");
		String productName = request.getParameter("productName");
		String id = request.getParameter("id");
	%>



	<div class="container" style="margin: 0 auto;" id="dont">

		<div class="outer">
			<div class="inner">
				<h1 style="font-family: 'Roboto', sans-serif; padding-top: 100px"
					align="center">Please check applied product</h1>
				<c:url var="addUrl" value="doConfirm" />
				<form action="${addUrl}" method="GET" id="form1" runat="server">
				
					<fieldset class="form-group">
						<label for="ex1">Requester</label> <input class="form-control"
							name="id" type="text" value="<%=id%>">
							</fieldset>
		

					<fieldset class="form-group">
						<label for="exampleInputEmail1">Product barcode</label> <input
							type="text" class="form-control" name="barcode"
							placeholder="Confirm barcode" value="<%=barcode%>"> <small
							class="text-muted">Please check whether the barcode
							matches</small>
					</fieldset>
					<fieldset class="form-group">
						<label for="exampleInputEmail1">ProductName</label> <input
							type="text" class="form-control" name="productName"
							placeholder="Confirm ProductName" value="<%=productName%>">
						<small class="text-muted">Please check whether the product
							name matches</small>
					</fieldset>
					
				 	<fieldset class="form-group">
						<label for="exampleInputEmail1">Category</label> <input
							type="text" class="form-control" name="category"
							placeholder="Confirm Category">
						<small class="text-muted">Please check  product category </small>
					</fieldset>
					
						<fieldset class="form-group">
						<label for="exampleInputEmail1">CompanyName</label> <input
							type="text" class="form-control" name="companyName"
							placeholder="Confirm CompanyName">
						<small class="text-muted">Please check Company name</small>
					</fieldset>
				
					
					<fieldset class="form-group">
						<label for="exampleTextarea">ProductImage URL</label>
						<textarea class="form-control" name="productUrl" rows="2"></textarea>
					</fieldset>

					<fieldset class="form-group">
						<label for="exampleTextarea">Product description</label>
						<textarea class="form-control" name="description" rows="3"></textarea>
					</fieldset>



					<button type="submit" class="btn btn-primary" name="allow"
						value="okay">Submit</button>
					<button type="submit" class="btn btn-danger" name="allow"
						value="reject">Reject</button>

				</form>

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
					<p>Copyright &copy; Your Website 2016</p>
				</div>
			</div>
			<!-- /.row -->
		</footer>

	</div>

	<!-- /.container -->

</body>

</html>
