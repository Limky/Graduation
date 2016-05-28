<%@page import="java.util.*"%>
<%@page import="kr.ac.zebra.dto.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">


<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Item - Start Bootstrap Template</title>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapmincss" />
<spring:url value="/resources/core/css/shop-item.css"
	var="cssshopitemcss" />
<spring:url value="/resources/core/css/blog-home" var="bloghome" />
<link href="${bloghome}" rel="stylesheet" />
<link href="${bootstrapmincss}" rel="stylesheet" />
<link href="${cssshopitemcss}" rel="stylesheet" />

<spring:url value="/resources/core/js/jquery.js" var="jsjqueryjs" />
<script src="${jsjqueryjs}"></script>

<spring:url value="/resources/core/js/bootstrap.min.js"
	var="jsbootstrapminjs" />
<script src="${jsbootstrapminjs}"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>




<spring:url value="/resources/core/css/heroic-features"
	var="heroicfeatures" />
<link href="${heroicfeatures}" rel="stylesheet" />



</head>

<body style="background-color:">



	<!---------------------------------네비게이션 바 시작-------------------------  -->
	<jsp:include page="topNavigation.jsp" flush="false"></jsp:include>
	<!---------------------------------네비게이션 바 끝-------------------------  -->
	<%
		double starPoint = (double) request.getAttribute("starPoint");
		String str = "";
		if (starPoint > 4.5)
			str = "star5";
		else if (starPoint > 4)
			str = "star4";
		else if (starPoint > 3.5)
			str = "star4";
		else if (starPoint > 3)
			str = "star3";
		else if (starPoint > 2.5)
			str = "star3";
		else if (starPoint > 2)
			str = "star2";
		
		


		
		
	%>






	<!-- /.container -->


	<div class="container" style="padding-top: 80px">

		<div class="row">

			<!-- Blog Entries Column -->
			<div class="col-md-8">

				<h1 class="page-header">Product reviews</h1>

				<div class="row">

					<div class="col-md-6" style="">
						<img class="img-responsive" src="${productInfo.productUrl}" alt=""
							align="middle" style="width: 300px; height: 350px;">
					</div>
					<div class="col-md-6">
						<img alt="" src="/ZEBRA/resources/image/<%=str%>.png"
							width="200px" height="40px">스캔:
						<c:out value="${productInfo.scanCount}"></c:out>
						리뷰:
						<c:out value="${productInfo.totalReviewCount}"></c:out>

						<h2 style="font-weight: bolder;">
							<c:out value="${productInfo.productName}"></c:out>
						</h2>
						<p>
							<c:out value="${productInfo.description}"></c:out>
						</p>

					</div>
					<div class="col-md-6" align="left">
						<div class="col-md-3" align="left">
							<img alt="" src="/ZEBRA/resources/image/star5.png" width="80px"
								height="20px" align="left">
						</div>
						<div class="col-md-9">
							<div class="progress">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"
									style="width:${star4Rating}">
									<span class="sr-only"> 80% Complete (danger) </span>
									<p align="center">${star4Rating}%</p>
								</div>
							</div>
						</div>
						<div class="col-md-3">
							<img alt="" src="/ZEBRA/resources/image/star4.png" width="80px"
								height="20px">
						</div>
						<div class="col-md-9">
							<div class="progress">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
									style="width: ${star3Rating}">
									<span class="sr-only"> 60% Complete (danger) </span>
									<p>${star3Rating}%</p>

								</div>
							</div>
						</div>
						<div class="col-md-3">
							<img alt="" src="/ZEBRA/resources/image/star3.png" width="80px"
								height="20px">
						</div>
						<div class="col-md-9">
							<div class="progress">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
									style="width: ${star2Rating}">
									<span class="sr-only"> 40% Complete (danger) </span>
									<p>${star2Rating}%</p>

								</div>
							</div>
						</div>
						<div class="col-md-3">
							<img alt="" src="/ZEBRA/resources/image/star2.png" width="80px"
								height="20px">
						</div>
						<div class="col-md-9">
							<div class="progress">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"
									style="width: ${star1Rating}">
									<span class="sr-only">20% Complete (danger) </span>
									<p>${star1Rating}%</p>

								</div>
							</div>
						</div>
						<div class="col-md-3">
							<img alt="" src="/ZEBRA/resources/image/star1.png" width="80px"
								height="20px">
						</div>
						<div class="col-md-9">
							<div class="progress">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"
									style="width: ${star0Rating}">
									<span class="sr-only"> 10% Complete (danger) </span>
									<p>${star0Rating}%</p>
								</div>
							</div>
						</div>
					</div>


				</div>



				<!--    <a class="btn btn-primary" href="#">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>
 -->
				<div class="col-md-8"></div>

				<hr>

				<style>
