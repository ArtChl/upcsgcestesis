/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.com.ega.sgces.model.Despacho;

/**
 *
 * @author sistemas
 */
public class DespachoTest {
    
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
    /*
    @Test
    public void buscarDespacho(){       
        ArrayList<Despacho> transaccions = (ArrayList<Despacho>) despachoLogica.buscarTodos(); 
        Assert.assertEquals(3, transaccions.size());
    }
*/
}
