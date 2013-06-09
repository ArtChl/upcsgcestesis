/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.view;

import Imprimir.ImprimirComprobante;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
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
public class OpcionFrame extends org.openswing.swing.mdi.client.InternalFrame {

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        depacho = new javax.swing.JButton();
        factura = new javax.swing.JButton();
        boleta = new javax.swing.JButton();

        jPanel1.setLayout(null);

        depacho.setText("NDES");
        depacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depachoActionPerformed(evt);
            }
        });
        jPanel1.add(depacho);
        depacho.setBounds(30, 10, 59, 50);

        factura.setText("FACT");
        factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaActionPerformed(evt);
            }
        });
        jPanel1.add(factura);
        factura.setBounds(110, 10, 59, 50);

        boleta.setText("TBOL");
        boleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boletaActionPerformed(evt);
            }
        });
        jPanel1.add(boleta);
        boleta.setBounds(190, 10, 57, 50);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaActionPerformed
        FacturaFrame f=new FacturaFrame(desp);
            f.setSize(391,151);
            f.setTitle("Factura");
            MDIFrame.add(f);
            //salir(evt);
    }//GEN-LAST:event_facturaActionPerformed

    private void boletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boletaActionPerformed
        System.out.println("Despacho"+desp.getId()+desp.getCaraproducto().getProducto()+desp.getCaraproducto().getCara());
        comprobante=new ImprimirComprobante();    
        llenardatos(desp);       
        try {
            transaccionLogica.grabar(transaccion);
            despachoLogica.grabar(desp);
            comprobante.imprimirBoleta("LOPEZ CORDOVA", String.valueOf(desp.getMontoSoles()), String.valueOf(desp.getPrecioUnitario()), desp.getProducto().getNombre()
                 , String.valueOf(desp.getNroGalones()), "1", "325", "10419492421", "FF9G151648", "TBOL");
            salir(evt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
       
        }finally{
            transaccion=new Transaccion();
        }
        
    }//GEN-LAST:event_boletaActionPerformed

    private void depachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depachoActionPerformed
        NotaFrame f=new NotaFrame(desp);
            f.setSize(290,250);
            f.setTitle("Nota Despacho");
            MDIFrame.add(f);
            //salir(evt);
    }//GEN-LAST:event_depachoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boleta;
    private javax.swing.JButton depacho;
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

    private void llenardatos(Despacho desp) {
        transaccion.setDespacho(desp);
        transaccion.setIdTipoTransaccion("TBOL");
        transaccion.setIdEstado(1);
        transaccion.setNumeroTransaccion(String.valueOf(desp.getId()));
        transaccion.setNumeroVale("325-00000001");
        transaccion.setNroGalones(desp.getNroGalones());
        transaccion.setPrecioUnitario(desp.getPrecioUnitario());
        transaccion.setProducto(desp.getProducto().getNombre());
        transaccion.setMontoTotal(desp.getMontoSoles());
        transaccion.setFechaRegistro(desp.getFechaRegistro());
        Cliente clie= new Cliente();
        clie.setId(1);
        transaccion.setCliente(clie);
    }
}
