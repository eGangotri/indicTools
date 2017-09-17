package com.egangotri.transliteration.fromSLP

import org.apache.commons.lang3.StringUtils

import static com.egangotri.constants.SLPConstants.*

/**
 * Created by user on 6/4/2016.
 */
class SLPToIPA {
    public static String transform(String transformed) {

        transformed = StringUtils.replacePattern(transformed,"F", "ɹ̩ː");
        transformed = StringUtils.replacePattern(transformed,"f","ɹ");
        transformed = StringUtils.replacePattern(transformed,"X","l̩ː");
        transformed = StringUtils.replacePattern(transformed,"x","l̩");

        transformed = StringUtils.replacePattern(transformed, "E", "aːi");
        transformed = StringUtils.replacePattern(transformed,"O", "aːu");
        transformed = StringUtils.replacePattern(transformed, "e", "eː");
        transformed = StringUtils.replacePattern(transformed, "o", "oː");



        transformed = StringUtils.replacePattern(transformed, "A", "ɑː");
        transformed = StringUtils.replacePattern(transformed, 'a', 'ə')

        transformed = StringUtils.replacePattern(transformed, "I", "iː");
        transformed = StringUtils.replacePattern(transformed, 'i', 'i')

        transformed = StringUtils.replacePattern(transformed,"U", "uː");
        transformed = StringUtils.replacePattern(transformed,"u", "u");


        transformed = StringUtils.replacePattern(transformed,"H", "h");
        transformed = StringUtils.replacePattern(transformed,"M", "ⁿ");


        transformed = StringUtils.replacePattern(transformed,'~', '̃')

        transformed = StringUtils.replacePattern(transformed, KHA, 'kʰ')
        transformed = StringUtils.replacePattern(transformed,KA, 'k')
        transformed = StringUtils.replacePattern(transformed,GHA,'gʰ')
        transformed = StringUtils.replacePattern(transformed,GA,'g')
        transformed = StringUtils.replacePattern(transformed,ANGA, 'ŋ')

        transformed = StringUtils.replacePattern(transformed,CHHA, 'tʃʰ')
        transformed = StringUtils.replacePattern(transformed,CHA,'tʃ')
        transformed = StringUtils.replacePattern(transformed,JHA,'dʒʱ')
        transformed = StringUtils.replacePattern(transformed,JA, 'dʒ')
        transformed = StringUtils.replacePattern(transformed,YAN, 'ɲ')

        transformed = StringUtils.replacePattern(transformed,THA_HARD, 'ʈʰ')
        transformed = StringUtils.replacePattern(transformed, TA_HARD, 'ʈ')
        transformed = StringUtils.replacePattern(transformed,DHA_HARD, 'ɖʰ')
        transformed = StringUtils.replacePattern(transformed,DA_HARD, 'ɖ')
        transformed = StringUtils.replacePattern(transformed,NA_RAJASTHANI,'ɳ')

        transformed = StringUtils.replacePattern(transformed,THA_SOFT, 't̪ʰ' )
        transformed = StringUtils.replacePattern(transformed,TA_SOFT, 't̪');
        transformed = StringUtils.replacePattern(transformed,DHA_SOFT, 'd̪ʰ')
        transformed = StringUtils.replacePattern(transformed,DA_SOFT,'d̪')
        transformed = StringUtils.replacePattern(transformed,NA, 'n')

        transformed = StringUtils.replacePattern(transformed,PHA,'pʰ')
        transformed = StringUtils.replacePattern(transformed,PA, 'p')
        transformed = StringUtils.replacePattern(transformed,BHA, 'bʰ')
        transformed = StringUtils.replacePattern(transformed, BA, 'b')
        transformed = StringUtils.replacePattern(transformed,MA, 'm')

        transformed = StringUtils.replacePattern(transformed,YA, 'j')
        transformed = StringUtils.replacePattern(transformed,RA, 'r')
        transformed = StringUtils.replacePattern(transformed,LA,'l')
        transformed = StringUtils.replacePattern(transformed,VA, 'ʋ' )

        transformed = StringUtils.replacePattern(transformed,SHA, 'ʃ')
        transformed = StringUtils.replacePattern(transformed,SHA_RETROFLEX, 'ʂ')
        transformed = StringUtils.replacePattern(transformed,SA,'s')
        transformed = StringUtils.replacePattern(transformed,HA, 'ɦ')

        /*     transformed = StringUtils.replacePattern(transformed,'kʃ', 'kz')
             transformed = StringUtils.replacePattern(transformed,'t̪ɾ', 'tr')
             transformed = StringUtils.replacePattern(transformed,'gj', 'jY')
             transformed = StringUtils.replacePattern(transformed,'ɕc', 'Sr')*/
        transformed = StringUtils.replacePattern(transformed,K_WITH_NUKTA, 'q' )
        transformed = StringUtils.replacePattern(transformed, KH_WITH_NUKTA, 'x')
        transformed = StringUtils.replacePattern(transformed,G_WITH_NUKTA, 'ɣ')
        transformed = StringUtils.replacePattern(transformed, Z_WITH_NUKTA, 'z')
        transformed = StringUtils.replacePattern(transformed,F_WITH_NUKTA, 'f')

        transformed = StringUtils.replacePattern(transformed,T_SOFT_WITH_NUKTA, 't̪') //त़      "त़" /त़/
        transformed = StringUtils.replacePattern(transformed,DH_HARD_WITH_BINDI, 'ɽʱ')

        transformed = StringUtils.replacePattern(transformed,D_HARD__WITH_BINDI, 'ɽ')

        transformed = StringUtils.replacePattern(transformed,D_SOFT_WITH_NUKTA, 'XXX')
        transformed = StringUtils.replacePattern(transformed,S_SOFT_WITH_NUKTA, 'XXX')
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
