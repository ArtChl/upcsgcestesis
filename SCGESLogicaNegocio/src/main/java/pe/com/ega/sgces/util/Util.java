/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.util;

import java.util.List;

/**
 *
 * @author CHRISTIAN
 */
public class Util {

    public static Double recuperarNumero(List lista) {
        Double monto = 0.00;
        if (lista != null) {
            String numero = lista.toString().replace("[", "");
            numero = numero.replace("]", "");
            monto = Double.parseDouble(numero);
        }
        return monto;
    }

    public static double redondear(double numero) {
        int cifras = (int) Math.pow(10, 2);
        return Math.rint(numero * cifras) / cifras;
    }
}
