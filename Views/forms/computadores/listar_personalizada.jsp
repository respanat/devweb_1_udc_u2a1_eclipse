<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buscar Computadores por Marca</title>
</head>
<body>
    <h1>Buscar Computadores por Marca</h1>
    <form action="<%= request.getContextPath() %>/computadores?action=listarPersonalizada" method="get">
        <label for="marca">Marca:</label><br>
        <input type="text" id="marca" name="marca" required><br><br>
        <input type="submit" value="Buscar por Marca">
    </form>
    <br>
    <a href="<%= request.getContextPath() %>/computadores">Volver a la lista de computadores</a>
</body>
</html>