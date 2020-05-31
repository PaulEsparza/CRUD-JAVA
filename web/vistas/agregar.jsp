<%-- 
    Document   : agregar
    Created on : 29-ago-2019, 17:49:08
    Author     : Paul Esparza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AGREGAR</title>
    </head>
    <body>
        <form action="Controlador" method="POST">
            Alias:<input type="text" name="alias"><br>
            Nombre:<input type="text" name="nombre"><br>
            Apellidos:<input type="text" name="apellidos"><br>
            Contraseña:<input type="text" name="contrasena"><br>
            Correo:<input type="text" name="email"><br>
            <button type="submit" name="btnAgregar">Agregar</button><br>
            <a href="Controlador?accion=listar">Regresar</a>
        </form>
    </body>
</html>
