/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Modelo.Profesor;
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
    public class SQL_Profesor extends  Conexion{
    
    private final String SQL_INSERT = "INSERT INTO profesor (prof_dni, prof_nombre,prof_apellido,prof_fec_nac,prof_domicilio, prof_telefono) VALUES (?,?,?,?,?,?)";
    private final String SQL_SELECT = "SELECT * FROM profesor";
    private final String SQL_DELETE = "DELETE FROM profesor WHERE prof_dni=?";
    private final String SQL_UPDATE = "UPDATE profesor SET prof_nombre=?,prof_apellido=?,prof_fec_nac=?,prof_domicilio=?, prof_telefono=? WHERE prof_dni=?";
   
    
    public boolean crear(Profesor profe) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) con.prepareStatement(SQL_INSERT);
            
            ps.setInt(1, profe.getDni());
            ps.setString(2, profe.getNombre());
            ps.setString(3, profe.getApellido());
            ps.setDate(4, (Date) profe.getFechaNac());
            ps.setString(5, profe.getDomicilio());
            ps.setString(6, profe.getTelefono());

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

    public ArrayList<Profesor> leer() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSetImpl rs = null;
        Profesor profesor;
        ArrayList<Profesor> listaProfesor = new ArrayList<>();

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) conectarse().prepareStatement(SQL_SELECT);
            rs = (ResultSetImpl) ps.executeQuery();

        while (rs.next()) {
                profesor = new Profesor();

                profesor.setDni(rs.getInt(1));
                profesor.setNombre(rs.getString(2));
                profesor.setApellido(rs.getString(3));
                profesor.setFechaNac(rs.getDate(4));
                profesor.setDomicilio(rs.getString(5));
                profesor.setTelefono(rs.getString(6));


                listaProfesor.add(profesor);

            }

        } catch (SQLException e) {

            System.out.println(e);

        } finally {
            Conexion.cerrar(con);
            Conexion.cerrar(ps);
            Conexion.cerrar(rs);
        }
        return listaProfesor;
    }

    public boolean actualizar(Profesor profe) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) con.prepareStatement(SQL_UPDATE);

            ps.setString(1, profe.getNombre());
            ps.setString(2, profe.getApellido());
            ps.setDate(3, (Date) profe.getFechaNac());
            ps.setString(4, profe.getDomicilio());
            ps.setString(5, profe.getTelefono());
            ps.setInt(6, profe.getDni());

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

 public boolean eliminar(int idProf) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) con.prepareStatement(SQL_DELETE);
            ps.setInt(1, idProf);
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
  

}

