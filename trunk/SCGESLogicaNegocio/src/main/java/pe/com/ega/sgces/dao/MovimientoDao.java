/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.model.Movimiento;

/**
 *
 * @author FLOPEZ
 */

public interface MovimientoDao {
    public void insertar(Movimiento movimiento);
    public void actualizar(Movimiento movimiento);
    public void eliminar(Movimiento movimiento);
    public Movimiento buscarPorCodigo(Integer id);
    public void setSession(SessionFactory session);
    public Movimiento buscarTurno(String cerrado);
    public Movimiento buscarTransaccion(String transaccion);
    public List buscarMonto(String tipo, String turno);
    public List buscarMontoVuelto(String tipo, String turno);
}
