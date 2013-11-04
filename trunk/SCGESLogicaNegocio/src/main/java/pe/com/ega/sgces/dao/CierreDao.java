/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import org.hibernate.Session;
import pe.com.ega.sgces.model.InterfaceConfig;

/**
 *
 * @author Flopez
 */
public interface CierreDao {
    
    public void cierreTurno();
    public void cierreDia();
    public void setSession(Session session);
    
}
