package com.autonavi.gbl.util.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class ValueType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int ValueTypeArray = 2;
    public static final int ValueTypeBinary = 8;
    public static final int ValueTypeBoolean = 4;
    public static final int ValueTypeFloat = 7;
    public static final int ValueTypeInt64 = 5;
    public static final int ValueTypeNull = 0;
    public static final int ValueTypeObject = 1;
    public static final int ValueTypeString = 3;
    public static final int ValueTypeUInt64 = 6;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface ValueType1 {
    }
}
