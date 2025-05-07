<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login de Usuario</title>
</head>
<body>
    <h1>Iniciar Sesión</h1>
    <c:if test="${not empty mensajeError}">
        <p style="color: red;"><c:out value="${mensajeError}" /></p>
    </c:if>
    <form action="<%= request.getContextPath() %>/usuarios?action=login" method="post">
        <label for="username">Nombre de Usuario:</label><br>
        <input type="text" id="username" name="username" required><br>
        <label for="password">Contraseña:</label><br>
        <input type="password" id="password" name="password" required><br><br>
        <input type="submit" value="Iniciar Sesión">
    </form>
    <br>
    <a href="<%= request.getContextPath() %>/usuarios?action=recordarPasswordForm">¿Olvidaste tu contraseña?</a>
</body>
</html>