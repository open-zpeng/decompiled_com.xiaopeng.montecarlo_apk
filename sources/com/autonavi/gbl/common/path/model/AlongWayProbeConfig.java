package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class AlongWayProbeConfig implements Serializable {
    public int hightwayProbeLength;
    public int maxProbeCount;
    public int maxProbeStepLength;
    public int maxServiceAreaCount;
    public int minProbeStepLength;

    public AlongWayProbeConfig() {
        this.hightwayProbeLength = 20000;
        this.maxProbeCount = 100;
        this.maxServiceAreaCount = 50;
        this.minProbeStepLength = 1000;
        this.maxProbeStepLength = 1500;
    }

    public AlongWayProbeConfig(int i, int i2, int i3, int i4, int i5) {
        this.hightwayProbeLength = i;
        this.maxProbeCount = i2;
        this.maxServiceAreaCount = i3;
        this.minProbeStepLength = i4;
        this.maxProbeStepLength = i5;
    }
}
