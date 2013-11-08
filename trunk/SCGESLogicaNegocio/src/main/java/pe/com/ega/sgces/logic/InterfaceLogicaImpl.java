/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.com.ega.sgces.dao.InterfaceDao;
import pe.com.ega.sgces.model.InterfaceConfig;

/**
 *
 * @author Flopez
 */
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class InterfaceLogicaImpl implements InterfaceLogica {

    private InterfaceDao interfaceDao;

    public InterfaceLogicaImpl() {
        
    }

    @Override
    public void setInterfaceDao(InterfaceDao interfaceDao) {
        this.interfaceDao = interfaceDao;

    }

    @Override
    public void insertar(InterfaceConfig turno) {
        this.interfaceDao.insertar(turno);
    }

    @Override
    public void actualizar(InterfaceConfig turno) {
        this.interfaceDao.actualizar(turno);
    }

    @Override
    @Transactional(readOnly = true)
    public InterfaceConfig buscarPorCodigo(int id) {
        return this.interfaceDao.buscarPorCodigo(id);
    }
}
