package com.xiaopeng.montecarlo.root.util;
/* loaded from: classes3.dex */
public class IdGenerator {
    private long mLastTs = 0;

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    public synchronized long nextId() {
        long timeGen;
        timeGen = timeGen();
        if (timeGen <= this.mLastTs) {
            timeGen = this.mLastTs + 1;
        }
        this.mLastTs = timeGen;
        return timeGen;
    }
}
