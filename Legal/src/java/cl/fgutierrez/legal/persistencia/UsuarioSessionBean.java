
package cl.fgutierrez.legal.persistencia;

import cl.fgutierrez.legal.entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class UsuarioSessionBean {

    @PersistenceContext(unitName = "LegalPU")
    
    private EntityManager em;
    
    public List<Usuario> listarUsr()
    {
        List<Usuario>lista=null;
        try{
            
            lista=em.createNamedQuery("Usuario.findAll",Usuario.class).getResultList();
            
        }catch(Exception ex)
        {
            
        }
        return lista;
    }
    
}
