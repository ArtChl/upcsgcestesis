// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 09/01/2010 08:30:56 a.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   KProduct.java

package pos;


public class KProduct
{

    public KProduct()
    {
    }

    public static String getSIGESCode(String cemCode)
    {
        String result = null;
        switch(Integer.valueOf(cemCode).intValue())
        {
        case 1: // '\001'
            result = "01";
            break;

        case 2: // '\002'
            result = "02";
            break;

        case 3: // '\003'
            result = "03";
            break;

        case 4: // '\004'
            result = "04";
            break;

        case 5: // '\005'
            result = "06";
            break;

        case 6: // '\006'
            result = "05";
            break;

        case 7: // '\007'
            result = "07";
            break;

        case 8: // '\b'
            result = "08";
            break;
        }
        return result;
    }

    public static String getKallpaCode(String cemCode)
    {
        String result = null;
        switch(Integer.valueOf(cemCode).intValue())
        {
        case 1: // '\001'
            result = "01";
            break;

        case 2: // '\002'
            result = "02";
            break;

        case 3: // '\003'
            result = "03";
            break;

        case 4: // '\004'
            result = "04";
            break;

        case 5: // '\005'
            result = "06";
            break;

        case 6: // '\006'
            result = "05";
            break;

        case 7: // '\007'
            result = "07";
            break;

        case 8: // '\b'
            result = "08";
            break;
        }
        return result;
    }
}
