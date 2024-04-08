<%-- 
    Document   : modificar
    Created on : 7/04/2024, 02:06:06 AM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Vehiculo</title>
    </head>
    <body>
    <center>
        <h1>Modificar Vehiculo</h1>
        <hr/>
        <form action="/concesionario/vehiculo?accion-buscartredir=modificar" method="post">
            <table>
                <tr>
                    <th style="text-align: right">ID VEHICULO</th>
                    <td><input type="text" name="id"/></td>
                </tr>
                <tr>
                    <th><input type="submit" value="Penar*"></th>
                    <td><input type="reset" name="Limp"/></td>
                </tr>
            </table>
        </form>
        <hr/>
        <%--<% if (alguien != null) { %> --%>
        <form action="/concesionario/vehiculo?accion=modificar" method="post">
            <table>
                <tr>
                    <th style="text-align: right">Id vehiculo: </th>
                        <%--<td><input type="text" name="id" value="<%= (alguien != null) ? alguien.getId() : "" %>" readonly="readonly"/></td>--%>
                </tr>
                <tr>
                    <th style="text-align: right">Marca: </th>
                        <%-- <td><input type="password" name="marca" value="<%= (alguien != null) ? alguien.getMarca() : "" %>"/></td> --%>
                </tr>
                <tr>
                    <th style="text-align: right">Modelo: </th>
                        <%--  <td><input type="text" name="modelo" value="<%= (alguien != null) ? alguien.getModelo() : "" %>"/></td> --%>
                </tr>
                   <tr>
                    <th style="text-align: right">Cilindrada: </th>
                        <%--  <td><input type="text" name="cilindrada" value="<%= (alguien != null) ? alguien.getCilindrada() : "" %>"/></td> --%>
                </tr>
                <tr>
                    <th style="text-align: right">Precio: </th>
                        <%--  <td><input type="text" name="precio" value="<%= (alguien != null) ? alguien.getPrecio() : "" %>"/></td> --%>
                </tr>
                <tr>
                    <th><input type="submit" value="Modificar"></th>
                    <td><input type="reset" name="Limpias"/></td>
                </tr>
            </table>
        </form>
        <%-- } --%>
        <hr/>
        <p style="color:#FF0000;">
            <%-- <%= (mensaje != null && !mensaje.isEmpty()) ? mensaje : "" %> --%>
        </p>
        <%--<% request.getSession().setAttribute("vehiculo.buscar", null); %>--%>
    </center>
</body>
</html>
