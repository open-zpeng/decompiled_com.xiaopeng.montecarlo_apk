package com.xiaopeng.montecarlo.events;

import android.os.Bundle;
/* loaded from: classes.dex */
public class RouteRequestUpdateEvent {
    public static final int ADD_VIA = 0;
    public static final int NEW_DESTINATION = 1;
    private int mAction;
    private Bundle mBundle;

    public RouteRequestUpdateEvent(int i, Bundle bundle) {
        this.mAction = i;
        this.mBundle = bundle;
    }

    public int getAction() {
        return this.mAction;
    }

    public void setAction(int i) {
        this.mAction = i;
    }

    public Bundle getBundle() {
        return this.mBundle;
    }

    public void setBundle(Bundle bundle) {
        this.mBundle = bundle;
    }
}
