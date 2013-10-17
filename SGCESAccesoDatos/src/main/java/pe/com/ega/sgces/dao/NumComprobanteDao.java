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
public interface NumComprobanteDao {
    public void insertar(NumComprobante comp);
    public void actualizar(NumComprobante comp);
    public void eliminar(NumComprobante comp);
    public NumComprobante buscarPorCodigo(int tipo);
    public List<NumComprobante> buscarConsumo(String cliente);
    public void setSession(Session session);
}
