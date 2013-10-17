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
import pe.com.ega.sgces.dao.NumComprobanteDao;
import pe.com.ega.sgces.dao.NumComprobanteDaoImpl;
import pe.com.ega.sgces.dao.TransaccionDao;
import pe.com.ega.sgces.dao.TransaccionDaoImpl;
import pe.com.ega.sgces.dao.UsuariodaoImpl;
import pe.com.ega.sgces.dao.ValeDaoImpl;
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.model.Movimiento;
import pe.com.ega.sgces.model.NumComprobante;
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
     /*TransaccionLogicaImpl trans=new TransaccionLogicaImpl();
     trans.setTransaccionDao(new TransaccionDaoImpl());
     ArrayList<Transaccion> comprobantes= (ArrayList<Transaccion>) trans.buscarTodoDoc("NDES");
            int i=comprobantes.size();
            System.out.println(comprobantes.size());
            int num=comprobantes.get(i-1).getNumero();*/
       NumComprobanteLogicaImpl valedao = new NumComprobanteLogicaImpl(); 
       valedao.setValeDao(new NumComprobanteDaoImpl());
       //valedao.setSession(session);
       //List<Cliente> cliente=usuariodao.razon(1041949242);
      // System.out.println("Cliente"+cliente.get(1).getRazonSocial());
       NumComprobante comprobantes= valedao.buscarPorCodigo(1);
        System.out.println(comprobantes.getNumero());
       comprobantes.setNumero(comprobantes.getNumero()+1);
        valedao.actualizar(comprobantes);
    }
}
