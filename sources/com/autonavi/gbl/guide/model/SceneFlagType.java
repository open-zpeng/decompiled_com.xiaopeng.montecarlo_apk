package com.autonavi.gbl.guide.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class SceneFlagType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int SceneFlagTypeNormal = 0;
    public static final int SceneFlagTypeOrdinaryContinuation = 2;
    public static final int SceneFlagTypeParkGuide = 4;
    public static final int SceneFlagTypeServiceAreaContinuation = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface SceneFlagType1 {
    }
}
