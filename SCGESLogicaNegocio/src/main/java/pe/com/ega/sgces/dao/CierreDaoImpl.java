/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Flopez
 */
public class CierreDaoImpl implements CierreDao {

    private SessionFactory session;

    @Override
    public void setSession(SessionFactory session) {
        this.session = session;
    }

    @Override
    public void cierreTurno() {
        String sql = "update InterfaceConfig set cambioturno=1 where codigo=1";
        session.getCurrentSession().createQuery(sql).executeUpdate();

    }

    @Override
    public void cierreDia() {
        String sql = "update InterfaceConfig set cierredia=1 where codigo=1";
        session.getCurrentSession().createQuery(sql).executeUpdate();
    }
}
