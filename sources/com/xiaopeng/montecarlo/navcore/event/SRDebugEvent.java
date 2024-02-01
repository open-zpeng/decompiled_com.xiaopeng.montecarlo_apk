package com.xiaopeng.montecarlo.navcore.event;
/* loaded from: classes3.dex */
public class SRDebugEvent {
    public static final int SR_DATA_DISPLAY_STATUS = 3;
    public static final int SR_DATA_DRIVE_MODE_STATUS = 6;
    public static final int SR_DATA_FRAME_INFO = 7;
    public static final int SR_DATA_INFO_TIPS = 0;
    public static final int SR_DATA_LANE_STATUS = 4;
    public static final int SR_DATA_LC_TIPS_AND_ODD_STATUS = 1;
    public static final int SR_DATA_LNDS_DIS = 8;
    public static final int SR_DATA_OPERATE_STATUS = 2;
    public static final int SR_DATA_TTS_STATUS = 5;
    public int mTipsType;
    public int mTipsType1;
    private int mType;

    public SRDebugEvent(int i) {
        this.mType = i;
    }

    public int getType() {
        return this.mType;
    }
}
