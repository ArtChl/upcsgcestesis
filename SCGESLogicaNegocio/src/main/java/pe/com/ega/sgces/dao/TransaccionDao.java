/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.model.Transaccion;

/**
 *
 * @author Flopez
 */

public interface TransaccionDao {
    public void insertar(Transaccion transaccion);
    public void actualizar(Transaccion transaccion);
    public void eliminar(Transaccion transaccion);
    public Transaccion buscarPorCodigo(Integer id);
    public Transaccion buscarPorNumero(String numero);
    public List<Transaccion> buscarTodos();
    public List<Transaccion> buscarTurno(int turno);
    public List<Transaccion> buscarTodosDoc(String documento);
    public List<Transaccion> buscarListaId(String id);
    public List buscarMonto(String tipo, String turno) ;
    public void setSession(SessionFactory session);
}
