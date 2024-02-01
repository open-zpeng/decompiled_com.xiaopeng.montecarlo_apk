package com.autonavi.gbl.search.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.SearchServiceV2;
import com.autonavi.gbl.search.model.KeywordSearchIdqParam;
import com.autonavi.gbl.search.model.KeywordSearchRqbxyParam;
import com.autonavi.gbl.search.model.KeywordSearchSpqParam;
import com.autonavi.gbl.search.model.KeywordSearchTQueryParam;
import com.autonavi.gbl.search.model.SceneSearchParam;
import com.autonavi.gbl.search.model.SearchMode;
import com.autonavi.gbl.search.model.SearchPoiCmallDetailParam;
import com.autonavi.gbl.search.model.SearchPoiDetailParam;
import com.autonavi.gbl.search.model.SearchPoiShopListParam;
import com.autonavi.gbl.search.observer.impl.IKeyWordSearchObserverV2Impl;
import com.autonavi.gbl.search.observer.impl.IPoiCmallDetailSearchObserverImpl;
import com.autonavi.gbl.search.observer.impl.IPoiDetailSearchObserverImpl;
import com.autonavi.gbl.search.observer.impl.IPoiShopListSearchObserverImpl;
import com.autonavi.gbl.search.observer.impl.ISceneSearchObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
@IntfAuto(target = SearchServiceV2.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class ISearchServiceV2Impl implements IService {
    private static BindTable BIND_TABLE = new BindTable(ISearchServiceV2Impl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native int abortAllNative(long j, ISearchServiceV2Impl iSearchServiceV2Impl);

    private static native int abortNative(long j, ISearchServiceV2Impl iSearchServiceV2Impl, int i);

    private static native void destroyNativeObj(long j);

    private static native String getSdkVersionNative();

    private static native void initNative(long j, ISearchServiceV2Impl iSearchServiceV2Impl);

    private static native int isInitNative(long j, ISearchServiceV2Impl iSearchServiceV2Impl);

    private static native int keyWordSearchIdqNative(long j, ISearchServiceV2Impl iSearchServiceV2Impl, long j2, KeywordSearchIdqParam keywordSearchIdqParam, long j3, IKeyWordSearchObserverV2Impl iKeyWordSearchObserverV2Impl, int i, int i2);

    private static native int keyWordSearchRqbxyNative(long j, ISearchServiceV2Impl iSearchServiceV2Impl, long j2, KeywordSearchRqbxyParam keywordSearchRqbxyParam, long j3, IKeyWordSearchObserverV2Impl iKeyWordSearchObserverV2Impl, int i, int i2);

    private static native int keyWordSearchSpqNative(long j, ISearchServiceV2Impl iSearchServiceV2Impl, long j2, KeywordSearchSpqParam keywordSearchSpqParam, long j3, IKeyWordSearchObserverV2Impl iKeyWordSearchObserverV2Impl, int i, int i2);

    private static native int keyWordSearchTQueryNative(long j, ISearchServiceV2Impl iSearchServiceV2Impl, long j2, KeywordSearchTQueryParam keywordSearchTQueryParam, long j3, IKeyWordSearchObserverV2Impl iKeyWordSearchObserverV2Impl, int i, int i2);

    private static native int poiCmallDetailSearchNative(long j, ISearchServiceV2Impl iSearchServiceV2Impl, long j2, SearchPoiCmallDetailParam searchPoiCmallDetailParam, long j3, IPoiCmallDetailSearchObserverImpl iPoiCmallDetailSearchObserverImpl, int i, int i2);

    private static native int poiDetailSearchNative(long j, ISearchServiceV2Impl iSearchServiceV2Impl, long j2, SearchPoiDetailParam searchPoiDetailParam, long j3, IPoiDetailSearchObserverImpl iPoiDetailSearchObserverImpl, int i, int i2);

    private static native int poiShopListSearchNative(long j, ISearchServiceV2Impl iSearchServiceV2Impl, long j2, SearchPoiShopListParam searchPoiShopListParam, long j3, IPoiShopListSearchObserverImpl iPoiShopListSearchObserverImpl, int i, int i2);

    private static native int sceneSearchNative(long j, ISearchServiceV2Impl iSearchServiceV2Impl, long j2, SceneSearchParam sceneSearchParam, long j3, ISceneSearchObserverImpl iSceneSearchObserverImpl, int i, int i2);

    private static native void setDbPathNative(String str);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected ISearchServiceV2Impl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ISearchServiceV2Impl) && getUID(this) == getUID((ISearchServiceV2Impl) obj);
    }

    private static long getUID(ISearchServiceV2Impl iSearchServiceV2Impl) {
        long cPtr = getCPtr(iSearchServiceV2Impl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ISearchServiceV2Impl iSearchServiceV2Impl) {
        if (iSearchServiceV2Impl == null) {
            return 0L;
        }
        return iSearchServiceV2Impl.swigCPtr;
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

    public int keyWordSearchTQuery(KeywordSearchTQueryParam keywordSearchTQueryParam, IKeyWordSearchObserverV2Impl iKeyWordSearchObserverV2Impl, @SearchMode.SearchMode1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return keyWordSearchTQueryNative(j, this, 0L, keywordSearchTQueryParam, IKeyWordSearchObserverV2Impl.getCPtr(iKeyWordSearchObserverV2Impl), iKeyWordSearchObserverV2Impl, i, i2);
    }

    public int keyWordSearchIdq(KeywordSearchIdqParam keywordSearchIdqParam, IKeyWordSearchObserverV2Impl iKeyWordSearchObserverV2Impl, @SearchMode.SearchMode1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return keyWordSearchIdqNative(j, this, 0L, keywordSearchIdqParam, IKeyWordSearchObserverV2Impl.getCPtr(iKeyWordSearchObserverV2Impl), iKeyWordSearchObserverV2Impl, i, i2);
    }

    public int keyWordSearchRqbxy(KeywordSearchRqbxyParam keywordSearchRqbxyParam, IKeyWordSearchObserverV2Impl iKeyWordSearchObserverV2Impl, @SearchMode.SearchMode1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return keyWordSearchRqbxyNative(j, this, 0L, keywordSearchRqbxyParam, IKeyWordSearchObserverV2Impl.getCPtr(iKeyWordSearchObserverV2Impl), iKeyWordSearchObserverV2Impl, i, i2);
    }

    public int keyWordSearchSpq(KeywordSearchSpqParam keywordSearchSpqParam, IKeyWordSearchObserverV2Impl iKeyWordSearchObserverV2Impl, @SearchMode.SearchMode1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return keyWordSearchSpqNative(j, this, 0L, keywordSearchSpqParam, IKeyWordSearchObserverV2Impl.getCPtr(iKeyWordSearchObserverV2Impl), iKeyWordSearchObserverV2Impl, i, i2);
    }

    public int sceneSearch(SceneSearchParam sceneSearchParam, ISceneSearchObserverImpl iSceneSearchObserverImpl, @SearchMode.SearchMode1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sceneSearchNative(j, this, 0L, sceneSearchParam, ISceneSearchObserverImpl.getCPtr(iSceneSearchObserverImpl), iSceneSearchObserverImpl, i, i2);
    }

    public int poiDetailSearch(SearchPoiDetailParam searchPoiDetailParam, IPoiDetailSearchObserverImpl iPoiDetailSearchObserverImpl, @SearchMode.SearchMode1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return poiDetailSearchNative(j, this, 0L, searchPoiDetailParam, IPoiDetailSearchObserverImpl.getCPtr(iPoiDetailSearchObserverImpl), iPoiDetailSearchObserverImpl, i, i2);
    }

    public int poiCmallDetailSearch(SearchPoiCmallDetailParam searchPoiCmallDetailParam, IPoiCmallDetailSearchObserverImpl iPoiCmallDetailSearchObserverImpl, @SearchMode.SearchMode1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return poiCmallDetailSearchNative(j, this, 0L, searchPoiCmallDetailParam, IPoiCmallDetailSearchObserverImpl.getCPtr(iPoiCmallDetailSearchObserverImpl), iPoiCmallDetailSearchObserverImpl, i, i2);
    }

    public int poiShopListSearch(SearchPoiShopListParam searchPoiShopListParam, IPoiShopListSearchObserverImpl iPoiShopListSearchObserverImpl, @SearchMode.SearchMode1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return poiShopListSearchNative(j, this, 0L, searchPoiShopListParam, IPoiShopListSearchObserverImpl.getCPtr(iPoiShopListSearchObserverImpl), iPoiShopListSearchObserverImpl, i, i2);
    }

    public int abort(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return abortNative(j, this, i);
    }

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
