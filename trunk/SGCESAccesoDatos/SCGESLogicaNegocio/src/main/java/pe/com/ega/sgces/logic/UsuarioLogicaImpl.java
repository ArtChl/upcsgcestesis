/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import org.hibernate.Session;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.dao.UsuarioDao;
import pe.com.ega.sgces.model.Usuario;

/**
 *
 * @author CHRISTIAN
 */
public class UsuarioLogicaImpl implements UsuarioLogica {

    public UsuarioLogicaImpl()
    {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    Session session; 
    UsuarioDao usuarioDao;
    
    public void setTransaccionDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;   
        this.usuarioDao.setSession(session);
    }
    
    public Usuario buscarPorUsuario(Usuario usuario) {
        return usuarioDao.buscarPorUsuario(usuario);
    }

    public void grabar(Usuario usuario) {
        session.beginTransaction();
        if(usuario.getId() == 0)
        {
            usuarioDao.insertar(usuario);
        }
        else{
            usuarioDao.actualizar(usuario);
        }
        session.getTransaction().commit();
    }

    public Usuario buscarPorCodigo(Integer id) {
        return usuarioDao.buscarPorCodigo(id);
    }

    public List<Usuario> buscarTodos() {
        return usuarioDao.buscarTodos();
    }
    
}
