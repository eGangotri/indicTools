package com.egangotri.monierWilliams.util

import com.egangotri.util.Log
import org.apache.commons.lang3.StringUtils

import java.io.UnsupportedEncodingException
import java.text.NumberFormat

public class Util
{
    public static String toUTF8(String isoString)
    /**
     * Convert ISO8859-1 format string (which is the default sent by IE
     * to the UTF-8 format that the database is in.
     */
    {
     String utf8String = ""
     if (StringUtils.isNotBlank(isoString))
     {
      try
      {
       byte[] stringBytesISO = isoString.getBytes("ISO-8859-1")
       utf8String = new String(stringBytesISO, "UTF-8")
      }
      catch(UnsupportedEncodingException e)
      {
       // As we can't translate just send back the best guess.
       Log.info("UnsupportedEncodingException is: " + e.getMessage())
       utf8String = isoString
      }
     }
     else
     {
      utf8String = isoString
     }
     return utf8String
    }
    
    public static String getFilePath(String fileName)
    {
        return StringUtils.isNotBlank(fileName) ? "src//txt//" + fileName + ".txt" : ""
    }
    
    public static String getXMLFilePath(String xmlFileName)
    {
        return StringUtils.isNotBlank(xmlFileName) ? "src//xml//" + xmlFileName + ".xml" : ""
    }
    
    public static String getSourceURL(String fileName)
    {
        return StringUtils.isNotBlank(fileName) ? "http://students.washington.edu/prem/mw/" + fileName + ".html" : ""
    }

    public static void getTimeDiff(long startTime, long endTime)
    {
        long diff = (endTime - startTime) / (1000 * 1000)
        NumberFormat format = NumberFormat.getInstance()
        format.setMaximumFractionDigits(2)
        Log.info("Time Taken : " + (diff > 60000 ? format.format((double)diff/60000.0) + " mins" : format.format((double)diff/1000.0) + " secs"))
    }
}
