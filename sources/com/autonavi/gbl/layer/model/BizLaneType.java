package com.autonavi.gbl.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class BizLaneType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int BizLaneTypeGuideCamera = 10001;
    public static final int BizLaneTypeGuideCongestion = 10002;
    public static final int BizLaneTypeGuideEnd = 10006;
    public static final int BizLaneTypeGuideEvent = 10003;
    public static final int BizLaneTypeGuideTurn = 10004;
    public static final int BizLaneTypeGuideVia = 10005;
    public static final int BizLaneTypeInvalid = 10000;
    public static final int BizLaneTypeMax = 10007;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface BizLaneType1 {
    }
}
