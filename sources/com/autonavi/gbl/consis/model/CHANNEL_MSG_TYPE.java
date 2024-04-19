package com.autonavi.gbl.consis.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class CHANNEL_MSG_TYPE {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int CHANNEL_MSG_BL_CONSIS = 5500;
    public static final int CHANNEL_MSG_BL_CUSTOM = 5000;
    public static final int CHANNEL_MSG_BL_RENDER = 9000;
    public static final int CHANNEL_MSG_CHANNEL_CREATE = 1;
    public static final int CHANNEL_MSG_CHANNEL_DESTROY = 2;
    public static final int CHANNEL_MSG_CUSTOM = 10000;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface CHANNEL_MSG_TYPE1 {
    }
}
