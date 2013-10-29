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
    
    @Override
    public void insertar(Vale usuario) {
        System.out.println("Vale:"+usuario.getCliente());
        Transaction tx;
        tx =session.beginTransaction();
        usuario.setEstado(1);
        session.save(usuario);
        tx.commit();
        
    }

    @Override
    public void actualizar(Vale usuario) {
        session.update(usuario);
    }

    @Override
    public void eliminar(Vale usuario) {
        session.delete(usuario);
    }

    @Override
    public Vale buscarPorCodigo(Integer id) {
        return (Vale) session.load(Vale.class, id);
    }

    @Override
    public List<Vale> buscarTodos(String cliente) {
        return session.createQuery("from Vale where cliente='"+cliente+"' and estado='1'").list();
    }
    
    @Override
    public List<Vale> buscarConsumo(String cliente) {
        return session.createQuery("from Vale where cliente='"+cliente+"'").list();
    }
    
    @Override
    public void setSession(Session session) {
       this.session = session;
    }
    
}
