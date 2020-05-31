/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controladores;

import app.dao.UsuarioDAOMySQL;
import app.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paul Esparza
 */
public class Controlador extends HttpServlet {
    String consultar = "vistas/consultar.jsp";
    String listar = "vistas/listar.jsp";
    String agregar = "vistas/agregar.jsp";
    String editar = "vistas/editar.jsp";
    Usuario u = new Usuario();
    UsuarioDAOMySQL dao = new UsuarioDAOMySQL();
    int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String accion = request.getParameter("accion");
        
        if(accion.equalsIgnoreCase("listar")){
            acceso = listar;
        } else if(accion.equalsIgnoreCase("agregar")){
            acceso = agregar;
        } else if(accion.equalsIgnoreCase("editar")){
            request.setAttribute("idU", request.getParameter("id"));
            acceso = editar;
        } else if(accion.equalsIgnoreCase("consultar")){
            request.setAttribute("idU", request.getParameter("id"));
            acceso = consultar;
        } else if(accion.equalsIgnoreCase("eliminar")){
            id = Integer.parseInt(request.getParameter("id"));
            u.setId(id);
            dao.elimina(id);
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("btnAgregar") != null){
            String alias = request.getParameter("alias");
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String contrasena = request.getParameter("contrasena");
            String email = request.getParameter("email");
            u.setAlias(alias);
            u.setNombre(nombre);
            u.setApellidos(apellidos);
            u.setContrasena(contrasena);
            u.setEmail(email);
            dao.agregar(u);
        } else if(request.getParameter("btnEditar") != null){
            id = Integer.parseInt(request.getParameter("txtId"));
            String alias = request.getParameter("alias");
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String contrasena = request.getParameter("contrasena");
            String email = request.getParameter("email");
            u.setId(id);
            u.setAlias(alias);
            u.setNombre(nombre);
            u.setApellidos(apellidos);
            u.setContrasena(contrasena);
            u.setEmail(email);
            dao.modifica(u);
        }
        RequestDispatcher vista = request.getRequestDispatcher(listar);
        vista.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}