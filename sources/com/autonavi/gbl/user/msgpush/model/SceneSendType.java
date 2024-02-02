package com.autonavi.gbl.user.msgpush.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class SceneSendType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int SceneTypeAddPathPoint = 5;
    public static final int SceneTypeAppendPlanPref = 7;
    public static final int SceneTypeCancelPlanPref = 8;
    public static final int SceneTypeChangeDestination = 3;
    public static final int SceneTypeDelPathPoint = 6;
    public static final int SceneTypeInvalid = 0;
    public static final int SceneTypeManual = 1;
    public static final int SceneTypeNaviImmediately = 4;
    public static final int SceneTypeStartNavi = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface SceneSendType1 {
    }
}
