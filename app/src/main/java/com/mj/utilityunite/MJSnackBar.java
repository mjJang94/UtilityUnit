package com.mj.utilityunite;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class MJSnackBar {

    public void makeShortSnackBar(View view, String message){
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
    }

    public void makeLongSnackBar(View view, String message){
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }
}
