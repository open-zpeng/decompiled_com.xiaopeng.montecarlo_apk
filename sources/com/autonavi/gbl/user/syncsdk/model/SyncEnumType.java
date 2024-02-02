package com.autonavi.gbl.user.syncsdk.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class SyncEnumType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int SyncTypeCustom = -1;
    public static final int SyncTypePoi = 0;
    public static final int SyncTypeRouteBus = 2;
    public static final int SyncTypeRouteBusLine = 4;
    public static final int SyncTypeRouteDrive = 1;
    public static final int SyncTypeRouteHistoryBike = 11;
    public static final int SyncTypeRouteHistoryBus = 9;
    public static final int SyncTypeRouteHistoryDrive = 8;
    public static final int SyncTypeRouteHistoryTrain = 12;
    public static final int SyncTypeRouteHistoryWalk = 10;
    public static final int SyncTypeRouteWalk = 3;
    public static final int SyncTypeSearch = 7;
    public static final int SyncTypeSetting = 5;
    public static final int SyncTypeSettingAuto = 6;
    public static final int SyncTypeTrailBike = 14;
    public static final int SyncTypeTrailDriveForAuto = 15;
    public static final int SyncTypeTrailRun = 13;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface SyncEnumType1 {
    }
}
