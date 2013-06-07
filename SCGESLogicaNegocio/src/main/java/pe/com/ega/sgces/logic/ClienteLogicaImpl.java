/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

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
        if(cliente.getId() == 0)
        {
            clienteDao.insertar(cliente);
        }
        else
        {
            clienteDao.actualizar(cliente);
        }
        session.getTransaction().commit();
    }

    public void eliminar(Cliente cliente) {
        session.beginTransaction();
        clienteDao.eliminar(cliente);
        session.getTransaction().commit();
    }

    public Cliente buscarPorCodigo(Integer id) {
        return clienteDao.buscarPorCodigo(id);
    }
    
}
