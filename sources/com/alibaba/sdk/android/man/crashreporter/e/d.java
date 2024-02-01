package com.alibaba.sdk.android.man.crashreporter.e;

import com.xiaopeng.montecarlo.root.util.TimeFormatUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes.dex */
public class d {
    public static String b(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeFormatUtil.DEFAULT_PATTERN);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return simpleDateFormat.format(new Date(j));
    }
}
