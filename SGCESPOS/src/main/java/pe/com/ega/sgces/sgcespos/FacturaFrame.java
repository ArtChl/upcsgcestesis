/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.sgcespos;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.openswing.swing.mdi.client.MDIFrame;
import pe.com.ega.sgces.dao.ClienteDaoImpl;
import pe.com.ega.sgces.logic.ClienteLogicaImpl;
import pe.com.ega.sgces.logic.DespachoLogica;
import pe.com.ega.sgces.logic.MovimientoLogica;
import pe.com.ega.sgces.logic.TransaccionLogica;
import pe.com.ega.sgces.logic.TurnoLogica;
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.model.Despacho;

/**
 *
 * @author FLOPEZ
 */
public class FacturaFrame extends JFrame {

    private Despacho desp;
    private ClienteLogicaImpl clienteLogica;
    private Cliente cliente;
    private TransaccionLogica transaccionLogica;
    private DespachoLogica despachoLogica;
    private MovimientoLogica movimientoLogica;
    private TurnoLogica turnoLogica;

    public FacturaFrame(Despacho despacho, DespachoLogica despachoLogica, MovimientoLogica movimientoLogica, TurnoLogica turnoLogica, TransaccionLogica transaccionLogica) {
        initComponents();
        desp = despacho;
        clienteLogica = new ClienteLogicaImpl();
        clienteLogica.setClienteDao(new ClienteDaoImpl());
        this.transaccionLogica = transaccionLogica;
        this.despachoLogica = despachoLogica;
        this.movimientoLogica = movimientoLogica;
        this.turnoLogica = turnoLogica;
        limpiar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jrucCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jrazonCliente = new javax.swing.JTextField();
        imprimir = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        bcliente = new javax.swing.JButton();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel1.setText("RAZON SOCIAL :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 80, 200, 40);

        jrucCliente.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jrucCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrucClienteActionPerformed(evt);
            }
        });
        jrucCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jrucClienteFocusGained(evt);
            }
        });
        jPanel1.add(jrucCliente);
        jrucCliente.setBounds(240, 30, 170, 40);

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel2.setText("R.U.C :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 30, 150, 40);

        jrazonCliente.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jPanel1.add(jrazonCliente);
        jrazonCliente.setBounds(240, 80, 350, 40);

        imprimir.setBackground(new java.awt.Color(133, 238, 75));
        imprimir.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        imprimir.setText("ACEPTAR");
        imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirActionPerformed(evt);
            }
        });
        jPanel1.add(imprimir);
        imprimir.setBounds(40, 160, 180, 80);

        cancelar.setBackground(new java.awt.Color(255, 235, 90));
        cancelar.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        cancelar.setText("CANCELAR");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar);
        cancelar.setBounds(420, 160, 170, 80);

        bcliente.setBackground(new java.awt.Color(51, 153, 255));
        bcliente.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        bcliente.setText("NUEVO");
        bcliente.setEnabled(false);
        bcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bclienteActionPerformed(evt);
            }
        });
        jPanel1.add(bcliente);
        bcliente.setBounds(230, 160, 170, 80);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jrucClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrucClienteActionPerformed
        String rucCliente = jrucCliente.getText();
        try {
            cliente = clienteLogica.buscarPorCodigo(rucCliente);
            jrazonCliente.setText(cliente.getRazonsocial());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se Encontro Cliente", "Error", JOptionPane.ERROR_MESSAGE);
            cliente = new Cliente();
            cliente.setId(0);
        }
    }//GEN-LAST:event_jrucClienteActionPerformed

    private void jrucClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jrucClienteFocusLost
        String rucCliente = jrucCliente.getText();
        try {
            cliente = clienteLogica.buscarPorCodigo(rucCliente);
            jrazonCliente.setText(cliente.getRazonsocial());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se Encontro Cliente", "Error", JOptionPane.ERROR_MESSAGE);
            cliente = new Cliente();
            cliente.setId(0);
        }
    }//GEN-LAST:event_jrucClienteFocusLost

    private void jrucClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jrucClienteFocusGained
        jrucCliente.setText("");
        jrazonCliente.setText("");
    }//GEN-LAST:event_jrucClienteFocusGained

    private void imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirActionPerformed
        if (cliente.getId() == 0) {
            Cliente temporal1 = new Cliente();
            temporal1.setNumerodocumento(jrucCliente.getText());
            temporal1.setRazonsocial(jrazonCliente.getText());
            clienteLogica.grabar(temporal1);
            MonedaFrame f = new MonedaFrame(desp, "TFAC", temporal1, despachoLogica, movimientoLogica, turnoLogica, transaccionLogica);
            f.setSize(528, 395);
            f.setTitle("TIPO DE PAGO");
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            salir(evt);

        } else {
            MonedaFrame f = new MonedaFrame(desp, "TFAC", cliente, despachoLogica, movimientoLogica, turnoLogica, transaccionLogica);
            f.setSize(528, 395);
            f.setTitle("TIPO DE PAGO");
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            salir(evt);
        }
    }//GEN-LAST:event_imprimirActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        salir(evt);
    }//GEN-LAST:event_cancelarActionPerformed

    private void bclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bclienteActionPerformed
        ClienteFrame f = new ClienteFrame(desp);
        f.setSize(658, 343);
        f.setTitle("CLIENTE TEMPORAL");
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }//GEN-LAST:event_bclienteActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcliente;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton imprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jrazonCliente;
    private javax.swing.JTextField jrucCliente;
    // End of variables declaration//GEN-END:variables

    private void salir(java.awt.event.ActionEvent evt) {
        actionPerformed(evt);
    }

    private void actionPerformed(ActionEvent evt) {
        setVisible(false);
        dispose();
    }

    public void limpiar() {
        jrucCliente.setText("");
        jrazonCliente.setText("");
    }
}
