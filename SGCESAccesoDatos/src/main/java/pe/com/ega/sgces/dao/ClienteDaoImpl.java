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

    Session session;

    public void setSession(Session session) {
        this.session = session;
    }
            
    public void insertar(Cliente cliente) {
        session.save(cliente);
    }

    public void actualizar(Cliente cliente) {
        session.update(cliente);
    }

    public void eliminar(Cliente cliente) {
        session.delete(cliente);
    }

    public Cliente buscarPorCodigo(Integer id) {
        return (Cliente) session.load(Cliente.class, id);
    }

    public List<Cliente> buscarTodos() {
         return session.createQuery("from Cliente").list();
    }
    
}
