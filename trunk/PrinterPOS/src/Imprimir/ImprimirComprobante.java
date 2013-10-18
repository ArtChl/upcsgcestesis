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
public class ImprimirComprobante {

    public Ticket ticket = new Ticket();
       
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
            ticket.ImprimirDocumento("COM15");
        }catch(Exception e){System.out.print("\nerror "+e.toString());}
    }
    
    public void imprimirVale(String cliente,String chofer, String placa, String producto, String Galones, String numero){
        try{
            
            System.out.println("Chofer"+chofer+"placa"+placa+"producto"+producto+"galones"+Galones+"numero"+numero);
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
            ticket.ImprimirDocumento("COM15");
        }catch(Exception e){System.out.print("\nerror "+e.toString());}
    }
    
    public void imprimirBoleta(String vendedor, String total, String precio, String producto, String Galones, String numero, String emisor, String ruc, String impresora, String comprobante){
        try{
            
            System.out.println("Chofer"+total+"placa"+precio+"producto"+producto+"galones"+Galones+"numero"+numero);
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
            ticket.ImprimirDocumento("COM15");
        }catch(Exception e){System.out.print("\nerror "+e.toString());}
    }
    
    public void imprimirFactura(String cliente, String rucCliente, String vendedor, String total, String subtotal, String igv,String precio, String producto, String Galones, String numero, String emisor, String ruc, String impresora, String comprobante){
        try{
            
            System.out.println("Chofer"+total+"placa"+precio+"producto"+producto+"galones"+Galones+"numero"+numero);
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
            ticket.ImprimirDocumento("COM15");
        }catch(Exception e){System.out.print("\nerror "+e.toString());}
    }
    
    public void imprimirNotaDespacho(String kilometraje,String placa, String chofer, String cliente, String rucCliente, String vendedor, String total, String subtotal, String igv,String precio, String producto, String Galones, String numero, String emisor, String ruc, String impresora, String comprobante){
        try{
            
            System.out.println("Chofer"+total+"placa"+precio+"producto"+producto+"galones"+Galones+"numero"+numero);
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
            ticket.ImprimirDocumento("COM15");
        }catch(Exception e){System.out.print("\nerror "+e.toString());}
    }
}
