<%@page import="java.util.Collection"%>
<%@page import="de.deutscherv.kurse.jee.entity.Pizza"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pizzen</title>
</head>
<body>
	<h1>
		<c:out value="${empty pageTitle ? 'Anzeige aller Pizzen' : pageTitle}" />
	</h1>
	<form action="warenkorb" method="post">
		<table id="PizzaLager">
			<thead>
				<tr>
					<th>Bestellnummer</th>
					<th>Name</th>
					<th>Durchmesser</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pz}" var="p">
					<tr>
						<td><c:out value=" ${p.kartenNummer }" /> <c:if
								test="${!warenkorbFormDisabled}">
								<input type="checkbox" name="id" value="${p.kartenNummer}">
							</c:if></td>
						<td><c:out value="${p.name}" /></td>
						<td><c:out value="${p.durchmesser}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>