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

@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class NumComprobanteLogicaImpl implements NumComprobanteLogica {

    private NumComprobanteDao numcomprobanteDao;

    public NumComprobanteLogicaImpl() {
    }

    public void setNumcomprobanteDao(NumComprobanteDao numDao) {
        this.numcomprobanteDao = numDao;
    }

    @Override
    public void insertar(Numcomprobante numDao) {
        numcomprobanteDao.insertar(numDao);
    }

    @Override
    public void actualizar(Numcomprobante numDao) {
        numcomprobanteDao.actualizar(numDao);
    }

    @Override
    public void eliminar(Numcomprobante numDao) {
        numcomprobanteDao.eliminar(numDao);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Numcomprobante> buscarConsumo(String cliente) {
        return numcomprobanteDao.buscarConsumo(cliente);
    }

    @Override
    @Transactional
    public Numcomprobante buscarPorCodigo(int tipo) {
        return numcomprobanteDao.buscarPorCodigo(tipo);
    }
}
