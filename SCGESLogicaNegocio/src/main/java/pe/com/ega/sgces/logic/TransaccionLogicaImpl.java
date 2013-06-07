/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

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
    TransaccionDao transaccionDao;
    public void setTransaccionDao(TransaccionDao transaccionDao) {
        this.transaccionDao = transaccionDao;   
    }
    
    TransaccionDetalleDao transacciondetalleDao;
    public void setTransaccionDetalleDao(TransaccionDetalleDao transacciondetalleDao) {
        this.transacciondetalleDao = transacciondetalleDao;   
    }
    
    public void grabar(Transaccion transaccion) {
        transaccionDao.insertar(transaccion);
        for (Transacciondetalle detalle : transaccion.getTransacciondetalles()) {
            transacciondetalleDao.insertar(detalle);
        }
    }

    public Transaccion buscarPorCodigo(Integer id) {
        return transaccionDao.buscarPorCodigo(id);
    }
    
}
