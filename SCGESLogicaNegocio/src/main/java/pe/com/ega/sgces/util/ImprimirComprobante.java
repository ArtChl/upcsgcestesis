/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Flopez
 */
public class ImprimirComprobante {

    public static Ticket ticket = new Ticket();
       
    public void imprimirFacturaDetalle(){
        try{
            Date date=new Date();
            SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat hora=new SimpleDateFormat("hh:mm:ss aa");
            
            ticket.AddCabecera("             GRIFO KAT'S");
            ticket.AddCabecera(ticket.DarEspacio());
            ticket.AddCabecera("Dir:Av. Jose Galvez Esq. Alfonso Ugarte");
            ticket.AddCabecera("         Bellavista Callao");
            ticket.AddCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DibujarLinea(40));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("Control Suministro No:'0000111'");
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("        "+fecha.format(date) + " " + hora.format(date));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(" Mesa "+"1"+" Mozo "+"3001"+" Pers "+"LOPEZ CORDOVA");
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DibujarLinea(40));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("QTA   PRODUCTO             P.U     TOTAL");
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DibujarLinea(40));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddItem("2","GAS98","13.45","20.58");
            ticket.AddItem("2","GAS98","13.45","20.58");
            //ticket.AddTotal("",ticket.DarEspacio());
            ticket.AddFinItem(ticket.DibujarLinea(40));
            ticket.AddTotal("SUBTOTAL","20.00");
            ticket.AddTotal("IGV","0.36");
            ticket.AddTotal("TOTAL VENTA","17.24");
            ticket.AddTotal("PAGA CON","50.00");
            ticket.AddTotal("VUELTO","30.00");
            ticket.AddPieLinea(ticket.DarEspacio());
            ticket.AddPieLinea(ticket.DarEspacio());
            ticket.AddPieLinea("       Gracias por su Preferencia");
            ticket.ImprimirDocumento("COM1");
        }catch(Exception e){System.out.print("\nerror "+e.toString());}
    }
    
    public void imprimirVale(String cliente,String chofer, String placa, String producto, String Galones, String numero){
        try{
            
            Date date=new Date();
            SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat hora=new SimpleDateFormat("hh:mm:ss aa");
            
            ticket.AddCabecera("              GRIFO KAT'S");
            ticket.AddCabecera(ticket.DarEspacio());
            ticket.AddCabecera("Dir:Av. Jose Galvez Esq. Alfonso Ugarte");
            ticket.AddCabecera("            Bellavista Callao");
            ticket.AddCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DibujarLinea(40));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("   Control Suministro No:"+String.format("%06d",Integer.parseInt(numero)));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("        "+fecha.format(date) + " " + hora.format(date));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DibujarLinea(40));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("CLIENTE  : "+cliente);
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("CHOFER   : "+chofer);
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("PLACA    : "+placa);
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("PRODUCTO : "+String.format("%1$-8s",producto));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("GALONES  : "+Galones);
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DibujarLinea(40));
            ticket.AddPieLinea(ticket.DarEspacio());
            ticket.AddPieLinea(ticket.DarEspacio());
            ticket.AddPieLinea(ticket.DarEspacio());
            ticket.AddPieLinea("________________        ________________");
            ticket.AddPieLinea("    CHOFER                    PLAYERO ");
            ticket.ImprimirDocumento("COM1");
        }catch(Exception e){System.out.print("\nerror "+e.toString());}
    }
    
    public void imprimirBoleta(String vendedor, String total, String precio, String producto, String Galones, String numero, String emisor, String ruc, String impresora, String comprobante){
        try{
            
            Date date=new Date();
            SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat hora=new SimpleDateFormat("hh:mm:ss aa");
            
            ticket.AddCabecera("              GRIFO KAT'S");
            ticket.AddCabecera(ticket.DarEspacio());
            ticket.AddCabecera("Dir:Av. Jose Galvez Esq. Alfonso Ugarte");
            ticket.AddCabecera("            Bellavista Callao");
            ticket.AddCabecera(ticket.DarEspacio());
            ticket.AddCabecera(" R.U.C "+ruc+"  Serie #:"+impresora);
            ticket.AddCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DibujarLinea(40));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(fecha.format(date)+" "+hora.format(date)+" "+comprobante+" "+emisor+"-"+String.format("%08d",Integer.parseInt(numero)));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DibujarLinea(40));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddItemBoleta(Galones,"GlnX S/.",precio,"      ");
            ticket.AddTotalBoleta(producto,total);
            ticket.AddPieLinea(ticket.DarEspacio());
            ticket.AddTotalBoleta("","");
            ticket.AddTotalBoleta("****TOTAL S/.",total);
            ticket.AddPieLinea(ticket.DarEspacio());
            ticket.AddPieLinea("Cobrado por: "+String.format("%1$27s",vendedor));
            ticket.AddPieLinea("       Gracias por su Preferencia");
            ticket.ImprimirDocumento("COM1");
        }catch(Exception e){System.out.print("\nerror "+e.toString());}
    }
    
    public void imprimirFactura(String cliente, String rucCliente, String vendedor, String total, String subtotal, String igv,String precio, String producto, String Galones, String numero, String emisor, String ruc, String impresora, String comprobante){
        try{
            
            Date date=new Date();
            SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat hora=new SimpleDateFormat("hh:mm:ss aa");
            
            ticket.AddCabecera("              GRIFO KAT'S");
            ticket.AddCabecera(ticket.DarEspacio());
            ticket.AddCabecera("Dir:Av. Jose Galvez Esq. Alfonso Ugarte");
            ticket.AddCabecera("            Bellavista Callao");
            ticket.AddCabecera(ticket.DarEspacio());
            ticket.AddCabecera(" R.U.C "+ruc+"  Serie #:"+impresora);
            ticket.AddCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DibujarLinea(40));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(fecha.format(date)+" "+hora.format(date)+" "+comprobante+" "+emisor+"-"+String.format("%08d",Integer.parseInt(numero)));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DibujarLinea(40));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("NOMBRE: "+String.format("%1$-32s",cliente));
            ticket.AddSubCabecera("R.U.C : "+String.format("%1$-32s",rucCliente));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DibujarLinea(40));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddItemBoleta(Galones,"GlnX S/.",precio,"      ");
            ticket.AddTotalBoleta(producto,total);
            ticket.AddPieLinea(ticket.DarEspacio());
            ticket.AddTotalBoleta("","");
            ticket.AddTotalBoleta("****VALOR VTA. S/.",subtotal);
            ticket.AddTotalBoleta("****IGV 18.0%",igv);
            ticket.AddTotalBoleta("****TOTAL S/.",total);
            ticket.AddPieLinea(ticket.DarEspacio());
            ticket.AddPieLinea("Cobrado por: "+String.format("%1$27s",vendedor));
            ticket.AddPieLinea("       Gracias por su Preferencia");
            ticket.ImprimirDocumento("COM1");
        }catch(Exception e){System.out.print("\nerror "+e.toString());}
    }
    
    public void imprimirNotaDespacho(String kilometraje,String placa, String chofer, String cliente, String rucCliente, String vendedor, String total, String subtotal, String igv,String precio, String producto, String Galones, String numero, String emisor, String ruc, String impresora, String comprobante){
        try{
            
            Date date=new Date();
            SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat hora=new SimpleDateFormat("hh:mm:ss aa");
            
            ticket.AddCabecera("              GRIFO KAT'S");
            ticket.AddCabecera(ticket.DarEspacio());
            ticket.AddCabecera("Dir:Av. Jose Galvez Esq. Alfonso Ugarte");
            ticket.AddCabecera("            Bellavista Callao");
            ticket.AddCabecera(ticket.DarEspacio());
            ticket.AddCabecera(" R.U.C "+ruc+"  Serie #:"+impresora);
            ticket.AddCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DibujarLinea(40));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(fecha.format(date)+" "+hora.format(date)+" "+comprobante+" "+emisor+"-"+String.format("%08d",Integer.parseInt(numero)));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DibujarLinea(40));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("NOMBRE: "+String.format("%1$-32s",cliente));
            ticket.AddSubCabecera("R.U.C : "+String.format("%1$-32s",rucCliente));
            ticket.AddSubCabecera("PLACA:  "+String.format("%1$-32s",placa));
            ticket.AddSubCabecera("CHOFER: "+String.format("%1$-32s",chofer));
            ticket.AddSubCabecera("KILOMETRAJE: "+String.format("%1$-27s",kilometraje));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DibujarLinea(40));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddItemBoleta(Galones,"GlnX S/.",precio,"      ");
            ticket.AddTotalBoleta(producto,total);
            ticket.AddPieLinea(ticket.DarEspacio());
            ticket.AddPieLinea("            SIN VALOR FISCAL");
            ticket.AddPieLinea(ticket.DarEspacio());
            ticket.AddPieLinea("Recibi Conforme:                        ");
            ticket.AddPieLinea("Firma:..................................");
            ticket.AddPieLinea("Nombre:.................................");
            ticket.AddPieLinea("DNI:....................................");
            ticket.AddPieLinea(ticket.DarEspacio());
            ticket.AddPieLinea("Cobrado por: "+String.format("%1$27s",vendedor));
            ticket.AddPieLinea("       Gracias por su Preferencia");
            ticket.ImprimirDocumento("COM1");
        }catch(Exception e){System.out.print("\nerror "+e.toString());}
    }
    
     public void imprimirTirada(String caja,String numero, String tipo, String cantidad, String usuario){
        try{
            
            Date date=new Date();
            SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat hora=new SimpleDateFormat("hh:mm:ss aa");
            
            ticket.AddCabecera("        TIRADA DE VALORES A BUZON       ");
            ticket.AddCabecera(ticket.DarEspacio());
            ticket.AddCabecera("            GRIFO KAT'S");
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("CAJA : "+String.format("%1$-33s",caja));
            ticket.AddSubCabecera(fecha.format(date)+"                  "+hora.format(date)+" ");
            ticket.AddSubCabecera("SOBRE NRO : "+String.format("%1$-28s",numero));  
            ticket.AddSubCabecera("****************************************");
            ticket.AddSubCabecera(String.format("%1$-20s",tipo)+" "+String.format("%1$19s",cantidad));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("TOTAL : "+String.format("%1$32s",cantidad));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DibujarLinea(40));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddPieLinea("usuario: "+String.format("%1$-31s",usuario));
            ticket.AddPieLinea(ticket.DarEspacio());
            ticket.AddPieLinea("Firma:..................................");
            ticket.AddPieLinea(ticket.DarEspacio());
            ticket.AddPieLinea("Nombre:.................................");
            ticket.AddPieLinea(ticket.DarEspacio());
            ticket.AddPieLinea("        Gracias por su Preferencia");
            ticket.ImprimirDocumento("COM1");
        }catch(Exception e){System.out.print("\nerror "+e.toString());}
    }
     
     public void imprimirArqueo(String caja,String soles, String dolares, String visa, String total , String mastercard, String usuario){
        try{
            
            Date date=new Date();
            SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat hora=new SimpleDateFormat("hh:mm:ss aa");
            
            ticket.AddCabecera("           ARQUEO DE CAJA      ");
            ticket.AddCabecera(ticket.DarEspacio());
            ticket.AddCabecera("            GRIFO KAT'S");
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("CAJA : "+String.format("%1$-33s",caja));
            ticket.AddSubCabecera(fecha.format(date)+"                  "+hora.format(date)+" ");
            ticket.AddSubCabecera("****************************************");
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("NUEVOS SOLES : "+String.format("%1$25s",soles));
            ticket.AddSubCabecera("DOLARES (2.80) : "+String.format("%1$23s",dolares));
            ticket.AddSubCabecera("VISA : "+String.format("%1$33s",visa));
            ticket.AddSubCabecera("MASTERCARD : "+String.format("%1$27s",mastercard));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("TOTAL : "+String.format("%1$32s",total));
            ticket.AddSubCabecera(ticket.DibujarLinea(40));
            ticket.AddPieLinea("usuario: "+String.format("%1$-31s",usuario));
            ticket.AddPieLinea(ticket.DarEspacio());
            ticket.ImprimirDocumento("COM1");
        }catch(Exception e){System.out.print("\nerror "+e.toString());}
    }
     
     public void imprimirTurno(String caja,String soles, String dolares, String visa, String total , String mastercard, String usuario){
        try{
            
            Date date=new Date();
            SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat hora=new SimpleDateFormat("hh:mm:ss aa");
            
            ticket.AddCabecera("           CIERRE TURNO      ");
            ticket.AddCabecera(ticket.DarEspacio());
            ticket.AddCabecera("            GRIFO KAT'S");
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("TURNO : "+String.format("%1$-32s",caja));
            ticket.AddSubCabecera(fecha.format(date)+"                  "+hora.format(date)+" ");
            ticket.AddSubCabecera("****************************************");
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("GASOLINA 84 : "+String.format("%1$26s",soles));
            ticket.AddSubCabecera("GASOLINA 90 : "+String.format("%1$26s",dolares));
            ticket.AddSubCabecera("GASOLINA 94 : "+String.format("%1$26s",visa));
            ticket.AddSubCabecera("DIESEL : "+String.format("%1$31s",mastercard));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("TOTAL : "+String.format("%1$32s",total));
            ticket.AddSubCabecera(ticket.DibujarLinea(40));
            ticket.AddPieLinea("usuario: "+String.format("%1$-31s",usuario));
            ticket.AddPieLinea(ticket.DarEspacio());
            ticket.ImprimirDocumento("COM1");
        }catch(Exception e){System.out.print("\nerror "+e.toString());}
    }
     
     public void imprimirAnular(String comprobante,String importe,String usuario){
        try{
            
            Date date=new Date();
            SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat hora=new SimpleDateFormat("hh:mm:ss aa");
            
            ticket.AddCabecera("       ** COMPROBANTE DE EXTORNO **     ");
            ticket.AddCabecera(ticket.DarEspacio());
            ticket.AddCabecera("               GRIFO KAT'S");
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("COMPROBANTE ANULADO : "+String.format("%1$-18s",comprobante));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera("IMPORTE ORIGINAL : "+String.format("%1$-21s",importe));
            ticket.AddSubCabecera("FECHA - HORA :  "+fecha.format(date)+" - "+hora.format(date));
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DarEspacio());
            ticket.AddSubCabecera(ticket.DarEspacio());         
            ticket.AddPieLinea("IMPRESO POR : "+String.format("%1$-26s",usuario));
            ticket.AddPieLinea(ticket.DarEspacio());
            ticket.ImprimirDocumento("COM1");
        }catch(Exception e){System.out.print("\nerror "+e.toString());}
    }
     
    
}
