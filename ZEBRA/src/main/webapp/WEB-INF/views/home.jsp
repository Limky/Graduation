<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!--홈  -->
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





	<style>
	@import url(http://fonts.googleapis.com/earlyaccess/hanna.css);
	
	#title {
		background-color:#880000     ;
		/* 	margin: 50px;  */
		padding-top: 60px;
		padding-bottom:30px;
		color: black;
		font-size: 60px;
	}
	
	#titlep{
	font-size: 20px;
	
	}
	
	.bootstrap-demo {
		padding: 50px;
		
	}
	</style>

		<h1 id="title" align="center"style="font-family: fantasy; color: #FFFFFF;">
			<!-- <img alt="" src="/ZEBRA/resources/image/test.png" width="150px" height="100px"> -->ZEBRA<br>
		<div class="container" align="center">
</div>
		<p id="titlep"class="lead" style="font-family: 'Nanum Gothic'; color: #dcdcdc; border:1" >
Section of the community to build healthy consumption culture
      </p>
		</h1>



<!-- 
		<div class="container"> -->

<div class="container">
<!------------------------------------------------------쿠르셜 시작  ----------------------------------------------------------->
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				</ol>
				<!-- style='position: relative; top:-200' -->
				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox"
					style="width: 1158; height: 444">


					<div class="item active">
						<img
							src="https://scontent.xx.fbcdn.net/t31.0-8/13247694_172669706464455_118460718092039742_o.jpg">

						<div class="carousel-caption">
							<h1 style="color: #FFFFFF; text-shadow:3px 3px #3c3c3c">Scan a barcode!</h1>
							<p style="color: #FFFFFF;  text-shadow:1px 1px #3c3c3c">Find the barcode of the item you want.</p>
							
						</div>

					</div>


					<div class="item">
						<img
							src="https://scontent.xx.fbcdn.net/hphotos-xaf1/t31.0-8/12898409_121419598256133_5437606159514345821_o.jpg"
							title="cold" alt="...">
						<div class="carousel-caption">
							<h1>Cold Play</h1>
							<p class="lead">Parachutes A Rush of Blood to the Head X&Y
								Viva la Vida or Death and All His Friends Mylo Xyloto Ghost
								Stories</p>
						</div>
					</div>


					<div class="item">
						<img align="middle"
							src="https://scontent.xx.fbcdn.net/hphotos-xaf1/t31.0-8/12909531_121423344922425_8489312002504703306_o.jpg">

						<div class="carousel-caption">
							<h1 style="color: #FFFFFF">It's come from saying 'no' to
								1,000 things</h1>
							<p class="lead" style="color: #FFFFFF">I think if you do
								something and it turns out pretty good, then you should go do
								something else wonderful, not dwell on it for too long.</p>

						</div>

					</div>
				</div>





				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>

			<script type="text/javascript">
				$('.carousel').carousel({
					interval : 2000
				})
			</script>
<!------------------------------------------------------쿠르셜 끝  ----------------------------------------------------------->
</div>


<h1 align="center" style="padding:20px ">ZEBRA Service</h1>
<img src="https://scontent.xx.fbcdn.net/t31.0-8/13247920_172959903102102_2284409825658967265_o.jpg" alt="china thumbnail">

	<!-- 	</div>컨테이너 끝  -->
	
		
</body>
</html>