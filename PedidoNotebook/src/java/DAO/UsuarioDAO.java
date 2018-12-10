/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Conexion;
import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fgutierrez
 */
public class UsuarioDAO {
    
    
    public List<UsuarioDTO> listarUsr()
    {
        List<UsuarioDTO>lista=new ArrayList<>();
        
        try
        {
            String select="SELECT Nombres, ApellidoPat, Estado FROM usuarios WHERE Estado=0 ORDER BY Nombres";
            PreparedStatement ps=null;
            Conexion con=new Conexion();
            Connection dbCon=con.conectarMySQL();
            ps=dbCon.prepareStatement(select);
            ResultSet rs=ps.executeQuery();

            while(rs.next())
            {
                UsuarioDTO usuario=new UsuarioDTO();
                usuario.setNombre(rs.getString("Nombres"));
                usuario.setApellido(rs.getString("ApellidoPat"));
                lista.add(usuario);
            }
            
        }catch(Exception ex)
        {
            
        }
        
        return lista;
    }
    
}
