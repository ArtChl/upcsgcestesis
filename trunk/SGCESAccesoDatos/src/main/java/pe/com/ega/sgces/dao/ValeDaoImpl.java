/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pe.com.ega.sgces.model.Vale;

/**
 *
 * @author FLOPEZ
 */
public class ValeDaoImpl implements ValeDao{

    Session session;
    public void insertar(Vale usuario) {
       // Transaction tx;
       // tx =session.beginTransaction();
        usuario.setEstado(1);
        session.save(usuario);
       // tx.commit();
        System.out.println("Vale:"+usuario.getCliente());
    }

    public void actualizar(Vale usuario) {
        session.update(usuario);
    }

    public void eliminar(Vale usuario) {
        session.delete(usuario);
    }

    public Vale buscarPorCodigo(Integer id) {
        return (Vale) session.load(Vale.class, id);
    }

    public List<Vale> buscarTodos(String cliente) {
        return session.createQuery("from Vale where cliente='"+cliente+"'").list();
    }
    
    public List<Vale> buscarConsumo(String cliente) {
        return session.createQuery("from Vale where cliente='"+cliente+"'").list();
    }
    
    public void setSession(Session session) {
       this.session = session;
    }
    
}
