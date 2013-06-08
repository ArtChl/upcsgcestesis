/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.ArrayList;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.dao.ClienteDao;
import pe.com.ega.sgces.dao.ClienteDaoImpl;
import pe.com.ega.sgces.dao.HibernateUtil;

/**
 *
 * @author CHRISTIAN
 */
public class ClienteLogicaImpl implements ClienteLogica{

    public ClienteLogicaImpl()
    {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    Session session;
    ClienteDao clienteDao;
    public void setClienteDao(ClienteDao clienteDao) {
        this.clienteDao = clienteDao; 
        this.clienteDao.setSession(session);
    }
    
    public void grabar(Cliente cliente) {
        session.beginTransaction();
        clienteDao.insertar(cliente);   
        session.getTransaction().commit();
    }

    public void eliminar(Cliente cliente) {
        session.beginTransaction();
        clienteDao.eliminar(cliente);
        session.getTransaction().commit();
    }

    public Cliente buscarPorCodigo(String id) {
        Cliente razon=null;
        ArrayList<Cliente> clientes=(ArrayList<Cliente>) clienteDao.buscarTodos();
        for (Cliente cliente : clientes) {
            if(id.equalsIgnoreCase(cliente.getNumeroDocumento())){
                razon=cliente;
                break;
            }
        }
        return razon;
    }

    public void actualizar(Cliente cliente) {
        session.beginTransaction();
        clienteDao.actualizar(cliente);   
        session.getTransaction().commit();
    }
    
}
