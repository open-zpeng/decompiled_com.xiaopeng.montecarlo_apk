package com.xiaopeng.montecarlo.navcore.bean.sr;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class XPDecision implements Serializable {
    public static final int LANE_CHANGE_FAIL = 4;
    public static final int LANE_CHANGE_FINISH = 3;
    public static final int LANE_CHANGE_START = 2;
    public static final int LANE_CHANGE_WAIT = 1;
    public static final int LANE_KEEP_WAY = 0;
    public static final int RELATIVE_DIRECTION_ELSE = 99;
    public static final int RELATIVE_DIRECTION_LEFT = 1;
    public static final int RELATIVE_DIRECTION_RIGHT = 2;
    private int mChangeStatus;
    private int mDirection;
    private XPRelativePos mLocalRefPos;
    private ArrayList<XPRelativePos> mRelativePos;

    public ArrayList<XPRelativePos> getRelativePos() {
        return this.mRelativePos;
    }

    public void setRelativePos(ArrayList<XPRelativePos> arrayList) {
        this.mRelativePos = arrayList;
    }

    public XPRelativePos getLocalRefPos() {
        return this.mLocalRefPos;
    }

    public void setLocalRefPos(XPRelativePos xPRelativePos) {
        this.mLocalRefPos = xPRelativePos;
    }

    public int getChangeStatus() {
        return this.mChangeStatus;
    }

    public void setChangeStatus(int i) {
        this.mChangeStatus = i;
    }

    public int getDirection() {
        return this.mDirection;
    }

    public void setDirection(int i) {
        this.mDirection = i;
    }
}
