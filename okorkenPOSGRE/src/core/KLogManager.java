// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 09/01/2010 08:31:36 a.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   KLogManager.java

package core;

import core.factory.KDataFormatter;
import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class KLogManager
{

    public KLogManager()
    {
    }

    public static KLogManager getInstance()
    {
        KLogManager log = null;
        try
        {
            log = new KLogManager();
            log.file = new File("C:/WINDOWS/CEM44/Korken/Log.txt");
        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return log;
    }

    public static void logDebug(String line)
    {
        try
        {
            Calendar cal = new GregorianCalendar();
            String year = KDataFormatter.justifyStrings("", String.valueOf(cal.get(1)), 4, '0');
            String month = KDataFormatter.justifyStrings("", String.valueOf(cal.get(2) + 1), 2, '0');
            String day = KDataFormatter.justifyStrings("", String.valueOf(cal.get(5)), 2, '0');
            clearOldLogs(year + month);
            String hour = KDataFormatter.justifyStrings("", String.valueOf(cal.get(11)), 2, '0');
            String minutes = KDataFormatter.justifyStrings("", String.valueOf(cal.get(12)), 2, '0');
            String seconds = KDataFormatter.justifyStrings("", String.valueOf(cal.get(13)), 2, '0');
            BufferedWriter out = new BufferedWriter(new FileWriter("C:/WINDOWS/CEM44/Korken/KorkenLog." + year + month + day + ".txt", true));
            out.write(year + "/" + month + "/" + day + " " + hour + ":" + minutes + ":" + seconds + " - " + line + "\r");
            out.newLine();
            out.close();
            System.out.println(line);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void clearOldLogs(String yearMonth)
    {
        try
        {
            File file = new File("C:/WINDOWS/CEM44/Korken/");
            File files[] = file.listFiles();
            for(int i = 0; i < files.length; i++)
            {
                String name = files[i].getName();
                if(name.length() == 22)
                {
                    String actualYearMonth = name.substring(10, 16);
                    if(!actualYearMonth.equals(yearMonth))
                    {
                        System.out.println("Deleting " + name);
                        if(!files[i].delete())
                            System.out.println(name + " could not be deleted.");
                    }
                }
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    File file;
}
