// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 09/01/2010 08:31:55 a.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   KDataFormatter.java

package Util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;


public class KDataFormatter
{

    public KDataFormatter()
    {
    }

    public static String formatNull(Integer numero)
    {
        String array[] = new String[numero]; 
        String result = null;
        for (int i = 0; i < numero; ++i) {
            array[i]=";";
            
        }  
        StringBuffer cadena = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
            cadena =cadena.append(array[i]);
            
        }  
        result=cadena.toString();
        return result;
    }
    
    public static String formatActual()
    {
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 
        Date date = new Date(); 
        String dateString = formatter.format(date);
        return dateString;
    }
    
    public static String formatDateForSQL(String date)
    {
        String result = null;
        result = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
        return result;
    }

    public static String formatDateForSQLANSI(String date)
    {
        String result = null;
        result = date.substring(0, 4) + date.substring(5, 7) + date.substring(8, 10);
        return result;
    }

    public static String formatDateForSQLGyN(String date)
    {
        String result = null;
        result = date.substring(6, 8) + "-" + date.substring(4, 6) + "-" + date.substring(0, 4);
        return result;
    }

    public static String formatDateForSQLTime(String date)
    {
        String result = null;
        result = date.substring(8, 10) + "/" + date.substring(5, 7) + "/" + date.substring(0, 4);
        return result;
    }

    public static String formatDateForSQLGyN2(String s)
    {
        String s1 = null;
        s1 = s.substring(8, 10) + s.substring(4, 8) + s.substring(0, 4);
        return s1;
    }

    public static String formatDateForSQLKallpa(String date)
    {
        String result = null;
        result = date.substring(8, 10) + "/" + date.substring(5, 7) + "/" + date.substring(0, 4)+ " "+date.substring(11, 13)+":"+date.substring(14, 16)+":"+date.substring(17, 19);
        return result;
    }

    public static String formatCode(String date)
    {
        String result = null;
        result = date.substring(8, 10) + date.substring(5, 7) + date.substring(2, 4);
        return result;
    }
    
      public static String formatVale(int date)
    {
     
        Formatter fmt = new Formatter();
        fmt.format("%07d",date);
        return String.valueOf(fmt);
 
    }
      
        public static String formatSite(String date)
    {
     
        String result = null;
        result = date.substring(1, 3);
        return result;
 
    }
    public static String formatTimeForSQL(String time)
    {
        String result = null;
        String ampm = "AM";
        int hour = Integer.valueOf(time.substring(0, 2)).intValue();
        if(hour == 12)
            ampm = "PM";
        if(hour > 12)
        {
            hour -= 12;
            ampm = "PM";
        }
        result = hour + ":" + time.substring(2, 4) + ":" + time.substring(4, 6) + " " + ampm;
        return result;
    }

    public static String formatTimeForDBFTime(String time)
    {
        String result = null;
        result = time.substring(0, 2) + time.substring(2, 4) + time.substring(4, 6);
        return result;
    }

      public static String formatCodeObra(String time)
    {
        String result = null;
        result = time.substring(4, 8);
        return result;
    }

        public static String formatCodeCEQ(String time)
    {
        String result = null;
        result = time.substring(9, 19);
        return result;
    }

        public static String formatCodeMobra(String time)
    {
        String result = null;
        result = time.substring(5, 9);
        return result;
    }

    public static String formatTurno(String date)
    {
    Date timeDate = new Date();
    if(date.length()==8)
    {
    String turno=date.substring(6,8);
    String result=null;
    String doce=date.substring(0,2);
    result = date.substring(0, 5)+":00";
    String[] splitStrings = result.split(":");
        if(turno.equals("AM"))
        {
            if(doce.equals("12")){
                timeDate.setHours(Integer.parseInt(splitStrings[0])-12);
                timeDate.setMinutes(Integer.parseInt(splitStrings[1]));
                timeDate.setSeconds(Integer.parseInt(splitStrings[2]));
           }else{
                timeDate.setHours(Integer.parseInt(splitStrings[0]));
                timeDate.setMinutes(Integer.parseInt(splitStrings[1]));
                timeDate.setSeconds(Integer.parseInt(splitStrings[2]));
           }
        }else
        {
           if(doce.equals("12")){
                timeDate.setHours(Integer.parseInt(splitStrings[0]));
                timeDate.setMinutes(Integer.parseInt(splitStrings[1]));
                timeDate.setSeconds(Integer.parseInt(splitStrings[2]));
           }else{
                timeDate.setHours(Integer.parseInt(splitStrings[0])+12);
                timeDate.setMinutes(Integer.parseInt(splitStrings[1]));
                timeDate.setSeconds(Integer.parseInt(splitStrings[2]));
           }
        }

        if((timeDate.getHours()>=7) && (timeDate.getHours()<18)) result="1";
        if((timeDate.getHours()>=18 && timeDate.getHours()<=23) || (timeDate.getHours()>=0 && timeDate.getHours()<4)) result="2";
        if((timeDate.getHours()>=4) && (timeDate.getHours()<7)) result="3";
        return result;
    }else{
    date="0"+date;
    String turno=date.substring(5,7);
    String result=null;
    String doce=date.substring(0,2);
    result = date.substring(0, 5)+":00";
    String[] splitStrings = result.split(":");
        if(turno.equals("AM"))
        {
            if(doce.equals("12")){
                timeDate.setHours(Integer.parseInt(splitStrings[0])-12);
                timeDate.setMinutes(Integer.parseInt(splitStrings[1]));
                timeDate.setSeconds(Integer.parseInt(splitStrings[2]));
           }else{
                timeDate.setHours(Integer.parseInt(splitStrings[0]));
                timeDate.setMinutes(Integer.parseInt(splitStrings[1]));
                timeDate.setSeconds(Integer.parseInt(splitStrings[2]));
           }
        }else
        {
           if(doce.equals("12")){
                timeDate.setHours(Integer.parseInt(splitStrings[0]));
                timeDate.setMinutes(Integer.parseInt(splitStrings[1]));
                timeDate.setSeconds(Integer.parseInt(splitStrings[2]));
           }else{
                timeDate.setHours(Integer.parseInt(splitStrings[0])+12);
                timeDate.setMinutes(Integer.parseInt(splitStrings[1]));
                timeDate.setSeconds(Integer.parseInt(splitStrings[2]));
           }
        }

        if((timeDate.getHours()>=7) && (timeDate.getHours()<18)) result="1";
        if((timeDate.getHours()>=18 && timeDate.getHours()<=23) || (timeDate.getHours()>=0 && timeDate.getHours()<4)) result="2";
        if((timeDate.getHours()>=4) && (timeDate.getHours()<7)) result="3";
        return result;
    }
    }

    public static double redondear(double numero, int decimales)
    {
        return (double)Math.round(numero * Math.pow(10D, decimales)) / Math.pow(10D, decimales);
    }

    public static String justifyStrings(String leftString, String rightString, int totalLen, char refill)
    {
        if(leftString == null)
            leftString = "";
        if(rightString == null)
            rightString = "";
        int leftLen = leftString.length();
        int rightLen = rightString.length();
        int bothLen = leftLen + rightLen;
        if(bothLen > totalLen)
            return leftString.concat(rightString).substring(0, totalLen);
        if(bothLen == totalLen)
            return leftString.concat(rightString);
        int refillLen = totalLen - bothLen;
        char resultingArray[] = new char[totalLen];
        if(leftLen > 0 && rightLen > 0)
        {
            leftString.getChars(0, leftLen, resultingArray, 0);
            int i;
            for(i = 0; i < refillLen; i++)
                resultingArray[leftLen + i] = refill;

            rightString.getChars(0, rightLen, resultingArray, leftLen + i);
            return new String(resultingArray);
        }
        if(leftLen > 0)
        {
            leftString.getChars(0, leftLen, resultingArray, 0);
            for(int i = 0; i < refillLen; i++)
                resultingArray[leftLen + i] = refill;

            return new String(resultingArray);
        }
        if(rightLen > 0)
        {
            rightString.getChars(0, rightLen, resultingArray, totalLen - rightLen);
            for(int i = 0; i < refillLen; i++)
                resultingArray[i] = refill;

            return new String(resultingArray);
        }
        for(int i = 0; i < totalLen; i++)
            resultingArray[i] = refill;

        return new String(resultingArray);
    }
}
