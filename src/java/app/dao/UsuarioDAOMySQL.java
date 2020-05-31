/*

*/
package app.dao;

import app.BD.Conexion;
import app.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOMySQL implements UsuarioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario u = new Usuario();

    @Override
    public List listar() {
        ArrayList<Usuario> list = new ArrayList<>();
        String sql = "SELECT * FROM tblUsuario";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Usuario usu = new Usuario();
                usu.setId(rs.getInt("id"));
                usu.setAlias(rs.getString("alias"));
                usu.setNombre(rs.getString("nombre"));
                usu.setApellidos(rs.getString("apellidos"));
                usu.setContrasena(rs.getString("contrasena"));
                usu.setEmail(rs.getString("email"));
                list.add(usu);
            }
        } catch (Exception e) {
            
        }
        return list;
    }

    @Override
    public boolean agregar(Usuario u) {
        String sql = "INSERT INTO tblUsuario(alias,nombre,apellidos,contrasena,email)"
                + " VALUES('"+u.getAlias()+"','"+u.getNombre()+"','"
                +u.getApellidos()+"','"+u.getContrasena()+"','"+u.getEmail()+"')";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public Usuario consulta(int id) {
        String sql = "SELECT * FROM tblUsuario WHERE id="+id;
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {              
                u.setId(rs.getInt("id"));
                u.setAlias(rs.getString("alias"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellidos"));
                u.setContrasena(rs.getString("contrasena"));
                u.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            
        }
        return u;
    }

    @Override
    public boolean elimina(int id) {
        String sql = "DELETE FROM tblUsuario WHERE id="+id;
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean modifica(Usuario u) {
        String sql = "UPDATE tblUsuario SET alias='"+u.getAlias()+"',nombre='"
                +u.getNombre()+"',apellidos='"+u.getApellidos()
                +"',contrasena='"+u.getContrasena()+"',email='"+u.getEmail()+"' "
                + "WHERE id="+u.getId();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }   
}