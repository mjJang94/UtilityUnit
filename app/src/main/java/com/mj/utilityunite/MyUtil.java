package com.mj.utilityunite;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtil {

    private static String TAG = MyUtil.class.getSimpleName();

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

    /**
     * Base64 인코딩
     */
    private static String getBase64encode(String content) {
        return Base64.encodeToString(content.getBytes(), 0);
    }

    /**
     * Base64 디코딩
     */
    private static String getBase64decode(String content) {
        return new String(Base64.decode(content, 0));
    }

    /**
     * // empty인지 "null" 인지 확인 하고 값이 없는 경우 ""를 반환 한다.
     *
     * @param str
     * @return
     */
    public static String checkEmpty(String str) {
        String result = str;
        if (str == null || str.isEmpty() || str.equalsIgnoreCase("null")) {
            result = "";
        }
        return result;
    }


    /**
     * null, "", "null" 인지 확인 하고
     * 해당하는 경우 "0"을 반환한다.
     *
     * @param num
     * @return
     */
    public static String checkNullNum(String num) {
        String result = "0";

        if (num == null || "".equals(num.trim()) || "null".equals(num)) {

        } else {
            try {
                if (num.contains(",")) {
                    num = num.replace(",", "");
                }

                Double tmp = Double.valueOf(num);
                result = tmp.intValue() + "";
            } catch (NumberFormatException e) {
                result = "0";
            }
        }

        return result;
    }

    /**
     * 날짜 형태 변환
     * YYYYMMDD -> YYYY/MM/dd
     */
    public static String getDateFormatYYYYMMdd(String date) {
        String YEAR = date.substring(0, 4);
        String MONTH = date.substring(4, 6);
        String DAY = date.substring(6, 8);

        String returnDate = YEAR + "/" + MONTH + "/" + DAY;
        return returnDate;
    }


    public static void getHashKey(Context context, String pkgName) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(pkgName, PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.e("key_hash=", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String getTAG(Context context) {

        String TAG = context.getClass().getSimpleName();

        return TAG;
    }

    public static String getPrintStackTrace(Exception e) {

        StringWriter errors = new StringWriter();
        e.printStackTrace(new PrintWriter(errors));

        return errors.toString();

    }

    public static void saveStringData(Activity activity, String key, String value) {

        SharedPreferences pref = activity.getSharedPreferences("util", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String loadStringData(Activity activity, String key) {

        String value;

        SharedPreferences pref = activity.getSharedPreferences("util", Context.MODE_PRIVATE);
        value = pref.getString(key, "NO_DATA");

        return value;
    }

    public static void savelongData(Activity activity, String key, long value) {

        SharedPreferences pref = activity.getSharedPreferences("util", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static long loadlongData(Activity activity, String key) {

        long value;

        SharedPreferences pref = activity.getSharedPreferences("util", Context.MODE_PRIVATE);
        value = pref.getLong(key, 0);

        return value;
    }

    public static void deleteSharedPreferencesByKey(Activity activity, String key){
        SharedPreferences pref = activity.getSharedPreferences("util", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(key);
        editor.apply();
    }

    public static void clearSharedPreferences(Activity activity){
        SharedPreferences pref = activity.getSharedPreferences("util", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }
}
