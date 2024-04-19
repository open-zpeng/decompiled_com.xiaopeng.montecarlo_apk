package com.autonavi.gbl.card.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class ResourceType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int ResourceTypeLoaderNotSupport = 0;
    public static final int ResourceTypeNormal = 2;
    public static final int ResourceTypeNotFound = 1;
    public static final int ResourceTypeVector = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface ResourceType1 {
    }
}
