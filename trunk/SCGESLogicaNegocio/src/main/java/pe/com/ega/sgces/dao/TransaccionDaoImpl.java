/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import pe.com.ega.sgces.model.Transaccion;

/**
 *
 * @author Flopez
 */
@Repository
public class TransaccionDaoImpl implements TransaccionDao {

    private SessionFactory session;

    @Override
    public void setSession(SessionFactory session) {
        this.session = session;
    }

    @Override
    public void insertar(Transaccion transaccion) {
        transaccion.setFacturado(false);
        transaccion.setAnulado(false);
        session.getCurrentSession().save(transaccion);
    }

    @Override
    public void actualizar(Transaccion transaccion) {
        session.getCurrentSession().update(transaccion);
    }

    @Override
    public void eliminar(Transaccion transaccion) {
        session.getCurrentSession().delete(transaccion);
    }

    @Override
    public Transaccion buscarPorCodigo(Integer id) {
        return (Transaccion) session.getCurrentSession().load(Transaccion.class, id);
    }

    @Override
    public List<Transaccion> buscarTodos() {
        session.getCurrentSession().beginTransaction();
        List<Transaccion> lista;
        lista = session.getCurrentSession().createQuery("from Transaccion").list();
        return lista;
    }

    @Override
    public List<Transaccion> buscarListaId(String id) {
        session.getCurrentSession().beginTransaction();
        List<Transaccion> lista;
        lista = session.getCurrentSession().createQuery("from Transaccion where idcliente='" + id + "' and idtipotransaccion='NDES' and facturado=false and anulado=false").list();
        return lista;
    }

    @Override
    public List<Transaccion> buscarTodosDoc(String documento) {
        session.getCurrentSession().beginTransaction();
        List<Transaccion> lista = session.getCurrentSession().createQuery("from Transaccion where idtipotransaccion='" + documento + "'").list();
        return lista;
    }

    @Override
    public List buscarMonto(String tipo, String turno) {
        session.getCurrentSession().beginTransaction();
        Query query;
        query = session.getCurrentSession().createQuery("select sum(montototal) from Transaccion where producto='" + tipo + "' and idestado='" + turno + "'");
        List results = query.list();
        return results;
    }

    @Override
    public List<Transaccion> buscarTurno(int turno) {
        session.getCurrentSession().beginTransaction();
        List<Transaccion> lista;
        lista = session.getCurrentSession().createQuery("from Transaccion where idestado=" + turno + " and anulado=false").list();
        return lista;
    }

    @Override
    public Transaccion buscarPorNumero(String numero) {
        session.getCurrentSession().beginTransaction();
        Transaccion trans;
        trans = (Transaccion) session.getCurrentSession().createQuery("from Transaccion where numerovale='" + numero + "'").uniqueResult();
        return trans;
    }
}
