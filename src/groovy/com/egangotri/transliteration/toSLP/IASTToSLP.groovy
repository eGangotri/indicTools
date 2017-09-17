package com.egangotri.transliteration.toSLP

import groovy.util.logging.Slf4j
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class IASTToSLP {

    public IASTToSLP() {
    }

    public static String transform(String transformed) {
        transformed = transformed.toLowerCase();
        //log.info("IASTToSLP: " + transformed);
        //ā
        // Vowels
        transformed = StringUtils.replacePattern(transformed, "ā", "A")
        transformed = StringUtils.replacePattern(transformed,"ā", "A");
        transformed = StringUtils.replacePattern(transformed,"ī", "I");
        transformed = StringUtils.replacePattern(transformed,"ū", "U");
        transformed = StringUtils.replacePattern(transformed,"ṛ", "f");
        transformed = StringUtils.replacePattern(transformed,"ṝ", "F");
        transformed = StringUtils.replacePattern(transformed,"ḷ", "x");
        transformed = StringUtils.replacePattern(transformed,"ḹ", "X");

        transformed = StringUtils.replacePattern(transformed,"ai", "E");
        transformed = StringUtils.replacePattern(transformed,"au", "O");

        transformed = StringUtils.replacePattern(transformed,"ḥ", "H");
        transformed = StringUtils.replacePattern(transformed,"ṃ", "M");

        transformed = StringUtils.replacePattern(transformed,"kh", "K");
        transformed = StringUtils.replacePattern(transformed,"gh", "G");

        transformed = StringUtils.replacePattern(transformed,"ch", "C");
        transformed = StringUtils.replacePattern(transformed,"jh", "J");


        transformed = StringUtils.replacePattern(transformed,"ṭh", "W");
        transformed = StringUtils.replacePattern(transformed,"ṭ", "w");

        transformed = StringUtils.replacePattern(transformed,"ḍh", "Q");
        // vargiyas
        transformed = StringUtils.replacePattern(transformed,"ḍ", "q");

        transformed = StringUtils.replacePattern(transformed,"th", "T");
        transformed = StringUtils.replacePattern(transformed,"dh", "D");

        transformed = StringUtils.replacePattern(transformed,"ph", "P");
        transformed = StringUtils.replacePattern(transformed,"bh", "B");

        // Nasals:
        transformed = StringUtils.replacePattern(transformed,"ñ", "Y"); // represents
        // SLP
        // "Y"(jYaana)
        transformed = StringUtils.replacePattern(transformed,"ṅ", "N"); // represents
        // SLP
        // "N"(kalaNka)
        transformed = StringUtils.replacePattern(transformed,"ṇ", "R"); // represents
        // SLP
        // "R"(N)
        transformed = StringUtils.replacePattern(transformed,"ś", "S"); // represents
        // SLP
        // "S"(Sh
        // as
        // in
        // Sharma)

        transformed = StringUtils.replacePattern(transformed,"ṣ", "z"); // represents
        // SLP
        // "z"(kzaNa)

        //Vedic Accents
        transformed = StringUtils.replacePattern(transformed,"á", "/"); // uddata  "/", "\" and "^"
        transformed = StringUtils.replacePattern(transformed,"á", "\\"); // uddata  "/", "\" and "^"
        transformed = StringUtils.replacePattern(transformed,"à", "^"); // uddata  "/", "\" and "^"

        return transformed;
    }
}
