<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="org.json.simple.*"%>
<%@ page session="true"%>

<%
	request.setCharacterEncoding("UTF-8");

	String str = (String) request.getAttribute("result");

	JSONObject jObject = new JSONObject();

	jObject.put("result", str);

	out.println(jObject.toJSONString());
%>