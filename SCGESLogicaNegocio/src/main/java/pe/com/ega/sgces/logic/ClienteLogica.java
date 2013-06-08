/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import pe.com.ega.sgces.model.Cliente;
/**
 *
 * @author CHRISTIAN
 */
public interface ClienteLogica {
    public void grabar(Cliente cliente);
    public void actualizar(Cliente cliente);
    public void eliminar(Cliente cliente);
    public Cliente buscarPorCodigo(String id);
}
