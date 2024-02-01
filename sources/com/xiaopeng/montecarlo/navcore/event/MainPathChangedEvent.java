package com.xiaopeng.montecarlo.navcore.event;
/* loaded from: classes3.dex */
public class MainPathChangedEvent {
    public static final int MAIN_PATH_CHANGED = 0;
    private int mEvent;

    public MainPathChangedEvent(int i) {
        this.mEvent = i;
    }

    public int getEvent() {
        return this.mEvent;
    }
}
