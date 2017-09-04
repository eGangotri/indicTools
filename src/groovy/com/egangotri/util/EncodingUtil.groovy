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

    static String getRawItransInput(String alter) {
        return alter
    }

    static String convertRawItransToUniformItrans(String alter) {
        return ItransToUniformItrans.transform(alter)
    }

    static String convertUniformItransToSLP(String alter) {
        return ItransToSLP.transform(alter)
    }

    static String convertRawItransToIAST(String alter) {
        return convertSLPToIAST(convertRawItransToSLP(alter))
    }

    static String convertRawItransToSLP(String alter) {
        return convertUniformItransToSLP(convertRawItransToUniformItrans(alter))
    }

    static String convertHLToIAST(String alter) {
        return convertSLPToIAST(convertHKToSLP(alter))
    }

    static String convertSLPToDevanagari(String alter) {
        return (new SLPToDevanagari()).transform(alter)
        // return (new SLPToBangla()).transform(alter)
    }

    static String convertSLPToIAST(String alter) {
        return new SLPToIAST().transform(alter)
    }


    static String convertUniformItransToDevanagari(String alter) {
        return convertSLPToDevanagari(convertUniformItransToSLP(alter))
    }

    static String convertRawItransToDevanagari(String alter) {
        return convertSLPToDevanagari(convertRawItransToSLP(alter))
    }

    static String convertSLPToUniformItrans(String alter) {
        return SLPToItrans.transform(alter)
    }

    static String convertSLPToHK(String alter) {
        return SLPToHK.transform(alter)
    }

    static String convertSLPToVelthuis(String alter) {
        return SLPToVelthuis.transform(alter)
    }

    static String convertDevanagariToSLP(String alter) {
        return new DvnToSLP().transform(alter)
    }

    static String convertDevanagariToUniformItrans(String alter) {
        return convertSLPToUniformItrans(convertDevanagariToSLP(alter))
    }

    static String convertIASTToSLP(String alter) {
        return IASTToSLP.transform(alter)
    }

    static String convertVelthuisToSLP(String alter) {
        return VelthuisToSLP.transform(alter)
    }

    static String convertIASTToUniformItrans(String alter) {
        return convertSLPToUniformItrans(convertIASTToSLP(alter))
    }

    static String convertHKToSLP(String string) {
        return HKToSLP.transform(string)
    }


    static String convertHKToIAST(String string) {
        return convertSLPToIAST(convertHKToSLP(string))
    }

    static String convertVelthuisToIAST(String string) {
        return convertSLPToIAST(convertVelthuisToSLP(string))
    }

    static String convertHKToDVN(String string) {
        return convertSLPToDevanagari(convertHKToSLP(string))
    }

    static String convertDVNToIAST(String string) {
        String wordInSLP = convertDevanagariToSLP(string)
        return convertSLPToIAST(wordInSLP)
    }

    static String convertIASTToDVN(String string) {
        String wordInSLP = convertIASTToSLP(string)
        return convertSLPToDevanagari(wordInSLP)
    }

    static String convertVelthuisToDVN(String string) {
        String wordInSLP = convertVelthuisToSLP(string)
        return convertSLPToDevanagari(wordInSLP)
    }

    static String convertIPAToDevanagari(String string) {
        String wordInSLP = convertIPAToSLP(string)
        return convertSLPToDevanagari(wordInSLP)
    }

    public
    static String convert(String convertibleText, String inputEncoding, String outputEncoding, boolean capitalizeIAST) {
        if (inputEncoding == outputEncoding) {
            return convertibleText
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
                 it.substring(0, it.size() > PREVIEW_CHARS ? PREVIEW_CHARS : it.size())
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
             it.substring(0, it.size() > PREVIEW_CHARS ? PREVIEW_CHARS : it.size())
         } + "<<<")*/
        String output = results.join(" ")

        int end = System.currentTimeMillis()
        println("OptimizedConvert took: $start $end ${(end - start) / 1000} secs")
        return output
    }

    private
    static String _convert(String convertibleText, String inputEncoding, String outputEncoding, boolean capitalizeIAST) {
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

    static String convertSLPToIPA(String str) {
        return SLPToIPA.transform(str)
    }

    static String convertIPAToSLP(String str) {
        return IPAToSLP.transform(str)
    }

    static String convertDevanagariToIPA(String str) {
        return DevangariToIPA.transform(str)
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

    static String convertSLPToEncoding(String str, String encoding) {
        if (Constants.ITRANS.equalsIgnoreCase(encoding))
            return convertSLPToUniformItrans(str)
        else if (Constants.HK.equalsIgnoreCase(encoding))
            return convertSLPToHK(str)
        else if (Constants.UNICODE_DVN.equalsIgnoreCase(encoding))
            return convertSLPToDevanagari(str)
        else if (Constants.IAST.equalsIgnoreCase(encoding))
            return convertSLPToIAST(str)
        else if (Constants.VELTHUIS.equalsIgnoreCase(encoding))
            return convertSLPToVelthuis(str)
        else if (Constants.IPA.equalsIgnoreCase(encoding))
            return convertSLPToIPA(str)
        else
            return str
    }

    static String convertToIAST(String str, String encoding) {
        if (Constants.ITRANS.equalsIgnoreCase(encoding))
            return convertRawItransToIAST(str)
        else if (Constants.HK.equalsIgnoreCase(encoding))
            return convertHKToIAST(str)
        else if (Constants.SLP.equalsIgnoreCase(encoding))
            return convertSLPToIAST(str)
        else if (Constants.UNICODE_DVN.equalsIgnoreCase(encoding))
            return convertDVNToIAST(str)
        else if (Constants.HK.equalsIgnoreCase(encoding))
            return convertHKToIAST(str)
        else if (Constants.VELTHUIS.equalsIgnoreCase(encoding))
            return convertVelthuisToIAST(str)
        else return str
    }

    static String toUTF8(String isoString)
    /**
     * Convert ISO8859-1 format string (which is the default sent by IE
     * to the UTF-8 format that the database is in.
     */ {
        String utf8String = ""
        if (isoString != null && isoString.length() > 0) {
            try {
                byte[] stringBytesISO = isoString.getBytes("ISO-8859-1")
                utf8String = new String(stringBytesISO, "UTF-8")
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
