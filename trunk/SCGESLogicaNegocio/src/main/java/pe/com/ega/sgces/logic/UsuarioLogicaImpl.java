/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import pe.com.ega.sgces.dao.UsuarioDao;
import pe.com.ega.sgces.model.Usuario;

/**
 *
 * @author CHRISTIAN
 */
public class UsuarioLogicaImpl implements UsuarioLogica {

    UsuarioDao usuarioDao;
    public void setTransaccionDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;   
    }
    
    public Usuario buscarPorUsuario(Usuario usuario) {
        return usuarioDao.buscarPorUsuario(usuario);
    }

    public void grabar(Usuario usuario) {
        if(usuario.getId() == 0)
        {
            usuarioDao.insertar(usuario);
        }
        else{
            usuarioDao.actualizar(usuario);
        }
    }

    public Usuario buscarPorCodigo(Integer id) {
        return usuarioDao.buscarPorCodigo(id);
    }
    
}
