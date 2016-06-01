<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<html>

<head>
<title>Admin Home Page</title>
<!-- Bootstrap -->
<link href="resources/bootstrap/bootstrap/css/bootstrap.min.css"
 rel="stylesheet" media="screen">
<link
 href="resources/bootstrap/bootstrap/css/bootstrap-responsive.min.css"
 rel="stylesheet" media="screen">
<link
 href="resources/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.css"
 rel="stylesheet" media="screen">
<link href="resources/bootstrap/assets/styles.css" rel="stylesheet"
 media="screen">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
<script
 src="resources/bootstrap/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>
</head>
<body>
	
	
<div class="container" style="padding: 15px; padding-top: 30px">
		<div class="row-fluid" style="padding: 15px; padding-top: 30px">
			<!-- block -->
			<div class="block">
				<div class="navbar navbar-inner block-header">
					<div class="muted pull-left">
						<h4>Persent of Scanning Contrast review</h4>
					</div>
				</div>
				<div class="block-content collapse in" style="padding-bottom: 20px">
				<div class="span3">
				<h4 style="padding-left:20px">Scan Count</h4>
				</div>
				<div class="span3">
				<h4>Scan Count</h4>
				</div>
				<div class="span3">
				<h4>Scanning Contrast review</h4>
				</div>
					<div class="span3">
						<div class="chart" data-percent=100>${useCount.cinemaCompute}%</div>
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



</body>
</html>