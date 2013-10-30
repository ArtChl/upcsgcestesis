
package pe.com.ega.sgces.view;
import Imprimir.ImprimirComprobante;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.openswing.swing.mdi.client.InternalFrame;
import pe.com.ega.sgces.logic.DespachoLogica;
import pe.com.ega.sgces.logic.MovimientoLogica;
import pe.com.ega.sgces.logic.TransaccionLogica;
import pe.com.ega.sgces.logic.TurnoLogica;
import pe.com.ega.sgces.model.Transaccion;

/**
 *
 * @author FLOPEZ
 */
public class ComprobanteFrame extends InternalFrame {

    private TransaccionLogica transaccionLogica;
    private ArrayList<Transaccion> transaccions;
    private TurnoLogica turnoLogica;
    private ImprimirComprobante comprobante;

    public ComprobanteFrame(TurnoLogica turnoLogica, MovimientoLogica movimientoLogica, DespachoLogica despachoLogica, TransaccionLogica transaccionLogica) {
        initComponents();
        this.turnoLogica =turnoLogica;
        this.transaccionLogica = transaccionLogica;
        transaccions=new ArrayList<>(); 
        
        pintarTabla();            
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setLayout(null);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(200, 290));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(492, 190));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        tabla.setMaximumSize(new java.awt.Dimension(200, 290));
        tabla.setMinimumSize(new java.awt.Dimension(200, 290));
        tabla.setPreferredSize(new java.awt.Dimension(452, 190));
        tabla.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 492, 120);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Comprobante Emitidos");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 160, 16);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
   private void salir (MouseEvent evt){
       actionPerformed(evt);
   }

   private void actionPerformed(MouseEvent evt) {
        setVisible(false);
        dispose();
   }
   
  private void pintarTabla(){
  System.out.println("se llamo a pintar tabla");
  String[] titulo=new String[]{"Cod","Numero","Tipo","Producto","Monto","Fecha"};

  try {
      int turno2=turnoLogica.buscarPorCodigo("N").getId();
      transaccions=(ArrayList<Transaccion>) transaccionLogica.buscarTurno(turno2);
  } catch (Exception ex) {
//TODO Agregar log de errores.
  }

  Object[][] arre=new Object[transaccions.size()][6];
  int i=0;
  for(Transaccion t:transaccions){
      arre[i][0]=t.getId();
      arre[i][1]=t.getNumerovale();
      arre[i][2]=t.getIdtipotransaccion();
      arre[i][3]=t.getProducto();
      arre[i][4]=t.getMontototal();
      arre[i][5]=t.getFecharegistro();
      i++;
  }


  tabla.addMouseListener(new SelectListener());
  DefaultTableModel modelo=new DefaultTableModel(arre, titulo);
  tabla.setModel(modelo);
  int anchos[] = {1, 50, 20, 50, 50, 50, 50};
  tabla.getColumnModel().getColumn(0).setMaxWidth(0);
  tabla.getColumnModel().getColumn(0).setMinWidth(0);
  tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
  for (int x = 1; x < tabla.getColumnCount(); x++) {
    tabla.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
    tabla.getColumnModel().getColumn(x).setResizable(false);
  }
  jScrollPane1.setViewportView(tabla); 
}

  class SelectListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
           // select(e);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            select(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

       

         private void select(MouseEvent e){
            int row=tabla.getSelectedRow();
            String txt[] = new String[tabla.getColumnCount()];
            //String txt[] = "";
            for (int i = 0; i < tabla.getColumnCount(); i++) {
                txt[i]=String.valueOf(tabla.getValueAt(row, 0));
                
            }
             if (JOptionPane.showConfirmDialog(new JFrame(),"Desea Eliminar Comprobante?", "Confirmacion",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                 Transaccion tr= buscar(txt[0]);
                 tr.setAnulado(true);
                 transaccionLogica.actualizar(tr);  
                 pintarTabla();
                 salir(e);       
             }
        }
       
  }
  
  private Transaccion buscar(String codigo){
      int cod= Integer.parseInt(codigo);
      Transaccion desp=null;
      for(Transaccion t:transaccions){
            if(cod==t.getId()){
                desp=t;
                break;
            }
  } 
      desp.setAnulado(true);
      return desp;
  }
}
