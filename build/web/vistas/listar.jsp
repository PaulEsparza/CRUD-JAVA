<%-- 
    Document   : listar
    Created on : 29-ago-2019, 17:48:54
    Author     : Paul Esparza
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="app.modelo.Usuario"%>
<%@page import="app.dao.UsuarioDAOMySQL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar</title>
    </head>
    <body>
        <div>
            <h1>Registros Actuales</h1>
            <a href="Controlador?accion=agregar">Agregar</a>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>ALIAS</th>
                        <th>NOMBRE</th>
                        <th>APELLIDOS</th>
                        <th>CONTRASEÑA</th>
                        <th>EMAIL</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <% 
                    UsuarioDAOMySQL dao = new UsuarioDAOMySQL();
                    List<Usuario> list = dao.listar();
                    Iterator<Usuario> i = list.iterator();
                    Usuario usu = null;
                    while(i.hasNext()){
                        usu = i.next();
                %>
                <tbody>
                    <tr>
                        <td><%= usu.getId() %></td>
                        <td><%= usu.getAlias()%></td>
                        <td><%= usu.getNombre()%></td>
                        <td><%= usu.getApellidos()%></td>
                        <td><%= usu.getContrasena()%></td>
                        <td><%= usu.getEmail()%></td>
                        <td>
                            <a href="Controlador?accion=consultar&id=<%= usu.getId() %>">Consultar</a>
                            <a href="Controlador?accion=editar&id=<%= usu.getId() %>">Editar</a>
                            <a href="Controlador?accion=eliminar&id=<%= usu.getId() %>">Eliminar</a>
                        </td>
                    </tr>
                    <% }%>
                </tbody>
            </table>


        </div>
    </body>
</html>
