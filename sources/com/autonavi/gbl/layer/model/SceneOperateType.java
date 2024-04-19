package com.autonavi.gbl.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class SceneOperateType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int SCENE_OPERATE_AFTER_ENTER = 2;
    public static final int SCENE_OPERATE_AFTER_LEAVE = 4;
    public static final int SCENE_OPERATE_BEFORE_ENTER = 1;
    public static final int SCENE_OPERATE_BEFORE_LEAVE = 3;
    public static final int SCENE_OPERATE_NONE = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface SceneOperateType1 {
    }
}
