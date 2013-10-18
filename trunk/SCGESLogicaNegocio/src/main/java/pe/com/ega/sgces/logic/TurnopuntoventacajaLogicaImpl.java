/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import org.hibernate.Session;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.dao.TurnopuntoventacajaDao;
import pe.com.ega.sgces.model.Turnopuntoventacaja;

/**
 *
 * @author Flopez
 */
public class TurnopuntoventacajaLogicaImpl implements TurnopuntoventacajaLogica {

    public TurnopuntoventacajaLogicaImpl()
    {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    Session session; 
    TurnopuntoventacajaDao turnopuntoventacajaDao;

    public void setTurnopuntoventacajaDao(TurnopuntoventacajaDao turnopuntoventacajaDao) {
        this.turnopuntoventacajaDao = turnopuntoventacajaDao;
        this.turnopuntoventacajaDao.setSession(session);
    }
    
    @Override
    public void insertar(Turnopuntoventacaja turno) {
        session.beginTransaction();
        this.turnopuntoventacajaDao.insertar(turno);
        session.getTransaction().commit();
    }
    
}
