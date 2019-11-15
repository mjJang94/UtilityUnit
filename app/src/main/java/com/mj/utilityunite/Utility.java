package com.mj.utilityunite;

import android.content.Context;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    private static String TAG = Utility.class.getSimpleName();

    public static String getHashSHA256(String value) {
        String SHA = "";
        try {
            MessageDigest sh = MessageDigest.getInstance("SHA-256");
            sh.update(value.getBytes());
            byte byteData[] = sh.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++)
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            SHA = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            SHA = null;
        }
        return SHA;
    }


    public static int parseIntFromSring(String text) {
        int num = 0;
        try {
            num = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            Log.d(TAG, e.getMessage());
        }
        return num;
    }

    public static String parseStringFromInt(int value) {
        String tmp = "";
        try {
            tmp = Integer.toString(value);
        } catch (NumberFormatException e) {
            Log.d(TAG, e.getMessage());
        }
        return tmp;
    }

    public static String parseStringFromLong(Long value) {
        String tmp = "";
        try {
            tmp = Long.toString(value);
        } catch (NumberFormatException e) {
            Log.d(TAG, e.getMessage());
        }
        return tmp;
    }


    public static String getTimeFormatWithAmPm(String time) {
        String ampm = "";
        String hour = time.substring(0, 2);
        String min = time.substring(2, 4);

        int hourI = 0;
        int minI = 0;

        try {

            hourI = Integer.valueOf(hour);
            minI = Integer.valueOf(min);

            if (hourI < 12) {
                ampm = "AM";
            } else if (hourI == 24) {
                ampm = "AM";
                hourI = 0;
            } else {
                ampm = "PM";
                if (hourI != 12) {
                    hourI -= 12;
                }
            }

        } catch (NumberFormatException e) {
            Log.d(TAG, e.getMessage());
        }

        hour = String.format("%02d", hourI);
        min = String.format("%02d", minI);

        String returnTime = ampm + " " + hour + ":" + min;

        return returnTime;
    }


    public static String getTodayDate() {

        Date date = new Date();
        SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyy년MM월dd일");

        String strCurDate = CurDateFormat.format(date);
        return strCurDate;
    }

    public static String getDateFormatWithSlash(String date, String time) {
        String YEAR = date.substring(0, 4);
        String MONTH = date.substring(4, 6);
        String DAY = date.substring(6);
        String HOUR = time.substring(0, 2);
        String MINUTE = time.substring(2, 4);
        String SECOND = time.substring(4);

        String returnDate = MONTH + "/" + DAY;
        return returnDate;
    }


    public static String formatForMoneyByString(String money) {
        double amount = 0.0d;
        try {
            amount = Double.parseDouble(money);
        } catch (NumberFormatException | NullPointerException e) {
            Log.d(TAG, e.getMessage());
        }
        return new DecimalFormat("#,###").format(amount);
    }

    public static String formatForMoneyByInteger(int money) {
        return new DecimalFormat("#,###").format(money);
    }

    public static String formatForMoneyByLong(long money) {
        return new DecimalFormat("#,###").format(money);
    }



}
