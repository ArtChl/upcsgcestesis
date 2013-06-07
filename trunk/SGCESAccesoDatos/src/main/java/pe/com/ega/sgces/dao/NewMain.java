/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.model.Transaccion;
import pe.com.ega.sgces.model.Transacciondetalle;
import pe.com.ega.sgces.model.Usuario;

/**
 *
 * @author FLOPEZ
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //DespachoDao usuariodao = new DespachoDaoImpl();
       //List <Despacho> lista = usuariodao.buscarTodos();
       //System.out.println("Numero: "+lista.get(1).getMontoSoles());
       Transaccion transaccion=new Transaccion();
       //transaccion.setId(2);
       Cliente cliente=new Cliente();
       cliente.setId(1);
       transaccion.setCliente(cliente);
       Despacho detalle = new Despacho();
       detalle.setId(1);
       transaccion.setDespacho(detalle);
       //new Set<Transacciondetalle> myset;
       
      // transaccion.setTransacciondetalles();
       TransaccionDao transdao = new TransaccionDaoImpl();
        try {
            transdao.insertar(transaccion);
        } catch (Exception e) {
            System.out.println("Numero: "+e);
        }
       
       
    }
}
