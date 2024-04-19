package com.xiaopeng.montecarlo.root.httpclient.core;
/* loaded from: classes3.dex */
public class HardCodedTarget<T> {
    private final Class<T> mType;

    public HardCodedTarget(Class<T> cls) {
        this.mType = cls;
    }

    public Class<T> type() {
        return this.mType;
    }
}
