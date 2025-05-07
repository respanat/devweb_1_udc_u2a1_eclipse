<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buscar Usuario</title>
</head>
<body>
    <h1>Buscar Usuario por ID</h1>
    <form action="<%= request.getContextPath() %>/usuarios?action=buscar" method="get">
        <label for="id">ID del Usuario:</label><br>
        <input type="number" id="id" name="id" required><br><br>
        <input type="submit" value="Buscar Usuario">
    </form>
    <br>
    <a href="<%= request.getContextPath() %>/usuarios">Volver a la lista de usuarios</a>
</body>
</html>