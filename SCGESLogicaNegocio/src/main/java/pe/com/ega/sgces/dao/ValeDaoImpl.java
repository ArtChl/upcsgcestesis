/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pe.com.ega.sgces.model.Vale;

/**
 *
 * @author FLOPEZ
 */
public class ValeDaoImpl implements ValeDao {

    private SessionFactory session;

    @Override
    public void insertar(Vale usuario) {
        Transaction tx;
        tx = session.openSession().beginTransaction();
        usuario.setEstado(1);
        session.openSession().save(usuario);
        tx.commit();

    }

    @Override
    public void actualizar(Vale usuario) {
        session.openSession().update(usuario);
    }

    @Override
    public void eliminar(Vale usuario) {
        session.openSession().delete(usuario);
    }

    @Override
    public Vale buscarPorCodigo(Integer id) {
        return (Vale) session.openSession().load(Vale.class, id);
    }

    @Override
    public List<Vale> buscarTodos(String cliente) {
        return session.openSession().createQuery("from Vale where cliente='" + cliente + "' and estado='1'").list();
    }

    @Override
    public List<Vale> buscarConsumo(String cliente) {
        return session.openSession().createQuery("from Vale where cliente='" + cliente + "'").list();
    }

    @Override
    public void setSession(SessionFactory session) {
        this.session = session;
    }
}
