/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.model.InterfaceConfig;

/**
 *
 * @author Flopez
 */
public interface InterfaceDao {
    public void insertar(InterfaceConfig turno);
    public void actualizar(InterfaceConfig turno);
    public InterfaceConfig buscarPorCodigo(int codigo);  
    public void setSession(SessionFactory session);
}
