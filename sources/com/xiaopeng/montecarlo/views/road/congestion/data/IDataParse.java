package com.xiaopeng.montecarlo.views.road.congestion.data;

import androidx.annotation.ColorInt;
/* loaded from: classes3.dex */
public interface IDataParse<T> {
    @ColorInt
    int parseCongestionColor();

    IDataParse parseCongestionData(T t);

    CharSequence parseCongestionStr();
}
