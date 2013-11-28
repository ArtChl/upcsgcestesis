/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.com.ega.sgces.model.Numcomprobante;
import pe.com.ega.sgces.model.Transaccion;
import pe.com.ega.sgces.model.Vale;
import pe.com.ega.sgces.util.Formato;

/**
 *
 * @author sistemas
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ValeTest {
    
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
    public void test1registrarVale(){
        String numero=null;
        Vale vale=new Vale();
        vale.setCliente("1");
        vale.setFecha(new Date());
        vale.setProducto("GASOLINA 95");
        vale.setMonto(20.0);
        Numcomprobante comprobantes = numcomprobanteLogica.buscarPorCodigo(1);
        numero="325-" + Formato.agregarCeros(String.valueOf(comprobantes.getNumero()), 8);
        vale.setNumero(numero);
        vale.setChofer("JUAN PERES");
        vale.setPlaca("TGJ456");
        List<Vale> vales=valeLogica.buscarTodos("1");
        valeLogica.insertar(vale);
        comprobantes.setNumero(comprobantes.getNumero()+1);
        numcomprobanteLogica.actualizar(comprobantes);
        Assert.assertEquals(vales.size(), valeLogica.buscarTodos("1").size()-1);
    }
     
    @Test
    public void test2updateVale(){
        String numero=null;
        Numcomprobante comprobantes = numcomprobanteLogica.buscarPorCodigo(1);
        numero="325-" + Formato.agregarCeros(String.valueOf(comprobantes.getNumero()-1), 8);
        Vale vale=valeLogica.buscarPorNumero(numero);
        vale.setMonto(200.0);
        valeLogica.actualizar(vale);
        
        Assert.assertEquals(String.valueOf(vale.getMonto()), String.valueOf(valeLogica.buscarPorNumero(numero).getMonto()));
    }
   
     @Test
    public void test3eliminarVale(){
        String numero=null;
        Numcomprobante comprobantes = numcomprobanteLogica.buscarPorCodigo(1);
        numero="325-" + Formato.agregarCeros(String.valueOf(comprobantes.getNumero()-1), 8);
        Vale vale=valeLogica.buscarPorNumero(numero);
        String error=null;
        try {
            valeLogica.eliminar(vale);
        } catch (Exception e) {
            error=e.toString();
        }   
        Assert.assertEquals(error, null);
      
    }
     
     @Test
    public void test4correguirNumeracio(){
        Numcomprobante comprobantes = numcomprobanteLogica.buscarPorCodigo(1);
        int numero = comprobantes.getNumero();
        comprobantes.setNumero(numero-1);
        numcomprobanteLogica.actualizar(comprobantes);

        Assert.assertEquals(String.valueOf(numero-1), String.valueOf(numcomprobanteLogica.buscarPorCodigo(1).getNumero()));
    }
    
}
