package com.xiaopeng.montecarlo.navcore.bean.sr;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class XPWarnInfo implements Serializable {
    public static final int BSD_DIRECTION_LEFT = 1;
    public static final int BSD_DIRECTION_NONE = 0;
    public static final int BSD_DIRECTION_RIGHT = 2;
    public static final int WARN_GRADE_FIRST_WARN = 1;
    public static final int WARN_GRADE_SECOND_WARN = 2;
    public static final int WARN_GRADE_UN_WARN = 0;
    public static final int WARN_STATUS_NO = 0;
    public static final int WARN_STATUS_YES = 1;
    public static final int WARN_TYPE_AEB = 1;
    public static final int WARN_TYPE_BSD = 3;
    public static final int WARN_TYPE_FCW = 0;
    public static final int WARN_TYPE_RCW = 2;
    private int mBsdDirection;
    private int mWarnGrade;
    private int mWarnStatus;
    private int mWarnType;

    public int getWarnStatus() {
        return this.mWarnStatus;
    }

    public void setWarnStatus(int i) {
        this.mWarnStatus = i;
    }

    public int getWarnType() {
        return this.mWarnType;
    }

    public void setWarnType(int i) {
        this.mWarnType = i;
    }

    public int getBsdDirection() {
        return this.mBsdDirection;
    }

    public void setBsdDirection(int i) {
        this.mBsdDirection = i;
    }

    public int getWarnGrade() {
        return this.mWarnGrade;
    }

    public void setWarnGrade(int i) {
        this.mWarnGrade = i;
    }
}
