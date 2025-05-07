<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Usuario</title>
</head>
<body>
    <h1>Agregar Nuevo Usuario</h1>
    <form action="<%= request.getContextPath() %>/usuarios?action=agregar" method="post">
        <label for="username">Nombre de Usuario:</label><br>
        <input type="text" id="username" name="username" required><br>
        <label for="password">Contraseña:</label><br>
        <input type="password" id="password" name="password" required><br>
        <label for="nombre">Nombre Completo:</label><br>
        <input type="text" id="nombre" name="nombre" required><br>
        <label for="email">Correo Electrónico:</label><br>
        <input type="email" id="email" name="email" required><br><br>
        <input type="submit" value="Agregar Usuario">
    </form>
    <br>
    <a href="<%= request.getContextPath() %>/usuarios">Volver a la lista de usuarios</a>
</body>
</html>