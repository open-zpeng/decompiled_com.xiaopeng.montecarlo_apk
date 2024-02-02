package com.xiaopeng.montecarlo.scenes.searchscene;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class SearchScenePoiType {
    public static final int TYPE_COMPANY = 1;
    public static final int TYPE_FAVOURITE = 2;
    public static final int TYPE_HOME = 0;
    public static final int TYPE_INVALID = -1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PoiType {
    }
}
