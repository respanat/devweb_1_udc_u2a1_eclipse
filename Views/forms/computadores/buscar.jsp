<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buscar Computador</title>
</head>
<body>
    <h1>Buscar Computador por ID</h1>
    <form action="<%= request.getContextPath() %>/computadores?action=buscar" method="get">
        <label for="id">ID del Computador:</label><br>
        <input type="number" id="id" name="id" required><br><br>
        <input type="submit" value="Buscar Computador">
    </form>
    <br>
    <a href="<%= request.getContextPath() %>/computadores">Volver a la lista de computadores</a>
</body>
</html>