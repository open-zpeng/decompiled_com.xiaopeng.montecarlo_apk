package com.xiaopeng.montecarlo.navcore.bean.sync;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class SyncType {
    public static final int TYPE_BL_PULL = 55;
    public static final int TYPE_BL_UPLOAD = 56;
    public static final int TYPE_XP_DEL_USER_DATA = 4;
    public static final int TYPE_XP_PULL = 1;
    public static final int TYPE_XP_UPLOAD = 2;
    public static final int TYPE_XP_UPLOAD_IF_FAIL = 3;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Type {
    }
}
