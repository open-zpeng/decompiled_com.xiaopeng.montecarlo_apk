package com.autonavi.gbl.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class BizUserType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int BizUserTypeFavoriteMain = 8004;
    public static final int BizUserTypeFavoritePoi = 8005;
    public static final int BizUserTypeGpsTrack = 8001;
    public static final int BizUserTypeGpsTrackLine = 8002;
    public static final int BizUserTypeInvalid = 8000;
    public static final int BizUserTypeMax = 8007;
    public static final int BizUserTypeRainbowLine = 8006;
    public static final int BizUserTypeSendToCar = 8003;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface BizUserType1 {
    }
}
