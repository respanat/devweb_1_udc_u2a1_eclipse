<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Computadores</title>
</head>
<body>
    <h1>Lista de Computadores</h1>
    <c:if test="${not empty listaComputadores}">
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Marca</th>
                    <th>Categoría</th>
                    <th>Marca CPU</th>
                    <th>Velocidad CPU</th>
                    <th>RAM</th>
                    <th>Disco</th>
                    <th>Precio</th>
                    </tr>
            </thead>
            <tbody>
                <c:forEach var="computador" items="${listaComputadores}">
                    <tr>
                        <td><c:out value="${computador.id}"/></td>
                        <td><c:out value="${computador.marca}"/></td>
                        <td><c:out value="${computador.categoria}"/></td>
                        <td><c:out value="${computador.marcaCpu}"/></td>
                        <td><c:out value="${computador.velocidadCpu}"/></td>
                        <td><c:out value="${computador.capacidadRam} ${computador.tecnologiaRam}"/></td>
                        <td><c:out value="${computador.capacidadDisco} ${computador.tecnologiaDisco}"/></td>
                        <td><c:out value="${computador.precio}"/></td>
                        </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty listaComputadores}">
        <p>No hay computadores registrados.</p>
    </c:if>
    <br>
    <a href="<%= request.getContextPath() %>/computadores?action=agregarForm">Agregar Nuevo Computador</a> |
    <a href="<%= request.getContextPath() %>/computadores?action=buscarForm">Buscar Computador</a> |
    <a href="<%= request.getContextPath() %>/computadores?action=listarPersonalizadaForm">Buscar por Marca</a>
</body>
</html>