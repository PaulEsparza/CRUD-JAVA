<%-- 
    Document   : consultar
    Created on : 29-ago-2019, 20:43:31
    Author     : Paul Esparza
--%>

<%@page import="app.modelo.Usuario"%>
<%@page import="app.dao.UsuarioDAOMySQL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONSULTAR</title>
    </head>
    <body>
        <% 
            UsuarioDAOMySQL dao = new UsuarioDAOMySQL();
            int id = Integer.parseInt((String)request.getAttribute("idU"));
            Usuario u = (Usuario) dao.consulta(id);
        %>
        <form>
            Alias:<input type="text" name="alias" value="<%= u.getAlias() %>" disabled><br>
            Nombre:<input type="text" name="nombre" value="<%= u.getNombre()%>" disabled><br>
            Apellidos:<input type="text" name="apellidos" value="<%= u.getApellidos()%>" disabled><br>
            <!--Contraseña:<input type="text" name="contrasena" value="<%= u.getContrasena()%>"><br>-->
            Correo:<input type="text" name="email" value="<%= u.getEmail()%>" disabled><br>
            <input type="hidden" name="txtId" value="<%= u.getId()%>">
            <a href="Controlador?accion=listar">Regresar</a>
        </form>
    </body>
</html>
