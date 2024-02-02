package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class MapMessageType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MapMessageTypAll = 5;
    public static final int MapMessageTypeGesture = 0;
    public static final int MapMessageTypeNavi = 2;
    public static final int MapMessageTypePosture = 1;
    public static final int MapMessageTypeState = 3;
    public static final int MapMessageTypeUnknow = 4;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface MapMessageType1 {
    }
}
