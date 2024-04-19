package com.xiaopeng.montecarlo.root.util;

import java.util.Calendar;
/* loaded from: classes3.dex */
public class TimeUtil {
    public static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        return calendar != null && calendar2 != null && calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }

    public static boolean isSameDay(long j, long j2) {
        if (j <= 0 || j2 <= 0) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j2);
        return isSameDay(calendar, calendar2);
    }

    public static boolean isSameDayOrAfter(long j, long j2) {
        if (j <= 0 || j2 <= 0) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j2);
        return isSameDay(calendar, calendar2) || calendar.after(calendar2);
    }
}
