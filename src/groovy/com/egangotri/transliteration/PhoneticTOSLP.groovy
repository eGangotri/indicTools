package com.egangotri.transliteration

/**
 * Created by user on 6/3/2016.
 */
class PhoneticTOSLP {

    public static String transform(String transformed) {

        transformed = transformed.replaceAll("ka", "kA");
        transformed = transformed.replaceAll("k", "ka");
    }
}

