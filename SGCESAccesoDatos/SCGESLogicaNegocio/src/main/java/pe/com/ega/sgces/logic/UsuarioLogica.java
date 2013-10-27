/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import pe.com.ega.sgces.model.Usuario;

/**
 *
 * @author CHRISTIAN
 */
public interface UsuarioLogica {
    public Usuario buscarPorUsuario(Usuario usuario);
    public void grabar(Usuario usuario);
    public Usuario buscarPorCodigo(Integer id);
    public List<Usuario> buscarTodos();
}
