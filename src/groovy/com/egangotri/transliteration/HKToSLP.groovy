package com.egangotri.transliteration

import org.apache.commons.lang3.StringUtils;

public class HKToSLP
{

    public static String transform(String s1)
    {
        String transformed = s1;
        transformed = StringUtils.replacePattern(transformed,"ai", "E");
        transformed = StringUtils.replacePattern(transformed,"au", "O");

        transformed = StringUtils.replacePattern(transformed,"IRR", "X");
        transformed = StringUtils.replacePattern(transformed,"IR", "x");
        transformed = StringUtils.replacePattern(transformed,"RR", "F");
        transformed = StringUtils.replacePattern(transformed,"R", "f");
        

        transformed = StringUtils.replacePattern(transformed,"N", "R");
        transformed = StringUtils.replacePattern(transformed,"G", "N");
        transformed = StringUtils.replacePattern(transformed,"J", "Y"); 
        
        transformed = StringUtils.replacePattern(transformed,"kh", "K");
        transformed = StringUtils.replacePattern(transformed,"gh", "G");
        
        transformed = StringUtils.replacePattern(transformed,"ch", "C");
        transformed = StringUtils.replacePattern(transformed,"jh", "J");
        

        transformed = StringUtils.replacePattern(transformed,"Th", "W");  
        transformed = StringUtils.replacePattern(transformed,"T", "w");    
        transformed = StringUtils.replacePattern(transformed,"Dh", "Q");  
        transformed = StringUtils.replacePattern(transformed,"D", "q");
        

        transformed = StringUtils.replacePattern(transformed,"th", "T");
        transformed = StringUtils.replacePattern(transformed,"dh", "D");

        transformed = StringUtils.replacePattern(transformed,"ph", "P");
        transformed = StringUtils.replacePattern(transformed,"bh", "B");
        

        transformed = StringUtils.replacePattern(transformed,"z", "@@"); //'@@' is a temporary holder.
        transformed = StringUtils.replacePattern(transformed,"S", "z");
        transformed = StringUtils.replacePattern(transformed,"@@", "S");
        
        transformed = StringUtils.replacePattern(transformed,"\\.a", "'"); // SLP for
                                                            // avagraha,,,,,using
                                                            // from own system
        // watch out!!!! use "\\.a" not ".a"



        /** *NOTE 1 ** */
        transformed = StringUtils.replacePattern(transformed,"\\.N", "~"); // chandra-bindu...watch
                                                            // out do not just
                                                            // use .N use \\.N

        // return transformed;
        return transformed;
    }
}
