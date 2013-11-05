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
public class TurnoDaoImpl implements  TurnoDao{

    private SessionFactory session;

    @Override
    public void setSession(SessionFactory session) {
        this.session = session;
    }
    
    @Override
    public void insertar(Turno turno) {
        session.getCurrentSession().save(turno);
    }

    @Override
    public void actualizar(Turno turno) {
        session.getCurrentSession().saveOrUpdate(turno);
    }

    @Override
    public void eliminar(Turno turno) {
        session.getCurrentSession().delete(turno);
    }

    @Override
    public Turno buscarPorCodigo(String estado) {
        session.getCurrentSession().beginTransaction();
        Turno turno;
        turno = (Turno)session.getCurrentSession().createQuery("from Turno where estado='"+estado+"'").uniqueResult();
        session.close();
        return turno;
    } 
}
