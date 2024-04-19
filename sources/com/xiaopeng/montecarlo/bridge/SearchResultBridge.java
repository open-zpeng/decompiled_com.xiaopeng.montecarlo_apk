package com.xiaopeng.montecarlo.bridge;

import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
/* loaded from: classes2.dex */
public class SearchResultBridge extends BaseBridge {
    public static final String SEARCH_RESULT = "search_result";
    public static final String SEARCH_RESULT_FAVORITE_POI = "search_result_favorite_poi";
    public static final String SEARCH_RESULT_SEARCH_PARAMS = "search_result_search_params";
    private static final String TAG = "com.xiaopeng.montecarlo.bridge.SearchResultBridge";

    public SearchResultBridge() {
        super(StatusConst.Mode.SEARCH_RESULT);
    }
}
