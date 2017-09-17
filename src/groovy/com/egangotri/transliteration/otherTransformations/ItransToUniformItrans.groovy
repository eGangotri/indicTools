package com.egangotri.transliteration.otherTransformations

import groovy.util.logging.Slf4j
import org.apache.commons.lang3.StringUtils

@Slf4j
class ItransToUniformItrans
{

    /*
     * This Class replaces alternative Itrans Encodings for a given String to
     * only One Uniform Kind of Itrans so that conversion to SLP is easier. For
     * example 'aa' can be written as 'aa' and 'A' but here we replace all 'aa'
     * to A only
     */
    static String transform(String transformed)
    {
        //log.info("I2UI before " + transformed)
        transformed = StringUtils.replacePattern(transformed,"x", "kSh")
        transformed = StringUtils.replacePattern(transformed,"GY", "j~n")
        transformed = StringUtils.replacePattern(transformed,"dny", "j~n")
        transformed = StringUtils.replacePattern(transformed,"w", "v")
        transformed = StringUtils.replacePattern(transformed,"[\\.][a]", "'") // avagraha
        transformed = StringUtils.replacePattern(transformed,"aa", "A")
        transformed = StringUtils.replacePattern(transformed,"ii", "I")// what will happen if
                                                        // user inputs RRii
                                                        // implying
        // RRI-kaar ikaar but will end up reading RRI-kaar
        transformed = StringUtils.replacePattern(transformed,"uu", "U")

        transformed = StringUtils.replacePattern(transformed,"R\\^i", "RRi")
        transformed = StringUtils.replacePattern(transformed,"R\\^I", "RRI")
        transformed = StringUtils.replacePattern(transformed,"L\\^i", "LLi")
        transformed = StringUtils.replacePattern(transformed,"L\\^I", "LLI")
        transformed = StringUtils.replacePattern(transformed,"Ch", "C") // must be above
                                                            // .replaceAll("ch","c")
        transformed = StringUtils.replacePattern(transformed,"ch", "c")

        transformed = StringUtils.replacePattern(transformed,"N\\^", "~N")
        transformed = StringUtils.replacePattern(transformed,"JN", "~n")

        transformed = StringUtils.replacePattern(transformed,"w", "v")


        transformed = StringUtils.replacePattern(transformed,"\\.n", "M")
        transformed = StringUtils.replacePattern(transformed,"\\.m", "M")
        // difficulty handling the dot, special regex meaning ..... 3MAR05 taken
        // care of using \\
        //log.info("I2UI after = " + transformed )
        return transformed
    }
}
