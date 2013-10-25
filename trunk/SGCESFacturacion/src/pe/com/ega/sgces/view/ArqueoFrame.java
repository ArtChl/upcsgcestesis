/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.view;

import Imprimir.ImprimirComprobante;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import org.openswing.swing.mdi.client.InternalFrame;
import pe.com.ega.sgces.dao.TurnoDaoImpl;
import pe.com.ega.sgces.logic.ArqueoLogicaImpl;
import pe.com.ega.sgces.logic.TurnoLogicaImpl;
import pe.com.ega.sgces.model.Arqueo;
import pe.com.ega.sgces.model.Despacho;

/**
 *
 * @author FLOPEZ
 */
public class ArqueoFrame extends InternalFrame {

    private Despacho desp;
    private ImprimirComprobante comprobante;
    private Arqueo arq;
    private ArqueoLogicaImpl arqueoLogica;
    private TurnoLogicaImpl turnoLogica;
    
    public ArqueoFrame() {
        initComponents();
        arq=new Arqueo();
        arqueoLogica =new ArqueoLogicaImpl();
        turnoLogica =new TurnoLogicaImpl();
        turnoLogica.setTurnoDao(new TurnoDaoImpl());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        arqueo = new javax.swing.JButton();

        jPanel1.setLayout(null);

        arqueo.setText("ARQUEO");
        arqueo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arqueoActionPerformed(evt);
            }
        });
        jPanel1.add(arqueo);
        arqueo.setBounds(100, 10, 90, 50);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void arqueoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arqueoActionPerformed
            Double total=0.0;
            ArrayList<Arqueo> lista=arqueoLogica.buscarPorCodigo(String.valueOf(turnoLogica.buscarPorCodigo("N").getId()));
            for (Arqueo arqueo1 : lista) {
                System.out.println("parcial"+arqueo1.getCantidad());
            total=total+arqueo1.getCantidad();
            System.out.println("total"+total);
            }
            ImprimirComprobante comprobante = new ImprimirComprobante();
            comprobante.imprimirArqueo("0001", String.valueOf(redondear(lista.get(1).getCantidad()))
                    , String.valueOf(redondear(lista.get(0).getCantidad())),String.valueOf(redondear(lista.get(2).getCantidad())),
                     String.valueOf(redondear(total))
                    , String.valueOf(redondear(lista.get(3).getCantidad())), "ROSARIO");
            salir(evt);
    }//GEN-LAST:event_arqueoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton arqueo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
   private void salir (java.awt.event.ActionEvent evt){
       actionPerformed(evt);
   }

    private void actionPerformed(ActionEvent evt) {
        setVisible(false);
        dispose();
    }
    
    public static double redondear(double numero) 
       {        
           return Math.rint(numero*100)/100; 
       }

}
