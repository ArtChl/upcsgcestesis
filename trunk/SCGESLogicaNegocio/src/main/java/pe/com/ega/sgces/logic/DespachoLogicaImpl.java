/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.com.ega.sgces.dao.DespachoDao;
import pe.com.ega.sgces.model.Despacho;

/**
 *
 * @author CHRISTIAN
 */
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class DespachoLogicaImpl implements DespachoLogica {

    private DespachoDao despachoDao;

    public DespachoLogicaImpl() {
    }

    @Override
    public void setDespachoDao(DespachoDao despachoDao) {
        this.despachoDao = despachoDao;
    }

    @Override
    public void grabar(Despacho despacho) {
        if (despacho.getId() == 0) {
            despachoDao.insertar(despacho);
        } else {
            despachoDao.actualizar(despacho);
        }
    }

    @Override
    public void eliminar(Despacho despacho) {
        despachoDao.eliminar(despacho);
    }

    @Override
    @Transactional(readOnly = true)
    public Despacho buscarPorCodigo(Integer id) {
        return despachoDao.buscarPorCodigo(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Despacho> buscarTodos() {
        return despachoDao.buscarTodos();
    }

    @Override
    public void actualizar(Despacho despacho) {
        despachoDao.actualizar(despacho);
    }
}
