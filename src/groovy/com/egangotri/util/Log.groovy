package com.egangotri.util

import groovy.util.logging.Slf4j;

//import org.apache.log4j.Logger;
/**
 * Logger - Logging component to log all the messages.
 * The Correct Version of Log.java for logging.CP
 */
@Slf4j
public class Log {
    public static void info(String info) {
        println(info)
    }
    public static void info(String info, Exception e) {
        println(info)
        e.printStackTrace()
    }
}