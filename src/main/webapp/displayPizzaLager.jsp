<%@page import="java.util.Collection"%>
<%@page import="de.deutscherv.kurse.jee.entity.Pizza"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gefundene Pizzen</title>
</head>
<body>
	<table id="PizzaLager">
		<thead>
			<tr>
				<th>Bestellnummer</th>
				<th>Name</th>
				<th>Preis</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pz}" var="p">
				<tr>
					<td><c:out value=" ${p.kartenNummer }" /></td>
					<td><c:out value="${p.name}" /></td>
					<td><c:out value="${p.preis}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>