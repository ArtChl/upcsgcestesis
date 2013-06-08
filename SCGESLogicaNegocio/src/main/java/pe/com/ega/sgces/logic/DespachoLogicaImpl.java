/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pe.com.ega.sgces.dao.DespachoDao;
import pe.com.ega.sgces.dao.DespachoDaoImpl;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.model.Despacho;

/**
 *
 * @author CHRISTIAN
 */
public class DespachoLogicaImpl implements DespachoLogica {

    Session session;    
    DespachoDao despachoDao;
    
    public DespachoLogicaImpl()
    {
       session = HibernateUtil.getSessionFactory().openSession();
       
    }
    
    public void setDespachoDao(DespachoDao despachoDao) {
       this.despachoDao= despachoDao;
       this.despachoDao.setSession(session);
       System.out.println("Contrutor");
    }
    
    public void grabar(Despacho despacho) {
        session.beginTransaction();
        if(despacho.getId() == 0) 
        {
           despachoDao.insertar(despacho);
        }
        else{
           despachoDao.actualizar(despacho);
        }
        session.getTransaction().commit();
        session.flush();
        session.close();
    }

    public void eliminar(Despacho despacho) {
        session.beginTransaction();
        despachoDao.eliminar(despacho);
        session.getTransaction().commit();
    }

    public Despacho buscarPorCodigo(Integer id) {
        return despachoDao.buscarPorCodigo(id);
    }

    public List<Despacho> buscarTodos() {      
        return despachoDao.buscarTodos(session);     
    }

}
