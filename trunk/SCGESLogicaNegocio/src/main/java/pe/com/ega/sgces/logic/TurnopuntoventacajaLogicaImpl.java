/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import org.hibernate.SessionFactory;
import pe.com.ega.sgces.dao.TurnopuntoventacajaDao;
import pe.com.ega.sgces.model.Turnopuntoventacaja;

/**
 *
 * @author Flopez
 */
public class TurnopuntoventacajaLogicaImpl implements TurnopuntoventacajaLogica {

    private SessionFactory session; 
    private TurnopuntoventacajaDao turnopuntoventacajaDao;
    
    public TurnopuntoventacajaLogicaImpl()
    {
    }
    
    public void setSession(SessionFactory session) {
        this.session = session;
    }

    public void setTurnopuntoventacajaDao(TurnopuntoventacajaDao turnopuntoventacajaDao) {
        this.turnopuntoventacajaDao = turnopuntoventacajaDao;
    }
    
    @Override
    public void insertar(Turnopuntoventacaja turno) {
        session.getCurrentSession().beginTransaction();
        this.turnopuntoventacajaDao.insertar(turno);
        session.getCurrentSession().getTransaction().commit();
    }
    
}
