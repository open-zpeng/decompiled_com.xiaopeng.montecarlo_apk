package com.autonavi.gbl.user.syncsdk.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class SyncRet {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int SyncRetAbort = 1289;
    public static final int SyncRetBusy = 1284;
    public static final int SyncRetError = 1280;
    public static final int SyncRetErrorBase = 1280;
    public static final int SyncRetExiting = 1288;
    public static final int SyncRetInvalidCall = 1285;
    public static final int SyncRetInvalidJson = 1290;
    public static final int SyncRetInvalidParam = 1281;
    public static final int SyncRetJniInvalidParam = 1292;
    public static final int SyncRetNetworkError = 1480;
    public static final int SyncRetNetworkFileDescriptionNotFound = 1489;
    public static final int SyncRetNetworkFileHashNotFound = 1490;
    public static final int SyncRetNetworkFileNotFound = 1486;
    public static final int SyncRetNetworkFileOversized = 1488;
    public static final int SyncRetNetworkLicenseExpired = 1484;
    public static final int SyncRetNetworkLoginInfoInvalid = 1485;
    public static final int SyncRetNetworkParse = 1481;
    public static final int SyncRetNetworkRequestBodyOverload = 1487;
    public static final int SyncRetNetworkSignFailed = 1483;
    public static final int SyncRetNetworkUnexpected = 1482;
    public static final int SyncRetNetworkUnknownError = 1491;
    public static final int SyncRetNotExist = 1282;
    public static final int SyncRetNotImplement = 1291;
    public static final int SyncRetOffline = 1283;
    public static final int SyncRetPostponed = 1286;
    public static final int SyncRetSqliteBegin = 1580;
    public static final int SyncRetSqliteCantOpen = 1583;
    public static final int SyncRetSqliteIOError = 1582;
    public static final int SyncRetSqliteNotADB = 1585;
    public static final int SyncRetSqlitePerm = 1581;
    public static final int SyncRetSqlitePrepareError = 1584;
    public static final int SyncRetSuccess = 0;
    public static final int SyncRetThreadBegin = 1380;
    public static final int SyncRetThreadStart = 1381;
    public static final int SyncRetTrailDriveRequest = 403;
    public static final int SyncRetUserStatusIncorrect = 1287;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface SyncRet1 {
    }
}
