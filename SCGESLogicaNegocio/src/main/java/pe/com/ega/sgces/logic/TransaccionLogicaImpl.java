/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import org.hibernate.Session;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.dao.TransaccionDao;
import pe.com.ega.sgces.dao.TransaccionDetalleDao;
import pe.com.ega.sgces.model.Transaccion;
import pe.com.ega.sgces.model.Transacciondetalle;

/**
 *
 * @author CHRISTIAN
 */
public class TransaccionLogicaImpl implements TransaccionLogica
{
    public TransaccionLogicaImpl()
    {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    Session session; 
    
    TransaccionDao transaccionDao;
    public void setTransaccionDao(TransaccionDao transaccionDao) {
        this.transaccionDao = transaccionDao; 
        this.transaccionDao.setSession(session);
    }
    
    TransaccionDetalleDao transacciondetalleDao;
    public void setTransaccionDetalleDao(TransaccionDetalleDao transacciondetalleDao) {
        this.transacciondetalleDao = transacciondetalleDao; 
        this.transaccionDao.setSession(session);
    }
    
    public void grabar(Transaccion transaccion) {
        session.beginTransaction();
        transaccionDao.insertar(transaccion);
        for (Transacciondetalle detalle : transaccion.getTransacciondetalles()) {
            transacciondetalleDao.insertar(detalle);
        }
        session.getTransaction().commit();
    }

    public Transaccion buscarPorCodigo(Integer id) {
        return transaccionDao.buscarPorCodigo(id);
    }
    
}
