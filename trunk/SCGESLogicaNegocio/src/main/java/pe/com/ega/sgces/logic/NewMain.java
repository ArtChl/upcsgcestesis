/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pe.com.ega.sgces.dao.ClienteDao;
import pe.com.ega.sgces.dao.ClienteDaoImpl;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.dao.MovimientoDaoImpl;
import pe.com.ega.sgces.dao.UsuariodaoImpl;
import pe.com.ega.sgces.dao.ValeDaoImpl;
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.model.Movimiento;
import pe.com.ega.sgces.model.Transaccion;
import pe.com.ega.sgces.model.Turnopuntoventacaja;
import pe.com.ega.sgces.model.TurnopuntoventacajaId;
import pe.com.ega.sgces.model.Usuario;
import pe.com.ega.sgces.model.Vale;

/**
 *
 * @author FLOPEZ
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {   
      MovimientoLogicaImpl usuariodao = new MovimientoLogicaImpl();
       usuariodao.setMovimientoDao(new MovimientoDaoImpl());
       Movimiento movimiento=new Movimiento(); 
        Transaccion transaccion= new Transaccion();
        transaccion.setId(95);
        movimiento.setTransaccion(transaccion);
        movimiento.setPago("TBOL");
        Turnopuntoventacaja caja= new Turnopuntoventacaja();
        caja.setId(new TurnopuntoventacajaId(1, 1, 1));
        movimiento.setTurnopuntoventacaja(caja);
        movimiento.setMontoTotal(100.00);
        movimiento.setMontoRecibido(80.00);
        movimiento.setMontoDevuelto(100.00-80.00);
        usuariodao.grabar(movimiento);
      /* Usuario cli=new Usuario();
       cli.setLogin("admin");
       cli.setClave("admin");
       Usuario usu=usuariodao.buscarPorUsuario(cli);
       System.out.println("Cliente"+usu.getLogin());*/
/*       ValeLogicaImpl usuariodao = new ValeLogicaImpl();
       usuariodao.setValeDao(new ValeDaoImpl());  
       ArrayList<Vale> lista= (ArrayList<Vale>) usuariodao.buscarTodos("1041949242");
        for (Vale vale : lista) {
            System.out.println("Vale"+vale.getNumero());
        }    */
    }
}
