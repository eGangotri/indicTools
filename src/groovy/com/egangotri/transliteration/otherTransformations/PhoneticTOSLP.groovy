package com.egangotri.transliteration.otherTransformations

import org.apache.commons.lang3.StringUtils

/**
 * Created by user on 6/3/2016.
 */
class PhoneticTOSLP {

    public static String transform(String transformed) {

        transformed = StringUtils.replacePattern(transformed,"ka", "kA");
        transformed = StringUtils.replacePattern(transformed,"k", "ka");
    }
}

