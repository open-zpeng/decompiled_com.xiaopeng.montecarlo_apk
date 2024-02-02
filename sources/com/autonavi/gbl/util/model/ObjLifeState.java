package com.autonavi.gbl.util.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class ObjLifeState {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int CONSTRUCT_DONE_STATE = 1;
    public static final int CONSTRUCT_STATE = 0;
    public static final int DESTRUCT_READY_STATE = 2;
    public static final int DESTRUCT_STATE = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface ObjLifeState1 {
    }
}
