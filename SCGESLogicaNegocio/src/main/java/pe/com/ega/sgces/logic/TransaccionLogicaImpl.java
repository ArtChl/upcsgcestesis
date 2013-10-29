/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.dao.TransaccionDao;
import pe.com.ega.sgces.dao.TransaccionDetalleDao;
import pe.com.ega.sgces.model.Transaccion;
import pe.com.ega.sgces.model.Transacciondetalle;

/**
 *
 * @author CHRISTIAN
 */
public class TransaccionLogicaImpl implements TransaccionLogica
{
    SessionFactory session; 
    TransaccionDao transaccionDao;
    DespachoLogica despachoLogica;
    MovimientoLogica movimientoLogica;
 
    public TransaccionLogicaImpl()
    {
      
    }
    
    @Override
    public void setDespachoLogica(DespachoLogica despachoLogica) {
        this.despachoLogica = despachoLogica;
    }

    @Override
    public void setMovimientoLogica(MovimientoLogica movimientoLogica) {
        this.movimientoLogica = movimientoLogica;
    }
   
    @Override
    public void setSession(SessionFactory session) {
        this.session = session;
    }
    
    @Override
    public void setTransaccionDao(TransaccionDao transaccionDao) {
        this.transaccionDao = transaccionDao;
        this.transaccionDao.setSession(session);

    }
    
    TransaccionDetalleDao transacciondetalleDao;
    public void setTransaccionDetalleDao(TransaccionDetalleDao transacciondetalleDao) {
        this.transacciondetalleDao = transacciondetalleDao; 
        this.transaccionDao.setSession(session);
    }
    
    @Override
    public void grabar(Transaccion transaccion) {
        session.getCurrentSession().beginTransaction();
        transaccionDao.insertar(transaccion);
        for (Transacciondetalle detalle : transaccion.getTransacciondetalles()) {
            transacciondetalleDao.insertar(detalle);
        }
        session.getCurrentSession().getTransaction().commit(); 
    }

    @Override
    public Transaccion buscarPorCodigo(Integer id) {
        return transaccionDao.buscarPorCodigo(id);
    }

    @Override
    public List<Transaccion> buscarListaId(String id) {
        return transaccionDao.buscarListaId(id);
    }

    @Override
    public List<Transaccion> buscarTodo() {
        return transaccionDao.buscarTodos();
    }
    
    @Override
     public List<Transaccion> buscarTodoDoc(String documento) {
        return transaccionDao.buscarTodosDoc(documento);
    }

    @Override
    public Double buscarMonto(String tipo, String turno) {
        Double monto;
        try{
            List lis=transaccionDao.buscarMonto(tipo, turno);
            monto=Util.recuperarNumero(lis);
        } catch (Exception ex) {
                   monto=0.00;
        }
        return monto;
    }

    @Override
    public void actualizar(Transaccion transaccion) {
        
        try {
            session.getCurrentSession().beginTransaction();
            transaccionDao.actualizar(transaccion);       
            session.getCurrentSession().getTransaction().commit(); 
            System.out.println("Transaccion"+transaccion.getNumerovale());
            if(transaccion.getAnulado()==true)
            {
            transaccion.getDespacho().setIdestado(1);
            despachoLogica.actualizar(transaccion.getDespacho());
            movimientoLogica.eliminar(movimientoLogica.buscarTransaccion(String.valueOf(transaccion.getId())));
            }
            
        } catch (Exception e) {
            session.getCurrentSession().getTransaction().rollback();
        }   
    }

    @Override
    public List<Transaccion> buscarTurno(int turno) {
        return transaccionDao.buscarTurno(turno);
    }
    
}
