/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.com.ega.sgces.model.Despacho;

/**
 *
 * @author FLOPEZ
 */
public class NewMain {

    private static MovimientoDao movimientoService; 
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		NewMain.movimientoService =  context.getBean("movimientoDao",
				MovimientoDaoImpl.class);
        List monedas=movimientoService.buscarMonto("SOLES", "117");
        System.out.println("Monedas"+monedas.toString());
    }
    
}
