package com.autonavi.gbl.search.observer.impl;

import com.autonavi.gbl.search.model.SearchAlongWayResult;
import com.autonavi.gbl.search.model.SearchAroundRecommendResult;
import com.autonavi.gbl.search.model.SearchChargingLiveStatusResult;
import com.autonavi.gbl.search.model.SearchDeepInfoResult;
import com.autonavi.gbl.search.model.SearchDetailInfoResult;
import com.autonavi.gbl.search.model.SearchKeywordResult;
import com.autonavi.gbl.search.model.SearchLineDeepInfoResult;
import com.autonavi.gbl.search.model.SearchNaviInfoResult;
import com.autonavi.gbl.search.model.SearchNearestResult;
import com.autonavi.gbl.search.model.SearchSuggestResult;
import com.autonavi.gbl.util.model.EGErr;
/* loaded from: classes2.dex */
public class SearchObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_IGSearchKeyWordObserverImpl_onGetKeyWordResult(IGSearchKeyWordObserverImpl iGSearchKeyWordObserverImpl, int i, @EGErr.EGErr1 int i2, SearchKeywordResult searchKeywordResult) {
        iGSearchKeyWordObserverImpl.onGetKeyWordResult(i, i2, searchKeywordResult);
    }

    public static void SwigDirector_IGSearchSuggestionObserverImpl_onGetSuggestionResult(IGSearchSuggestionObserverImpl iGSearchSuggestionObserverImpl, int i, @EGErr.EGErr1 int i2, SearchSuggestResult searchSuggestResult) {
        iGSearchSuggestionObserverImpl.onGetSuggestionResult(i, i2, searchSuggestResult);
    }

    public static void SwigDirector_IGSearchAlongWayObserverImpl_onGetAlongWayResult(IGSearchAlongWayObserverImpl iGSearchAlongWayObserverImpl, int i, @EGErr.EGErr1 int i2, SearchAlongWayResult searchAlongWayResult) {
        iGSearchAlongWayObserverImpl.onGetAlongWayResult(i, i2, searchAlongWayResult);
    }

    public static void SwigDirector_IGSearchAroundRecommendObserverImpl_onGetAroundRecommendResult(IGSearchAroundRecommendObserverImpl iGSearchAroundRecommendObserverImpl, int i, @EGErr.EGErr1 int i2, SearchAroundRecommendResult searchAroundRecommendResult) {
        iGSearchAroundRecommendObserverImpl.onGetAroundRecommendResult(i, i2, searchAroundRecommendResult);
    }

    public static void SwigDirector_IGSearchNearestObserverImpl_onGetNearestResult(IGSearchNearestObserverImpl iGSearchNearestObserverImpl, int i, @EGErr.EGErr1 int i2, SearchNearestResult searchNearestResult) {
        iGSearchNearestObserverImpl.onGetNearestResult(i, i2, searchNearestResult);
    }

    public static void SwigDirector_IGSearchDeepInfoObserverImpl_onGetDeepInfoResult(IGSearchDeepInfoObserverImpl iGSearchDeepInfoObserverImpl, int i, @EGErr.EGErr1 int i2, SearchDeepInfoResult searchDeepInfoResult) {
        iGSearchDeepInfoObserverImpl.onGetDeepInfoResult(i, i2, searchDeepInfoResult);
    }

    public static void SwigDirector_IGSearchLineDeepInfoObserverImpl_onGetLineDeepInfoResult(IGSearchLineDeepInfoObserverImpl iGSearchLineDeepInfoObserverImpl, int i, @EGErr.EGErr1 int i2, SearchLineDeepInfoResult searchLineDeepInfoResult) {
        iGSearchLineDeepInfoObserverImpl.onGetLineDeepInfoResult(i, i2, searchLineDeepInfoResult);
    }

    public static void SwigDirector_IGSearchDetailInfoObserverImpl_onGetDetailInfoResult(IGSearchDetailInfoObserverImpl iGSearchDetailInfoObserverImpl, int i, @EGErr.EGErr1 int i2, SearchDetailInfoResult searchDetailInfoResult) {
        iGSearchDetailInfoObserverImpl.onGetDetailInfoResult(i, i2, searchDetailInfoResult);
    }

    public static void SwigDirector_IGSearchNaviInfoObserverImpl_onGetNaviInfoResult(IGSearchNaviInfoObserverImpl iGSearchNaviInfoObserverImpl, int i, @EGErr.EGErr1 int i2, SearchNaviInfoResult searchNaviInfoResult) {
        iGSearchNaviInfoObserverImpl.onGetNaviInfoResult(i, i2, searchNaviInfoResult);
    }

    public static void SwigDirector_IGSearchChargingLiveStatusObserverImpl_onGetChargingLiveStatusResult(IGSearchChargingLiveStatusObserverImpl iGSearchChargingLiveStatusObserverImpl, int i, @EGErr.EGErr1 int i2, SearchChargingLiveStatusResult searchChargingLiveStatusResult) {
        iGSearchChargingLiveStatusObserverImpl.onGetChargingLiveStatusResult(i, i2, searchChargingLiveStatusResult);
    }
}
