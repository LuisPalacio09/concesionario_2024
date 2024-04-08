<%-- 
    Document   : buscar
    Created on : 7/04/2024, 02:05:35 AM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Opcion Adicional</title>
    </head>
    <body>
    <center>
        <h1>Buscar Opcion Adicional </h1>
        <hr/>
        <form action="/concesionario/opcionadicional?accion=buscartredir&buscar" method="post">
            <table>
                <tr>
                    <th style="text-align: right">Id Opción:</th>
                    <td><input type="text" name="id_opcion"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Buscar"></td>
                    <td><input type="reset" name="Limpiar"/></td>
                </tr>
                <tr>
                    <th style="text-align: right">Nombre:</th>
                        <%--  <td style="text-align: left"><%= (alguien != null) ? alguien.getNombre() : "" %></td>--%>
                </tr>
                <tr>
                    <th style="text-align: right">Descripción</th>
                        <%-- <td style="text-align: left"><%= (alguien != null) ? alguien.getDescripcion() : "" %></td>--%>
                </tr>
                <tr>
                    <th style="text-align: right">Precio</th>
                        <%-- <td style="text-align: left"><%= (alguien != null) ? alguien.getPrecio() : "" %></td>--%>
                </tr>

                <tr>
                    <th style="text-align: right">Id Vehiculo</th>
                        <%--  <td style="text-align: left"><%= (alguien != null) ? alguien.getId_vehiculo() : "" %></td>--%>
                </tr>
            </table>
        </form>
        <hr/>
        <p style="color:#FF0000;">
            <!-- (mensaje != null && mensaje.isEmpty()) ? mensaje : "" -->
        </p>
        <% request.getSession().setAttribute("opcionadicional.buscar", null);%>
    </center>
</body>
</html>
