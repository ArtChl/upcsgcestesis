/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Transaccion;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;


/**
 *
 * @author Flopez
 */
public class DespachoDaoImpl implements DespachoDao{

    Session session;

    public void setSession(Session session) {
        this.session = session;
    }
        
    public void insertar(Transaccion despacho) {
        session.save(despacho);
    }

    public void actualizar(Transaccion  despacho) {
        String query = "update Transaccion set estado=1 where numero="+ despacho.getNumero();
        SQLQuery s=session.createSQLQuery(query);
        s.executeUpdate();
    }

    public void eliminar(Transaccion  despacho) {
        session.delete(despacho);
    }

    public Transaccion  buscarPorCodigo(Integer id) {
        return (Transaccion ) session.load(Transaccion.class, id);
    }

    public List<Transaccion> buscarTodos(Session s) {
         System.out.println("DespachoDao");
         return s.createQuery("from Transaccion where estado='0'").list();
    }
    
}
