/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.ArrayList;
import pe.com.ega.sgces.model.Arqueo;

/**
 *
 * @author sistemas
 */
public class ArqueoLogicaImpl implements ArqueoLogica{

    private MovimientoLogica movimientoLogica;
    private DepositoLogica depositoLogica;

    public ArqueoLogicaImpl(MovimientoLogica movimiento, DepositoLogica deposito) {
         this.movimientoLogica = movimiento;
         this.depositoLogica = deposito;
    }

    public ArqueoLogicaImpl() {
    }

    
    public void setMovimientoLogica(MovimientoLogica movimientoLogica) {
        this.movimientoLogica = movimientoLogica;
    }

    public void setDepositoLogica(DepositoLogica depositoLogica) {
        this.depositoLogica = depositoLogica;
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
            }
            if(arqueo.getComprobante().equalsIgnoreCase("DOLARES")) {
                arqueo.setCantidad(redondear((mov/2.65-dep))); 
                solesDolares=vuelto;
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
