package com.egangotri.transliteration

import com.egangotri.util.UnicodeUtils

class IndicToSLP {

    static List<Hashtable<String, String>> dvnI2S
    static List<Hashtable<String, String>> gurumukhiI2S
    static List<Hashtable<String, String>> bnglaI2S
    static List<Hashtable<String, String>> oriyaI2S
    static List<Hashtable<String, String>> gujaratiI2S
    static List<Hashtable<String, String>> tamilI2S
    static List<Hashtable<String, String>> teluguI2S
    static List<Hashtable<String, String>> kannadaI2S
    static List<Hashtable<String, String>> malayalamI2S


    static String transform(String text) {
        _transform(dvnI2S, UnicodeUtils.DEVANAGARI_A_SYMBOL_IN_HEX, text)
    }

    static String banglaToSLP(String text) {
        _transform(bnglaI2S, UnicodeUtils.BANGLA_A_SYMBOL_IN_HEX, text)
    }

    static String gurumukhiToSLP(String text) {
        _transform(gurumukhiI2S, UnicodeUtils.GURUMUKHI_A_SYMBOL_IN_HEX, text)
    }

    static String gujaratiToSLP(String text) {
        _transform(gujaratiI2S, UnicodeUtils.GUJARATI_A_SYMBOL_IN_HEX, text)
    }

    static String oriyaToSLP(String text) {
        _transform(oriyaI2S, UnicodeUtils.ORIYA_A_SYMBOL_IN_HEX, text)
    }

    static String kannadaToSLP(String text) {
        _transform(kannadaI2S, UnicodeUtils.KANNADA_A_SYMBOL_IN_HEX, text)
    }

    static String malayalamToSLP(String text) {
        _transform(malayalamI2S, UnicodeUtils.MALAYALAM_A_SYMBOL_IN_HEX, text)
    }


    static String tamilToSLP(String text) {
        _transform(tamilI2S, UnicodeUtils.TAMIL_A_SYMBOL_IN_HEX, text)
    }


    static String teluguToSLP(String text) {
        _transform(teluguI2S, UnicodeUtils.TELUGU_A_SYMBOL_IN_HEX, text)
    }

    static String _transform(List<Hashtable<String, String>> script, String a_symbol, text) {
        if (script == null) {
            script = IndicToSLPMap.populateHashTable(a_symbol)
        }
        IndicToSLPMap.transform(script[0], script[1], UnicodeUtils.getHalant(a_symbol), text)
    }
}

