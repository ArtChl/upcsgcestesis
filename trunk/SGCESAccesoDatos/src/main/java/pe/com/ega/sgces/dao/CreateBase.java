/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import pe.com.ega.sgces.model.Usuario;

/**
 *
 * @author FLOPEZ
 */
public class CreateBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuariodao usuariodao = new UsuariodaoImpl();
        List<Usuario> usuarios = usuariodao.buscarTodos();
        System.out.println("Numero"+usuarios.size());// TODO code application logic here
    }
}