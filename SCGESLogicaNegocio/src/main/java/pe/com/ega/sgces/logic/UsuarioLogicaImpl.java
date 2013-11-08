/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.com.ega.sgces.dao.UsuarioDao;
import pe.com.ega.sgces.model.Usuario;

/**
 *
 * @author CHRISTIAN
 */
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class UsuarioLogicaImpl implements UsuarioLogica {

    public UsuarioLogicaImpl() {
    }
    
    private UsuarioDao usuarioDao;

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    public Usuario buscarPorUsuario(Usuario usuario) {
        return usuarioDao.buscarPorUsuario(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public void grabar(Usuario usuario) {
        if (usuario.getId() == 0) {
            usuarioDao.insertar(usuario);
        } else {
            usuarioDao.actualizar(usuario);
        }
    }

    @Override
    public Usuario buscarPorCodigo(Integer id) {
        return usuarioDao.buscarPorCodigo(id);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioDao.buscarTodos();
    }
}
