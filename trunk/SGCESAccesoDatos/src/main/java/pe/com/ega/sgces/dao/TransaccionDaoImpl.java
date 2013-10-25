/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Transaccion;

/**
 *
 * @author Flopez
 */
public class TransaccionDaoImpl implements TransaccionDao{

    Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
        
    @Override
    public void insertar(Transaccion transaccion) {
        transaccion.setFacturado(false);
        transaccion.setAnulado(false);
        session.save(transaccion);
    }

    @Override
    public void actualizar(Transaccion transaccion) {
        System.out.println("TransaccionDao"+transaccion.getId());
        session.update(transaccion);
    }

    @Override
    public void eliminar(Transaccion transaccion) {
        session.delete(transaccion);
    }

    @Override
    public Transaccion buscarPorCodigo(Integer id) {
        return (Transaccion) session.load(Transaccion.class, id);
    }

    @Override
    public List<Transaccion> buscarTodos() {
         return session.createQuery("from Transaccion").list();
    }

    @Override
    public List<Transaccion> buscarListaId(String id) {
        return session.createQuery("from Transaccion where idcliente='"+id+"' and idtipotransaccion='NDES' and facturado=false and anulado=false").list();
    }

    @Override
    public List<Transaccion> buscarTodosDoc(String documento) {
        System.out.println(documento);
        return session.createQuery("from Transaccion where idtipotransaccion='"+documento+"'").list();
    }

    @Override
    public List buscarMonto(String tipo, String turno) throws Exception {
       Query query = session.createQuery("select sum(montototal) from Transaccion where producto='"+tipo+"' and idestado='"+turno+"'");
       System.out.println("consulta"+query.getQueryString());
       List results = query.list();
       return results;
    }

    @Override
    public List<Transaccion> buscarTurno(int turno) {
        System.out.println("codigo turno"+turno);
        return session.createQuery("from Transaccion where idestado="+turno+" and anulado=false").list();
    }
    
}
