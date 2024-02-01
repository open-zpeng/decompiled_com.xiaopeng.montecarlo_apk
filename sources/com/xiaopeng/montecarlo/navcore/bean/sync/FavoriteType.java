package com.xiaopeng.montecarlo.navcore.bean.sync;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class FavoriteType {
    private static final int COMPANY = 3;
    public static final String COMPANY_STRING = "company";
    private static final int HOME = 2;
    public static final String HOME_STRING = "home";
    private static final int NORMAL = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface FavoriteTypeString {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Type {
    }
}
