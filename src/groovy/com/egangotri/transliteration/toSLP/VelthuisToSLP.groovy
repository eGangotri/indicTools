package com.egangotri.transliteration.toSLP

import org.apache.commons.lang3.StringUtils

public class VelthuisToSLP {

    public VelthuisToSLP() {
    }

    /*
     * This Class replaces alternative Velthuis Encodings for a given String to
     * only One Uniform Kind of Velthuis so that conversion to SLP is easier. For
     * example 'aa' can be written as 'aa' and 'A' but here we replace all 'aa'
     * to A only
     */
    public static String transform(String transformed) {

        transformed = StringUtils.replacePattern(transformed,"O", "ॐ")
        transformed = StringUtils.replacePattern(transformed,"\\.rr", "F") // a dot without escape will be interpreted as regex
        transformed = StringUtils.replacePattern(transformed,"\\.ll", "X")
        transformed = StringUtils.replacePattern(transformed,'"s', "S")
        transformed = StringUtils.replacePattern(transformed,"\\.s", "z")
        transformed = StringUtils.replacePattern(transformed,"\\.n", "R")
        transformed = StringUtils.replacePattern(transformed,"\\.dh", "Q")
        transformed = StringUtils.replacePattern(transformed,"\\.d", "q")
        transformed = StringUtils.replacePattern(transformed,"\\.th", "W")
        transformed = StringUtils.replacePattern(transformed,"\\.t", "w")
        transformed = StringUtils.replacePattern(transformed,"~n", "Y")
        transformed = StringUtils.replacePattern(transformed,"\"n", "N")


        transformed = StringUtils.replacePattern(transformed,"aa", "A")
        transformed = StringUtils.replacePattern(transformed,"ii", "I")
        transformed = StringUtils.replacePattern(transformed,"uu", "U")
        transformed = StringUtils.replacePattern(transformed,"ai", "E")
        transformed = StringUtils.replacePattern(transformed,"au", "O")
        transformed = StringUtils.replacePattern(transformed,"\\.r", "f")
        transformed = StringUtils.replacePattern(transformed,"\\.l", "x")
        transformed = StringUtils.replacePattern(transformed,"\\.m", "M")
        transformed = StringUtils.replacePattern(transformed,"\\.h", "H")
        transformed = StringUtils.replacePattern(transformed,"/", "~")
        transformed = StringUtils.replacePattern(transformed,"\\.a", "'")

        transformed = StringUtils.replacePattern(transformed,"kh", "K")
        transformed = StringUtils.replacePattern(transformed,"gh", "G")
        transformed = StringUtils.replacePattern(transformed,"ch", "C")
        transformed = StringUtils.replacePattern(transformed,"jh", "J")
        transformed = StringUtils.replacePattern(transformed,"th", "T")
        transformed = StringUtils.replacePattern(transformed,"dh", "D")
        transformed = StringUtils.replacePattern(transformed,"ph", "P")
        transformed = StringUtils.replacePattern(transformed,"bh", "B")

        return transformed
    }
}
