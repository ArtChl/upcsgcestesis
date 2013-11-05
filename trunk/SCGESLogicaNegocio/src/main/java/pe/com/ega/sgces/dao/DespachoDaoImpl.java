/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.model.Despacho;

/**
 *
 * @author Flopez
 */
public class DespachoDaoImpl implements DespachoDao {

    private SessionFactory session;

    @Override
    public void setSession(SessionFactory session) {
        this.session = session;
    }

    @Override
    public void insertar(Despacho despacho) {
        session.getCurrentSession().save(despacho);
    }

    @Override
    public void actualizar(Despacho despacho) {
        String query = "update despacho set idestado=0 where id=" + despacho.getId();
        SQLQuery s = session.openSession().createSQLQuery(query);
        s.executeUpdate();
    }

    @Override
    public void eliminar(Despacho despacho) {
        session.getCurrentSession().delete(despacho);
    }

    @Override
    public Despacho buscarPorCodigo(Integer id) {
        return (Despacho) session.getCurrentSession().load(Despacho.class, id);
    }

    @Override
    public List<Despacho> buscarTodos() {
        session.getCurrentSession().beginTransaction();
        List<Despacho> lista = session.openSession().createQuery("from Despacho where idestado=1").list();
        session.getCurrentSession().flush();
        return lista;
    }
}
