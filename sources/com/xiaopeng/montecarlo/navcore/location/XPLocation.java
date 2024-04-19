package com.xiaopeng.montecarlo.navcore.location;

import android.location.Location;
/* loaded from: classes3.dex */
public class XPLocation {
    private Location mLocation;
    private boolean mTypeWGS84;

    public XPLocation setLocation(Location location) {
        this.mLocation = location;
        return this;
    }

    public XPLocation setTypeWGS84(boolean z) {
        this.mTypeWGS84 = z;
        return this;
    }

    public Location getLocation() {
        return this.mLocation;
    }

    public boolean isTypeWGS84() {
        return this.mTypeWGS84;
    }
}
