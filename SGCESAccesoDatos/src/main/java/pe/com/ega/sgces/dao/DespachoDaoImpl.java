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

    Session session;

    public void setSession(Session session) {
        this.session = session;
    }
        
    public void insertar(Despacho despacho) {
        session.save(despacho);
    }

    public void actualizar(Despacho despacho) {
        session.update(despacho);
    }

    public void eliminar(Despacho despacho) {
        session.delete(despacho);
    }

    public Despacho buscarPorCodigo(Integer id) {
        return (Despacho) session.load(Despacho.class, id);
    }

    public List<Despacho> buscarTodos() {
         return session.createQuery("from Despacho").list();
    }
    
}
