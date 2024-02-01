package com.autonavi.gbl.map.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class OpenLayerStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int OPEN_LAYER_STATUS_APPENDED = 2;
    public static final int OPEN_LAYER_STATUS_INVALID = -1;
    public static final int OPEN_LAYER_STATUS_NOT_IN = 1;
    public static final int OPEN_LAYER_STATUS_SHOWED = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface OpenLayerStatus1 {
    }
}
