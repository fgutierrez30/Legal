/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COTROLADOR;

import DAO.NotebookDAO;
import DAO.PrestamoDAO;
import DTO.PrestamoDTO;
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
        
        String fechaS=request.getParameter("fechaEntrega");
        String equipo=request.getParameter("nomEquipo");
        try {
            Date fecha=new SimpleDateFormat("dd-MM-yy").parse(fechaS);
            int id=Integer.parseInt(request.getParameter("idPrestamo"));
            PrestamoDAO finPrestamo=new PrestamoDAO();
            finPrestamo.finPrestamo(id, fecha);
            NotebookDAO devolucion=new NotebookDAO();
            devolucion.liberaEquipo(equipo);
            
            response.sendRedirect("libera.jsp");
            
            
        } catch (ParseException ex) {
            Logger.getLogger(PrestamoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


}
