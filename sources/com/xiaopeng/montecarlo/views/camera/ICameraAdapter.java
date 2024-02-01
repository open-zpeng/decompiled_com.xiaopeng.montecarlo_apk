package com.xiaopeng.montecarlo.views.camera;

import java.util.List;
/* loaded from: classes3.dex */
public interface ICameraAdapter {
    int getDataCount();

    void renderDayNightTheme();

    void setData(List<ICameraData> list);
}
