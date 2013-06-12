// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 09/01/2010 08:30:34 a.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   KLicense.java

package pos;

import core.*;
import java.io.*;
import java.util.Properties;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class KLicense
{

    public KLicense()
    {
    }

    public static void verify()
        throws Exception
    {
        Properties file = new Properties();
        try
        {
            file.load(new FileInputStream("C:\\WINDOWS\\CEM44\\Korken\\Korken.ini"));
            client = file.getProperty("CLIENT");
            license = file.getProperty("LICENSE");
            developer = file.getProperty("DEVELOPER");
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
        String address = (new KMAC()).getMacAddress();
        String decrypted = null;
        try
        {
            javax.crypto.SecretKey key = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec((developer + client).getBytes()));
            KEncrypter encrypter = new KEncrypter(key);
            decrypted = encrypter.decrypt(license);
        }
        catch(Exception e)
        {
            throw new Exception("ERROR|");
        }
        if(!address.equalsIgnoreCase(decrypted))
        {
            throw new Exception("ERROR^");
        } else
        {
            KLogManager.logDebug("Welcome " + client + "! This interface is powered by " + developer + " (Imptec)");
            return;
        }
    }

    private static String client = null;
    private static String license = null;
    private static String developer = null;

}
