/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.view;

import java.awt.event.ActionEvent;
import org.openswing.swing.mdi.client.InternalFrame;
import org.openswing.swing.mdi.client.MDIFrame;
import pe.com.ega.sgces.logic.DespachoLogica;
import pe.com.ega.sgces.logic.MovimientoLogica;
import pe.com.ega.sgces.logic.TransaccionLogica;
import pe.com.ega.sgces.logic.TurnoLogica;
import pe.com.ega.sgces.model.Despacho;

/**
 *
 * @author FLOPEZ
 */
public class OpcionFrame extends InternalFrame {

    private Despacho desp;
    private DespachoLogica despachoLogic;
    private MovimientoLogica movimientoLogica;
    private TurnoLogica turnoLogica;
    private TransaccionLogica transaccionLogica;
    
    public OpcionFrame(Despacho codigo, DespachoLogica despachoLogica, MovimientoLogica movimientoLogica, TurnoLogica turnoLogica, TransaccionLogica transaccionLogica) {
        initComponents();
        this.desp=codigo;
        this.despachoLogic=despachoLogica;
        this.movimientoLogica= movimientoLogica;
        this.turnoLogica= turnoLogica;
        this.transaccionLogica=transaccionLogica;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        boleta = new javax.swing.JButton();
        despacho = new javax.swing.JButton();
        factura = new javax.swing.JButton();

        jPanel1.setLayout(null);

        boleta.setText("TBOL");
        boleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boletaActionPerformed(evt);
            }
        });
        jPanel1.add(boleta);
        boleta.setBounds(190, 10, 80, 50);

        despacho.setText("NDES");
        despacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                despachoActionPerformed(evt);
            }
        });
        jPanel1.add(despacho);
        despacho.setBounds(10, 10, 80, 50);

        factura.setText("FACT");
        factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaActionPerformed(evt);
            }
        });
        jPanel1.add(factura);
        factura.setBounds(100, 10, 80, 50);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaActionPerformed
        FacturaFrame f=new FacturaFrame(desp,despachoLogic, movimientoLogica, turnoLogica, transaccionLogica);
            f.setSize(391,166);
            f.setTitle("Factura");
            MDIFrame.add(f);
            salir(evt);
    }//GEN-LAST:event_facturaActionPerformed

    private void despachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_despachoActionPerformed
       NotaFrame f=new NotaFrame(desp);
            f.setSize(391,290);
            f.setTitle("Nota Despacho");
            MDIFrame.add(f);
            salir(evt);
    }//GEN-LAST:event_despachoActionPerformed

    private void boletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boletaActionPerformed
        MonedaFrame f=new MonedaFrame(desp, "BOL", null, despachoLogic, movimientoLogica, turnoLogica, transaccionLogica);
            f.setSize(301,213);
            f.setTitle("Tipo Pago");
            MDIFrame.add(f);
            salir(evt);
    }//GEN-LAST:event_boletaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boleta;
    private javax.swing.JButton despacho;
    private javax.swing.JButton factura;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
   private void salir (java.awt.event.ActionEvent evt){
       actionPerformed(evt);
   }

    private void actionPerformed(ActionEvent evt) {
        setVisible(false);
        dispose();
    }

}
