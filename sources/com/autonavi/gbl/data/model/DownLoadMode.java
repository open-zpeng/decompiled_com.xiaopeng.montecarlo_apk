package com.autonavi.gbl.data.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class DownLoadMode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int DOWNLOAD_MODE_MAX = 2;
    public static final int DOWNLOAD_MODE_NET = 0;
    public static final int DOWNLOAD_MODE_USB = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface DownLoadMode1 {
    }
}
