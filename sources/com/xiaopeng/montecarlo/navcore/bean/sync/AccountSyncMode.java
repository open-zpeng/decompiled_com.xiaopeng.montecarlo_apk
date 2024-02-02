package com.xiaopeng.montecarlo.navcore.bean.sync;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class AccountSyncMode {
    public static final int SYNC_LATER = 2;
    public static final int SYNC_NOW = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface SyncMode {
    }
}
