/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.ArrayList;
import org.hibernate.Session;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.dao.MovimientoDaoImpl;
import pe.com.ega.sgces.dao.NumComprobanteDaoImpl;
import pe.com.ega.sgces.model.Arqueo;
import pe.com.ega.sgces.model.Numcomprobante;

/**
 *
 * @author FLOPEZ
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {   
     /*TransaccionLogicaImpl trans=new TransaccionLogicaImpl();
     trans.setTransaccionDao(new TransaccionDaoImpl());
     ArrayList<Transaccion> comprobantes= (ArrayList<Transaccion>) trans.buscarTodoDoc("NDES");
            int i=comprobantes.size();
            System.out.println(comprobantes.size());
            int num=comprobantes.get(i-1).getNumero();*/
       ArqueoLogicaImpl valedao = new ArqueoLogicaImpl(); 
       //valedao.setSession(session);
        ArrayList<Arqueo> monedas=valedao.buscarPorCodigo("117");
      // System.out.println("Cliente"+cliente.get(1).getRazonSocial());
        for (Arqueo arqueo : monedas) {
            System.out.println(arqueo.getComprobante()+"///"+arqueo.getCantidad());
        }
        
        /*
        Session session = null;
       session = HibernateUtil.getSessionFactory().openSession();
       MovimientoLogicaImpl valedao = new MovimientoLogicaImpl(); 
       valedao.setMovimientoDao(new MovimientoDaoImpl());
       Double uno=valedao.buscarMonto("MASTERCARD", "117");
       System.out.println("Monto"+uno);*/
        

    }
}
