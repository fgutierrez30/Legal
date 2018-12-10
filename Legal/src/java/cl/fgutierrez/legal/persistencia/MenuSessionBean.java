/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legal.persistencia;

import cl.fgutierrez.legal.entidades.Menu;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fgutierrez
 */
@Stateless
public class MenuSessionBean {

  @PersistenceContext(unitName = "LegalPU")
    
    private EntityManager em;
  
  
  public List<Menu> menuXPerfil(int perfil)
  {
      List<Menu> menu=null;
     try{
         menu=em.createNamedQuery("Menu.findByIdPerfil", Menu.class ).setParameter("perfil", perfil).getResultList();
     } catch(Exception ex)
     {
         menu=null;
     }
     return menu;
  }
  
}
