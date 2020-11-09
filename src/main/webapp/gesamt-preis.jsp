<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Der Gesamtpreis beträgt: <span> <%
 	out.println((request.getAttribute("gesamtPreis")));
 %>
		</span>
	</h1>
</body>
</html>