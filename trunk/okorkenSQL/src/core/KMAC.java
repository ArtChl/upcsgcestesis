// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 09/01/2010 08:31:44 a.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   KMAC.java

package core;

import java.io.*;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package core:
//            KLogManager

public class KMAC
{

    public KMAC()
        throws Exception
    {
        platformLanguage = null;
        Properties file = new Properties();
        try
        {
            file.load(new FileInputStream("C:\\WINDOWS\\CEM44\\Korken\\Korken.ini"));
            platformLanguage = file.getProperty("PLATFORM_LANGUAGE");
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
            KLogManager.logDebug("Error when trying to get ini file. " + e.getMessage());
            throw new Exception("Error when trying to load ini file.");
        }
        catch(IOException e)
        {
            e.printStackTrace();
            KLogManager.logDebug("Error when trying to load ini file. " + e.getMessage());
            throw new Exception("Error when trying to load ini file.");
        }
    }

    public String getMacAddress()
        throws Exception
    {
        String macAddress = null;
        String command = "ipconfig /all";
        Process pid = Runtime.getRuntime().exec(command);
        BufferedReader in = new BufferedReader(new InputStreamReader(pid.getInputStream()));
        do
        {
            String line = in.readLine();
            System.out.println(line);
            if(line == null)
                break;
            Pattern p = null;
            if(platformLanguage.equalsIgnoreCase("EN"))
                p = Pattern.compile(".*Physical Address.*: (.*)");
            else
            if(platformLanguage.equalsIgnoreCase("ES"))
                p = Pattern.compile(".*Direcci\363n f\355sica.*: (.*)");
            Matcher m = p.matcher(line);
            if(!m.matches())
                continue;
            macAddress = m.group(1);
            break;
        } while(true);
        in.close();
        if(macAddress == null)
            throw new Exception("ERROR!");
        else
            return macAddress;
    }

    private String platformLanguage;
}
