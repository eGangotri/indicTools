package com.egangotri.transliteration.fromSLP

import groovy.util.logging.Slf4j
import org.apache.commons.lang3.StringUtils;
@Slf4j
public class SLPToVelthuis {
    public static String transform(String s1)
    {

        String transformed = s1;
        //log.info("SLPToItrans: " + s1  );

        transformed = StringUtils.replacePattern(transformed,"A","aa");
        transformed = StringUtils.replacePattern(transformed,"I","ii");
        transformed = StringUtils.replacePattern(transformed,"U","uu");
        transformed = StringUtils.replacePattern(transformed,"f", ".r");
        transformed = StringUtils.replacePattern(transformed,"F",".rr");// same reason as above
        transformed = StringUtils.replacePattern(transformed,"x",".l");
        transformed = StringUtils.replacePattern(transformed,"X",".ll");

        transformed = StringUtils.replacePattern(transformed,"E","ai");
        transformed = StringUtils.replacePattern(transformed,"O","au");

        transformed = StringUtils.replacePattern(transformed,"M",".m");
        transformed = StringUtils.replacePattern(transformed,"H",".h");

        transformed = StringUtils.replacePattern(transformed,"~n","Y");

        transformed = StringUtils.replacePattern(transformed,"~","/");
        transformed = StringUtils.replacePattern(transformed,"'",".a");

        //whats is OM in SLP

        transformed = StringUtils.replacePattern(transformed,"K","kh");
        transformed = StringUtils.replacePattern(transformed,"G","gh");
        transformed = StringUtils.replacePattern(transformed,"N","\"n");


        transformed = StringUtils.replacePattern(transformed,"C","ch");
        transformed = StringUtils.replacePattern(transformed,"J","jh");

        transformed = StringUtils.replacePattern(transformed,"w",".t");
        transformed = StringUtils.replacePattern(transformed,"W",".th");
        transformed = StringUtils.replacePattern(transformed,"q",".d");
        transformed = StringUtils.replacePattern(transformed,"Q",".dh");
        transformed = StringUtils.replacePattern(transformed,"R",".n");

        transformed = StringUtils.replacePattern(transformed,"P","ph");
        transformed = StringUtils.replacePattern(transformed,"B","bh");

        transformed = StringUtils.replacePattern(transformed,"S","\"s");// temporary place holder
        transformed = StringUtils.replacePattern(transformed,"z",".s");

        return transformed; // return transformed;
    }
}
