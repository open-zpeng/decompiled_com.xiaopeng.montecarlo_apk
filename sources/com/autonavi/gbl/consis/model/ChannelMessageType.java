package com.autonavi.gbl.consis.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class ChannelMessageType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int ChannelMessageBlConsis = 5500;
    public static final int ChannelMessageBlCustom = 5000;
    public static final int ChannelMessageBlDisplay = 9000;
    public static final int ChannelMessageChannelCreate = 1;
    public static final int ChannelMessageChannelDestroy = 2;
    public static final int ChannelMessageCustom = 10000;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface ChannelMessageType1 {
    }
}
