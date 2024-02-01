package com.xiaopeng.montecarlo.navcore.bean.sync;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class SyncOperationType {
    public static final int ADD = 1;
    public static final int DELETE = 3;
    public static final int REPLACE = 4;
    public static final int UPDATE = 2;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface OperationType {
    }
}
