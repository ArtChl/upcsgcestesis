/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.sgcespos;

import java.awt.Color;
import java.awt.Component;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.com.ega.sgces.logic.ArqueoLogica;
import pe.com.ega.sgces.logic.ArqueoLogicaImpl;
import pe.com.ega.sgces.logic.CierreLogica;
import pe.com.ega.sgces.logic.CierreLogicaImpl;
import pe.com.ega.sgces.logic.ClienteLogica;
import pe.com.ega.sgces.logic.ClienteLogicaImpl;
import pe.com.ega.sgces.logic.DepositoLogica;
import pe.com.ega.sgces.logic.DepositoLogicaImpl;
import pe.com.ega.sgces.logic.DespachoLogica;
import pe.com.ega.sgces.logic.DespachoLogicaImpl;
import pe.com.ega.sgces.logic.MovimientoLogica;
import pe.com.ega.sgces.logic.MovimientoLogicaImpl;
import pe.com.ega.sgces.logic.NumComprobanteLogica;
import pe.com.ega.sgces.logic.NumComprobanteLogicaImpl;
import pe.com.ega.sgces.logic.TransaccionLogica;
import pe.com.ega.sgces.logic.TransaccionLogicaImpl;
import pe.com.ega.sgces.logic.TurnoLogica;
import pe.com.ega.sgces.logic.TurnoLogicaImpl;
import pe.com.ega.sgces.logic.ValeLogica;
import pe.com.ega.sgces.logic.ValeLogicaImpl;
import pe.com.ega.sgces.model.Arqueo;
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.util.Formato;
import pe.com.ega.sgces.util.ImprimirComprobante;

/**
 *
 * @author sistemas
 */
public class PrincipalFrame extends javax.swing.JFrame {

    private final static Logger logger = Logger.getLogger(PrincipalFrame.class);
    
    private MovimientoLogica movimientoLogica;
    private DepositoLogica depositoLogica;
    private DespachoLogica despachoLogica;
    private TurnoLogica turnoLogica;
    private TransaccionLogica transaccionLogica;
    private CierreLogica cierreLogica;
    private ArqueoLogica arqueoLogica;
    private NumComprobanteLogica numcomprobanteLogica;
    private ClienteLogica clienteLogica;
    private ValeLogica valeLogica;
    private String numero;
    private ArrayList<Despacho> transaccions;

