/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import pe.com.ega.sgces.model.Despacho;
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
       DespachoDao usuariodao = new DespachoDaoImpl();
       List <Despacho> lista = usuariodao.buscarTodos();
       System.out.println("Numero: "+lista.get(1).getMontoSoles());
    }
}
