/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import org.hibernate.Session;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.dao.MovimientoDao;
import pe.com.ega.sgces.model.Movimiento;

/**
 *
 * @author FLOPEZ
 */
public class MovimientoLogicaImpl implements MovimientoLogica{

    Session session; 
    MovimientoDao movimientoDao;

    public MovimientoLogicaImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void setMovimientoDao(MovimientoDao movimientoDao) {
        this.movimientoDao = movimientoDao;
        this.movimientoDao.setSession(session);

    }
    
    @Override
    public void grabar(Movimiento movimiento) {
        session.beginTransaction();
        movimientoDao.insertar(movimiento);
        session.getTransaction().commit(); 
    }

    @Override
    public Movimiento buscarPorCodigo(Integer id) {
        return movimientoDao.buscarPorCodigo(id);
    }

    @Override
    public Double buscarMonto(String tipo, String turno) {
        List lis=movimientoDao.buscarMonto(tipo, turno);

        String numero=lis.toString().replace("[", "");
        numero=numero.replace("]", "");

        return Double.parseDouble(numero);
    }

    @Override
    public Movimiento buscarTransaccion(String transaccion) {
        return movimientoDao.buscarTransaccion(transaccion);
    }

    @Override
    public void eliminar(Movimiento movimiento) {
        session.beginTransaction();
        movimientoDao.eliminar(movimiento);
        session.getTransaction().commit(); 
    }

    @Override
    public Double buscarMontoVuelto(String tipo, String turno) {
        Double monto;
                try{
                List lis=movimientoDao.buscarMontoVuelto(tipo, turno);
                monto=Util.recuperarNumero(lis);
         } catch (Exception ex) {
                    monto=0.00;
         }
        return monto;
    }
}
