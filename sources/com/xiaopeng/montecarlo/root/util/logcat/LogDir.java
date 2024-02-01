package com.xiaopeng.montecarlo.root.util.logcat;
/* loaded from: classes3.dex */
public class LogDir {
    private String mAbsSourcePath;
    private boolean mNeedRecursive;
    private String mUdiskDirName;

    public LogDir(String str, String str2, boolean z) {
        this.mUdiskDirName = str;
        this.mAbsSourcePath = str2;
        this.mNeedRecursive = z;
    }

    public String getUdiskDirName() {
        return this.mUdiskDirName;
    }

    public String getAbsSourcePath() {
        return this.mAbsSourcePath;
    }

    public boolean isNeedRecursive() {
        return this.mNeedRecursive;
    }
}
