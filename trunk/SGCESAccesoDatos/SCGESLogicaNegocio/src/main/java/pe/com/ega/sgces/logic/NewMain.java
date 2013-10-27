/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.Date;
import pe.com.ega.sgces.dao.InterfaceDaoImpl;
import pe.com.ega.sgces.dao.TurnoDaoImpl;
import pe.com.ega.sgces.dao.TurnopuntoventacajaDaoImpl;
import pe.com.ega.sgces.model.Caja;
import pe.com.ega.sgces.model.InterfaceConfig;
import pe.com.ega.sgces.model.Puntoventa;
import pe.com.ega.sgces.model.Turnopuntoventacaja;
import pe.com.ega.sgces.model.TurnopuntoventacajaId;

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
   /*    ArqueoLogicaImpl valedao = new ArqueoLogicaImpl(); 
       //valedao.setSession(session);
        ArrayList<Arqueo> monedas=valedao.buscarPorCodigo("117");
      // System.out.println("Cliente"+cliente.get(1).getRazonSocial());
        for (Arqueo arqueo : monedas) {
            System.out.println(arqueo.getComprobante()+"///"+arqueo.getCantidad());
        }*/
        
        /*
        Session session = null;
       session = HibernateUtil.getSessionFactory().openSession();
       MovimientoLogicaImpl valedao = new MovimientoLogicaImpl(); 
       valedao.setMovimientoDao(new MovimientoDaoImpl());
       Double uno=valedao.buscarMonto("MASTERCARD", "117");
       System.out.println("Monto"+uno);*/
        InterfaceLogicaImpl interfaceLogica =new InterfaceLogicaImpl();
        interfaceLogica.setInterfaceDao(new InterfaceDaoImpl());
        
       InterfaceConfig cierre=interfaceLogica.buscarPorCodigo(1);   
       System.out.println("estado Cem44"+cierre.getCodigo());
        cierre.setCambioturno(1);
        cierre.setFechaTotalizadoresElectronicos(new Date());      
        interfaceLogica.actualizar(cierre);
        
        

    }
}
