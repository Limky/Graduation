<%@page import="kr.ac.zebra.dto.*"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.json.simple.*"%>

<%

	request.setCharacterEncoding("UTF-8");

	List<Product> productList = (List<Product>) request.getAttribute("productList");

	JSONObject jObject = new JSONObject();

	
	jObject.put("productInfo", productList);

	out.println(jObject);

%>