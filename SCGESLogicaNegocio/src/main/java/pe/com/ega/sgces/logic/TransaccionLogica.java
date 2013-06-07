/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import pe.com.ega.sgces.model.Transaccion;

/**
 *
 * @author CHRISTIAN
 */
public interface TransaccionLogica {
    public void grabar(Transaccion transaccion);
    public Transaccion buscarPorCodigo(Integer id);
}
