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

    public void setSession(Session session) {
        this.session = session;
    }
        
    public void insertar(Transaccion transaccion) {
        transaccion.setFacturado(false);
        transaccion.setAnulado(false);
        session.save(transaccion);
    }

    public void actualizar(Transaccion transaccion) {
        session.update(transaccion);
    }

    public void eliminar(Transaccion transaccion) {
        session.delete(transaccion);
    }

    public Transaccion buscarPorCodigo(Integer id) {
        return (Transaccion) session.load(Transaccion.class, id);
    }

    public List<Transaccion> buscarTodos() {
         return session.createQuery("from Transaccion").list();
    }

    public List<Transaccion> buscarListaId(String id) {
        return session.createQuery("from Transaccion where idcliente='"+id+"' and idtipotransaccion='NDES' and facturado=false and anulado=false").list();
    }

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
    
}
