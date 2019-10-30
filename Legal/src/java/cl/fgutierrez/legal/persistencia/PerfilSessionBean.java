/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legal.persistencia;

import cl.fgutierrez.legal.entidades.Perfil;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fgutierrez
 */
@Stateless
public class PerfilSessionBean {

   @PersistenceContext(unitName = "LegalPU")
    
    private EntityManager em;
   
   
   public Perfil perfilXID(int id)
   {
       Perfil perfil=new Perfil();
       
       perfil=em.createNamedQuery("Perfil.findByIdPerfil",Perfil.class).setParameter("idPerfil", id).getSingleResult();
       
       return perfil;
   }
   
   
   
}
