/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Cliente;

/**
 *
 * @author Flopez
 */
public class ClienteDaoImpl implements ClienteDao{

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
            
    @Override
    public void insertar(Cliente cliente) {
        session.save(cliente);
    }

    @Override
    public void actualizar(Cliente cliente) {
        session.update(cliente);
    }

    @Override
    public void eliminar(Cliente cliente) {
        session.delete(cliente);
    }

    @Override
    public Cliente buscarPorCodigo(Integer id) {
        return (Cliente) session.load(Cliente.class, id);
    }

    @Override
    public List<Cliente> buscarTodos() {
         return session.createQuery("from Cliente").list();
    }
   
}
