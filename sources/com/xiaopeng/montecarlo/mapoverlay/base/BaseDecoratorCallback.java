package com.xiaopeng.montecarlo.mapoverlay.base;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import java.util.List;
/* loaded from: classes2.dex */
public interface BaseDecoratorCallback {
    MainContext getMainContext();

    void onClearFocus(XPPointBaseData xPPointBaseData);

    void onFocus(boolean z);

    void onLoad();

    void onPointUpdate(@NonNull List<XPPointBaseData> list, @NonNull List<XPPointBaseData> list2, @NonNull List<XPPointBaseData> list3);
}
