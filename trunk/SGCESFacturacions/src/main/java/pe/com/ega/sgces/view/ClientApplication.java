package pe.com.ega.sgces.view;

import java.util.*;
import org.openswing.swing.mdi.client.*;
import org.openswing.swing.util.client.ClientSettings;
import org.openswing.swing.permissions.client.*;
import javax.swing.*;
import org.openswing.swing.internationalization.java.Language;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import org.openswing.swing.mdi.java.ApplicationFunction;
import org.openswing.swing.domains.java.Domain;
import org.openswing.swing.internationalization.java.XMLResourcesFactory;
import org.openswing.swing.tree.java.OpenSwingTreeNode;


/**
 * <p>Title: OpenSwing Demo</p>
 * <p>Description: Used to start application from main method: it creates an MDI Frame app
 * and uses Hibernate as persistent layer.</p>
 * <p>Copyright: Copyright (C) 2006 Mauro Carniel</p>
 * <p> </p>
 * @author Mauro Carniel
 * @version 1.0
 */
public class ClientApplication implements MDIController,LoginController {


  private DemoClientFacade clientFacade = null;
  private String username = null;

  public ClientApplication() {

    try {
      clientFacade = new DemoClientFacade();


      Hashtable domains = new Hashtable();
      Domain sexDomain = new Domain("SEX");
      sexDomain.addDomainPair("M","male");
      sexDomain.addDomainPair("F","female");
      domains.put(
        sexDomain.getDomainId(),
        sexDomain
      );

      Domain orderStateDomain = new Domain("COMBUSTIBLE");
        orderStateDomain.addDomainPair("GASOLINA 90","90");
        orderStateDomain.addDomainPair("GASOLINA 95","95");
        orderStateDomain.addDomainPair("GASOLINA 97","97");
        orderStateDomain.addDomainPair("DIESEL PRO+ ECO","DIESEL");
        orderStateDomain.addDomainPair("GLP","GLP");
        
        domains.put(
        orderStateDomain.getDomainId(),
        orderStateDomain
        );
        
        Domain orderStateDomain1 = new Domain("CLIENTE");
        orderStateDomain1.addDomainPair("MUNICIPALIDAD LA PERLA","MUNICIPALIDAD LA PERLA");
        orderStateDomain1.addDomainPair("MUNICIPALIDAD BELLAVISTA","MUNICIPALIDAD BELLAVISTA");
        orderStateDomain1.addDomainPair("TRANSPORTES ESMERALDA","TRANSPORTES ESMERALDA");
        orderStateDomain1.addDomainPair("MUNICIPALIDAD SAN MIGUEL","MUNICIPALIDAD SAN MIGUEL");
        
        domains.put(
        orderStateDomain1.getDomainId(),
        orderStateDomain1
        );
      Properties props = new Properties();

      props.setProperty("id","ID");
      props.setProperty("numero","Numero");
      props.setProperty("placa","Placa");
      props.setProperty("chofer","Chofer");
      props.setProperty("fecha","Fecha Desp");
      props.setProperty("producto","Producto");
      props.setProperty("galones","Galones");
      props.setProperty("estado","Estado Dep");
      
      
      Hashtable xmlFiles = new Hashtable();
      xmlFiles.put("EN","Resources_en.xml");
      xmlFiles.put("IT","Resources_it.xml");
      ClientSettings clientSettings = new ClientSettings(
          new XMLResourcesFactory(xmlFiles,true),
          domains
      );

      ClientSettings.BACKGROUND = "car1.jpg";
      ClientSettings.TREE_BACK = "treeback2.jpg";
      ClientSettings.VIEW_BACKGROUND_SEL_COLOR = true;
      ClientSettings.VIEW_MANDATORY_SYMBOL = true;

      LoginDialog d = new LoginDialog(null,false,this);
    }
    catch (Throwable ex) {
      ex.printStackTrace();
    }

  }


  /**
   * Method called after MDI creation.
   */
  public void afterMDIcreation(MDIFrame frame) {
    GenericStatusPanel userPanel = new GenericStatusPanel();
    userPanel.setColumns(12);
    MDIFrame.addStatusComponent(userPanel);
    userPanel.setText(username);
    MDIFrame.addStatusComponent(new Clock());

  }


  /**
   * @see JFrame getExtendedState method
   */
  public int getExtendedState() {
    return JFrame.MAXIMIZED_BOTH;
  }


  /**
   * @return client facade, invoked by the MDI Frame tree/menu
   */
  public ClientFacade getClientFacade() {
    return clientFacade;
  }


  /**
   * Method used to destroy application.
   */
  public void stopApplication() {
    System.exit(0);
  }


  /**
   * Defines if application functions must be viewed inside a tree panel of MDI Frame.
   * @return <code>true</code> if application functions must be viewed inside a tree panel of MDI Frame, <code>false</code> no tree is viewed
   */
  public boolean viewFunctionsInTreePanel() {
    return true;
  }


