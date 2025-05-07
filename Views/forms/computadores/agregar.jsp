<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Computador</title>
</head>
<body>
    <h1>Agregar Nuevo Computador</h1>
    <form action="<%= request.getContextPath() %>/computadores?action=agregar" method="post">
        <label for="marca">Marca:</label><br>
        <input type="text" id="marca" name="marca" required><br>
        <label for="categoria">Categoría:</label><br>
        <input type="text" id="categoria" name="categoria" required><br>
        <label for="marcaCpu">Marca CPU:</label><br>
        <input type="text" id="marcaCpu" name="marcaCpu"><br>
        <label for="velocidadCpu">Velocidad CPU:</label><br>
        <input type="text" id="velocidadCpu" name="velocidadCpu"><br>
        <label for="tecnologiaRam">Tecnología RAM:</label><br>
        <input type="text" id="tecnologiaRam" name="tecnologiaRam"><br>
        <label for="capacidadRam">Capacidad RAM:</label><br>
        <input type="text" id="capacidadRam" name="capacidadRam"><br>
        <label for="tecnologiaDisco">Tecnología Disco:</label><br>
        <input type="text" id="tecnologiaDisco" name="tecnologiaDisco"><br>
        <label for="capacidadDisco">Capacidad Disco:</label><br>
        <input type="text" id="capacidadDisco" name="capacidadDisco"><br>
        <label for="numPuertosUSB">Número Puertos USB:</label><br>
        <input type="number" id="numPuertosUSB" name="numPuertosUSB"><br>
        <label for="numPuertosHDMI">Número Puertos HDMI:</label><br>
        <input type="number" id="numPuertosHDMI" name="numPuertosHDMI"><br>
        <label for="MarcaMonitor">Marca Monitor:</label><br>
        <input type="text" id="MarcaMonitor" name="MarcaMonitor"><br>
        <label for="pulgadas">Pulgadas:</label><br>
        <input type="number" step="0.1" id="pulgadas" name="pulgadas"><br>
        <label for="precio">Precio:</label><br>
        <input type="number" step="0.01" id="precio" name="precio" required><br><br>
        <input type="submit" value="Agregar Computador">
    </form>
    <br>
    <a href="<%= request.getContextPath() %>/computadores">Volver a la lista de computadores</a>
</body>
</html>