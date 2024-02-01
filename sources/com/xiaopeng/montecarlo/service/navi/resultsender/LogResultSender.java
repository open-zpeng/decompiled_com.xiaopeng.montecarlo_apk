package com.xiaopeng.montecarlo.service.navi.resultsender;

import android.content.Context;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.service.navi.NaviService;
import com.xiaopeng.montecarlo.service.navi.type.Request;
import com.xiaopeng.montecarlo.service.navi.type.Result;
/* loaded from: classes3.dex */
public final class LogResultSender implements IResultSender {
    @Override // com.xiaopeng.montecarlo.service.navi.resultsender.IResultSender
    public void sendResult(@NonNull Context context, @NonNull Request request, @NonNull Result result) {
        L.Tag tag = NaviService.TAG;
        L.i(tag, "LogResultSender request:" + request);
        L.Tag tag2 = NaviService.TAG;
        L.i(tag2, "LogResultSender result:" + result);
    }
}
