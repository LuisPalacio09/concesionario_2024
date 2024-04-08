<%-- 
    Document   : agregar
    Created on : 7/04/2024, 02:05:30 AM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String rutaRaiz = request.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Opcion adicional </title>
    </head>
    <body>
    <center>
        <h1>Agregar Opcion adicional </h1>
        <hr/>
        <form action="/concesionario/opcionadicional?accion agregar" method="post">
            <table>
                <tr>
                    <th style="text-align: right">Id Opción:</th>
                    <td><input type="text" name="id_opcion"/></td>
                </tr>
                <tr>
                    <th style="text-align: right">Nombre</th>
                    <td><input type="text" name="nombre"/></td>
                </tr>
                <tr>
                    <th style="text-align: right">Descripción</th>
                    <td><input type="text" name="descripcion"/></td>
                </tr>
                <tr>
                    <th style="text-align: right">Precio</th>
                    <td><input type="text" name="precio"/></td>
                </tr>

                <tr>
                    <th style="text-align: right">Id Vehiculo</th>
                    <td><input type="text" name="id_vehiculo"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="ENTRAR"></td>
                    <td><input type="reset" name="LIMPIAR"/></td>
                </tr>
            </table>
        </form>
        <p style="color:#FF0000;">
        <hr/>
        <!-- (mensaje != null && mensaje.isEmpty())?mensaje: -->
    </p>
</center>
</body>
</html>
