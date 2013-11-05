/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.model.Movimiento;

public class MovimientoDaoImpl implements MovimientoDao {

    private SessionFactory session;

    @Override
    public void setSession(SessionFactory session) {
        this.session = session;
    }

    @Override
    public void insertar(Movimiento movimiento) {
        session.getCurrentSession().save(movimiento);
    }

    @Override
    public void actualizar(Movimiento movimiento) {
        session.getCurrentSession().update(movimiento);
    }

    @Override
    public void eliminar(Movimiento movimiento) {
        session.getCurrentSession().delete(movimiento);
    }

    @Override
    public Movimiento buscarPorCodigo(Integer id) {
        return (Movimiento) session.getCurrentSession().load(Movimiento.class, id);
    }

    @Override
    public Movimiento buscarTurno(String cerrado) {
        return (Movimiento) session.getCurrentSession().load(Movimiento.class, cerrado);
    }

    @Override
    public List buscarMonto(String tipo, String turno) {
        session.getCurrentSession().beginTransaction();
        Query query = session.openSession().createQuery("select sum(montorecibido) from Movimiento where tipo='" + tipo + "' and idturno='" + turno + "'");
        List results = query.list();
        session.getCurrentSession().flush();
        return results;
    }

    @Override
    public Movimiento buscarTransaccion(String transaccion) {
        session.getCurrentSession().beginTransaction();
        Movimiento movimiento = (Movimiento) session.openSession().createQuery("from Movimiento where idtransaccion=" + transaccion).uniqueResult();
        session.getCurrentSession().flush();
        return movimiento;
    }

    @Override
    public List buscarMontoVuelto(String tipo, String turno) {
        session.getCurrentSession().beginTransaction();
        Query query = session.openSession().createQuery("select sum(montodevuelto) from Movimiento where tipo='" + tipo + "' and idturno='" + turno + "'");
        List results = query.list();
        session.getCurrentSession().flush();
        return results;
    }
}
