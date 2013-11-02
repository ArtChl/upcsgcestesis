/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.view;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.openswing.swing.mdi.client.InternalFrame;
import pe.com.ega.sgces.logic.CierreLogica;
import pe.com.ega.sgces.logic.DepositoLogica;
import pe.com.ega.sgces.logic.DespachoLogica;
import pe.com.ega.sgces.logic.MovimientoLogica;
import pe.com.ega.sgces.logic.TurnoLogica;

/**
 *
 * @author FLOPEZ
 */
public class CierreFrame extends InternalFrame {

    private CierreLogica cierreLogica;
    private TurnoLogica turnoLogica;
    
    public CierreFrame(TurnoLogica turnoLogica, CierreLogica cierreLogica) {
        initComponents();
        this.cierreLogica = cierreLogica;
        this.turnoLogica= turnoLogica;
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
              String mensaje=cierreLogica.cierreTurno(turnoLogica.buscarPorCodigo("N"));
              if(mensaje.equalsIgnoreCase("Cierre"))
              {
                  salir(evt);
                  final JPanel panel = new JPanel();
                  JOptionPane.showMessageDialog(panel,"Cierre Realizado con Existo", "Informacion", JOptionPane.OK_OPTION);
                  
              }else{

                  if(mensaje.equalsIgnoreCase("Caja no Cuadrada"))
                  {
                       final JPanel panel = new JPanel();
                       JOptionPane.showMessageDialog(panel,mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                  }else{
                        final JPanel panel = new JPanel();
                        JOptionPane.showMessageDialog(panel, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                  }
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
     
    
     
     

}
