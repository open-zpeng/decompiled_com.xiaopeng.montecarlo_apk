package com.xiaopeng.montecarlo.service.navi.resultsender;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.service.navi.RemoteCallback;
import com.xiaopeng.montecarlo.service.navi.type.Request;
import com.xiaopeng.montecarlo.service.navi.type.Result;
/* loaded from: classes3.dex */
public final class CallbackResultSender implements IResultSender {
    private Runnable mEx = new Runnable() { // from class: com.xiaopeng.montecarlo.service.navi.resultsender.CallbackResultSender.1
        @Override // java.lang.Runnable
        public void run() {
            if (CallbackResultSender.this.mRemoteCallback.isKilled()) {
                return;
            }
            CallbackResultSender.this.mRemoteCallback.onTimeOut(CallbackResultSender.this.mRequest.getRequest_id());
            CallbackResultSender.this.mRemoteCallback.kill();
        }
    };
    private final Handler mHandler;
    private final RemoteCallback mRemoteCallback;
    private final Request mRequest;

    public CallbackResultSender(@NonNull RemoteCallback remoteCallback, Request request, @NonNull Handler handler) {
        this.mRemoteCallback = remoteCallback;
        this.mHandler = handler;
        this.mRequest = request;
        this.mHandler.postDelayed(this.mEx, this.mRequest.getOut_time());
    }

    @Override // com.xiaopeng.montecarlo.service.navi.resultsender.IResultSender
    public void sendResult(@NonNull Context context, @NonNull Request request, @NonNull Result result) {
        if (this.mRemoteCallback.isKilled()) {
            return;
        }
        this.mHandler.removeCallbacks(this.mEx);
        this.mRemoteCallback.onBackResult(GsonUtil.toJson(result));
        this.mRemoteCallback.kill();
    }
}
