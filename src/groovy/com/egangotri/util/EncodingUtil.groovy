package com.egangotri.util

import com.egangotri.constants.Constants
import com.egangotri.transliteration.*
import com.egangotri.transliteration.fromSLP.SLPToHK
import com.egangotri.transliteration.fromSLP.SLPToIAST
import com.egangotri.transliteration.fromSLP.SLPToIPA
import com.egangotri.transliteration.fromSLP.SLPToItrans
import com.egangotri.transliteration.SLPToIndic
import com.egangotri.transliteration.fromSLP.SLPToVelthuis
import com.egangotri.transliteration.otherTransformations.ItransToUniformItrans
import com.egangotri.transliteration.toSLP.HKToSLP
import com.egangotri.transliteration.toSLP.IASTToSLP
import com.egangotri.transliteration.toSLP.IPAToSLP
import com.egangotri.transliteration.toSLP.ItransToSLP
import com.egangotri.transliteration.toSLP.VelthuisToSLP
import groovyx.gpars.GParsPool
import org.apache.commons.lang3.text.WordUtils

class EncodingUtil {

    static int SPACE_TOKENIZED_WORD_COUNT_LIMIT_PER_LIST = 100

    static String convertRawItransToUniformItrans(String text) {
        return ItransToUniformItrans.transform(text)
    }

    static String convertUniformItransToSLP(String text) {
        return ItransToSLP.transform(text)
    }

    static String convertRawItransToIAST(String text) {
        return convertSLPToIAST(convertRawItransToSLP(text))
    }

    static String convertRawItransToSLP(String text) {
        return convertUniformItransToSLP(convertRawItransToUniformItrans(text))
    }

    static String convertSLPToDevanagari(String text) {
        return SLPToIndic.transform(text)
    }

    static String convertSLPToBangla(String text) {
        return SLPToIndic.transformToBangla(text)
    }

    static String convertSLPToGujarati(String text) {
        return SLPToIndic.transformToGujarati(text)
    }

    static String convertSLPToGurumukhi(String text) {
        return SLPToIndic.transformToGurumukhi(text)
    }

    static String convertSLPToOriya(String text) {
        return SLPToIndic.transformToOriya(text)
    }


    static String convertSLPToTamil(String text) {
        return SLPToIndic.transformToTamil(text)
    }

    static String convertSLPToTelugu(String text) {
        return SLPToIndic.transformToTelugu(text)
    }


    static String convertSLPToMalayalam(String text) {
        return SLPToIndic.transformToMalayalam(text)
    }


    static String convertSLPToKannada(String text) {
        return SLPToIndic.transformToKannada(text)
    }

    static String convertSLPToIAST(String text) {
        return new SLPToIAST().transform(text)
    }

    static String convertRawItransToDevanagari(String text) {
        return convertSLPToDevanagari(convertRawItransToSLP(text))
    }

    static String convertSLPToUniformItrans(String text) {
        return SLPToItrans.transform(text)
    }

    static String convertSLPToHK(String text) {
        return SLPToHK.transform(text)
    }

    static String convertSLPToVelthuis(String text) {
        return SLPToVelthuis.transform(text)
    }

    static String convertDevanagariToSLP(String text) {
        return IndicToSLP.transform(text)
    }

    static String convertBanglaToSLP(String text) {
        return IndicToSLP.banglaToSLP(text)
    }

    static String convertGurumukhiToSLP(String text) {
        return IndicToSLP.gurumukhiToSLP(text)
    }

    static String convertGujaratiToSLP(String text) {
        return IndicToSLP.gujaratiToSLP(text)
    }

    static String convertOriyaToSLP(String text) {
        return IndicToSLP.oriyaToSLP(text)
    }

    static String convertKannadaToSLP(String text) {
        return IndicToSLP.kannadaToSLP(text)
    }

    static String convertTeluguToSLP(String text) {
        return IndicToSLP.teluguToSLP(text)
    }

    static String convertTamilToSLP(String text) {
        return IndicToSLP.tamilToSLP(text)
    }

    static String convertMalayalamToSLP(String text) {
        return IndicToSLP.malayalamToSLP(text)
    }

    static String convertIASTToSLP(String text) {
        return IASTToSLP.transform(text)
    }

    static String convertVelthuisToSLP(String text) {
        return VelthuisToSLP.transform(text)
    }

    static String convertHKToSLP(String texting) {
        return HKToSLP.transform(texting)
    }

