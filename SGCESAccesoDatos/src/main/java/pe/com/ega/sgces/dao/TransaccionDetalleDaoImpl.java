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

    Session session= HibernateUtil.getSessionFactory().openSession();
        
    public void insertar(Transacciondetalle detalle) {
        try{
            session.beginTransaction();
            session.save(detalle);
            session.beginTransaction().commit();
        }catch (Exception e){
            session.beginTransaction().rollback();
        }
    }

    public void actualizar(Transacciondetalle detalle) {
        try{
            session.beginTransaction();
            session.update(detalle);
            session.beginTransaction().commit();
        }catch (Exception e){
            session.beginTransaction().rollback();
        }
    }

    public void eliminar(Transacciondetalle detalle) {
        try{
            session.beginTransaction();
            session.delete(detalle);
            session.beginTransaction().commit();
        }catch (Exception e){
            session.beginTransaction().rollback();
        }
    }

    public Transacciondetalle buscraPorCodigo(Integer id) {
        return (Transacciondetalle) session.load(Transacciondetalle.class, id);
    }

    public List<Transacciondetalle> buscarTodos() {
         return session.createQuery("from Transacciondetalle").list();
    }
    
}
