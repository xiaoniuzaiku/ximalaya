package com.example.myapplication.utils;

import android.util.Log;

/*
PACKAGE_NAME:com.example.myapplication.utils
DATE:2020/1/6
${}
*/public class logutils {
    public static String sTAG="logutil";
    public static boolean sIsRelease=false;
    public static void init(String basetag,boolean IsRelease){
        sTAG=basetag;
        sIsRelease=IsRelease;
    }
    public static void d(String Tag,String content){
        if (!sIsRelease) {
            Log.d("["+sTAG+"]"+Tag, content);
        }
    }
    public static void v(String TAG, String content) {
        if (!sIsRelease) {
            Log.d("[" + sTAG + "]" + TAG, content);
        }
    }

    public static void i(String TAG, String content) {
        if (!sIsRelease) {
            Log.d("[" + sTAG + "]" + TAG, content);
        }
    }

    public static void w(String TAG, String content) {
        if (!sIsRelease) {
            Log.d("[" + sTAG + "]" + TAG, content);
        }
    }

    public static void e(String TAG, String content) {
        if (!sIsRelease) {
            Log.d("[" + sTAG + "]" + TAG, content);
        }
    }


}