    public PrincipalFrame() {
        initComponents();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().
                addKeyEventDispatcher(new KeyEventDispatcher() {
                    
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == java.awt.event.KeyEvent.KEY_RELEASED &&
                    e.getKeyCode() == java.awt.event.KeyEvent.VK_F5) {
                    pintarTabla();
                }
                return false;
            }
            
        });

        this.setSize(554, 424);
        transaccions = new ArrayList<>();

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        this.movimientoLogica = context.getBean("movimientoService",
                MovimientoLogicaImpl.class);
        this.depositoLogica = context.getBean("depositoService",
                DepositoLogicaImpl.class);
        this.despachoLogica = context.getBean("despachoService",
                DespachoLogicaImpl.class);
        this.turnoLogica = context.getBean("turnoService",
                TurnoLogicaImpl.class);
        this.transaccionLogica = context.getBean("transaccionService",
                TransaccionLogicaImpl.class);
        this.cierreLogica = context.getBean("cierreService",
                CierreLogicaImpl.class);
        this.numcomprobanteLogica= context.getBean("numComprobanteService",
                NumComprobanteLogicaImpl.class);
        this.arqueoLogica = context.getBean("arqueoService",
                ArqueoLogicaImpl.class);
        this.clienteLogica = context.getBean("clienteService",
                ClienteLogicaImpl.class);
        this.valeLogica = context.getBean("valeService",
                ValeLogicaImpl.class);
        
        pintarTabla();
        
        this.getRootPane().setDefaultButton(boleta);
        boleta.requestFocus();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panel1 = new java.awt.Panel();
        boleta = new javax.swing.JButton();
        factura = new javax.swing.JButton();
        nota = new javax.swing.JButton();
        panel3 = new java.awt.Panel();
        boleta1 = new javax.swing.JButton();
        factura1 = new javax.swing.JButton();
        nota1 = new javax.swing.JButton();
        panel2 = new java.awt.Panel();
        arqueo = new javax.swing.JButton();
        tirada = new javax.swing.JButton();
        cierre = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        panel4 = new java.awt.Panel();
        anular = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PUNTO DE VENTA PLAYA");
        setBackground(new java.awt.Color(255, 0, 0));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setEnabled(false);
        jPanel2.setLayout(null);

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setLayout(null);

        boleta.setBackground(new java.awt.Color(133, 238, 75));
        boleta.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        boleta.setForeground(new java.awt.Color(51, 51, 51));
        boleta.setMnemonic(KeyEvent.VK_B);
        boleta.setText("BOLETA");
        boleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boletaActionPerformed(evt);
            }
        });
        panel1.add(boleta);
        boleta.setBounds(0, 10, 170, 100);

        factura.setBackground(new java.awt.Color(133, 238, 75));
        factura.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        factura.setForeground(new java.awt.Color(51, 51, 51));
        factura.setMnemonic(KeyEvent.VK_F);
        factura.setText("FACTURA");
        factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaActionPerformed(evt);
            }
        });
        panel1.add(factura);
        factura.setBounds(180, 10, 160, 100);

        nota.setBackground(new java.awt.Color(133, 238, 75));
        nota.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        nota.setForeground(new java.awt.Color(51, 51, 51));
        nota.setMnemonic(KeyEvent.VK_D);
        nota.setText("DESPACHO");
        nota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notaActionPerformed(evt);
            }
        });
        panel1.add(nota);
        nota.setBounds(350, 10, 170, 100);

        panel3.setBackground(new java.awt.Color(0, 204, 0));
        panel3.setLayout(null);

        boleta1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        boleta1.setForeground(new java.awt.Color(51, 51, 51));
        boleta1.setMnemonic(KeyEvent.VK_E);
        boleta1.setText("BOLETA");
        boleta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boleta1ActionPerformed(evt);
            }
        });
        panel3.add(boleta1);
        boleta1.setBounds(10, 10, 150, 100);

        factura1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        factura1.setForeground(new java.awt.Color(51, 51, 51));
        factura1.setMnemonic(KeyEvent.VK_E);
        factura1.setText("FACTURA");
        factura1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                factura1ActionPerformed(evt);
            }
        });
        panel3.add(factura1);
        factura1.setBounds(170, 10, 150, 100);

        nota1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        nota1.setForeground(new java.awt.Color(51, 51, 51));
        nota1.setMnemonic(KeyEvent.VK_E);
        nota1.setText("FACTURA");
        nota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nota1ActionPerformed(evt);
            }
        });
        panel3.add(nota1);
        nota1.setBounds(330, 10, 150, 100);

        panel1.add(panel3);
        panel3.setBounds(10, 280, 490, 120);

        jPanel2.add(panel1);
        panel1.setBounds(10, 280, 530, 120);

        panel2.setBackground(new java.awt.Color(255, 255, 255));
        panel2.setLayout(null);

        arqueo.setBackground(new java.awt.Color(255, 235, 90));
        arqueo.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        arqueo.setForeground(new java.awt.Color(51, 51, 51));
        arqueo.setMnemonic(KeyEvent.VK_R);
        arqueo.setText("<html><center><p>ARQUEO DE</p><p>CAJA</p></center></html>");
        arqueo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arqueoActionPerformed(evt);
            }
        });
        panel2.add(arqueo);
        arqueo.setBounds(0, 0, 140, 63);

        tirada.setBackground(new java.awt.Color(255, 235, 90));
        tirada.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        tirada.setForeground(new java.awt.Color(51, 51, 51));
        tirada.setMnemonic(KeyEvent.VK_T);
        tirada.setText("<html><center><p>TIRADA A</p><p>BUZON</p></center></html>");
        tirada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiradaActionPerformed(evt);
            }
        });
        panel2.add(tirada);
        tirada.setBounds(0, 80, 140, 66);

        cierre.setBackground(new java.awt.Color(255, 235, 90));
        cierre.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        cierre.setForeground(new java.awt.Color(51, 51, 51));
        cierre.setMnemonic(KeyEvent.VK_C);
        cierre.setText("<html><center><p>CIERRE DE</p><p>TURNO</p></center></html>");
        cierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cierreActionPerformed(evt);
            }
        });
        panel2.add(cierre);
        cierre.setBounds(0, 160, 140, 70);

        jPanel2.add(panel2);
        panel2.setBounds(730, 30, 140, 370);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(200, 290));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(492, 190));

        tabla.setAutoCreateRowSorter(true);
        tabla.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabla.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        tabla.setForeground(new java.awt.Color(51, 51, 51));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Transaccion", "Surtidor", "Producto", "Precio", "Galones", "Monto"
            }
        ));
        tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabla.setFocusTraversalPolicyProvider(true);
        tabla.setMaximumSize(new java.awt.Dimension(200, 290));
        tabla.setMinimumSize(new java.awt.Dimension(200, 290));
        tabla.setPreferredSize(new java.awt.Dimension(452, 190));
        tabla.setRowHeight(36);
        tabla.setSelectionBackground(new java.awt.Color(255, 255, 0));
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla.setSurrendersFocusOnKeystroke(true);
        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);
        tabla.getAccessibleContext().setAccessibleParent(tabla);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 700, 230);

        panel4.setBackground(new java.awt.Color(255, 255, 255));
        panel4.setLayout(null);

        anular.setBackground(new java.awt.Color(255, 62, 79));
        anular.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        anular.setForeground(new java.awt.Color(51, 51, 51));
        anular.setMnemonic(KeyEvent.VK_A);
        anular.setText("ANULAR");
        anular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anularActionPerformed(evt);
            }
        });
        panel4.add(anular);
        anular.setBounds(0, 10, 170, 100);

        jPanel2.add(panel4);
        panel4.setBounds(540, 280, 200, 120);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 880, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void arqueoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arqueoActionPerformed
        Double total = 0.0;
        ArrayList<Arqueo> lista = arqueoLogica.buscarPorCodigo(String.valueOf(turnoLogica.buscarPorCodigo("N").getId()));
        for (Arqueo arqueo1 : lista) {
            total = total + arqueo1.getCantidad();
        }
        ImprimirComprobante comprobante = new ImprimirComprobante();
        comprobante.imprimirArqueo("0001", 
                Formato.redondearCadena(lista.get(1).getCantidad()), 
                Formato.redondearCadena(lista.get(0).getCantidad()), 
                Formato.redondearCadena(lista.get(2).getCantidad()),
                Formato.redondearCadena(total), 
                Formato.redondearCadena(lista.get(3).getCantidad()), "ROSARIO");
    }//GEN-LAST:event_arqueoActionPerformed

    private void tiradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiradaActionPerformed
        TiradaFrame f = new TiradaFrame(depositoLogica);
        f.setSize(509, 325);
        f.setTitle("Tirada");
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }//GEN-LAST:event_tiradaActionPerformed

    private void cierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cierreActionPerformed
        
        try {
            cierreLogica.cierreTurno(turnoLogica.buscarPorCodigo("N"));
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Cierre Realizado con Existo", "Informacion", JOptionPane.OK_OPTION);
        } catch (RuntimeException exCierre) {
            logger.error("Mensaje:\n" + exCierre.getMessage());
            new OkCancelDialog(this, true, exCierre.getMessage()).setVisible(true);
        }
        catch(Exception ex){
            logger.error("Mensaje:\n" + ex.getMessage());
            new OkDialog(this, true, "Ocurrio un error intentelo de nuevo").setVisible(true);
        }
    }//GEN-LAST:event_cierreActionPerformed

    private void anularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anularActionPerformed
        ComprobanteFrame f = new ComprobanteFrame(turnoLogica, transaccionLogica);
        f.setSize(857, 489);
        f.setTitle("ANULAR COMPROBANTE");
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }//GEN-LAST:event_anularActionPerformed

    private void nota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nota1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nota1ActionPerformed

    private void factura1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_factura1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_factura1ActionPerformed

    private void boleta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boleta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boleta1ActionPerformed

    private void notaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notaActionPerformed
        try {
            NotaFrame f = new NotaFrame(buscar(numero),transaccionLogica,despachoLogica,turnoLogica,numcomprobanteLogica,valeLogica,clienteLogica);
            f.setSize(573, 553);
            f.setTitle("NOTA DE DESPACHO");
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        } catch (Exception ex) {
            logger.error("Mensaje:\n" + ex.getMessage());
            new OkDialog(this, true, "No ha Seleccionado Despacho !!!").setVisible(true);
        }

    }//GEN-LAST:event_notaActionPerformed

    private void facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaActionPerformed
        try {
            FacturaFrame f = new FacturaFrame(buscar(numero), despachoLogica, movimientoLogica, turnoLogica, transaccionLogica, numcomprobanteLogica, clienteLogica);
            f.setSize(627, 301);
            f.setTitle("EMISION DE FACTURA");
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        } catch (Exception ex) {
            logger.error("Mensaje:\n" + ex.getMessage());
            new OkDialog(this, true, "No ha Seleccionado Despacho !!!").setVisible(true);
        }

    }//GEN-LAST:event_facturaActionPerformed

    private void boletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boletaActionPerformed
        try {
            Cliente cliente = new Cliente();
            cliente.setId(2);
            MonedaFrame f = new MonedaFrame(buscar(numero), "BOL", cliente, despachoLogica, movimientoLogica, turnoLogica, transaccionLogica, numcomprobanteLogica);
            f.setSize(528, 395);
            f.setTitle("TIPO DE PAGO");
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        } catch (Exception ex) {
            logger.error("Mensaje:\n" + ex.getMessage());
            new OkDialog(this, true, "No ha Seleccionado Despacho !!!").setVisible(true);
        }

    }//GEN-LAST:event_boletaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrincipalFrame().setVisible(true);

                try {
                    UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    logger.error("Mensaje:\n" + ex.getMessage());
                }
            }
        });
    }

    private void pintarTabla() {
        String[] titulo = new String[]{"Codigo", "Fecha", "Producto", "Precio", "Galones", "Monto"};

        try {
            transaccions = (ArrayList<Despacho>) despachoLogica.buscarTodos();            
        } catch (Exception ex) {
              logger.error("Mensaje:\n" + ex.getMessage());
              JOptionPane.showMessageDialog(null, "No se encontro la ransación.", "Error", JOptionPane.ERROR_MESSAGE);
              return;
        }

        Object[][] arre = new Object[transaccions.size()][7];
        int i = 0;
        for (Despacho t : transaccions) {
            arre[i][0] = t.getId();
            arre[i][1] = t.getFecharegistro();
            arre[i][2] = t.getProducto().getNombre();
            arre[i][3] = t.getPreciounitario();
            arre[i][4] = t.getNrogalones();
            arre[i][5] = t.getMontosoles();
            i++;
        }

        tabla.addMouseListener(new SelectListener());
        DefaultTableModel modelo = new DefaultTableModel(arre, titulo);
        tabla.setModel(modelo);
        int anchos[] = {50, 100, 200, 50, 50, 50};
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(1).setMaxWidth(0);
        tabla.getColumnModel().getColumn(1).setMinWidth(0);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(0).setHeaderRenderer(new MyRenderer(Color.orange, Color.orange));
        for (int x = 2; x < tabla.getColumnCount(); x++) {
            tabla.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
            tabla.getColumnModel().getColumn(x).setResizable(false);
            if (x > 2) {
                tabla.getColumnModel().getColumn(x).setCellRenderer(render);
            }
        }
        jScrollPane1.setViewportView(tabla);
    }

    class SelectListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            select(e);
        }

        private void select(MouseEvent e) {
            int row = tabla.getSelectedRow();
            String txt[] = new String[tabla.getColumnCount()];
            for (int i = 0; i < tabla.getColumnCount(); i++) {
                txt[i] = String.valueOf(tabla.getValueAt(row, 0));
            }
            numero = txt[0];
        }
    }

    private Despacho buscar(String codigo) {
        int cod = Integer.parseInt(codigo);
        Despacho desp = null;
        for (Despacho t : transaccions) {
            if (cod == t.getId()) {
                desp = t;
                break;
            }
        }
        return desp;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anular;
    private javax.swing.JButton arqueo;
    private javax.swing.JButton boleta;
    private javax.swing.JButton boleta1;
    private javax.swing.JButton cierre;
    private javax.swing.JButton factura;
    private javax.swing.JButton factura1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nota;
    private javax.swing.JButton nota1;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private java.awt.Panel panel4;
    private javax.swing.JTable tabla;
    private javax.swing.JButton tirada;
    // End of variables declaration//GEN-END:variables
    TableCellRenderer render = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            l.setHorizontalAlignment(SwingConstants.RIGHT);
            if (hasFocus) {
                l.setForeground(Color.RED);
            } else {
                l.setForeground(Color.BLACK);
            }
            return l;
        }
    };
}
