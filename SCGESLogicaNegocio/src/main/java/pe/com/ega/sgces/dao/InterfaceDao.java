/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Deposito;
import pe.com.ega.sgces.model.InterfaceConfig;
import pe.com.ega.sgces.model.Turno;

/**
 *
 * @author Flopez
 */
public interface InterfaceDao {
    public void insertar(InterfaceConfig turno);
    public void actualizar(InterfaceConfig turno);
    public InterfaceConfig buscarPorCodigo(int codigo);  
    public void setSession(Session session);
}
