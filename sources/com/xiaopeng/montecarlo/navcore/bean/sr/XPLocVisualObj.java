package com.xiaopeng.montecarlo.navcore.bean.sr;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class XPLocVisualObj implements Serializable {
    private int mCntMarkings;
    private int mCntPoles;
    private int mCntTrafficLights;
    private long mCntTrafficSigns;
    private LocMarking[] mMarkings;
    private LocPole[] mPoles;
    private LocTrafficLight[] mTrafficLights;
    private LocTrafficSign[] mTrafficSigns;

    public long getCntTrafficSigns() {
        return this.mCntTrafficSigns;
    }

    public void setCntTrafficSigns(long j) {
        this.mCntTrafficSigns = j;
    }

    public LocTrafficSign[] getTrafficSigns() {
        return this.mTrafficSigns;
    }

    public void setTrafficSigns(LocTrafficSign[] locTrafficSignArr) {
        this.mTrafficSigns = locTrafficSignArr;
    }

    public int getCntPoles() {
        return this.mCntPoles;
    }

    public void setCntPoles(int i) {
        this.mCntPoles = i;
    }

    public LocPole[] getPoles() {
        return this.mPoles;
    }

    public void setPoles(LocPole[] locPoleArr) {
        this.mPoles = locPoleArr;
    }

    public int getCntMarkings() {
        return this.mCntMarkings;
    }

    public void setCntMarkings(int i) {
        this.mCntMarkings = i;
    }

    public LocMarking[] getMarkings() {
        return this.mMarkings;
    }

    public void setMarkings(LocMarking[] locMarkingArr) {
        this.mMarkings = locMarkingArr;
    }

    public int getCntTrafficLights() {
        return this.mCntTrafficLights;
    }

    public void setCntTrafficLights(int i) {
        this.mCntTrafficLights = i;
    }

    public LocTrafficLight[] getTrafficLights() {
        return this.mTrafficLights;
    }

    public void setTrafficLights(LocTrafficLight[] locTrafficLightArr) {
        this.mTrafficLights = locTrafficLightArr;
    }
}
