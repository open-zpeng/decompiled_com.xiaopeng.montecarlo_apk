package com.autonavi.gbl.map.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class NaviOverlayType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int NaviOverlayTypeArc = 2;
    public static final int NaviOverlayTypeComposite = 3;
    public static final int NaviOverlayTypeCompositeStentil = 4;
    public static final int NaviOverlayTypeEndPoint = 1;
    public static final int NaviOverlayTypeStart2EndLine = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface NaviOverlayType1 {
    }
}
