package pe.com.ega.sgces.view;


import org.openswing.swing.mdi.client.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.com.ega.sgces.logic.CierreLogica;
import pe.com.ega.sgces.logic.CierreLogicaImpl;
import pe.com.ega.sgces.logic.DepositoLogica;
import pe.com.ega.sgces.logic.DepositoLogicaImpl;
import pe.com.ega.sgces.logic.DespachoLogica;
import pe.com.ega.sgces.logic.DespachoLogicaImpl;
import pe.com.ega.sgces.logic.MovimientoLogica;
import pe.com.ega.sgces.logic.MovimientoLogicaImpl;
import pe.com.ega.sgces.logic.TransaccionLogica;
import pe.com.ega.sgces.logic.TransaccionLogicaImpl;
import pe.com.ega.sgces.logic.TurnoLogica;
import pe.com.ega.sgces.logic.TurnoLogicaImpl;



/**
 * <p>Title: OpenSwing Framework</p>
 * <p>Description: Client Facade, called by the MDI Tree.</p>
 * <p>Copyright: Copyright (C) 2006 Mauro Carniel</p>
 * <p> </p>
 * @author Mauro Carniel
 * @version 1.0
 */
public class DemoClientFacade implements ClientFacade {

  private MovimientoLogica movimientoLogica;
  private DepositoLogica depositoLogica;
  private DespachoLogica despachoLogica;
  private TurnoLogica turnoLogica;
  private TransaccionLogica transaccionLogica;
  private CierreLogica cierreLogica;

  public DemoClientFacade() {
                ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		this.movimientoLogica =  context.getBean("movimientoService",
				MovimientoLogicaImpl.class);
                this.depositoLogica =  context.getBean("depositoService",
				DepositoLogicaImpl.class);
                this.despachoLogica =  context.getBean("despachoService",
				DespachoLogicaImpl.class);
                this.turnoLogica =  context.getBean("turnoService",
				TurnoLogicaImpl.class);
                this.transaccionLogica =  context.getBean("transaccionService",
				TransaccionLogicaImpl.class);
                this.cierreLogica =  context.getBean("cierreService",
				CierreLogicaImpl.class);
  }
  
   public void getUsuario() {
   UsuarioFrame usuarioFrame = new UsuarioFrame();
   usuarioFrame.setVisible(true);

  }
   
   public void getDespacho() {
        DespachoFrame f = new DespachoFrame(despachoLogica,movimientoLogica,turnoLogica, transaccionLogica);
        f.setSize(528,202);
        f.setTitle("Despachos");
        MDIFrame.add(f);

  }
   
   public void getTirada() 
   {
        TiradaFrame f = new TiradaFrame(depositoLogica);
        f.setSize(210,233);
        f.setTitle("Tirada");
        MDIFrame.add(f);

  }

   public void getCierre() 
   {
        CierreFrame f = new CierreFrame(movimientoLogica, depositoLogica, despachoLogica, turnoLogica, cierreLogica);
        f.setSize(422,118);
        f.setTitle("Cierre Turno");
        MDIFrame.add(f);

  }
   
   public void getArqueo() 
   {
        ArqueoFrame f = new ArqueoFrame(movimientoLogica, depositoLogica, turnoLogica);
        f.setSize(293,107);
        f.setTitle("Arqueo");
        MDIFrame.add(f);

  }
   
    public void getAnular() 
   {
        ComprobanteFrame f = new ComprobanteFrame(turnoLogica, movimientoLogica, despachoLogica, transaccionLogica);
        f.setSize(528,202);
        f.setTitle("Anular Comprobantes");
        MDIFrame.add(f);

  }
   
   
   
}
