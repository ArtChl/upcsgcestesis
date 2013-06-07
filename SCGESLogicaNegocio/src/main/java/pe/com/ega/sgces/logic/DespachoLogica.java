/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import pe.com.ega.sgces.model.Despacho;

/**
 *
 * @author CHRISTIAN
 */
public interface DespachoLogica {
    public void grabar(Despacho despacho);
    public void eliminar(Despacho despacho);
    public Despacho buscarPorCodigo(Integer id);
}
