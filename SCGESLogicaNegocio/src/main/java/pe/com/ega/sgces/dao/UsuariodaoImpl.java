/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.model.Usuario;

/**
 *
 * @author Administrador
 */
public class UsuariodaoImpl implements UsuarioDao {

    private SessionFactory session;

    @Override
    public void setSession(SessionFactory session) {
        this.session = session;
    }

    @Override
    public Usuario buscarPorUsuario(Usuario usuario) {
        session.getCurrentSession().beginTransaction();
        String sql = "select u from Usuario u where login=:user and clave=:pass";
        Query query = session.openSession().createQuery(sql);
        query.setString("user", usuario.getLogin());
        query.setString("pass", usuario.getClave());
        session.getCurrentSession().close();
        return (Usuario) query.uniqueResult();
    }

    @Override
    public void insertar(Usuario usuario) {
        session.getCurrentSession().save(usuario);
    }

    @Override
    public void actualizar(Usuario usuario) {
        session.getCurrentSession().update(usuario);
    }

    @Override
    public void eliminar(Usuario usuario) {
        session.getCurrentSession().delete(usuario);
    }

    @Override
    public Usuario buscarPorCodigo(Integer id) {
        return (Usuario) session.getCurrentSession().load(Usuario.class, id);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return session.getCurrentSession().createQuery("from Usuario").list();
    }
}
