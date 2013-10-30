/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.model.Transaccion;
import pe.com.ega.sgces.model.Transacciondetalle;

/**
 *
 * @author Flopez
 */
public class TransaccionDetalleDaoImpl implements TransaccionDetalleDao{

    SessionFactory session;

    @Override
    public void setSession(SessionFactory session) {
        this.session = session;
    }
        
    @Override
    public void insertar(Transacciondetalle detalle) {
        session.getCurrentSession().save(detalle);
    }

    @Override
    public void actualizar(Transacciondetalle detalle) {
        session.getCurrentSession().update(detalle);
    }

    @Override
    public void eliminar(Transacciondetalle detalle) {
        session.getCurrentSession().delete(detalle);
    }

    @Override
    public Transacciondetalle buscraPorCodigo(Integer id) {
        return (Transacciondetalle) session.getCurrentSession().load(Transacciondetalle.class, id);
    }

    @Override
    public List<Transacciondetalle> buscarTodos() {
         session.getCurrentSession().beginTransaction();
         List<Transacciondetalle> lista=session.openSession().createQuery("from Transacciondetalle").list();
         session.getCurrentSession().flush();
         return  lista;
    }
    
}
