/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.sgcespos;

import pe.com.ega.sgces.util.ImprimirComprobante;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
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
import pe.com.ega.sgces.util.Formato;

/**
 *
 * @author FLOPEZ
 */
public class NotaFrame extends JFrame {

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
    private Formato f;

    public NotaFrame(Despacho despacho) {
        initComponents();
        desp = despacho;
        cliente = new Cliente();
        lista = new ArrayList<>();
        clienteLogica = new ClienteLogicaImpl();
        clienteLogica.setClienteDao(new ClienteDaoImpl());
        transaccion = new Transaccion();
        transaccionLogica = new TransaccionLogicaImpl();
        transaccionLogica.setTransaccionDao(new TransaccionDaoImpl());
        despachoLogica = new DespachoLogicaImpl();
        despachoLogica.setDespachoDao(new DespachoDaoImpl());
        valedao = new ValeLogicaImpl();
        valedao.setValeDao(new ValeDaoImpl());
        turnoLogica = new TurnoLogicaImpl();
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
        jLabel6 = new javax.swing.JLabel();
        comboVale = new javax.swing.JComboBox();
        montovale = new javax.swing.JTextField();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel1.setText("R. SOCIAL :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 90, 150, 29);

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
        jrucCliente.setBounds(190, 30, 190, 40);

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel2.setText("R.U.C :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 40, 130, 29);

        jrazonCliente.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jPanel1.add(jrazonCliente);
        jrazonCliente.setBounds(190, 90, 350, 40);

        imprimir.setBackground(new java.awt.Color(133, 238, 75));
        imprimir.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        imprimir.setForeground(new java.awt.Color(51, 51, 51));
        imprimir.setText("ACEPTAR");
        imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirActionPerformed(evt);
            }
        });
        jPanel1.add(imprimir);
        imprimir.setBounds(100, 400, 170, 80);

        cancelar.setBackground(new java.awt.Color(255, 62, 79));
        cancelar.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        cancelar.setForeground(new java.awt.Color(51, 51, 51));
        cancelar.setText("CANCELAR");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar);
        cancelar.setBounds(300, 400, 180, 80);

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel3.setText("PLACA :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 210, 120, 30);

        jLabel4.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel4.setText("CHOFER :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 270, 130, 30);

        jplaca.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jplaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jplacaActionPerformed(evt);
            }
        });
        jPanel1.add(jplaca);
        jplaca.setBounds(190, 210, 170, 40);

        jchofer.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jPanel1.add(jchofer);
        jchofer.setBounds(190, 270, 260, 40);

        jLabel5.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel5.setText("KILOMETRO :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 330, 180, 29);

        jkilometrajes.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jPanel1.add(jkilometrajes);
        jkilometrajes.setBounds(190, 330, 170, 40);

        jLabel6.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel6.setText("NRO VALE :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 150, 190, 29);

        comboVale.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        comboVale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboValeActionPerformed(evt);
            }
        });
        jPanel1.add(comboVale);
        comboVale.setBounds(190, 150, 210, 40);

        montovale.setEditable(false);
        montovale.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        montovale.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        montovale.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        montovale.setFocusable(false);
        jPanel1.add(montovale);
        montovale.setBounds(440, 150, 100, 40);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jrucClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrucClienteActionPerformed
        String rucCliente = jrucCliente.getText();
        try {
            cliente = clienteLogica.buscarPorCodigo(rucCliente);
            jrazonCliente.setText(cliente.getRazonsocial());
            llenarcombo(cliente.getNumerodocumento());
            temporal = new Cliente();
            temporal.setId(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se Encontro Cliente", "Error", JOptionPane.ERROR_MESSAGE);
            temporal.setId(1);
        }
    }//GEN-LAST:event_jrucClienteActionPerformed

    private void jrucClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jrucClienteFocusGained
        jrucCliente.setText("");
        jrazonCliente.setText("");
    }//GEN-LAST:event_jrucClienteFocusGained

    private void imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirActionPerformed
