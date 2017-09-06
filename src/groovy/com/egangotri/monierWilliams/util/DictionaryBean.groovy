package com.egangotri.monierWilliams.util

public class DictionaryBean {

    String entry

    String transformedEntry

    String encoding

    String searchType

    String meaning

    public DictionaryBean(String entry, String transformedEntry, String encoding, String searchType, String meaning) {
        this.entry = entry
        this.transformedEntry = transformedEntry
        this.encoding = encoding
        this.meaning = meaning
        this.searchType = searchType
    }

}
