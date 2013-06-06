/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UsuarioFrame.java
 *
 * Created on 21/01/2010, 01:35:29 AM
 */

package pe.com.ega.sgces.view;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import pe.com.ega.sgces.dao.DespachoDao;
import pe.com.ega.sgces.dao.DespachoDaoImpl;
import pe.com.ega.sgces.dao.Usuariodao;
import pe.com.ega.sgces.dao.UsuariodaoImpl;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.model.Transaccion;
import pe.com.ega.sgces.model.Usuario;


/**
 *
 * @author Administrador
 */
public class DespachoFrame extends javax.swing.JFrame {

    private DespachoDao despachoDao;
    
    public DespachoFrame() {
        initComponents();
        pintarTabla();
        setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(tabla);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Despachos Pendientes x Facturar");

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
salir(evt);      // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
    private void pintarTabla(){
  System.out.println("se llamo a pintar tabla");
  String[] titulo=new String[]{"Codigo","Transaccion","Surtidor","Producto","Precio","Galones","Monto"};

  //LENAR DE DATOS EL MODELO
  //la lista
        despachoDao = new DespachoDaoImpl();
        ArrayList<Despacho> transaccions=new ArrayList<Despacho>();
       // TecnicoBean t=new TecnicoBean();
        try {

            transaccions=(ArrayList<Despacho>) despachoDao.buscarTodos();

        } catch (Exception ex) {

        }

  //recuperar la lista
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


  tabla.addMouseListener(new MouseAdapter()
   {
            @Override
      public void mouseClicked(MouseEvent e)
      {
         int fila = tabla.rowAtPoint(e.getPoint());
         int columna = tabla.columnAtPoint(e.getPoint());
         if ((fila > -1) && (columna > -1))
            System.out.println(tabla.getValueAt(fila,0));
            String valor=(String) tabla.getValueAt(fila,0);
            String x=String.valueOf(valor);
         //   FrameClienteM.jcodigo.setText(x);
            setVisible(false);
      }
   });
  DefaultTableModel modelo=new DefaultTableModel(arre, titulo);
  //ASIGNAR EL MODELO A LA TABLA
  tabla.setModel(modelo);
  //ASIGNAR LA TABLA SCROOLPANEL
  jScrollPane1.setViewportView(tabla);
  /*

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Producto", "Cantidad", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tabla);

   * */
}
  /*  public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioFrame().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
 private void salir (java.awt.event.ActionEvent evt){
       actionPerformed(evt);
   }

    private void actionPerformed(ActionEvent evt) {
        setVisible(false);
        dispose();
    }
 
}
