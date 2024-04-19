package com.xiaopeng.montecarlo.root;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.dataprovider.BaseParameter;
import com.xiaopeng.montecarlo.root.dataprovider.BaseResultData;
/* loaded from: classes3.dex */
public interface XpBaseCallBack<P extends BaseParameter, D extends BaseResultData> extends BaseCallBack<P, D> {
    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    void onError(int i, @NonNull String str);

    @MainThread
    void onError(@NonNull P p, int i, @NonNull String str);
}
