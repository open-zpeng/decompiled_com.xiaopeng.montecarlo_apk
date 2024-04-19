package com.xiaopeng.montecarlo.navcore.search.policy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class NetworkPolicy {
    public static final int OFFLINE_FIRST = 2;
    public static final int OFFLINE_ONLY = 4;
    public static final int ONLINE_FIRST = 1;
    public static final int ONLINE_ONLY = 3;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Mode {
    }
}
