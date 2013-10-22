/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.view;

import Imprimir.ImprimirComprobante;
import java.awt.event.ActionEvent;
import java.util.Date;
import org.openswing.swing.mdi.client.InternalFrame;
import pe.com.ega.sgces.dao.DepositoDaoImpl;
import pe.com.ega.sgces.dao.MovimientoDaoImpl;
import pe.com.ega.sgces.dao.TurnoDaoImpl;
import pe.com.ega.sgces.dao.TurnopuntoventacajaDaoImpl;
import pe.com.ega.sgces.logic.DepositoLogicaImpl;
import pe.com.ega.sgces.logic.MovimientoLogicaImpl;
import pe.com.ega.sgces.logic.TurnoLogicaImpl;
import pe.com.ega.sgces.logic.TurnopuntoventacajaLogicaImpl;
import pe.com.ega.sgces.model.Caja;
import pe.com.ega.sgces.model.Estacionservicio;
import pe.com.ega.sgces.model.Puntoventa;
import pe.com.ega.sgces.model.Transaccion;
import pe.com.ega.sgces.model.Turno;
import pe.com.ega.sgces.model.Turnopuntoventacaja;
import pe.com.ega.sgces.model.TurnopuntoventacajaId;

/**
 *
 * @author FLOPEZ
 */
public class CierreFrame extends InternalFrame {

    private ImprimirComprobante comprobante;
    private Transaccion transaccion;
    private DepositoLogicaImpl depositoLogica;
    private MovimientoLogicaImpl movimientoLogica;
    private TurnoLogicaImpl turnoLogica;
    private TurnopuntoventacajaLogicaImpl turnopuntoventacajaLogica;
    private Turno turno;
    
    public CierreFrame() {
        initComponents();
        transaccion=new Transaccion();
        depositoLogica =new DepositoLogicaImpl();
        depositoLogica.setDepositoDao(new DepositoDaoImpl());
        turnoLogica =new TurnoLogicaImpl();
        turnoLogica.setTurnoDao(new TurnoDaoImpl());
        movimientoLogica =new MovimientoLogicaImpl();
        movimientoLogica.setMovimientoDao(new MovimientoDaoImpl());
        turnopuntoventacajaLogica =new TurnopuntoventacajaLogicaImpl();
        turnopuntoventacajaLogica.setTurnopuntoventacajaDao(new TurnopuntoventacajaDaoImpl());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bdia = new javax.swing.JButton();
        bturno = new javax.swing.JButton();

        jPanel1.setLayout(null);

        bdia.setText("DIA");
        bdia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdiaActionPerformed(evt);
            }
        });
        jPanel1.add(bdia);
        bdia.setBounds(160, 10, 80, 50);

        bturno.setText("TURNO");
        bturno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bturnoActionPerformed(evt);
            }
        });
        jPanel1.add(bturno);
        bturno.setBounds(30, 10, 80, 50);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void bdiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdiaActionPerformed
     
            salir(evt);
    }//GEN-LAST:event_bdiaActionPerformed

    private void bturnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bturnoActionPerformed
            turno=turnoLogica.buscarPorCodigo("N");
            turno.setEstado("S");
            turno.setFechacierre(new Date());
            turnoLogica.actualizar(turno);
            this.Turno();
            salir(evt);
    }//GEN-LAST:event_bturnoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bdia;
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
    
    private void Turno() {
        Turno x=new Turno();
        x.setEstacionservicio(new  Estacionservicio(1));
        x.setFechaapertura(new Date());
        x.setEstado("N");
        turnoLogica.insertar(x);

        Turnopuntoventacaja cajax= new Turnopuntoventacaja();
        cajax.setId(new TurnopuntoventacajaId(turnoLogica.buscarPorCodigo("N").getId(),1,1));
        cajax.setCaja(new Caja(1));
        cajax.setPuntoventa(new Puntoventa(1));
        cajax.setTurno(turnoLogica.buscarPorCodigo("N"));
        cajax.setFecharegistro(new Date());
        turnopuntoventacajaLogica.insertar(cajax);
    }

}