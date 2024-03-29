/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import pe.com.ega.sgces.model.Transaccion;

/**
 *
 * @author CHRISTIAN
 */

public interface TransaccionLogica {
    public void grabar(Transaccion transaccion);
    public void actualizar(Transaccion transaccion);
    public void eliminar(Transaccion transaccion);
    public Transaccion buscarPorCodigo(Integer id);
    public List<Transaccion> buscarListaId(String id);
    public List<Transaccion> buscarTodo();
    public List<Transaccion> buscarTurno(int turno);
    public List<Transaccion> buscarTodoDoc(String documento);
    public Double buscarMonto(String tipo, String turno);
    public Transaccion buscarPorNumero(String numero);
}
