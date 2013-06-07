/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Transacciondetalle;

/**
 *
 * @author Flopez
 */
public interface TransaccionDetalleDao {
    public void insertar(Transacciondetalle detalle);
    public void actualizar(Transacciondetalle detalle);
    public void eliminar(Transacciondetalle detalle);
    public Transacciondetalle buscraPorCodigo(Integer id);
    public List<Transacciondetalle> buscarTodos(); 
    public void setSession(Session session);
}
