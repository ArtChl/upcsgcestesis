/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.model.Transacciondetalle;

/**
 *
 * @author Flopez
 */
public class TransaccionDetalleDaoImpl implements TransaccionDetalleDao{

    public void insertar(Transacciondetalle detalle) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(detalle);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Insertar Detalle"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    public void actualizar(Transacciondetalle detalle) {
         Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(detalle);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Actualizar Detalle"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    public void eliminar(Transacciondetalle detalle) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.delete(detalle);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Eliminar Detalle"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    public Transacciondetalle buscraPorCodigo(Integer id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        return (Transacciondetalle) session.load(Transacciondetalle.class, id);
    }

    public List<Transacciondetalle> buscarTodos() {
        Session session= HibernateUtil.getSessionFactory().openSession();
         return session.createQuery("from Transacciondetalle").list();
    }
    
}
