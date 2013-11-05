/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import org.hibernate.Session;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.dao.ValeDao;
import pe.com.ega.sgces.model.Vale;

/**
 *
 * @author FLOPEZ
 */
public class ValeLogicaImpl implements ValeLogica {

    private Session session;
    private ValeDao valeDao;

    public ValeLogicaImpl() {
        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void setValeDao(ValeDao valeDao) {
        this.valeDao = valeDao;
        this.valeDao.setSession(session);
    }

    @Override
    public void insertar(Vale usuario) {
        session.beginTransaction();
        valeDao.insertar(usuario);
        session.getTransaction().commit();
    }

    @Override
    public void actualizar(Vale usuario) {
        session.beginTransaction();
        valeDao.actualizar(usuario);
        session.getTransaction().commit();
    }

    @Override
    public void eliminar(Vale usuario) {
        session.beginTransaction();
        valeDao.eliminar(usuario);
        session.getTransaction().commit();
    }

    @Override
    public Vale buscarPorCodigo(Integer id) {
        return valeDao.buscarPorCodigo(id);
    }

    @Override
    public List<Vale> buscarTodos(String cliente) {
        return valeDao.buscarTodos(cliente);
    }

    @Override
    public List<Vale> buscarConsumo(String cliente) {
        return valeDao.buscarConsumo(cliente);
    }
}
