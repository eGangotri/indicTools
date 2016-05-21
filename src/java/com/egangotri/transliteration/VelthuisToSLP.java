package com.egangotri.transliteration;

public class VelthuisToSLP
{

    public static String transform(String s1)
    {
        String transformed = s1;

        transformed = transformed.replaceAll("R", "δ");
        transformed = transformed.replaceAll("Rh", "Δ");
        transformed = transformed.replaceAll("f", "φ");
        transformed = transformed.replaceAll("z", "ζ");
        transformed = transformed.replaceAll("\\.K", "Κ");
        transformed = transformed.replaceAll("\\.g", "γ");
        transformed = transformed.replaceAll("q", "κ");
        transformed = transformed.replaceAll("\\.o", "Ω");
        

        transformed = transformed.replaceAll("~o", "ο"); // English 'o' using Greek Omicron
        transformed = transformed.replaceAll("~a", "Ω"); // English 'e' using Greek epsilon
        
        
        transformed = transformed.replaceAll("\\.L", "X");
        transformed = transformed.replaceAll("\\.l", "x");
        transformed = transformed.replaceAll("\\.R", "F");
        transformed = transformed.replaceAll("\\.r", "f");
        

        transformed = transformed.replaceAll("\"n", "N");
        transformed = transformed.replaceAll("~n", "Y");
        transformed = transformed.replaceAll("\\.n", "R"); 
        
        transformed = transformed.replaceAll("\\.t", "w");
        transformed = transformed.replaceAll("\\.T", "W");
        
        transformed = transformed.replaceAll("\\.d", "q");
        transformed = transformed.replaceAll("\\.D", "Q");
        

        transformed = transformed.replaceAll("\"s", "S");
        transformed = transformed.replaceAll("\\.s", "z");
        

        transformed = transformed.replaceAll("\\.a", "'");//watch
        // out do not just
        // use .a use \\.a
        transformed = transformed.replaceAll("/", "~");
        

        // return transformed;
        return transformed;
    }
}
