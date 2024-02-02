package com.xiaopeng.montecarlo.navcore.search;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.navcore.search.response.XPSearchResponse;
/* loaded from: classes2.dex */
public class Call {
    protected boolean mIsCanceled;
    protected Request mRequest;
    protected XPSearchResponse mXPSearchResponse;

    public Call(@NonNull Request request, @NonNull XPSearchResponse xPSearchResponse, ResponseCallback responseCallback) {
        this.mRequest = null;
        this.mXPSearchResponse = null;
        this.mRequest = request;
        this.mXPSearchResponse = xPSearchResponse;
        XPSearchResponse xPSearchResponse2 = this.mXPSearchResponse;
        if (xPSearchResponse2 != null) {
            xPSearchResponse2.setRequest(request);
            this.mXPSearchResponse.setResponseCallback(responseCallback);
        }
    }

    public Request getRequest() {
        return this.mRequest;
    }

    public XPSearchResponse getXPSearchResponse() {
        return this.mXPSearchResponse;
    }

    public boolean isCanceled() {
        return this.mIsCanceled;
    }

    public void cancel() {
        this.mIsCanceled = true;
        XPSearchResponse xPSearchResponse = this.mXPSearchResponse;
        if (xPSearchResponse != null) {
            xPSearchResponse.setCanceled(this.mIsCanceled);
        }
    }
}
