package com.xiaopeng.montecarlo.root.account;

import java.util.Observable;
/* loaded from: classes2.dex */
public class AMapAccountLoginObservable extends Observable {
    private static final AMapAccountLoginObservable sInstance = new AMapAccountLoginObservable();

    private AMapAccountLoginObservable() {
    }

    public static AMapAccountLoginObservable getInstance() {
        return sInstance;
    }

    public void changed() {
        setChanged();
    }
}
