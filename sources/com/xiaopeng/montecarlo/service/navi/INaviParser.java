package com.xiaopeng.montecarlo.service.navi;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public interface INaviParser {
    void onCreate(@NonNull Context context);

    void onHandleEvent(@NonNull Context context, @NonNull String str, @NonNull IRequestEventCallback iRequestEventCallback);
}
