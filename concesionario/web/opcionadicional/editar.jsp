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
        <title>Modificar Opcion Adicional</title>
    </head>
    <body>
    <center>
        <h1>Modificar Opcion Adicional</h1>
        <hr/>
        <form action="/concesionario/opcionadicional?accion-buscartredir=modificar" method="post">
            <table>
                <tr>
                    <th style="text-align: right">ID</th>
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
        <form action="/concesionario/opcionadicional?accion=modificar" method="post">
            <table>
                <tr>
                    <th style="text-align: right">Id Opción:</th>
                        <%--<td><input type="text" name="id" value="<%= (alguien != null) ? alguien.getId() : "" %>" readonly="readonly"/></td>--%>
                </tr>
                <tr>
                    <th style="text-align: right">Nombre</th>
                        <%-- <td><input type="password" name="nombre" value="<%= (alguien != null) ? alguien.getNombre() : "" %>"/></td> --%>
                </tr>
                <tr>
                    <th style="text-align: right">Descripción</th>
                        <%--  <td><input type="text" name="descripcion" value="<%= (alguien != null) ? alguien.getDescripcion() : "" %>"/></td> --%>
                </tr>
                <tr>
                    <th style="text-align: right">Precio</th>
                        <%--  <td><input type="text" name="precio" value="<%= (alguien != null) ? alguien.getPrecio() : "" %>"/></td> --%>
                </tr>

                <tr>
                    <th style="text-align: right">Id Vehiculo</th>
                        <%--  <td><input type="text" name="id_vehiculo" value="<%= (alguien != null) ? alguien.getId_vehiculo() : "" %>"/></td> --%>
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
        <%--<% request.getSession().setAttribute("opcionadicional.buscar", null); %>--%>
    </center>
</body>
</html>
