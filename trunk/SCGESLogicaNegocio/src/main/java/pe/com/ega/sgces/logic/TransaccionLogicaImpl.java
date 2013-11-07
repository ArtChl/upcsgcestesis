/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import pe.com.ega.sgces.util.Util;
import org.apache.log4j.Logger;
import pe.com.ega.sgces.util.ImprimirComprobante;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import pe.com.ega.sgces.dao.TransaccionDao;
import pe.com.ega.sgces.model.Transaccion;

/**
 *
 * @author CHRISTIAN
 */
@Transactional(readOnly = true)
public class TransaccionLogicaImpl implements TransaccionLogica {

    private final static Logger logger = Logger.getLogger(TransaccionLogicaImpl.class);
    private SessionFactory session;
    private TransaccionDao transaccionDao;
    private DespachoLogica despachoLogica;
    private MovimientoLogica movimientoLogica;
    private ImprimirComprobante comprobante;

    public TransaccionLogicaImpl() {
        this.comprobante = new ImprimirComprobante();
    }

    public void setSession(SessionFactory session) {
        this.session = session;
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
    public void grabar(Transaccion transaccion) {
        session.getCurrentSession().beginTransaction();
        transaccionDao.insertar(transaccion);
        session.getCurrentSession().getTransaction().commit();
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
        try {
            List lis = transaccionDao.buscarMonto(tipo, turno);
            monto = Util.recuperarNumero(lis);
        } catch (Exception ex) {
            logger.error("Mensaje:\n" + ex.getMessage());
            monto = 0.00;
        }
        return monto;
    }

    @Override
    public void actualizar(Transaccion transaccion) {
        try {
            session.getCurrentSession().beginTransaction();
            transaccionDao.actualizar(transaccion);

            if (transaccion.getAnulado() == true) {
                transaccion.getDespacho().setIdestado(1);
                despachoLogica.actualizar(transaccion.getDespacho());
                movimientoLogica.eliminar(movimientoLogica.buscarTransaccion(String.valueOf(transaccion.getId())));
                comprobante.imprimirAnular(transaccion.getIdtipotransaccion() + "-" + transaccion.getNumerovale(), String.valueOf(transaccion.getMontototal()), "Lopez Cordova");
            }

        } catch (Exception e) {
            logger.error("Mensaje:\n" + e.getMessage());
            session.getCurrentSession().getTransaction().rollback();
        } finally {
//            session.getCurrentSession().getTransaction().commit();
        }
    }

    @Override
    public List<Transaccion> buscarTurno(int turno) {
        return transaccionDao.buscarTurno(turno);
    }
}
