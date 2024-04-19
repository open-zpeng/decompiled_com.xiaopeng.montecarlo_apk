package com.xiaopeng.montecarlo.dynamiclevel.base;

import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public abstract class DynamicLevelSetting {
    public static final int ERROR_DEGREE = 10000;
    private static final L.Tag TAG = new L.Tag("DynamicLevelSetting");
    protected boolean mIsRefreshFail;

    public float getCameraDegree() {
        return 10000.0f;
    }

    public abstract float getLevel();

    public abstract boolean isEnableDynamicDegree();

    public float getGradientInterval(float f, float f2, int i, int i2) {
        float f3 = (f - f2) / ((i * 1000) / i2);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.v(tag, " getGradientInterval from :" + f + "  to :" + f2 + "  in seconds:" + i);
        }
        return f3;
    }

    public void refreshFail() {
        this.mIsRefreshFail = true;
    }

    /* loaded from: classes2.dex */
    public static class SettingInfo {
        public int end;
        public float level;
        public int start;

        public SettingInfo(int i, int i2, float f) {
            this.start = i;
            this.end = i2;
            this.level = f;
        }
    }
}
