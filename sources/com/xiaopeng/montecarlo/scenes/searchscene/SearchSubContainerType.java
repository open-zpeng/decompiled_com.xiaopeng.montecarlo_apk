package com.xiaopeng.montecarlo.scenes.searchscene;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class SearchSubContainerType {
    public static final int FAVORITE_TYPE = 1;
    public static final int HISTORY_TYPE = 2;
    public static final int SEARCH_TYPE = 0;
    private int mType = 2;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SubContainerType {
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
