package com.egangotri.util

import com.egangotri.constants.Constants

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

    public static void main(String[] args) throws IOException {

        String inputEncoding = Constants.IAST
        String outputEncoding = Constants.UNICODE_DVN
        boolean capitalizeIAST = false
        String userInput = """
iti śrītaṃtraciṃtāmaṇau sṛṣṭikramanirūpaṇātmakaḥ prathamaprakāśaḥ
iti śrītaṃtraciṃtāmaṇau sṛṣṭikramanirūpaṇātmakaḥ prathamaprakāśaḥ
"""
        String output = EncodingUtil.convert(userInput, inputEncoding, outputEncoding, capitalizeIAST)
        args = ["C:\\tmp\\tntrlk1_14.txt"]
        if(args?.size() == 1){
            File inputFile =  new File(args.first())
            userInput = inputFile.getText('UTF-8')
            int lastIndexOfDot = inputFile.name.lastIndexOf('.')
            String fileBareName = inputFile.name.substring(0,lastIndexOfDot)
            String newName = inputFile.parent + File.separator + fileBareName + "-cnv" + inputFile.name.substring(lastIndexOfDot, inputFile.name.size())
            println(newName)
            File outputFile = new File(newName)
            output = EncodingUtil.convert(userInput, inputEncoding, outputEncoding, capitalizeIAST)
            outputFile << output
            println("Finished writting to File")

        }
        println(output)
        System.exit(0)

    }
}

