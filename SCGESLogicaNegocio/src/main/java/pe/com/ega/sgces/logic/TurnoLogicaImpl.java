/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.Date;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.dao.InterfaceDaoImpl;
import pe.com.ega.sgces.dao.TurnoDao;
import pe.com.ega.sgces.model.InterfaceConfig;
import pe.com.ega.sgces.model.Turno;

/**
 *
 * @author Flopez
 */
public class TurnoLogicaImpl implements TurnoLogica {

    private InterfaceLogica interfaceLogica;
    private SessionFactory session;
    private TurnoDao turnoDao;

    public TurnoLogicaImpl() {
        interfaceLogica = new InterfaceLogicaImpl();
        interfaceLogica.setInterfaceDao(new InterfaceDaoImpl());
    }

    @Override
    public void setSession(SessionFactory session) {
        this.session = session;
    }

    @Override
    public void setTurnoDao(TurnoDao turnoDao) {
        this.turnoDao = turnoDao;
    }

    @Override
    public void insertar(Turno turno) {
        session.getCurrentSession().beginTransaction();
        turnoDao.insertar(turno);
        session.getCurrentSession().getTransaction().commit();
        this.cem44();
    }

    @Override
    public void actualizar(Turno turno) {
        turno.setEstado("S");
        turno.setFechacierre(new Date());
        session.getCurrentSession().beginTransaction();
        turnoDao.actualizar(turno);
        session.getCurrentSession().getTransaction().commit();
    }

    @Override
    public void eliminar(Turno turno) {
        session.getCurrentSession().beginTransaction();
        turnoDao.eliminar(turno);
        session.getCurrentSession().getTransaction().commit();
    }

    @Override
    public Turno buscarPorCodigo(String estado) {
        return turnoDao.buscarPorCodigo(estado);
    }

    public final void cem44() {
        InterfaceConfig cierre = interfaceLogica.buscarPorCodigo(1);
        cierre.setCambioturno(1);
        cierre.setFechaTotalizadoresElectronicos(new Date());
        interfaceLogica.actualizar(cierre);
    }
}
