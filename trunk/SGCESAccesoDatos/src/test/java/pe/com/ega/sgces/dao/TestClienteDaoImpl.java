/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.Date;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pe.com.ega.sgces.model.Cliente;

/**
 *
 * @author CHRISTIAN
 */
public class TestClienteDaoImpl {
    
    private ClienteDaoImpl clienteDao;
    Session session;
    
    @Before
    public void setUp() {
      clienteDao = new ClienteDaoImpl();
      session = HibernateUtil.getSessionFactory().openSession();
      clienteDao.setSession(session);
    }
    
    @Test
    public void grabarCliente(){
        Cliente cliente = new Cliente();
        cliente.setId(5);
        cliente.setIdTipoDocumento(1);
        cliente.setNumeroDocumento("123456");
        cliente.setRazonSocial("14444");
        cliente.setFechaRegistro(new Date());
        session.beginTransaction();
        clienteDao.insertar(cliente);
        session.beginTransaction().commit();
        
        Assert.assertEquals(1, cliente.getId());
    }
    
}
