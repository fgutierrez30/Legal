/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Conexion;
import DTO.NotebookDTO;
import DTO.PrestamoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author fgutierrez
 */
public class NotebookDAO {
    
     
    public List<NotebookDTO> listarNotebook()
    {
       List<NotebookDTO> lista=new ArrayList<>();
               
       
      
       try
       {
            
           
           String select="SELECT id_note,nom_note,estado_note FROM notebook WHERE estado_note=0";
           PreparedStatement ps=null;
           Conexion con=new Conexion();
           Connection dbCon=con.conectarMySQL();
           ps=dbCon.prepareStatement(select);
           ResultSet rs=ps.executeQuery();
          
           
           while (rs.next())
           {
               NotebookDTO notebook=new NotebookDTO();
               int id=rs.getInt("id_note");
               notebook.setId(id);
               String nombre=rs.getString("nom_note");
               notebook.setNombre(nombre);
               int estado=rs.getInt("estado_note");
               notebook.setEstado(estado);
               lista.add(notebook);
               
           }
           
         
           
       }catch(Exception ex)
       {
           
       }
       
       return lista;
       
    }
    
    public void prestaEquipo(String nombre)
    {
        try{
            
            String update="UPDATE notebook set estado_note=1 WHERE nom_note=?";
            Conexion con=new Conexion();
            Connection dbCon=con.conectarMySQL();
            PreparedStatement ps=dbCon.prepareStatement(update);
            ps.setString(1, nombre);
            ps.executeUpdate();
            
        }catch(Exception e)
        {
            
        }
    }
    
    
    public void liberaEquipo(String nombre)
    {
        try{
            
            String update="UPDATE notebook set estado_note=0 WHERE nom_note=?";
            Conexion con=new Conexion();
            Connection dbCon=con.conectarMySQL();
            PreparedStatement ps=dbCon.prepareStatement(update);
            ps.setString(1, nombre);
            ps.executeUpdate();
            
        }catch(Exception e)
        {
            
        }
        
    }
    
   
    
}
