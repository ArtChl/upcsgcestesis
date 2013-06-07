/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pe.com.ega.sgces.model.Cliente;

/**
 *
 * @author CHRISTIAN
 */
public class TestClienteDaoImpl {
    
    private ClienteDao clienteDao;
    
    @Before
    public void setUp() {
      clienteDao = new ClienteDaoImpl();
    }
    
    @Test
    public void grabarUsuario(){
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setIdTipoDocumento(1);
        cliente.setNumeroDocumento("123456");
        cliente.setRazonSocial("14444");
        cliente.setFechaRegistro(new Date());
        clienteDao.insertar(cliente);
        
        Assert.assertEquals(1, cliente.getId());
    }
    
}
