/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.view;

import Imprimir.ImprimirComprobante;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.openswing.swing.mdi.client.InternalFrame;
import pe.com.ega.sgces.dao.DespachoDaoImpl;
import pe.com.ega.sgces.dao.TurnoDaoImpl;
import pe.com.ega.sgces.dao.TurnopuntoventacajaDaoImpl;
import pe.com.ega.sgces.logic.ArqueoLogicaImpl;
import pe.com.ega.sgces.logic.CierreLogicaImpl;
import pe.com.ega.sgces.logic.DepositoLogica;
import pe.com.ega.sgces.logic.DespachoLogica;
import pe.com.ega.sgces.logic.DespachoLogicaImpl;
import pe.com.ega.sgces.logic.MovimientoLogica;
import pe.com.ega.sgces.logic.TurnoLogicaImpl;
import pe.com.ega.sgces.logic.TurnopuntoventacajaLogicaImpl;
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
 * @author FLOPEZ
 */
public class CierreFrame extends InternalFrame {

    private TurnoLogicaImpl turnoLogica;
    private Turno turno;
    private ImprimirComprobante imprimircomprobante;
    private CierreLogicaImpl cierreLogica;
    private DespachoLogica despachoLogica;
    private ArqueoLogicaImpl arqueoLogica;     
    private TurnopuntoventacajaLogicaImpl turnopuntoventacajaLogica;
    
    public CierreFrame(MovimientoLogica movimiento, DepositoLogica deposito, DespachoLogica despachoLogica) {
        initComponents();
        turno = new Turno();
        imprimircomprobante = new ImprimirComprobante();
        turnoLogica =new TurnoLogicaImpl();
        cierreLogica = new CierreLogicaImpl();
        this.despachoLogica=despachoLogica;
        arqueoLogica= new ArqueoLogicaImpl(movimiento,deposito);
        turnoLogica.setTurnoDao(new TurnoDaoImpl());
        turnopuntoventacajaLogica= new TurnopuntoventacajaLogicaImpl();
        turnopuntoventacajaLogica.setTurnopuntoventacajaDao(new TurnopuntoventacajaDaoImpl());

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bturno = new javax.swing.JButton();

        jPanel1.setLayout(null);

        bturno.setText("TURNO");
        bturno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bturnoActionPerformed(evt);
            }
        });
        jPanel1.add(bturno);
        bturno.setBounds(100, 10, 80, 50);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void bturnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bturnoActionPerformed
              turno=turnoLogica.buscarPorCodigo("N");
              List<Despacho> despachos=(List<Despacho>) despachoLogica.buscarTodos();                   
              ArrayList<Arqueo> arqueos=arqueoLogica.buscarPorCodigo(String.valueOf(turno.getId()));
              System.out.println("Cierre Cero"+arqueos.get(0).getCantidad()+" "+arqueos.get(1).getCantidad()+" "+arqueos.get(2).getCantidad()+" "+arqueos.get(3).getCantidad());
              if(despachos.size()==0){
               if(redondear(arqueos.get(0).getCantidad())==0 &&redondear(arqueos.get(1).getCantidad())==0 && redondear(arqueos.get(2).getCantidad())==0 && redondear(arqueos.get(3).getCantidad())==0){
                Double total=0.0;
                ArrayList<Cierre> lista=cierreLogica.buscarPorCodigo(String.valueOf(turno.getId()));
                for (Cierre arqueo1 : lista) {
                    total=total+arqueo1.getCantidad();
                }      
                imprimircomprobante.imprimirTurno("0001", String.valueOf(redondear(lista.get(0).getCantidad())), String.valueOf(redondear(lista.get(1).getCantidad())),String.valueOf(redondear(lista.get(2).getCantidad())),String.valueOf(redondear(total)),String.valueOf(redondear(lista.get(3).getCantidad())), "ROSARIO");                
                turnoLogica.actualizar(turno);
                this.turno();
                this.turnoCaja();
                salir(evt); 
                }else{
                    final JPanel panel = new JPanel();
                    JOptionPane.showMessageDialog(panel, "Caja no Cuadrada", "Error", JOptionPane.ERROR_MESSAGE);
                }                    
            }else{
                final JPanel panel = new JPanel();
                JOptionPane.showMessageDialog(panel, "Despachos Pendientes por facturar", "Error", JOptionPane.ERROR_MESSAGE);
            }

            
    }//GEN-LAST:event_bturnoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bturno;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
   private void salir (java.awt.event.ActionEvent evt){
       actionPerformed(evt);
   }

    private void actionPerformed(ActionEvent evt) {
        setVisible(false);
        dispose();
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
        turnoLogica.insertar(x);
           
    }
     
     private void turnoCaja(){ 
        Turnopuntoventacaja cajax= new Turnopuntoventacaja();
        int turno2= turnoLogica.buscarPorCodigo("N").getId();
        cajax.setId(new TurnopuntoventacajaId(turno2,1,1));
        cajax.setCaja(new Caja(1));
        cajax.setPuntoventa(new Puntoventa(1));
        cajax.setTurno(turnoLogica.buscarPorCodigo("N"));
        cajax.setFecharegistro(new Date());
        turnopuntoventacajaLogica.insertar(cajax);
     }
     
     

}
