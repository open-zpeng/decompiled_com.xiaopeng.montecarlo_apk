package com.autonavi.gbl.search.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class SearchPoiPayType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int SearchPoiPayAlipay = 7;
    public static final int SearchPoiPayCash = 8;
    public static final int SearchPoiPayETC = 11;
    public static final int SearchPoiPayFree = 1;
    public static final int SearchPoiPayManual = 2;
    public static final int SearchPoiPayOther = 0;
    public static final int SearchPoiPayWechat = 6;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface SearchPoiPayType1 {
    }
}
