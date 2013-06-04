// Decompiled by DJ v3.8.8.85 Copyright 2005 Atanas Neshkov  Date: 22/05/2013 11:44:51 a.m.
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   JfPrinter.java

package Zeus.core.printers;

import Zeus.core.Conectividad.Client.Serial.JbSerialClient;
import Zeus.core.Wins.*;
import Zeus.core.ui.components.JZeusLabel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

// Referenced classes of package Zeus.core.printers:
//            JwPrinter, JbPrinter

public class JfPrinter extends JBaseForm
{

    public JfPrinter()
        throws Exception
    {
        nodo = new JZeusEdit();
        printer_id = new JZeusEdit();
        ltipo = new JZeusLabel();
        lbaudios = new JZeusLabel();
        baudios = new JComboBox();
        lNroCorriente = new JZeusLabel();
        NroRollo = new JZeusEdit();
        TieneRollo = new JCheckBox();
        Tipo = new JComboBox();
        Pais = new JZeusEdit();
        jLabel1 = new JZeusLabel();
        Descripcion = new JZeusEdit();
        Puerto = new JZeusEdit();
        lPuerto = new JZeusLabel();
        NroSerie = new JZeusEdit();
        jLabel2 = new JZeusLabel();
        jPanel1 = new JPanel();
        cierreInformeParticular = new JCheckBox();
        jLabel4 = new JZeusLabel();
        jLabel5 = new JZeusLabel();
        horaInicioFiscal = new JZeusEdit();
        fechaInicioFiscal = new JZeusCalendarEdit();
        jRadioSinCajon = new JRadioButton();
        jRadioSinSensor = new JRadioButton();
        jRadioSensorApertura = new JRadioButton();
        jRadioSensorCierre = new JRadioButton();
        jPanelCajon = new JPanel(null);
        CashVirtualGroup = new ButtonGroup();
        try
        {
            jbInit();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public JwPrinter GetWin()
    {
        return (JwPrinter)GetBaseWin();
    }

    protected void jbInit()
        throws Exception
    {
        setLayout(null);
        setSize(new Dimension(492, 264));
        nodo.setBounds(new Rectangle(168, 44, 143, 22));
        TieneRollo.setText("Tiene Rollo");
        TieneRollo.setBounds(new Rectangle(81, 94, 83, 25));
        TieneRollo.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent itemevent)
            {
                TieneRollo_itemStateChanged(itemevent);
            }

            
            {
                super();
            }
        });
        Tipo.setBounds(new Rectangle(81, 40, 203, 21));
        Pais.setText("jTextField1");
        Pais.setBounds(new Rectangle(229, 7, 63, 21));
        jLabel1.setHorizontalAlignment(4);
        jLabel1.setText("Descripci\363n");
        jLabel1.setBounds(new Rectangle(7, 13, 66, 21));
        Descripcion.setBounds(new Rectangle(81, 13, 378, 21));
        Puerto.setBounds(new Rectangle(357, 67, 102, 21));
        lPuerto.setHorizontalAlignment(4);
        lPuerto.setText("Puerto o IP");
        lPuerto.setBounds(new Rectangle(288, 67, 61, 21));
        NroSerie.setBounds(new Rectangle(81, 67, 203, 21));
        jLabel2.setHorizontalAlignment(4);
        jLabel2.setText("Nro Serie");
        jLabel2.setBounds(new Rectangle(13, 67, 59, 21));
        lbaudios.setHorizontalAlignment(4);
        ltipo.setHorizontalAlignment(4);
        lNroCorriente.setHorizontalAlignment(4);
        jPanel1.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(148, 145, 140)), " Impresora No Fiscal pero con Rollo Fiscal "));
        jPanel1.setDebugGraphicsOptions(0);
        jPanel1.setBounds(new Rectangle(12, 130, 257, 115));
        jPanel1.setLayout(null);
        cierreInformeParticular.setBounds(new Rectangle(14, 21, 235, 23));
        cierreInformeParticular.setText("Cierres X y Z solo de movimientos propios");
        jLabel4.setBounds(new Rectangle(14, 51, 116, 23));
        jLabel4.setText("Fecha de inicio fiscal");
        jLabel4.setVerifyInputWhenFocusTarget(true);
        jLabel4.setHorizontalAlignment(2);
        jLabel5.setHorizontalAlignment(2);
        jLabel5.setVerifyInputWhenFocusTarget(true);
        jLabel5.setText("Hora de inicio fiscal");
        jLabel5.setBounds(new Rectangle(14, 80, 116, 23));
        horaInicioFiscal.setBounds(new Rectangle(132, 80, 97, 23));
        fechaInicioFiscal.setBounds(new Rectangle(132, 51, 97, 23));
        jRadioSinCajon.setText("Sin Caj\363n");
        jRadioSinCajon.setBounds(new Rectangle(12, 21, 104, 23));
        jRadioSinSensor.setText("Cajon sin Sensor");
        jRadioSinSensor.setBounds(new Rectangle(12, 42, 140, 23));
        jRadioSensorApertura.setBounds(new Rectangle(12, 62, 181, 23));
        jRadioSensorApertura.setText("Caj\363n con Sensor de Apertura");
        jRadioSensorCierre.setBounds(new Rectangle(12, 83, 178, 23));
        jRadioSensorCierre.setText("Caj\363n con Sensor de Cierre");
        jPanelCajon.setBounds(new Rectangle(275, 130, 198, 115));
        jPanelCajon.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(148, 145, 140)), " Caj\363n de Dinero "));
        add(nodo, null);
        printer_id.setBounds(new Rectangle(168, 71, 143, 22));
        add(printer_id, null);
        ltipo.setText("Tipo");
        ltipo.setBounds(new Rectangle(31, 40, 41, 21));
        lbaudios.setText("Baudios");
        lbaudios.setBounds(new Rectangle(293, 40, 56, 21));
        baudios.setBounds(new Rectangle(356, 40, 103, 21));
        lNroCorriente.setText("N\372mero de Rollo");
        lNroCorriente.setBounds(new Rectangle(244, 94, 105, 22));
        NroRollo.setBounds(new Rectangle(357, 94, 102, 22));
        nodo.setVisible(false);
        printer_id.setVisible(false);
        add(Pais, null);
        add(Descripcion, null);
        add(jLabel1, null);
        jPanel1.add(cierreInformeParticular, null);
        jPanel1.add(jLabel4, null);
        jPanel1.add(jLabel5, null);
        jPanel1.add(horaInicioFiscal, null);
        jPanel1.add(fechaInicioFiscal, null);
        add(TieneRollo, null);
        add(NroRollo, null);
        add(lNroCorriente, null);
        add(baudios, null);
        add(Puerto, null);
        add(lbaudios, null);
        add(lPuerto, null);
        jPanelCajon.add(jRadioSinCajon, null);
        jPanelCajon.add(jRadioSinSensor, null);
        jPanelCajon.add(jRadioSensorApertura, null);
        jPanelCajon.add(jRadioSensorCierre, null);
        add(Tipo, null);
        add(ltipo, null);
        add(jLabel2, null);
        add(NroSerie, null);
        add(jPanel1, null);
        add(jPanelCajon, null);
        Pais.setVisible(false);
    }

    public void InicializarPanel(JWin jwin)
        throws Exception
    {
        AddItem(Pais, "CHAR", "REQ", "pais");
        AddItem(nodo, "CHAR", "REQ", "nodo");
        AddItem(printer_id, "UINT", "OPT", "printer_id");
        AddItem(Descripcion, "CHAR", "REQ", "descripcion");
        AddItem(Tipo, "CHAR", "REQ", "tipo", JWins.CreateVirtualWins(JbPrinter.getTipoImpresoras()));
        AddItem(baudios, "UINT", "OPT", "baudios", JWins.CreateVirtualWins(JbSerialClient.getBaudRates()));
        AddItem(Puerto, "CHAR", "OPT", "puerto");
        AddItem(TieneRollo, "CHAR", "REQ", "tiene_rollo", "S", "N");
        AddItem(NroRollo, "UINT", "OPT", "nro_rollo");
        AddItem(NroSerie, "CHAR", "OPT", "nro_serie");
        CashVirtualGroup.add(jRadioSinCajon);
        CashVirtualGroup.add(jRadioSinSensor);
        CashVirtualGroup.add(jRadioSensorApertura);
        CashVirtualGroup.add(jRadioSensorCierre);
        JFormSwingRadio jformswingradio = AddItem(CashVirtualGroup, "CHAR", "REQ", "cash_drawer");
        jformswingradio.AddValor(jRadioSinCajon.getText(), "N");
        jformswingradio.AddValor(jRadioSinSensor.getText(), "S");
        jformswingradio.AddValor(jRadioSensorApertura.getText(), "A");
        jformswingradio.AddValor(jRadioSensorCierre.getText(), "C");
        AddItem(cierreInformeParticular, "CHAR", "OPT", "cierre_informe_particular", "S", "N");
        AddItem(fechaInicioFiscal, "CHAR", "OPT", "fecha_inicio_fiscal");
        AddItem(horaInicioFiscal, "CHAR", "OPT", "hora_inicio_fiscal");
    }

    public void OnShow()
        throws Exception
    {
        checkControls();
    }

    void TieneRollo_itemStateChanged(ItemEvent itemevent)
    {
        try
        {
            checkControls();
        }
        catch(Exception exception) { }
    }

    public void checkControls()
        throws Exception
    {
        boolean flag = GetControles().ControlByName("tiene_rollo").GetValor().equals("S");
        lNroCorriente.setVisible(flag);
        NroRollo.setVisible(flag);
    }

    JZeusEdit nodo;
    JZeusEdit printer_id;
    JZeusLabel ltipo;
    JZeusLabel lbaudios;
    JComboBox baudios;
    JZeusLabel lNroCorriente;
    JZeusEdit NroRollo;
    private JCheckBox TieneRollo;
    private JComboBox Tipo;
    private JZeusEdit Pais;
    private JZeusLabel jLabel1;
    private JZeusEdit Descripcion;
    private JZeusEdit Puerto;
    private JZeusLabel lPuerto;
    private JZeusEdit NroSerie;
    private JZeusLabel jLabel2;
    JPanel jPanel1;
    JCheckBox cierreInformeParticular;
    JZeusLabel jLabel4;
    JZeusLabel jLabel5;
    JZeusEdit horaInicioFiscal;
    JZeusCalendarEdit fechaInicioFiscal;
    JRadioButton jRadioSinCajon;
    JRadioButton jRadioSinSensor;
    JRadioButton jRadioSensorApertura;
    JRadioButton jRadioSensorCierre;
    JPanel jPanelCajon;
    ButtonGroup CashVirtualGroup;
}