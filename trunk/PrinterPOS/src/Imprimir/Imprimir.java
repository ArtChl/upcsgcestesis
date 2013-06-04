/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imprimir;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Flopez
 */
public class Imprimir {

    public static Ticket ticket = new Ticket();
    public static void main(String[] args) {
        ImprimirComprobante nuevo= new ImprimirComprobante();
        nuevo.imprimirVale("MUNICIPALIDAD DE LA PERLA","LOPEZ CORDOVA, EDWIN FRANK", "TGJ456", "GASOLINA 90","10.25", "1");
        nuevo.imprimirBoleta("OSCAR CARLOS BENAVIDES","50.00", "10.25", "GASOLINA 90","3.771", "1","003","10419492421","FF9G151630","TBOL" );
        nuevo.imprimirFactura("AGROINDURTIA SUPE S.A.C","20141718780","OSCAR CARLOS BENAVIDES","50.00","42.37","7.63","10.25", "GASOLINA 90","3.771", "1","003","10419492421","FF9G151630","TFAC" );
        nuevo.imprimirNotaDespacho("223855","TGJ-432","EDWIN LOPEZ","AGROINDURTIA SUPE S.A.C","20141718780","OSCAR CARLOS BENAVIDES","50.00","42.37","7.63","10.25", "GASOLINA 90","3.771", "1","003","10419492421","FF9G151630","TFAC" );
    }
}
