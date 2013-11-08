/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import pe.com.ega.sgces.util.Util;
import pe.com.ega.sgces.util.ImprimirComprobante;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.com.ega.sgces.dao.TransaccionDao;
import pe.com.ega.sgces.model.Transaccion;

/**
 *
 * @author CHRISTIAN
 */
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class TransaccionLogicaImpl implements TransaccionLogica {

    private TransaccionDao transaccionDao;
    private DespachoLogica despachoLogica;
    private MovimientoLogica movimientoLogica;
    private ImprimirComprobante comprobante;

    public TransaccionLogicaImpl() {
        this.comprobante = new ImprimirComprobante();
    }

    public void setDespachoLogica(DespachoLogica despachoLogica) {
        this.despachoLogica = despachoLogica;
    }

    public void setMovimientoLogica(MovimientoLogica movimientoLogica) {
        this.movimientoLogica = movimientoLogica;
    }

    public void setTransaccionDao(TransaccionDao transaccionDao) {
        this.transaccionDao = transaccionDao;
    }

    @Override
    @Transactional(readOnly = false)
    public void grabar(Transaccion transaccion) {
        transaccionDao.insertar(transaccion);
    }

    @Override
    public Transaccion buscarPorCodigo(Integer id) {
        return transaccionDao.buscarPorCodigo(id);
    }

    @Override
    public List<Transaccion> buscarListaId(String id) {
        return transaccionDao.buscarListaId(id);
    }

    @Override
    public List<Transaccion> buscarTodo() {
        return transaccionDao.buscarTodos();
    }

    @Override
    public List<Transaccion> buscarTodoDoc(String documento) {
        return transaccionDao.buscarTodosDoc(documento);
    }

    @Override
    public Double buscarMonto(String tipo, String turno) {
        Double monto;

        List lis = transaccionDao.buscarMonto(tipo, turno);
        monto = Util.recuperarNumero(lis);

        return monto;
    }

    @Override
    @Transactional(readOnly = false)
    public void actualizar(Transaccion transaccion) {
        transaccionDao.actualizar(transaccion);

        if (transaccion.getAnulado() == true) {
            transaccion.getDespacho().setIdestado(1);
            despachoLogica.actualizar(transaccion.getDespacho());
            movimientoLogica.eliminar(movimientoLogica.buscarTransaccion(String.valueOf(transaccion.getId())));
            comprobante.imprimirAnular(transaccion.getIdtipotransaccion() + "-" + transaccion.getNumerovale(), String.valueOf(transaccion.getMontototal()), "Lopez Cordova");
        }
    }

    @Override
    public List<Transaccion> buscarTurno(int turno) {
        return transaccionDao.buscarTurno(turno);
    }
}
