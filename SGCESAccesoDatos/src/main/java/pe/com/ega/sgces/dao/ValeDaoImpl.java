/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Vale;

/**
 *
 * @author FLOPEZ
 */
public class ValeDaoImpl implements ValeDao{

    Session session;
    public void insertar(Vale usuario) {
        session.save(usuario);
    }

    public void actualizar(Vale usuario) {
        String query = "update cem44.vale set estado=0 where id="+usuario.getId();
        System.out.println("Sentencia:"+query);
        SQLQuery s=session.createSQLQuery(query);
        s.executeUpdate();
    }

    public void eliminar(Vale usuario) {
        session.delete(usuario);
    }

    public Vale buscarPorCodigo(Integer id) {
        return (Vale) session.load(Vale.class, id);
    }

    public List<Vale> buscarTodos(String cliente) {
        return session.createQuery("from Vale where cliente='"+cliente+"' and estado=1").list();
    }
    
    public List<Vale> buscarConsumo(String cliente) {
        return session.createQuery("from Vale where cliente='"+cliente+"' and estado=0").list();
    }
    
    public void setSession(Session session) {
       this.session = session;
    }
    
}
