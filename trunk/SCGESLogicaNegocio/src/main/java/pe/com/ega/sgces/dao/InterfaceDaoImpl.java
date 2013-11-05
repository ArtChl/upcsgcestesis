/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import org.hibernate.Session;
import pe.com.ega.sgces.model.InterfaceConfig;

/**
 *
 * @author Flopez
 */
public class InterfaceDaoImpl implements InterfaceDao {

    private Session session;

    @Override
    public void insertar(InterfaceConfig turno) {
        session.save(turno);
    }

    @Override
    public void actualizar(InterfaceConfig turno) {
        session.update(turno);
    }

    @Override
    public InterfaceConfig buscarPorCodigo(int id) {
        return (InterfaceConfig) session.load(InterfaceConfig.class, id);
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
}
