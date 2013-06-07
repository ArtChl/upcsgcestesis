/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import pe.com.ega.sgces.dao.DespachoDao;
import pe.com.ega.sgces.model.Despacho;

/**
 *
 * @author CHRISTIAN
 */
public class DespachoLogicaImpl implements DespachoLogica {

    DespachoDao despachoDao;
    public void setDespachoDao(DespachoDao despachoDao) {
        this.despachoDao = despachoDao;   
    }
    
    public void grabar(Despacho despacho) {
        if(despacho.getId() == 0) 
        {
           despachoDao.insertar(despacho);
        }
        else{
         despachoDao.actualizar(despacho);
        }
    }

    public void eliminar(Despacho despacho) {
        despachoDao.eliminar(despacho);
    }

    public Despacho buscarPorCodigo(Integer id) {
        return despachoDao.buscarPorCodigo(id);
    }

}
