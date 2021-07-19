<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.io.PrintWriter"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<style type="text/css"><%@include file="css/style.css" %></style>
	<title>Game</title>
</head>
<body>

	<div class="contenedor">
		<h1>Welcome to the Great Number Game!</h1>
		<h3>I am thinking of a number between 1 and 100</h3>
		<h3>Take a guess!</h3>

		<form action="GreatNumber" method="post">
		<%-- <%int valAleatGuardado = (int)session.getAttribute("valorAleat");%> --%>
			<input value="${number}" name="number" type="text" />
			<div>${requestScope.validaciones}</div>
			<%-- <h1>El numero generado es: <%=valAleatGuardado%></h1> --%>
			<input type="submit" name="btnSubmit" value="Submit">
		</form>
		<br>
		<form action="Resetear" method="post">
			<input type="submit" name="btnReset" value="Play Again">
		</form>
	</div>
</body>
</html>