/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Modelo.Carrera;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pablo Valentini
 */
    public class SQL_Carrera extends  Conexion{
    
    private final String SQL_INSERT = "INSERT INTO carrera (car_cod, car_nombre,car_duracion) VALUES (?,?,?)";
    private final String SQL_SELECT = "SELECT * FROM carrera";
    private final String SQL_DELETE = "DELETE FROM carrera WHERE car_cod=?";
    private final String SQL_UPDATE = "UPDATE carrera SET car_nombre=?,car_duracion=? WHERE car_cod=?";

  
    public boolean crear(Carrera carrera) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) con.prepareStatement(SQL_INSERT);

            ps.setInt(1, carrera.getCodigo());
            ps.setString(2, carrera.getNombre());
            ps.setString(3, carrera.getDuracion());

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

    public ArrayList<Carrera> leer() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSetImpl rs = null;
        Carrera carrera;
        ArrayList<Carrera> listaCarrera = new ArrayList<>();

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) conectarse().prepareStatement(SQL_SELECT);
            rs = (ResultSetImpl) ps.executeQuery();

        while (rs.next()) {
                carrera = new Carrera();
                carrera.setCodigo(rs.getInt(1));
                carrera.setNombre(rs.getString(2));
                carrera.setDuracion(rs.getString(3));
                listaCarrera.add(carrera);
            }

        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            Conexion.cerrar(con);
            Conexion.cerrar(ps);
            Conexion.cerrar(rs);
        }
        return listaCarrera;
    }

    public boolean actualizar(Carrera carrera) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) con.prepareStatement(SQL_UPDATE);

            ps.setString(1, carrera.getNombre());
            ps.setString(2, carrera.getDuracion());
            ps.setInt(3, carrera.getCodigo());
            
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

    public boolean eliminar(int codCarrera) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) con.prepareStatement(SQL_DELETE);
            ps.setInt(1, codCarrera);
            ps.executeUpdate();
            System.out.println("Eliminado con éxito");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al éliminar : " + e);
            return false;

        } finally {
            Conexion.cerrar(con);
            Conexion.cerrar(ps);

        }
    }
    
}

