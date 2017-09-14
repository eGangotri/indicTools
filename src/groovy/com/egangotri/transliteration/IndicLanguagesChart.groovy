package com.egangotri.transliteration

import com.egangotri.constants.SLPConstants
import com.egangotri.util.VowelUtil

import javax.xml.bind.DatatypeConverter

class IndicLanguagesChart {

    static List populateHashTable(String unicodeForA) {

        Hashtable<String, String> unicode = new Hashtable<String, String>()
        Hashtable<String, String> matra = new Hashtable<String, String>()

        matra.put("A", toUTF(unicodeForA, 57))
        matra.put("i", toUTF(unicodeForA, 58))
        matra.put("I", toUTF(unicodeForA, 59))
        matra.put("u",  toUTF(unicodeForA, 60))
        matra.put("U",  toUTF(unicodeForA, 61))
        matra.put("f",  toUTF(unicodeForA, 62))
        matra.put("F", toUTF(unicodeForA, 63))
        matra.put("x", toUTF(unicodeForA, 93))
        matra.put("X",  toUTF(unicodeForA, 94))
        matra.put("e", toUTF(unicodeForA, 66))
        matra.put("E", toUTF(unicodeForA, 67))
        matra.put("o", toUTF(unicodeForA, 70))
        matra.put("O", toUTF(unicodeForA, 71))

        unicode.put("a", toUTF(unicodeForA,0))
        unicode.put("A", toUTF(unicodeForA, 1))
        unicode.put("i", toUTF(unicodeForA, 2))
        unicode.put("I", toUTF(unicodeForA, 3))
        unicode.put("u", toUTF(unicodeForA, 4))
        unicode.put("U", toUTF(unicodeForA, 5))
        unicode.put("f", toUTF(unicodeForA, 6))
        unicode.put("F",  toUTF(unicodeForA, 91))
        unicode.put("x", toUTF(unicodeForA, 7))
        unicode.put("X",  toUTF(unicodeForA, 92))
        unicode.put("e", toUTF(unicodeForA, 10))
        unicode.put("E", toUTF(unicodeForA, 11))
        unicode.put("o", toUTF(unicodeForA, 14))
        unicode.put("O", toUTF(unicodeForA, 15))

        unicode.put(SLPConstants.KA, toUTF(unicodeForA,16))
        unicode.put("K", toUTF(unicodeForA, 17))
        unicode.put("g", toUTF(unicodeForA, 18))
        unicode.put("G", toUTF(unicodeForA, 19))
        unicode.put("N", toUTF(unicodeForA, 20))
        unicode.put("c", toUTF(unicodeForA, 21))
        unicode.put("C", toUTF(unicodeForA, 22))
        unicode.put("j", toUTF(unicodeForA, 23))
        unicode.put("J", toUTF(unicodeForA, 24))
        unicode.put("Y", toUTF(unicodeForA, 25))
        unicode.put("w", toUTF(unicodeForA, 26)) // Ta as in Tom
        unicode.put("W", toUTF(unicodeForA, 27))
        unicode.put("q", toUTF(unicodeForA, 28)) // Da as in David
        unicode.put("Q", toUTF(unicodeForA, 29))
        unicode.put("R", toUTF(unicodeForA, 30))
        unicode.put("t", toUTF(unicodeForA, 31)) // ta as in tamasha
        unicode.put("T", toUTF(unicodeForA, 32)) // tha as in thanks
        unicode.put("d", toUTF(unicodeForA, 33)) // da as in darvaaza
        unicode.put("D", toUTF(unicodeForA, 34)) // dha as in dhanusha
        unicode.put("n", toUTF(unicodeForA, 35))
        unicode.put("p", toUTF(unicodeForA, 37))
        unicode.put("P", toUTF(unicodeForA, 38))
        unicode.put("b", toUTF(unicodeForA, 39))
        unicode.put("B", toUTF(unicodeForA, 40))
        unicode.put("m", toUTF(unicodeForA, 41))
        unicode.put("y", toUTF(unicodeForA, 42))
        unicode.put("r", toUTF(unicodeForA, 43))
        unicode.put("l", toUTF(unicodeForA, 45))

        unicode.put(SLPConstants.L_HARD_VEDIC, toUTF(unicodeForA, 46)) // the Marathi and Vedic 'L' 'ळ'
        // unicode.put("|", hexToUTF16("09330939")) // the Marathi and Vedic 'L' 'ळ्ह'

        unicode.put("v", toUTF(unicodeForA, 48))
        unicode.put("S", toUTF(unicodeForA, 49))
        unicode.put("z", toUTF(unicodeForA,50 ))
        unicode.put("s", toUTF(unicodeForA, 51))
        unicode.put("h", toUTF(unicodeForA, 52))

        unicode.put("M", toUTF(unicodeForA, -3)) // anusvara
        unicode.put("H", toUTF(unicodeForA, -2))// visarga
        unicode.put("~", toUTF(unicodeForA, -4)) // anunAsika - cchandra bindu, using ~ to
        // represent it\
        unicode.put("'", toUTF(unicodeForA, 56)) // avagraha using "'"
        unicode.put("3", hexToUTF16("0969")) // 3 equals to pluta

        unicode.put("Z", hexToUTF16("014F"))// Z equals to jihvamuliya
        unicode.put("V", hexToUTF16("0CF1"))
// V equals to upadhamaniya....but what character have u settled for jihvamuliya

        unicode.put("Ω", hexToUTF16("0950")) // aum
        unicode.put("κ", hexToUTF16("0958")) // Urdu qaif
        unicode.put("Κ", hexToUTF16("0959")) //Urdu qhe
        unicode.put("γ", hexToUTF16("095A")) // Urdu gain
        unicode.put("ζ", hexToUTF16("095B")) //Urdu zal, ze, zoe
        unicode.put("φ", hexToUTF16("095E")) // Urdu f
        unicode.put("δ", hexToUTF16("095C")) // Hindi 'dh' as in padh
        unicode.put("Δ", hexToUTF16("095D")) // hindi dhh
        unicode.put("τ", hexToUTF16("0926093C")) // Urdu dwad
        unicode.put("θ", hexToUTF16("0924093C")) // Urdu toe
        unicode.put("σ", hexToUTF16("0938093C")) // Urdu swad, se


        unicode.put("ε", hexToUTF16("0945")) // English 'e'. Using epsilon
        unicode.put("ο", hexToUTF16("0949")) // English '0'. Using omicron


        unicode.put("0", hexToUTF16("0966"))
        unicode.put("1", hexToUTF16("0967"))
        unicode.put("3", hexToUTF16("0968"))
        unicode.put("3", hexToUTF16("0969")) // 3 equals to pluta
        unicode.put("4", hexToUTF16("096A"))
        unicode.put("5", hexToUTF16("096B"))
        unicode.put("6", hexToUTF16("096C"))
        unicode.put("7", hexToUTF16("096D"))
        unicode.put("8", hexToUTF16("096E"))
        unicode.put("9", hexToUTF16("0975"))

        //Vedic
        unicode.put("/", hexToUTF16("0951")) // udataa
        unicode.put("\\\\", hexToUTF16("0952")) //anudatta
        unicode.put("^", hexToUTF16("1CDA")) //svarita



        /*
transformed = StringUtils.replacePattern(transformed,"AUM","Ω")) //omega or Ohm
transformed = StringUtils.replacePattern(transformed,"OM","Ω")) //Omega or Ohm

transformed = StringUtils.replacePattern(transformed,"q","κ"))  //Greek kappa
transformed = StringUtils.replacePattern(transformed,"K","Κ"))  // Greek Capital Kappa
transformed = StringUtils.replacePattern(transformed,"G","γ")) //gamma
transformed = StringUtils.replacePattern(transformed,"z","ζ")) //Zeta
transformed = StringUtils.replacePattern(transformed,"J","ζ")) //Zeta
transformed = StringUtils.replacePattern(transformed,"f","φ")) //phi
transformed = StringUtils.replacePattern(transformed,".Dh","Δ"))  //Capital Delta
transformed = StringUtils.replacePattern(transformed,".D","δ")) //delta
transformed = StringUtils.replacePattern(transformed,".d","τ")) //tau
transformed = StringUtils.replacePattern(transformed,".t","θ")) //theta
transformed = StringUtils.replacePattern(transformed,".s","σ")) //sigma
transformed = StringUtils.replacePattern(transformed,".c","ω")) //omega
*/

        [matra, unicode]
    }
    
