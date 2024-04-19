package com.autonavi.gbl.user.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class BehaviorDataType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int BehaviorTypeInvalid = -1;
    public static final int BehaviorTypePoi = 101;
    public static final int BehaviorTypeRouteBus = 103;
    public static final int BehaviorTypeRouteBusLine = 105;
    public static final int BehaviorTypeRouteDrive = 102;
    public static final int BehaviorTypeRouteHistoryBike = 305;
    public static final int BehaviorTypeRouteHistoryBus = 303;
    public static final int BehaviorTypeRouteHistoryDrive = 302;
    public static final int BehaviorTypeRouteHistoryTrain = 306;
    public static final int BehaviorTypeRouteHistoryWalk = 304;
    public static final int BehaviorTypeRouteWalk = 104;
    public static final int BehaviorTypeSearch = 301;
    public static final int BehaviorTypeSetting = 201;
    public static final int BehaviorTypeSettingAuto = 202;
    public static final int BehaviorTypeTrailBike = 402;
    public static final int BehaviorTypeTrailDriveForAuto = 403;
    public static final int BehaviorTypeTrailRun = 401;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface BehaviorDataType1 {
    }
}
