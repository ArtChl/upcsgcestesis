/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Transaccion;

/**
 *
 * @author Flopez
 */
public class TransaccionDaoImpl implements TransaccionDao{

    Session session= HibernateUtil.getSessionFactory().openSession();
        
    public void insertar(Transaccion transaccion) {
        try{
            session.beginTransaction();
            session.save(transaccion);
            session.beginTransaction().commit();
        }catch (Exception e){
            session.beginTransaction().rollback();
        }
    }

    public void actualizar(Transaccion transaccion) {
        try{
            session.beginTransaction();
            session.update(transaccion);
            session.beginTransaction().commit();
        }catch (Exception e){
            session.beginTransaction().rollback();
        }
    }

    public void eliminar(Transaccion transaccion) {
        try{
            session.beginTransaction();
            session.delete(transaccion);
            session.beginTransaction().commit();
        }catch (Exception e){
            session.beginTransaction().rollback();
        }
    }

    public Transaccion buscarPorCodigo(Integer id) {
        return (Transaccion) session.load(Transaccion.class, id);
    }

    public List<Transaccion> buscarTodos() {
         return session.createQuery("from Transaccion").list();
    }
    
}
