/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import org.hibernate.Session;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.dao.NumComprobanteDao;
import pe.com.ega.sgces.dao.ValeDao;
import pe.com.ega.sgces.model.NumComprobante;
import pe.com.ega.sgces.model.Vale;

/**
 *
 * @author FLOPEZ
 */
public class NumComprobanteLogicaImpl implements NumComprobanteLogica{

    Session session; 
    NumComprobanteDao valeDao;
    
    public NumComprobanteLogicaImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void setValeDao(NumComprobanteDao numDao) {
        this.valeDao = numDao;
        this.valeDao.setSession(session);
    }

    @Override
    public void insertar(NumComprobante numDao) {
        session.beginTransaction();
        valeDao.insertar(numDao);
        session.getTransaction().commit(); 
    }

    @Override
    public void actualizar(NumComprobante numDao) {
        session.beginTransaction();
        valeDao.actualizar(numDao);
        session.getTransaction().commit(); 
    }

    @Override
    public void eliminar(NumComprobante numDao) {
        session.beginTransaction();
        valeDao.eliminar(numDao);
        session.getTransaction().commit(); 
    }
  
    @Override
    public List<NumComprobante> buscarConsumo(String cliente) {
        return valeDao.buscarConsumo(cliente);
    }

    @Override
    public NumComprobante buscarPorCodigo(int tipo) {
        return valeDao.buscarPorCodigo(tipo);
    }
    
    
}
