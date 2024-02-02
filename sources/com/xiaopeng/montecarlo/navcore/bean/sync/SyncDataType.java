package com.xiaopeng.montecarlo.navcore.bean.sync;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class SyncDataType {
    public static final int SYNC_EVENT_FAVORITE = 1;
    public static final int SYNC_EVENT_HISTORY = 2;
    public static final int SYNC_EVENT_NONE = 0;
    public static final int SYNC_EVENT_SETTING = 3;
    public static final int SYNC_EVENT_VALUME = 4;
    public static final int SYNC_EVENT_VISUAL_ANGLE = 5;
    public static final Integer[] SYNC_EVENT_FAVORITE_CHLID_TYPE_LIST = {1};
    public static final Integer[] SYNC_EVENT_HISTORY_CHILD_TYPE_LIST = new Integer[0];
    public static final Integer[] SYNC_EVENT_ALL_CHILD_TYPE_LIST = new Integer[0];

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface DataType {
    }
}
