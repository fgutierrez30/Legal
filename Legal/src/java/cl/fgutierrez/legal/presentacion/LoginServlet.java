/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legal.presentacion;

import cl.fgutierrez.legal.entidades.Menu;
import cl.fgutierrez.legal.entidades.Usuario;
import cl.fgutierrez.legal.persistencia.LoginSessionBean;
import cl.fgutierrez.legal.persistencia.MenuSessionBean;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fgutierrez
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet","/login"})
public class LoginServlet extends HttpServlet {

 @EJB
 private LoginSessionBean objLoginSessionBean;
 
 @EJB
 private MenuSessionBean objMenuSessionBean;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
 
        HttpSession sesion=request.getSession(false);
        sesion.invalidate();
         
    	response.sendRedirect("index.jsp");
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession(false);
        String usr=request.getParameter("txtUsr");
        String pass=request.getParameter("txtPass");
        
        Usuario usuario=this.objLoginSessionBean.login(usr, pass);
        if(usuario==null)
        {   
            sesion.setAttribute("msgError", "Usuario no existe");
            response.sendRedirect("index.jsp");
        }
        else
        {
            List<Menu> menu=this.objMenuSessionBean.menuXPerfil(usuario.getIdPerfil().getIdPerfil());
            sesion.setAttribute("menu", menu);
            sesion.setAttribute("usrLogin", usuario);
            response.sendRedirect("home.jsp");
        }
        
    }

   

}
