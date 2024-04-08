<%-- 
    Document   : agregar
    Created on : 7/04/2024, 02:05:30 AM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String rutaRaiz = request.getServletContext().getContextPath();
    String msj = request.getParameter("msj");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Vehiculo </title>
    </head>
    <body>
    <center>
        <h1>Agregar Vehiculo</h1>
        <hr/>
        <%-- <form action="/concesionario/vehiculo?accion agregar" method="post">--%>
        <%-- <form action="/vehiculo" method="post">--%>
        <form action="<%= rutaRaiz %>/vehiculo" method="post">
            
            <table>
                <tr>
                    <th style="text-align: right">Id vehiculo: </th>
                    <td><input type="text" name="id"/></td>
                </tr>
                <tr>
                    <th style="text-align: right">Marca: </th>
                    <td><input type="text" name="marca"/></td>
                </tr>
                <tr>
                    <th style="text-align: right">Modelo: </th>
                    <td><input type="text" name="modelo"/></td>
                </tr>
                <tr>
                    <th style="text-align: right">Cilindrada: </th>
                    <td><input type="text" name="cilindrada"/></td>
                </tr>
                <tr>
                    <th style="text-align: right">Precio: </th>
                    <td><input type="text" name="precio"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Guardar"></td>
                    <td><input type="reset" name="LIMPIAR"/></td>
                </tr>
            </table>
        </form>
        <span><%= (msj != null) ? msj : ""%></span>
        <hr/>
        <!-- (mensaje != null && mensaje.isEmpty())?mensaje: -->
    </p>
</center>
</body>
</html>
