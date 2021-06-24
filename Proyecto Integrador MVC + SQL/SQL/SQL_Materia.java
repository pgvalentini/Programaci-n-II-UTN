/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;


import Modelo.Materia;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pablo Valentini
 */
    public class SQL_Materia extends  Conexion{
    
    private final String SQL_INSERT = "INSERT INTO materia (mat_cod,mat_nombre, mat_prof_dni) VALUES (?,?,?)";
    private final String SQL_SELECT = "SELECT * FROM materia";
    private final String SQL_DELETE = "DELETE FROM materia WHERE mat_cod=?";
    private final String SQL_UPDATE = "UPDATE materia SET mat_nombre =?, mat_prof_dni=? WHERE mat_cod=?";
   
    
    public boolean crear(Materia materia) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) con.prepareStatement(SQL_INSERT);

            ps.setInt(1, materia.getCodigo());
            ps.setString(2, materia.getNombre());
            ps.setInt(3, materia.getProfesor().getDni());

            ps.executeUpdate();
            System.out.println("Agregado con éxito");
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al crear : " + e);
            return false;

        } finally {
            Conexion.cerrar(con);
            Conexion.cerrar(ps);
        }
    }

    public ArrayList<Materia> leer() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSetImpl rs = null;
        Materia materia=null;
        ArrayList<Materia> listaMaterias = new ArrayList<>();

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) conectarse().prepareStatement(SQL_SELECT);
            rs = (ResultSetImpl) ps.executeQuery();

        while (rs.next()) {
                materia = new Materia();

                materia.setCodigo(rs.getInt(1));
                materia.setNombre(rs.getString(2));
                materia.getProfesor().setDni((rs.getInt(3)));
         
                listaMaterias.add(materia);

            }

        } catch (SQLException e) {

            System.out.println(e);

        } finally {
            Conexion.cerrar(con);
            Conexion.cerrar(ps);
            Conexion.cerrar(rs);
        }
        return listaMaterias;
    }

    public boolean actualizar(Materia materia) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) con.prepareStatement(SQL_UPDATE);

            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getProfesor().getDni());
            ps.setInt(3, materia.getCodigo());
   
            ps.executeUpdate();
            System.out.println("Actualizado con éxito");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al actualizar : " + e);
            return false;

        } finally {

            Conexion.cerrar(con);
            Conexion.cerrar(ps);

        }
    }

     public boolean eliminar(int idMateria) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) con.prepareStatement(SQL_DELETE);
            ps.setInt(1, idMateria);
            ps.executeUpdate();
            System.out.println("Eliminado con éxito");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al eliminar : " + e);
            return false;

        } finally {
            Conexion.cerrar(con);
            Conexion.cerrar(ps);

        }
    }
     

        public ArrayList<Integer> llenarCombo() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSetImpl rs = null;
        ArrayList<Integer> lista = new ArrayList<>();
                
        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) conectarse().prepareStatement("SELECT * FROM profesor");
            rs = (ResultSetImpl) ps.executeQuery();

            while (rs.next()) {
                lista.add(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Conexion.cerrar(con);
            Conexion.cerrar(ps);
            Conexion.cerrar(rs);
        }
        return lista;
    }

}

