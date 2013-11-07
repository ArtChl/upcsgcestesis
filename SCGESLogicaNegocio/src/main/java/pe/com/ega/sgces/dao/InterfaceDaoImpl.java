/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import org.hibernate.SessionFactory;
import pe.com.ega.sgces.model.InterfaceConfig;

/**
 *
 * @author Flopez
 */
public class InterfaceDaoImpl implements InterfaceDao {

    private SessionFactory session;

    @Override
    public void insertar(InterfaceConfig turno) {
        session.getCurrentSession().save(turno);
    }

    @Override
    public void actualizar(InterfaceConfig turno) {
        session.getCurrentSession().update(turno);
    }

    @Override
    public InterfaceConfig buscarPorCodigo(int id) {
        return (InterfaceConfig) session.getCurrentSession().load(InterfaceConfig.class, id);
    }

    @Override
    public void setSession(SessionFactory session) {
        this.session = session;
    }
}
