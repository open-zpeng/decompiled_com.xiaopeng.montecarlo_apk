package com.xiaopeng.montecarlo.service.navi.resultsender;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.service.navi.type.Request;
import com.xiaopeng.montecarlo.service.navi.type.Result;
import com.xiaopeng.speech.protocol.bean.recommend.RecommendBean;
/* loaded from: classes3.dex */
public class BroadcastResultSender implements IResultSender {
    private static final String ACTION = "com.xiaopeng.montecarlo.service.navi.BACK_RESULT_ACTION";

    @Override // com.xiaopeng.montecarlo.service.navi.resultsender.IResultSender
    public void sendResult(@NonNull Context context, @NonNull Request request, @NonNull Result result) {
        Intent intent = new Intent(ACTION);
        intent.putExtra(RecommendBean.SHOW_TIME_RESULT, GsonUtil.toJson(result));
        context.sendBroadcast(intent);
    }
}
