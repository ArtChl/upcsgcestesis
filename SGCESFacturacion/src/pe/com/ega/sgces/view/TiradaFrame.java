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
import pe.com.ega.sgces.logic.DepositoLogicaImpl;
import pe.com.ega.sgces.logic.DespachoLogicaImpl;
import pe.com.ega.sgces.logic.TransaccionLogicaImpl;
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.model.Deposito;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.model.Transaccion;

/**
 *
 * @author FLOPEZ
 */
public class TiradaFrame extends InternalFrame {

    private Despacho desp;
    private ImprimirComprobante comprobante;
    private Deposito deposito;
    private DepositoLogicaImpl depositoLogica;
  
    
    public TiradaFrame(Despacho codigo) {
        initComponents();
        desp=codigo;
        deposito=new Deposito();
        depositoLogica =new DepositoLogicaImpl();
       // depositoLogica.setTransaccionDao(new TransaccionDaoImpl());
       // despachoLogica=new DespachoLogicaImpl();
       // despachoLogica.setDespachoDao(new DespachoDaoImpl());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        despacho = new javax.swing.JButton();
        factura = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jmonto = new javax.swing.JTextField();

        jPanel1.setLayout(null);

        despacho.setText("SOLES");
        despacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                despachoActionPerformed(evt);
            }
        });
        jPanel1.add(despacho);
        despacho.setBounds(20, 90, 80, 30);

        factura.setText("DOLARES");
        factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaActionPerformed(evt);
            }
        });
        jPanel1.add(factura);
        factura.setBounds(120, 90, 80, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("MONTO :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 40, 70, 17);

        jmonto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jmonto);
        jmonto.setBounds(110, 40, 90, 23);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void despachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_despachoActionPerformed
       NotaFrame f=new NotaFrame(desp);
            f.setSize(391,290);
            f.setTitle("Nota Despacho");
            MDIFrame.add(f);
            salir(evt);
    }//GEN-LAST:event_despachoActionPerformed

    private void facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaActionPerformed
        FacturaFrame f=new FacturaFrame(desp);
        f.setSize(391,151);
        f.setTitle("Factura");
        MDIFrame.add(f);
        salir(evt);
    }//GEN-LAST:event_facturaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton despacho;
    private javax.swing.JButton factura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jmonto;
    // End of variables declaration//GEN-END:variables
   private void salir (java.awt.event.ActionEvent evt){
       actionPerformed(evt);
   }

    private void actionPerformed(ActionEvent evt) {
        setVisible(false);
        dispose();
    }

}
