// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 09/01/2010 08:31:28 a.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   KEncrypter.java

package core;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.*;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class KEncrypter
{

    public KEncrypter(SecretKey key)
    {
        try
        {
            ecipher = Cipher.getInstance("DES");
            dcipher = Cipher.getInstance("DES");
            ecipher.init(1, key);
            dcipher.init(2, key);
        }
        catch(NoSuchPaddingException nosuchpaddingexception) { }
        catch(NoSuchAlgorithmException nosuchalgorithmexception) { }
        catch(InvalidKeyException invalidkeyexception) { }
    }

    public String encrypt(String str)
    {
        try
        {
            byte utf8[] = str.getBytes("UTF8");
            byte enc[] = ecipher.doFinal(utf8);
            return (new BASE64Encoder()).encode(enc);
        }
        catch(BadPaddingException badpaddingexception) { }
        catch(IllegalBlockSizeException illegalblocksizeexception) { }
        catch(Exception exception) { }
        return null;
    }

    public String decrypt(String str)
    {
        try
        {
            byte dec[] = (new BASE64Decoder()).decodeBuffer(str);
            byte utf8[] = dcipher.doFinal(dec);
            return new String(utf8, "UTF8");
        }
        catch(BadPaddingException badpaddingexception) { }
        catch(IllegalBlockSizeException illegalblocksizeexception) { }
        catch(Exception exception) { }
        return null;
    }

    private Cipher ecipher;
    private Cipher dcipher;
}
