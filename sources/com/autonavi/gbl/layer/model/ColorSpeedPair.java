package com.autonavi.gbl.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ColorSpeedPair implements Serializable {
    public int mMaxspeed;
    public int mMinspeed;
    public String mStrColorvalue;

    public ColorSpeedPair() {
        this.mMinspeed = 0;
        this.mMaxspeed = 0;
        this.mStrColorvalue = "";
    }

    public ColorSpeedPair(int i, int i2, String str) {
        this.mMinspeed = i;
        this.mMaxspeed = i2;
        this.mStrColorvalue = str;
    }
}
