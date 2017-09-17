package com.egangotri.transliteration

import com.egangotri.constants.SLPConstants
import groovy.util.logging.Slf4j

import static com.egangotri.util.UnicodeUtils.hexToUTF16
import static com.egangotri.util.UnicodeUtils.toUTF

@Slf4j
public class IndicToSLPMap {

    static List<Hashtable<String, String>> populateHashTable(String unicodeForA) {

        Hashtable<String, String> unicode = new Hashtable<String, String>()
        Hashtable<String, String> matra = new Hashtable<String, String>()

        matra.put(toUTF(unicodeForA, 57), "A");
        matra.put(toUTF(unicodeForA, 58), "i");
        matra.put(toUTF(unicodeForA, 59), "I");
        matra.put(toUTF(unicodeForA, 60), "u");
        matra.put(toUTF(unicodeForA, 61), "U");
        matra.put(toUTF(unicodeForA, 62), "f");
        matra.put(toUTF(unicodeForA, 63), "F");
        matra.put(toUTF(unicodeForA, 93), "x");
        matra.put(toUTF(unicodeForA, 94), "X");
        matra.put(toUTF(unicodeForA, 66), "e");
        matra.put(toUTF(unicodeForA, 67), "E");
        matra.put(toUTF(unicodeForA, 70), "o");
        matra.put(toUTF(unicodeForA, 71), "O");

        unicode.put(toUTF(unicodeForA, 0), "a");
        unicode.put(toUTF(unicodeForA, 1), "A");
        unicode.put(toUTF(unicodeForA, 2), "i");
        unicode.put(toUTF(unicodeForA, 3), "I");
        unicode.put(toUTF(unicodeForA, 4), "u");
        unicode.put(toUTF(unicodeForA, 5), "U");
        unicode.put(toUTF(unicodeForA, 6), "f");
        unicode.put(toUTF(unicodeForA, 91), "F");
        unicode.put(toUTF(unicodeForA, 7), "x");
        unicode.put(toUTF(unicodeForA, 92), "X");
        unicode.put(toUTF(unicodeForA, 10), "e");
        unicode.put(toUTF(unicodeForA, 11), "E");
        unicode.put(toUTF(unicodeForA, 14), "o");
        unicode.put(toUTF(unicodeForA, 15), "O");

        unicode.put(toUTF(unicodeForA, 16), "ka");
        unicode.put(toUTF(unicodeForA, 17), "Ka");
        unicode.put(toUTF(unicodeForA, 18), "ga");
        unicode.put(toUTF(unicodeForA, 19), "Ga");
        unicode.put(toUTF(unicodeForA, 20), "Na");
        unicode.put(toUTF(unicodeForA, 21), "ca");
        unicode.put(toUTF(unicodeForA, 22), "Ca");
        unicode.put(toUTF(unicodeForA, 23), "ja");
        unicode.put(toUTF(unicodeForA, 24), "Ja");
        unicode.put(toUTF(unicodeForA, 25), "Ya");
        unicode.put(toUTF(unicodeForA, 26), "wa"); // Ta as in Tom
        unicode.put(toUTF(unicodeForA, 27), "Wa");
        unicode.put(toUTF(unicodeForA, 28), "qa"); // Da as in David
        unicode.put(toUTF(unicodeForA, 29), "Qa");
        unicode.put(toUTF(unicodeForA, 30), "Ra");
        unicode.put(toUTF(unicodeForA, 31), "ta"); // ta as in tamasha
        unicode.put(toUTF(unicodeForA, 32), "Ta"); // tha as in thanks
        unicode.put(toUTF(unicodeForA, 33), "da"); // da as in darvaaza
        unicode.put(toUTF(unicodeForA, 34), "Da"); // dha as in dhanusha
        unicode.put(toUTF(unicodeForA, 35), "na");
        unicode.put(toUTF(unicodeForA, 37), "pa");
        unicode.put(toUTF(unicodeForA, 38), "Pa");
        unicode.put(toUTF(unicodeForA, 39), "ba");
        unicode.put(toUTF(unicodeForA, 40), "Ba");
        unicode.put(toUTF(unicodeForA, 41), "ma");
        unicode.put(toUTF(unicodeForA, 42), "ya");
        unicode.put(toUTF(unicodeForA, 43), "ra");
        unicode.put(toUTF(unicodeForA, 45), "la");
        unicode.put(toUTF(unicodeForA, 46), "La"); // the Marathi and Vedic 'L'
        unicode.put(toUTF(unicodeForA, 48), "va");
        unicode.put(toUTF(unicodeForA, 49), "Sa");
        unicode.put(toUTF(unicodeForA, 50), "za");
        unicode.put(toUTF(unicodeForA, 51), "sa");
        unicode.put(toUTF(unicodeForA, 52), "ha");
        unicode.put(toUTF(unicodeForA, -3), "M"); // anusvara
        unicode.put(toUTF(unicodeForA, -2), "H"); // visarga
        unicode.put(toUTF(unicodeForA, -4), "~"); // anunAsika - cchandra bindu using V to represent it\
        unicode.put(toUTF(unicodeForA, 56), "'"); // avagraha using "'"
        unicode.put(hexToUTF16("0969"), "3"); // 3 equals to pluta

        //NOT PART OF SLP-1
        unicode.put("\u014F", "${SLPConstants.UPADHAMANIYA}");// Z equals to upadhamaniya
        unicode.put("\u0CF1", "${SLPConstants.JIHNVAMULIYA}");
// V equals to jihvamuliya....but what character have u settled for jihvamuliya
        unicode.put("\u0950", "${SLPConstants.OM}"); // aum
        unicode.put("\u0958", "${SLPConstants.K_WITH_NUKTA}a"); // Urdu qaif
        unicode.put("\u0959", "${SLPConstants.KH_WITH_NUKTA}a"); //Urdu qhe
        unicode.put("\u095A", "${SLPConstants.G_WITH_NUKTA}a"); // Urdu gain
        unicode.put("\u095B", "${SLPConstants.Z_WITH_NUKTA}a"); //Urdu zal, ze, zoe
        unicode.put("\u095E", "${SLPConstants.F_WITH_NUKTA}a"); // Urdu f
        unicode.put("\u095C", "${SLPConstants.D_HARD__WITH_BINDI}a"); // Hindi 'dh' as in padh
        unicode.put("\u095D", "${SLPConstants.DH_HARD_WITH_BINDI}a"); // hindi dhh
        unicode.put("\u0926\u093C", "${SLPConstants.D_SOFT_WITH_NUKTA}a"); // Urdu dwad
        unicode.put("\u0924\u093C", "${SLPConstants.T_SOFT_WITH_NUKTA}a"); // Urdu toe
        unicode.put("\u0938\u093C", "${SLPConstants.S_SOFT_WITH_NUKTA}a"); // Urdu swad, se

        unicode.put("\u0966", "0");
        unicode.put("\u0967", "1");
        unicode.put("\u0968", "2");
        unicode.put("\u0969", "3"); // 3 equals to pluta
        unicode.put("\u096A", "4");
        unicode.put("\u096B", "5");
        unicode.put("\u096C", "6");
        unicode.put("\u096D", "7");
        unicode.put("\u096E", "8");
        unicode.put("\u096F", "9");
        [matra, unicode]
    }

