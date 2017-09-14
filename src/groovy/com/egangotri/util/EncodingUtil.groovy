package com.egangotri.util

import com.egangotri.constants.Constants
import com.egangotri.transliteration.*
import groovyx.gpars.GParsPool
import org.apache.commons.lang3.text.WordUtils

class EncodingUtil {

    static int SPACE_TOKENIZED_WORD_COUNT_LIMIT_PER_LIST = 100
    static int PREVIEW_CHARS = 12

    EncodingUtil() {
    }

    static String getRawItransInput(String text) {
        return text
    }

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

    static String convertHLToIAST(String text) {
        return convertSLPToIAST(convertHKToSLP(text))
    }

    static String convertSLPToDevanagari(String text) {
        return SLPToUnicode.transform(text)
    }

    static String convertSLPToBangla(String text) {
        return SLPToUnicode.transformToBangla(text)
    }

    static String convertSLPToGujarati(String text) {
        return SLPToUnicode.transformToGujarati(text)
    }

    static String convertSLPToGurumukhi(String text) {
        return SLPToUnicode.transformToGurumukhi(text)
    }

    static String convertSLPToOriya(String text) {
        return SLPToUnicode.transformToOriya(text)
    }


    static String convertSLPToTamil(String text) {
        return SLPToUnicode.transformToTamil(text)
    }

    static String convertSLPToTelugu(String text) {
        return SLPToUnicode.transformToTelugu(text)
    }


    static String convertSLPToMalayalam(String text) {
        return SLPToUnicode.transformToMalayalam(text)
    }


    static String convertSLPToKannada(String text) {
        return SLPToUnicode.transformToKannada(text)
    }

    static String convertSLPToIAST(String text) {
        return new SLPToIAST().transform(text)
    }


    static String convertUniformItransToDevanagari(String text) {
        return convertSLPToDevanagari(convertUniformItransToSLP(text))
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
        return new DvnToSLP().transform(text)
    }

    static String convertDevanagariToUniformItrans(String text) {
        return convertSLPToUniformItrans(convertDevanagariToSLP(text))
    }

    static String convertIASTToSLP(String text) {
        return IASTToSLP.transform(text)
    }

    static String convertVelthuisToSLP(String text) {
        return VelthuisToSLP.transform(text)
    }

    static String convertIASTToUniformItrans(String text) {
        return convertSLPToUniformItrans(convertIASTToSLP(text))
    }

    static String convertHKToSLP(String texting) {
        return HKToSLP.transform(texting)
    }


    static String convertHKToIAST(String texting) {
        return convertSLPToIAST(convertHKToSLP(texting))
    }

    static String convertVelthuisToIAST(String texting) {
        return convertSLPToIAST(convertVelthuisToSLP(texting))
    }

    static String convertHKToDVN(String texting) {
        return convertSLPToDevanagari(convertHKToSLP(texting))
    }

    static String convertDVNToIAST(String texting) {
        String wordInSLP = convertDevanagariToSLP(texting)
        return convertSLPToIAST(wordInSLP)
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

        List splits = []
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
                EncodingUtil._convert(_part.join(" "), inputEncoding, outputEncoding, capitalizeIAST)
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

        String toSLP = convertToSLP(convertibleText, inputEncoding)
        if (Constants.SLP.equalsIgnoreCase(outputEncoding)) {
            return toSLP
        } else {
            if (Constants.IAST.equalsIgnoreCase(outputEncoding) && capitalizeIAST) {
                return WordUtils.capitalizeFully(convertSLPToEncoding(toSLP, outputEncoding))
            } else {
                return convertSLPToEncoding(toSLP, outputEncoding)
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

    static String convertDevanagariToIPA(String text) {
        return DevangariToIPA.transform(text)
    }

    static String convertToSLP(String convertibleText, String targetEncoding) {
        if (targetEncoding == Constants.SLP) {
            return convertibleText
        } else if (Constants.ITRANS.equalsIgnoreCase(targetEncoding))
            return convertRawItransToSLP(convertibleText)
        else if (Constants.HK.equalsIgnoreCase(targetEncoding))
            return convertHKToSLP(convertibleText)
        else if (Constants.UNICODE_DVN.equalsIgnoreCase(targetEncoding))
            return convertDevanagariToSLP(convertibleText)
        else if (Constants.IAST.equalsIgnoreCase(targetEncoding))
            return convertIASTToSLP(convertibleText)
        else if (Constants.VELTHUIS.equalsIgnoreCase(targetEncoding))
            return convertVelthuisToSLP(convertibleText)
        else if (Constants.IPA.equalsIgnoreCase(targetEncoding))
            return convertIPAToSLP(convertibleText)
        else
            return convertibleText
    }

    static String convertSLPToEncoding(String text, String encoding) {
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

    static String convertToIAST(String text, String encoding) {
        if (Constants.ITRANS.equalsIgnoreCase(encoding))
            return convertRawItransToIAST(text)
        else if (Constants.HK.equalsIgnoreCase(encoding))
            return convertHKToIAST(text)
        else if (Constants.SLP.equalsIgnoreCase(encoding))
            return convertSLPToIAST(text)
        else if (Constants.UNICODE_DVN.equalsIgnoreCase(encoding))
            return convertDVNToIAST(text)
        else if (Constants.HK.equalsIgnoreCase(encoding))
            return convertHKToIAST(text)
        else if (Constants.VELTHUIS.equalsIgnoreCase(encoding))
            return convertVelthuisToIAST(text)
        else return text
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
