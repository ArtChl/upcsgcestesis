/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Usuario;

/**
 *
 * @author Administrador
 */
public class UsuariodaoImpl implements Usuariodao{

    @Override
    public Usuario buscarPorUsuario(Usuario usuario) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        String sql="select u from Usuario u where username=:user and password=:pass";
        Query query= session.createQuery(sql);
        query.setString("user", usuario.getLogin());
        query.setString("pass", usuario.getClave());
        return (Usuario) query.uniqueResult();
    }

    @Override
    public void insertar(Usuario usuario) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(usuario);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Insertar Usuario"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public void actualizar(Usuario usuario) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(usuario);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Actualizar Usuario"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public void eliminar(Usuario usuario) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.delete(usuario);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Eliminar Usuario"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public Usuario buscraPorId(Integer id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        return (Usuario) session.load(Usuario.class, id);
    }

    @Override
    public List<Usuario> buscarTodos() {
        Session session= HibernateUtil.getSessionFactory().openSession();
         return session.createQuery("from Usuario").list();
    }
}