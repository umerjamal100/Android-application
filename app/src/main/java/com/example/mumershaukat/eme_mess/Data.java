package com.example.mumershaukat.eme_mess;


/**
 * Created by M Umer Shaukat on 4/26/2017.
 */

public class Data {
    private static final Data ourInstance = new Data();

    public static Data getInstance() {
        return ourInstance;
    }

    private Data() {
    }
    public static String name=null;
    public static String record=null;
    protected static String var(String Token){
        name=Token;
        return Token;


    }
    protected static String dat(String Token){
        record=Token;
        return Token;


    }
}

