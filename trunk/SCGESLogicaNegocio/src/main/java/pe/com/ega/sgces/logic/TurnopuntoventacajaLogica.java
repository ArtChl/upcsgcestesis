/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import org.hibernate.SessionFactory;
import pe.com.ega.sgces.dao.TurnopuntoventacajaDao;
import pe.com.ega.sgces.model.Movimiento;
import pe.com.ega.sgces.model.Turnopuntoventacaja;

/**
 *
 * @author FLOPEZ
 */
public interface TurnopuntoventacajaLogica {
    public void insertar(Turnopuntoventacaja caja);
}
