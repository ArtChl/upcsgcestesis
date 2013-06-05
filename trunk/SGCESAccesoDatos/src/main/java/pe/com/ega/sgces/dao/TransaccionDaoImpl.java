/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.model.Transaccion;

/**
 *
 * @author Flopez
 */
public class TransaccionDaoImpl implements TransaccionDao{

    public void insertar(Transaccion transaccion) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(transaccion);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Insertar Transaccion"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    public void actualizar(Transaccion transaccion) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(transaccion);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Actualizar Transaccion"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    public void eliminar(Transaccion transaccion) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.delete(transaccion);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Eliminar Transaccion"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    public Transaccion buscraPorCodigo(Integer id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        return (Transaccion) session.load(Transaccion.class, id);
    }

    public List<Transaccion> buscarTodos() {
        Session session= HibernateUtil.getSessionFactory().openSession();
         return session.createQuery("from Transaccion").list();
    }
    
}
