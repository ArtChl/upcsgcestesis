/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.model.Movimiento;
import pe.com.ega.sgces.model.Numcomprobante;
import pe.com.ega.sgces.model.Transaccion;
import pe.com.ega.sgces.model.Turnopuntoventacaja;
import pe.com.ega.sgces.model.TurnopuntoventacajaId;
import pe.com.ega.sgces.util.Formato;

/**
 *
 * @author sistemas
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransaccionTest {
    
    private MovimientoLogica movimientoLogica;
    private DepositoLogica depositoLogica;
    private DespachoLogica despachoLogica;
    private TurnoLogica turnoLogica;
    private TransaccionLogica transaccionLogica;
    private CierreLogica cierreLogica;
    private ArqueoLogica arqueoLogica;
    private NumComprobanteLogica numcomprobanteLogica;
    private ClienteLogica clienteLogica;
    private ValeLogica valeLogica;
    private String codigo;
    private Transaccion  transaccionPersistent;
   
    
    
    @Before
    public void iniciarContextto(){
         ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        this.movimientoLogica = context.getBean("movimientoService",
                MovimientoLogicaImpl.class);
        this.depositoLogica = context.getBean("depositoService",
                DepositoLogicaImpl.class);
        this.despachoLogica = context.getBean("despachoService",
                DespachoLogicaImpl.class);
        this.turnoLogica = context.getBean("turnoService",
                TurnoLogicaImpl.class);
        this.transaccionLogica = context.getBean("transaccionService",
                TransaccionLogicaImpl.class);
        this.cierreLogica = context.getBean("cierreService",
                CierreLogicaImpl.class);
        this.numcomprobanteLogica= context.getBean("numComprobanteService",
                NumComprobanteLogicaImpl.class);
        this.arqueoLogica = context.getBean("arqueoService",
                ArqueoLogicaImpl.class);
        this.clienteLogica = context.getBean("clienteService",
                ClienteLogicaImpl.class);
        this.valeLogica = context.getBean("valeService",
                ValeLogicaImpl.class);
        
    }
   
  
    
    @Test
    public void test1ingresarBoleta(){   
        ArrayList<Despacho> transaccions = (ArrayList<Despacho>) despachoLogica.buscarTodos(); 
        String numero=null;      
        for (Despacho despacho : transaccions) {
            if(despacho.getId()==215)
            {
            Transaccion transaccion=new Transaccion();
            transaccion.setDespacho(despacho);
            transaccion.setIdestado(turnoLogica.buscarPorCodigo("N").getId());
            transaccion.setNumerotransaccion(String.valueOf(despacho.getId())); 
            transaccion.setNrogalones(despacho.getNrogalones());
            transaccion.setPreciounitario(despacho.getPreciounitario());
            transaccion.setProducto(despacho.getProducto().getNombre());
            transaccion.setMontototal(despacho.getMontosoles());
            transaccion.setFecharegistro(despacho.getFecharegistro());
            transaccion.setTurno(despacho.getTurno());

            Cliente cliente=new Cliente();
            cliente.setId(1);
            transaccion.setCliente(cliente);
            transaccion.setIdtipotransaccion("TBOL");
            Numcomprobante comprobantes = numcomprobanteLogica.buscarPorCodigo(2);
            numero="325-" + Formato.agregarCeros(String.valueOf(comprobantes.getNumero()), 8);
            System.out.println("Numero Inicial"+numero);
            transaccion.setNumerovale(numero);
            transaccion.setNumero(comprobantes.getNumero());
            comprobantes.setNumero(comprobantes.getNumero()+1);
            numcomprobanteLogica.actualizar(comprobantes); 
            transaccionLogica.grabar(transaccion);
            transaccionPersistent=transaccionLogica.buscarPorNumero(numero);
            despachoLogica.eliminar(despacho);
            } 
        }      
        Assert.assertEquals(numero, transaccionPersistent.getNumerovale() );
    }
    
   
    @Test
    public void test2movimientoBoleta(){
        Transaccion transaccion=new Transaccion();
        String numero=null;
        try {
            Numcomprobante comprobantes = numcomprobanteLogica.buscarPorCodigo(2);
            numero="325-" + Formato.agregarCeros(String.valueOf(comprobantes.getNumero()-1), 8);
            System.out.println("Numero Movimiento"+numero);
            transaccion=transaccionLogica.buscarPorNumero(numero);
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
        
        Movimiento movimiento=new Movimiento();
        movimiento.setTransaccion(transaccion);
        movimiento.setPago("SOLES");
        Turnopuntoventacaja caja = new Turnopuntoventacaja();
        TurnopuntoventacajaId turnopuntoventacajaId = new TurnopuntoventacajaId();
        turnopuntoventacajaId.setIdturno(turnoLogica.buscarPorCodigo("N").getId());
        turnopuntoventacajaId.setIdcaja(1);
        turnopuntoventacajaId.setIdpuntoventa(1);
        caja.setId(turnopuntoventacajaId);
        movimiento.setTurnopuntoventacaja(caja);
        movimiento.setMontototal(transaccion.getMontototal());
        movimiento.setTipo("SOLES");
        movimiento.setMontorecibido(new BigDecimal(100));
        movimiento.setMontodevuelto(new BigDecimal(100).subtract(transaccion.getMontototal()));
        movimiento.setTurno(transaccion.getTurno());
        movimiento.setCerrado("N");
        movimiento.setFecharegistro(new Date());
        movimientoLogica.grabar(movimiento);
        Assert.assertEquals(transaccion.getId(), movimientoLogica.buscarTransaccion(String.valueOf(transaccion.getId())).getTransaccion().getId());
    }
    
   
    
    @Test
    public void test3suprimirMovimiento(){
        Numcomprobante comprobantes = numcomprobanteLogica.buscarPorCodigo(2);
        String numero=null;
        numero="325-" + Formato.agregarCeros(String.valueOf(comprobantes.getNumero()-1), 8);
        System.out.println("Movimiento eliminar"+numero);
        Transaccion transaccion=transaccionLogica.buscarPorNumero(numero);  
        String codigo=String.valueOf(transaccion.getId());
        System.out.println("Codigo transaccion movimiento"+codigo);
        Movimiento movimiento=movimientoLogica.buscarTransaccion(codigo);
        String error=null;
         try {
             movimientoLogica.eliminar(movimiento);
         } catch (Exception e) {
             error=e.toString();
         }
        Assert.assertEquals(error, null);
    }
    
    @Test
    public void test4suprimirBoleta(){
        Numcomprobante comprobantes = numcomprobanteLogica.buscarPorCodigo(2);
        String numero=null;
        numero="325-" + Formato.agregarCeros(String.valueOf(comprobantes.getNumero()-1), 8);
        Transaccion transaccion=transaccionLogica.buscarPorNumero(numero);  
        System.out.println("Boleta eliminar"+transaccion.getNumerovale());
        String error=null;
         try {
             transaccionLogica.eliminar(transaccion);
         } catch (Exception e) {
             error=e.toString();
         }
        Assert.assertEquals(error, null);
    }
     
    @Test
    public void test5correguirNumeracion(){
        Numcomprobante comprobantes = numcomprobanteLogica.buscarPorCodigo(2);
        int numero = comprobantes.getNumero();
        comprobantes.setNumero(numero-1);
        numcomprobanteLogica.actualizar(comprobantes);
        Assert.assertEquals(String.valueOf(numero-1), String.valueOf(numcomprobanteLogica.buscarPorCodigo(2).getNumero()));
    }
    
}
