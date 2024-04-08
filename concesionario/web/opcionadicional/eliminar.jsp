<%-- 
    Document   : eliminar
    Created on : 7/04/2024, 02:05:40 AM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Opcion Adicional</title>
    </head>
    <body>
    <center>
        <h1>Eliminar Opcion Adicional</h1>
        <hr/>
        <form action="/concesionario/opcionadicional?accion-buscar&redir=borrar" method="post">
            <table>
                <tr>
                    <th style="text-align: right">ID OPCION ADICIONAL</th>
                    <td><input type="text" name="id"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Buscar"></td>
                    <td><input type="reset" name="Limpiar"/></td>
                </tr>
                <%-- <tr>
                    <th style="text-align: right">Nombre</th>
                        <td style="text-align: left"><%= (alguien != null) ? "" : "" %></td> 
                </tr>--%>

                <tr>
                    <th style="text-align: right">Nombre:</th>
                        <%--  <td style="text-align: left"><%= (alguien != null) ? alguien.getNombre() : "" %></td> --%>
                </tr>
                <tr>
                    <th style="text-align: right">Descripción</th>
                        <%-- <td style="text-align: left"><%= (alguien != null) ? alguien.getDescripcion() : "" %></td> --%>
                </tr>
                <tr>
                    <th style="text-align: right">Precio</th>
                        <%-- <td style="text-align: left"><%= (alguien != null) ? alguien.getPrecio() : "" %></td> --%>
                </tr>

                <tr>
                    <th style="text-align: right">Id Vehiculo</th>
                        <%-- <td style="text-align: left"><%= (alguien != null) ? alguien.getId_vehiculo() : "" %></td> --%>
                </tr>
            </table>
        </form>
        <hr/>
        <%-- <% if (alguien != null) { %> 
        <form action="/concesionario/opcionadicional?accion=borrar" method="post">
        <%-- <input type="hidden" name="id" value="<%= alguien.getId()%>"> 
        <table>
          <tr><td><input type="submit" value="Eliminar"/></td></tr>
        </table>
      </form>
    <% } %>
    <p style="color:#FF0000;"> --%>
        <%-- <%= (mensaje != null && !mensaje.isEmpty()) ? mensaje : "" %> --%>
    </p>
    <%-- <% request.getSession().setAttribute("opcionadicional.buscar", null); %> --%>
</center>
</body>
</html>
