<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CineCalidad</title>
</head>
<body>
<center>
<h1>Bienvenidos a CineCalidad</h1>
<form action="PeliServlet" method="post">
    Enter your name: <input type="text" name="yourName" size="20">
    <input type="submit" value="Call Servlet post" />
</form>
<form action="PeliServlet" method="get">
    <input type="submit" value="Call Servlet get" />
</form>
    <a href="AddPel.jsp">Agregar Pelicula</a>
</center>
</body>
</html>