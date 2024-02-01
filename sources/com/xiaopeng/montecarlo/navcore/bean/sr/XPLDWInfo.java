package com.xiaopeng.montecarlo.navcore.bean.sr;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class XPLDWInfo implements Serializable {
    public static final int LDW_DIRECTION_LEFT = 0;
    public static final int LDW_DIRECTION_RIGHT = 1;
    public static final int LDW_STATUS_NO = 0;
    public static final int LDW_STATUS_YES = 1;
    private int mDirection;
    private int mStatus;

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public int getDirection() {
        return this.mDirection;
    }

    public void setDirection(int i) {
        this.mDirection = i;
    }
}
