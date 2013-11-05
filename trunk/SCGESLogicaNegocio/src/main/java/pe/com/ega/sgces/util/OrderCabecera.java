/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.util;

/**
 *
 * @author Flopez
 */
public class OrderCabecera {
    char[] temp=new char[] { ' ' };
    public OrderCabecera(char delimit){temp=new char[]{delimit};}
    public String getTotalNombre(String totalItem){
        String[] delimitado=totalItem.split(""+temp);
        return delimitado[0];
    }
    public String getCabeceraCantidad(String totalItem){
        String[] delimitado=totalItem.split(""+temp);
        return delimitado[1];
    }
    public String generaCabecera(String nombre, String precio){
        return String.format("%1$-32s",nombre)+String.format("%1$8s",precio);
    }
    public String generaCabeceraFactura(String nombre, String precio){
        return String.format("%1$-10s",nombre)+String.format("%1$40s",precio);
    }
}
