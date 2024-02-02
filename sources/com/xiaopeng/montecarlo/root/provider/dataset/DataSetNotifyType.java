package com.xiaopeng.montecarlo.root.provider.dataset;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class DataSetNotifyType {
    public static final int NOTIFY_ALL = 1;
    public static final int NOTIFY_BL = 2;
    public static final int NOTIFY_NONE = 0;
    public static final int NOTIFY_XP = 3;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface NotifyType {
    }
}
