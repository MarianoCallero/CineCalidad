<%@ page import="Clases.Pelicula" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: maria
  Date: 8/5/2022
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tarea</title>
</head>
<body>
<%
    List<Pelicula> retunCat2 =  (List<Pelicula>)request.getAttribute("LisPel");
%>
    <%for(Pelicula s: retunCat2){%>
    <p><%s.toString(); %></p>
<%}%>
</body>
</html>
