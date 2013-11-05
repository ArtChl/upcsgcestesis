/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.util;

/**
 *
 * @author Flopez
 */
public class OrderItem {
    char[] temp=new char[]{ ' ' };
    public OrderItem(char delimit){temp=new char[]{delimit };}
    public String getItemCantidad(String orderItem){
        String[] delimitado=orderItem.split(""+temp);
        return delimitado[0];
    }
    public String getItemNombre(String orderItem){
        String[] delimitado=orderItem.split(""+temp);
        return delimitado[1];
    }
    public String getItemPrecio(String orderItem){
        String[] delimitado=orderItem.split(""+temp);
        return delimitado[2];
    }
    public String getItemTotal(String orderItem){
        String[] delimitado=orderItem.split(""+temp);
        return delimitado[3];
    }
    public String generaItem(String cantidad, String nombre, String precio,String total){
        return String.format("%1$-6s",cantidad)+String.format("%1$-20s",nombre)+String.format("%1$6s",precio)+String.format("%1$8s",total);
    }
    
    public String generaItemBoleta(String cantidad, String nombre, String precio,String total){
        return String.format("%1$-10s",cantidad)+String.format("%1$-10s",nombre)+String.format("%1$6s",precio)+String.format("%1$14s",total);
    }
}
