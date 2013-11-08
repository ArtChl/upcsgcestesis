/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.model.Cliente;

/**
 *
 * @author Flopez
 */
public class ClienteDaoImpl implements ClienteDao {

    private SessionFactory session;

    @Override
    public void setSession(SessionFactory session) {
        this.session = session;
    }

    @Override
    public void insertar(Cliente cliente) {
        session.getCurrentSession().save(cliente);
    }

    @Override
    public void actualizar(Cliente cliente) {
        session.getCurrentSession().update(cliente);
    }

    @Override
    public void eliminar(Cliente cliente) {
        session.getCurrentSession().delete(cliente);
    }

    @Override
    public Cliente buscarPorCodigo(Integer id) {
        return (Cliente) session.getCurrentSession().load(Cliente.class, id);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return session.getCurrentSession().createQuery("from Cliente").list();
    }
}