#reviewDiv {
	-webkit-box-shadow: 2px 4px 5px 0px rgba(0, 0, 0, 0.29);
	-moz-box-shadow: 2px 4px 5px 0px rgba(0, 0, 0, 0.29);
	box-shadow: 2px 4px 5px 0px rgba(0, 0, 0, 0.29);
}
</style>

				<%
					List<Double> i = new ArrayList();
					List<Review> reviewList = (List<Review>) request.getAttribute("reviewListRequ");
					for (int j = 0; j < reviewList.size(); j++) {
						i.add(j, reviewList.get(j).getStarPoint());
					}
					
					List<Double> relatedStar = new ArrayList();
					List<Product> relatedProduct = (List<Product>) request.getAttribute("relatedProductsRequ");
					for (int j = 0; j < relatedProduct.size(); j++) {
						relatedStar.add(j, relatedProduct.get(j).getStarPoint());
					}
					
					int z=0;
				%>

				<c:forEach var="reviewList" items="${reviewList}">

					<div id="" style="padding-top: 5px">
						<hr>

						<div class="row">
							<div class="col-md-12" id="reviewDiv">
								<p>
									<img
										src="https://scontent.xx.fbcdn.net/v/t1.0-9/13133331_159272791137480_2076198251917202711_n.jpg?oh=0ff3e11adaa947acfd481819011865c8&oe=57E2D8BF"
										alt="..." class="img-circle" width="50px" height="50px"
										style="padding-left: 5px">
									<%-- <c:out value="${reviewList.starPoint}"></c:out> --%>
									ID:
									<c:out value="${reviewList.id}"></c:out>
									<%
										
											int starimag=i.get(z).intValue();
											if(starimag == 5){
									%>

									<img alt="" src="/ZEBRA/resources/image/star5.png" width="80px"
										height="20px">

									<%
										}
											if(starimag == 4){

									%>
									<img alt="" src="/ZEBRA/resources/image/star4.png" width="80px"
										height="20px">

									<%
										
											}if(starimag == 3){
										%>
									<img alt="" src="/ZEBRA/resources/image/star3.png" width="80px"
										height="20px">
										<%
											}if(starimag == 2){
										
										%>
											<img alt="" src="/ZEBRA/resources/image/star2.png" width="80px"
										height="20px">
										<%
											}if(starimag == 1){
										
										%>
										<img alt="" src="/ZEBRA/resources/image/star1.png" width="80px"
										height="20px">
										<%
											}z++;
										
										%>
										
								</p>

								<p style="padding-left: 5px">
									<c:out value="${reviewList.reviewText}"></c:out>
									<br />
								</p>
							</div>
						</div>
					</div>
				</c:forEach>





			</div>
	
	<%
	z=0;
	
	%>

			<!-- Blog Sidebar Widgets Column -->
			<div class="col-md-4" style="padding-top: 80px">
				<h3>Related Products</h3>

				<c:forEach var="relatedProducts" items="${relatedProducts}">
					<div class="col-md-4 portfolio-item"
						style="width: 250px; height: 315px">
						<a href="/ZEBRA/review?barcode=${relatedProducts.barcode}"> <img
							class="img-responsive" src="${relatedProducts.productUrl}" alt=""
							style="width: 150px; height: 170px;"></a>

						<div class="caption">

							<h5>
								<hr>
								<h5 style="font-weight: bolder; font-size: 15px">
									<c:out value="${relatedProducts.productName}"></c:out>
								</h5>
							</h5>
							<%
										
											int starimag=relatedStar.get(z).intValue();
											if(starimag == 5){
									%>

									<img alt="" src="/ZEBRA/resources/image/star5.png" width="80px"
										height="20px">

									<%
										}
											if(starimag == 4){

									%>
									<img alt="" src="/ZEBRA/resources/image/star4.png" width="80px"
										height="20px">

									<%
										
											}if(starimag == 3){
										%>
									<img alt="" src="/ZEBRA/resources/image/star3.png" width="80px"
										height="20px">
										<%
											}if(starimag == 2){
										
										%>
											<img alt="" src="/ZEBRA/resources/image/star2.png" width="80px"
										height="20px">
										<%
											}if(starimag == 1){
										
										%>
										<img alt="" src="/ZEBRA/resources/image/star1.png" width="80px"
										height="20px">
										<%
											}z++;
										
										%>


						</div>
					</div>
				</c:forEach>
			</div>

		</div>
		<!-- /.row -->
		<style>
</style>



		<script>
			$(document).on('ready', function() {
				$('#input-3').rating({
					displayOnly : true,
					step : 0.5
				});
			});
		</script>




		<div class="container">

			<!-- Footer -->
			<footer>
				<div class="row">
					<div class="col-lg-12">
						<p>Copyright &copy; Your Website 2014</p>
					</div>
				</div>
			</footer>

		</div>
		<!-- /.container -->
</body>

</html>
