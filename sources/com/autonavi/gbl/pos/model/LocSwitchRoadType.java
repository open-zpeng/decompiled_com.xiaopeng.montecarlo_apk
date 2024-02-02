package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocSwitchRoadType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LocSwitchDownBridgeToUpBridge = 3;
    public static final int LocSwitchMainToSide = 0;
    public static final int LocSwitchNull = -1;
    public static final int LocSwitchSideToMain = 1;
    public static final int LocSwitchUpBridgeToDownBridge = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocSwitchRoadType1 {
    }
}
