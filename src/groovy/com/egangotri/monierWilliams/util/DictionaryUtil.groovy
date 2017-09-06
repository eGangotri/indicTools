package com.egangotri.monierWilliams.util

import com.egangotri.monierWilliams.vo.WordMaster
import org.apache.commons.lang3.text.WordUtils

/**
 * Created by user on 5/21/2016.
 */
class DictionaryUtil {

    public
    static String createHeader(String entry, String transformedEntry, long count) {
        // Set Notes
        StringBuilder header = new StringBuilder();
        String heading = "Found <b>$count Meaning(s)</b> for Search Term: <b>$entry</b>[<b>$transformedEntry</b>]<br>"
//        if (count > DictionaryConstants.DICTIONARY_MAX_RESULTS_ALLOWED) {
//            heading += "Only the First ${DictionaryConstants.DICTIONARY_MAX_RESULTS_ALLOWED} Meanings are being shown<br> "
//        }
        header.append(heading);
        return header
    }

    public
    static String createBody(ArrayList<WordMaster> wordList, String entry, String transformedEntry, long count) {
        if (!wordList) {
            return "No such Word '<i>" + entry + "</i>' [" + transformedEntry + "]" + " Found";
        }

        // Set Notes
        StringBuilder notes = new StringBuilder();
        String heading = "<br>Results for Search Term '<i>" + entry + "</i>' [$transformedEntry]"
        if (count > DictionaryConstants.DICTIONARY_MAX_RESULTS_ALLOWED) {
            heading += "<br><i>Results Restricted to Only the First ${DictionaryConstants.DICTIONARY_MAX_RESULTS_ALLOWED} out of $count Meanings<i><br> "
        }

        notes.append(heading);
        int counter = 0;
        wordList.each { WordMaster word ->
            notes.append("<br><b><font color='#006400'>" + ++counter + ".&nbsp;" + "<u>${word.wordinDVN}, ${WordUtils.capitalizeFully(word.word)}</u></font></b><br>");
            String[] meanings = word.getMeaning().split(DictionaryConstants.ARTHA_VIBHAKTA);
            if (meanings) {
                notes.append("<ol>");
                meanings.each { String meaning ->
                    notes.append("<li color='blue'> $meaning</li>");
                }
                notes.append("</ol>");
            }

        }
        return notes.toString();
    }

}

