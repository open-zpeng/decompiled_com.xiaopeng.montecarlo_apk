package com.xiaopeng.montecarlo.navcore.search;

import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.navcore.search.response.XPSearchResponse;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class RealCall extends Call {
    public static final L.Tag TAG = new L.Tag("RealCall");

    public RealCall(Request request, XPSearchResponse xPSearchResponse, ResponseCallback responseCallback) {
        super(request, xPSearchResponse, responseCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XPSearchResult executeOn() {
        if (this.mRequest != null && this.mXPSearchResponse != null) {
            return this.mRequest.execute(this.mXPSearchResponse);
        }
        L.Tag tag = TAG;
        L.w(tag, "RealCall request = " + this.mRequest + ", response = " + this.mXPSearchResponse);
        return null;
    }
}
