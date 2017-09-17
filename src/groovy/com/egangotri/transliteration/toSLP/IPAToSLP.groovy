package com.egangotri.transliteration.toSLP

import com.egangotri.constants.SLPConstants
import org.apache.commons.lang3.StringUtils

/**
 * Created by user on 6/3/2016.
 */
class IPAToSLP {
    public static String transform(String transformed) {

        transformed = StringUtils.replacePattern(transformed,"ɹ̩ː", "F");
        transformed = StringUtils.replacePattern(transformed,"ɹ", "f");
        transformed = StringUtils.replacePattern(transformed,"l̩ː", "X");
        transformed = StringUtils.replacePattern(transformed,"l̩","x");

        transformed = StringUtils.replacePattern(transformed,"aːi", "E");
        transformed = StringUtils.replacePattern(transformed,"aːu", "O");
        transformed = StringUtils.replacePattern(transformed,"eː", "e");
        transformed = StringUtils.replacePattern(transformed,"oː", "o");



        transformed = StringUtils.replacePattern(transformed,"ɑː", "A");
        transformed = StringUtils.replacePattern(transformed, 'ə','a')

        transformed = StringUtils.replacePattern(transformed,"iː", "I");
        transformed = StringUtils.replacePattern(transformed,'i', 'i')

        transformed = StringUtils.replacePattern(transformed,"uː", "U");
        transformed = StringUtils.replacePattern(transformed,"u", "u");


        transformed = StringUtils.replacePattern(transformed,"h", "H");
        transformed = StringUtils.replacePattern(transformed,"ⁿ", "M");


        transformed = StringUtils.replacePattern(transformed,'̃' , '~')

        transformed = StringUtils.replacePattern(transformed,'kʰ', 'K')
        transformed = StringUtils.replacePattern(transformed,'k', 'k')
        transformed = StringUtils.replacePattern(transformed,'gʰ', 'G')
        transformed = StringUtils.replacePattern(transformed,'g', 'g')
        transformed = StringUtils.replacePattern(transformed,'ŋ', 'N')

        transformed = StringUtils.replacePattern(transformed,'tʃʰ', 'C')
        transformed = StringUtils.replacePattern(transformed,'tʃ','c')
        transformed = StringUtils.replacePattern(transformed,'dʒʱ', 'J')
        transformed = StringUtils.replacePattern(transformed,'dʒ', 'j')
        transformed = StringUtils.replacePattern(transformed,'ɲ', 'Y')

        transformed = StringUtils.replacePattern(transformed,'ʈʰ', 'w')
        transformed = StringUtils.replacePattern(transformed,'ʈ', 'W')
        transformed = StringUtils.replacePattern(transformed,'ɖʰ', 'q')
        transformed = StringUtils.replacePattern(transformed,'ɖ', 'Q')
        transformed = StringUtils.replacePattern(transformed,'ɳ', 'R')

        transformed = StringUtils.replacePattern(transformed,'t̪ʰ', 'T')
        transformed = StringUtils.replacePattern(transformed,'t̪', 't');
        transformed = StringUtils.replacePattern(transformed,'d̪ʰ', 'D')
        transformed = StringUtils.replacePattern(transformed,'d̪', 'd')
        transformed = StringUtils.replacePattern(transformed,'n', 'n')

        transformed = StringUtils.replacePattern(transformed,'pʰ', 'P')
        transformed = StringUtils.replacePattern(transformed,'p', 'p')
        transformed = StringUtils.replacePattern(transformed,'bʰ', 'B')
        transformed = StringUtils.replacePattern(transformed,'b', 'b')
        transformed = StringUtils.replacePattern(transformed,'m', 'm')

        transformed = StringUtils.replacePattern(transformed,'j', 'y')
        transformed = StringUtils.replacePattern(transformed,'r', 'r')
        transformed = StringUtils.replacePattern(transformed,'l','l')
        transformed = StringUtils.replacePattern(transformed,'ʋ', 'v')

        transformed = StringUtils.replacePattern(transformed,'ʃ', 'S')
        transformed = StringUtils.replacePattern(transformed,'ʂ', 'z')
        transformed = StringUtils.replacePattern(transformed,'s', 's')
        transformed = StringUtils.replacePattern(transformed,'ɦ', 'h')

   /*     transformed = StringUtils.replacePattern(transformed,'kʃ', 'kz')
        transformed = StringUtils.replacePattern(transformed,'t̪ɾ', 'tr')
        transformed = StringUtils.replacePattern(transformed,'gj', 'jY')
        transformed = StringUtils.replacePattern(transformed,'ɕc', 'Sr')*/
        transformed = StringUtils.replacePattern(transformed,'q', SLPConstants.K_WITH_NUKTA)
        transformed = StringUtils.replacePattern(transformed,'x', SLPConstants.KH_WITH_NUKTA)
        transformed = StringUtils.replacePattern(transformed,'ɣ', SLPConstants.G_WITH_NUKTA)
        transformed = StringUtils.replacePattern(transformed,'z', SLPConstants.Z_WITH_NUKTA)
        transformed = StringUtils.replacePattern(transformed,'f', SLPConstants.F_WITH_NUKTA)

        transformed = StringUtils.replacePattern(transformed,'t̪', SLPConstants.T_SOFT_WITH_NUKTA) //त़      "त़" /त़/
        transformed = StringUtils.replacePattern(transformed,'ɽʱ', SLPConstants.DH_HARD_WITH_BINDI)

        transformed = StringUtils.replacePattern(transformed,'ɽ', SLPConstants.D_HARD__WITH_BINDI)

        transformed = StringUtils.replacePattern(transformed,'XXX', SLPConstants.D_SOFT_WITH_NUKTA)
        transformed = StringUtils.replacePattern(transformed,'XXX', SLPConstants.S_SOFT_WITH_NUKTA)
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
