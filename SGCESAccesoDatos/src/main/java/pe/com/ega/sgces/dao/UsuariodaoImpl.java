/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Usuario;

/**
 *
 * @author Administrador
 */
public class UsuariodaoImpl implements UsuarioDao{

    Session session;

    public void setSession(Session session) {
        this.session = session;
    }
        
    @Override
    public Usuario buscarPorUsuario(Usuario usuario) {
        String sql="select u from Usuario u where login=:user and clave=:pass";
        Query query= session.createQuery(sql);
        query.setString("user", usuario.getLogin());
        query.setString("pass", usuario.getClave());
        return (Usuario) query.uniqueResult();
    }

    @Override
    public void insertar(Usuario usuario) {
        session.save(usuario);
    }

    @Override
    public void actualizar(Usuario usuario) {
        session.update(usuario);
    }

    @Override
    public void eliminar(Usuario usuario) {
        session.delete(usuario);
    }

    @Override
    public Usuario buscarPorCodigo(Integer id) {
        return (Usuario) session.load(Usuario.class, id);
    }

    @Override
    public List<Usuario> buscarTodos() {
         return session.createQuery("from Usuario").list();
    }
}
