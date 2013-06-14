/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.view;

import Imprimir.ImprimirComprobante;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import org.openswing.swing.mdi.client.InternalFrame;
import pe.com.ega.sgces.dao.DespachoDaoImpl;
import pe.com.ega.sgces.dao.MovimientoDao;
import pe.com.ega.sgces.dao.MovimientoDaoImpl;
import pe.com.ega.sgces.dao.TransaccionDaoImpl;
import pe.com.ega.sgces.logic.DespachoLogicaImpl;
import pe.com.ega.sgces.logic.MovimientoLogicaImpl;
import pe.com.ega.sgces.logic.TransaccionLogicaImpl;
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.model.Movimiento;
import pe.com.ega.sgces.model.Transaccion;
import pe.com.ega.sgces.model.Turnopuntoventacaja;
import pe.com.ega.sgces.model.TurnopuntoventacajaId;

/**
 *
 * @author FLOPEZ
 */
public class MonedaFrame extends InternalFrame {

    private Despacho desp;
    private ImprimirComprobante comprobante;
    private Transaccion transaccion;
    private Movimiento movimiento;
    private TransaccionLogicaImpl transaccionLogica;
    private DespachoLogicaImpl despachoLogica;
    private MovimientoLogicaImpl movimientoLogica;
    private String moneda;
    private Cliente cliente;
    
