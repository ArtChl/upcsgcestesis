/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.view;

import Imprimir.ImprimirComprobante;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pe.com.ega.sgces.dao.ClienteDaoImpl;
import pe.com.ega.sgces.dao.DespachoDaoImpl;
import pe.com.ega.sgces.dao.TransaccionDaoImpl;
import pe.com.ega.sgces.dao.ValeDaoImpl;
import pe.com.ega.sgces.logic.ClienteLogicaImpl;
import pe.com.ega.sgces.logic.DespachoLogicaImpl;
import pe.com.ega.sgces.logic.TransaccionLogicaImpl;
import pe.com.ega.sgces.logic.ValeLogicaImpl;
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.model.Despacho;
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
    private ValeLogicaImpl valedao;
    ArrayList<Vale> lista;
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
        });
        jPanel1.add(jrucCliente);
        jrucCliente.setBounds(100, 30, 170, 20);

        jLabel2.setText("R.U.C");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 30, 34, 14);
        jPanel1.add(jrazonCliente);
        jrazonCliente.setBounds(100, 60, 260, 20);

        imprimir.setText("Confirmar");
        imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirActionPerformed(evt);
            }
        });
        jPanel1.add(imprimir);
        imprimir.setBounds(90, 210, 80, 23);

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar);
        cancelar.setBounds(180, 210, 75, 23);

        jLabel3.setText("Placa :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 120, 32, 14);

        jLabel4.setText("Chofer :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 150, 50, 14);

        jplaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jplacaActionPerformed(evt);
            }
        });
        jPanel1.add(jplaca);
        jplaca.setBounds(100, 120, 90, 20);
        jPanel1.add(jchofer);
        jchofer.setBounds(100, 150, 260, 20);

        jLabel5.setText("Kilometraje :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 180, 70, 14);
        jPanel1.add(jkilometrajes);
        jkilometrajes.setBounds(100, 180, 80, 20);

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        jPanel1.add(buscar);
        buscar.setBounds(290, 30, 65, 23);

        jLabel6.setText("Nro. Vale :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 90, 70, 14);

        comboVale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboValeActionPerformed(evt);
            }
        });
        jPanel1.add(comboVale);
        comboVale.setBounds(100, 90, 130, 20);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jrucClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrucClienteActionPerformed
        
    }//GEN-LAST:event_jrucClienteActionPerformed

    private void jrucClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jrucClienteFocusGained
        jrucCliente.setText("");
        jrazonCliente.setText("");
    }//GEN-LAST:event_jrucClienteFocusGained

    private void imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirActionPerformed
      // String numVale=transaccionLogica.
       comprobante = new ImprimirComprobante();
       if(temporal.getId()==1){        
           System.out.println("Cliente"+temporal.getId());
           Cliente temporal1 = new Cliente();
           //temporal1.setId(Integer.parseInt(jrucCliente.getText()));
           temporal1.setNumeroDocumento(jrucCliente.getText());
           temporal1.setRazonSocial(jrazonCliente.getText());
           try {
               clienteLogica.grabar(temporal1);
               llenardatos(desp,temporal1);
               transaccionLogica.grabar(transaccion);
               despachoLogica.grabar(desp);
               System.out.println("Vale"+valeTemporal.getId());
               //valedao.actualizar(valeTemporal);
               comprobante.imprimirFactura(temporal1.getRazonSocial(),
               String.valueOf(temporal1.getNumeroDocumento()) ,"LOPEZ CORDOVA", String.valueOf(desp.getMontoSoles()), String.valueOf(desp.getMontoSoles()*0.82),String.valueOf(desp.getMontoSoles()*0.18),String.valueOf(desp.getPrecioUnitario()), desp.getProducto().getNombre()
                 , String.valueOf(desp.getNroGalones()), String.valueOf(numero("NDES")+1), "325", "10419492421", "FF9G151648", "NDES");
               limpiar();
               salir(evt);
           } catch (Exception e) {
               System.out.println("e");
           }          
       }else{
           llenardatos(desp,cliente);
           transaccionLogica.grabar(transaccion);
           despachoLogica.grabar(desp); 
           System.out.println("Vale"+valeTemporal.getId());
          // valedao.actualizar(valeTemporal);
           comprobante.imprimirNotaDespacho(jkilometrajes.getText(),jplaca.getText(),jchofer.getText(),cliente.getRazonSocial(),
                String.valueOf(cliente.getNumeroDocumento()) ,"LOPEZ CORDOVA", String.valueOf(desp.getMontoSoles()), String.valueOf(Redondear(desp.getMontoSoles()*0.82)),String.valueOf(Redondear(desp.getMontoSoles()*0.18)),String.valueOf(desp.getPrecioUnitario()), desp.getProducto().getNombre()
                 , String.valueOf(desp.getNroGalones()), String.valueOf(numero("NDES")+1), "325", "10419492421", "FF9G151648", "NDES");
           limpiar();
           salir(evt);
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
            jrazonCliente.setText(cliente.getRazonSocial());
            llenarcombo(cliente.getNumeroDocumento());
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
                  transaccion.setNumeroTiket(vale.getNumero());
                  valeTemporal=vale;
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
        transaccion.setDespacho(desp);
        transaccion.setIdTipoTransaccion("NDES");
        transaccion.setIdEstado(1);
        transaccion.setNumeroTransaccion(String.valueOf(desp.getId()));
        transaccion.setNumeroVale("325-0000000"+String.valueOf(numero("NDES")+1));
        transaccion.setNumero(numero("NDES")+1);
        transaccion.setNroGalones(desp.getNroGalones());
        transaccion.setPrecioUnitario(desp.getPrecioUnitario());
        transaccion.setProducto(desp.getProducto().getNombre());
        transaccion.setMontoTotal(desp.getMontoSoles());
        transaccion.setNumeroPlaca(jplaca.getText());
        transaccion.setFechaRegistro(desp.getFechaRegistro());
        transaccion.setCliente(nuevo);
        
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
  
    private int numero(String documento) 
    {
        int num=0;
        try {
            ArrayList<Transaccion> comprobantes= (ArrayList<Transaccion>) transaccionLogica.buscarTodoDoc(documento);
            int i=comprobantes.size();
            num=comprobantes.get(i-1).getNumero();  
        } catch (Exception e) {
            System.out.println(e);
        }
        return num;
    }
    }
    
 