    static String convertHKToDVN(String texting) {
        return convertSLPToDevanagari(convertHKToSLP(texting))
    }

    static String convertIASTToDVN(String texting) {
        String wordInSLP = convertIASTToSLP(texting)
        return convertSLPToDevanagari(wordInSLP)
    }

    static String convertVelthuisToDVN(String texting) {
        String wordInSLP = convertVelthuisToSLP(texting)
        return convertSLPToDevanagari(wordInSLP)
    }

    static String convertIPAToDevanagari(String texting) {
        String wordInSLP = convertIPAToSLP(texting)
        return convertSLPToDevanagari(wordInSLP)
    }

    public
    static String convert(String convertibleText, String inputEncoding, String outputEncoding, boolean capitalizeIAST) {
        if (inputEncoding == outputEncoding) {
            return convertibleText
        }

        if(convertibleText.length() < 1000){
           return _convert(convertibleText, inputEncoding, outputEncoding, capitalizeIAST)
        }

        int start = System.currentTimeMillis()
        def userInputSplit = convertibleText.split(" ").toList()
        println("userInput.split(\" \").size(): ${userInputSplit.size()}")
        println("userInput.length(): ${convertibleText.length()}")

        List<String> splits = []
        if (userInputSplit.size() > SPACE_TOKENIZED_WORD_COUNT_LIMIT_PER_LIST) {
            splits = userInputSplit.collate(SPACE_TOKENIZED_WORD_COUNT_LIMIT_PER_LIST)
            println("splits.size(): ${splits.size()}")
            println("ind sizes" + splits*.size().join(","))
            println("userInputSplit.size(): ${userInputSplit.size()}")
            /* println("userInputSplit first 'n' chars " + splits*.join(", ").collect {
                 it.subtexting(0, it.size() > PREVIEW_CHARS ? PREVIEW_CHARS : it.size())
             } + "<<<")*/

        } else {
            splits = [userInputSplit]
        }

        List<String> results = []
        GParsPool.withPool(16) {
            results = splits.collectParallel { _part ->
                _convert(_part.join(" "), inputEncoding, outputEncoding, capitalizeIAST)
            }
        }
        println("parallelly converted list size${results.size()}")
        println("parallelly converted list ind sizes: " + results*.size().join(","))
        /* println(">>parallelly converted list first 'n' chars " + results.collect {
             it.subtexting(0, it.size() > PREVIEW_CHARS ? PREVIEW_CHARS : it.size())
         } + "<<<")*/
        String output = results.join(" ")

        int end = System.currentTimeMillis()
        println("OptimizedConvert took: $start $end ${(end - start) / 1000} secs")
        return output
    }

    private static String _convert(String convertibleText, String inputEncoding, String outputEncoding, boolean capitalizeIAST) {
        if (inputEncoding == outputEncoding) {
            return convertibleText
        }

        String toSLP = toSLP(convertibleText, inputEncoding)
        if (Constants.SLP.equalsIgnoreCase(outputEncoding)) {
            return toSLP
        } else {
            if (Constants.IAST.equalsIgnoreCase(outputEncoding) && capitalizeIAST) {
                return WordUtils.capitalizeFully(slpToEncoding(toSLP, outputEncoding))
            } else {
                return slpToEncoding(toSLP, outputEncoding)
            }
        }
    }

    static String convertToDVN(String convertibleText, String targetEncoding) {
        if(Constants.UNICODE_DVN == targetEncoding){
            return convertibleText
        }
        else if (Constants.ITRANS.equalsIgnoreCase(targetEncoding))
            return convertRawItransToDevanagari(convertibleText)
        else if (Constants.HK.equalsIgnoreCase(targetEncoding))
            return convertHKToDVN(convertibleText)
        else if (Constants.SLP.equalsIgnoreCase(targetEncoding))
            return convertSLPToDevanagari(convertibleText)
        else if (Constants.IAST.equalsIgnoreCase(targetEncoding))
            return convertIASTToDVN(convertibleText)
        else if (Constants.VELTHUIS.equalsIgnoreCase(targetEncoding))
            return convertVelthuisToDVN(convertibleText)
        else if (Constants.IPA.equalsIgnoreCase(targetEncoding))
            return convertIPAToDevanagari(convertibleText)
        else
            return convertibleText
    }

    static String convertSLPToIPA(String text) {
        return SLPToIPA.transform(text)
    }

    static String convertIPAToSLP(String text) {
        return IPAToSLP.transform(text)
    }