    public MonedaFrame(Despacho codigo, String tipo, Cliente cli) 
    {
        initComponents();
        desp=codigo;
        moneda=tipo;
        cliente=cli;
        transaccion=new Transaccion();
        movimiento=new Movimiento();
        transaccionLogica =new TransaccionLogicaImpl();
        transaccionLogica.setTransaccionDao(new TransaccionDaoImpl());
        despachoLogica=new DespachoLogicaImpl();
        despachoLogica.setDespachoDao(new DespachoDaoImpl());
        movimientoLogica=new MovimientoLogicaImpl();
        movimientoLogica.setMovimientoDao(new MovimientoDaoImpl());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        soles = new javax.swing.JButton();
        dolares = new javax.swing.JButton();
        tarjeta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pago = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        numero = new javax.swing.JLabel();
        tarjetas = new javax.swing.JComboBox();
        numtarjeta = new javax.swing.JTextField();

        jPanel1.setLayout(null);

        soles.setText("SOLES");
        soles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solesActionPerformed(evt);
            }
        });
        jPanel1.add(soles);
        soles.setBounds(10, 120, 80, 40);

        dolares.setText("DOLARES");
        dolares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dolaresActionPerformed(evt);
            }
        });
        jPanel1.add(dolares);
        dolares.setBounds(100, 120, 80, 40);

        tarjeta.setText("TARJETA");
        tarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarjetaActionPerformed(evt);
            }
        });
        jPanel1.add(tarjeta);
        tarjeta.setBounds(190, 120, 79, 40);

        jLabel1.setText("Pago Efectivo:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 20, 80, 14);

        pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagoActionPerformed(evt);
            }
        });
        jPanel1.add(pago);
        pago.setBounds(100, 20, 70, 20);

        jLabel2.setText("Tarjeta");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 50, 70, 14);

        numero.setText("Numero:");
        jPanel1.add(numero);
        numero.setBounds(20, 80, 70, 14);

        tarjetas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "VISA", "MASTERCARD", " " }));
        tarjetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarjetasActionPerformed(evt);
            }
        });
        jPanel1.add(tarjetas);
        tarjetas.setBounds(100, 50, 140, 22);

        numtarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numtarjetaActionPerformed(evt);
            }
        });
        jPanel1.add(numtarjeta);
        numtarjeta.setBounds(100, 80, 150, 20);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void solesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solesActionPerformed
        if("BOL".equals(moneda)){
            imprimirBoleta(desp, evt);
            llenarMovimiento(transaccion, moneda, Double.parseDouble(pago.getText()));
        }else{
            imprimirFactura(desp, cliente, evt);
            llenarMovimiento(transaccion, moneda, Double.parseDouble(pago.getText()));
        }
        
    }//GEN-LAST:event_solesActionPerformed

    private void dolaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dolaresActionPerformed
        if("BOL".equals(moneda)){
            imprimirBoleta(desp, evt);
            llenarMovimiento(transaccion, moneda, Double.parseDouble(pago.getText())*2.65);
        }else{
            imprimirFactura(desp, cliente, evt);
            llenarMovimiento(transaccion, moneda, Double.parseDouble(pago.getText())*2.65);
        }
    }//GEN-LAST:event_dolaresActionPerformed

    private void tarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetaActionPerformed
        if("BOL".equals(moneda)){
            imprimirBoleta(desp, evt);
            llenarMovimiento(transaccion, moneda, Double.parseDouble(pago.getText())*2.65);
        }else{
            imprimirFactura(desp, cliente, evt);
            llenarMovimiento(transaccion, moneda, Double.parseDouble(pago.getText())*2.65);
        }
    }//GEN-LAST:event_tarjetaActionPerformed

    private void numtarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numtarjetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numtarjetaActionPerformed

    private void tarjetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetasActionPerformed
        pago.setFocusable(false);
    }//GEN-LAST:event_tarjetasActionPerformed

    private void pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagoActionPerformed
        tarjetas.setFocusable(false);
        numtarjeta.setFocusable(false);
    }//GEN-LAST:event_pagoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dolares;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel numero;
    private javax.swing.JTextField numtarjeta;
    private javax.swing.JTextField pago;
    private javax.swing.JButton soles;
    private javax.swing.JButton tarjeta;
    private javax.swing.JComboBox tarjetas;
    // End of variables declaration//GEN-END:variables

   public void imprimirBoleta(Despacho desp, java.awt.event.ActionEvent evt){
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
          //  transaccion=new Transaccion();
        }
   }
   public void imprimirFactura(Despacho desp, Cliente cli,java.awt.event.ActionEvent evt){
       System.out.println("Cliente"+cliente.getId());
       comprobante = new ImprimirComprobante();
       llenardatosF(desp,cli);
       try {
           transaccionLogica.grabar(transaccion);
               despachoLogica.grabar(desp);
               comprobante.imprimirFactura(cli.getRazonSocial(),
               String.valueOf(cli.getNumeroDocumento()) ,"LOPEZ CORDOVA", String.valueOf(desp.getMontoSoles()), String.valueOf(Math.rint(desp.getMontoSoles()*0.82*100)/100),String.valueOf(Math.rint(desp.getMontoSoles()*0.18*100)/100),String.valueOf(desp.getPrecioUnitario()), desp.getProducto().getNombre()
                 , String.valueOf(desp.getNroGalones()), "1", "325", "10419492421", "FF9G151648", "TBOL");
               salir(evt);
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
       }
               
           
   }

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
       // return transaccion;
    }
    
    private void llenarMovimiento(Transaccion transaccion, String pag, Double monto){
        movimiento.setTransaccion(transaccion);
        movimiento.setPago(pag);
        Turnopuntoventacaja caja= new Turnopuntoventacaja();
        caja.setId(new TurnopuntoventacajaId(1, 1, 1));
        movimiento.setTurnopuntoventacaja(caja);
        movimiento.setMontoTotal(desp.getMontoSoles());
        movimiento.setMontoRecibido(monto);
        movimiento.setMontoDevuelto(monto-desp.getMontoSoles());
        try {
            movimientoLogica.grabar(movimiento);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    private void llenardatosF(Despacho desp, Cliente nuevo) {
        transaccion.setDespacho(desp);
        transaccion.setIdTipoTransaccion("TFAC");
        transaccion.setIdEstado(1);
        transaccion.setNumeroTransaccion(String.valueOf(desp.getId()));
        transaccion.setNumeroVale("325-00000001");
        transaccion.setNroGalones(desp.getNroGalones());
        transaccion.setPrecioUnitario(desp.getPrecioUnitario());
        transaccion.setProducto(desp.getProducto().getNombre());
        transaccion.setMontoTotal(desp.getMontoSoles());
        transaccion.setFechaRegistro(desp.getFechaRegistro());
        transaccion.setCliente(nuevo);
    }

}
