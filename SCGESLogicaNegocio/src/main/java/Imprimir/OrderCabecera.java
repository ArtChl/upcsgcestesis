/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imprimir;

/**
 *
 * @author Flopez
 */
public class OrderCabecera {
    char[] temp=new char[] { ' ' };
    public OrderCabecera(char delimit){temp=new char[]{delimit};}
    public String GetTotalNombre(String totalItem){
        String[] delimitado=totalItem.split(""+temp);
        return delimitado[0];
    }
    public String GetCabeceraCantidad(String totalItem){
        String[] delimitado=totalItem.split(""+temp);
        return delimitado[1];
    }
    public String GeneraCabecera(String nombre, String precio){
        return String.format("%1$-32s",nombre)+String.format("%1$8s",precio);
    }
    public String GeneraCabeceraFactura(String nombre, String precio){
        return String.format("%1$-10s",nombre)+String.format("%1$40s",precio);
    }
}
