/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.model.Vale;

/**
 *
 * @author FLOPEZ
 */
public interface ValeDao {
    public void insertar(Vale usuario);
    public void actualizar(Vale usuario);
    public void eliminar(Vale usuario);
    public Vale buscarPorCodigo(Integer id);
    public List<Vale> buscarTodos(String cliente);
    public List<Vale> buscarConsumo(String cliente);
    public void setSession(SessionFactory session);
}
