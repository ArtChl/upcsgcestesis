/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Deposito;

/**
 *
 * @author Flopez
 */
public class DepositoDaoImpl implements DepositoDao{

    Session session;
    
    @Override
    public void insertar(Deposito deposito) {
        session.save(deposito);
    }

    @Override
    public void actualizar(Deposito deposito) {
        session.update(deposito);
    }

    @Override
    public void eliminar(Deposito deposito) {
        session.delete(deposito);
    }

    @Override
    public Deposito buscarPorCodigo(Integer id) {
        return (Deposito) session.load(Deposito.class, id);
    }

    @Override
    public List<Deposito> buscarTodos() {
        return session.createQuery("from Deposito").list();
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
    
}
