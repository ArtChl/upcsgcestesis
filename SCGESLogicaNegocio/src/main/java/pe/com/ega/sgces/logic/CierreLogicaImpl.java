/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import Imprimir.ImprimirComprobante;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.model.Arqueo;
import pe.com.ega.sgces.model.Caja;
import pe.com.ega.sgces.model.Cierre;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.model.Estacionservicio;
import pe.com.ega.sgces.model.Puntoventa;
import pe.com.ega.sgces.model.Turno;
import pe.com.ega.sgces.model.Turnopuntoventacaja;
import pe.com.ega.sgces.model.TurnopuntoventacajaId;

/**
 *
 * @author sistemas
 */
public class CierreLogicaImpl implements CierreLogica{

    SessionFactory session; 
    TransaccionLogica transaccionLogica;
    DespachoLogica despachoLogica;
    TurnopuntoventacajaLogica turnopuntoventacajaLogica;
    ArqueoLogica arqueoLogica;
    TurnoLogica turnoLogica;
    ImprimirComprobante imprimircomprobante;

    public CierreLogicaImpl() {
            imprimircomprobante = new ImprimirComprobante();
    }
    
    public void setSession(SessionFactory session) {
        this.session=session;
    }

    public void setTurnoLogica(TurnoLogica turnoLogica) {
        this.turnoLogica = turnoLogica;
    }
    
    public void setTransaccionLogica(TransaccionLogica transaccionLogica) {
        this.transaccionLogica = transaccionLogica;
    }

    public void setArqueoLogica(ArqueoLogica arqueoLogica) {
        this.arqueoLogica = arqueoLogica;
    }

    public void setDespachoLogica(DespachoLogica despachoLogica) {
        this.despachoLogica = despachoLogica;
    }

    public void setTurnopuntoventacajaLogica(TurnopuntoventacajaLogica turnopuntoventacajaLogica) {
        this.turnopuntoventacajaLogica = turnopuntoventacajaLogica;
    }
    
    @Override
    public String cierreTurno() {
              String resultado=null;
              Turno turno=turnoLogica.buscarPorCodigo("N");
              List<Despacho> despachos=(List<Despacho>) despachoLogica.buscarTodos();  
              ArrayList<Arqueo> arqueos=arqueoLogica.buscarPorCodigo(String.valueOf(turno.getId()));
              if(despachos.isEmpty()){
               if(redondear(arqueos.get(0).getCantidad())==0 &&redondear(arqueos.get(1).getCantidad())==0 && redondear(arqueos.get(2).getCantidad())==0 && redondear(arqueos.get(3).getCantidad())==0){            
                Double total=0.0;
                ArrayList<Cierre> lista=this.buscarPorCodigo(String.valueOf(turno.getId()));
                for (Cierre arqueo1 : lista) {
                    total=total+arqueo1.getCantidad();
                }      
                //imprimircomprobante.imprimirTurno("0001", String.valueOf(redondear(lista.get(0).getCantidad())), String.valueOf(redondear(lista.get(1).getCantidad())),String.valueOf(redondear(lista.get(2).getCantidad())),String.valueOf(redondear(total)),String.valueOf(redondear(lista.get(3).getCantidad())), "ROSARIO");                
                
                  try {
                       turnoLogica.actualizar(turno);
                       resultado="Cierre";
                   } catch (Exception e) {
                       System.out.println("Cierre"+e.toString());
                       resultado="Cierre";
                   }
                   
                this.turno();
                this.turnoCaja();
                }else{
                   resultado="Caja No Cuadrada";
                }                    
            }else{
                resultado="Despachos Pendientes por Facturar";
            }
              return resultado;
    }


    public static double redondear(double numero) 
    {        
           return Math.rint(numero*100)/100; 
    }
    
    private void turno() 
    {
        Turno x=new Turno();
        x.setEstacionservicio(new  Estacionservicio(1));
        x.setFechaapertura(new Date());
        x.setEstado("N");
        try {
            turnoLogica.insertar(x);
        } catch (Exception e) {
            System.out.println("Insertar"+e.toString());
        }
        
           
    }
     
    private void turnoCaja(){ 
        Turnopuntoventacaja cajax= new Turnopuntoventacaja();
        int turno2=0;
        try {
            turno2= turnoLogica.buscarPorCodigo("N").getId();
        } catch (Exception e) {
            System.out.println("Insertar"+e.toString());
        }
        
        
        cajax.setId(new TurnopuntoventacajaId(turno2,1,1));
        cajax.setCaja(new Caja(1));
        cajax.setPuntoventa(new Puntoventa(1));
        cajax.setTurno(turnoLogica.buscarPorCodigo("N"));
        cajax.setFecharegistro(new Date());
        System.out.println("Error Caja"+turno2);
        try {
            turnopuntoventacajaLogica.insertar(cajax);
        } catch (Exception e) {
            System.out.println("Error Caja"+e.toString());
        }
        
     }
    
    @Override
    public ArrayList<Cierre> buscarPorCodigo(String turno) {
         System.out.println("Entro a Buscar");
         ArrayList<Cierre> cierres= new ArrayList<>();
         ArrayList<String> lista= new ArrayList<>();
         lista.add("GASOLINA 84");
         lista.add("GASOLINA 90");
         lista.add("GASOLINA 94");
         lista.add("DIESEL");
         System.out.println("Cierre Cero"+lista.size());
         for (int i = 0; i < lista.size(); i++) {
            String string = lista.get(i);
            Cierre cierre=new Cierre();
            cierre.setProducto(string);
            Double mov=transaccionLogica.buscarMonto(string, turno);
            cierre.setCantidad(mov);
            cierres.add(cierre);           
        }
         return cierres;
    }
}
