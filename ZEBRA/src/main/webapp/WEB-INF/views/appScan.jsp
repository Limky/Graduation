<%@page import="kr.ac.zebra.dto.*"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="org.json.simple.*"%>
<%@ page session="true"%>

<%
   request.setCharacterEncoding("UTF-8");

   JSONObject jObject = new JSONObject();

   Product product = (Product) request.getAttribute("product");

   if (product == null) {
      String result = (String) request.getAttribute("result");
      
      jObject.put("result", result);
   } else {
      List<Review> reviews = (List<Review>) request.getAttribute("reviews");

      jObject.put("productInfo", product);
      jObject.put("reviews", reviews);
   }

   out.println(jObject.toJSONString());
%>