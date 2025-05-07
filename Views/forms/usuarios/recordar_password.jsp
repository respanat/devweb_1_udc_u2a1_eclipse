<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Recordar Contraseña</title>
</head>
<body>
    <h1>Recordar Contraseña</h1>
    <form action="<%= request.getContextPath() %>/usuarios?action=recordarPassword" method="post">
        <label for="email">Correo Electrónico:</label><br>
        <input type="email" id="email" name="email" required><br><br>
        <input type="submit" value="Enviar Solicitud">
    </form>
    <br>
    <a href="<%= request.getContextPath() %>/usuarios?action=loginForm">Volver al Login</a>
</body>
</html>