    public static String transform(Hashtable<String, String> matra, Hashtable<String, String> unicode, String halant, String text) {

        String transformed = ""

        int strLen = text.length()
        ArrayList<String> shabda = new ArrayList<String>()
        String lastEntry = ""
        for (int i = 0; i < strLen; i++) {
            char c = text.charAt(i)
            String varna = String.valueOf(c)

            if (VowelUtil.isConsonant(varna)) {
                shabda.add(unicode.get(varna))
                shabda.add(halant) //halant
                lastEntry = halant
            } else if (VowelUtil.isVowel(varna)) {
                if (halant.equals(lastEntry)) {
                    if (varna.equals("a")) {
                        shabda.set(shabda.size() - 1, "")
                    } else {
                        shabda.set(shabda.size() - 1, matra.get(varna))
                    }
                } else {
                    shabda.add(unicode.get(varna))
                }
                lastEntry = unicode.get(varna)
            } // end of else if is-Vowel

            else if (unicode.containsKey(varna)) {
                shabda.add(unicode.get(varna))
                lastEntry = unicode.get(varna)
            } else {
                shabda.add(varna)
                lastEntry = varna
            }

        } // end of for

        for (String string : shabda) {
            transformed += string
        }

        //Discard the shabda array
        shabda = null
        return transformed // return transformed
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
