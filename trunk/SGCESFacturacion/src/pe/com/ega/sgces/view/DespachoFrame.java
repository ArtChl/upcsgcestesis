
package pe.com.ega.sgces.view;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.openswing.swing.mdi.client.InternalFrame;
import org.openswing.swing.mdi.client.MDIFrame;
import pe.com.ega.sgces.dao.DespachoDaoImpl;
import pe.com.ega.sgces.logic.DespachoLogicaImpl;
import pe.com.ega.sgces.model.Despacho;

/**
 *
 * @author FLOPEZ
 */
public class DespachoFrame extends InternalFrame {

    private DespachoLogicaImpl despachoLogic;
    private ArrayList<Despacho> transaccions;

    public DespachoFrame() {
        initComponents();
        despachoLogic = new DespachoLogicaImpl();      
        despachoLogic.setDespachoDao(new DespachoDaoImpl());
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
        jLabel1.setText("Despachos Pendientes x Facturar");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 216, 16);

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
  String[] titulo=new String[]{"Codigo","Fecha","Cara","Producto","Precio","Galones","Monto"};

  try {
  transaccions=(ArrayList<Despacho>) despachoLogic.buscarTodos();
  } catch (Exception ex) {
//TODO Agregar log de errores.
  }

  Object[][] arre=new Object[transaccions.size()][7];
  int i=0;
  for(Despacho t:transaccions){
      arre[i][0]=t.getId();
      arre[i][1]=t.getFechaRegistro();
      arre[i][2]=t.getCaraproducto().getCara().getCodigo();
      arre[i][3]=t.getProducto().getNombre();
      arre[i][4]=t.getPrecioUnitario();
      arre[i][5]=t.getNroGalones();
      arre[i][6]=t.getMontoSoles();
      i++;
  }


  tabla.addMouseListener(new SelectListener());
  DefaultTableModel modelo=new DefaultTableModel(arre, titulo);
  tabla.setModel(modelo);
  int anchos[] = {30, 50, 15, 100, 50, 50, 50};
  for (int x = 0; x < tabla.getColumnCount(); x++) {
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
            OpcionFrame f=new OpcionFrame(buscar(txt[0]));
            f.setSize(298,103);
            f.setTitle("Comprobante");
            MDIFrame.add(f);
            salir(e);
        }
       
  }
  
  private Despacho buscar(String codigo){
      int cod= Integer.parseInt(codigo);
      Despacho desp=null;
      for(Despacho t:transaccions){
            if(cod==t.getId()){
                desp=t;
                break;
            }
  }
        return desp;
  }
}
