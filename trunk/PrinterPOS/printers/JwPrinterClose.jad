// Decompiled by DJ v3.8.8.85 Copyright 2005 Atanas Neshkov  Date: 22/05/2013 11:46:16 a.m.
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   JwPrinterClose.java

package Zeus.core.printers;

import Zeus.core.Database.JBD;
import Zeus.core.Wins.JWin;

// Referenced classes of package Zeus.core.printers:
//            JbPrinterClose

public class JwPrinterClose extends JWin
{

    public JwPrinterClose()
        throws Exception
    {
    }

    public JBD ObtenerDato()
        throws Exception
    {
        return new JbPrinterClose();
    }

    public int GetNroIcono()
        throws Exception
    {
        return 205;
    }

    public String GetTitle()
        throws Exception
    {
        return "Cierre Impresora ";
    }

    public Class GetFormBase()
        throws Exception
    {
        return Zeus.core.printers.JfPrinterClose.class;
    }

    public String GetItemClave()
        throws Exception
    {
        return "id";
    }

    public String GetItemDescrip()
    {
        return "id";
    }

    public void OnGenerarAcciones()
        throws Exception
    {
        SetAccionConsultar(1, "Consultar");
    }

    public JbPrinterClose GetcDato()
        throws Exception
    {
        return (JbPrinterClose)GetDato();
    }
}