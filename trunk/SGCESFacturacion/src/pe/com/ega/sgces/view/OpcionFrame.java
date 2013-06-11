/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.view;

import Imprimir.ImprimirComprobante;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import org.openswing.swing.mdi.client.InternalFrame;
import org.openswing.swing.mdi.client.MDIFrame;
import pe.com.ega.sgces.dao.DespachoDaoImpl;
import pe.com.ega.sgces.dao.TransaccionDaoImpl;
import pe.com.ega.sgces.logic.DespachoLogicaImpl;
import pe.com.ega.sgces.logic.TransaccionLogicaImpl;
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.model.Transaccion;

/**
 *
 * @author FLOPEZ
 */
public class OpcionFrame extends InternalFrame {

    private Despacho desp;
    private ImprimirComprobante comprobante;
    private Transaccion transaccion;
    private TransaccionLogicaImpl transaccionLogica;
    private DespachoLogicaImpl despachoLogica;
    
    public OpcionFrame(Despacho codigo) {
        initComponents();
        desp=codigo;
        transaccion=new Transaccion();
        transaccionLogica =new TransaccionLogicaImpl();
        transaccionLogica.setTransaccionDao(new TransaccionDaoImpl());
        despachoLogica=new DespachoLogicaImpl();
        despachoLogica.setDespachoDao(new DespachoDaoImpl());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        boleta = new javax.swing.JButton();
        despacho = new javax.swing.JButton();
        factura = new javax.swing.JButton();

        jPanel1.setLayout(null);

        boleta.setText("BOLETA");
        boleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boletaActionPerformed(evt);
            }
        });
        jPanel1.add(boleta);
        boleta.setBounds(11, 10, 80, 50);

        despacho.setText("NDES");
        despacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                despachoActionPerformed(evt);
            }
        });
        jPanel1.add(despacho);
        despacho.setBounds(100, 10, 80, 50);

        factura.setText("FACTURA");
        factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaActionPerformed(evt);
            }
        });
        jPanel1.add(factura);
        factura.setBounds(190, 10, 80, 50);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaActionPerformed
        FacturaFrame f=new FacturaFrame(desp);
            f.setSize(391,151);
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
        MonedaFrame f=new MonedaFrame(desp, "BOL", null);
            f.setSize(295,132);
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
