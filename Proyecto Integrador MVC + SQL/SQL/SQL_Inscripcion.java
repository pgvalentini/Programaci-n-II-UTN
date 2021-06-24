/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Modelo.Inscripciones;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pablo Valentini
 */
    public class SQL_Inscripcion extends  Conexion{
    
    private final String SQL_INSERT = "INSERT INTO inscripcion (insc_cod, insc_nombre, insc_fecha, insc_car_cod) VALUES (?,?,?,?)";
    private final String SQL_SELECT = "SELECT * FROM inscripcion";
    private final String SQL_DELETE = "DELETE FROM inscripcion WHERE insc_cod=?";
    private final String SQL_UPDATE = "UPDATE inscripcion SET insc_nombre=?,insc_fecha=?, insc_car_cod=? WHERE insc_cod=?";
  
  
      
    public boolean crear(Inscripciones ins) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) con.prepareStatement(SQL_INSERT);

            ps.setInt(1, ins.getCodigo());
            ps.setString(2, ins.getNombre());
            ps.setDate(3, (Date) ins.getFecha());
            ps.setInt(4, ins.getCarrera().getCodigo());

            ps.executeUpdate();
            System.out.println("Agregado Con éxito");
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al crear : " + e);
            return false;

        } finally {
            Conexion.cerrar(con);
            Conexion.cerrar(ps);
        }
    }

    public ArrayList<Inscripciones> leer() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSetImpl rs = null;
        Inscripciones inscripciones = null;
        ArrayList<Inscripciones> listaInscripcion = new ArrayList<>();
        
        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) conectarse().prepareStatement(SQL_SELECT);
            rs = (ResultSetImpl) ps.executeQuery();

        while (rs.next()) {
                inscripciones = new Inscripciones();
                
                inscripciones.setCodigo(rs.getInt(1));
                inscripciones.setNombre(rs.getString(2));
                inscripciones.setFecha(rs.getDate(3));
                inscripciones.getCarrera().setCodigo((rs.getInt(4)));
                        
                listaInscripcion.add(inscripciones);
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Conexion.cerrar(con);
            Conexion.cerrar(ps);
            Conexion.cerrar(rs);
        }
        return listaInscripcion;
    }

    public boolean actualizar(Inscripciones insc) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) con.prepareStatement(SQL_UPDATE);
            
            ps.setString(1, insc.getNombre());
            ps.setDate(2, (Date) insc.getFecha());
            ps.setInt(3, insc.getCarrera().getCodigo());
            ps.setInt(4, insc.getCodigo());

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

    public boolean eliminar(int codInscripcion) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) con.prepareStatement(SQL_DELETE);
            ps.setInt(1, codInscripcion);
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
            ps = (PreparedStatement) conectarse().prepareStatement("SELECT * FROM carrera");
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

