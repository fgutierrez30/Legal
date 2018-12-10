/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legal.presentacion;

import cl.fgutierrez.legal.entidades.Usuario;
import cl.fgutierrez.legal.persistencia.UsuarioSessionBean;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
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
@WebServlet(name = "UsrServlet", urlPatterns = {"/UsrServlet","/usr"})
public class UsrServlet extends HttpServlet {

    @EJB
    private UsuarioSessionBean usrSessionbean;
 
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession(false);
        List<Usuario> listar=usrSessionbean.listarUsr();
        sesion.setAttribute("usuarios", listar);
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

 

}
