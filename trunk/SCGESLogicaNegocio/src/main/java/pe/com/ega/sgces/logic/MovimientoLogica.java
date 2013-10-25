/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import pe.com.ega.sgces.model.Deposito;
import pe.com.ega.sgces.model.Movimiento;

/**
 *
 * @author FLOPEZ
 */
public interface MovimientoLogica {
    public void grabar(Movimiento movimiento);
    public Movimiento buscarPorCodigo(Integer id);
    public Double buscarMonto(String tipo, String turno);
    public Movimiento buscarTransaccion(String transaccion);
    public void eliminar(Movimiento movimiento);
}
