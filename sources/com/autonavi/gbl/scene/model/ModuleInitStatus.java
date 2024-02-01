package com.autonavi.gbl.scene.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class ModuleInitStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int ModuleInitDoing = 2;
    public static final int ModuleInitDone = 3;
    public static final int ModuleNotInit = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface ModuleInitStatus1 {
    }
}
