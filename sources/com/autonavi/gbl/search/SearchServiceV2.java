package com.autonavi.gbl.search;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.search.impl.ISearchServiceV2Impl;
import com.autonavi.gbl.search.model.KeywordSearchIdqParam;
import com.autonavi.gbl.search.model.KeywordSearchRqbxyParam;
import com.autonavi.gbl.search.model.KeywordSearchSpqParam;
import com.autonavi.gbl.search.model.KeywordSearchTQueryParam;
import com.autonavi.gbl.search.model.SceneSearchParam;
import com.autonavi.gbl.search.model.SearchMode;
import com.autonavi.gbl.search.model.SearchPoiCmallDetailParam;
import com.autonavi.gbl.search.model.SearchPoiDetailParam;
import com.autonavi.gbl.search.model.SearchPoiShopListParam;
import com.autonavi.gbl.search.observer.IKeyWordSearchObserverV2;
import com.autonavi.gbl.search.observer.IPoiCmallDetailSearchObserver;
import com.autonavi.gbl.search.observer.IPoiDetailSearchObserver;
import com.autonavi.gbl.search.observer.IPoiShopListSearchObserver;
import com.autonavi.gbl.search.observer.ISceneSearchObserver;
import com.autonavi.gbl.search.observer.impl.IKeyWordSearchObserverV2Impl;
import com.autonavi.gbl.search.observer.impl.IPoiCmallDetailSearchObserverImpl;
import com.autonavi.gbl.search.observer.impl.IPoiDetailSearchObserverImpl;
import com.autonavi.gbl.search.observer.impl.IPoiShopListSearchObserverImpl;
import com.autonavi.gbl.search.observer.impl.ISceneSearchObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
@IntfAuto(target = ISearchServiceV2Impl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class SearchServiceV2 implements IService {
    private static String PACKAGE = ReflexTool.PN(SearchServiceV2.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private ISearchServiceV2Impl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected SearchServiceV2(long j, boolean z) {
        this((ISearchServiceV2Impl) ReflexTool.invokeDeclConstructorSafe(ISearchServiceV2Impl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(SearchServiceV2.class, this, this.mControl);
        }
    }

    public SearchServiceV2(ISearchServiceV2Impl iSearchServiceV2Impl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iSearchServiceV2Impl);
    }

    private void $constructor(ISearchServiceV2Impl iSearchServiceV2Impl) {
        if (iSearchServiceV2Impl != null) {
            this.mControl = iSearchServiceV2Impl;
            this.mTargetId = String.format("SearchServiceV2_%s_%d", String.valueOf(ISearchServiceV2Impl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ISearchServiceV2Impl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        ISearchServiceV2Impl iSearchServiceV2Impl = this.mControl;
        if (iSearchServiceV2Impl != null) {
            return iSearchServiceV2Impl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        ISearchServiceV2Impl iSearchServiceV2Impl = this.mControl;
        if (iSearchServiceV2Impl != null) {
            return iSearchServiceV2Impl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        ISearchServiceV2Impl iSearchServiceV2Impl = this.mControl;
        if (iSearchServiceV2Impl != null) {
            iSearchServiceV2Impl.onCreate();
        }
    }

    public void init() {
        ISearchServiceV2Impl iSearchServiceV2Impl = this.mControl;
        if (iSearchServiceV2Impl != null) {
            iSearchServiceV2Impl.init();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        ISearchServiceV2Impl iSearchServiceV2Impl = this.mControl;
        if (iSearchServiceV2Impl != null) {
            return iSearchServiceV2Impl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public int keyWordSearchTQuery(KeywordSearchTQueryParam keywordSearchTQueryParam, IKeyWordSearchObserverV2 iKeyWordSearchObserverV2, @SearchMode.SearchMode1 int i, int i2) {
        TypeHelper typeHelper;
        try {
            Method method = SearchServiceV2.class.getMethod("keyWordSearchTQuery", KeywordSearchTQueryParam.class, IKeyWordSearchObserverV2.class, Integer.TYPE, Integer.TYPE);
            IKeyWordSearchObserverV2Impl iKeyWordSearchObserverV2Impl = null;
            if (iKeyWordSearchObserverV2 != null && (typeHelper = this.mTypeHelper) != null) {
                iKeyWordSearchObserverV2Impl = (IKeyWordSearchObserverV2Impl) typeHelper.transfer(method, 1, iKeyWordSearchObserverV2);
            }
            ISearchServiceV2Impl iSearchServiceV2Impl = this.mControl;
            if (iSearchServiceV2Impl != null) {
                return iSearchServiceV2Impl.keyWordSearchTQuery(keywordSearchTQueryParam, iKeyWordSearchObserverV2Impl, i, i2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int keyWordSearchIdq(KeywordSearchIdqParam keywordSearchIdqParam, IKeyWordSearchObserverV2 iKeyWordSearchObserverV2, @SearchMode.SearchMode1 int i, int i2) {
        TypeHelper typeHelper;
        try {
            Method method = SearchServiceV2.class.getMethod("keyWordSearchIdq", KeywordSearchIdqParam.class, IKeyWordSearchObserverV2.class, Integer.TYPE, Integer.TYPE);
            IKeyWordSearchObserverV2Impl iKeyWordSearchObserverV2Impl = null;
            if (iKeyWordSearchObserverV2 != null && (typeHelper = this.mTypeHelper) != null) {
                iKeyWordSearchObserverV2Impl = (IKeyWordSearchObserverV2Impl) typeHelper.transfer(method, 1, iKeyWordSearchObserverV2);
            }
            ISearchServiceV2Impl iSearchServiceV2Impl = this.mControl;
            if (iSearchServiceV2Impl != null) {
                return iSearchServiceV2Impl.keyWordSearchIdq(keywordSearchIdqParam, iKeyWordSearchObserverV2Impl, i, i2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int keyWordSearchRqbxy(KeywordSearchRqbxyParam keywordSearchRqbxyParam, IKeyWordSearchObserverV2 iKeyWordSearchObserverV2, @SearchMode.SearchMode1 int i, int i2) {
        TypeHelper typeHelper;
        try {
            Method method = SearchServiceV2.class.getMethod("keyWordSearchRqbxy", KeywordSearchRqbxyParam.class, IKeyWordSearchObserverV2.class, Integer.TYPE, Integer.TYPE);
            IKeyWordSearchObserverV2Impl iKeyWordSearchObserverV2Impl = null;
            if (iKeyWordSearchObserverV2 != null && (typeHelper = this.mTypeHelper) != null) {
                iKeyWordSearchObserverV2Impl = (IKeyWordSearchObserverV2Impl) typeHelper.transfer(method, 1, iKeyWordSearchObserverV2);
            }
            ISearchServiceV2Impl iSearchServiceV2Impl = this.mControl;
            if (iSearchServiceV2Impl != null) {
                return iSearchServiceV2Impl.keyWordSearchRqbxy(keywordSearchRqbxyParam, iKeyWordSearchObserverV2Impl, i, i2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int keyWordSearchSpq(KeywordSearchSpqParam keywordSearchSpqParam, IKeyWordSearchObserverV2 iKeyWordSearchObserverV2, @SearchMode.SearchMode1 int i, int i2) {
        TypeHelper typeHelper;
        try {
            Method method = SearchServiceV2.class.getMethod("keyWordSearchSpq", KeywordSearchSpqParam.class, IKeyWordSearchObserverV2.class, Integer.TYPE, Integer.TYPE);
            IKeyWordSearchObserverV2Impl iKeyWordSearchObserverV2Impl = null;
            if (iKeyWordSearchObserverV2 != null && (typeHelper = this.mTypeHelper) != null) {
                iKeyWordSearchObserverV2Impl = (IKeyWordSearchObserverV2Impl) typeHelper.transfer(method, 1, iKeyWordSearchObserverV2);
            }
            ISearchServiceV2Impl iSearchServiceV2Impl = this.mControl;
            if (iSearchServiceV2Impl != null) {
                return iSearchServiceV2Impl.keyWordSearchSpq(keywordSearchSpqParam, iKeyWordSearchObserverV2Impl, i, i2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int sceneSearch(SceneSearchParam sceneSearchParam, ISceneSearchObserver iSceneSearchObserver, @SearchMode.SearchMode1 int i, int i2) {
        TypeHelper typeHelper;
        try {
            Method method = SearchServiceV2.class.getMethod("sceneSearch", SceneSearchParam.class, ISceneSearchObserver.class, Integer.TYPE, Integer.TYPE);
            ISceneSearchObserverImpl iSceneSearchObserverImpl = null;
            if (iSceneSearchObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iSceneSearchObserverImpl = (ISceneSearchObserverImpl) typeHelper.transfer(method, 1, iSceneSearchObserver);
            }
            ISearchServiceV2Impl iSearchServiceV2Impl = this.mControl;
            if (iSearchServiceV2Impl != null) {
                return iSearchServiceV2Impl.sceneSearch(sceneSearchParam, iSceneSearchObserverImpl, i, i2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int poiDetailSearch(SearchPoiDetailParam searchPoiDetailParam, IPoiDetailSearchObserver iPoiDetailSearchObserver, @SearchMode.SearchMode1 int i, int i2) {
        TypeHelper typeHelper;
        try {
            Method method = SearchServiceV2.class.getMethod("poiDetailSearch", SearchPoiDetailParam.class, IPoiDetailSearchObserver.class, Integer.TYPE, Integer.TYPE);
            IPoiDetailSearchObserverImpl iPoiDetailSearchObserverImpl = null;
            if (iPoiDetailSearchObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPoiDetailSearchObserverImpl = (IPoiDetailSearchObserverImpl) typeHelper.transfer(method, 1, iPoiDetailSearchObserver);
            }
            ISearchServiceV2Impl iSearchServiceV2Impl = this.mControl;
            if (iSearchServiceV2Impl != null) {
                return iSearchServiceV2Impl.poiDetailSearch(searchPoiDetailParam, iPoiDetailSearchObserverImpl, i, i2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int poiCmallDetailSearch(SearchPoiCmallDetailParam searchPoiCmallDetailParam, IPoiCmallDetailSearchObserver iPoiCmallDetailSearchObserver, @SearchMode.SearchMode1 int i, int i2) {
        TypeHelper typeHelper;
        try {
            Method method = SearchServiceV2.class.getMethod("poiCmallDetailSearch", SearchPoiCmallDetailParam.class, IPoiCmallDetailSearchObserver.class, Integer.TYPE, Integer.TYPE);
            IPoiCmallDetailSearchObserverImpl iPoiCmallDetailSearchObserverImpl = null;
            if (iPoiCmallDetailSearchObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPoiCmallDetailSearchObserverImpl = (IPoiCmallDetailSearchObserverImpl) typeHelper.transfer(method, 1, iPoiCmallDetailSearchObserver);
            }
            ISearchServiceV2Impl iSearchServiceV2Impl = this.mControl;
            if (iSearchServiceV2Impl != null) {
                return iSearchServiceV2Impl.poiCmallDetailSearch(searchPoiCmallDetailParam, iPoiCmallDetailSearchObserverImpl, i, i2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int poiShopListSearch(SearchPoiShopListParam searchPoiShopListParam, IPoiShopListSearchObserver iPoiShopListSearchObserver, @SearchMode.SearchMode1 int i, int i2) {
        TypeHelper typeHelper;
        try {
            Method method = SearchServiceV2.class.getMethod("poiShopListSearch", SearchPoiShopListParam.class, IPoiShopListSearchObserver.class, Integer.TYPE, Integer.TYPE);
            IPoiShopListSearchObserverImpl iPoiShopListSearchObserverImpl = null;
            if (iPoiShopListSearchObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPoiShopListSearchObserverImpl = (IPoiShopListSearchObserverImpl) typeHelper.transfer(method, 1, iPoiShopListSearchObserver);
            }
            ISearchServiceV2Impl iSearchServiceV2Impl = this.mControl;
            if (iSearchServiceV2Impl != null) {
                return iSearchServiceV2Impl.poiShopListSearch(searchPoiShopListParam, iPoiShopListSearchObserverImpl, i, i2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int abort(int i) {
        ISearchServiceV2Impl iSearchServiceV2Impl = this.mControl;
        if (iSearchServiceV2Impl != null) {
            return iSearchServiceV2Impl.abort(i);
        }
        return Integer.MIN_VALUE;
    }

    public int abortAll() {
        ISearchServiceV2Impl iSearchServiceV2Impl = this.mControl;
        if (iSearchServiceV2Impl != null) {
            return iSearchServiceV2Impl.abortAll();
        }
        return Integer.MIN_VALUE;
    }

    public static String getSdkVersion() {
        return ISearchServiceV2Impl.getSdkVersion();
    }

    public static void setDbPath(String str) {
        ISearchServiceV2Impl.setDbPath(str);
    }

    protected void unbind() {
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

    protected synchronized void delete() {
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
