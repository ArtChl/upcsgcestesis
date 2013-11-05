package pe.com.ega.sgces.sgcespos;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.apache.log4j.Logger;
import pe.com.ega.sgces.logic.TransaccionLogica;
import pe.com.ega.sgces.logic.TurnoLogica;
import pe.com.ega.sgces.model.Transaccion;

/**
 *
 * @author FLOPEZ
 */
public class ComprobanteFrame extends JFrame {

    private final static Logger logger = Logger.getLogger(ComprobanteFrame.class);
    private TransaccionLogica transaccionLogica;
    private ArrayList<Transaccion> transaccions;
    private TurnoLogica turnoLogica;
    private String numero;

    public ComprobanteFrame(TurnoLogica turnoLogica, TransaccionLogica transaccionLogica) {
        initComponents();
        this.turnoLogica = turnoLogica;
        this.transaccionLogica = transaccionLogica;
        transaccions = new ArrayList<>();
        pintarTabla();
        numero="0";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cancelar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel1.setText("Comprobante Emitidos");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 10, 300, 30);

        jScrollPane2.setMinimumSize(new java.awt.Dimension(200, 290));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(492, 190));

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
        tabla.setAutoscrolls(false);
        tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabla.setFocusTraversalPolicyProvider(true);
        tabla.setFocusable(false);
        tabla.setMaximumSize(new java.awt.Dimension(200, 290));
        tabla.setMinimumSize(new java.awt.Dimension(200, 290));
        tabla.setPreferredSize(new java.awt.Dimension(452, 190));
        tabla.setRowHeight(36);
        tabla.setSelectionBackground(new java.awt.Color(255, 255, 0));
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabla);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 60, 810, 230);

        cancelar.setBackground(new java.awt.Color(255, 62, 79));
        cancelar.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        cancelar.setForeground(new java.awt.Color(51, 51, 51));
        cancelar.setMnemonic(KeyEvent.VK_C);
        cancelar.setText("CANCELAR");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar);
        cancelar.setBounds(660, 320, 170, 100);

        aceptar.setBackground(new java.awt.Color(133, 238, 75));
        aceptar.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        aceptar.setForeground(new java.awt.Color(51, 51, 51));
        aceptar.setMnemonic(KeyEvent.VK_A);
        aceptar.setText("ACEPTAR");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        jPanel1.add(aceptar);
        aceptar.setBounds(470, 320, 170, 100);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
                salir(evt);
    }//GEN-LAST:event_cancelarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        if("0".equals(numero))
            {
                        new OkDialog(this,true,"No ha Seleccionado Comprobante !!!").setVisible(true);
            }
        else {

            if (JOptionPane.showConfirmDialog(new JFrame(), "Desea Eliminar Comprobante?", "Confirmacion", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Transaccion tr = buscar(numero);
                tr.setAnulado(true);
                transaccionLogica.actualizar(tr);
                this.salir(evt);
        }
        }
        
    }//GEN-LAST:event_aceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

    private void salir(ActionEvent evt) {
        actionPerformed(evt);
    }

    private void actionPerformed(ActionEvent evt) {
        setVisible(false);
        dispose();
    }

    private void pintarTabla() {
        String[] titulo = new String[]{"Cod", "Numero", "Tipo", "Producto", "Monto"};

        try {
            int turno2 = turnoLogica.buscarPorCodigo("N").getId();
            transaccions = (ArrayList<Transaccion>) transaccionLogica.buscarTurno(turno2);
        } catch (Exception ex) {
            logger.error("Mensaje:\n" + ex.getMessage());
        }

        Object[][] arre = new Object[transaccions.size()][6];
        int i = 0;
        for (Transaccion t : transaccions) {
            arre[i][0] = t.getId();
            arre[i][1] = t.getNumerovale();
            arre[i][2] = t.getIdtipotransaccion();
            arre[i][3] = t.getProducto();
            arre[i][4] = t.getMontototal();
           // arre[i][5] = t.getFecharegistro();
            i++;
        }


        tabla.addMouseListener(new SelectListener());
        DefaultTableModel modelo = new DefaultTableModel(arre, titulo);
        tabla.setModel(modelo);
        int anchos[] = {1, 100, 20, 50, 50, 50, 50};
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
        for (int x = 1; x < tabla.getColumnCount(); x++) {
            tabla.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
            tabla.getColumnModel().getColumn(x).setResizable(false);
            if(x==4) {
          tabla.getColumnModel().getColumn(x).setCellRenderer(render);
      }
        }
        //jScrollPane1.setViewportView(tabla);
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
             numero=txt[0];
            System.out.println("Numero"+numero); 
            
        }
    }

    private Transaccion buscar(String codigo) {
        int cod = Integer.parseInt(codigo);
        Transaccion desp = null;
        for (Transaccion t : transaccions) {
            if (cod == t.getId()) {
                desp = t;
                break;
            }
        }
        desp.setAnulado(true);
        return desp;
    }
    
    
    
    TableCellRenderer render = new DefaultTableCellRenderer() { 
@Override 
public Component getTableCellRendererComponent(JTable table, Object value, 
boolean isSelected, boolean hasFocus, int row, int column) {  
JLabel l = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
l.setHorizontalAlignment(SwingConstants.RIGHT); 
if(hasFocus) {
        l.setForeground(Color.RED);
    } 
else {
        l.setForeground(Color.BLACK);
    } 
return l; 
} 
}; 
}
