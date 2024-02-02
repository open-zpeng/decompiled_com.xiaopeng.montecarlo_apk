package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class RenderMapType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MAP_RENDERMAP_BEGIN = 0;
    public static final int MAP_RENDERMAP_DRAW = 1;
    public static final int MAP_RENDERMAP_END = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface RenderMapType1 {
    }
}
