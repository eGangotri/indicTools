package com.egangotri.util

/**
 * Created by user on 5/22/2016.
 */
class TransliteratorUtil {

    static String inputDefault = Constants.ITRANS
    static String output1Default = Constants.UNICODE_DVN
    static String output2Default = Constants.IAST

    static getAllEncodings(){
        return Constants.ENCODINGS.toArray()
    }

    static getAvailableEncodings(List usedEncodings){
        if(usedEncodings){
            return Constants.ENCODINGS - usedEncodings
        }
    }
}

