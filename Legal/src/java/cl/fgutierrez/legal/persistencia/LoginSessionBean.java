
package cl.fgutierrez.legal.persistencia;

import cl.fgutierrez.legal.entidades.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class LoginSessionBean {

    @PersistenceContext(unitName = "LegalPU")
    
    private EntityManager em;
    
    public Usuario login (String login, String pass)
    {
        Usuario usr=null; 
        try{
           
         usr=em.createNamedQuery("Usuario.login", Usuario.class).setParameter("login", login).setParameter("pass", pass).getSingleResult();
            
            
        }catch(Exception ex)
        {
            usr=null;
        }
        
        return usr;
    }
    
}
