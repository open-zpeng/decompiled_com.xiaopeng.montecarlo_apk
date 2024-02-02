package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class ReportType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int ReportTypeAddress = 3;
    public static final int ReportTypeCondition = 100;
    public static final int ReportTypeDecoder = 1000;
    public static final int ReportTypeFile = 2;
    public static final int ReportTypeMemory = 1;
    public static final int ReportTypeShader = 1002;
    public static final int ReportTypeSqldb = 1001;
    public static final int ReportTypeString = 4;
    public static final int ReportTypeTexture = 5;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface ReportType1 {
    }
}
