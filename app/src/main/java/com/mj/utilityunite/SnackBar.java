package com.mj.utilityunite;

import android.content.Context;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class SnackBar {

    public static void makeShortSnackBar(View view, String message){
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
    }
    public static void makeLongSnackBar(View view, String message){
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }
}
