package com.egangotri.util

import com.egangotri.constants.Constants
import groovyx.gpars.GParsPool

/**
 * Created by user on 5/22/2016.
 */
class TransliteratorUtil {

    static String inputDefault = Constants.ITRANS
    static String output1Default = Constants.UNICODE_DVN
    static String output2Default = Constants.IAST
    //Benchmark Results for 15K, was 83.88 seconds.
    // For 5K was 23.83 seconds
    // For 1000 8.3 Seconds
    //For 500 5.35 Seconds
    //For 100 3.884 secs
    //For 50  3.913 secs

    static getAllEncodings() {
        return Constants.ENCODINGS.toArray()
    }

    static getAvailableEncodings(List usedEncodings) {
        if (usedEncodings) {
            return Constants.ENCODINGS - usedEncodings
        }
    }

    public static void main(String[] args) throws IOException {

        String inputEncoding = Constants.IAST
        String outputEncoding = Constants.UNICODE_DVN
        boolean capitalizeIAST = false
        args = ["C:\\hw\\bigDataForSkt\\psv.txt"]
        int start = System.currentTimeMillis()
        if (args?.size() == 1) {
            File inputFile = new File(args.first())
            String userInput = inputFile.getText('UTF-8')
            int lastIndexOfDot = inputFile.name.lastIndexOf('.')
            String fileBareName = inputFile.name.substring(0, lastIndexOfDot)
            String newName = inputFile.parent + File.separator + fileBareName + "-cnv" + inputFile.name.substring(lastIndexOfDot, inputFile.name.size())
            println("newName: $newName")
            File outputFile = new File(newName)
            outputFile << EncodingUtil.convert(userInput, inputEncoding, outputEncoding, capitalizeIAST)
            println("Finished writting to File: " /*+ output*/)

            int end = System.currentTimeMillis()
            println( "$start $end ${(end-start)/1000} secs")
        }
        //println(output.substring(0,10))
        System.exit(0)

    }
}

