/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Despacho;

/**
 *
 * @author Flopez
 */
public class DespachoDaoImpl implements DespachoDao{

    Session session= HibernateUtil.getSessionFactory().openSession();
        
    public void insertar(Despacho despacho) {
        try{
            session.beginTransaction();
            session.save(despacho);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Insertar Despacho"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    public void actualizar(Despacho despacho) {
        try{
            session.beginTransaction();
            session.update(despacho);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Actualizar Despacho"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    public void eliminar(Despacho despacho) {
        try{
            session.beginTransaction();
            session.delete(despacho);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Eliminar Despacho"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    public Despacho buscraPorCodigo(Integer id) {
        return (Despacho) session.load(Despacho.class, id);
    }

    public List<Despacho> buscarTodos() {
         return session.createQuery("from Despacho").list();
    }
    
}
