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
import DTO.NotebookDTO;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "NotebookServlet", urlPatterns = {"/NotebookServlet","/registra"})
public class NotebookServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        NotebookDAO notebook=new NotebookDAO();
        List<NotebookDTO> listaEquipos= notebook.listarNotebook();
        HttpSession sesion=request.getSession();
        sesion.setAttribute("equipos", listaEquipos);
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        try {
            
            UsuarioDAO usr= new UsuarioDAO();
            String usuario=request.getParameter("cmbUsr");
            String fechaS=request.getParameter("txbFecha");
            Date fecha=new SimpleDateFormat("dd-MM-yy").parse(fechaS);
            
            String fechaFormat=DateFormat.getDateInstance().format(fecha);
            
            String equipo=request.getParameter("cmbEquipo");
            
            
            PrestamoDAO nuevoPrestamo=new PrestamoDAO();
            nuevoPrestamo.crearPrestamo(usuario,equipo,fecha);
            NotebookDAO notebook=new NotebookDAO();
            notebook.prestaEquipo(equipo);
            
           
            
            
            String[] nombre=usuario.split(" ");
            String primerNombre="";
            String primerApellido="";
            if(nombre.length==2)
            {
                primerNombre=nombre[0];
                primerApellido=nombre[1];
            }
            else if (nombre.length==3)
            {
                primerNombre=nombre[0]+" "+nombre[1];
                primerApellido=nombre[2];
            }else if (nombre.length==4)
            {
                primerNombre=nombre[0]+" "+nombre[1]+" "+nombre[2];
                primerApellido=nombre[3];
            }else if (nombre.length==5)
            {
                primerNombre=nombre[0]+" "+nombre[1]+" "+nombre[2]+" "+nombre[3];
                primerApellido=nombre[4];
            }            
            
            
            String destinatario=usr.buscarCorreo(primerNombre, primerApellido);
            String asunto="Notebook de Prestamo";
            String cuerpo="Estimado (a) "+usuario+",\n Junto con saludar, confirmamos que ha solicitado el equipo "+ equipo + " con fecha "+fechaFormat;
           /* String aux="fgutierrez@circuloverde.cl";*/
            
            MailDAO mail=new MailDAO();
            mail.enviarConGMail(destinatario, asunto, cuerpo);
            
            MailDAO mailTI=new MailDAO();
            
            String correoTI="fgutierrez@circuloverde.cl";
            String correoTI2="dsantander@circuloverde.cl";
            String cuerpoTI="El usuario "+usuario+" ha solicitado el equipo "+equipo+" con fecha "+fechaFormat;
            
            mailTI.enviarConGMail(correoTI, asunto, cuerpoTI);
            
            MailDAO mailTI2=new MailDAO();
            mailTI2.enviarConGMail(correoTI2, asunto, cuerpoTI);
            
            response.sendRedirect("index.jsp");
            
            
        } catch (ParseException ex) {
            Logger.getLogger(NotebookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }


}
