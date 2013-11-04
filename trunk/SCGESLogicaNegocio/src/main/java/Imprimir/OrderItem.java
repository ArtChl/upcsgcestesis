/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imprimir;

/**
 *
 * @author Flopez
 */
public class OrderItem {
    char[] temp=new char[]{ ' ' };
    public OrderItem(char delimit){temp=new char[]{delimit };}
    public String GetItemCantidad(String orderItem){
        String[] delimitado=orderItem.split(""+temp);
        return delimitado[0];
    }
    public String GetItemNombre(String orderItem){
        String[] delimitado=orderItem.split(""+temp);
        return delimitado[1];
    }
    public String GetItemPrecio(String orderItem){
        String[] delimitado=orderItem.split(""+temp);
        return delimitado[2];
    }
    public String GetItemTotal(String orderItem){
        String[] delimitado=orderItem.split(""+temp);
        return delimitado[3];
    }
    public String GeneraItem(String cantidad, String nombre, String precio,String total){
        //return cantidad+temp[0]+nombre+temp[0]+precio+temp[0]+total;
        return String.format("%1$-6s",cantidad)+String.format("%1$-20s",nombre)+String.format("%1$6s",precio)+String.format("%1$8s",total);
    }
    
    public String GeneraItemBoleta(String cantidad, String nombre, String precio,String total){
        //return cantidad+temp[0]+nombre+temp[0]+precio+temp[0]+total;
        return String.format("%1$-10s",cantidad)+String.format("%1$-10s",nombre)+String.format("%1$6s",precio)+String.format("%1$14s",total);
    }
}
