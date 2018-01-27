package com.example.supriya.music;

/**
 * Created by Supriya on 1/22/2018.
 */


public class Constants {
    public interface ACTION {
        public static String MAIN_ACTION = "com.example.supriya.music.action.main";
        public static String PREV_ACTION = "com.example.supriya.music.action.prev";
        public static String PLAY_ACTION = "com.example.supriya.music.action.play";
        public static String NEXT_ACTION = "com.example.supriya.music.action.next";
        public static String STARTFOREGROUND_ACTION = "com.example.supriya.music.action.startforeground";
        public static String STOPFOREGROUND_ACTION = "com.example.supriya.music.action.stopforeground";
    }

    public interface NOTIFICATION_ID {
        public static int FOREGROUND_SERVICE = 101;
    }
}