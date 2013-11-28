/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.com.ega.sgces.dao.ValeDao;
import pe.com.ega.sgces.model.Vale;

/**
 *
 * @author FLOPEZ
 */
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class ValeLogicaImpl implements ValeLogica {

    private ValeDao valeDao;

    public ValeLogicaImpl() {
    }

    @Override
    public void setValeDao(ValeDao valeDao) {
        this.valeDao = valeDao;
    }

    @Override
    public void insertar(Vale usuario) {
        valeDao.insertar(usuario);
    }

    @Override
    public void actualizar(Vale usuario) {
        valeDao.actualizar(usuario);
    }

    @Override
    public void eliminar(Vale usuario) {
        valeDao.eliminar(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Vale buscarPorCodigo(Integer id) {
        return valeDao.buscarPorCodigo(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vale> buscarTodos(String cliente) {
        return valeDao.buscarTodos(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vale> buscarConsumo(String cliente) {
        return valeDao.buscarConsumo(cliente);
    }

    @Override
    public Vale buscarPorNumero(String numero) {
        return valeDao.buscarPorNumero(numero);
    }
}
