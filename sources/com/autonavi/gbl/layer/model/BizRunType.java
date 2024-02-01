package com.autonavi.gbl.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class BizRunType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int BizRunTypeAfterData = 2;
    public static final int BizRunTypeBeforeData = 1;
    public static final int BizRunTypeCarLoc = 64;
    public static final int BizRunTypeCollision = 16;
    public static final int BizRunTypeMoveBegin = 512;
    public static final int BizRunTypeNaviInfo = 128;
    public static final int BizRunTypeNone = 0;
    public static final int BizRunTypePathChanged = 32;
    public static final int BizRunTypePreviewStatus = 256;
    public static final int BizRunTypeRunning = 4;
    public static final int BizRunTypeUpdate = 8;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface BizRunType1 {
    }
}
