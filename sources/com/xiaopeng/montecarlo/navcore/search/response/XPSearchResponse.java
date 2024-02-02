package com.xiaopeng.montecarlo.navcore.search.response;

import androidx.annotation.NonNull;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.search.ResponseCallback;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public abstract class XPSearchResponse<T> {
    public static final int DEFAULT_ALONG_WAY_SIZE = 50;
    public static final int DEFAULT_SUG_SIZE = 10;
    protected static final int SEARCH_RESULT_TYPE_OFFLINE = 0;
    protected static final int SEARCH_RESULT_TYPE_ONLINE = 1;
    protected static final L.Tag TAG = new L.Tag("XPSearchResponse");
    protected boolean mIsCanceled;
    protected Request mRequest = null;
    private ResponseCallback mResponseCallback = null;

    abstract XPSearchResult parseBody(@NonNull T t);

    protected CarLoc getCarLocation() {
        if (SearchClient.getInstance().getIMapDelegate() != null) {
            return SearchClient.getInstance().getIMapDelegate().getCarLocation();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getString(int i) {
        return ContextUtils.getString(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkAndGenerateBlSupplePoiId(XPPoiInfo xPPoiInfo) {
        XPPoiInfo.generatePoiIdIfEmpty(xPPoiInfo, 1);
    }

    public XPSearchResult parseBody(int i, int i2, T t) {
        L.Tag tag = TAG;
        L.i(tag, "XPKeywordResponse parseBody requestId = " + i + ", mRequest.getRequestId() = " + this.mRequest.getRequestId() + ", searchResult = " + t);
        XPSearchResult xPSearchResult = new XPSearchResult();
        xPSearchResult.setRequestId(i);
        if (checkCancelState() || !checkResultOK(i2) || checkRequestInvalid(i) || checkResponseInvalid(t)) {
            return xPSearchResult;
        }
        XPSearchResult parseBody = parseBody(t);
        if (checkCancelState()) {
            return parseBody;
        }
        handleParseResult(parseBody);
        return parseBody;
    }

    private void handleParseResult(XPSearchResult xPSearchResult) {
        Request request = this.mRequest;
        if (request == null || this.mResponseCallback == null) {
            return;
        }
        if (xPSearchResult == null) {
            XPSearchResult xPSearchResult2 = new XPSearchResult();
            xPSearchResult2.setRequestId(this.mRequest.getRequestId());
            xPSearchResult2.setResultCode(1005);
            this.mResponseCallback.onResponse(this.mRequest, xPSearchResult2);
            return;
        }
        xPSearchResult.setRequestId(request.getRequestId());
        xPSearchResult.setResultCode(0);
        this.mResponseCallback.onResponse(this.mRequest, xPSearchResult);
    }

    private boolean checkResultOK(int i) {
        if (i != 0) {
            XPSearchResult xPSearchResult = new XPSearchResult();
            xPSearchResult.setRequestId(this.mRequest.getRequestId());
            xPSearchResult.setResultCode(i);
            ResponseCallback responseCallback = this.mResponseCallback;
            if (responseCallback != null) {
                responseCallback.onResponse(this.mRequest, xPSearchResult);
                return false;
            }
            return false;
        }
        return true;
    }

    private boolean checkResponseInvalid(T t) {
        if (t == null) {
            XPSearchResult xPSearchResult = new XPSearchResult();
            xPSearchResult.setRequestId(this.mRequest.getRequestId());
            xPSearchResult.setResultCode(1006);
            ResponseCallback responseCallback = this.mResponseCallback;
            if (responseCallback != null) {
                responseCallback.onResponse(this.mRequest, xPSearchResult);
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean checkRequestInvalid(int i) {
        Request request = this.mRequest;
        if (request == null || i != request.getRequestId()) {
            if (this.mResponseCallback != null) {
                XPSearchResult xPSearchResult = new XPSearchResult();
                xPSearchResult.setRequestId(this.mRequest.getRequestId());
                xPSearchResult.setResultCode(1004);
                this.mResponseCallback.onResponse(this.mRequest, xPSearchResult);
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean checkCancelState() {
        if (this.mIsCanceled) {
            L.i(TAG, "XPKeywordResponse parseBody request canceled by user");
            if (this.mResponseCallback == null || this.mRequest == null) {
                return true;
            }
            XPSearchResult xPSearchResult = new XPSearchResult();
            xPSearchResult.setRequestId(this.mRequest.getRequestId());
            xPSearchResult.setResultCode(1002);
            this.mResponseCallback.onResponse(this.mRequest, xPSearchResult);
            return true;
        }
        return false;
    }

    public void setCanceled(boolean z) {
        this.mIsCanceled = z;
    }

    public Request getRequest() {
        return this.mRequest;
    }

    public void setRequest(Request request) {
        this.mRequest = request;
    }

    public ResponseCallback getResponseCallback() {
        return this.mResponseCallback;
    }

    public void setResponseCallback(ResponseCallback responseCallback) {
        this.mResponseCallback = responseCallback;
    }

    public void release() {
        setResponseCallback(null);
        this.mRequest = null;
    }
}
