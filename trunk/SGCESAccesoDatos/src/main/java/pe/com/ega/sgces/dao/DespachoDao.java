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
public interface DespachoDao {
    public void insertar(Despacho despacho);
    public void actualizar(Despacho despacho);
    public void eliminar(Despacho despacho);
    public Despacho buscarPorCodigo(Integer id);
    public List<Despacho> buscarTodos(Session s);
    public void setSession(Session session);
    //public void estado(Despacho despacho);
}
