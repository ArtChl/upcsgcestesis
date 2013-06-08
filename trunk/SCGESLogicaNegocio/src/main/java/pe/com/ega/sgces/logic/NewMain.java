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
       Cliente desp=new Cliente();
       desp.setNumeroDocumento("1");
       desp.setRazonSocial("1");
       desp.setId(1);
       usuariodao.grabar(desp);
    }
}
