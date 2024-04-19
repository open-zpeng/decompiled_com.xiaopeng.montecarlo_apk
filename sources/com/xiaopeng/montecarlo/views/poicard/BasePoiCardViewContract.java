package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.view.View;
import java.util.Map;
/* loaded from: classes3.dex */
public interface BasePoiCardViewContract {
    void executeAfterViewInflated(View view);

    void executeViewOperation();

    void formatParams(Context context, Map<String, Object> map);

    void init(Context context, Map<String, Object> map);

    void onInitOrThemeSwitch();

    void refresh(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener);

    void setViewListener();
}
