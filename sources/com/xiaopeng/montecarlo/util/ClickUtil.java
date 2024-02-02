package com.xiaopeng.montecarlo.util;
/* loaded from: classes3.dex */
public class ClickUtil {
    private static final long CLICK_TIME_INTERVAL = 100;
    private static long sLastClickTime;

    public static boolean isFastClick() {
        return isFastClick(100L);
    }

    public static boolean isFastClick(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - sLastClickTime < j) {
            sLastClickTime = currentTimeMillis;
            return true;
        }
        sLastClickTime = currentTimeMillis;
        return false;
    }
}
