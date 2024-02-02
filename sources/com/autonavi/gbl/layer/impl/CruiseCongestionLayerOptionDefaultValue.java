package com.autonavi.gbl.layer.impl;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class CruiseCongestionLayerOptionDefaultValue {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int kCongestionLayerDistanceDeviation = 10;
    public static final int kCongestionLayerEndThreshold = 50;
    public static final int kCongestionLayerLeaveCongestionThreshold = 10;
    public static final int kCongestionLayerPreviewZoomRecoverTimeout = 30000;
    public static final int kCongestionLayerShowTimeout = 120000;
    public static final int kCongestionLayerStartThreshold = 10;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface CruiseCongestionLayerOptionDefaultValue1 {
    }
}
