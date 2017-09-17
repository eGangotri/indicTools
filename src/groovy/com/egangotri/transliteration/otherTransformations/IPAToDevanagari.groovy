package com.egangotri.transliteration.otherTransformations

import org.apache.commons.lang3.StringUtils

/**
 * Created by user on 6/3/2016.
 */
class IPAToDevanagari {
    public static String transform(String transformed) {

        transformed = StringUtils.replacePattern(transformed, 'ə','अ')
        transformed = StringUtils.replacePattern(transformed,'ɑː', 'आ')
        transformed = StringUtils.replacePattern(transformed,'iː', 'ई')
        transformed = StringUtils.replacePattern(transformed,'i', 'इ')
        transformed = StringUtils.replacePattern(transformed,'uː', 'ऊ')
        transformed = StringUtils.replacePattern(transformed,'u', 'उ')
        transformed = StringUtils.replacePattern(transformed,'aːi', 'ऐ')
        transformed = StringUtils.replacePattern(transformed,'eː', 'ए')
        transformed = StringUtils.replacePattern(transformed,'aːu', 'औ')
        transformed = StringUtils.replacePattern(transformed,'oː', 'ओ')

        transformed = StringUtils.replacePattern(transformed,'ɹ̩', 'ऋ')
        transformed = StringUtils.replacePattern(transformed,'ɹ̩ː', 'ॠ')
        transformed = StringUtils.replacePattern(transformed,'l̩', 'ऌ')
        transformed = StringUtils.replacePattern(transformed,'l̩ːl̩ː', 'ॡ')


        transformed = StringUtils.replacePattern(transformed,'kʰ', 'ख्')
        transformed = StringUtils.replacePattern(transformed,'k', 'क्')
        transformed = StringUtils.replacePattern(transformed,'gʰ', 'घ्')
        transformed = StringUtils.replacePattern(transformed,'g', 'ग्')
        transformed = StringUtils.replacePattern(transformed,'ŋ', 'ङ्')
        transformed = StringUtils.replacePattern(transformed,'cʰ', 'छ्')
        transformed = StringUtils.replacePattern(transformed,'c','च्')
        transformed = StringUtils.replacePattern(transformed,'ɟʰ', 'झ्')
        transformed = StringUtils.replacePattern(transformed,'ɟ', 'ज्')
        transformed = StringUtils.replacePattern(transformed,'ɲ', 'ञ्')
        transformed = StringUtils.replacePattern(transformed,'ʈʰ', 'ठ्')
        transformed = StringUtils.replacePattern(transformed,'ʈ', 'ट्')
        transformed = StringUtils.replacePattern(transformed,'ɖʰ', 'ढ्')
        transformed = StringUtils.replacePattern(transformed,'ɖ', 'ड्')
        transformed = StringUtils.replacePattern(transformed,'ɳ', 'ण्')
        transformed = StringUtils.replacePattern(transformed,'t̪ʰ', 'थ्')
        transformed = StringUtils.replacePattern(transformed,'t̪', 'त्');
        transformed = StringUtils.replacePattern(transformed,'d̪ʰ', 'ध्')
        transformed = StringUtils.replacePattern(transformed,'d̪', 'द्')
        transformed = StringUtils.replacePattern(transformed,'n', 'न्')
        transformed = StringUtils.replacePattern(transformed,'pʰ', 'फ्')
        transformed = StringUtils.replacePattern(transformed,'p', 'प्')
        transformed = StringUtils.replacePattern(transformed,'bʰ', 'भ्')
        transformed = StringUtils.replacePattern(transformed,'b', 'ब्')
        transformed = StringUtils.replacePattern(transformed,'m', 'म्')
        transformed = StringUtils.replacePattern(transformed,'j', 'य्')
        transformed = StringUtils.replacePattern(transformed,'r', 'र्')
        transformed = StringUtils.replacePattern(transformed,'l','ल्')
        transformed = StringUtils.replacePattern(transformed,'v', 'व्')
        transformed = StringUtils.replacePattern(transformed,'ɕ', 'श्')
        transformed = StringUtils.replacePattern(transformed,'ʂ', 'ष्')
        transformed = StringUtils.replacePattern(transformed,'s', 'स्')
        transformed = StringUtils.replacePattern(transformed,'ɦ', 'ह्')
        transformed = StringUtils.replacePattern(transformed,'kʃ', 'क्ष्')
        transformed = StringUtils.replacePattern(transformed,'t̪ɾ', 'त्र्')
        transformed = StringUtils.replacePattern(transformed,'gj', 'ज्ञ्')
        transformed = StringUtils.replacePattern(transformed,'ɕc', 'श्र्')
        transformed = StringUtils.replacePattern(transformed,'q', 'क़्')
        transformed = StringUtils.replacePattern(transformed,'x', 'ख़्')
        transformed = StringUtils.replacePattern(transformed,'ɣ', 'ग़्')
        transformed = StringUtils.replacePattern(transformed,'z', 'ज़्')
        transformed = StringUtils.replacePattern(transformed,'f', "फ़्")
        String nuktaTa = "त़"
        transformed = StringUtils.replacePattern(transformed,'t̪', "त़्") //त़      "त़" /त़/
        transformed = StringUtils.replacePattern(transformed,'ɽʱ', 'ढ़्')
        transformed = StringUtils.replacePattern(transformed,'ɽ', 'ड़्')

       // transformed = StringUtils.replacePattern(transformed,'्', 'ə्')    // blank

        transformed = StringUtils.replacePattern(transformed,'ɑː', "ा")
        transformed = StringUtils.replacePattern(transformed,'i', 'ि')
        transformed = StringUtils.replacePattern(transformed,'iː', "ी")
        transformed = StringUtils.replacePattern(transformed,'u', 'ु')
        transformed = StringUtils.replacePattern(transformed,'uː', "ू")
        transformed = StringUtils.replacePattern(transformed,'ɹ̩', 'ृ')
        transformed = StringUtils.replacePattern(transformed,'eː', "े")
        transformed = StringUtils.replacePattern(transformed,'aːi', "ै")
        transformed = StringUtils.replacePattern(transformed,'oː', "ो")
        transformed = StringUtils.replacePattern(transformed,'aːu', "ौ")
        transformed = StringUtils.replacePattern(transformed,'ⁿ', 'ं')
        transformed = StringUtils.replacePattern(transformed,'̃' , 'ँ')
        transformed = StringUtils.replacePattern(transformed,'h', 'əः')

    }

    static main(def args) {
        String str = """
əɦəm ɑːd̪irɦiː bʰuːt̪ɑːnɑːm mət̪t̪h sərvəmeːvə prəvərt̪ət̪eː d̪ʰərmoː rəkʂət̪i rəkʂət̪h səⁿ ə:
 əⁿ mɑː̃ xə ɣə zə t̪ə़ d̪ə़ .fə sə़  x ɣ z t̪ə़् d̪ə़् .f sə़्  t̪ə़ qə  .ɕə zə ɽə ɽʱə ɖə ɖ  kʂə t̪rə ɟɲə sɑːɳɽʱə səɽəkə
            """
        println str
        println transform(str)
    }
}
