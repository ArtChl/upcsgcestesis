/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Model.Transaccion;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Flopez
 */
public interface DespachoDao {
    public void insertar(Transaccion  despacho);
    public void actualizar(Transaccion  despacho);
    public void eliminar(Transaccion  despacho);
    public Transaccion  buscarPorCodigo(Integer id);
    public List<Transaccion> buscarTodos(Session s);
    public void setSession(Session session);
}
