/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pe.com.ega.sgces.dao.ClienteDao;
import pe.com.ega.sgces.dao.ClienteDaoImpl;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.dao.UsuariodaoImpl;
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.model.Usuario;

/**
 *
 * @author FLOPEZ
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {   
       UsuarioLogicaImpl usuariodao = new UsuarioLogicaImpl();
       usuariodao.setTransaccionDao(new UsuariodaoImpl());  
       Usuario cli=new Usuario();
       cli.setLogin("admin");
       cli.setClave("admin");
       Usuario usu=usuariodao.buscarPorUsuario(cli);
       System.out.println("Cliente"+usu.getLogin());
    }
}
