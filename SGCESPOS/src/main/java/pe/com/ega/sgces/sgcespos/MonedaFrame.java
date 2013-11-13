/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.sgcespos;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import pe.com.ega.sgces.logic.DespachoLogica;
import pe.com.ega.sgces.logic.MovimientoLogica;
import pe.com.ega.sgces.logic.NumComprobanteLogica;
import pe.com.ega.sgces.logic.TransaccionLogica;
import pe.com.ega.sgces.logic.TurnoLogica;
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.model.Movimiento;
import pe.com.ega.sgces.model.Numcomprobante;
import pe.com.ega.sgces.model.Transaccion;
import pe.com.ega.sgces.model.Turnopuntoventacaja;
import pe.com.ega.sgces.model.TurnopuntoventacajaId;
import pe.com.ega.sgces.util.Formato;
import pe.com.ega.sgces.util.ImprimirComprobante;

/**
 *
 * @author FLOPEZ
 */
public class MonedaFrame extends JFrame {

    private final static Logger logger = Logger.getLogger(MonedaFrame.class);
    private Despacho desp;
    private ImprimirComprobante comprobante;
    private Transaccion transaccion;
    private Movimiento movimiento;
    private TransaccionLogica transaccionLogica;
    private DespachoLogica despachoLogica;
    private MovimientoLogica movimientoLogica;
    private TurnoLogica turnoLogica;
    private String moneda;
    private Cliente cliente;
    private NumComprobanteLogica numComprobanteLogica;

