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
public class DepositoDaoImpl implements DepositoDao{

    @Override
    public void insertar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void eliminar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Cliente buscarPorCodigo(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Cliente> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setSession(Session session) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
