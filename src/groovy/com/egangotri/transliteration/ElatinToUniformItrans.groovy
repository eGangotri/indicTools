package com.egangotri.transliteration;

import com.egangotri.util.Log
import groovy.util.logging.Slf4j
import org.apache.commons.lang3.StringUtils;
@Slf4j
@Deprecated
public class ElatinToUniformItrans
{
    public static String transform(String s1)
    {
    String transformed= "";
    transformed = s1;
    log.info("ElatinToUniformItrans");

    // Vowels
    transformed = StringUtils.replacePattern(transformed, "â","a"); // seems
    // like
    // a
    // variation
    // of
    // a)
    transformed = StringUtils.replacePattern(transformed, "á","a"); // represents
    // SLP
    // "a"(aham)
    //transformed = StringUtils.replacePattern(transformed, "&#x0101;", "\u0101"); //
    transformed = StringUtils.replacePattern(transformed, "ā","A" ); // represents
    // SLP
    // "A"
    transformed = StringUtils.replacePattern(transformed, "Ā","A"); // capitalized
    // version
    // of
    // 'A'

    transformed = StringUtils.replacePattern(transformed,"ī" ,"I"); // represents
    // SLP
    // "I"(vIra)
    transformed = StringUtils.replacePattern(transformed,"í" ,"I"); // represents
    // SLP
    // "I"(vIra)
    transformed = StringUtils.replacePattern(transformed, "Ī","I"); // capitalized
    // "I"(vIra)

    transformed = StringUtils.replacePattern(transformed, "ū", "U"); // represents
    // SLP
    // "U"(krUra)
    transformed = StringUtils.replacePattern(transformed, "ú", "U"); // represents
    // SLP
    // "U"(krUra)
    transformed = StringUtils.replacePattern(transformed, "Ū" ,"U"); // capitalized
    // "U"(krUra)
    transformed = StringUtils.replacePattern(transformed, "û" , "U"); // capitalized
    // "U"(krUra)

    transformed = StringUtils.replacePattern(transformed,"ṛ" ,"RRi"); // represents
    // SLP
    // "f"(RRi)
    transformed = StringUtils.replacePattern(transformed, "Ṛ","RRi"); // capitalized
    // "f"(RRi)
    transformed = StringUtils.replacePattern(transformed, "ṝ" , "RRI"); // capitalized
    // "f"(RRi)
    transformed = StringUtils.replacePattern(transformed, "Ḷ", "LLi"); // capitalized
    // "f"(RRi)

    transformed = StringUtils.replacePattern(transformed,  "é", "e"); //
    transformed = StringUtils.replacePattern(transformed,  "ê", "ai"); //

    transformed = StringUtils.replacePattern(transformed,  "ô", "o"); // represents
    // SLP
    // "o"(meghodaya)
    transformed = StringUtils.replacePattern(transformed,  "ó", "o"); // represents
    // SLP
    // "o"(meghodaya)

    transformed = StringUtils.replacePattern(transformed, "ṃ","M"); // represents
    // SLP
    // "M"(aMsha)
    transformed = StringUtils.replacePattern(transformed, "ḥ", "H"); // represents
    // visarga

    // vargiyas
    transformed = StringUtils.replacePattern(transformed, "ḍ" , "D"); // represents
    // SLP
    // "q"(D
    // as
    // in
    // Danda)
    transformed = StringUtils.replacePattern(transformed, "Ḍ" ,"D"); // represents
    // SLP
    // "q"(D
    // as
    // in
    // Danda)

    transformed = StringUtils.replacePattern(transformed, "ṭ", "T"); // represents
    // SLP
    // "w"(T
    // as
    // in
    // TamaaTar)

    // Nasals:
    transformed = StringUtils.replacePattern(transformed, "ñ","~n"); // represents
    // SLP
    // "Y"(jYaana)
    transformed = StringUtils.replacePattern(transformed, "ṅ","Y"); // represents
    // SLP
    // "N"(kalaNka)
    transformed = StringUtils.replacePattern(transformed, "ṇ","N"); // represents
    // SLP
    // "R"(N)

    // sh-sh
    transformed = StringUtils.replacePattern(transformed,"ś", "sh"); // represents
    // SLP
    // "S"(Sh
    // as
    // in
    // Sharma)
    transformed = StringUtils.replacePattern(transformed,"Ś","sh"); // Capitalized
    // form
    // of
    // SLP
    // "S"(Sh
    // as
    // in
    // Sharma)

    transformed = StringUtils.replacePattern(transformed,"ṣ","z"); // represents
    // SLP
    // "z"(kzaNa)
    transformed = StringUtils.replacePattern(transformed,"Ṣ","z");
        
    // return transformed;
    return transformed;
    }
}
