package com.xiaopeng.montecarlo.root.util.logcat;

import android.os.Process;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes2.dex */
class LogMessage {
    private static SimpleDateFormat sSimpleDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    String mLevel;
    String mMsg;
    String mTag;
    long mCurrentTimeMillis = System.currentTimeMillis();
    int mPid = Process.myPid();
    int mTid = Process.myTid();

    public LogMessage(String str, String str2, String str3) {
        this.mLevel = str;
        this.mTag = str2;
        this.mMsg = str3;
    }

    public String getFormatMessage() {
        return String.format(Locale.US, "%s %d %d %s/%s: %s", sSimpleDateFormat.format(new Date(this.mCurrentTimeMillis)), Integer.valueOf(this.mPid), Integer.valueOf(this.mTid), this.mLevel, this.mTag, this.mMsg);
    }

    public String getFormatMessage(String str) {
        return String.format(Locale.US, "%s %d %d %s/%s version(%s): %s", sSimpleDateFormat.format(new Date(this.mCurrentTimeMillis)), Integer.valueOf(this.mPid), Integer.valueOf(this.mTid), this.mLevel, this.mTag, str, this.mMsg);
    }
}
