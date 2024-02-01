package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class MapLabelType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LABEL_Type_Indoor = 2;
    public static final int LABEL_Type_Normal = 0;
    public static final int LABEL_Type_OPENLAYER = 4;
    public static final int LABEL_Type_SEARCH_RESULT = 3;
    public static final int LABEL_Type_Scenic = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface MapLabelType1 {
    }
}
