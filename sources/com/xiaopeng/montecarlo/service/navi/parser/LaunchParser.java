package com.xiaopeng.montecarlo.service.navi.parser;

import android.content.Context;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.service.navi.INaviParser;
import com.xiaopeng.montecarlo.service.navi.IRequestEventCallback;
/* loaded from: classes3.dex */
public class LaunchParser implements INaviParser {
    public static L.Tag TAG = new L.Tag("LaunchParser");

    @Override // com.xiaopeng.montecarlo.service.navi.INaviParser
    public void onCreate(@NonNull Context context) {
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviParser
    public void onHandleEvent(@NonNull Context context, @NonNull String str, @NonNull IRequestEventCallback iRequestEventCallback) {
        iRequestEventCallback.setNeedReturnResult(false, null);
        iRequestEventCallback.setNeedStartMainActivity(true);
        iRequestEventCallback.allWorkEnd();
    }
}
