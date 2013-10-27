/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Caja;
import pe.com.ega.sgces.model.Deposito;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.model.Numcomprobante;
import pe.com.ega.sgces.model.Puntoventa;
import pe.com.ega.sgces.model.Turno;
import pe.com.ega.sgces.model.Turnopuntoventacaja;
import pe.com.ega.sgces.model.TurnopuntoventacajaId;

/**
 *
 * @author FLOPEZ
 */
public class NewMain {

    
    public static void main(String[] args) {

        DespachoDao despachoDao=new DespachoDaoImpl();
        despachoDao.setSession(HibernateUtil.sessionFactory.openSession());
        Despacho despacho=despachoDao.buscarPorCodigo(50);
        System.out.println("Despacho"+despacho.getId());
    }
    
}
