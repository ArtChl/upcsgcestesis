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
public interface ClienteDao {
    public void insertar(Cliente cliente);
    public void actualizar(Cliente cliente);
    public void eliminar(Cliente cliente);
    public Cliente buscarPorCodigo(Integer id);
    public List<Cliente> buscarTodos();   
    public void setSession(SessionFactory session);
}
