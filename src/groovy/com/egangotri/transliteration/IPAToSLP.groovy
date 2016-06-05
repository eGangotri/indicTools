package com.egangotri.transliteration

import com.egangotri.constants.SLPConstants

/**
 * Created by user on 6/3/2016.
 */
class IPAToSLP {
    public static String transform(String transformed) {

        transformed = transformed.replaceAll("ɹ̩ː", "F");
        transformed = transformed.replaceAll("ɹ", "f");
        transformed = transformed.replaceAll("l̩ː", "X");
        transformed = transformed.replaceAll("l̩","x");

        transformed = transformed.replaceAll("aːi", "E");
        transformed = transformed.replaceAll("aːu", "O");
        transformed = transformed.replaceAll("eː", "e");
        transformed = transformed.replaceAll("oː", "o");



        transformed = transformed.replaceAll("ɑː", "A");
        transformed = transformed.replaceAll( 'ə','a')

        transformed = transformed.replaceAll("iː", "I");
        transformed = transformed.replaceAll('i', 'i')

        transformed = transformed.replaceAll("uː", "U");
        transformed = transformed.replaceAll("u", "u");


        transformed = transformed.replaceAll("h", "H");
        transformed = transformed.replaceAll("ⁿ", "M");


        transformed = transformed.replaceAll('̃' , '~')

        transformed = transformed.replaceAll('kʰ', 'K')
        transformed = transformed.replaceAll('k', 'k')
        transformed = transformed.replaceAll('gʰ', 'G')
        transformed = transformed.replaceAll('g', 'g')
        transformed = transformed.replaceAll('ŋ', 'N')

        transformed = transformed.replaceAll('tʃʰ', 'C')
        transformed = transformed.replaceAll('tʃ','c')
        transformed = transformed.replaceAll('dʒʱ', 'J')
        transformed = transformed.replaceAll('dʒ', 'j')
        transformed = transformed.replaceAll('ɲ', 'Y')

        transformed = transformed.replaceAll('ʈʰ', 'w')
        transformed = transformed.replaceAll('ʈ', 'W')
        transformed = transformed.replaceAll('ɖʰ', 'q')
        transformed = transformed.replaceAll('ɖ', 'Q')
        transformed = transformed.replaceAll('ɳ', 'R')

        transformed = transformed.replaceAll('t̪ʰ', 'T')
        transformed = transformed.replaceAll('t̪', 't');
        transformed = transformed.replaceAll('d̪ʰ', 'D')
        transformed = transformed.replaceAll('d̪', 'd')
        transformed = transformed.replaceAll('n', 'n')

        transformed = transformed.replaceAll('pʰ', 'P')
        transformed = transformed.replaceAll('p', 'p')
        transformed = transformed.replaceAll('bʰ', 'B')
        transformed = transformed.replaceAll('b', 'b')
        transformed = transformed.replaceAll('m', 'm')

        transformed = transformed.replaceAll('j', 'y')
        transformed = transformed.replaceAll('r', 'r')
        transformed = transformed.replaceAll('l','l')
        transformed = transformed.replaceAll('ʋ', 'v')

        transformed = transformed.replaceAll('ʃ', 'S')
        transformed = transformed.replaceAll('ʂ', 'z')
        transformed = transformed.replaceAll('s', 's')
        transformed = transformed.replaceAll('ɦ', 'h')

   /*     transformed = transformed.replaceAll('kʃ', 'kz')
        transformed = transformed.replaceAll('t̪ɾ', 'tr')
        transformed = transformed.replaceAll('gj', 'jY')
        transformed = transformed.replaceAll('ɕc', 'Sr')*/
        transformed = transformed.replaceAll('q', SLPConstants.K_WITH_NUKTA)
        transformed = transformed.replaceAll('x', SLPConstants.KH_WITH_NUKTA)
        transformed = transformed.replaceAll('ɣ', SLPConstants.G_WITH_NUKTA)
        transformed = transformed.replaceAll('z', SLPConstants.Z_WITH_NUKTA)
        transformed = transformed.replaceAll('f', SLPConstants.F_WITH_NUKTA)

        transformed = transformed.replaceAll('t̪', SLPConstants.T_SOFT_WITH_NUKTA) //त़      "त़" /त़/
        transformed = transformed.replaceAll('ɽʱ', SLPConstants.DH_HARD_WITH_BINDI)

        transformed = transformed.replaceAll('ɽ', SLPConstants.D_HARD__WITH_BINDI)

        transformed = transformed.replaceAll('XXX', SLPConstants.D_SOFT_WITH_NUKTA)
        transformed = transformed.replaceAll('XXX', SLPConstants.S_SOFT_WITH_NUKTA)
    }

    static main(def args) {
        String str = """
əɦəm ɑːd̪irɦiː bʰuːt̪ɑːnɑːm mət̪tə̪h sərvəmeːvə prəvərt̪ət̪eː d̪ʰərmoː rəkʂət̪i rəkʂət̪h səⁿ ə:
 əⁿ mɑː̃ xə ɣə zə t̪ə़ d̪ə़ .fə sə़  x ɣ z t̪ə़् d̪ə़् .f sə़्  t̪ə़ qə  .ɕə zə ɽə ɽʱə ɖə ɖ  kʂə t̪rə ɟɲə sɑːɳɽʱə səɽəkə
            """
        println str
        println transform(str)
    }
}
