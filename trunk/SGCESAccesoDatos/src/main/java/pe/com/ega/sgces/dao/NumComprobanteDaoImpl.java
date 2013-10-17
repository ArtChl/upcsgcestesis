/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Session;
import pe.com.ega.sgces.model.NumComprobante;

/**
 *
 * @author FLOPEZ
 */
public class NumComprobanteDaoImpl implements NumComprobanteDao{

    Session session;
    @Override
    public void insertar(NumComprobante usuario) {
        session.save(usuario);
    }

    @Override
    public void actualizar(NumComprobante usuario) {
        session.update(usuario);
    }

    @Override
    public void eliminar(NumComprobante usuario) {
        session.delete(usuario);
    }

    @Override
    public NumComprobante buscarPorCodigo(int id) {
        return (NumComprobante) session.load(NumComprobante.class, id);
    }
  
    @Override
    public List<NumComprobante> buscarConsumo(String cliente) {
        return session.createQuery("from Vale where cliente='"+cliente+"' and estado=1").list();
    }
    
    @Override
    public void setSession(Session session) {
       this.session = session;
    }
    
}
