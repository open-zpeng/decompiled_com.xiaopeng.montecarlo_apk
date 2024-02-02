package com.xiaopeng.montecarlo.navcore.bean.location;

import com.autonavi.gbl.pos.model.LocAcce3d;
import com.autonavi.gbl.pos.model.LocGnss;
import com.autonavi.gbl.pos.model.LocGpgsv;
import com.autonavi.gbl.pos.model.LocGyro;
import com.autonavi.gbl.pos.model.LocPulse;
/* loaded from: classes2.dex */
public class XPPosInfo {
    private LocAcce3d mAcce3d;
    private LocGnss mGnss;
    private LocGpgsv mGpgsv;
    private LocGyro mGyro;
    private LocPulse mPulse;

    public XPPosInfo setAcce3d(LocAcce3d locAcce3d) {
        this.mAcce3d = locAcce3d;
        return this;
    }

    public XPPosInfo setGnss(LocGnss locGnss) {
        this.mGnss = locGnss;
        return this;
    }

    public XPPosInfo setGpgsv(LocGpgsv locGpgsv) {
        this.mGpgsv = locGpgsv;
        return this;
    }

    public XPPosInfo setGyro(LocGyro locGyro) {
        this.mGyro = locGyro;
        return this;
    }

    public XPPosInfo setPulse(LocPulse locPulse) {
        this.mPulse = locPulse;
        return this;
    }

    public String toString() {
        return "XPPosInfo(mGnss=" + getGnss() + ", mGyro=" + getGyro() + ", mPulse=" + getPulse() + ", mGpgsv=" + getGpgsv() + ", mAcce3d=" + getAcce3d() + ")";
    }

    public LocGnss getGnss() {
        return this.mGnss;
    }

    public LocGyro getGyro() {
        return this.mGyro;
    }

    public LocPulse getPulse() {
        return this.mPulse;
    }

    public LocGpgsv getGpgsv() {
        return this.mGpgsv;
    }

    public LocAcce3d getAcce3d() {
        return this.mAcce3d;
    }
}
