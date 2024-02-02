package com.xiaopeng.montecarlo.navcore.search;

import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.navcore.search.response.XPSearchResponse;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes2.dex */
public class AsyncCall extends Call implements Runnable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final L.Tag TAG = new L.Tag("AsyncCall");

    public AsyncCall(Request request, XPSearchResponse xPSearchResponse, ResponseCallback responseCallback) {
        super(request, xPSearchResponse, responseCallback);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mRequest != null && this.mXPSearchResponse != null) {
            this.mRequest.execute(this.mXPSearchResponse);
            return;
        }
        L.Tag tag = TAG;
        L.w(tag, "AsyncCall request = " + this.mRequest + ", response = " + this.mXPSearchResponse);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void execute() {
        ResponseCallback responseCallback;
        try {
            try {
                WorkThreadUtil.getInstance().executeCachedTask(this);
            } catch (RejectedExecutionException unused) {
                XPSearchResult xPSearchResult = new XPSearchResult();
                xPSearchResult.setResultCode(1001);
                if (this.mRequest != null) {
                    xPSearchResult.setRequestId(this.mRequest.getRequestId());
                }
                if (this.mXPSearchResponse != null && (responseCallback = this.mXPSearchResponse.getResponseCallback()) != null) {
                    responseCallback.onResponse(this.mRequest, xPSearchResult);
                }
            }
        } finally {
            SearchClient.getInstance().getDispatcher().finished(this);
        }
    }
}
