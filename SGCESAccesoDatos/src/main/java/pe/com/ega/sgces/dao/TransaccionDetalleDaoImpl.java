/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Transacciondetalle;

/**
 *
 * @author Flopez
 */
public class TransaccionDetalleDaoImpl implements TransaccionDetalleDao{

    Session session;

    public void setSession(Session session) {
        this.session = session;
    }
        
    public void insertar(Transacciondetalle detalle) {
        session.save(detalle);
    }

    public void actualizar(Transacciondetalle detalle) {
        session.update(detalle);
    }

    public void eliminar(Transacciondetalle detalle) {
        session.delete(detalle);
    }

    public Transacciondetalle buscraPorCodigo(Integer id) {
        return (Transacciondetalle) session.load(Transacciondetalle.class, id);
    }

    public List<Transacciondetalle> buscarTodos() {
         return session.createQuery("from Transacciondetalle").list();
    }
    
}
