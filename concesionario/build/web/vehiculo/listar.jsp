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
        <title>Lista de vehiculos</title>
    </head>
    <body>
    <center>
        <h1>Todos los vehiculos agregados aqui</h1>
        <%-- if (mensaje != null) {
           out.print(mensaje);
        } else { --%>
        <table border="1">
            <thead>
                <tr>
                    <th>Item</th>
                    <th>ID </th>
                    <th>Marca</th>
                    <th>Modelo</th>
                    <th>Cilindrada</th>
                    <th>Precio</th>
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
                  <td><%= alguien.getMarca() %></td>
                  <td><%= alguien.getModelo() %></td>
                  <td><%= alguien.getCilindrada() %></td>
                  <td><%= alguien.getPrecio() %></td>
                </tr>
                <% } --%>
            </tbody>
        </table>
        <%-- } --%>
        <hr>
        <a href="vehiculos/index.jsp"><<:: VOLVER AL MENU</a>
               

    </center>
</body>
</html>
