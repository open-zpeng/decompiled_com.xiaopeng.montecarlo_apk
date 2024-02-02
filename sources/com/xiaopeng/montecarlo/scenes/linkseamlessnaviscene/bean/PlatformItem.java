package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.bean;

import androidx.annotation.DrawableRes;
/* loaded from: classes2.dex */
public class PlatformItem {
    public static final int PLATFORM_AMAP = 258;
    public static final int PLATFORM_BAIDU = 259;
    public static final int PLATFORM_DIANPING = 260;
    public static final int PLATFORM_MEITUAN = 261;
    public static final int PLATFORM_WECHAT = 257;
    public static final int PLATFORM_XIAOPENG = 256;
    public int mPlatformType;
    @DrawableRes
    public int mResId;

    public PlatformItem(int i, int i2) {
        this.mResId = i;
        this.mPlatformType = i2;
    }
}
