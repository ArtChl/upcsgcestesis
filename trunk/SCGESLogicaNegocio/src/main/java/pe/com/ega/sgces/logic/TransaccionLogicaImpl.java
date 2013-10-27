/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import org.hibernate.Session;
import pe.com.ega.sgces.dao.DespachoDaoImpl;
import pe.com.ega.sgces.dao.HibernateUtil;
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
    Session session; 
    TransaccionDao transaccionDao;
    DespachoLogicaImpl despachoLogica;
  
    
    public TransaccionLogicaImpl()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        despachoLogica=new DespachoLogicaImpl();
        despachoLogica.setDespachoDao(new DespachoDaoImpl());
     
    }
    
   
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
        session.beginTransaction();
        transaccionDao.insertar(transaccion);
        for (Transacciondetalle detalle : transaccion.getTransacciondetalles()) {
            transacciondetalleDao.insertar(detalle);
        }
        session.getTransaction().commit(); 
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
        System.out.println("Entro despacho1"+transaccion.getAnulado());
        if(transaccion.getAnulado()==true){
            System.out.println("Entro despacho2");
            transaccion.getDespacho().setIdestado(1);
            despachoLogica.actualizar(transaccion.getDespacho());
        }
        session.beginTransaction();
        transaccionDao.actualizar(transaccion);
        session.getTransaction().commit(); 
          
    }

    @Override
    public List<Transaccion> buscarTurno(int turno) {
        return transaccionDao.buscarTurno(turno);
    }
    
}
