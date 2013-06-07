/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import org.hibernate.Session;
import pe.com.ega.sgces.dao.DespachoDao;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.model.Despacho;

/**
 *
 * @author CHRISTIAN
 */
public class DespachoLogicaImpl implements DespachoLogica {

    public DespachoLogicaImpl()
    {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    Session session;    
    DespachoDao despachoDao;
    public void setDespachoDao(DespachoDao despachoDao) {
        this.despachoDao = despachoDao;         
        this.despachoDao.setSession(session);
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
    }

    public void eliminar(Despacho despacho) {
        session.beginTransaction();
        despachoDao.eliminar(despacho);
        session.getTransaction().commit();
    }

    public Despacho buscarPorCodigo(Integer id) {
        return despachoDao.buscarPorCodigo(id);
    }

}
