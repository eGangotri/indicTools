package com.egangotri.monierWilliams.db

import com.egangotri.monierWilliams.vo.WordMaster
import com.egangotri.monierWilliams.util.DictionaryConstants
import groovy.sql.GroovyRowResult
import groovy.sql.Sql
import groovy.util.logging.Slf4j
import org.apache.commons.lang3.StringUtils
import org.apache.derby.jdbc.EmbeddedDataSource

// Please note.
// In order to have Case-Sensitive Results, you must specify the
// DB with a collate value of utf8_bin
// Example : COLLATE=utf8_bin
// Pls see below for more Info
/*
 * DROP TABLE IF EXISTS `mw_dictionary`.`word_master`; CREATE TABLE
 * `mw_dictionary`.`word_master` ( `ID` int(10) unsigned NOT NULL
 * auto_increment, `WORD` varchar(50) collate utf8_bin NOT NULL default
 * '', `MEANING` varchar(2000) collate utf8_bin NOT NULL default '',
 * `WORDINSLP` varchar(50) collate utf8_bin NOT NULL default '',
 * `WORDINITRANS` varchar(50) collate utf8_bin NOT NULL default '',
 * `WORDINDVN` varchar(50) collate utf8_bin NOT NULL default '', PRIMARY
 * KEY (`ID`) ) ENGINE=InnoDB AUTO_INCREMENT=20308 DEFAULT CHARSET=utf8
 * COLLATE=utf8_bin COMMENT='InnoDB free: 6144 kB';
 */

@Slf4j
class DBUtil {
    static Sql connection
    static String database = 'MW_DICTIONARY'
    static String TABLE_NAME = "${database}.Word"
    static Boolean useMySql = false
    static Boolean withDerbyInJar = true

    static Sql getConnection() {
        if (connection == null) {
            if (useMySql) {
                String username = 'root'
                String server = 'localhost'
                String mySqlUrl = "jdbc:mysql://$server/$database"
                connection = Sql.newInstance(mySqlUrl, username, "", 'com.mysql.jdbc.Driver')
            } else {
                EmbeddedDataSource source
                String dbName = "db\\$database"
                println dbName
                boolean attemptFailed = false
                if(withDerbyInJar) {
                    source = new EmbeddedDataSource(databaseName: dbName)
                    connection = Sql.newInstance(source)
                }
                //when running from Local
                else {
                    URL url = DBUtil.class.getClassLoader().getResource("db/$database")
                    println url.path
                    source = new EmbeddedDataSource(databaseName: (url.path - "/"))
                    connection = Sql.newInstance(source)
                }
            }
        }
        return connection
    }


    static List<GroovyRowResult> fetchRows(String query) {
        return getConnection().rows(query, 1, DictionaryConstants.DICTIONARY_MAX_RESULTS_ALLOWED)
    }

    static WordMaster findWord(int id) {
        GroovyRowResult result = getConnection().firstRow("select * from $TABLE_NAME where id = $id")
        WordMaster word = dbRowToWord(result)
        return word
    }

    static WordMaster dbRowToWord(GroovyRowResult row) {
        WordMaster word = new WordMaster()
        word.id = row.ID
        word.word = row.WORD
        word.meaning = row.MEANING
        word.wordInSLP = row.WORDINSLP
        word.wordinItrans = row.WORDINITRANS
        word.wordinDVN = row.WORDINDVN
        return word
    }

    static List<WordMaster> dbRowsToWord(List<GroovyRowResult> rows) {
        List<WordMaster> list = []
        rows.each { row ->
            list << dbRowToWord(row)
        }
        return list
    }

    static ArrayList<WordMaster> findWord(int beginRowId, int endRowId) {
        List<GroovyRowResult> rows = fetchRows("select * from $TABLE_NAME where id >= $beginRowId and id <= $endRowId")
        return dbRowsToWord(rows)
    }

    static String prepareCountQuery(String searchWord, String searchType) {
        String query = "select count(*) as count from $TABLE_NAME "
        return prepareQuery(query, searchWord, searchType)
    }

    static String prepareReadQuery(String searchWord, String searchType) {
        String query = "select * from $TABLE_NAME "
        return prepareQuery(query, searchWord, searchType)

    }

    static String prepareQuery(String query, String searchWord, String searchType) {
        String predicate = " where "

        if (StringUtils.equalsIgnoreCase(searchType, DictionaryConstants.LEFT)) {
            predicate += "wordInSLP like '$searchWord%' or wordinDVN like '$searchWord%' "
        } else if (StringUtils.equalsIgnoreCase(searchType, DictionaryConstants.RIGHT)) {
            predicate += "wordInSLP like '%$searchWord' or wordinDVN like '%$searchWord' "
        } else if (StringUtils.equalsIgnoreCase(searchType, DictionaryConstants.ALL)) {
            predicate += "wordInSLP like '%$searchWord%' or wordinDVN like '%$searchWord%' "
        } else {
            predicate += "wordInSLP = '$searchWord' or wordinDVN = '$searchWord' "
        }

        return "$query$predicate"
    }

    static Long findWordCount(String searchWord, String searchType) {
        def result = getConnection().firstRow(prepareCountQuery(searchWord, searchType))
        println "result $result"
        return result.'count'
    }

    static ArrayList<WordMaster> findWord(String searchWord, String searchType) {
        List<GroovyRowResult> rows = fetchRows(prepareReadQuery(searchWord, searchType))
        return dbRowsToWord(rows)
    }

}