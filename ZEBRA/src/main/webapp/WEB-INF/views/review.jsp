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

<body>



	<!---------------------------------네비게이션 바 시작-------------------------  -->
	<jsp:include page="topNavigation.jsp" flush="false"></jsp:include>
	<!---------------------------------네비게이션 바 끝-------------------------  -->
	<%
		String str = "star4";
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
							align="middle" style="width: 350px; height: 350px;">
					</div>
					<div class="col-md-6">
						<img alt="" src="/ZEBRA/resources/image/<%=str%>.png"
							width="230px" height="50px">

						<h2>
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
									aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"
									style="width: 80%">
									<span class="sr-only"> 80% Complete (danger) </span>
									<p>80%</p>
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
									style="width: 60%">
									<span class="sr-only"> 60% Complete (danger) </span>
									<p>60%</p>

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
									style="width: 40%">
									<span class="sr-only"> 40% Complete (danger) </span>
									<p>40%</p>

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
									style="width: 20%">
									<span class="sr-only">20% Complete (danger) </span>
									<p>20%</p>

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
									style="width: 10%">
									<span class="sr-only"> 10% Complete (danger) </span>
									<p>10%</p>
								</div>
							</div>
						</div>
					</div>


				</div>



				<!--    <a class="btn btn-primary" href="#">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>
 -->
				<div class="col-md-8"></div>

				<hr>



				<c:forEach var="reviewList" items="${reviewList}">
					<div class="well" style="padding-top: 10px">

						<!-- 	<div class="text-right">
						<a class="btn btn-success">Leave a Review</a>
					</div>
 -->
						<hr>

						<div class="row">
							<div class="col-md-12">
								<p>
									<img
										src="https://scontent.xx.fbcdn.net/v/t1.0-9/13133331_159272791137480_2076198251917202711_n.jpg?oh=0ff3e11adaa947acfd481819011865c8&oe=57E2D8BF"
										alt="..." class="img-circle" width="50px" height="50px">
									<c:out value="${reviewList.starPoint}"></c:out>
									<c:out value="${reviewList.id}"></c:out>
									<img alt="" src="/ZEBRA/resources/image/star5.png" width="80px"
										height="20px">
								</p>
								<p>
									<c:out value="${reviewList.reviewText}"></c:out>
									<br />
								</p>
							</div>
						</div>
					</div>
				</c:forEach>





			</div>

			<!-- Blog Sidebar Widgets Column -->
			<div class="col-md-4" style="padding-top: 80px">
				<h3>Related Products</h3>
				
				<c:forEach var="relatedProducts" items="${relatedProducts}">
					<div class="thumbnail" style="width: 250px; height: 315px">
						<img src="${relatedProducts.productUrl}" alt="" width="150px" height="170px">
					
						<div class="caption">
						
							<h5>
							<hr>
							<c:out value="${relatedProducts.productName}"></c:out></h5>
							<img alt="" src="/ZEBRA/resources/image/star5.png" width="80px"
								height="20px">
							<form action="review" method="GET">
								<button type="submit" class="btn btn-danger" name="barcode"
									value="${popularProduct.barcode}">Review</button>
							</form>

						</div>
					</div>
					</c:forEach>
			</div>

		</div>
		<!-- /.row -->



		<div class="container">

			<hr>

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
