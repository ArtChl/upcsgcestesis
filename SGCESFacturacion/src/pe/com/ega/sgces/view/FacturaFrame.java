/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.view;

import Imprimir.ImprimirComprobante;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import pe.com.ega.sgces.dao.ClienteDao;
import pe.com.ega.sgces.dao.ClienteDaoImpl;
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.model.Despacho;

/**
 *
 * @author FLOPEZ
 */
public class FacturaFrame extends org.openswing.swing.mdi.client.InternalFrame {

    private Despacho desp;
    private ClienteDao clienteDao;
    private Cliente cliente;
    private Cliente temporal;
    private ImprimirComprobante comprobante;
    public FacturaFrame(Despacho despacho) {
        initComponents();
        desp=despacho;
        cliente= new Cliente();
        clienteDao=new ClienteDaoImpl();
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

        jPanel1.setLayout(null);

        jLabel1.setText("Razon Social :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 60, 80, 14);

        jrucCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrucClienteActionPerformed(evt);
            }
        });
        jrucCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jrucClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jrucClienteFocusLost(evt);
            }
        });
        jPanel1.add(jrucCliente);
        jrucCliente.setBounds(100, 30, 170, 20);

        jLabel2.setText("R.U.C");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 30, 34, 14);
        jPanel1.add(jrazonCliente);
        jrazonCliente.setBounds(100, 60, 260, 20);

        imprimir.setText("Imprimir");
        imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirActionPerformed(evt);
            }
        });
        jPanel1.add(imprimir);
        imprimir.setBounds(110, 90, 80, 23);

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar);
        cancelar.setBounds(200, 90, 75, 23);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jrucClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrucClienteActionPerformed
        
    }//GEN-LAST:event_jrucClienteActionPerformed

    private void jrucClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jrucClienteFocusLost
        String rucCliente=jrucCliente.getText();
        try{
            cliente=clienteDao.buscraPorCodigo(Integer.parseInt(rucCliente));
            jrazonCliente.setText(cliente.getRazonSocial());
            temporal=new Cliente();
            temporal.setId(0);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se Encontro Cliente", "Error", JOptionPane.ERROR_MESSAGE);
            temporal.setId(1);
        }     
    }//GEN-LAST:event_jrucClienteFocusLost

    private void jrucClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jrucClienteFocusGained
        jrucCliente.setText("");
        jrazonCliente.setText("");
    }//GEN-LAST:event_jrucClienteFocusGained

    private void imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirActionPerformed
       //System.out.println("Cliente"+temporal.getId());
       comprobante = new ImprimirComprobante();
       if(temporal.getId()==1){        
           System.out.println("Cliente"+temporal.getId());
           Cliente temporal1 = new Cliente();
           temporal1.setId(Integer.parseInt(jrucCliente.getText()));
           temporal1.setNumeroDocumento(jrucCliente.getText());
           temporal1.setRazonSocial(jrazonCliente.getText());
           try {
               clienteDao.insertar(temporal1);
               temporal1 = new Cliente();
               comprobante.imprimirFactura(temporal1.getRazonSocial(),
                String.valueOf(temporal1.getId()) ,"LOPEZ CORDOVA", String.valueOf(desp.getMontoSoles()), String.valueOf(desp.getMontoSoles()*0.82),String.valueOf(desp.getMontoSoles()*0.18),String.valueOf(desp.getPrecioUnitario()), desp.getProducto().getNombre()
                 , String.valueOf(desp.getNroGalones()), "1", "325", "10419492421", "FF9G151648", "TBOL");
               limpiar();
           } catch (Exception e) {
               System.out.println("e");
           }          
       }else{
           comprobante.imprimirFactura(cliente.getRazonSocial(),
                String.valueOf(cliente.getId()) ,"LOPEZ CORDOVA", String.valueOf(desp.getMontoSoles()), String.valueOf(Redondear(desp.getMontoSoles()*0.82)),String.valueOf(Redondear(desp.getMontoSoles()*0.18)),String.valueOf(desp.getPrecioUnitario()), desp.getProducto().getNombre()
                 , String.valueOf(desp.getNroGalones()), "1", "325", "10419492421", "FF9G151648", "TBOL");
           limpiar();
       }
    }//GEN-LAST:event_imprimirActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        salir(evt);
    }//GEN-LAST:event_cancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton imprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jrazonCliente;
    private javax.swing.JTextField jrucCliente;
    // End of variables declaration//GEN-END:variables
    private void salir (java.awt.event.ActionEvent evt){
       actionPerformed(evt);
   }

    private void actionPerformed(ActionEvent evt) {
        setVisible(false);
        dispose();
    }
    
    public double Redondear(double numero)
{
       int cifras=(int) Math.pow(10,2);
        return Math.rint(numero*cifras)/cifras;
}
    
    public void limpiar(){
        jrucCliente.setText("");
        jrazonCliente.setText("");
    
    }

}
