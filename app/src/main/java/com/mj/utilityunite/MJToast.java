package com.mj.utilityunite;

import android.content.Context;
import android.widget.Toast;

public class MJToast {

    public void makeShortToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public void makeLongToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
