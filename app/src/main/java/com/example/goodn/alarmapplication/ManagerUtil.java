package com.example.goodn.alarmapplication;

import android.app.Activity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * ManagerUtil
 */
public final class ManagerUtil {

    /**
     * debugging
     */
    private static final String TAG = ManagerUtil.class.getSimpleName();

    public static List<Activity> activityManager;

    protected static final int CLICKING_TIME_INTERVAL = 250;

    protected static long mGlobalClickTime;

    /**
     * 여러번 클릭 방지를 위한 체크
     *
     * @return true = 클릭 막힘, false = 클릭 가능
     */
    public static boolean isClicking() {
        long timeGap = System.currentTimeMillis() - mGlobalClickTime;
        if (Math.abs(timeGap) < CLICKING_TIME_INTERVAL) {
            return true;
        }

        mGlobalClickTime = System.currentTimeMillis();
        return false;
    }
    /**
     * 시간을 AM, PM 구분
     *
     * @param time
     * @return
     */
    public static String convertTimeFormat(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(2, 4));

        String dayOrNight = "AM";

        String strHour = "";
        String strMinute = "";

        if (hour < 10) {
            strHour = "0" + hour;
        } else {

            if (hour >= 12) {

                dayOrNight = "PM";

                if (hour == 12) {
                    strHour = String.valueOf(hour);
                } else if (hour == 24) {
                    strHour = "00";
                    dayOrNight = "AM";
                } else {

                    int nHour = hour - 12;

                    if (nHour < 10) {
                        strHour = "0" + nHour;
                    } else {
                        strHour = String.valueOf(nHour);
                    }
                }
            } else {
                strHour = String.valueOf(hour);
            }
        }

        if (minute < 10) {
            strMinute = "0" + minute;
        } else {
            strMinute = String.valueOf(minute);
        }

        String strTime = dayOrNight + " " + strHour + ":" + strMinute;

        return strTime;
    }
    /**
     * format 형태의 현재 시간 조회
     *
     * @param dateFormat
     * @return
     */
    public static String getCurrentDateTime(String dateFormat) {

        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dateFormat);

        df.setTimeZone(TimeZone.getDefault());

        return df.format(date);
    }

}
