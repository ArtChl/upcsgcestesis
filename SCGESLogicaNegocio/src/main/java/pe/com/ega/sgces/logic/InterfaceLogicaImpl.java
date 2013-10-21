/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import org.hibernate.Session;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.dao.InterfaceDao;
import pe.com.ega.sgces.model.InterfaceConfig;
import pe.com.ega.sgces.model.Turno;

/**
 *
 * @author Flopez
 */
public class InterfaceLogicaImpl implements InterfaceLogica{

    Session session; 
    InterfaceDao interfaceDao;

    public InterfaceLogicaImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void setInterfaceDao(InterfaceDao interfaceDao) {
        this.interfaceDao = interfaceDao;
        this.interfaceDao.setSession(session);

    }
    
    @Override
    public void insertar(InterfaceConfig turno) {
        session.beginTransaction();
        this.interfaceDao.insertar(turno);
        session.getTransaction().commit();
    }

    @Override
    public void actualizar(InterfaceConfig turno) {
        session.beginTransaction();
        this.interfaceDao.actualizar(turno);
        session.getTransaction().commit();
    }

    @Override
    public InterfaceConfig buscarPorCodigo(int codigo) {
        return this.interfaceDao.buscarPorCodigo(codigo);
    }
    
}