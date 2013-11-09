/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.Date;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.com.ega.sgces.dao.TurnoDao;
import pe.com.ega.sgces.model.InterfaceConfig;
import pe.com.ega.sgces.model.Turno;

/**
 *
 * @author Flopez
 */
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class TurnoLogicaImpl implements TurnoLogica {

    private InterfaceLogica interfaceLogica;
    private TurnoDao turnoDao;

    public TurnoLogicaImpl() {

    }

    @Override
    public void setTurnoDao(TurnoDao turnoDao) {
        this.turnoDao = turnoDao;
    }
 
    public void setInterfaceLogica(InterfaceLogica interfaceLogica) {
        this.interfaceLogica = interfaceLogica;
    }
        
    @Override
    public void insertar(Turno turno) {
        turnoDao.insertar(turno);
        this.enviarComandoCierreCem44();
    }

    @Override
    public void actualizar(Turno turno) {
        turnoDao.actualizar(turno);
    }

    @Override
    public void eliminar(Turno turno) {
        turnoDao.eliminar(turno);
    }

    @Override
    @Transactional(readOnly = false)
    public Turno buscarPorCodigo(String estado) {
        return turnoDao.buscarPorCodigo(estado);
    }

    private void enviarComandoCierreCem44() {
        InterfaceConfig cierre = interfaceLogica.buscarPorCodigo(1);
        cierre.setCambioturno(1);
        cierre.setFechaTotalizadoresElectronicos(new Date());
        interfaceLogica.actualizar(cierre);
    }
}
