/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import org.hibernate.Session;
import pe.com.ega.sgces.model.Deposito;
import pe.com.ega.sgces.model.Turno;

/**
 *
 * @author Flopez
 */
public class TurnoDaoImpl implements  TurnoDao{

    Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
    
    @Override
    public void insertar(Turno turno) {
        session.save(turno);
    }

    @Override
    public void actualizar(Turno turno) {
        session.update(turno);
    }

    @Override
    public void eliminar(Turno turno) {
        session.delete(turno);
    }

    @Override
    public Turno buscarPorCodigo(String estado) {
        return (Turno)session.createQuery("from Turno where estado='"+estado+"'").uniqueResult();
    }

 
    
}
