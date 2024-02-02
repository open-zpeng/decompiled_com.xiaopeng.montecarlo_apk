package com.alibaba.sdk.android.httpdns.b;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.root.util.TimeFormatUtil;
import java.text.SimpleDateFormat;
/* loaded from: classes.dex */
public class c {
    private static final SimpleDateFormat a = new SimpleDateFormat(TimeFormatUtil.DEFAULT_PATTERN);

    public static long a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str) {
        try {
            return a.format(Long.valueOf(a(str) * 1000));
        } catch (Exception unused) {
            return a.format(Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(String str) {
        try {
            return String.valueOf(a.parse(str).getTime() / 1000);
        } catch (Exception unused) {
            return String.valueOf(System.currentTimeMillis() / 1000);
        }
    }
}
