package com.egangotri.transliteration

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

        transformed = transformed.replaceAll("O", "ॐ")
        transformed = transformed.replaceAll("\\.rr", "F") // a dot without escape will be interpreted as regex
        transformed = transformed.replaceAll("\\.ll", "X")
        transformed = transformed.replaceAll('"s', "S")
        transformed = transformed.replaceAll("\\.s", "z")
        transformed = transformed.replaceAll("\\.n", "R")
        transformed = transformed.replaceAll("\\.dh", "Q")
        transformed = transformed.replaceAll("\\.d", "q")
        transformed = transformed.replaceAll("\\.th", "W")
        transformed = transformed.replaceAll("\\.t", "w")
        transformed = transformed.replaceAll("~n", "Y")
        transformed = transformed.replaceAll("\"n", "N")


        transformed = transformed.replaceAll("aa", "A")
        transformed = transformed.replaceAll("ii", "I")
        transformed = transformed.replaceAll("uu", "U")
        transformed = transformed.replaceAll("ai", "E")
        transformed = transformed.replaceAll("au", "O")
        transformed = transformed.replaceAll("\\.r", "f")
        transformed = transformed.replaceAll("\\.l", "x")
        transformed = transformed.replaceAll("\\.m", "M")
        transformed = transformed.replaceAll("\\.h", "H")
        transformed = transformed.replaceAll("/", "~")
        transformed = transformed.replaceAll("\\.a", "'")

        transformed = transformed.replaceAll("kh", "K")
        transformed = transformed.replaceAll("gh", "G")
        transformed = transformed.replaceAll("ch", "C")
        transformed = transformed.replaceAll("jh", "J")
        transformed = transformed.replaceAll("th", "T")
        transformed = transformed.replaceAll("dh", "D")
        transformed = transformed.replaceAll("ph", "P")
        transformed = transformed.replaceAll("bh", "B")

        return transformed
    }
}
