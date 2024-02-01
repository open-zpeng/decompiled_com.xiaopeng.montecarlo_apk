package com.autonavi.gbl.information.nearby;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.information.nearby.impl.INearbyRecommendSessionImpl;
import com.autonavi.gbl.information.nearby.model.NearbyRecommendParam;
import com.autonavi.gbl.information.nearby.model.NearbyRecommendPoiRetainParam;
import com.autonavi.gbl.information.nearby.observer.INearbyRecommendObserver;
import com.autonavi.gbl.information.nearby.observer.impl.INearbyRecommendObserverImpl;
import com.autonavi.gbl.search.model.SearchTabInfo;
import com.lzy.okgo.model.Progress;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = INearbyRecommendSessionImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class NearbyRecommendSession {
    private static String PACKAGE = ReflexTool.PN(NearbyRecommendSession.class);
    private INearbyRecommendSessionImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected NearbyRecommendSession(long j, boolean z) {
        this(new INearbyRecommendSessionImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(NearbyRecommendSession.class, this, this.mControl);
        }
    }

    public NearbyRecommendSession(INearbyRecommendSessionImpl iNearbyRecommendSessionImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iNearbyRecommendSessionImpl);
    }

    private void $constructor(INearbyRecommendSessionImpl iNearbyRecommendSessionImpl) {
        if (iNearbyRecommendSessionImpl != null) {
            this.mControl = iNearbyRecommendSessionImpl;
            this.mTargetId = String.format("NearbyRecommendSession_%s_%d", String.valueOf(INearbyRecommendSessionImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected INearbyRecommendSessionImpl getControl() {
        return this.mControl;
    }

    public long request(NearbyRecommendParam nearbyRecommendParam, INearbyRecommendObserver iNearbyRecommendObserver) {
        TypeHelper typeHelper;
        try {
            Method method = NearbyRecommendSession.class.getMethod(Progress.REQUEST, NearbyRecommendParam.class, INearbyRecommendObserver.class);
            INearbyRecommendObserverImpl iNearbyRecommendObserverImpl = null;
            if (iNearbyRecommendObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iNearbyRecommendObserverImpl = (INearbyRecommendObserverImpl) typeHelper.transfer(method, 1, iNearbyRecommendObserver);
            }
            INearbyRecommendSessionImpl iNearbyRecommendSessionImpl = this.mControl;
            if (iNearbyRecommendSessionImpl != null) {
                return iNearbyRecommendSessionImpl.request(nearbyRecommendParam, iNearbyRecommendObserverImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public void abort(long j) {
        INearbyRecommendSessionImpl iNearbyRecommendSessionImpl = this.mControl;
        if (iNearbyRecommendSessionImpl != null) {
            iNearbyRecommendSessionImpl.abort(j);
        }
    }

    public void setLocation(Coord2DDouble coord2DDouble) {
        INearbyRecommendSessionImpl iNearbyRecommendSessionImpl = this.mControl;
        if (iNearbyRecommendSessionImpl != null) {
            iNearbyRecommendSessionImpl.setLocation(coord2DDouble);
        }
    }

    public int onShowPoi(ArrayList<NearbyRecommendPoiRetainParam> arrayList) {
        INearbyRecommendSessionImpl iNearbyRecommendSessionImpl = this.mControl;
        if (iNearbyRecommendSessionImpl != null) {
            return iNearbyRecommendSessionImpl.onShowPoi(arrayList);
        }
        return Integer.MIN_VALUE;
    }

    public int onShowTab(SearchTabInfo searchTabInfo) {
        INearbyRecommendSessionImpl iNearbyRecommendSessionImpl = this.mControl;
        if (iNearbyRecommendSessionImpl != null) {
            return iNearbyRecommendSessionImpl.onShowTab(searchTabInfo);
        }
        return Integer.MIN_VALUE;
    }

    public int onClickPoi(NearbyRecommendPoiRetainParam nearbyRecommendPoiRetainParam) {
        INearbyRecommendSessionImpl iNearbyRecommendSessionImpl = this.mControl;
        if (iNearbyRecommendSessionImpl != null) {
            return iNearbyRecommendSessionImpl.onClickPoi(nearbyRecommendPoiRetainParam);
        }
        return Integer.MIN_VALUE;
    }

    public int clickTab(SearchTabInfo searchTabInfo) {
        INearbyRecommendSessionImpl iNearbyRecommendSessionImpl = this.mControl;
        if (iNearbyRecommendSessionImpl != null) {
            return iNearbyRecommendSessionImpl.clickTab(searchTabInfo);
        }
        return Integer.MIN_VALUE;
    }

    public int like(NearbyRecommendPoiRetainParam nearbyRecommendPoiRetainParam) {
        INearbyRecommendSessionImpl iNearbyRecommendSessionImpl = this.mControl;
        if (iNearbyRecommendSessionImpl != null) {
            return iNearbyRecommendSessionImpl.like(nearbyRecommendPoiRetainParam);
        }
        return Integer.MIN_VALUE;
    }

    public int dislike(NearbyRecommendPoiRetainParam nearbyRecommendPoiRetainParam) {
        INearbyRecommendSessionImpl iNearbyRecommendSessionImpl = this.mControl;
        if (iNearbyRecommendSessionImpl != null) {
            return iNearbyRecommendSessionImpl.dislike(nearbyRecommendPoiRetainParam);
        }
        return Integer.MIN_VALUE;
    }

    public int setPersonalizeEnable(boolean z) {
        INearbyRecommendSessionImpl iNearbyRecommendSessionImpl = this.mControl;
        if (iNearbyRecommendSessionImpl != null) {
            return iNearbyRecommendSessionImpl.setPersonalizeEnable(z);
        }
        return Integer.MIN_VALUE;
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

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