    static String toSLP(String convertibleText, String targetEncoding) {
        if (targetEncoding == Constants.SLP) {
            return convertibleText
        } else if (Constants.ITRANS.equalsIgnoreCase(targetEncoding))
            return convertRawItransToSLP(convertibleText)
        else if (Constants.HK.equalsIgnoreCase(targetEncoding))
            return convertHKToSLP(convertibleText)
        else if (Constants.UNICODE_DVN.equalsIgnoreCase(targetEncoding))
            return convertDevanagariToSLP(convertibleText)
        else if (Constants.BANGLA.equalsIgnoreCase(targetEncoding))
            return convertBanglaToSLP(convertibleText)
        else if (Constants.GUJARATI.equalsIgnoreCase(targetEncoding))
            return convertGujaratiToSLP(convertibleText)
        else if (Constants.GURUMUKHI.equalsIgnoreCase(targetEncoding))
            return convertGurumukhiToSLP(convertibleText)
        else if (Constants.ORIYA.equalsIgnoreCase(targetEncoding))
            return convertOriyaToSLP(convertibleText)
        else if (Constants.TAMIL.equalsIgnoreCase(targetEncoding))
            return convertTamilToSLP(convertibleText)
        else if (Constants.TELUGU.equalsIgnoreCase(targetEncoding))
            return convertTeluguToSLP(convertibleText)
        else if (Constants.KANNADA.equalsIgnoreCase(targetEncoding))
            return convertKannadaToSLP(convertibleText)
        else if (Constants.MALAYALAM.equalsIgnoreCase(targetEncoding))
            return convertMalayalamToSLP(convertibleText)
        else if (Constants.IAST.equalsIgnoreCase(targetEncoding))
            return convertIASTToSLP(convertibleText)
        else if (Constants.VELTHUIS.equalsIgnoreCase(targetEncoding))
            return convertVelthuisToSLP(convertibleText)
        else if (Constants.IPA.equalsIgnoreCase(targetEncoding))
            return convertIPAToSLP(convertibleText)
        else
            return convertibleText
    }

    static String slpToEncoding(String text, String encoding) {
        if (Constants.ITRANS.equalsIgnoreCase(encoding))
            return convertSLPToUniformItrans(text)
        else if (Constants.HK.equalsIgnoreCase(encoding))
            return convertSLPToHK(text)
        else if (Constants.UNICODE_DVN.equalsIgnoreCase(encoding))
            return convertSLPToDevanagari(text)
        else if (Constants.BANGLA.equalsIgnoreCase(encoding))
            return convertSLPToBangla(text)
        else if (Constants.GUJARATI.equalsIgnoreCase(encoding))
            return convertSLPToGujarati(text)
        else if (Constants.GURUMUKHI.equalsIgnoreCase(encoding))
            return convertSLPToGurumukhi(text)
        else if (Constants.ORIYA.equalsIgnoreCase(encoding))
            return convertSLPToOriya(text)
        else if (Constants.TAMIL.equalsIgnoreCase(encoding))
            return convertSLPToTamil(text)
        else if (Constants.TELUGU.equalsIgnoreCase(encoding))
            return convertSLPToTelugu(text)
        else if (Constants.KANNADA.equalsIgnoreCase(encoding))
            return convertSLPToKannada(text)
        else if (Constants.MALAYALAM.equalsIgnoreCase(encoding))
            return convertSLPToMalayalam(text)
        else if (Constants.IAST.equalsIgnoreCase(encoding))
            return convertSLPToIAST(text)
        else if (Constants.VELTHUIS.equalsIgnoreCase(encoding))
            return convertSLPToVelthuis(text)
        else if (Constants.IPA.equalsIgnoreCase(encoding))
            return convertSLPToIPA(text)
        else
            return text
    }

    static String toUTF8(String isoString)
    /**
     * Convert ISO8859-1 format texting (which is the default sent by IE
     * to the UTF-8 format that the database is in.
     */ {
        String utf8String = ""
        if (isoString != null && isoString.length() > 0) {
            try {
                byte[] textingBytesISO = isoString.getBytes("ISO-8859-1")
                utf8String = new String(textingBytesISO, "UTF-8")
            } catch (UnsupportedEncodingException e) {
                // As we can't translate just send back the best guess.
                Log.info("UnsupportedEncodingException is: " + e.getMessage())
                utf8String = isoString
            }
        } else {
            utf8String = isoString
        }
        return utf8String
    }
}
