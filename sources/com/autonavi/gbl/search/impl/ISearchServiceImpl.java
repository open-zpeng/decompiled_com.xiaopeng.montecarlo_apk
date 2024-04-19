package com.autonavi.gbl.search.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.search.SearchService;
import com.autonavi.gbl.search.model.SearchAlongWayParam;
import com.autonavi.gbl.search.model.SearchAroundRecommendParam;
import com.autonavi.gbl.search.model.SearchDeepInfoParam;
import com.autonavi.gbl.search.model.SearchDetailInfoParam;
import com.autonavi.gbl.search.model.SearchKeywordParam;
import com.autonavi.gbl.search.model.SearchLineDeepInfoParam;
import com.autonavi.gbl.search.model.SearchMode;
import com.autonavi.gbl.search.model.SearchNaviInfoParam;
import com.autonavi.gbl.search.model.SearchNearestParam;
import com.autonavi.gbl.search.model.SearchSuggestParam;
import com.autonavi.gbl.search.observer.impl.IGSearchAlongWayObserverImpl;
import com.autonavi.gbl.search.observer.impl.IGSearchAroundRecommendObserverImpl;
import com.autonavi.gbl.search.observer.impl.IGSearchDeepInfoObserverImpl;
import com.autonavi.gbl.search.observer.impl.IGSearchDetailInfoObserverImpl;
import com.autonavi.gbl.search.observer.impl.IGSearchKeyWordObserverImpl;
import com.autonavi.gbl.search.observer.impl.IGSearchLineDeepInfoObserverImpl;
import com.autonavi.gbl.search.observer.impl.IGSearchNaviInfoObserverImpl;
import com.autonavi.gbl.search.observer.impl.IGSearchNearestObserverImpl;
import com.autonavi.gbl.search.observer.impl.IGSearchSuggestionObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.EGErr;
import com.autonavi.gbl.util.model.ServiceInitStatus;
@IntfAuto(target = SearchService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class ISearchServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(ISearchServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native int abortAllNative(long j, ISearchServiceImpl iSearchServiceImpl);

    private static native int abortNative(long j, ISearchServiceImpl iSearchServiceImpl, int i);

    private static native int alongWaySearchNative(long j, ISearchServiceImpl iSearchServiceImpl, long j2, SearchAlongWayParam searchAlongWayParam, long j3, IGSearchAlongWayObserverImpl iGSearchAlongWayObserverImpl, int i, int i2);

    private static native int aroundRecommendSearchNative(long j, ISearchServiceImpl iSearchServiceImpl, long j2, SearchAroundRecommendParam searchAroundRecommendParam, long j3, IGSearchAroundRecommendObserverImpl iGSearchAroundRecommendObserverImpl, int i, int i2);

    private static native int deepInfoSearchNative(long j, ISearchServiceImpl iSearchServiceImpl, long j2, SearchDeepInfoParam searchDeepInfoParam, long j3, IGSearchDeepInfoObserverImpl iGSearchDeepInfoObserverImpl, int i, int i2);

    private static native void destroyNativeObj(long j);

    private static native int detailInfoSearchNative(long j, ISearchServiceImpl iSearchServiceImpl, long j2, SearchDetailInfoParam searchDetailInfoParam, long j3, IGSearchDetailInfoObserverImpl iGSearchDetailInfoObserverImpl, int i, int i2);

    private static native String getSdkVersionNative();

    private static native void initNative(long j, ISearchServiceImpl iSearchServiceImpl);

    private static native int isInitNative(long j, ISearchServiceImpl iSearchServiceImpl);

    private static native int keyWordSearchNative(long j, ISearchServiceImpl iSearchServiceImpl, long j2, SearchKeywordParam searchKeywordParam, long j3, IGSearchKeyWordObserverImpl iGSearchKeyWordObserverImpl, int i, int i2);

    private static native int lineDeepInfoSearchNative(long j, ISearchServiceImpl iSearchServiceImpl, long j2, SearchLineDeepInfoParam searchLineDeepInfoParam, long j3, IGSearchLineDeepInfoObserverImpl iGSearchLineDeepInfoObserverImpl, int i, int i2);

    private static native int naviInfoSearchNative(long j, ISearchServiceImpl iSearchServiceImpl, long j2, SearchNaviInfoParam searchNaviInfoParam, long j3, IGSearchNaviInfoObserverImpl iGSearchNaviInfoObserverImpl, int i, int i2);

    private static native int nearestSearchNative(long j, ISearchServiceImpl iSearchServiceImpl, long j2, SearchNearestParam searchNearestParam, long j3, IGSearchNearestObserverImpl iGSearchNearestObserverImpl, int i, int i2);

    private static native void setDbPathNative(String str);

    private static native int suggestionSearchNative(long j, ISearchServiceImpl iSearchServiceImpl, long j2, SearchSuggestParam searchSuggestParam, long j3, IGSearchSuggestionObserverImpl iGSearchSuggestionObserverImpl, int i, int i2);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected ISearchServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ISearchServiceImpl) && getUID(this) == getUID((ISearchServiceImpl) obj);
    }

    private static long getUID(ISearchServiceImpl iSearchServiceImpl) {
        long cPtr = getCPtr(iSearchServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ISearchServiceImpl iSearchServiceImpl) {
        if (iSearchServiceImpl == null) {
            return 0L;
        }
        return iSearchServiceImpl.swigCPtr;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        return this.swigCPtr;
    }

    protected synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public void init() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        initNative(j, this);
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isInitNative(j, this);
    }

    public int keyWordSearch(SearchKeywordParam searchKeywordParam, IGSearchKeyWordObserverImpl iGSearchKeyWordObserverImpl, @SearchMode.SearchMode1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return keyWordSearchNative(j, this, 0L, searchKeywordParam, IGSearchKeyWordObserverImpl.getCPtr(iGSearchKeyWordObserverImpl), iGSearchKeyWordObserverImpl, i, i2);
    }

    public int suggestionSearch(SearchSuggestParam searchSuggestParam, IGSearchSuggestionObserverImpl iGSearchSuggestionObserverImpl, @SearchMode.SearchMode1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return suggestionSearchNative(j, this, 0L, searchSuggestParam, IGSearchSuggestionObserverImpl.getCPtr(iGSearchSuggestionObserverImpl), iGSearchSuggestionObserverImpl, i, i2);
    }

    public int alongWaySearch(SearchAlongWayParam searchAlongWayParam, IGSearchAlongWayObserverImpl iGSearchAlongWayObserverImpl, @SearchMode.SearchMode1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return alongWaySearchNative(j, this, 0L, searchAlongWayParam, IGSearchAlongWayObserverImpl.getCPtr(iGSearchAlongWayObserverImpl), iGSearchAlongWayObserverImpl, i, i2);
    }

    public int deepInfoSearch(SearchDeepInfoParam searchDeepInfoParam, IGSearchDeepInfoObserverImpl iGSearchDeepInfoObserverImpl, @SearchMode.SearchMode1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return deepInfoSearchNative(j, this, 0L, searchDeepInfoParam, IGSearchDeepInfoObserverImpl.getCPtr(iGSearchDeepInfoObserverImpl), iGSearchDeepInfoObserverImpl, i, i2);
    }

    public int lineDeepInfoSearch(SearchLineDeepInfoParam searchLineDeepInfoParam, IGSearchLineDeepInfoObserverImpl iGSearchLineDeepInfoObserverImpl, @SearchMode.SearchMode1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return lineDeepInfoSearchNative(j, this, 0L, searchLineDeepInfoParam, IGSearchLineDeepInfoObserverImpl.getCPtr(iGSearchLineDeepInfoObserverImpl), iGSearchLineDeepInfoObserverImpl, i, i2);
    }

    public int detailInfoSearch(SearchDetailInfoParam searchDetailInfoParam, IGSearchDetailInfoObserverImpl iGSearchDetailInfoObserverImpl, @SearchMode.SearchMode1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return detailInfoSearchNative(j, this, 0L, searchDetailInfoParam, IGSearchDetailInfoObserverImpl.getCPtr(iGSearchDetailInfoObserverImpl), iGSearchDetailInfoObserverImpl, i, i2);
    }

    public int nearestSearch(SearchNearestParam searchNearestParam, IGSearchNearestObserverImpl iGSearchNearestObserverImpl, @SearchMode.SearchMode1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return nearestSearchNative(j, this, 0L, searchNearestParam, IGSearchNearestObserverImpl.getCPtr(iGSearchNearestObserverImpl), iGSearchNearestObserverImpl, i, i2);
    }

    public int aroundRecommendSearch(SearchAroundRecommendParam searchAroundRecommendParam, IGSearchAroundRecommendObserverImpl iGSearchAroundRecommendObserverImpl, @SearchMode.SearchMode1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return aroundRecommendSearchNative(j, this, 0L, searchAroundRecommendParam, IGSearchAroundRecommendObserverImpl.getCPtr(iGSearchAroundRecommendObserverImpl), iGSearchAroundRecommendObserverImpl, i, i2);
    }

    public int naviInfoSearch(SearchNaviInfoParam searchNaviInfoParam, IGSearchNaviInfoObserverImpl iGSearchNaviInfoObserverImpl, @SearchMode.SearchMode1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return naviInfoSearchNative(j, this, 0L, searchNaviInfoParam, IGSearchNaviInfoObserverImpl.getCPtr(iGSearchNaviInfoObserverImpl), iGSearchNaviInfoObserverImpl, i, i2);
    }

    @EGErr.EGErr1
    public int abort(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return abortNative(j, this, i);
    }

    @EGErr.EGErr1
    public int abortAll() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return abortAllNative(j, this);
    }

    public static String getSdkVersion() {
        return getSdkVersionNative();
    }

    public static void setDbPath(String str) {
        setDbPathNative(str);
    }
}
