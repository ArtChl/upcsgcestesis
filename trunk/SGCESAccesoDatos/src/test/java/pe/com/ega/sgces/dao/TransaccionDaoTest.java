/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Session;
import static org.junit.Assert.*;
import org.junit.Test;
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.model.Numcomprobante;
import pe.com.ega.sgces.model.Transaccion;

/**
 *
 * @author FLOPEZ
 */
public class TransaccionDaoTest {
    
   
    TransaccionDao transaccionDao;
    Despacho despacho;
    DespachoDao despachoDao;
    TurnoDao turnoDao;
    NumComprobanteDao numComprobanteDao;
    Numcomprobante numComprobante;
    Session session;
    String numero;
   
    public TransaccionDaoTest() {
        session=HibernateUtil.sessionFactory.openSession();
        transaccionDao=new TransaccionDaoImpl();
        transaccionDao.setSession(session);
        despachoDao=new DespachoDaoImpl();
        turnoDao= new TurnoDaoImpl();
        turnoDao.setSession(session);
        numComprobanteDao=new NumComprobanteDaoImpl();
        numComprobanteDao.setSession(session);
        numComprobante= numComprobanteDao.buscarPorCodigo(1);
        
    }
    /*
    @Test
    public void insertarTransaccion(){
        Transaccion transaccion= new Transaccion();
        despacho=despachoDao.buscarPorCodigo(1);       
        numero="325-"+agregarCeros(String.valueOf(numComprobante.getNumero()),8);
        System.out.println("numero"+numero);
        transaccion.setDespacho(despacho);
        transaccion.setIdtipotransaccion("NDES");
        transaccion.setIdestado(turnoDao.buscarPorCodigo("N").getId());
        transaccion.setNumerotransaccion(String.valueOf(despacho.getId()));
        
        transaccion.setNumerovale(numero);
        transaccion.setNumero(numComprobante.getNumero());
        transaccion.setNrogalones(despacho.getNrogalones());
        transaccion.setPreciounitario(despacho.getPreciounitario());
        transaccion.setProducto(despacho.getProducto().getNombre());
        transaccion.setMontototal(despacho.getMontosoles());
        transaccion.setFecharegistro(despacho.getFecharegistro());
        transaccion.setTurno(despacho.getTurno());
        numComprobante.setNumero(numComprobante.getNumero()+1);
        numComprobanteDao.actualizar(numComprobante);
        Cliente clie= new Cliente();
        clie.setId(2);
        transaccion.setCliente(clie);
        session.beginTransaction();
        transaccionDao.insertar(transaccion);
        session.getTransaction().commit();
        Transaccion transaccionR=transaccionDao.buscarPorNumero(numero);
        assertEquals(transaccion.getNumerovale(), transaccionR.getNumerovale());
        
    }
    */
   
   /* 
   @Test
    public void anularTransaccion(){
        Transaccion trans= new Transaccion();
        numero="325-"+agregarCeros(String.valueOf(numComprobante.getNumero()-1),8);  
        System.out.println("numeroanulado"+numero);
        trans=transaccionDao.buscarPorNumero(numero);
        trans.setAnulado(true);
        System.out.println("transaccion"+trans.getNumerovale());
        session.beginTransaction();
        transaccionDao.actualizar(trans);
        session.getTransaction().commit();
        
        assertEquals(trans.getAnulado(), transaccionDao.buscarPorNumero(numero).getAnulado());
        
    }
   
   @Test
    public void eliminarTransaccion(){   
        Transaccion transaccion= new Transaccion();
        numero="325-"+agregarCeros(String.valueOf(numComprobante.getNumero()-1),8);
        transaccion=transaccionDao.buscarPorNumero(numero);       
        session.beginTransaction();
        transaccionDao.eliminar(transaccion);
        session.getTransaction().commit();
        String eliminado = "NO";
        try {         
           transaccionDao.buscarPorNumero(numero); 
       } catch (Exception e) {
            eliminado="SI";
       }
        assertEquals("NO",eliminado);
        
    }
  
    */
    private static String agregarCeros(String string, int largo)
    {
    	String ceros = "";
    	int cantidad = largo - string.length();
    	if (cantidad >= 1){
    		for(int i=0;i<cantidad;i++)
    		{
    		ceros += "0";	
    		}
    		return (ceros + string);
    	}else {
            return string;
        }
    }
}
