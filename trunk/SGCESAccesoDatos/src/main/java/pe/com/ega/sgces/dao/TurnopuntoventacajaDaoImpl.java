/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.model.Turnopuntoventacaja;

/**
 *
 * @author Flopez
 */
public class TurnopuntoventacajaDaoImpl implements TurnopuntoventacajaDao{

    SessionFactory session;

    public void setSession(SessionFactory session) {
        this.session = session;
    }
    
    @Override
    public void insertar(Turnopuntoventacaja turno) {
        session.getCurrentSession().save(turno);
    }

    
    
}
