/*

*/
package app.dao;

import app.modelo.Usuario;
import java.sql.Connection;
import java.util.List;

public interface UsuarioDAO {
    public List listar();
    public boolean agregar(Usuario u);
    public Usuario consulta(int id);
    public boolean elimina(int id);
    public boolean modifica(Usuario u);
//    public Connection abrir();
//    public void cerrar(Connection c);
}