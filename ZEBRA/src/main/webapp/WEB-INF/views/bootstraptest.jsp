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

<style type="text/css">
#topspace {
	padding-top: 70px;
	padding-bottom: 10px;
}
</style>

</head>
<body>

	<!---------------------------------네비게이션 바 시작-------------------------  -->
	<jsp:include page="topNavigation.jsp" flush="false"></jsp:include>
	<!---------------------------------네비게이션 바 끝-------------------------  -->

	<h1 id="topspace" align="center">Power Reviewers</h1>
	<hr style="border: solid 2px red;">


	<div class="container">
		<h1>Gold Level</h1>
		<p>The blockquote element is used to present content from another
			source:</p>
		<blockquote>
			<p>For 50 years, WWF has been protecting the future of nature.
				The world's leading conservation organization, WWF works in 100
				countries and is supported by 1.2 million members in the United
				States and close to 5 million globally.</p>
			<footer>From WWF's website</footer>
		</blockquote>
	</div>


	<div class="container">
		<div class="bootstrap-demo">
			<div class="row">

				<div class="col-sm-6 col-md-4">
					<!-- column 1 -->
					<div class="thumbnail">
						<!--  thumbnail 1  -->
						<img class="img-circle"
							src="http://www.tutorialspark.com/twitterBootstrap/china.jpg"
							alt="china thumbnail">
						<!-- image 1 -->
						<div class="caption">
							<!-- caption -->
							<h3>The Great Wall of China</h3>
							<p>The Great Wall of China is a series of fortifications
								northern borders of China</p>
							<p>
								<a href="#" class="btn btn-primary" role="button">Buy
									Tickets</a>
								<!-- btn 1 -->
								<a href="#" class="btn btn-default" role="button">Add to
									Wishlist</a>
							</p>
							<!-- btn 2 -->
						</div>
					</div>
				</div>

				<div class="col-sm-6 col-md-4">
					<!-- column 2 -->
					<div class="thumbnail">
						<!-- thumbnail 2 -->
						<img class="img-circle"
							src="http://www.tutorialspark.com/twitterBootstrap/statue-liberty.jpg"
							alt="Statue of Liberty thumbnail">
						<!-- image 2 -->
						<div class="caption">
							<!-- caption -->
							<h3>Statue of Liberty</h3>
							<p>The Statue of Liberty is a colossal neoclassical sculpture
								on Liberty Island in the middle of New York Harbor, in
								Manhattan, New York City.</p>
							<p>
								<a href="#" class="btn btn-primary" role="button">Buy
									Tickets</a>
								<!-- btn 1 -->
								<a href="#" class="btn btn-default" role="button">Add to
									Wishlist</a>
							</p>
							<!-- btn 2 -->
						</div>
					</div>
				</div>

				<div class="col-sm-6 col-md-4">
					<!-- column 2 -->
					<div class="thumbnail">
						<!-- thumbnail 2 -->
						<img class="img-circle"
							src="https://scontent.xx.fbcdn.net/hphotos-xtl1/t31.0-8/12671674_121428374921922_1736655941279239457_o.jpg"
							alt="Statue of Liberty thumbnail">
						<!-- image 2 -->
						<div class="caption">
							<!-- caption -->
							<h3>Statue of Liberty</h3>
							<p>The Statue of Liberty is a colossal neoclassical sculpture
								on Liberty Island in the middle of New York Harbor, in
								Manhattan, New York City.</p>
							<p>
								<a href="#" class="btn btn-primary" role="button">Buy
									Tickets</a>
								<!-- btn 1 -->
								<a href="#" class="btn btn-default" role="button">Add to
									Wishlist</a>
							</p>
							<!-- btn 2 -->
						</div>
					</div>
				</div>

			</div>
		</div>


	</div>



</body>
</html>