    static String transform(Hashtable<String, String> matra, Hashtable<String, String> unicode, String halant, String text) {
        int strLen = text.length();
        ArrayList<String> shabda = new ArrayList<String>();
        String lastEntry = "";
        for (int i = 0; i < strLen; i++) {
            char c = text.charAt(i);
            String varna = String.valueOf(c);

            if (unicode.containsKey(varna)) {
                shabda.add(unicode.get(varna));
                lastEntry = unicode.get(varna);
            } else if (matra.containsKey(varna)) {
                shabda.set(shabda.size() - 1, String.valueOf(lastEntry.charAt(0)));
                shabda.add(matra.get(varna));
                lastEntry = matra.get(varna);
            } else if (halant.equals(varna)) {
                //log.info("before adding halant: lastEntry " + lastEntry + " word " + listToString(shabda) + ", size: " + shabda.size());
                shabda.set(shabda.size() - 1, String.valueOf(lastEntry.charAt(0)));
                lastEntry = halant;
                //log.info("after adding halant: lastEntry " + lastEntry + " word " + listToString(shabda) + "size: " + shabda.size());
            } else {
                shabda.add(varna);
                lastEntry = varna;
            }

        } // end of for

        String newString = listToString(shabda);
        //Discard the shabda array
        shabda = null;

        return newString; // return transformed;
    }

    static String listToString(ArrayList<String> shabda) {
        shabda.join("")
    }

}
