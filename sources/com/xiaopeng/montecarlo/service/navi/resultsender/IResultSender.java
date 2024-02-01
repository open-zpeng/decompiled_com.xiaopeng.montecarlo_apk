package com.xiaopeng.montecarlo.service.navi.resultsender;

import android.content.Context;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.service.navi.type.Request;
import com.xiaopeng.montecarlo.service.navi.type.Result;
/* loaded from: classes3.dex */
public interface IResultSender {
    void sendResult(@NonNull Context context, @NonNull Request request, @NonNull Result result);
}
