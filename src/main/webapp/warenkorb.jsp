<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Collection"%>
<%@page import="de.deutscherv.kurse.jee.entity.Pizza"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Vielen Dank f�r Ihre Bestellung!</h1>
	<h3>Bestell�bersicht</h3>
	<table id="Bestell�bersicht">
		<thead>
			<tr>
				<th>Bestellnummer</th>
				<th>Name</th>
				<th>Preis</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${warenkorb}" var="wk">
				<tr>
					<td><c:out value=" ${wk.kartenNummer }" /></td>
					<td><c:out value="${wk.name}" /></td>
					<td><c:out value="${wk.preis}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h2>
		<b><i>G E S A M T</i> <c:out value="${bestellSumme}"></c:out></b>
	</h2>

</body>
</html>