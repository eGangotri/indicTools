package com.egangotri.transliteration

import static com.egangotri.constants.SLPConstants.*

/**
 * Created by user on 6/4/2016.
 */
class SLPToIPA {
    public static String transform(String transformed) {

        transformed = transformed.replaceAll("F", "ɹ̩ː");
        transformed = transformed.replaceAll("f","ɹ");
        transformed = transformed.replaceAll("X","l̩ː");
        transformed = transformed.replaceAll("x","l̩");

        transformed = transformed.replaceAll( "E", "aːi");
        transformed = transformed.replaceAll("O", "aːu");
        transformed = transformed.replaceAll( "e", "eː");
        transformed = transformed.replaceAll( "o", "oː");



        transformed = transformed.replaceAll( "A", "ɑː");
        transformed = transformed.replaceAll( 'a', 'ə')

        transformed = transformed.replaceAll( "I", "iː");
        transformed = transformed.replaceAll( 'i', 'i')

        transformed = transformed.replaceAll("U", "uː");
        transformed = transformed.replaceAll("u", "u");


        transformed = transformed.replaceAll("H", "h");
        transformed = transformed.replaceAll("M", "ⁿ");


        transformed = transformed.replaceAll('~', '̃')

        transformed = transformed.replaceAll( KHA, 'kʰ')
        transformed = transformed.replaceAll(KA, 'k')
        transformed = transformed.replaceAll(GHA,'gʰ')
        transformed = transformed.replaceAll(GA,'g')
        transformed = transformed.replaceAll(ANGA, 'ŋ')

        transformed = transformed.replaceAll(CHHA, 'tʃʰ')
        transformed = transformed.replaceAll(CHA,'tʃ')
        transformed = transformed.replaceAll(JHA,'dʒʱ')
        transformed = transformed.replaceAll(JA, 'dʒ')
        transformed = transformed.replaceAll(YAN, 'ɲ')

        transformed = transformed.replaceAll(THA_HARD, 'ʈʰ')
        transformed = transformed.replaceAll( TA_HARD, 'ʈ')
        transformed = transformed.replaceAll(DHA_HARD, 'ɖʰ')
        transformed = transformed.replaceAll(DA_HARD, 'ɖ')
        transformed = transformed.replaceAll(NA_RAJASTHANI,'ɳ')

        transformed = transformed.replaceAll(THA_SOFT, 't̪ʰ' )
        transformed = transformed.replaceAll(TA_SOFT, 't̪');
        transformed = transformed.replaceAll(DHA_SOFT, 'd̪ʰ')
        transformed = transformed.replaceAll(DA_SOFT,'d̪')
        transformed = transformed.replaceAll(NA, 'n')

        transformed = transformed.replaceAll(PHA,'pʰ')
        transformed = transformed.replaceAll(PA, 'p')
        transformed = transformed.replaceAll(BHA, 'bʰ')
        transformed = transformed.replaceAll( BA, 'b')
        transformed = transformed.replaceAll(MA, 'm')

        transformed = transformed.replaceAll(YA, 'j')
        transformed = transformed.replaceAll(RA, 'r')
        transformed = transformed.replaceAll(LA,'l')
        transformed = transformed.replaceAll(VA, 'ʋ' )

        transformed = transformed.replaceAll(SHA, 'ʃ')
        transformed = transformed.replaceAll(SHA_RETROFLEX, 'ʂ')
        transformed = transformed.replaceAll(SA,'s')
        transformed = transformed.replaceAll(HA, 'ɦ')

        /*     transformed = transformed.replaceAll('kʃ', 'kz')
             transformed = transformed.replaceAll('t̪ɾ', 'tr')
             transformed = transformed.replaceAll('gj', 'jY')
             transformed = transformed.replaceAll('ɕc', 'Sr')*/
        transformed = transformed.replaceAll(K_WITH_NUKTA, 'q' )
        transformed = transformed.replaceAll( KH_WITH_NUKTA, 'x')
        transformed = transformed.replaceAll(G_WITH_NUKTA, 'ɣ')
        transformed = transformed.replaceAll( Z_WITH_NUKTA, 'z')
        transformed = transformed.replaceAll(F_WITH_NUKTA, 'f')

        transformed = transformed.replaceAll(T_SOFT_WITH_NUKTA, 't̪') //त़      "त़" /त़/
        transformed = transformed.replaceAll(DH_HARD_WITH_BINDI, 'ɽʱ')

        transformed = transformed.replaceAll(D_HARD__WITH_BINDI, 'ɽ')

        transformed = transformed.replaceAll(D_SOFT_WITH_NUKTA, 'XXX')
        transformed = transformed.replaceAll(S_SOFT_WITH_NUKTA, 'XXX')
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
