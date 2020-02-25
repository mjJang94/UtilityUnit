package com.mj.utilityunite;

import android.util.Log;

public class NLog {

    public static void d(String tag, String msg) {
        if (BuildConfig.DEBUG)
            Log.d(tag, getCallerInfo() + msg);
    }

    public static void d(String tag, String msg, Throwable tr) {
        if (BuildConfig.DEBUG)
            Log.d(tag, getCallerInfo() + msg, tr);
    }

    public static void i(String tag, String msg) {
        if (BuildConfig.DEBUG)
            Log.i(tag, getCallerInfo() + msg);
    }

    public static void i(String tag, String msg, Throwable tr) {
        if (BuildConfig.DEBUG)
            Log.i(tag, getCallerInfo() + msg, tr);
    }

    public static void w(String tag, String msg) {
        if (BuildConfig.DEBUG)
            Log.w(tag, msg + " " + getCallerInfo());
    }

    public static void w(String tag, String msg, Throwable tr) {
        if (BuildConfig.DEBUG)
            Log.w(tag, getCallerInfo() + msg, tr);
    }

    public static void e(String tag, String msg) {
        if (BuildConfig.DEBUG)
            Log.e(tag, getCallerInfo() + msg);
    }

    public static void e(String tag, String msg, Throwable tr) {
        if (BuildConfig.DEBUG)
            Log.e(tag, getCallerInfo() + msg, tr);
    }

    private static String getCallerInfo() {
        String info = " ";

        StackTraceElement ste = Thread.currentThread().getStackTrace()[4];
        if (ste == null) {
            return info;
        }

        String fileName = ste.getFileName();
        String methodName = ste.getMethodName();
        int lineNumber = ste.getLineNumber();
        info = "(" + fileName + ", " + methodName + ", " + Integer.toString(lineNumber) + ")   ";
        return info;
    }
}