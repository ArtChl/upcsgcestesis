/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.view;

import Imprimir.ImprimirComprobante;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.openswing.swing.mdi.client.InternalFrame;
import pe.com.ega.sgces.dao.NumComprobanteDaoImpl;
import pe.com.ega.sgces.dao.TransaccionDaoImpl;
import pe.com.ega.sgces.logic.DespachoLogica;
import pe.com.ega.sgces.logic.MovimientoLogica;
import pe.com.ega.sgces.logic.NumComprobanteLogicaImpl;
import pe.com.ega.sgces.logic.TransaccionLogica;
import pe.com.ega.sgces.logic.TransaccionLogicaImpl;
import pe.com.ega.sgces.logic.TurnoLogica;
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.model.Movimiento;
import pe.com.ega.sgces.model.Numcomprobante;
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
    private TransaccionLogica transaccionLogica;
    private DespachoLogica despachoLogica;
    private MovimientoLogica movimientoLogica;
    private TurnoLogica turnoLogica;
    private String moneda;
    private Cliente cliente;
    private NumComprobanteLogicaImpl numdao;
    
    public MonedaFrame(Despacho codigo, String tipo, Cliente cli, DespachoLogica despachoLogica, MovimientoLogica movimientoLogica, TurnoLogica turnoLogica, TransaccionLogica transaccionLogica) 
    {
        initComponents();
        desp=codigo;
        moneda=tipo;
        cliente=cli;
        transaccion=new Transaccion();
        movimiento=new Movimiento();
        this.transaccionLogica = transaccionLogica;
        this.despachoLogica=despachoLogica;
        this.movimientoLogica=movimientoLogica;
        this.turnoLogica =turnoLogica;
        numdao = new NumComprobanteLogicaImpl();
        numdao.setValeDao(new NumComprobanteDaoImpl()); 
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
        dolares.setBounds(100, 120, 90, 40);

        tarjeta.setText("TARJETA");
        tarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarjetaActionPerformed(evt);
            }
        });
        jPanel1.add(tarjeta);
        tarjeta.setBounds(200, 120, 85, 40);

        jLabel1.setText("Pago Efectivo:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 20, 80, 16);

        pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagoActionPerformed(evt);
            }
        });
        jPanel1.add(pago);
        pago.setBounds(100, 20, 70, 22);

        jLabel2.setText("Tarjeta");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 50, 70, 16);

        numero.setText("Numero:");
        jPanel1.add(numero);
        numero.setBounds(20, 80, 70, 16);

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
        numtarjeta.setBounds(100, 80, 150, 22);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void solesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solesActionPerformed
        System.out.println("Pago"+pago.getText()+"//"+desp.getMontosoles());
        if(desp.getMontosoles()<Double.parseDouble(pago.getText())){
            if("BOL".equals(moneda)){
                imprimirBoleta(desp, evt);
                llenarMovimientoSoles(transaccion, moneda, Double.parseDouble(pago.getText()));
            }else{
                imprimirFactura(desp, cliente, evt);
                llenarMovimientoSoles(transaccion, moneda, Double.parseDouble(pago.getText()));
            }
        }else{
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Monto Pagado Menor al Despacho", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_solesActionPerformed

    private void dolaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dolaresActionPerformed
        System.out.println("Pago"+pago.getText()+"//"+desp.getMontosoles());
        if(desp.getMontosoles()<Double.parseDouble(pago.getText())*2.65){
            if("BOL".equals(moneda)){
                imprimirBoleta(desp, evt);
                llenarMovimientoDolares(transaccion, moneda, Double.parseDouble(pago.getText())*2.65,pago.getText());
            }else{
                imprimirFactura(desp, cliente, evt);
                llenarMovimientoDolares(transaccion, moneda, Double.parseDouble(pago.getText())*2.65,pago.getText());
            }
        }else{
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Monto Pagado Menor al Despacho", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_dolaresActionPerformed

    private void tarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetaActionPerformed
        if("BOL".equals(moneda)){
            imprimirBoleta(desp, evt);
            llenarMovimientoTarjeta(transaccion, moneda, numtarjeta.getText());
        }else{
            imprimirFactura(desp, cliente, evt);
            llenarMovimientoTarjeta(transaccion, moneda, numtarjeta.getText());
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
            comprobante.imprimirBoleta("LOPEZ CORDOVA", String.valueOf(desp.getMontosoles()), String.valueOf(desp.getPreciounitario()), desp.getProducto().getNombre()
                 , String.valueOf(desp.getNrogalones()), String.valueOf(transaccion.getNumero()), "325", "10419492421", "FF9G151648", "TBOL");
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
               comprobante.imprimirFactura(cli.getRazonsocial(),
               String.valueOf(cli.getNumerodocumento()) ,"LOPEZ CORDOVA", String.valueOf(desp.getMontosoles()), String.valueOf(Math.rint(desp.getMontosoles()*0.82*100)/100),String.valueOf(Math.rint(desp.getMontosoles()*0.18*100)/100),String.valueOf(desp.getPreciounitario()), desp.getProducto().getNombre()
                 , String.valueOf(desp.getNrogalones()), String.valueOf(transaccion.getNumero()), "325", "10419492421", "FF9G151648", "TBOL");
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
        
        Numcomprobante comprobantes= numdao.buscarPorCodigo(2);
        
        transaccion.setDespacho(desp);
        transaccion.setIdtipotransaccion("TBOL");
        transaccion.setIdestado(turnoLogica.buscarPorCodigo("N").getId());
        transaccion.setNumerotransaccion(String.valueOf(desp.getId()));
        transaccion.setNumerovale("325-"+agregarCeros(String.valueOf(comprobantes.getNumero()),8));
        transaccion.setNumero(comprobantes.getNumero());
        transaccion.setNrogalones(desp.getNrogalones());
        transaccion.setPreciounitario(desp.getPreciounitario());
        transaccion.setProducto(desp.getProducto().getNombre());
        transaccion.setMontototal(desp.getMontosoles());
        transaccion.setFecharegistro(desp.getFecharegistro());
        transaccion.setTurno(desp.getTurno());
        comprobantes.setNumero(comprobantes.getNumero()+1);
        numdao.actualizar(comprobantes);
        Cliente clie= new Cliente();
        clie.setId(1);
        transaccion.setCliente(clie);
        
       
    }
    
    private void llenarMovimientoSoles(Transaccion transaccion, String pag, Double monto){
        movimiento.setTransaccion(transaccion);
        movimiento.setPago(pag);
        Turnopuntoventacaja caja= new Turnopuntoventacaja();
        caja.setId(new TurnopuntoventacajaId(turnoLogica.buscarPorCodigo("N").getId(),1,1));
        movimiento.setTurnopuntoventacaja(caja);
        movimiento.setMontototal(desp.getMontosoles());
        movimiento.setMontorecibido(monto);
        movimiento.setTipo("SOLES");
        movimiento.setTurno(desp.getTurno());
        movimiento.setCerrado("N");
        movimiento.setMontodevuelto(monto-desp.getMontosoles());
        movimiento.setFecharegistro(new Date());
        try {
            movimientoLogica.grabar(movimiento);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    private void llenarMovimientoDolares(Transaccion transaccion, String pag, Double monto, String montes){
        movimiento.setTransaccion(transaccion);
        movimiento.setPago(pag);
        Turnopuntoventacaja caja= new Turnopuntoventacaja();
        caja.setId(new TurnopuntoventacajaId(turnoLogica.buscarPorCodigo("N").getId(),1,1));
        movimiento.setTurnopuntoventacaja(caja);
        movimiento.setMontototal(desp.getMontosoles());
        movimiento.setMontorecibido(monto);
        movimiento.setNrooperacion(montes);
        movimiento.setTipo("DOLARES");
        movimiento.setTurno(desp.getTurno());
        movimiento.setCerrado("N");
        movimiento.setMontodevuelto(monto-desp.getMontosoles());
        movimiento.setFecharegistro(new Date());
        try {
            movimientoLogica.grabar(movimiento);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    private void llenarMovimientoTarjeta(Transaccion transaccion, String pag, String monto){
        movimiento.setTransaccion(transaccion);
        movimiento.setPago(pag);
        Turnopuntoventacaja caja= new Turnopuntoventacaja();
        caja.setId(new TurnopuntoventacajaId(turnoLogica.buscarPorCodigo("N").getId(),1,1));
        movimiento.setTurnopuntoventacaja(caja);
        movimiento.setMontototal(desp.getMontosoles());
        movimiento.setMontorecibido(desp.getMontosoles());
        movimiento.setTipo((String)tarjetas.getSelectedItem());
        movimiento.setTurno(desp.getTurno());
        movimiento.setCerrado("N");
        movimiento.setMontodevuelto(0.0);
        movimiento.setNrooperacion(monto);
        movimiento.setFecharegistro(new Date());
        try {
            movimientoLogica.grabar(movimiento);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    private void llenardatosF(Despacho desp, Cliente nuevo) {
        Numcomprobante comprobantes= numdao.buscarPorCodigo(3);
        
        transaccion.setDespacho(desp);
        transaccion.setIdtipotransaccion("TFAC");
        transaccion.setIdestado(turnoLogica.buscarPorCodigo("N").getId());
        transaccion.setNumerotransaccion(String.valueOf(desp.getId()));
        transaccion.setNumerovale("325-"+agregarCeros(String.valueOf(comprobantes.getNumero()),8));
        transaccion.setNumero(comprobantes.getNumero());
        transaccion.setNrogalones(desp.getNrogalones());
        transaccion.setPreciounitario(desp.getPreciounitario());
        transaccion.setProducto(desp.getProducto().getNombre());
        transaccion.setMontototal(desp.getMontosoles());
        transaccion.setFecharegistro(desp.getFecharegistro());
        transaccion.setCliente(nuevo);
        transaccion.setTurno(desp.getTurno());
        
        comprobantes.setNumero(comprobantes.getNumero()+1);
        numdao.actualizar(comprobantes);
    }
    
    private static String agregarCeros(String string, int largo)
    {
    	String ceros = "";
    	int cantidad = largo - string.length();
    	if (cantidad >= 1){
    		for(int i=0;i<cantidad;i++)
    		{
    		ceros += "0";	
    		}
    		return (ceros + string);
    	}else {
            return string;
        }
    }

}
