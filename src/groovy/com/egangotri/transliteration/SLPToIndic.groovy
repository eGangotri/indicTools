package com.egangotri.transliteration

import com.egangotri.util.UnicodeUtils

class SLPToIndic {

    static List<Hashtable<String, String>> dvn
    static List<Hashtable<String, String>> gurumukhi
    static List<Hashtable<String, String>> bngla
    static List<Hashtable<String, String>> oriya
    static List<Hashtable<String, String>> gujarati
    static List<Hashtable<String, String>> tamil
    static List<Hashtable<String, String>> telugu
    static List<Hashtable<String, String>> kannada
    static List<Hashtable<String, String>> malayalam

    public static String transform(String text) {
        _transform(dvn, UnicodeUtils.DEVANAGARI_A_SYMBOL_IN_HEX, text)
    }

    public static String transformToBangla(String text) {
        _transform(bngla, UnicodeUtils.BANGLA_A_SYMBOL_IN_HEX, text)
    }

    public static String transformToGurumukhi(String text) {
        _transform(gurumukhi, UnicodeUtils.GURUMUKHI_A_SYMBOL_IN_HEX, text)
    }

    public static String transformToGujarati(String text) {
        _transform(gujarati, UnicodeUtils.GUJARATI_A_SYMBOL_IN_HEX, text)
    }

    public static String transformToOriya(String text) {
        _transform(oriya, UnicodeUtils.ORIYA_A_SYMBOL_IN_HEX, text)
    }

    public static String transformToKannada(String text) {
        _transform(kannada, UnicodeUtils.KANNADA_A_SYMBOL_IN_HEX, text)
    }


    public static String transformToMalayalam(String text) {
        _transform(malayalam, UnicodeUtils.MALAYALAM_A_SYMBOL_IN_HEX, text)
    }


    public static String transformToTamil(String text) {
        _transform(tamil, UnicodeUtils.TAMIL_A_SYMBOL_IN_HEX, text)
    }


    public static String transformToTelugu(String text) {
        _transform(telugu, UnicodeUtils.TELUGU_A_SYMBOL_IN_HEX, text)
    }


    public static String _transform(List<Hashtable<String, String>> script, String a_symbol, text) {
        if (script == null) {
            script = SLPToIndicMap.populateHashTable(a_symbol)
        }
        SLPToIndicMap.transform(script[0], script[1], UnicodeUtils.getHalant(a_symbol), text)
    }

}