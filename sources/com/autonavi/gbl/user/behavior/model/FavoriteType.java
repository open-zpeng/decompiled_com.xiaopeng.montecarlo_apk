package com.autonavi.gbl.user.behavior.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class FavoriteType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int FavoriteTypeCompany = 2;
    public static final int FavoriteTypeHome = 1;
    public static final int FavoriteTypePoi = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface FavoriteType1 {
    }
}
