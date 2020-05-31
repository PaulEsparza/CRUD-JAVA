<%-- 
    Document   : editar
    Created on : 29-ago-2019, 17:49:17
    Author     : Paul Esparza
--%>

<%@page import="app.modelo.Usuario"%>
<%@page import="app.dao.UsuarioDAOMySQL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDITAR</title>
    </head>
    <body>
        <% 
            UsuarioDAOMySQL dao = new UsuarioDAOMySQL();
            int id = Integer.parseInt((String)request.getAttribute("idU"));
            Usuario u = (Usuario) dao.consulta(id);
        %>
        <form action="Controlador" method="POST">
            Alias:<input type="text" name="alias" value="<%= u.getAlias() %>"><br>
            Nombre:<input type="text" name="nombre" value="<%= u.getNombre()%>"><br>
            Apellidos:<input type="text" name="apellidos" value="<%= u.getApellidos()%>"><br>
            Contraseña:<input type="text" name="contrasena" value="<%= u.getContrasena()%>"><br>
            Correo:<input type="text" name="email" value="<%= u.getEmail()%>"><br>
            <input type="hidden" name="txtId" value="<%= u.getId()%>">
            <button type="submit" name="btnEditar">Editar</button><br>
            <a href="Controlador?accion=listar">Cancelar</a>
        </form>
    </body>
</html>
