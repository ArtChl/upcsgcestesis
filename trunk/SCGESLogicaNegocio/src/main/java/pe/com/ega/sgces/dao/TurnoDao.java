/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import org.hibernate.SessionFactory;
import pe.com.ega.sgces.model.Turno;

/**
 *
 * @author Flopez
 */
public interface TurnoDao {
    public void insertar(Turno turno);
    public void actualizar(Turno turno);
    public void eliminar(Turno turno);
    public Turno buscarPorCodigo(String estado);  
    public void setSession(SessionFactory session);
}
