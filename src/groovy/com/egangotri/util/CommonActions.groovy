package com.egangotri.util

import com.egangotri.transliteration.RTFDocsSwingDisplayer
import groovy.util.logging.Slf4j

import javax.swing.JOptionPane

/**
 * Created by user on 5/22/2016.
 */
@Slf4j
class CommonActions {
    static performActions(def actionCommand) {
        if (actionCommand.equals("Exit")) {
            System.exit(0);
        } else if (actionCommand.equals("itrans_encoding")) {
            log.info("transliteration_scheme_display()");
            new RTFDocsSwingDisplayer("ITRANS ENCODING SCHEME", "itrans.rtf");
        } else if (actionCommand.equals("slp_encoding")) {
            log.info("transliteration_scheme_display()");
            new RTFDocsSwingDisplayer("SLP-I ENCODING SCHEME", "slp.rtf");
        } else if (actionCommand.equals("hk_encoding")) {
            log.info("RTFDocsSwingDisplayer for HK ENCODING DISPLAY");
            new RTFDocsSwingDisplayer("HK Encoding Scheme", "hk.rtf");
        } else if (actionCommand.equals("velthuis_encoding")) {
            log.info("RTFDocsSwingDisplayer for Velthuis DISPLAY");
            new RTFDocsSwingDisplayer("Velthuis Encoding Scheme", "velthuis.rtf");
        } else if (actionCommand.equals("devanagari_encoding")) {
            log.info("RTFDocsSwingDisplayer for HK ENCODING DISPLAY");
            new RTFDocsSwingDisplayer("Unicode Devanagari Encoding Scheme", "devanagari.rtf");
        } else if (actionCommand.equals("iast_encoding")) {
            log.info("RTFDocsSwingDisplayer for IAST ENCODING DISPLAY");
            new RTFDocsSwingDisplayer("IAST Encoding Scheme", "iast.rtf");
        } else if (actionCommand.equals("siva_sutra_desc")) {
            new RTFDocsSwingDisplayer("The Siva Sutras of Panini", "siva.rtf");
        }

    }
}
