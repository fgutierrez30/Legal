/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COTROLADOR;

import DAO.NotebookDAO;
import DAO.PrestamoDAO;
import DTO.NotebookDTO;
import java.io.IOException;
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
            
            String usuario=request.getParameter("cmbUsr");
            String fechaS=request.getParameter("txbFecha");
            Date fecha=new SimpleDateFormat("dd-MM-yy").parse(fechaS);
            
            String equipo=request.getParameter("cmbEquipo");
            
            
            PrestamoDAO nuevoPrestamo=new PrestamoDAO();
            nuevoPrestamo.crearPrestamo(usuario,equipo,fecha);
            NotebookDAO notebook=new NotebookDAO();
            notebook.prestaEquipo(equipo);
            response.sendRedirect("index.jsp");
            
            
        } catch (ParseException ex) {
            Logger.getLogger(NotebookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }


}
