/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.dao.DespachoDao;
import pe.com.ega.sgces.model.Despacho;

/**
 *
 * @author CHRISTIAN
 */
public interface DespachoLogica {
    public void grabar(Despacho despacho);
    public void eliminar(Despacho despacho);
    public Despacho buscarPorCodigo(Integer id);
    public List<Despacho> buscarTodos();
    public void actualizar(Despacho despacho);
    public void setSession(SessionFactory session);
    public void setDespachoDao(DespachoDao despachoDao);

}
