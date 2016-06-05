package com.egangotri.transliteration

/**
 * Created by user on 6/3/2016.
 */
class DevangariToIPA {
    public static String transform(String transformed) {
        transformed = transformed.replaceAll('अ', 'ə')
        transformed = transformed.replaceAll('आ', 'ɑː')
        transformed = transformed.replaceAll('इ', 'i')
        transformed = transformed.replaceAll('ई', 'iː')
        transformed = transformed.replaceAll('उ', 'u')
        transformed = transformed.replaceAll('ऊ', 'uː')
        transformed = transformed.replaceAll('ए', 'eː')
        transformed = transformed.replaceAll('ऐ', 'aːi')
        transformed = transformed.replaceAll('ओ', 'oː')
        transformed = transformed.replaceAll('औ', 'aːu')

        transformed = transformed.replaceAll('ऋ', 'ɹ̩')
        transformed = transformed.replaceAll('ॠ', 'ɹ̩ː')
        transformed = transformed.replaceAll('ऌ', 'l̩')
        transformed = transformed.replaceAll('ॡ', 'l̩ː')


        transformed = transformed.replaceAll('क', 'kə')
        transformed = transformed.replaceAll('ख', 'kʰə')
        transformed = transformed.replaceAll('ग', 'gə')
        transformed = transformed.replaceAll('घ', 'gʰə')
        transformed = transformed.replaceAll('ङ', 'ŋə')
        transformed = transformed.replaceAll('च', 'cə')
        transformed = transformed.replaceAll('छ', 'cʰə')
        transformed = transformed.replaceAll('ज', 'ɟə')
        transformed = transformed.replaceAll('झ', 'ɟʰə')
        transformed = transformed.replaceAll('ञ', 'ɲə')
        transformed = transformed.replaceAll('ट', 'ʈə')
        transformed = transformed.replaceAll('ठ', 'ʈʰə')
        transformed = transformed.replaceAll('ड', 'ɖə')
        transformed = transformed.replaceAll('ढ', 'ɖʰə')
        transformed = transformed.replaceAll('ण', 'ɳə')
        transformed = transformed.replaceAll('त', 't̪ə');
        transformed = transformed.replaceAll('थ', 't̪ʰə')
        transformed = transformed.replaceAll('द', 'd̪ə')
        transformed = transformed.replaceAll('ध', 'd̪ʰə')
        transformed = transformed.replaceAll('न', 'nə')
        transformed = transformed.replaceAll('प', 'pə')
        transformed = transformed.replaceAll('फ', 'pʰə')
        transformed = transformed.replaceAll('ब', 'bə')
        transformed = transformed.replaceAll('भ', 'bʰə')
        transformed = transformed.replaceAll('म', 'mə')
        transformed = transformed.replaceAll('य', 'jə')
        transformed = transformed.replaceAll('र', 'rə')
        transformed = transformed.replaceAll('ल', 'lə')
        transformed = transformed.replaceAll('व', 'və')
        transformed = transformed.replaceAll('श', 'ɕə')
        transformed = transformed.replaceAll('ष', 'ʂə')
        transformed = transformed.replaceAll('स', 'sə')
        transformed = transformed.replaceAll('ह', 'ɦə')
        transformed = transformed.replaceAll('क्ष', 'kʃə')
        transformed = transformed.replaceAll('त्र', 't̪ɾə')
        transformed = transformed.replaceAll('ज्ञ', 'gjə')
        transformed = transformed.replaceAll('श्र', 'ɕcə')
        transformed = transformed.replaceAll('क़', 'qə')
        transformed = transformed.replaceAll('ख़', 'xə')
        transformed = transformed.replaceAll('ग़', 'ɣə')
        transformed = transformed.replaceAll('ज़', 'zə')
        transformed = transformed.replaceAll("फ़", 'fə')
        String nuktaTa = "त़"
        transformed = transformed.replaceAll("त़", 't̪ə') //त़      "त़" /त़/
        transformed = transformed.replaceAll('ड़', 'ɽə')
        transformed = transformed.replaceAll('ढ़', 'ɽʱə')

        transformed = transformed.replaceAll('ə्', '')    // blank

        transformed = transformed.replaceAll("əा", 'ɑː')
        transformed = transformed.replaceAll('əि', 'i')
        transformed = transformed.replaceAll("əी", 'iː')
        transformed = transformed.replaceAll('əु', 'u')
        transformed = transformed.replaceAll("əू", 'uː')
        transformed = transformed.replaceAll('əृ', 'ɹ̩')
        transformed = transformed.replaceAll("əे", 'eː')
        transformed = transformed.replaceAll("əै", 'aːi')
        transformed = transformed.replaceAll("əो", 'oː')
        transformed = transformed.replaceAll("əौ", 'aːu')
        transformed = transformed.replaceAll('ं', 'ⁿ')
        transformed = transformed.replaceAll('ँ', '̃')
        transformed = transformed.replaceAll('əः', 'h')
    }

    static main(def args) {
        String dvn = "अहम् आदिर्ही भूतानाम् मत्तः सर्वमेव प्रवर्तते धर्मो रक्षति रक्षतः सं अ: अं माँ ख़ ग़ ज़ त़ द़ .फ़ स़  ख़् ग़् ज़् त़् द़् .फ़् स़्  त़ क़  .श ज़ ड़ ढ़ ड ड्  क्ष त्र ज्ञ साण्ढ़ सड़क"
        println dvn
        println transform(dvn)
    }
}