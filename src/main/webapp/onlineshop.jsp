<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>DeinePizza-Onlineshop</h1>

	<form id="wkFormId" name="warenkorb" method="post"
		action="PizzaWarenkorbServlet">
		<h3>Wählen Sie Ihre Pizzen aus:</h3>
		<fieldset>
			<label> <input type="checkbox" name="bestelltePizza"
				value="Margarita"> Margarita
			</label> <label> <input type="checkbox" name="bestelltePizza"
				value="Salami"> Salami
			</label> <label> <input type="checkbox" name="bestelltePizza"
				value="Schinken"> Schinken
			</label> <label> <input type="checkbox" name="bestelltePizza"
				value="Spezial"> Spezial
			</label>
		</fieldset>
	</form>

	<button form="wkFormId">bestellen</button>

</body>
</html>