package com.autonavi.gbl.user.syncsdk.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class SyncEventType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int SyncSdkEventBackupEnd = 2;
    public static final int SyncSdkEventBackupStart = 1;
    public static final int SyncSdkEventDataUpdated = 5;
    public static final int SyncSdkEventDatabaseInitDone = 10;
    public static final int SyncSdkEventFirstSync = 9;
    public static final int SyncSdkEventMergeEnd = 8;
    public static final int SyncSdkEventMergeStart = 7;
    public static final int SyncSdkEventSyncEnd = 4;
    public static final int SyncSdkEventSyncStart = 3;
    public static final int SyncSdkEventWantMergeLocalDataToUser = 6;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface SyncEventType1 {
    }
}
