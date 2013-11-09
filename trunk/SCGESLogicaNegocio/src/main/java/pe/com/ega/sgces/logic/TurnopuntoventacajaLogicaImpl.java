/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.com.ega.sgces.dao.TurnopuntoventacajaDao;
import pe.com.ega.sgces.model.Turnopuntoventacaja;

/**
 *
 * @author Flopez
 */
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class TurnopuntoventacajaLogicaImpl implements TurnopuntoventacajaLogica {

    private TurnopuntoventacajaDao turnopuntoventacajaDao;

    public TurnopuntoventacajaLogicaImpl() {
    }

    public void setTurnopuntoventacajaDao(TurnopuntoventacajaDao turnopuntoventacajaDao) {
        this.turnopuntoventacajaDao = turnopuntoventacajaDao;
    }

    @Override
    public void insertar(Turnopuntoventacaja turno) {
        this.turnopuntoventacajaDao.insertar(turno);
    }
}
