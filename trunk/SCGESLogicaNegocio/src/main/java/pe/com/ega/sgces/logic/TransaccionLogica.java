/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import pe.com.ega.sgces.model.Transaccion;

/**
 *
 * @author CHRISTIAN
 */
public interface TransaccionLogica {
    public void grabar(Transaccion transaccion);
    public Transaccion buscarPorCodigo(Integer id);
    public List<Transaccion> buscarListaId(String id);
    public List<Transaccion> buscarTodo();
    public List<Transaccion> buscarTodoDoc(String documento);
    public Double buscarMonto(String tipo, String turno);
}
