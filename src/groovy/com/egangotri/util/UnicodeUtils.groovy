package com.egangotri.util

import javax.xml.bind.DatatypeConverter

class UnicodeUtils {
    static final String DEVANAGARI_A_SYMBOL_IN_HEX = "0905"
    static final String BANGLA_A_SYMBOL_IN_HEX = "0985"
    static final String GURUMUKHI_A_SYMBOL_IN_HEX = "0A05"
    static final String GUJARATI_A_SYMBOL_IN_HEX = "0A85"
    static final String ORIYA_A_SYMBOL_IN_HEX = "0B05"
    static final String TAMIL_A_SYMBOL_IN_HEX = "0B85"
    static final String TELUGU_A_SYMBOL_IN_HEX = "0C05"
    static final String MALAYALAM_A_SYMBOL_IN_HEX = "0D05"
    static final String KANNADA_A_SYMBOL_IN_HEX = "0C85"


    public static getHalant(String a_akshar) {
        toUTF(a_akshar, 72)
    }

    static String hexToUTF16(String hexString) {
        byte[] bytes = DatatypeConverter.parseHexBinary(hexString)
        String result = new String(bytes, "UTF-16")
        return result
    }

    //https://stackoverflow.com/questions/13990941/how-to-convert-hex-string-to-java-string
    static String hexadecimalAddition(String hexString, int incrementerValue) {
        int result = Integer.parseInt(hexString, 16) + incrementerValue
        return String.format("%4s", Integer.toHexString(result)).replace(' ', '0')
    }

    static String toUTF(String hexString, int incrementerValue){
        return hexToUTF16(hexadecimalAddition(hexString, incrementerValue))
    }

}
