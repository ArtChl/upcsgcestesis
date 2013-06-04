// Decompiled by DJ v3.8.8.85 Copyright 2005 Atanas Neshkov  Date: 22/05/2013 11:45:26 a.m.
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   JfPrinterClose.java

package Zeus.core.printers;

import Zeus.core.Wins.*;
import Zeus.core.ui.components.JZeusLabel;
import java.awt.Dimension;
import java.awt.Rectangle;

// Referenced classes of package Zeus.core.printers:
//            JwPrinterClose

public class JfPrinterClose extends JBaseForm
{

    public JfPrinterClose()
        throws Exception
    {
        lnodo = new JZeusLabel();
        nodo = new JZeusEdit();
        lprinter_id = new JZeusLabel();
        printer_id = new JZeusEdit();
        ltipo_cierre = new JZeusLabel();
        tipo_cierre = new JZeusEdit();
        lid = new JZeusLabel();
        id = new JZeusEdit();
        lfecha_hasta = new JZeusLabel();
        fecha_hasta = new JZeusEdit();
        lhora_hasta = new JZeusLabel();
        hora_hasta = new JZeusEdit();
        try
        {
            jbInit();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public JwPrinterClose GetWin()
    {
        return (JwPrinterClose)GetBaseWin();
    }

    protected void jbInit()
        throws Exception
    {
        setLayout(null);
        setSize(new Dimension(357, 242));
        lnodo.setText("Nodo");
        lnodo.setBounds(new Rectangle(40, 44, 123, 22));
        nodo.setBounds(new Rectangle(168, 44, 143, 22));
        add(lnodo, null);
        add(nodo, null);
        lprinter_id.setText("Printer id");
        lprinter_id.setBounds(new Rectangle(40, 71, 123, 22));
        printer_id.setBounds(new Rectangle(168, 71, 143, 22));
        add(lprinter_id, null);
        add(printer_id, null);
        ltipo_cierre.setText("Tipo cierre");
        ltipo_cierre.setBounds(new Rectangle(40, 98, 123, 22));
        tipo_cierre.setBounds(new Rectangle(168, 98, 143, 22));
        add(ltipo_cierre, null);
        add(tipo_cierre, null);
        lid.setText("Id");
        lid.setBounds(new Rectangle(40, 125, 123, 22));
        id.setBounds(new Rectangle(168, 125, 143, 22));
        add(lid, null);
        add(id, null);
        lfecha_hasta.setText("Fecha hasta");
        lfecha_hasta.setBounds(new Rectangle(40, 152, 123, 22));
        fecha_hasta.setBounds(new Rectangle(168, 152, 143, 22));
        add(lfecha_hasta, null);
        add(fecha_hasta, null);
        lhora_hasta.setText("Hora hasta");
        lhora_hasta.setBounds(new Rectangle(40, 179, 123, 22));
        hora_hasta.setBounds(new Rectangle(168, 179, 143, 22));
        add(lhora_hasta, null);
        add(hora_hasta, null);
    }

    public void InicializarPanel(JWin jwin)
        throws Exception
    {
        AddItem(nodo, "CHAR", "REQ", "nodo");
        AddItem(printer_id, "UINT", "REQ", "printer_id");
        AddItem(tipo_cierre, "CHAR", "REQ", "tipo_cierre");
        AddItem(id, "UINT", "REQ", "id");
        AddItem(fecha_hasta, "DATE", "REQ", "fecha_hasta");
        AddItem(hora_hasta, "CHAR", "REQ", "hora_hasta");
    }

    JZeusLabel lnodo;
    JZeusEdit nodo;
    JZeusLabel lprinter_id;
    JZeusEdit printer_id;
    JZeusLabel ltipo_cierre;
    JZeusEdit tipo_cierre;
    JZeusLabel lid;
    JZeusEdit id;
    JZeusLabel lfecha_hasta;
    JZeusEdit fecha_hasta;
    JZeusLabel lhora_hasta;
    JZeusEdit hora_hasta;
}