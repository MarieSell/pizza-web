<%@page import="de.deutscherv.kurse.jee.entity.Pizza"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pizzen</title>
</head>
<body>
	<h1>
		<c:out value="${empty pageTitle ? 'Anzeige von Pizzen' : pageTitle}" />
	</h1>
	<form action="warenkorb" method="post">
		<ul>
			<c:forEach items="${pz}" var="p">
				<li><c:if test="${!merkenFormDisabled}">
						<input type="checkbox" name="kartennummer"
							value="${p.kartennummer}">
					</c:if> <c:out value="${p.name}, ${p.durchmesser}" /></li>
			</c:forEach>
		</ul>
		<c:if test="${!merkenFormDisabled}">
			<input type="submit" value="Markierte Pizzen in Warenkorb legen">
		</c:if>
	</form>
</body>
</html>