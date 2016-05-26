<%@page import="kr.ac.zebra.dto.*"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="org.json.simple.*"%>
<%@ page session="true"%>

<%
	request.setCharacterEncoding("UTF-8");

	List<Product> products = (List<Product>) request.getAttribute("products");

	JSONObject jObject = new JSONObject();

	jObject.put("products", products);

	out.println(jObject.toJSONString());
%>