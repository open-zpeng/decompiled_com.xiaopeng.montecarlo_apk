package com.autonavi.gbl.search.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class ShelfSourceType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int AmapShopShelf = 1;
    public static final int KouBeiShelf = 0;
    public static final int LianLianShelf = 4;
    public static final int UnknownShelf = -1;
    public static final int XiangKuShelf = 3;
    public static final int XinYangShelf = 2;
    public static final int ZiWoYouShelf = 5;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface ShelfSourceType1 {
    }
}
