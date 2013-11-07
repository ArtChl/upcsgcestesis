/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import org.hibernate.Session;
import org.hibernate.annotations.Entity;

/**
 *
 * @author Flopez
 */
@Entity
public interface CierreDao {
    
    public void cierreTurno();
    public void cierreDia();
    public void setSession(Session session);
    
}
