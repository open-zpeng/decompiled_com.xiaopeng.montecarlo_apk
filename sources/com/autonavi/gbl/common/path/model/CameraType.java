package com.autonavi.gbl.common.path.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class CameraType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int CameraTypeBicyclelane = 6;
    public static final int CameraTypeBreakRule = 3;
    public static final int CameraTypeBusway = 4;
    public static final int CameraTypeConsequent = 255;
    public static final int CameraTypeETC = 11;
    public static final int CameraTypeEmergencyLane = 5;
    public static final int CameraTypeFlowSpeed = 10;
    public static final int CameraTypeIntervalvelocity = 7;
    public static final int CameraTypeIntervalvelocityend = 9;
    public static final int CameraTypeIntervalvelocitystart = 8;
    public static final int CameraTypeSpeed = 0;
    public static final int CameraTypeSurveillance = 1;
    public static final int CameraTypeTrafficLight = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface CameraType1 {
    }
}
