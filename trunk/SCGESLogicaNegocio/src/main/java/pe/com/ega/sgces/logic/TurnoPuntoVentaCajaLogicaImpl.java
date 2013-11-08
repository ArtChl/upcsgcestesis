/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.com.ega.sgces.dao.TurnoPuntoVentaCajaDao;
import pe.com.ega.sgces.model.Turnopuntoventacaja;

/**
 *
 * @author Flopez
 */
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class TurnoPuntoVentaCajaLogicaImpl implements TurnoPuntoVentaCajaLogica {

    private TurnoPuntoVentaCajaDao turnopuntoventacajaDao;

    public TurnoPuntoVentaCajaLogicaImpl() {
    }

    public void setTurnoPuntoVentaCajaDao(TurnoPuntoVentaCajaDao turnopuntoventacajaDao) {
        this.turnopuntoventacajaDao = turnopuntoventacajaDao;
    }

    @Override
    public void insertar(Turnopuntoventacaja turno) {
        this.turnopuntoventacajaDao.insertar(turno);
    }
}
