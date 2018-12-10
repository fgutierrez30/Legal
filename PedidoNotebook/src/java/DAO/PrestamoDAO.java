/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Conexion;
import DTO.PrestamoDTO;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fgutierrez
 */
public class PrestamoDAO {
    
    public void crearPrestamo(String usr, String equipo, Date fechaPrestamo)
    {
        try
        {
            String select="INSERT INTO prestamo_notebook (usuario,equipo,fecha_solicitud) VALUES (?,?,?)";
            PreparedStatement ps=null;
            Conexion con=new Conexion();
            Connection dbCon=con.conectarMySQL();
            ps=dbCon.prepareStatement(select);
            ps.setString(1, usr);
            java.sql.Date fecha= new java.sql.Date(fechaPrestamo.getTime());
            ps.setString(2, equipo);
            ps.setDate(3,fecha);
            ps.executeUpdate();
            
        }catch(Exception ex)
        {
            
        }
        
    }
    
    
    public List<PrestamoDTO> listarPrestamo()
    {
        List<PrestamoDTO> lista=new ArrayList<>();
        
        try
        {
           String select="SELECT id_prestamo,usuario,equipo,fecha_solicitud FROM prestamo_notebook WHERE estado_prestamos=0";
           PreparedStatement ps=null;
           Conexion con=new Conexion();
           Connection dbCon=con.conectarMySQL();
           ps=dbCon.prepareStatement(select);
           ResultSet rs=ps.executeQuery();
           
           
           while (rs.next())
           {
               PrestamoDTO prestamo=new PrestamoDTO();
               int id=rs.getInt("id_prestamo");
               prestamo.setId(id);
               String nombre=rs.getString("usuario");
               prestamo.setUsr(nombre);
               String equipo=rs.getString("equipo");
               prestamo.setEquipo(equipo);
               Date fechaSolicitud=rs.getDate("fecha_solicitud");
               prestamo.setFechaPedido(fechaSolicitud);
               lista.add(prestamo);
               
           }
           
            
        }catch(Exception e)
        {
            
        }
        
        return lista;
    }
    
    
    public void finPrestamo(int id, Date fechaEntrega)
    {
        try{
            
            String update="UPDATE prestamo_notebook set estado_prestamos=1, fecha_entrega=? WHERE id_prestamo=?";
            Conexion con=new Conexion();
            Connection dbCon=con.conectarMySQL();
            PreparedStatement ps=dbCon.prepareStatement(update);
            java.sql.Date fecha= new java.sql.Date(fechaEntrega.getTime());
            ps.setDate(1, fecha);
            ps.setInt(2, id);
            ps.executeUpdate();
            
        }catch(Exception e)
        {
            
        }
    }
}
