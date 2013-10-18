/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import org.hibernate.Session;
import pe.com.ega.sgces.model.InterfaceConfig;
import pe.com.ega.sgces.model.Turnopuntoventacaja;

/**
 *
 * @author Flopez
 */
public interface TurnopuntoventacajaDao {
    
    public void insertar(Turnopuntoventacaja turno);
    public void setSession(Session session);
    
}
