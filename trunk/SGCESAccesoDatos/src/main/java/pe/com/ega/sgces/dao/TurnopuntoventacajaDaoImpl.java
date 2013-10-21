/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Turnopuntoventacaja;

/**
 *
 * @author Flopez
 */
public class TurnopuntoventacajaDaoImpl implements TurnopuntoventacajaDao{

    Session session;

    
    @Override
    public void insertar(Turnopuntoventacaja turno) {
        session.save(turno);
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
    
}
