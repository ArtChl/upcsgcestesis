/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.util;

/**
 *
 * @author Flopez
 */
public class OrderTotal {
    char[] temp=new char[] { ' ' };
    public OrderTotal(char delimit){temp=new char[]{delimit};}
    public String getTotalNombre(String totalItem){
        String[] delimitado=totalItem.split(""+temp);
        return delimitado[0];
    }
    public String getTotalCantidad(String totalItem){
        String[] delimitado=totalItem.split(""+temp);
        return delimitado[1];
    }
    public String generaTotal(String nombre, String precio){
        return String.format("%1$-32s",nombre)+String.format("%1$8s",precio);
    }
    public String generaTotalBoleta(String nombre, String precio){
        return String.format("%1$-32s",nombre)+String.format("%1$8s",precio);
    }
}
