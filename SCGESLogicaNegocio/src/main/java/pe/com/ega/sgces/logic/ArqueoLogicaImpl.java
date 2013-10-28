/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.ArrayList;
import org.hibernate.Session;
import pe.com.ega.sgces.dao.DepositoDaoImpl;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.dao.MovimientoDaoImpl;
import pe.com.ega.sgces.model.Arqueo;

/**
 *
 * @author sistemas
 */
public class ArqueoLogicaImpl implements ArqueoLogica{

    MovimientoLogica movimientoLogica;
    DepositoLogica depositoLogica;

    public ArqueoLogicaImpl(MovimientoLogica movimiento, DepositoLogica deposito) {
         this.movimientoLogica = movimiento;
         this.depositoLogica = deposito;
    }
     
    @Override
    public ArrayList<Arqueo> buscarPorCodigo(String turno) {
         ArrayList<Arqueo> arqueos= new ArrayList<>();
         ArrayList<String> lista= new ArrayList<>();
         lista.add("DOLARES");
         lista.add("SOLES");
         lista.add("VISA");
         lista.add("MASTERCARD");
         Double soles=0.0;
         Double solesDolares=0.0;
         for (int i = 0; i < lista.size(); i++) {
            String string = lista.get(i);
            Arqueo arqueo=new Arqueo();
            arqueo.setComprobante(string);     
            Double mov=movimientoLogica.buscarMonto(string,turno);
            Double vuelto=movimientoLogica.buscarMontoVuelto(string,turno);
            soles=redondear(mov-vuelto);
            Double dep=depositoLogica.buscarMonto(string,turno);
            if(arqueo.getComprobante().equalsIgnoreCase("SOLES")) {
                soles=soles-solesDolares;
                System.out.println("Soles"+soles);
            }
            if(arqueo.getComprobante().equalsIgnoreCase("DOLARES")) {
                arqueo.setCantidad(redondear((mov-dep)/2.65)); 
                solesDolares=vuelto;
                System.out.println("Vueltos Dolares"+solesDolares);
            }else{
                arqueo.setCantidad(soles-dep);      
                 
            } 
            arqueos.add(arqueo); 
        }
         return arqueos;
    }
    
    public static double redondear(double numero) 
       {        
           return Math.rint(numero*100)/100; 
       }
    
}
