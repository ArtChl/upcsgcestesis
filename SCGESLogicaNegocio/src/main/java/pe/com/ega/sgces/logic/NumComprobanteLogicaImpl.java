/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.com.ega.sgces.dao.NumComprobanteDao;
import pe.com.ega.sgces.model.Numcomprobante;

/**
 *
 * @author FLOPEZ
 */
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class NumComprobanteLogicaImpl implements NumComprobanteLogica {

    private NumComprobanteDao valeDao;

    public NumComprobanteLogicaImpl() {
    }

    public void setValeDao(NumComprobanteDao numDao) {
        this.valeDao = numDao;
    }

    @Override
    public void insertar(Numcomprobante numDao) {
        valeDao.insertar(numDao);
    }

    @Override
    public void actualizar(Numcomprobante numDao) {
        valeDao.actualizar(numDao);
    }

    @Override
    public void eliminar(Numcomprobante numDao) {
        valeDao.eliminar(numDao);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Numcomprobante> buscarConsumo(String cliente) {
        return valeDao.buscarConsumo(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Numcomprobante buscarPorCodigo(int tipo) {
        return valeDao.buscarPorCodigo(tipo);
    }
}
