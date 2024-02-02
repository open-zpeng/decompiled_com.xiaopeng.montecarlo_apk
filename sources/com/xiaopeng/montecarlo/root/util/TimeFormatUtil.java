package com.xiaopeng.montecarlo.root.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public class TimeFormatUtil {
    public static final String DATE_PATTERN_FORMAT = "yyyy-MM-dd";
    public static final String DATE_PATTERN_FORMAT_CN = "yyyy年MM月dd日";
    public static final String DATE_TIME_PATTERN_FORMAT_CN = "yyyy年MM月dd日 HH:mm";
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final long ONE_DAY = 86400;
    public static final long ONE_HOUR = 3600;
    public static final long ONE_MINUTE = 60;
    public static final String SHORT_TIME_PATTERN_FORMAT = "HH:mm";
    public static final String TIME_PATTERN_FORMAT = "HH:mm:ss";

    public static String formatShortTime(long j) {
        return formatTime(j, SHORT_TIME_PATTERN_FORMAT);
    }

    public static String formatTime(long j) {
        return formatTime(j, DEFAULT_PATTERN);
    }

    public static String formatTime(long j, String str) {
        return formatTime(new Date(j), str);
    }

    public static String formatTime(String str) {
        return formatTime(new Date(), str);
    }

    public static String formatTime(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }

    public static String getCurrentFormatTimeString() {
        return formatTime(System.currentTimeMillis());
    }
}
