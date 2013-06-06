package pe.com.ega.sgces.view;


import org.openswing.swing.mdi.client.*;



/**
 * <p>Title: OpenSwing Framework</p>
 * <p>Description: Client Facade, called by the MDI Tree.</p>
 * <p>Copyright: Copyright (C) 2006 Mauro Carniel</p>
 * <p> </p>
 * @author Mauro Carniel
 * @version 1.0
 */
public class DemoClientFacade implements ClientFacade {

  //private SessionFactory sessions = null;

  public DemoClientFacade() {
   // this.sessions = sessions;
  }
  
   public void getUsuario() {
   UsuarioFrame usuarioFrame = new UsuarioFrame();
   usuarioFrame.setVisible(true);

  }
   
   public void getDespacho() {
        DespachoFrame f = new DespachoFrame();
        f.setSize(528,202);
        f.setTitle("Despachos");
        MDIFrame.add(f);
       
       //DespachoFrame despachoFrame = new DespachoFrame();
   //despachoFrame.setVisible(true);
      // OpcionFrame opcionFrame=new OpcionFrame("113");
       //opcionFrame.setVisible(true);

  }

}
