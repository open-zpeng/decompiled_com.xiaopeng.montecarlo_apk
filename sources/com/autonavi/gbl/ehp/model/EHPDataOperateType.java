package com.autonavi.gbl.ehp.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class EHPDataOperateType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int EHPDataOperateTypeAdd = 3;
    public static final int EHPDataOperateTypeDelete = 2;
    public static final int EHPDataOperateTypeUnknown = 0;
    public static final int EHPDataOperateTypeUpdate = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface EHPDataOperateType1 {
    }
}
