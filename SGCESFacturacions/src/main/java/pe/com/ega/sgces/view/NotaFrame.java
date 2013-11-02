/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.view;

import Imprimir.ImprimirComprobante;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pe.com.ega.sgces.dao.ClienteDaoImpl;
import pe.com.ega.sgces.dao.DespachoDaoImpl;
import pe.com.ega.sgces.dao.NumComprobanteDaoImpl;
import pe.com.ega.sgces.dao.TransaccionDaoImpl;
import pe.com.ega.sgces.dao.TurnoDaoImpl;
import pe.com.ega.sgces.dao.ValeDaoImpl;
import pe.com.ega.sgces.logic.ClienteLogicaImpl;
import pe.com.ega.sgces.logic.DespachoLogicaImpl;
import pe.com.ega.sgces.logic.NumComprobanteLogicaImpl;
import pe.com.ega.sgces.logic.TransaccionLogicaImpl;
import pe.com.ega.sgces.logic.TurnoLogicaImpl;
import pe.com.ega.sgces.logic.ValeLogicaImpl;
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.model.Numcomprobante;
import pe.com.ega.sgces.model.Transaccion;
import pe.com.ega.sgces.model.Vale;

/**
 *
 * @author FLOPEZ
 */
public class NotaFrame extends org.openswing.swing.mdi.client.InternalFrame {

    private Despacho desp;
    private ClienteLogicaImpl clienteLogica;
    private Cliente cliente;
    private Cliente temporal;
    private Vale valeTemporal;
    private ImprimirComprobante comprobante;
    private Transaccion transaccion;
    private TransaccionLogicaImpl transaccionLogica;
    private DespachoLogicaImpl despachoLogica;
    private TurnoLogicaImpl turnoLogica;
    private ValeLogicaImpl valedao;
    ArrayList<Vale> lista;
    private NumComprobanteLogicaImpl numdao;
   
    public NotaFrame(Despacho despacho) {
        initComponents();
        desp=despacho;
        cliente= new Cliente();
        lista=new ArrayList<>();
        clienteLogica=new ClienteLogicaImpl();
        clienteLogica.setClienteDao(new ClienteDaoImpl());
        transaccion=new Transaccion();
        transaccionLogica =new TransaccionLogicaImpl();
        transaccionLogica.setTransaccionDao(new TransaccionDaoImpl());
        despachoLogica=new DespachoLogicaImpl();
        despachoLogica.setDespachoDao(new DespachoDaoImpl());
        valedao=new ValeLogicaImpl();
        valedao.setValeDao(new ValeDaoImpl());
        turnoLogica =new TurnoLogicaImpl();
        turnoLogica.setTurnoDao(new TurnoDaoImpl());
        numdao = new NumComprobanteLogicaImpl();
        numdao.setValeDao(new NumComprobanteDaoImpl()); 
    }

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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jplaca = new javax.swing.JTextField();
        jchofer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jkilometrajes = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        comboVale = new javax.swing.JComboBox();
        montovale = new javax.swing.JTextField();

        jPanel1.setLayout(null);

        jLabel1.setText("Razon Social :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 60, 80, 16);

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
        jrucCliente.setBounds(100, 30, 170, 22);

        jLabel2.setText("R.U.C");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 30, 34, 16);
        jPanel1.add(jrazonCliente);
        jrazonCliente.setBounds(100, 60, 260, 22);

