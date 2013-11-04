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
public interface NumComprobanteDao {
    public void insertar(Numcomprobante comp);
    public void actualizar(Numcomprobante comp);
    public void eliminar(Numcomprobante comp);
    public Numcomprobante buscarPorCodigo(int tipo);
    public List<Numcomprobante> buscarConsumo(String cliente);
    public void setSession(Session session);
}
