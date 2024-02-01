package com.xiaopeng.speech.jarvisproto;

import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
/* loaded from: classes3.dex */
public abstract class JarvisProto {
    public abstract String getEvent();

    public abstract String getJsonData();

    public String toString() {
        return getClass().getSimpleName() + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + getJsonData();
    }
}
