package com.autonavi.gbl.guide.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class TmcSpotPicState {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int SpotPicAlreadyExist = 5;
    public static final int SpotPicMissCacheDir = 7;
    public static final int SpotPicRequesCancel = 3;
    public static final int SpotPicRequesFail = 2;
    public static final int SpotPicRequesSuccess = 1;
    public static final int SpotPicRequestRepeat = 4;
    public static final int SpotPicUnknownState = 0;
    public static final int SpotPicUrlEmpty = 6;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface TmcSpotPicState1 {
    }
}
