package com.codingblocks.notesdb;

public final class TableContract {

    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String IS_DONE = "isDone";
    public static final String TABLE_NAME = "notes";
    public static final String IPK = " INTEGER PRIMARY KEY ";
    public static final String TYPE_TEXT = " TEXT ";
    public static final String COMMA = " , ";
    public static final String TYPE_INT = " INTEGER ";
    public static final String SELECT = " SELECT ";
    public static final String ALL = " * ";
    public static final String LBR = " ( ";
    public static final String RBR = " ) ";
    public static final String FROM = " FROM ";
    public static final String TERMINATION = " ; ";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + LBR + ID + IPK
            + COMMA + TITLE + TYPE_TEXT + COMMA + DESCRIPTION + TYPE_TEXT + COMMA + IS_DONE + TYPE_INT + RBR + TERMINATION;


    public static final String GET_ALL_NOTES = SELECT + ALL + FROM + TABLE_NAME + TERMINATION;

    public static String returnQueryForInput(String id) {
        return SELECT + ALL + FROM + TABLE_NAME + "WHERE " + ID + " = " + id + TERMINATION;
    }


}
