/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.dao.InterfaceDao;
import pe.com.ega.sgces.model.InterfaceConfig;

/**
 *
 * @author Flopez
 */
public class InterfaceLogicaImpl implements InterfaceLogica {

    private SessionFactory session;
    private InterfaceDao interfaceDao;

    public InterfaceLogicaImpl() {
        
    }

    @Override
    public void setInterfaceDao(InterfaceDao interfaceDao) {
        this.interfaceDao = interfaceDao;

    }

    @Override
    public void insertar(InterfaceConfig turno) {
        session.getCurrentSession().beginTransaction();
        this.interfaceDao.insertar(turno);
        session.getCurrentSession().getTransaction().commit();
    }

    public void setSession(SessionFactory session) {
        this.session = session;
    }

    @Override
    public void actualizar(InterfaceConfig turno) {
        session.getCurrentSession().beginTransaction();
        this.interfaceDao.actualizar(turno);
        session.getCurrentSession().getTransaction().commit();
    }

    @Override
    public InterfaceConfig buscarPorCodigo(int id) {
        return this.interfaceDao.buscarPorCodigo(id);
    }
}
