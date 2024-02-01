package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class ELocalizationType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int ELocalizationTypeDeadReckoning = 2;
    public static final int ELocalizationTypeHighDefinition = 5;
    public static final int ELocalizationTypeInit = 0;
    public static final int ELocalizationTypeMapMatching = 3;
    public static final int ELocalizationTypeNone = 1;
    public static final int ELocalizationTypeNull = -1;
    public static final int ELocalizationTypeStandardDefinition = 4;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface ELocalizationType1 {
    }
}
