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
import pe.com.ega.sgces.dao.TurnoDaoImpl;
import pe.com.ega.sgces.logic.DepositoLogicaImpl;
import pe.com.ega.sgces.logic.TurnoLogicaImpl;
import pe.com.ega.sgces.model.Deposito;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.model.Turno;
import pe.com.ega.sgces.model.Turnopuntoventacaja;
import pe.com.ega.sgces.model.TurnopuntoventacajaId;

/**
 *
 * @author FLOPEZ
 */
public class TiradaFrame extends InternalFrame {

    private Despacho desp;
    private ImprimirComprobante comprobante;
    private Deposito deposito;
    private DepositoLogicaImpl depositoLogica;
    private TurnoLogicaImpl turnoLogica;
  
    
    public TiradaFrame() {
        initComponents();
        deposito=new Deposito();
        depositoLogica =new DepositoLogicaImpl();
        depositoLogica.setDepositoDao(new DepositoDaoImpl());
        turnoLogica =new TurnoLogicaImpl();
        turnoLogica.setTurnoDao(new TurnoDaoImpl());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        soles = new javax.swing.JButton();
        dolares = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jmonto = new javax.swing.JTextField();

        jPanel1.setLayout(null);

        soles.setText("SOLES");
        soles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solesActionPerformed(evt);
            }
        });
        jPanel1.add(soles);
        soles.setBounds(20, 90, 80, 30);

        dolares.setText("DOLARES");
        dolares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dolaresActionPerformed(evt);
            }
        });
        jPanel1.add(dolares);
        dolares.setBounds(120, 90, 80, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("MONTO :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 40, 70, 17);

        jmonto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jmonto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel1.add(jmonto);
        jmonto.setBounds(120, 40, 80, 23);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void solesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solesActionPerformed
        this.llenardatos("SOLES");
        salir(evt);
    }//GEN-LAST:event_solesActionPerformed

    private void dolaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dolaresActionPerformed
        this.llenardatos("DOLARES");
        salir(evt);
    }//GEN-LAST:event_dolaresActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dolares;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jmonto;
    private javax.swing.JButton soles;
    // End of variables declaration//GEN-END:variables
   private void salir (java.awt.event.ActionEvent evt){
       actionPerformed(evt);
   }

    private void actionPerformed(ActionEvent evt) {
        setVisible(false);
        dispose();
    }

    private void llenardatos(String pago) {
        Turnopuntoventacaja caja= new Turnopuntoventacaja();
        caja.setId(new TurnopuntoventacajaId(turnoLogica.buscarPorCodigo("N").getId(), 1, 1));            
        deposito.setTurnopuntoventacaja(caja);
        deposito.setMontototal(Long.parseLong(jmonto.getText()));
        deposito.setFecharegistro(new Date());
        deposito.setIdtipopago(pago);     
        deposito.setTurno(String.valueOf(turnoLogica.buscarPorCodigo("N").getId()));
        deposito.setCerrado("N");
        depositoLogica.insertar(deposito);
    }
}
