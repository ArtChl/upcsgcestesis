/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.util;

/**
 *
 * @author CHRISTIAN
 */
public class Formato {

    public static double redondear(double numero) {
        return Math.rint(numero * 100) / 100;
    }

    public static String redondearCadena(double numero) {
        return String.valueOf(Math.rint(numero * 100) / 100);
    }

    public static String agregarCeros(String string, int largo) {
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
