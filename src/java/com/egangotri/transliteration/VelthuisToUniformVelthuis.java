package com.egangotri.transliteration;

public class VelthuisToUniformVelthuis
{

    public VelthuisToUniformVelthuis()
    {
    }

    /*
     * This Class replaces alternative Velthius Encodings for a given String to
     * only One Uniform Kind of Velthius so that conversion to SLP is easier. For
     * example 'aa' can be written as 'aa' and 'A' but here we replace all 'aa'
     * to A only
     */
    public static String transform(String transformed)
    {

        transformed = transformed.replaceAll(".kh", ".K");
        transformed = transformed.replaceAll(".o", "α");                                        
        transformed = transformed.replaceAll(".th", ".T");                              
        transformed = transformed.replaceAll(".dh", ".D");                             
        transformed = transformed.replaceAll(".m", "M");                              
        transformed = transformed.replaceAll(".h", "H");      
        
        transformed = transformed.replaceAll("ai", "E");
        transformed = transformed.replaceAll("au", "O");
        transformed = transformed.replaceAll("aa", "A");
        transformed = transformed.replaceAll("ii", "I");
        transformed = transformed.replaceAll("uu", "U");

        transformed = transformed.replaceAll("gh", "G");
        transformed = transformed.replaceAll("kh", "K");

        transformed = transformed.replaceAll("ch", "C"); 
        transformed = transformed.replaceAll("jh", "J");                                                     
        transformed = transformed.replaceAll("th", "T");                                                  
        transformed = transformed.replaceAll("th", "D");

        transformed = transformed.replaceAll("ph", "P");
        transformed = transformed.replaceAll("bh", "B");


        return transformed;
    }
}
