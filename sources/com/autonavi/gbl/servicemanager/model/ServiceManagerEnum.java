package com.autonavi.gbl.servicemanager.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class ServiceManagerEnum {
    public static final int AosDevelopmentEnv = 1;
    public static final int AosProductionEnv = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface AosEnv {
    }
}
