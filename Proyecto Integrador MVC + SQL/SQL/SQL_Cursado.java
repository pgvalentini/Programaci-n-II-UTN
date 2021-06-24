/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;


import Modelo.Cursado;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pablo Valentini
 */
    public class SQL_Cursado extends  Conexion{
    
    private final String SQL_INSERT = "INSERT INTO cursado (cur_alu_dni, cur_mat_cod,cur_nota) VALUES (?,?,?)";
    private final String SQL_SELECT = "SELECT * FROM cursado";
    private final String SQL_DELETE = "DELETE FROM cursado WHERE cur_alu_dni=?";
    private final String SQL_UPDATE = "UPDATE cursado SET cur_nota=? WHERE cur_alu_dni=? AND cur_mat_cod=?";

      
    public boolean crear(Cursado cursado) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) con.prepareStatement(SQL_INSERT);

            ps.setInt(1, cursado.getAlumno().getDni());
            ps.setInt(2, cursado.getMateria().getCodigo());
            ps.setDouble(3, cursado.getNota());

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

    public ArrayList<Cursado> leer() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSetImpl rs = null;
        Cursado cursado;
        ArrayList<Cursado> listaCursado = new ArrayList<>();

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) conectarse().prepareStatement(SQL_SELECT);
            rs = (ResultSetImpl) ps.executeQuery();

        while (rs.next()) {
                cursado = new Cursado();

                cursado.getAlumno().setDni((rs.getInt(1)));
                cursado.getMateria().setCodigo((rs.getInt(2)));
                cursado.setNota(rs.getDouble(3));

                listaCursado.add(cursado);

            }

        } catch (SQLException e) {

            System.out.println(e);

        } finally {
            Conexion.cerrar(con);
            Conexion.cerrar(ps);
            Conexion.cerrar(rs);
        }
        return listaCursado;
    }

    public boolean actualizar(Cursado cursado) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) con.prepareStatement(SQL_UPDATE);

            ps.setDouble(1, cursado.getNota());
            ps.setInt(2, cursado.getAlumno().getDni());       
            ps.setInt(3, cursado.getMateria().getCodigo());       
            

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

     public boolean eliminar(int codCursado) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) con.prepareStatement(SQL_DELETE);
            ps.setInt(1, codCursado);
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
     
    public ArrayList<Integer> llenarComboDni() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSetImpl rs = null;
        ArrayList<Integer> lista = new ArrayList<>();
                
        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) conectarse().prepareStatement("SELECT * FROM alumno");
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
    public ArrayList<Integer> llenarComboMateria() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSetImpl rs = null;
        ArrayList<Integer> lista = new ArrayList<>();
                
        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) conectarse().prepareStatement("SELECT * FROM materia");
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

