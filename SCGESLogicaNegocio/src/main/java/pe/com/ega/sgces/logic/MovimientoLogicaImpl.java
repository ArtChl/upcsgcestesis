/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import org.hibernate.Session;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.dao.MovimientoDao;
import pe.com.ega.sgces.model.Movimiento;

/**
 *
 * @author FLOPEZ
 */
public class MovimientoLogicaImpl implements MovimientoLogica{

    Session session; 
    MovimientoDao movimientoDao;

    public MovimientoLogicaImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void setMovimientoDao(MovimientoDao movimientoDao) {
        this.movimientoDao = movimientoDao;
        this.movimientoDao.setSession(session);

    }
    
    public void grabar(Movimiento movimiento) {
        session.beginTransaction();
        movimientoDao.insertar(movimiento);
        session.getTransaction().commit(); 
    }

    public Movimiento buscarPorCodigo(Integer id) {
        return movimientoDao.buscarPorCodigo(id);
    }

    
    
}
