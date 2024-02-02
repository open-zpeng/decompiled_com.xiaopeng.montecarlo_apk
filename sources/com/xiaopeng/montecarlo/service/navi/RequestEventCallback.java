package com.xiaopeng.montecarlo.service.navi;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.service.navi.resultsender.IResultSender;
import com.xiaopeng.montecarlo.service.navi.type.Request;
import com.xiaopeng.montecarlo.service.navi.type.Result;
/* loaded from: classes3.dex */
public class RequestEventCallback implements IRequestEventCallback {
    private final IActivityLauncher mActivityLauncher;
    private final Context mContent;
    protected Bundle mDataToMainActivity;
    private final Handler mHandler;
    private final Request mRequest;
    protected String mResultContent;
    private final IResultSender mResultSender;
    protected boolean mIsNeedStartMainActivity = false;
    protected boolean mIsNeedReturnResult = false;

    public RequestEventCallback(Context context, Request request, IResultSender iResultSender, IActivityLauncher iActivityLauncher, Handler handler) {
        this.mRequest = request;
        this.mResultSender = iResultSender;
        this.mContent = context;
        this.mActivityLauncher = iActivityLauncher;
        this.mHandler = handler;
    }

    @Override // com.xiaopeng.montecarlo.service.navi.IRequestEventCallback
    public void setNeedStartMainActivity(final boolean z) {
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.navi.RequestEventCallback.1
            @Override // java.lang.Runnable
            public void run() {
                RequestEventCallback.this.mIsNeedStartMainActivity = z;
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.service.navi.IRequestEventCallback
    public void setDataToMainActivity(final Bundle bundle) {
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.navi.RequestEventCallback.2
            @Override // java.lang.Runnable
            public void run() {
                RequestEventCallback.this.mDataToMainActivity = bundle;
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.service.navi.IRequestEventCallback
    public void setNeedReturnResult(final boolean z, final String str) {
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.navi.RequestEventCallback.3
            @Override // java.lang.Runnable
            public void run() {
                RequestEventCallback requestEventCallback = RequestEventCallback.this;
                requestEventCallback.mIsNeedReturnResult = z;
                requestEventCallback.mResultContent = str;
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.service.navi.IRequestEventCallback
    public void allWorkEnd() {
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.navi.RequestEventCallback.4
            @Override // java.lang.Runnable
            public void run() {
                if (RequestEventCallback.this.mIsNeedStartMainActivity) {
                    UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.navi.RequestEventCallback.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RequestEventCallback.this.mActivityLauncher.startMainActivity(RequestEventCallback.this.mDataToMainActivity, RequestEventCallback.this.mRequest);
                        }
                    });
                }
                if (RequestEventCallback.this.mIsNeedReturnResult) {
                    Result result = new Result();
                    result.setRequestId(RequestEventCallback.this.mRequest.getRequest_id());
                    result.setContent(RequestEventCallback.this.mResultContent);
                    RequestEventCallback.this.mResultSender.sendResult(RequestEventCallback.this.mContent, RequestEventCallback.this.mRequest, result);
                }
            }
        });
    }
}
