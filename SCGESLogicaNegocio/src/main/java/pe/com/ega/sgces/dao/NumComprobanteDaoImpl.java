/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Numcomprobante;

/**
 *
 * @author FLOPEZ
 */
public class NumComprobanteDaoImpl implements NumComprobanteDao {

    private Session session;

    @Override
    public void insertar(Numcomprobante usuario) {
        session.save(usuario);
    }

    @Override
    public void actualizar(Numcomprobante usuario) {
        session.update(usuario);
    }

    @Override
    public void eliminar(Numcomprobante usuario) {
        session.delete(usuario);
    }

    @Override
    public Numcomprobante buscarPorCodigo(int id) {
        return (Numcomprobante) session.load(Numcomprobante.class, id);
    }

    @Override
    public List<Numcomprobante> buscarConsumo(String cliente) {
        return session.createQuery("from Vale where cliente='" + cliente + "' and estado=1").list();
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
}
