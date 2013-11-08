/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import pe.com.ega.sgces.util.Util;
import java.util.List;
import pe.com.ega.sgces.dao.MovimientoDao;
import pe.com.ega.sgces.model.Movimiento;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author FLOPEZ
 */

@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class MovimientoLogicaImpl implements MovimientoLogica {

    private MovimientoDao movimientoDao;

    public MovimientoLogicaImpl() {
    }

    @Override
    public void setMovimientoDao(MovimientoDao movimientoDao) {
        this.movimientoDao = movimientoDao;
    }

    @Override
    public void grabar(Movimiento movimiento) {
        movimientoDao.insertar(movimiento);
    }

    @Override
    @Transactional(readOnly = true)
    public Movimiento buscarPorCodigo(Integer id) {
        return movimientoDao.buscarPorCodigo(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Double buscarMonto(String tipo, String turno) {
        Double monto;

        List lis = movimientoDao.buscarMonto(tipo, turno);
        monto = Util.recuperarNumero(lis);

        return monto;
    }

    @Override
    @Transactional(readOnly = true)
    public Movimiento buscarTransaccion(String transaccion) {
        return movimientoDao.buscarTransaccion(transaccion);
    }

    @Override
    public void eliminar(Movimiento movimiento) {
        movimientoDao.eliminar(movimiento);
    }

    @Override
    @Transactional(readOnly = true)
    public Double buscarMontoVuelto(String tipo, String turno) {
        Double monto;

        List lis = movimientoDao.buscarMontoVuelto(tipo, turno);
        monto = Util.recuperarNumero(lis);

        return monto;
    }
}