    //TODO El constructor tiene muchos aprametros
    public MonedaFrame(Despacho codigo, String tipo, Cliente cli, DespachoLogica despachoLogica, MovimientoLogica movimientoLogica, TurnoLogica turnoLogica, TransaccionLogica transaccionLogica, NumComprobanteLogica numComprobanteLogica) {
        initComponents();
        desp = codigo;
        moneda = tipo;
        cliente = cli;
        transaccion = new Transaccion();
        movimiento = new Movimiento();
        this.transaccionLogica = transaccionLogica;
        this.despachoLogica = despachoLogica;
        this.movimientoLogica = movimientoLogica;
        this.turnoLogica = turnoLogica;
        this.numComprobanteLogica = numComprobanteLogica;
        comprobante = new ImprimirComprobante();
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

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        soles.setBackground(new java.awt.Color(51, 153, 255));
        soles.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        soles.setMnemonic(KeyEvent.VK_S);
        soles.setText("SOLES");
        soles.setMaximumSize(new java.awt.Dimension(123, 37));
        soles.setMinimumSize(new java.awt.Dimension(123, 37));
        soles.setPreferredSize(new java.awt.Dimension(123, 37));
        soles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solesActionPerformed(evt);
            }
        });
        jPanel1.add(soles);
        soles.setBounds(30, 240, 150, 80);

        dolares.setBackground(new java.awt.Color(133, 238, 75));
        dolares.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        dolares.setMnemonic(KeyEvent.VK_D);
        dolares.setText("DOLARES");
        dolares.setMaximumSize(new java.awt.Dimension(123, 37));
        dolares.setMinimumSize(new java.awt.Dimension(123, 37));
        dolares.setPreferredSize(new java.awt.Dimension(123, 37));
        dolares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dolaresActionPerformed(evt);
            }
        });
        jPanel1.add(dolares);
        dolares.setBounds(190, 240, 160, 80);

        tarjeta.setBackground(new java.awt.Color(255, 235, 90));
        tarjeta.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        tarjeta.setMnemonic(KeyEvent.VK_T);
        tarjeta.setText("TARJETA");
        tarjeta.setMaximumSize(new java.awt.Dimension(123, 37));
        tarjeta.setMinimumSize(new java.awt.Dimension(123, 37));
        tarjeta.setPreferredSize(new java.awt.Dimension(123, 37));
        tarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarjetaActionPerformed(evt);
            }
        });
        jPanel1.add(tarjeta);
        tarjeta.setBounds(360, 240, 140, 80);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel1.setText("PAGO :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 40, 100, 30);

        pago.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagoActionPerformed(evt);
            }
        });
        jPanel1.add(pago);
        pago.setBounds(190, 30, 140, 35);

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel2.setText("TARJETA :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 90, 120, 30);

        numero.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        numero.setText("NUMERO :");
        jPanel1.add(numero);
        numero.setBounds(30, 150, 120, 30);

        tarjetas.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        tarjetas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "VISA", "MASTERCARD", " " }));
        tarjetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarjetasActionPerformed(evt);
            }
        });
        jPanel1.add(tarjetas);
        tarjetas.setBounds(190, 90, 140, 40);

        numtarjeta.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        numtarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numtarjetaActionPerformed(evt);
            }
        });
        jPanel1.add(numtarjeta);
        numtarjeta.setBounds(190, 150, 310, 40);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void solesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solesActionPerformed

        if ("BOL".equals(moneda)) {
            imprimirBoleta(desp, evt);
            llenarMovimiento(transaccion, moneda, BigDecimal.valueOf(Double.parseDouble(pago.getText())), "", "SOLES");
        } else {
            imprimirFactura(desp, cliente, evt);
            llenarMovimiento(transaccion, moneda, BigDecimal.valueOf(Double.parseDouble(pago.getText())), "", "SOLES");
        }
    }//GEN-LAST:event_solesActionPerformed

    private void dolaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dolaresActionPerformed
        if ("BOL".equals(moneda)) {
            imprimirBoleta(desp, evt);
            llenarMovimiento(transaccion, moneda, BigDecimal.valueOf(Double.parseDouble(pago.getText())).multiply(new BigDecimal("2.65")), "", "DOLARES");
        } else {
            imprimirFactura(desp, cliente, evt);
            llenarMovimiento(transaccion, moneda, BigDecimal.valueOf(Double.parseDouble(pago.getText())).multiply(new BigDecimal("2.65")), "", "DOLARES");
        }
    }//GEN-LAST:event_dolaresActionPerformed

    private void tarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetaActionPerformed
        if ("BOL".equals(moneda)) {
            imprimirBoleta(desp, evt);
            llenarMovimiento(transaccion, moneda, BigDecimal.ZERO, numtarjeta.getText(), "TARJETA");
        } else {
            imprimirFactura(desp, cliente, evt);
            llenarMovimiento(transaccion, moneda, BigDecimal.ZERO, numtarjeta.getText(), "TARJETA");
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

    public void imprimirBoleta(Despacho desp, java.awt.event.ActionEvent evt) {

        llenardatos(desp, cliente);
        try {
            DecimalFormat f = new DecimalFormat("##.00"); 
            transaccionLogica.grabar(transaccion);
            despachoLogica.grabar(desp);
            comprobante.imprimirBoleta("LOPEZ CORDOVA", String.valueOf(f.format(desp.getMontosoles())), String.valueOf(f.format(desp.getPreciounitario())), desp.getProducto().getNombre(), String.valueOf(f.format(desp.getNrogalones())), String.valueOf(transaccion.getNumero()), "325", "10419492421", "FF9G151648", "TBOL");
            salir(evt);
        } catch (Exception ex) {
            logger.error("Mensaje:\n" + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void imprimirFactura(Despacho desp, Cliente cli, java.awt.event.ActionEvent evt) {

        llenardatos(desp, cli);
        try {
            DecimalFormat f = new DecimalFormat("##.00"); 
            transaccionLogica.grabar(transaccion);
            despachoLogica.grabar(desp);
            comprobante.imprimirFactura(cli.getNumerodocumento(),cli.getRazonsocial(),"FRANK LOPEZ",String.valueOf(f.format(desp.getMontosoles())), String.valueOf(f.format(desp.getMontosoles().multiply(new BigDecimal(0.82)))),String.valueOf(f.format(desp.getMontosoles().multiply(new BigDecimal(0.18)))),String.valueOf(f.format(desp.getPreciounitario())), desp.getProducto().getNombre(), String.valueOf(f.format(desp.getNrogalones())), String.valueOf(transaccion.getNumero()), "325", "10419492421", "FF9G151648", "FACT");
            salir(evt);
        } catch (Exception ex) {
            logger.error("Mensaje:\n" + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salir(java.awt.event.ActionEvent evt) {
        actionPerformed(evt);
    }

    private void actionPerformed(ActionEvent evt) {
        setVisible(false);
        dispose();
    }

    private void llenardatos(Despacho desp, Cliente cliente) {
        transaccion.setDespacho(desp);
        int codigo = 0;
        try {
            codigo = turnoLogica.buscarPorCodigo("N").getId();
        } catch (Exception e) {
            logger.error("Mensaje:\n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se encontro el turno", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        transaccion.setIdestado(codigo);
        transaccion.setNumerotransaccion(String.valueOf(desp.getId()));

        transaccion.setNrogalones(desp.getNrogalones());
        transaccion.setPreciounitario(desp.getPreciounitario());
        transaccion.setProducto(desp.getProducto().getNombre());
        transaccion.setMontototal(desp.getMontosoles());
        transaccion.setFecharegistro(desp.getFecharegistro());
        transaccion.setTurno(desp.getTurno());

        //TODO Luego que se hace con el objeto transaccion?
        if (cliente.getId() == 2) {
            transaccion.setCliente(cliente);
            transaccion.setIdtipotransaccion("TBOL");
            Numcomprobante comprobantes = numComprobanteLogica.buscarPorCodigo(2);
            transaccion.setNumerovale("325-" + Formato.agregarCeros(String.valueOf(comprobantes.getNumero()), 8));
            transaccion.setNumero(comprobantes.getNumero());
            comprobantes.setNumero(comprobantes.getNumero()+1);
            numComprobanteLogica.actualizar(comprobantes);
        } else {
            transaccion.setCliente(cliente);
            transaccion.setIdtipotransaccion("FACT");
            Numcomprobante comprobantes = numComprobanteLogica.buscarPorCodigo(3);
            transaccion.setNumerovale("325-" + Formato.agregarCeros(String.valueOf(comprobantes.getNumero()), 8));
            transaccion.setNumero(comprobantes.getNumero());
            comprobantes.setNumero(comprobantes.getNumero()+1);
            numComprobanteLogica.actualizar(comprobantes);
            
        }

    }

    private void llenarMovimiento(Transaccion transaccion, String pag, BigDecimal monto, String tarjeta, String tipo) {
        movimiento.setTransaccion(transaccion);
        movimiento.setPago(pag);
        Turnopuntoventacaja caja = new Turnopuntoventacaja();
        TurnopuntoventacajaId turnopuntoventacajaId = new TurnopuntoventacajaId();
        turnopuntoventacajaId.setIdturno(turnoLogica.buscarPorCodigo("N").getId());
        turnopuntoventacajaId.setIdcaja(1);
        turnopuntoventacajaId.setIdpuntoventa(1);
        caja.setId(turnopuntoventacajaId);
        movimiento.setTurnopuntoventacaja(caja);
        movimiento.setMontototal(desp.getMontosoles());
        if ("TARJETA".equals(tipo)) {
            movimiento.setTipo(tarjeta);
            movimiento.setNrooperacion(numtarjeta.getText());
            movimiento.setTipo((String) tarjetas.getSelectedItem());
            movimiento.setMontorecibido(desp.getMontosoles());
            movimiento.setMontodevuelto(BigDecimal.ZERO);
        } else {
            movimiento.setTipo(tipo);
            movimiento.setMontorecibido(monto);
            movimiento.setMontodevuelto(monto.subtract(desp.getMontosoles()));
        }

        movimiento.setTurno(desp.getTurno());
        movimiento.setCerrado("N");
        movimiento.setFecharegistro(new Date());
        
        try {
            movimientoLogica.grabar(movimiento);
        } catch (Exception e) {
            logger.error("Mensaje:\n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se puedo grabar el movimiento.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
