/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import pe.com.ega.sgces.model.Usuario;

/**
 *
 * @author Administrador
 */
public interface Usuariodao {
    public Usuario buscarPorUsuario(Usuario usuario);
    public void insertar(Usuario usuario);
    public void actualizar(Usuario usuario);
    public void eliminar(Usuario usuario);
    public Usuario buscraPorId(Integer id);
    public List<Usuario> buscarTodos();
}
