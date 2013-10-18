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

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
        
    @Override
    public void insertar(Transacciondetalle detalle) {
        session.save(detalle);
    }

    @Override
    public void actualizar(Transacciondetalle detalle) {
        session.update(detalle);
    }

    @Override
    public void eliminar(Transacciondetalle detalle) {
        session.delete(detalle);
    }

    @Override
    public Transacciondetalle buscraPorCodigo(Integer id) {
        return (Transacciondetalle) session.load(Transacciondetalle.class, id);
    }

    @Override
    public List<Transacciondetalle> buscarTodos() {
         return session.createQuery("from Transacciondetalle").list();
    }
    
}
