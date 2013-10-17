/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import org.hibernate.Session;
import pe.com.ega.sgces.model.NumComprobante;

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
       CierreDao valedao = new CierreDaoImpl();
       valedao.setSession(session);
       session.beginTransaction();
       valedao.cierreTurno();
       session.getTransaction().commit(); 
       
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
}