/*
        if (desp.getMontosoles() == Double.parseDouble(montovale.getText())) {
            comprobante = new ImprimirComprobante();
            if (temporal.getId() == 1) {

                Cliente temporal1 = new Cliente();

                temporal1.setNumerodocumento(jrucCliente.getText());
                temporal1.setRazonsocial(jrazonCliente.getText());
                try {
                    llenardatos(desp, cliente);
                    transaccionLogica.grabar(transaccion);
                    despachoLogica.grabar(desp);

                    SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                    Date now = new Date();
                    valeTemporal.setFechadespacho(now);
                    valeTemporal.setHoradespacho(format.format(now));
                    valeTemporal.setEstado(0);
                    valedao.actualizar(valeTemporal);
                   // comprobante.imprimirNotaDespacho(jkilometrajes.getText(), jplaca.getText(), jchofer.getText(), cliente.getRazonsocial(),
                     //       String.valueOf(cliente.getNumerodocumento()), "LOPEZ CORDOVA", String.valueOf(desp.getMontosoles()), String.valueOf(Formato.redondear(desp.getMontosoles() * 0.82)), String.valueOf(Formato.redondear(desp.getMontosoles() * 0.18)), String.valueOf(desp.getPreciounitario()), desp.getProducto().getNombre(), String.valueOf(desp.getNrogalones()), String.valueOf(transaccion.getNumero()), "325", "10419492421", "FF9G151648", "NDES");
                    limpiar();
                    salir(evt);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se puede imprimir", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                llenardatos(desp, cliente);
                transaccionLogica.grabar(transaccion);
                despachoLogica.grabar(desp);
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                Date now = new Date();
                valeTemporal.setFechadespacho(now);
                valeTemporal.setHoradespacho(format.format(now));
                valeTemporal.setEstado(0);
                valedao.actualizar(valeTemporal);
                comprobante.imprimirNotaDespacho(jkilometrajes.getText(), jplaca.getText(), jchofer.getText(), cliente.getRazonsocial(),
                        String.valueOf(cliente.getNumerodocumento()), "LOPEZ CORDOVA", String.valueOf(desp.getMontosoles()), String.valueOf(Formato.redondear(desp.getMontosoles() * 0.82)), String.valueOf(Formato.redondear(desp.getMontosoles() * 0.18)), String.valueOf(desp.getPreciounitario()), desp.getProducto().getNombre(), String.valueOf(desp.getNrogalones()), String.valueOf(transaccion.getNumero()), "325", "10419492421", "FF9G151648", "NDES");
                limpiar();
                salir(evt);
            }
        } else {
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "No coincide los Montos", "Error", JOptionPane.ERROR_MESSAGE);
        }
*/
    }//GEN-LAST:event_imprimirActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        salir(evt);
    }//GEN-LAST:event_cancelarActionPerformed

    private void jplacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jplacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jplacaActionPerformed

    private void comboValeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboValeActionPerformed
        for (Vale vale : lista) {
            if (vale.getNumero() == (String) comboVale.getSelectedItem()) {
                jchofer.setFocusable(false);
                jplaca.setFocusable(false);
                jchofer.setText(vale.getChofer());
                jplaca.setText(vale.getPlaca());
                transaccion.setNumerotiket(vale.getNumero());
                valeTemporal = vale;
                montovale.setText(String.valueOf(vale.getMonto()));
            }
        }
    }//GEN-LAST:event_comboValeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
        jplaca.setText("");
        jkilometrajes.setText("");
        jchofer.setText("");
    }

    private void llenardatos(Despacho desp, Cliente nuevo) {
        Numcomprobante comprobantes = numdao.buscarPorCodigo(4);

        transaccion.setDespacho(desp);
        transaccion.setIdtipotransaccion("NDES");
        transaccion.setIdestado(turnoLogica.buscarPorCodigo("N").getId());
        transaccion.setNumerotransaccion(String.valueOf(desp.getId()));
        transaccion.setNumerovale("325-" + agregarCeros(String.valueOf(comprobantes.getNumero()), 8));
        transaccion.setNumero(comprobantes.getNumero());
        transaccion.setNrogalones(desp.getNrogalones());
        transaccion.setPreciounitario(desp.getPreciounitario());
        transaccion.setProducto(desp.getProducto().getNombre());
        transaccion.setMontototal(desp.getMontosoles());
        transaccion.setNumeroplaca(jplaca.getText());
        transaccion.setFecharegistro(desp.getFecharegistro());
        transaccion.setCliente(nuevo);
        transaccion.setTurno(desp.getTurno());

        comprobantes.setNumero(comprobantes.getNumero() + 1);
        numdao.actualizar(comprobantes);

    }

    private void llenarcombo(String cliente) {

        try {
            lista = (ArrayList<Vale>) valedao.buscarTodos(cliente);
            for (Vale vale : lista) {
                comboVale.addItem(vale.getNumero());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se Encontro Vales", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private static String agregarCeros(String string, int largo) {
        String ceros = "";
        int cantidad = largo - string.length();
        if (cantidad >= 1) {
            for (int i = 0; i < cantidad; i++) {
                ceros += "0";
            }
            return (ceros + string);
        } else {
            return string;
        }
    }
}
