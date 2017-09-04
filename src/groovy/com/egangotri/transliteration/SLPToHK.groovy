package com.egangotri.transliteration;

import com.egangotri.util.Log
import groovy.util.logging.Slf4j
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class SLPToHK
{

    public static String transform(String s1)
        {
        
        String transformed = s1;
        //log.info("SLPToItrans: " + s1  );

        transformed = StringUtils.replacePattern(transformed,"N","ň");  //tmp placeholder, reversd below
        transformed = StringUtils.replacePattern(transformed,"Y","ŷ");  //tmp placeholder, reversd below
        transformed = StringUtils.replacePattern(transformed,"R","N");
        transformed = StringUtils.replacePattern(transformed,"f", "R");
        transformed = StringUtils.replacePattern(transformed,"F","RR");// same reason as above
        transformed = StringUtils.replacePattern(transformed,"x","IR");
        transformed = StringUtils.replacePattern(transformed,"X","IRR");

        
        
        /***NOTE 1 ***/
        /***Note 1 ***/
        
        transformed = StringUtils.replacePattern(transformed,"E","ai");
        transformed = StringUtils.replacePattern(transformed,"O","au");
        
        transformed = StringUtils.replacePattern(transformed,"K","kh");
        transformed = StringUtils.replacePattern(transformed,"G","gh");
        
        transformed = StringUtils.replacePattern(transformed,"C","ch");
        transformed = StringUtils.replacePattern(transformed,"J","jh");
        
        transformed = StringUtils.replacePattern(transformed,"T","th"); // watch out!!!!
                                                                    // must be above .replaceAll("w","T")
        transformed = StringUtils.replacePattern(transformed,"D","dh");// watch out!!!!
                                                                    // must be above .replaceAll("q","D")
        transformed = StringUtils.replacePattern(transformed,"w","T");
        transformed = StringUtils.replacePattern(transformed,"W","Th");
        transformed = StringUtils.replacePattern(transformed,"q","D");
        transformed = StringUtils.replacePattern(transformed,"Q","Dh");
                                                                        

        transformed = StringUtils.replacePattern(transformed,"P","ph");
        transformed = StringUtils.replacePattern(transformed,"B","bh");
        transformed = StringUtils.replacePattern(transformed,"S","Z");// temporary place holder
        transformed = StringUtils.replacePattern(transformed,"z","S");
        transformed = StringUtils.replacePattern(transformed,"Z","z");
        transformed = StringUtils.replacePattern(transformed,"'", ".a");    // avagraha
        
        transformed = StringUtils.replacePattern(transformed,"ň","G");
        transformed = StringUtils.replacePattern(transformed,"ŷ","J");
        
        //log.info("SLPToItrans: transformed" + s1 + " = " + transformed );
        return transformed; // return transformed;
        }

    }

