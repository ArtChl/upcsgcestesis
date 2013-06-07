/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.dao.ClienteDao;

/**
 *
 * @author CHRISTIAN
 */
public class ClienteLogicaImpl implements ClienteLogica{

    ClienteDao clienteDao;
    public void setClienteDao(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;   
    }
    
    public void grabar(Cliente cliente) {
        if(cliente.getId() == 0)
        {
            clienteDao.insertar(cliente);
        }
        else
        {
            clienteDao.actualizar(cliente);
        }
    }

    public void eliminar(Cliente cliente) {
        clienteDao.eliminar(cliente);
    }

    public Cliente buscarPorCodigo(Integer id) {
        return clienteDao.buscarPorCodigo(id);
    }
    
}
