/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import org.hibernate.Session;
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
    public void setSession(Session session);
    public Movimiento buscarTurno(String cerrado);
}
