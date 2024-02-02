package com.xiaopeng.montecarlo.root.dataprovider;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.dataprovider.BaseParameter;
import com.xiaopeng.montecarlo.root.dataprovider.BaseResultData;
/* loaded from: classes2.dex */
public interface BaseCallBack<P extends BaseParameter, D extends BaseResultData> {
    boolean isLegal();

    @MainThread
    void onDataCache(@NonNull D d);

    @MainThread
    void onDataFetched(@NonNull D d);

    @MainThread
    void onError(int i, @NonNull String str);

    @MainThread
    void onFetchComplete(P p);

    @MainThread
    void onFetchStart(P p);
}
