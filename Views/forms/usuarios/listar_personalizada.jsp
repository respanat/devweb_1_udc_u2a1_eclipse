<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buscar Usuarios por Nombre</title>
</head>
<body>
    <h1>Buscar Usuarios por Nombre</h1>
    <form action="<%= request.getContextPath() %>/usuarios?action=listarPersonalizada" method="get">
        <label for="nombre">Nombre:</label><br>
        <input type="text" id="nombre" name="nombre" required><br><br>
        <input type="submit" value="Buscar por Nombre">
    </form>
    <br>
    <a href="<%= request.getContextPath() %>/usuarios">Volver a la lista de usuarios</a>
</body>
</html>