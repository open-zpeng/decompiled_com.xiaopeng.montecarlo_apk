package com.autonavi.gbl.information.nearby;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.nearby.impl.INearbyRecommendControlImpl;
import com.autonavi.gbl.information.nearby.impl.INearbyRecommendSessionImpl;
import com.autonavi.gbl.information.nearby.model.NearbyRecommendSessionInitParam;
import java.lang.reflect.Method;
@IntfAuto(target = INearbyRecommendControlImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class NearbyRecommendControl {
    private static String PACKAGE = ReflexTool.PN(NearbyRecommendControl.class);
    private INearbyRecommendControlImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected NearbyRecommendControl(long j, boolean z) {
        this(new INearbyRecommendControlImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(NearbyRecommendControl.class, this, this.mControl);
        }
    }

    public NearbyRecommendControl(INearbyRecommendControlImpl iNearbyRecommendControlImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iNearbyRecommendControlImpl);
    }

    private void $constructor(INearbyRecommendControlImpl iNearbyRecommendControlImpl) {
        if (iNearbyRecommendControlImpl != null) {
            this.mControl = iNearbyRecommendControlImpl;
            this.mTargetId = String.format("NearbyRecommendControl_%s_%d", String.valueOf(INearbyRecommendControlImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected INearbyRecommendControlImpl getControl() {
        return this.mControl;
    }

    public void unInit() {
        INearbyRecommendControlImpl iNearbyRecommendControlImpl = this.mControl;
        if (iNearbyRecommendControlImpl != null) {
            iNearbyRecommendControlImpl.unInit();
        }
    }

    public NearbyRecommendSession createSession(NearbyRecommendSessionInitParam nearbyRecommendSessionInitParam) {
        INearbyRecommendSessionImpl createSession;
        TypeHelper typeHelper;
        try {
            Method method = NearbyRecommendControl.class.getMethod("createSession", NearbyRecommendSessionInitParam.class);
            INearbyRecommendControlImpl iNearbyRecommendControlImpl = this.mControl;
            if (iNearbyRecommendControlImpl == null || (createSession = iNearbyRecommendControlImpl.createSession(nearbyRecommendSessionInitParam)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (NearbyRecommendSession) typeHelper.transfer(method, -1, (Object) createSession, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void destroySession(NearbyRecommendSession nearbyRecommendSession) {
        TypeHelper typeHelper;
        try {
            Method method = NearbyRecommendControl.class.getMethod("destroySession", NearbyRecommendSession.class);
            INearbyRecommendSessionImpl iNearbyRecommendSessionImpl = null;
            if (nearbyRecommendSession != null && (typeHelper = this.mTypeHelper) != null) {
                iNearbyRecommendSessionImpl = (INearbyRecommendSessionImpl) typeHelper.transfer(method, 0, nearbyRecommendSession);
            }
            INearbyRecommendControlImpl iNearbyRecommendControlImpl = this.mControl;
            if (iNearbyRecommendControlImpl != null) {
                iNearbyRecommendControlImpl.destroySession(iNearbyRecommendSessionImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
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