        imprimir.setText("Confirmar");
        imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirActionPerformed(evt);
            }
        });
        jPanel1.add(imprimir);
        imprimir.setBounds(70, 210, 100, 25);

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar);
        cancelar.setBounds(190, 210, 90, 25);

        jLabel3.setText("Placa :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 120, 39, 16);

        jLabel4.setText("Chofer :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 150, 50, 16);

        jplaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jplacaActionPerformed(evt);
            }
        });
        jPanel1.add(jplaca);
        jplaca.setBounds(100, 120, 90, 22);
        jPanel1.add(jchofer);
        jchofer.setBounds(100, 150, 260, 22);

        jLabel5.setText("Kilometraje :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 180, 70, 16);
        jPanel1.add(jkilometrajes);
        jkilometrajes.setBounds(100, 180, 80, 22);

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        jPanel1.add(buscar);
        buscar.setBounds(277, 30, 80, 25);

        jLabel6.setText("Nro. Vale :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 90, 70, 16);

        comboVale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboValeActionPerformed(evt);
            }
        });
        jPanel1.add(comboVale);
        comboVale.setBounds(100, 90, 130, 22);

        montovale.setEditable(false);
        montovale.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        montovale.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        montovale.setFocusable(false);
        jPanel1.add(montovale);
        montovale.setBounds(290, 90, 70, 22);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jrucClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrucClienteActionPerformed
        
    }//GEN-LAST:event_jrucClienteActionPerformed

    private void jrucClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jrucClienteFocusGained
        jrucCliente.setText("");
        jrazonCliente.setText("");
    }//GEN-LAST:event_jrucClienteFocusGained

    private void imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirActionPerformed
       System.out.println("Monto"+desp.getMontosoles()+"///"+Double.parseDouble(montovale.getText()));
       if(desp.getMontosoles()==Double.parseDouble(montovale.getText())){
          comprobante = new ImprimirComprobante();
          if(temporal.getId()==1){        
           System.out.println("Cliente"+temporal.getId());
           Cliente temporal1 = new Cliente();
           temporal1.setNumerodocumento(jrucCliente.getText());
           temporal1.setRazonsocial(jrazonCliente.getText());
           try {
               llenardatos(desp,cliente);
           transaccionLogica.grabar(transaccion);
           despachoLogica.grabar(desp); 
           SimpleDateFormat format = new SimpleDateFormat("HH:mm");
           Date now = new Date();
           valeTemporal.setFechadespacho(now);
           valeTemporal.setHoradespacho(format.format(now));
           valeTemporal.setEstado(0);
           valedao.actualizar(valeTemporal);
           comprobante.imprimirNotaDespacho(jkilometrajes.getText(),jplaca.getText(),jchofer.getText(),cliente.getRazonsocial(),
                String.valueOf(cliente.getNumerodocumento()) ,"LOPEZ CORDOVA", String.valueOf(desp.getMontosoles()), String.valueOf(Redondear(desp.getMontosoles()*0.82)),String.valueOf(Redondear(desp.getMontosoles()*0.18)),String.valueOf(desp.getPreciounitario()), desp.getProducto().getNombre()
                 , String.valueOf(desp.getNrogalones()), String.valueOf(transaccion.getNumero()), "325", "10419492421", "FF9G151648", "NDES");
           limpiar();
           salir(evt);
           } catch (Exception e) {
               System.out.println("e");
           }          
       }else{
           llenardatos(desp,cliente);
           transaccionLogica.grabar(transaccion);
           despachoLogica.grabar(desp); 
           SimpleDateFormat format = new SimpleDateFormat("HH:mm");
           Date now = new Date();
           valeTemporal.setFechadespacho(now);
           valeTemporal.setHoradespacho(format.format(now));
           valeTemporal.setEstado(0);
           valedao.actualizar(valeTemporal);
           comprobante.imprimirNotaDespacho(jkilometrajes.getText(),jplaca.getText(),jchofer.getText(),cliente.getRazonsocial(),
                String.valueOf(cliente.getNumerodocumento()) ,"LOPEZ CORDOVA", String.valueOf(desp.getMontosoles()), String.valueOf(Redondear(desp.getMontosoles()*0.82)),String.valueOf(Redondear(desp.getMontosoles()*0.18)),String.valueOf(desp.getPreciounitario()), desp.getProducto().getNombre()
                 , String.valueOf(desp.getNrogalones()), String.valueOf(transaccion.getNumero()), "325", "10419492421", "FF9G151648", "NDES");
           limpiar();
           salir(evt);
       }
      }else{
          final JPanel panel = new JPanel();
          JOptionPane.showMessageDialog(panel, "No coincide los Montos", "Error", JOptionPane.ERROR_MESSAGE);
      }
       
    }//GEN-LAST:event_imprimirActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        salir(evt);
    }//GEN-LAST:event_cancelarActionPerformed

    private void jplacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jplacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jplacaActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        String rucCliente=jrucCliente.getText();
        try{
            cliente=clienteLogica.buscarPorCodigo(rucCliente);
            jrazonCliente.setText(cliente.getRazonsocial());
            llenarcombo(cliente.getNumerodocumento());
            temporal=new Cliente();
            temporal.setId(0);          
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se Encontro Cliente", "Error", JOptionPane.ERROR_MESSAGE);
            temporal.setId(1);
        }   
    }//GEN-LAST:event_buscarActionPerformed

    private void comboValeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboValeActionPerformed
         for (Vale vale : lista) {
              if(vale.getNumero()==(String)comboVale.getSelectedItem())
              {
                  jchofer.setFocusable(false);
                  jplaca.setFocusable(false);
                  jchofer.setText(vale.getChofer());
                  jplaca.setText(vale.getPlaca());
                  transaccion.setNumerotiket(vale.getNumero());
                  valeTemporal=vale;
                  montovale.setText(String.valueOf(vale.getMonto()));
              }else{
                  
              }
        }
    }//GEN-LAST:event_comboValeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox comboVale;
    private javax.swing.JButton imprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jchofer;
    private javax.swing.JTextField jkilometrajes;
    private javax.swing.JTextField jplaca;
    private javax.swing.JTextField jrazonCliente;
    private javax.swing.JTextField jrucCliente;
    private javax.swing.JTextField montovale;
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
        jplaca.setText("");
        jkilometrajes.setText("");
        jchofer.setText("");
    }
    
    private void llenardatos(Despacho desp, Cliente nuevo) {
        Numcomprobante comprobantes= numdao.buscarPorCodigo(4);
        
        transaccion.setDespacho(desp);
        transaccion.setIdtipotransaccion("NDES");
        transaccion.setIdestado(turnoLogica.buscarPorCodigo("N").getId());
        transaccion.setNumerotransaccion(String.valueOf(desp.getId()));
        transaccion.setNumerovale("325-"+agregarCeros(String.valueOf(comprobantes.getNumero()),8));      
        transaccion.setNumero(comprobantes.getNumero());
        transaccion.setNrogalones(desp.getNrogalones());
        transaccion.setPreciounitario(desp.getPreciounitario());
        transaccion.setProducto(desp.getProducto().getNombre());
        transaccion.setMontototal(desp.getMontosoles());
        transaccion.setNumeroplaca(jplaca.getText());
        transaccion.setFecharegistro(desp.getFecharegistro());
        transaccion.setCliente(nuevo);
        transaccion.setTurno(desp.getTurno());
        
        comprobantes.setNumero(comprobantes.getNumero()+1);
        numdao.actualizar(comprobantes);
        
    }
    
    private void llenarcombo(String cliente) 
    {
        
        try {
            lista= (ArrayList<Vale>) valedao.buscarTodos(cliente);
       for (Vale vale : lista) {
            comboVale.addItem(vale.getNumero());
        }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "No se Encontro Vales", "Error", JOptionPane.ERROR_MESSAGE);
        }
       
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
    
 
