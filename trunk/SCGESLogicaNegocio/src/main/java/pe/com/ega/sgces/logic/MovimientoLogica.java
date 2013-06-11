/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import pe.com.ega.sgces.model.Movimiento;

/**
 *
 * @author FLOPEZ
 */
public interface MovimientoLogica {
    public void grabar(Movimiento movimiento);
    public Movimiento buscarPorCodigo(Integer id);
}
