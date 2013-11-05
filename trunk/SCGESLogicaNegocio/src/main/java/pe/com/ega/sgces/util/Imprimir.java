/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.util;

/**
 *
 * @author Flopez
 */
public class Imprimir {

    public static Ticket ticket = new Ticket();
    public static void main(String[] args) {
        ImprimirComprobante nuevo= new ImprimirComprobante();
        nuevo.imprimirAnular("0001", "10.20", "ROSA FUENTE");
    }
}