  /**
   * Defines if application functions must be viewed in the menubar of MDI Frame.
   * @return <code>true</code> if application functions must be viewed in the menubar of MDI Frame, <code>false</code> otherwise
   */
  public boolean viewFunctionsInMenuBar() {
    return true;
  }


  /**
   * @return <code>true</code> if the MDI frame must show a login menu in the menubar, <code>false</code> no login menu item will be added
   */
  public boolean viewLoginInMenuBar() {
    return true;
  }


  /**
   * @return application title
   */
  public String getMDIFrameTitle() {
    return "Vales de Consumo";
  }


  /**
   * @return text to view in the about dialog window
   */
  public String getAboutText() {
    return
        "This is an MDI Frame demo application\n"+
        "\n"+
        "Copyright: Copyright (C) 2013 Edwin Lopez\n"+
        "Author: Edwin Lopez";
  }


  /**
   * @return image name to view in the about dialog window
   */
  public String getAboutImage() {
    return "about.jpg";
  }


  /**
   * @param parentFrame parent frame
   * @return a dialog window to logon the application; the method can return null if viewLoginInMenuBar returns false
   */
  public JDialog viewLoginDialog(JFrame parentFrame) {
     JDialog d = new LoginDialog(parentFrame,true,this);
     return d;
  }



  /**
   * @return maximum number of failed login
   */
  public int getMaxAttempts() {
    return 3;
  }


  /**
   * Method called by MDI Frame to authenticate the user.
   * @param loginInfo login information, like username, password, ...
   * @return <code>true</code> if user is correcly authenticated, <code>false</code> otherwise
   */
  public boolean authenticateUser(Map loginInfo) throws Exception {
    if ("ADMIN".equalsIgnoreCase((String)loginInfo.get("username")) &&
        "ADMIN".equalsIgnoreCase((String)loginInfo.get("password")) ||
        "MAURO".equalsIgnoreCase((String)loginInfo.get("username")) &&
        "MAURO".equalsIgnoreCase((String)loginInfo.get("password")))
      return true;
    else
      return false;
  }




  public static void main(String[] argv) {
    new ClientApplication();
  }


  /**
   * Method called by LoginDialog to notify the sucessful login.
   * @param loginInfo login information, like username, password, ...
   */
  public void loginSuccessful(Map loginInfo) { 
   username = loginInfo.get("username").toString().toUpperCase();
   ClientSettings.getInstance().setLanguage("EN"); 
   MDIFrame mdi = new MDIFrame(this);
  }



  /**
   * @return <code>true</code> if the MDI frame must show a change language menu in the menubar, <code>false</code> no change language menu item will be added
   */
  public boolean viewChangeLanguageInMenuBar() {
    return true;
  }


  /**
   * @return list of languages supported by the application
   */
  public ArrayList getLanguages() {
    ArrayList list = new ArrayList();
    list.add(new Language("EN","English"));
    list.add(new Language("IT","Italiano"));
    return list;
  }



  /**
   * @return application functions (ApplicationFunction objects), organized as a tree
   */
  public DefaultTreeModel getApplicationFunctions() {
    DefaultMutableTreeNode root = new OpenSwingTreeNode();
    DefaultTreeModel model = new DefaultTreeModel(root);
    ApplicationFunction n1 = new ApplicationFunction("Mantenimiento",null);
    ApplicationFunction n2 = new ApplicationFunction("Operacion",null);
    ApplicationFunction n3 = new ApplicationFunction("Caja",null);
    ApplicationFunction n11 = new ApplicationFunction("Usuario","USUARIO","cliente.png","getUsuario");
    ApplicationFunction n21 = new ApplicationFunction("Emision Ticket","DESPACHO","car.png","getDespacho");
    ApplicationFunction n22 = new ApplicationFunction("Anulacion","ANULACION","Export16.gif","getAnular");
    ApplicationFunction n31 = new ApplicationFunction("Cierre","CIERRE","print16.gif","getCierre");
    ApplicationFunction n32 = new ApplicationFunction("Arqueo","ARQUEO","copy16.gif","getArqueo");
    ApplicationFunction n33 = new ApplicationFunction("Tirada Buzon","TIRADA","paste16.gif","getTirada");
    n1.add(n11);
    n2.add(n21);
    n2.add(n22);
    n3.add(n31);
    n3.add(n32);
    n3.add(n33);
    root.add(n1);
    root.add(n2);
    root.add(n3);

    return model;
  }

  /**
   * @return <code>true</code> if the MDI frame must show a panel in the bottom, containing last opened window icons, <code>false</code> no panel is showed
   */
  public boolean viewOpenedWindowIcons() {
    return true;
  }


  /**
   * @return <code>true</code> if the MDI frame must show the "File" menu in the menubar of the frame, <code>false</code> to hide it
   */
  public boolean viewFileMenu() {
    return true;
  }


}
