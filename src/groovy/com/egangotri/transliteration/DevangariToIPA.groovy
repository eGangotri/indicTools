package com.egangotri.transliteration

import groovy.util.logging.Slf4j
import org.apache.commons.lang3.StringUtils

/**
 * Created by user on 6/3/2016.
 */
@Slf4j
class DevangariToIPA {
    public static String transform(String transformed) {
        transformed = StringUtils.replacePattern(transformed,'अ', 'ə')
        transformed = StringUtils.replacePattern(transformed,'आ', 'ɑː')
        transformed = StringUtils.replacePattern(transformed,'इ', 'i')
        transformed = StringUtils.replacePattern(transformed,'ई', 'iː')
        transformed = StringUtils.replacePattern(transformed,'उ', 'u')
        transformed = StringUtils.replacePattern(transformed,'ऊ', 'uː')
        transformed = StringUtils.replacePattern(transformed,'ए', 'eː')
        transformed = StringUtils.replacePattern(transformed,'ऐ', 'aːi')
        transformed = StringUtils.replacePattern(transformed,'ओ', 'oː')
        transformed = StringUtils.replacePattern(transformed,'औ', 'aːu')

        transformed = StringUtils.replacePattern(transformed,'ऋ', 'ɹ̩')
        transformed = StringUtils.replacePattern(transformed,'ॠ', 'ɹ̩ː')
        transformed = StringUtils.replacePattern(transformed,'ऌ', 'l̩')
        transformed = StringUtils.replacePattern(transformed,'ॡ', 'l̩ː')


        transformed = StringUtils.replacePattern(transformed,'क', 'kə')
        transformed = StringUtils.replacePattern(transformed,'ख', 'kʰə')
        transformed = StringUtils.replacePattern(transformed,'ग', 'gə')
        transformed = StringUtils.replacePattern(transformed,'घ', 'gʰə')
        transformed = StringUtils.replacePattern(transformed,'ङ', 'ŋə')
        transformed = StringUtils.replacePattern(transformed,'च', 'cə')
        transformed = StringUtils.replacePattern(transformed,'छ', 'cʰə')
        transformed = StringUtils.replacePattern(transformed,'ज', 'ɟə')
        transformed = StringUtils.replacePattern(transformed,'झ', 'ɟʰə')
        transformed = StringUtils.replacePattern(transformed,'ञ', 'ɲə')
        transformed = StringUtils.replacePattern(transformed,'ट', 'ʈə')
        transformed = StringUtils.replacePattern(transformed,'ठ', 'ʈʰə')
        transformed = StringUtils.replacePattern(transformed,'ड', 'ɖə')
        transformed = StringUtils.replacePattern(transformed,'ढ', 'ɖʰə')
        transformed = StringUtils.replacePattern(transformed,'ण', 'ɳə')
        transformed = StringUtils.replacePattern(transformed,'त', 't̪ə');
        transformed = StringUtils.replacePattern(transformed,'थ', 't̪ʰə')
        transformed = StringUtils.replacePattern(transformed,'द', 'd̪ə')
        transformed = StringUtils.replacePattern(transformed,'ध', 'd̪ʰə')
        transformed = StringUtils.replacePattern(transformed,'न', 'nə')
        transformed = StringUtils.replacePattern(transformed,'प', 'pə')
        transformed = StringUtils.replacePattern(transformed,'फ', 'pʰə')
        transformed = StringUtils.replacePattern(transformed,'ब', 'bə')
        transformed = StringUtils.replacePattern(transformed,'भ', 'bʰə')
        transformed = StringUtils.replacePattern(transformed,'म', 'mə')
        transformed = StringUtils.replacePattern(transformed,'य', 'jə')
        transformed = StringUtils.replacePattern(transformed,'र', 'rə')
        transformed = StringUtils.replacePattern(transformed,'ल', 'lə')
        transformed = StringUtils.replacePattern(transformed,'व', 'və')
        transformed = StringUtils.replacePattern(transformed,'श', 'ɕə')
        transformed = StringUtils.replacePattern(transformed,'ष', 'ʂə')
        transformed = StringUtils.replacePattern(transformed,'स', 'sə')
        transformed = StringUtils.replacePattern(transformed,'ह', 'ɦə')
        transformed = StringUtils.replacePattern(transformed,'क्ष', 'kʃə')
        transformed = StringUtils.replacePattern(transformed,'त्र', 't̪ɾə')
        transformed = StringUtils.replacePattern(transformed,'ज्ञ', 'gjə')
        transformed = StringUtils.replacePattern(transformed,'श्र', 'ɕcə')
        transformed = StringUtils.replacePattern(transformed,'क़', 'qə')
        transformed = StringUtils.replacePattern(transformed,'ख़', 'xə')
        transformed = StringUtils.replacePattern(transformed,'ग़', 'ɣə')
        transformed = StringUtils.replacePattern(transformed,'ज़', 'zə')
        transformed = StringUtils.replacePattern(transformed,"फ़", 'fə')
        String nuktaTa = "त़"
        transformed = StringUtils.replacePattern(transformed,"त़", 't̪ə') //त़      "त़" /त़/
        transformed = StringUtils.replacePattern(transformed,'ड़', 'ɽə')
        transformed = StringUtils.replacePattern(transformed,'ढ़', 'ɽʱə')

        transformed = StringUtils.replacePattern(transformed,'ə्', '')    // blank

        transformed = StringUtils.replacePattern(transformed,"əा", 'ɑː')
        transformed = StringUtils.replacePattern(transformed,'əि', 'i')
        transformed = StringUtils.replacePattern(transformed,"əी", 'iː')
        transformed = StringUtils.replacePattern(transformed,'əु', 'u')
        transformed = StringUtils.replacePattern(transformed,"əू", 'uː')
        transformed = StringUtils.replacePattern(transformed,'əृ', 'ɹ̩')
        transformed = StringUtils.replacePattern(transformed,"əे", 'eː')
        transformed = StringUtils.replacePattern(transformed,"əै", 'aːi')
        transformed = StringUtils.replacePattern(transformed,"əो", 'oː')
        transformed = StringUtils.replacePattern(transformed,"əौ", 'aːu')
        transformed = StringUtils.replacePattern(transformed,'ं', 'ⁿ')
        transformed = StringUtils.replacePattern(transformed,'ँ', '̃')
        transformed = StringUtils.replacePattern(transformed,'əः', 'h')
    }

    static main(def args) {
        String dvn = "अहम् आदिर्ही भूतानाम् मत्तः सर्वमेव प्रवर्तते धर्मो रक्षति रक्षतः सं अ: अं माँ ख़ ग़ ज़ त़ द़ .फ़ स़  ख़् ग़् ज़् त़् द़् .फ़् स़्  त़ क़  .श ज़ ड़ ढ़ ड ड्  क्ष त्र ज्ञ साण्ढ़ सड़क"
        println dvn
        println transform(dvn)
    }
}