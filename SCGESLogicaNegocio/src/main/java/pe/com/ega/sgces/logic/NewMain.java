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
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.model.Despacho;

/**
 *
 * @author FLOPEZ
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {   
       ClienteLogicaImpl usuariodao = new ClienteLogicaImpl();
       usuariodao.setClienteDao(new ClienteDaoImpl());  
       Cliente clie=usuariodao.buscarPorCodigo("1041949246");
       System.out.println("Cliente"+clie.getRazonSocial());
    }
}
