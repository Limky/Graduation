<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<html class="no-js">

<head>
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
<link href="resources/Graph/bootstrap/assets/styles.css" rel="stylesheet"
 media="screen">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
<script
 src="resources/Graph/bootstrap/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>
<body>

                    <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left"><h3>Persentage For Sector Count</h3></div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span3">
                                    <div class="chart" data-percent=100>${useCount.cinemaCompute}%</div>
                                    <div class="chart-bottom-heading"><span class="label label-info">Cinema</span>
                                    </div>
                                </div>
                                <div class="span3">
                                    <div class="chart" data-percent=${useCount.exhibitionCompute}>${useCount.exhibitionCompute}%</div>
                                    <div class="chart-bottom-heading"><span class="label label-info">Exhibition</span>
                                    </div>
                                </div>
                                <div class="span3">
                                    <div class="chart" data-percent=${useCount.libraryCompute}>${useCount.libraryCompute}%</div>
                                    <div class="chart-bottom-heading"><span class="label label-info">Library</span>
                                    </div>
                                </div>
                                <div class="span3">
                                <div align="center"><h6>Sector Count</h6></div></br>
                                   <table class="table table-bordered">
        
          <tr>
           <th>Cinema</th>
           <th>Exhibition</th>
           <th>Library</th>
          </tr>
        
         
         <tr>
          <th align="center">${useCount.cinema}</th>
          <th align="center">${useCount.exhibition}</th>
          <th align="center">${useCount.library}</th>
         </tr>
         
        </table>
                                </div>
                            </div>
                            <div> </br></div>
                        </div>
                        <!-- /block -->
                    </div>
         
                    
              
  
  <hr>
  <footer>
  <div class="pull-right">
   <p>&copy; Cocktail 2016</p>
   </div>
  </footer>
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
</body>


</body>
</html>