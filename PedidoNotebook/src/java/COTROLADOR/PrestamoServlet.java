/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COTROLADOR;

import DAO.MailDAO;
import DAO.NotebookDAO;
import DAO.PrestamoDAO;
import DAO.UsuarioDAO;
import DTO.PrestamoDTO;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fgutierrez
 */
@WebServlet(name = "PrestamoServlet", urlPatterns = {"/PrestamoServlet","/listaPrestamo"})
public class PrestamoServlet extends HttpServlet {

 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         PrestamoDAO prestamo=new PrestamoDAO();
        List<PrestamoDTO> listaPrestamo= prestamo.listarPrestamo();
        HttpSession sesion=request.getSession();
        sesion.setAttribute("prestamos", listaPrestamo);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String equipo=request.getParameter("nomEquipo");
        
            
            java.sql.Date fechaSql=new java.sql.Date(Calendar.getInstance().getTime().getTime());
            int id=Integer.parseInt(request.getParameter("idPrestamo"));
            PrestamoDAO finPrestamo=new PrestamoDAO();
            finPrestamo.finPrestamo(id, fechaSql);
            NotebookDAO devolucion=new NotebookDAO();
            devolucion.liberaEquipo(equipo);
            
            PrestamoDTO prestamo= finPrestamo.pedidoXID(id);
            String[]nombre= prestamo.getUsr().split(" ");
            String nombreFinal="";
            String apellido="";
            
            if(nombre.length==2)
            {
                nombreFinal=nombre[0];
                apellido=nombre[1];
            }else if(nombre.length==3)
            {
                nombreFinal=nombre[0]+" "+nombre[1];
                apellido=nombre[2];
                
            }
            
            UsuarioDAO usr=new UsuarioDAO();
            
            String destinatario=usr.buscarCorreo(nombreFinal, apellido);
            String asunto="Devolucion Notebook";
            String cuerpo="Estimado "+prestamo.getUsr()+",\n Confirmamos devolucion del equipo "+prestamo.getEquipo()+" con fecha "+fechaSql;
            
            
            MailDAO mail=new MailDAO();
            mail.enviarConGMail(destinatario, asunto, cuerpo);
            
            
            response.sendRedirect("libera.jsp");
            
            
        
        
    }


}
