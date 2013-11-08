/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.ArrayList;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.dao.ClienteDao;

/**
 *
 * @author CHRISTIAN
 */
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class ClienteLogicaImpl implements ClienteLogica {

    public ClienteLogicaImpl() {
    }
    private ClienteDao clienteDao;

    public void setClienteDao(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    @Override
    public void grabar(Cliente cliente) {
        clienteDao.insertar(cliente);
    }

    @Override
    public void eliminar(Cliente cliente) {
        clienteDao.eliminar(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente buscarPorCodigo(String id) {
        Cliente razon = null;
        ArrayList<Cliente> clientes = (ArrayList<Cliente>) clienteDao.buscarTodos();
        for (Cliente cliente : clientes) {
            if (id.equalsIgnoreCase(cliente.getNumerodocumento())) {
                razon = cliente;
                break;
            }
        }
        return razon;
    }

    @Override
    public void actualizar(Cliente cliente) {
        clienteDao.actualizar(cliente);
    }
}
