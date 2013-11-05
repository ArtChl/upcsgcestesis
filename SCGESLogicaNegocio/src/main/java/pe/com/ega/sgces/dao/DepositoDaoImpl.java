/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.model.Deposito;

/**
 *
 * @author Flopez
 */
public class DepositoDaoImpl implements DepositoDao {

    private SessionFactory session;

    @Override
    public void setSession(SessionFactory session) {
        this.session = session;
    }

    @Override
    public void insertar(Deposito deposito) {
        session.getCurrentSession().save(deposito);
    }

    @Override
    public void actualizar(Deposito deposito) {
        session.getCurrentSession().update(deposito);
    }

    @Override
    public void eliminar(Deposito deposito) {
        session.getCurrentSession().delete(deposito);
    }

    @Override
    public Deposito buscarPorCodigo(Integer id) {
        return (Deposito) session.getCurrentSession().load(Deposito.class, id);
    }

    @Override
    public List<Deposito> buscarTodos() {
        session.getCurrentSession().beginTransaction();
        List<Deposito> lista = session.openSession().createQuery("from Deposito").list();
        session.getCurrentSession().flush();
        return lista;
    }

    @Override
    public List buscarMonto(String tipo, String turno) {
        session.getCurrentSession().beginTransaction();
        Query query = session.openSession().createQuery("select sum(montototal) from Deposito where idtipopago='" + tipo + "' and idturno='" + turno + "'");
        List results = query.list();
        session.getCurrentSession().flush();
        return results;
    }
}
