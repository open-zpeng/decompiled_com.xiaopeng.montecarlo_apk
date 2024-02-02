package com.autonavi.gbl.map.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class OverlayGeometryType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int OverlayGeometryTypeArc = 3;
    public static final int OverlayGeometryTypeArrow = 4;
    public static final int OverlayGeometryTypeGroup = 6;
    public static final int OverlayGeometryTypeInvalid = 16777215;
    public static final int OverlayGeometryTypeLottie = 11;
    public static final int OverlayGeometryTypeModel = 7;
    public static final int OverlayGeometryTypePlane = 8;
    public static final int OverlayGeometryTypePoint = 0;
    public static final int OverlayGeometryTypePolygon = 2;
    public static final int OverlayGeometryTypePolyline = 1;
    public static final int OverlayGeometryTypeRaster = 9;
    public static final int OverlayGeometryTypeSkeleton = 10;
    public static final int OverlayGeometryTypeUnknow = 12;
    public static final int OverlayGeometryTypeVector = 5;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface OverlayGeometryType1 {
    }
}
