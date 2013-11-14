/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import pe.com.ega.sgces.model.Numcomprobante;

/**
 *
 * @author FLOPEZ
 */
@Repository
public class NumComprobanteDaoImpl implements NumComprobanteDao {

    private SessionFactory session;

    @Override
    public void insertar(Numcomprobante usuario) {
        session.getCurrentSession().save(usuario);
    }

    @Override
    public void actualizar(Numcomprobante usuario) {
        session.getCurrentSession().update(usuario);
        
    }

    @Override
    public void eliminar(Numcomprobante usuario) {
        session.getCurrentSession().delete(usuario);
    }

    @Override
    public Numcomprobante buscarPorCodigo(int id) {
        session.getCurrentSession().beginTransaction();
        Numcomprobante num;
        num = (Numcomprobante) session.openSession().load(Numcomprobante.class, id);
        session.close();
        return num;
     
    }

    @Override
    public List<Numcomprobante> buscarConsumo(String cliente) {
        return session.getCurrentSession().createQuery("from Vale where cliente='" + cliente + "' and estado=1").list();
    }

    @Override
    public void setSession(SessionFactory session) {
        this.session = session;
    }
    
    public SessionFactory getSession() {
        return session;
    }

    
    public void insertarVale(Numcomprobante usuario) {
        Transaction tx=session.getCurrentSession().beginTransaction();
        tx.begin();
        session.getCurrentSession().save(usuario);
        tx.commit();
    }


    public void actualizarVale(Numcomprobante usuario) {
        Transaction tx=session.getCurrentSession().beginTransaction();
        tx.begin();
        session.getCurrentSession().update(usuario);
        tx.commit();
        
    }
}
