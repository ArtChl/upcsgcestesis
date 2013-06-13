/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Vale;

/**
 *
 * @author FLOPEZ
 */
public interface ValeLogica {
    public void insertar(Vale usuario);
    public void actualizar(Vale usuario);
    public void eliminar(Vale usuario);
    public Vale buscarPorCodigo(Integer id);
    public List<Vale> buscarTodos(String cliente);
    public List<Vale> buscarConsumo(String cliente);
}
