/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.dao.MovimientoDao;
import pe.com.ega.sgces.model.Movimiento;

/**
 *
 * @author FLOPEZ
 */
public class MovimientoLogicaImpl implements MovimientoLogica{

    SessionFactory session; 
    private MovimientoDao movimientoDao;

    public MovimientoLogicaImpl() {
    }
    
    
    @Override
    public void setSession(SessionFactory session) {
        this.session = session;
    }
    
    @Override
    public void setMovimientoDao(MovimientoDao movimientoDao) {
        this.movimientoDao = movimientoDao;
    }
    
    @Override
    public void grabar(Movimiento movimiento) {
       session.getCurrentSession().beginTransaction();
       movimientoDao.insertar(movimiento);
       session.getCurrentSession().getTransaction().commit(); 
    }

    @Override
    public Movimiento buscarPorCodigo(Integer id) {
        return movimientoDao.buscarPorCodigo(id);
    }

    @Override
    public Double buscarMonto(String tipo, String turno) {
        Double monto;
         try{
                List lis=movimientoDao.buscarMonto(tipo, turno);
                monto=Util.recuperarNumero(lis);
         } catch (Exception ex) {
                    monto=0.00;
         }
        return monto;
    }

    @Override
    public Movimiento buscarTransaccion(String transaccion) {
        return movimientoDao.buscarTransaccion(transaccion);
    }

    @Override
    public void eliminar(Movimiento movimiento) {
       session.getCurrentSession().beginTransaction();
        movimientoDao.eliminar(movimiento);
       session.getCurrentSession().getTransaction().commit(); 
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
