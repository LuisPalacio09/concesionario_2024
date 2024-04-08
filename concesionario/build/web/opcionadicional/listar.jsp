<%-- 
    Document   : listar
    Created on : 7/04/2024, 02:05:45 AM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Opciones adicionales</title>
    </head>
    <body>
    <center>
        <h1>Todas las opciones adicionales agregadas aqui</h1>
        <%-- if (mensaje != null) {
           out.print(mensaje);
        } else { --%>
        <table border="1">
            <thead>
                <tr>
                    <th>Item</th>
                    <th>ID </th>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Precio</th>
                    <th>Id Vehiculo</th>
                </tr>
            </thead>
            <tbody>
                <%-- int contador = 0;
                  for (Usuario alguien : listado) {
                     contador++;
                %>
                <tr>
                  <td><%= contador %></td>
                  <td><%= alguien.getId() %></td>
                  <td><%= alguien.getNombre() %></td>
                  <td><%= alguien.getDescripcion() %></td>
                  <td><%= alguien.getPrecio() %></td>
                  <td><%= alguien.getId_vehiculo() %></td>
                </tr>
                <% } --%>
            </tbody>
        </table>
        <%-- } --%>
        <hr>
        <a href="../opcionadicional/index.jsp"><<:: VOLVER AL MENU</a>
    </center>
</body>
</html>
