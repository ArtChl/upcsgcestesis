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
}
