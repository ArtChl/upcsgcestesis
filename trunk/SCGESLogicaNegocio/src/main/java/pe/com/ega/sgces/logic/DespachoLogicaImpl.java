/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.dao.DespachoDao;
import pe.com.ega.sgces.model.Despacho;

/**
 *
 * @author CHRISTIAN
 */
public class DespachoLogicaImpl implements DespachoLogica {

    private SessionFactory session;
    private DespachoDao despachoDao;

    public DespachoLogicaImpl() {
    }

    @Override
    public void setSession(SessionFactory session) {
        this.session = session;
    }

    @Override
    public void setDespachoDao(DespachoDao despachoDao) {
        this.despachoDao = despachoDao;
    }

    @Override
    public void grabar(Despacho despacho) {
        session.getCurrentSession().beginTransaction();
        if (despacho.getId() == 0) {
            despachoDao.insertar(despacho);
        } else {
            despachoDao.actualizar(despacho);
        }
        session.getCurrentSession().getTransaction().commit();
    }

    @Override
    public void eliminar(Despacho despacho) {
        session.getCurrentSession().beginTransaction();
        despachoDao.eliminar(despacho);
        session.getCurrentSession().getTransaction().commit();
    }

    @Override
    public Despacho buscarPorCodigo(Integer id) {
        return despachoDao.buscarPorCodigo(id);
    }

    @Override
    public List<Despacho> buscarTodos() {
        return despachoDao.buscarTodos();
    }

    @Override
    public void actualizar(Despacho despacho) {
        session.getCurrentSession().beginTransaction();
        despachoDao.actualizar(despacho);
        session.getCurrentSession().getTransaction().commit();
    }
}
