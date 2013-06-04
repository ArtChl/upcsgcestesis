// Decompiled by DJ v3.8.8.85 Copyright 2005 Atanas Neshkov  Date: 22/05/2013 11:46:08 a.m.
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   JwPrinter.java

package Zeus.core.printers;

import Zeus.core.Database.JBD;
import Zeus.core.Database.JEnlace;
import Zeus.core.Wins.*;

// Referenced classes of package Zeus.core.printers:
//            JbPrinter, JwPrinterCloses

public class JwPrinter extends JWin
{

    public JwPrinter()
        throws Exception
    {
    }

    public JBD ObtenerDato()
        throws Exception
    {
        return new JbPrinter();
    }

    public int GetNroIcono()
        throws Exception
    {
        return 5;
    }

    public String GetTitle()
        throws Exception
    {
        return "Impresora";
    }

    public Class GetFormBase()
        throws Exception
    {
        return Zeus.core.printers.JfPrinter.class;
    }

    public String GetItemClave()
        throws Exception
    {
        return "printer_id";
    }

    public String GetItemDescrip()
    {
        return "descr_printer";
    }

    public void OnGenerarAcciones()
        throws Exception
    {
        SetAccionConsultar(1, "Consultar");
        SetAccionModificar(2, "Modificar");
        SetAccionEliminar(3, "Eliminar");
        AddAction(5, "Cierres Fiscales", new JAct() {

            public JBaseWin GetBWin()
                throws Exception
            {
                return ObtenerCodigosBarra();
            }

            
                throws Exception
            {
                super();
            }
        }, 205, true, true, true, "Group");
    }

    public JbPrinter GetcDato()
        throws Exception
    {
        return (JbPrinter)GetDato();
    }

    public JWins ObtenerCodigosBarra()
        throws Exception
    {
        JEnlace jenlace = new JEnlace();
        jenlace.AddValor("printer_id", "printer_id", GetcDato().getPrinterId());
        JwPrinterCloses jwprintercloses = new JwPrinterCloses();
        jwprintercloses.SetEnlazado(jenlace);
        return jwprintercloses;
    }
}