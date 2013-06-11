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
public class MovimientoDaoImpl implements MovimientoDao{

    Session session;
    
    public void setSession(Session session) {
        this.session = session;
    }
        
   
    public void insertar(Movimiento movimiento) {
        session.save(movimiento);
    }

    public void actualizar(Movimiento movimiento) {
        session.update(movimiento);
    }

    public void eliminar(Movimiento movimiento) {
        session.delete(movimiento);
    }

    public Movimiento buscarPorCodigo(Integer id) {
        return (Movimiento) session.load(Movimiento.class, id);
    }

   
    
}
