/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Deposito;
import pe.com.ega.sgces.model.Numcomprobante;
import pe.com.ega.sgces.model.Turno;

/**
 *
 * @author FLOPEZ
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //DespachoDao usuariodao = new DespachoDaoImpl();
       //List <Despacho> lista = usuariodao.buscarTodos();
       //System.out.println("Numero: "+lista.get(1).getMontoSoles());
       /*Transaccion transaccion=new Transaccion();
       //transaccion.setId(2);
       Cliente cliente=new Cliente();
       cliente.setId(1);
       transaccion.setCliente(cliente);
       Despacho detalle = new Despacho();
       detalle.setId(1);
       transaccion.setDespacho(detalle);
       //new Set<Transacciondetalle> myset;
       
      // transaccion.setTransacciondetalles();
       TransaccionDao transdao = new TransaccionDaoImpl();
        try {
            transdao.insertar(transaccion);
        } catch (Exception e) {
            System.out.println("Numero: "+e);
        }
       */
      Session session = null;
       session = HibernateUtil.getSessionFactory().openSession();
       MovimientoDao valedao = new MovimientoDaoImpl();
       DepositoDao despdao = new DepositoDaoImpl();
       valedao.setSession(session);
       despdao.setSession(session);
       
       List lis;
       List lis2;
       String nuevo=null;
       String nuevo2=null;
        try {
            session.beginTransaction();
            lis = valedao.buscarMonto("SOLES", "139");
            nuevo=lis.toString().replace("[", "");
            nuevo=nuevo.replace("]", "");
            System.out.println("Despacho"+lis);
            session.getTransaction().commit(); 
        } catch (Exception ex) {
            nuevo="0";
        }
       
        System.out.println("Despacho"+nuevo);
            
       //Double mov=Double.parseDouble(nuevo);
       //Double dep=Double.parseDouble(nuevo2);
       //Double soles=redondear(100-dep);
       //System.out.println("Despacho"+soles);
       //System.out.println("Despacho"+lis2.toString());
       //valedao.setSession(session);
       //List<Cliente> cliente=usuariodao.razon(1041949242);
      // System.out.println("Cliente"+cliente.get(1).getRazonSocial());
        /*NumComprobante comprobantes= valedao.buscarPorCodigo(1);
        System.out.println(comprobantes.getNumero());
       comprobantes.setNumero(comprobantes.getNumero()+1);
  
        System.out.println(comprobantes.getNumero());
             session.beginTransaction();
            valedao.actualizar(comprobantes);
            session.getTransaction().commit(); 
             
            */
    }
       public static double redondear(double numero) 
       {        
           return Math.rint(numero*100)/100; 
       } 
    
}
