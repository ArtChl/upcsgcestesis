/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.com.ega.sgces.model.Despacho;

/**
 *
 * @author FLOPEZ
 */
public class NewMain {

    private static MovimientoLogica movimientoLogica;
    private static DepositoLogica depositoLogica;
    private static DespachoLogica despachoLogica;
   
    public static void main(String[] args) {   
 
       
       
       ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		NewMain.movimientoLogica =  context.getBean("movimientoService",
				MovimientoLogicaImpl.class);
                NewMain.depositoLogica =  context.getBean("depositoService",
				DepositoLogicaImpl.class);
                 NewMain.despachoLogica =  context.getBean("despachoService",
				DespachoLogicaImpl.class);
        Double movimiento=movimientoLogica.buscarMontoVuelto("SOLES", "117");
        Double deposito=depositoLogica.buscarMonto("SOLES", "117");
        List<Despacho> lista=despachoLogica.buscarTodos();
        System.out.println("Monedas"+movimiento);
        System.out.println("Monedas"+deposito);
        System.out.println("Lista"+lista.size());
    }
}
