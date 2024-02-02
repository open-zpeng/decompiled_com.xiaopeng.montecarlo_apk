package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocDriveSceneType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LocRoadSceneNull = 0;
    public static final int LocRoadSceneTunnel = 1;
    public static final int LocRoadSceneTunnelOrUnderground = 3;
    public static final int LocRoadSceneUnderground = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocDriveSceneType1 {
    }
}
