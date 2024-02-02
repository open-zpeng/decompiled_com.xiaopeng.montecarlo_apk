package com.xiaopeng.montecarlo.navcore.search;

import com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate;
import com.xiaopeng.montecarlo.navcore.search.request.AlongWayRequest;
import com.xiaopeng.montecarlo.navcore.search.request.DeepSearchRequest;
import com.xiaopeng.montecarlo.navcore.search.request.DefaultRequest;
import com.xiaopeng.montecarlo.navcore.search.request.DetailSearchRequest;
import com.xiaopeng.montecarlo.navcore.search.request.KeywordQueryRequest;
import com.xiaopeng.montecarlo.navcore.search.request.NearestSearchRequest;
import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.navcore.search.request.SuggestSearchRequest;
import com.xiaopeng.montecarlo.navcore.search.response.XPAlongWayResponse;
import com.xiaopeng.montecarlo.navcore.search.response.XPDeepResponse;
import com.xiaopeng.montecarlo.navcore.search.response.XPDefaultResponse;
import com.xiaopeng.montecarlo.navcore.search.response.XPDetailResponse;
import com.xiaopeng.montecarlo.navcore.search.response.XPKeywordResponse;
import com.xiaopeng.montecarlo.navcore.search.response.XPNearestResponse;
import com.xiaopeng.montecarlo.navcore.search.response.XPSearchResponse;
import com.xiaopeng.montecarlo.navcore.search.response.XPSuggestResponse;
/* loaded from: classes2.dex */
public class SearchClient {
    private static final SearchClient sInstance = new SearchClient();
    private final Object $lock = new Object[0];
    private IMapDelegate mIMapDelegate = null;
    private int mRequestId = 0;
    private Dispatcher mDispatcher = new Dispatcher();

    private SearchClient() {
    }

    public static SearchClient getInstance() {
        return sInstance;
    }

    public int getRequestId() {
        int i;
        synchronized (this.$lock) {
            if (this.mRequestId < 0 || this.mRequestId >= Integer.MAX_VALUE) {
                this.mRequestId = 0;
            }
            i = this.mRequestId + 1;
            this.mRequestId = i;
        }
        return i;
    }

    public BaseBuilder getRequestBuilder(int i) {
        BaseBuilder builder = new DefaultRequest.Builder();
        switch (i) {
            case 1:
                builder = new KeywordQueryRequest.Builder();
                break;
            case 2:
                builder = new AlongWayRequest.Builder();
                break;
            case 3:
                builder = new DetailSearchRequest.Builder();
                break;
            case 4:
                builder = new SuggestSearchRequest.Builder();
                break;
            case 5:
                builder = new NearestSearchRequest.Builder();
                break;
            case 6:
                builder = new DeepSearchRequest.Builder();
                break;
        }
        builder.setRequestType(i);
        return builder;
    }

    public XPSearchResponse getXPResponse(int i) {
        XPDefaultResponse xPDefaultResponse = new XPDefaultResponse();
        switch (i) {
            case 1:
                return new XPKeywordResponse();
            case 2:
                return new XPAlongWayResponse();
            case 3:
                return new XPDetailResponse();
            case 4:
                return new XPSuggestResponse();
            case 5:
                return new XPNearestResponse();
            case 6:
                return new XPDeepResponse();
            default:
                return xPDefaultResponse;
        }
    }

    public void init() {
        SearchServiceWrapper.getInstance().init();
    }

    public IMapDelegate getIMapDelegate() {
        return this.mIMapDelegate;
    }

    public void setIMapDelegate(IMapDelegate iMapDelegate) {
        this.mIMapDelegate = iMapDelegate;
    }

    public Dispatcher getDispatcher() {
        return this.mDispatcher;
    }

    public void enqueue(Request request, ResponseCallback responseCallback) {
        checkStatus();
        if (request == null) {
            request = getDefaultRequest();
        }
        if (this.mDispatcher != null) {
            this.mDispatcher.enqueue(new AsyncCall(request, getInstance().getXPResponse(request.getRequestType()), responseCallback));
        }
    }

    public XPSearchResult execute(Request request) {
        checkStatus();
        if (request == null) {
            request = getDefaultRequest();
        }
        if (this.mDispatcher != null) {
            return this.mDispatcher.execute(new RealCall(request, getInstance().getXPResponse(request.getRequestType()), null));
        }
        return null;
    }

    public void execute(Request request, ResponseCallback responseCallback) {
        checkStatus();
        if (request == null) {
            request = getDefaultRequest();
        }
        if (this.mDispatcher != null) {
            this.mDispatcher.execute(new RealCall(request, getInstance().getXPResponse(request.getRequestType()), responseCallback));
        }
    }

    private void checkStatus() {
        if (this.mDispatcher == null) {
            throw new IllegalArgumentException("set SearchClient mDispatcher first!");
        }
    }

    private Request getDefaultRequest() {
        return new DefaultRequest.Builder().build();
    }
}
