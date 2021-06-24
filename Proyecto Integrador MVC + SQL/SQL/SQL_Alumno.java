/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Modelo.Alumno;
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
    public class SQL_Alumno extends  Conexion{
    private final String SQL_INSERT = "INSERT INTO alumno (alu_dni, alu_nombre,alu_apellido,alu_fec_nac,alu_domicilio, alu_telefono, alu_insc_cod) VALUES (?,?,?,?,?,?,?)";
    private final String SQL_SELECT = "SELECT * FROM alumno";
    private final String SQL_DELETE = "DELETE FROM alumno WHERE alu_dni=?";
    private final String SQL_UPDATE = "UPDATE alumno SET alu_nombre=?,alu_apellido=?,alu_fec_nac=?, alu_domicilio=?,alu_telefono=?,alu_insc_cod=? WHERE alu_dni=?";

  
      
    public boolean crear(Alumno alumno) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) con.prepareStatement(SQL_INSERT);

            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setDate(4, (Date) alumno.getFechaNac());
            ps.setString(5, alumno.getDomicilio());
            ps.setString(6, alumno.getTelefono());
            ps.setInt(7, alumno.getInscripciones().getCodigo());
            
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

    public ArrayList<Alumno> leer() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSetImpl rs = null;
        Alumno alumno;
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) conectarse().prepareStatement(SQL_SELECT);
            rs = (ResultSetImpl) ps.executeQuery();

        while (rs.next()) {
                alumno = new Alumno();

                alumno.setDni(rs.getInt(1));
                alumno.setNombre(rs.getString(2));
                alumno.setApellido(rs.getString(3));
                alumno.setFechaNac(rs.getDate(4));
                alumno.setDomicilio(rs.getString(5));
                alumno.setTelefono(rs.getString(6));
                alumno.getInscripciones().setCodigo((rs.getInt(7)));
            
                listaAlumnos.add(alumno);

            }

        } catch (SQLException e) {

            System.out.println(e);

        } finally {
            Conexion.cerrar(con);
            Conexion.cerrar(ps);
            Conexion.cerrar(rs);
        }
        return listaAlumnos;
    }

    public boolean actualizar(Alumno alumno) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) con.prepareStatement(SQL_UPDATE);
            
            
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setDate(3, (Date) alumno.getFechaNac());
            ps.setString(4, alumno.getDomicilio());
            ps.setString(5, alumno.getTelefono());
            ps.setInt(6, alumno.getInscripciones().getCodigo());
            ps.setInt(7, alumno.getDni());
            
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

    public boolean eliminar(int codAlumno) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) con.prepareStatement(SQL_DELETE);
            ps.setInt(1, codAlumno);
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
    
    public Alumno buscarAlumno(int dniAlumno) {

        PreparedStatement ps = null;
        Connection con = null;
        ResultSetImpl rs = null;
        Alumno alumno = null;

        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) con.prepareStatement(SQL_SELECT);
            ps.setInt(1, dniAlumno);
            rs = (ResultSetImpl)ps.executeQuery();

            while (rs.next()) {
                alumno = new Alumno();
                
                alumno.setDni(rs.getInt(1));
                alumno.setNombre(rs.getString(2));
                alumno.setApellido(rs.getString(3));
                alumno.setFechaNac(rs.getDate(4));
                alumno.setDomicilio(rs.getString(5));
                alumno.setTelefono(rs.getString(6));
                alumno.getInscripciones().setCodigo((rs.getInt(7)));
            
            }

        } catch (SQLException e) {
            System.out.println("Error al Buscar : " + e);

        } finally {
            Conexion.cerrar(con);
            Conexion.cerrar(ps);
            Conexion.cerrar(rs);
        }

        return alumno;
    }
    
    public ArrayList<Integer> llenarCombo() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSetImpl rs = null;
        ArrayList<Integer> lista = new ArrayList<>();
                
        try {
            con = (Connection) Conexion.conectarse();
            ps = (PreparedStatement) conectarse().prepareStatement("SELECT * FROM inscripcion");
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

