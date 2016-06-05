package com.egangotri.transliteration

/**
 * Created by user on 6/3/2016.
 */
class IPAToDevanagari {
    public static String transform(String transformed) {

        transformed = transformed.replaceAll( 'ə','अ')
        transformed = transformed.replaceAll('ɑː', 'आ')
        transformed = transformed.replaceAll('iː', 'ई')
        transformed = transformed.replaceAll('i', 'इ')
        transformed = transformed.replaceAll('uː', 'ऊ')
        transformed = transformed.replaceAll('u', 'उ')
        transformed = transformed.replaceAll('aːi', 'ऐ')
        transformed = transformed.replaceAll('eː', 'ए')
        transformed = transformed.replaceAll('aːu', 'औ')
        transformed = transformed.replaceAll('oː', 'ओ')

        transformed = transformed.replaceAll('ɹ̩', 'ऋ')
        transformed = transformed.replaceAll('ɹ̩ː', 'ॠ')
        transformed = transformed.replaceAll('l̩', 'ऌ')
        transformed = transformed.replaceAll('l̩ːl̩ː', 'ॡ')


        transformed = transformed.replaceAll('kʰ', 'ख्')
        transformed = transformed.replaceAll('k', 'क्')
        transformed = transformed.replaceAll('gʰ', 'घ्')
        transformed = transformed.replaceAll('g', 'ग्')
        transformed = transformed.replaceAll('ŋ', 'ङ्')
        transformed = transformed.replaceAll('cʰ', 'छ्')
        transformed = transformed.replaceAll('c','च्')
        transformed = transformed.replaceAll('ɟʰ', 'झ्')
        transformed = transformed.replaceAll('ɟ', 'ज्')
        transformed = transformed.replaceAll('ɲ', 'ञ्')
        transformed = transformed.replaceAll('ʈʰ', 'ठ्')
        transformed = transformed.replaceAll('ʈ', 'ट्')
        transformed = transformed.replaceAll('ɖʰ', 'ढ्')
        transformed = transformed.replaceAll('ɖ', 'ड्')
        transformed = transformed.replaceAll('ɳ', 'ण्')
        transformed = transformed.replaceAll('t̪ʰ', 'थ्')
        transformed = transformed.replaceAll('t̪', 'त्');
        transformed = transformed.replaceAll('d̪ʰ', 'ध्')
        transformed = transformed.replaceAll('d̪', 'द्')
        transformed = transformed.replaceAll('n', 'न्')
        transformed = transformed.replaceAll('pʰ', 'फ्')
        transformed = transformed.replaceAll('p', 'प्')
        transformed = transformed.replaceAll('bʰ', 'भ्')
        transformed = transformed.replaceAll('b', 'ब्')
        transformed = transformed.replaceAll('m', 'म्')
        transformed = transformed.replaceAll('j', 'य्')
        transformed = transformed.replaceAll('r', 'र्')
        transformed = transformed.replaceAll('l','ल्')
        transformed = transformed.replaceAll('v', 'व्')
        transformed = transformed.replaceAll('ɕ', 'श्')
        transformed = transformed.replaceAll('ʂ', 'ष्')
        transformed = transformed.replaceAll('s', 'स्')
        transformed = transformed.replaceAll('ɦ', 'ह्')
        transformed = transformed.replaceAll('kʃ', 'क्ष्')
        transformed = transformed.replaceAll('t̪ɾ', 'त्र्')
        transformed = transformed.replaceAll('gj', 'ज्ञ्')
        transformed = transformed.replaceAll('ɕc', 'श्र्')
        transformed = transformed.replaceAll('q', 'क़्')
        transformed = transformed.replaceAll('x', 'ख़्')
        transformed = transformed.replaceAll('ɣ', 'ग़्')
        transformed = transformed.replaceAll('z', 'ज़्')
        transformed = transformed.replaceAll('f', "फ़्")
        String nuktaTa = "त़"
        transformed = transformed.replaceAll('t̪', "त़्") //त़      "त़" /त़/
        transformed = transformed.replaceAll('ɽʱ', 'ढ़्')
        transformed = transformed.replaceAll('ɽ', 'ड़्')

       // transformed = transformed.replaceAll('्', 'ə्')    // blank

        transformed = transformed.replaceAll('ɑː', "ा")
        transformed = transformed.replaceAll('i', 'ि')
        transformed = transformed.replaceAll('iː', "ी")
        transformed = transformed.replaceAll('u', 'ु')
        transformed = transformed.replaceAll('uː', "ू")
        transformed = transformed.replaceAll('ɹ̩', 'ृ')
        transformed = transformed.replaceAll('eː', "े")
        transformed = transformed.replaceAll('aːi', "ै")
        transformed = transformed.replaceAll('oː', "ो")
        transformed = transformed.replaceAll('aːu', "ौ")
        transformed = transformed.replaceAll('ⁿ', 'ं')
        transformed = transformed.replaceAll('̃' , 'ँ')
        transformed = transformed.replaceAll('h', 'əः')

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
