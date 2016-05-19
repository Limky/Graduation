<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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



<title>Home</title>



</head>
<body>

	<!---------------------------------네비게이션 바 시작-------------------------  -->
		<jsp:include page="topNavigation.jsp" flush="false"></jsp:include>
 	<!---------------------------------네비게이션 바 끝-------------------------  -->




	<h1 align="center"> 인기 상품 페이지 입니다.</h1>

<div class="container">
<!------------------------------------------------------레이아웃 시작  ----------------------------------------------------------->
			<div class="bootstrap-demo">
				<div class="row">

					<div class="col-sm-6 col-md-4">
						<!-- column 1 -->
						<div class="thumbnail">
							<!--  thumbnail 1  -->
							<img
								src="http://www.tutorialspark.com/twitterBootstrap/china.jpg"
								alt="china thumbnail">
							<!-- image 1 -->
							<div class="caption">
								<!-- caption -->
								<h3>The Great Wall of China</h3>
								<p>The Great Wall of China is a series of fortifications
									made of stone, brick, tamped earth, wood, and other materials,
									generally built along an east-to-west line across the
									historical northern borders of China</p>
								<p>
										<button type="button" class="btn btn-danger">Danger</button>
								</p>
								<!-- btn 2 -->
							</div>
						</div>
					</div>

					<div class="col-sm-6 col-md-4">
						<!-- column 2 -->
						<div class="thumbnail">
							<!-- thumbnail 2 -->
							<img
								src="http://www.tutorialspark.com/twitterBootstrap/statue-liberty.jpg"
								alt="Statue of Liberty thumbnail">
							<!-- image 2 -->
							<div class="caption">
								<!-- caption -->
								<h3>Statue of Liberty</h3>
								<p>The Statue of Liberty is a colossal neoclassical
									sculpture on Liberty Island in the middle of New York Harbor,
									in Manhattan, New York City.</p>
								<p>
										<button type="button" class="btn btn-danger">Danger</button>
								</p>
								<!-- btn 2 -->
							</div>
						</div>
					</div>

					<div class="col-sm-6 col-md-4">
						<!-- column 2 -->
						<div class="thumbnail">
							<!-- thumbnail 2 -->
							<img
								src="https://scontent.xx.fbcdn.net/hphotos-xtl1/t31.0-8/12671674_121428374921922_1736655941279239457_o.jpg"
								alt="Statue of Liberty thumbnail">
							<!-- image 2 -->
							<div class="caption">
								<!-- caption -->
								<h3>Statue of Liberty</h3>
								<p>The Statue of Liberty is a colossal neoclassical
									sculpture on Liberty Island in the middle of New York Harbor,
									in Manhattan, New York City.</p>
								<p>
										<button type="button" class="btn btn-danger">Danger</button>
								</p>
								<!-- btn 2 -->
							</div>
						</div>
					</div>

				</div>
			</div>
<!------------------------------------------------------레이아웃 끝  ----------------------------------------------------------->
</div>

	<c:forEach var="popularProduct" items="${popularProductModel}">
	<p>
		<c:out value="${popularProduct}">
		</c:out>
	</p>

	</c:forEach>




</body>
</html>