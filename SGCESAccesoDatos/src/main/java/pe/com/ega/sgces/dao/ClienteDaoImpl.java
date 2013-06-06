/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Cliente;

/**
 *
 * @author Flopez
 */
public class ClienteDaoImpl implements ClienteDao{

    Session session= HibernateUtil.getSessionFactory().openSession();
        
    public void insertar(Cliente cliente) {
        try{
            session.beginTransaction();
            session.save(cliente);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Insertar Cliente"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    public void actualizar(Cliente cliente) {
        try{
            session.beginTransaction();
            session.update(cliente);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Actualizar Cliente"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    public void eliminar(Cliente cliente) {
        try{
            session.beginTransaction();
            session.update(cliente);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Actualizar Cliente"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    public Cliente buscraPorCodigo(Integer id) {
        return (Cliente) session.load(Cliente.class, id);
    }

    public List<Cliente> buscarTodos() {
         return session.createQuery("from Cliente").list();
    }
    
}
