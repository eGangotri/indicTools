package com.egangotri.transliteration;

import com.egangotri.util.Log
import groovy.util.logging.Slf4j;
@Slf4j
public class SLPToVelthuis {
    public static String transform(String s1)
    {

        String transformed = s1;
        log.info("SLPToItrans: " + s1  );

        transformed = transformed.replaceAll("A","aa");
        transformed = transformed.replaceAll("I","ii");
        transformed = transformed.replaceAll("U","uu");
        transformed = transformed.replaceAll("f", ".r");
        transformed = transformed.replaceAll("F",".rr");// same reason as above
        transformed = transformed.replaceAll("x",".l");
        transformed = transformed.replaceAll("X",".ll");

        transformed = transformed.replaceAll("E","ai");
        transformed = transformed.replaceAll("O","au");

        transformed = transformed.replaceAll("M",".m");
        transformed = transformed.replaceAll("H",".h");

        transformed = transformed.replaceAll("~n","Y");

        transformed = transformed.replaceAll("~","/");
        transformed = transformed.replaceAll("'",".a");

        //whats is OM in SLP

        transformed = transformed.replaceAll("K","kh");
        transformed = transformed.replaceAll("G","gh");
        transformed = transformed.replaceAll("N","\"n");


        transformed = transformed.replaceAll("C","ch");
        transformed = transformed.replaceAll("J","jh");

        transformed = transformed.replaceAll("w",".t");
        transformed = transformed.replaceAll("W",".th");
        transformed = transformed.replaceAll("q",".d");
        transformed = transformed.replaceAll("Q",".dh");
        transformed = transformed.replaceAll("R",".n");

        transformed = transformed.replaceAll("P","ph");
        transformed = transformed.replaceAll("B","bh");

        transformed = transformed.replaceAll("S","\"s");// temporary place holder
        transformed = transformed.replaceAll("z",".s");

        return transformed; // return transformed;
    }
}
