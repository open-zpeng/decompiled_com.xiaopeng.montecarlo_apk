package com.autonavi.gbl.search;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.search.impl.ISearchServiceImpl;
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
import com.autonavi.gbl.search.observer.IGSearchAlongWayObserver;
import com.autonavi.gbl.search.observer.IGSearchAroundRecommendObserver;
import com.autonavi.gbl.search.observer.IGSearchDeepInfoObserver;
import com.autonavi.gbl.search.observer.IGSearchDetailInfoObserver;
import com.autonavi.gbl.search.observer.IGSearchKeyWordObserver;
import com.autonavi.gbl.search.observer.IGSearchLineDeepInfoObserver;
import com.autonavi.gbl.search.observer.IGSearchNaviInfoObserver;
import com.autonavi.gbl.search.observer.IGSearchNearestObserver;
import com.autonavi.gbl.search.observer.IGSearchSuggestionObserver;
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
import java.lang.reflect.Method;
@IntfAuto(target = ISearchServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class SearchService implements IService {
    private static String PACKAGE = ReflexTool.PN(SearchService.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private ISearchServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected SearchService(long j, boolean z) {
        this((ISearchServiceImpl) ReflexTool.invokeDeclConstructorSafe(ISearchServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(SearchService.class, this, this.mControl);
        }
    }

    public SearchService(ISearchServiceImpl iSearchServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iSearchServiceImpl);
    }

    private void $constructor(ISearchServiceImpl iSearchServiceImpl) {
        if (iSearchServiceImpl != null) {
            this.mControl = iSearchServiceImpl;
            this.mTargetId = String.format("SearchService_%s_%d", String.valueOf(ISearchServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ISearchServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        ISearchServiceImpl iSearchServiceImpl = this.mControl;
        if (iSearchServiceImpl != null) {
            return iSearchServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        ISearchServiceImpl iSearchServiceImpl = this.mControl;
        if (iSearchServiceImpl != null) {
            return iSearchServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        ISearchServiceImpl iSearchServiceImpl = this.mControl;
        if (iSearchServiceImpl != null) {
            iSearchServiceImpl.onCreate();
        }
    }

    public void init() {
        ISearchServiceImpl iSearchServiceImpl = this.mControl;
        if (iSearchServiceImpl != null) {
            iSearchServiceImpl.init();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        ISearchServiceImpl iSearchServiceImpl = this.mControl;
        if (iSearchServiceImpl != null) {
            return iSearchServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public int keyWordSearch(SearchKeywordParam searchKeywordParam, IGSearchKeyWordObserver iGSearchKeyWordObserver, @SearchMode.SearchMode1 int i, int i2) {
        try {
            Method method = SearchService.class.getMethod("keyWordSearch", SearchKeywordParam.class, IGSearchKeyWordObserver.class, Integer.TYPE, Integer.TYPE);
            if (iGSearchKeyWordObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IGSearchKeyWordObserverImpl) typeHelper.transfer(method, 1, iGSearchKeyWordObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.SearchService.1
                    }));
                    return 0;
                }
            }
            ISearchServiceImpl iSearchServiceImpl = this.mControl;
            if (iSearchServiceImpl != null) {
                return iSearchServiceImpl.keyWordSearch(searchKeywordParam, r2, i, i2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int suggestionSearch(SearchSuggestParam searchSuggestParam, IGSearchSuggestionObserver iGSearchSuggestionObserver, @SearchMode.SearchMode1 int i, int i2) {
        try {
            Method method = SearchService.class.getMethod("suggestionSearch", SearchSuggestParam.class, IGSearchSuggestionObserver.class, Integer.TYPE, Integer.TYPE);
            if (iGSearchSuggestionObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IGSearchSuggestionObserverImpl) typeHelper.transfer(method, 1, iGSearchSuggestionObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.SearchService.2
                    }));
                    return 0;
                }
            }
            ISearchServiceImpl iSearchServiceImpl = this.mControl;
            if (iSearchServiceImpl != null) {
                return iSearchServiceImpl.suggestionSearch(searchSuggestParam, r2, i, i2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int alongWaySearch(SearchAlongWayParam searchAlongWayParam, IGSearchAlongWayObserver iGSearchAlongWayObserver, @SearchMode.SearchMode1 int i, int i2) {
        try {
            Method method = SearchService.class.getMethod("alongWaySearch", SearchAlongWayParam.class, IGSearchAlongWayObserver.class, Integer.TYPE, Integer.TYPE);
            if (iGSearchAlongWayObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IGSearchAlongWayObserverImpl) typeHelper.transfer(method, 1, iGSearchAlongWayObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.SearchService.3
                    }));
                    return 0;
                }
            }
            ISearchServiceImpl iSearchServiceImpl = this.mControl;
            if (iSearchServiceImpl != null) {
                return iSearchServiceImpl.alongWaySearch(searchAlongWayParam, r2, i, i2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int deepInfoSearch(SearchDeepInfoParam searchDeepInfoParam, IGSearchDeepInfoObserver iGSearchDeepInfoObserver, @SearchMode.SearchMode1 int i, int i2) {
        try {
            Method method = SearchService.class.getMethod("deepInfoSearch", SearchDeepInfoParam.class, IGSearchDeepInfoObserver.class, Integer.TYPE, Integer.TYPE);
            if (iGSearchDeepInfoObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IGSearchDeepInfoObserverImpl) typeHelper.transfer(method, 1, iGSearchDeepInfoObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.SearchService.4
                    }));
                    return 0;
                }
            }
            ISearchServiceImpl iSearchServiceImpl = this.mControl;
            if (iSearchServiceImpl != null) {
                return iSearchServiceImpl.deepInfoSearch(searchDeepInfoParam, r2, i, i2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int lineDeepInfoSearch(SearchLineDeepInfoParam searchLineDeepInfoParam, IGSearchLineDeepInfoObserver iGSearchLineDeepInfoObserver, @SearchMode.SearchMode1 int i, int i2) {
        try {
            Method method = SearchService.class.getMethod("lineDeepInfoSearch", SearchLineDeepInfoParam.class, IGSearchLineDeepInfoObserver.class, Integer.TYPE, Integer.TYPE);
            if (iGSearchLineDeepInfoObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IGSearchLineDeepInfoObserverImpl) typeHelper.transfer(method, 1, iGSearchLineDeepInfoObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.SearchService.5
                    }));
                    return 0;
                }
            }
            ISearchServiceImpl iSearchServiceImpl = this.mControl;
            if (iSearchServiceImpl != null) {
                return iSearchServiceImpl.lineDeepInfoSearch(searchLineDeepInfoParam, r2, i, i2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int detailInfoSearch(SearchDetailInfoParam searchDetailInfoParam, IGSearchDetailInfoObserver iGSearchDetailInfoObserver, @SearchMode.SearchMode1 int i, int i2) {
        try {
            Method method = SearchService.class.getMethod("detailInfoSearch", SearchDetailInfoParam.class, IGSearchDetailInfoObserver.class, Integer.TYPE, Integer.TYPE);
            if (iGSearchDetailInfoObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IGSearchDetailInfoObserverImpl) typeHelper.transfer(method, 1, iGSearchDetailInfoObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.SearchService.6
                    }));
                    return 0;
                }
            }
            ISearchServiceImpl iSearchServiceImpl = this.mControl;
            if (iSearchServiceImpl != null) {
                return iSearchServiceImpl.detailInfoSearch(searchDetailInfoParam, r2, i, i2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int nearestSearch(SearchNearestParam searchNearestParam, IGSearchNearestObserver iGSearchNearestObserver, @SearchMode.SearchMode1 int i, int i2) {
        try {
            Method method = SearchService.class.getMethod("nearestSearch", SearchNearestParam.class, IGSearchNearestObserver.class, Integer.TYPE, Integer.TYPE);
            if (iGSearchNearestObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IGSearchNearestObserverImpl) typeHelper.transfer(method, 1, iGSearchNearestObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.SearchService.7
                    }));
                    return 0;
                }
            }
            ISearchServiceImpl iSearchServiceImpl = this.mControl;
            if (iSearchServiceImpl != null) {
                return iSearchServiceImpl.nearestSearch(searchNearestParam, r2, i, i2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int aroundRecommendSearch(SearchAroundRecommendParam searchAroundRecommendParam, IGSearchAroundRecommendObserver iGSearchAroundRecommendObserver, @SearchMode.SearchMode1 int i, int i2) {
        try {
            Method method = SearchService.class.getMethod("aroundRecommendSearch", SearchAroundRecommendParam.class, IGSearchAroundRecommendObserver.class, Integer.TYPE, Integer.TYPE);
            if (iGSearchAroundRecommendObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IGSearchAroundRecommendObserverImpl) typeHelper.transfer(method, 1, iGSearchAroundRecommendObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.SearchService.8
                    }));
                    return 0;
                }
            }
            ISearchServiceImpl iSearchServiceImpl = this.mControl;
            if (iSearchServiceImpl != null) {
                return iSearchServiceImpl.aroundRecommendSearch(searchAroundRecommendParam, r2, i, i2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int naviInfoSearch(SearchNaviInfoParam searchNaviInfoParam, IGSearchNaviInfoObserver iGSearchNaviInfoObserver, @SearchMode.SearchMode1 int i, int i2) {
        try {
            Method method = SearchService.class.getMethod("naviInfoSearch", SearchNaviInfoParam.class, IGSearchNaviInfoObserver.class, Integer.TYPE, Integer.TYPE);
            if (iGSearchNaviInfoObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IGSearchNaviInfoObserverImpl) typeHelper.transfer(method, 1, iGSearchNaviInfoObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.SearchService.9
                    }));
                    return 0;
                }
            }
            ISearchServiceImpl iSearchServiceImpl = this.mControl;
            if (iSearchServiceImpl != null) {
                return iSearchServiceImpl.naviInfoSearch(searchNaviInfoParam, r2, i, i2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @EGErr.EGErr1
    public int abort(int i) {
        ISearchServiceImpl iSearchServiceImpl = this.mControl;
        if (iSearchServiceImpl != null) {
            return iSearchServiceImpl.abort(i);
        }
        return Integer.MIN_VALUE;
    }

    @EGErr.EGErr1
    public int abortAll() {
        ISearchServiceImpl iSearchServiceImpl = this.mControl;
        if (iSearchServiceImpl != null) {
            return iSearchServiceImpl.abortAll();
        }
        return Integer.MIN_VALUE;
    }

    public static String getSdkVersion() {
        return ISearchServiceImpl.getSdkVersion();
    }

    public static void setDbPath(String str) {
        ISearchServiceImpl.setDbPath(str);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.SearchService.10
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.SearchService.11
        }));
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.SearchService.12
        }));
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
