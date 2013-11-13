/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.sgcespos;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import org.openswing.swing.mdi.client.InternalFrame;
import pe.com.ega.sgces.logic.DepositoLogica;

/**
 *
 * @author FLOPEZ
 */
public class TiradaFrame extends JFrame {
    
    private DepositoLogica depositoLogica;
    
    public TiradaFrame(DepositoLogica depositoLogica) {
        initComponents();
        this.depositoLogica =depositoLogica;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        master = new javax.swing.JButton();
        dolares = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jmonto = new javax.swing.JTextField();
        soles = new javax.swing.JButton();
        visa = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        master.setBackground(new java.awt.Color(255, 235, 90));
        master.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        master.setMnemonic(KeyEvent.VK_M);
        master.setText("MASTER");
        master.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masterActionPerformed(evt);
            }
        });
        jPanel1.add(master);
        master.setBounds(300, 120, 180, 70);

        dolares.setBackground(new java.awt.Color(133, 238, 75));
        dolares.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        dolares.setMnemonic(KeyEvent.VK_D);
        dolares.setText("DOLARES");
        dolares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dolaresActionPerformed(evt);
            }
        });
        jPanel1.add(dolares);
        dolares.setBounds(20, 200, 190, 70);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel1.setText("MONTO :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(80, 50, 150, 30);

        jmonto.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jmonto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel1.add(jmonto);
        jmonto.setBounds(220, 40, 140, 40);

        soles.setBackground(new java.awt.Color(51, 153, 255));
        soles.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        soles.setMnemonic(KeyEvent.VK_S);
        soles.setText("SOLES");
        soles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solesActionPerformed(evt);
            }
        });
        jPanel1.add(soles);
        soles.setBounds(20, 120, 190, 70);

        visa.setBackground(new java.awt.Color(255, 235, 90));
        visa.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        visa.setMnemonic(KeyEvent.VK_V);
        visa.setText("VISA");
        visa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visaActionPerformed(evt);
            }
        });
        jPanel1.add(visa);
        visa.setBounds(300, 200, 180, 70);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 255));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(230, 110, 0, 160);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void masterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masterActionPerformed
        depositoLogica.depositar(jmonto.getText(),"MASTERCARD");       
        salir(evt);
    }//GEN-LAST:event_masterActionPerformed

    private void dolaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dolaresActionPerformed
        depositoLogica.depositar(jmonto.getText(),"DOLARES");    
        salir(evt);
    }//GEN-LAST:event_dolaresActionPerformed

    private void solesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solesActionPerformed
        depositoLogica.depositar(jmonto.getText(),"SOLES");    
        salir(evt);
    }//GEN-LAST:event_solesActionPerformed

    private void visaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visaActionPerformed
        depositoLogica.depositar(jmonto.getText(),"VISA");    
        salir(evt);
    }//GEN-LAST:event_visaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dolares;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jmonto;
    private javax.swing.JButton master;
    private javax.swing.JButton soles;
    private javax.swing.JButton visa;
    // End of variables declaration//GEN-END:variables
   private void salir (java.awt.event.ActionEvent evt){
       actionPerformed(evt);
   }

    private void actionPerformed(ActionEvent evt) {
        setVisible(false);
        dispose();
    }

}
