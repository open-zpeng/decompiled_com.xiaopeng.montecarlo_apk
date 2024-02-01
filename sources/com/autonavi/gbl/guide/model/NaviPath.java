package com.autonavi.gbl.guide.model;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.option.POIForRequest;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.impl.IPOIForRequestImpl;
import com.autonavi.gbl.guide.model.SceneFlagType;
import com.autonavi.gbl.guide.model.impl.NaviPathImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = NaviPathImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class NaviPath {
    private static String PACKAGE = ReflexTool.PN(NaviPath.class);
    private NaviPathImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected NaviPath(long j, boolean z) {
        this(new NaviPathImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(NaviPath.class, this, this.mControl);
        }
    }

    public NaviPath() {
        this(new NaviPathImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(NaviPath.class, this, this.mControl);
        }
    }

    public NaviPath(NaviPathImpl naviPathImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(naviPathImpl);
    }

    private void $constructor(NaviPathImpl naviPathImpl) {
        if (naviPathImpl != null) {
            this.mControl = naviPathImpl;
            this.mTargetId = String.format("NaviPath_%s_%d", String.valueOf(NaviPathImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected NaviPathImpl getControl() {
        return this.mControl;
    }

    public void setVecPaths(ArrayList<PathInfo> arrayList) {
        NaviPathImpl naviPathImpl = this.mControl;
        if (naviPathImpl != null) {
            naviPathImpl.setVecPaths(arrayList);
        }
    }

    public ArrayList<PathInfo> getVecPaths() {
        NaviPathImpl naviPathImpl = this.mControl;
        if (naviPathImpl != null) {
            return naviPathImpl.getVecPaths();
        }
        return null;
    }

    public void setMainIdx(long j) {
        NaviPathImpl naviPathImpl = this.mControl;
        if (naviPathImpl != null) {
            naviPathImpl.setMainIdx(j);
        }
    }

    public long getMainIdx() {
        NaviPathImpl naviPathImpl = this.mControl;
        if (naviPathImpl != null) {
            return naviPathImpl.getMainIdx();
        }
        return 0L;
    }

    public void setType(int i) {
        NaviPathImpl naviPathImpl = this.mControl;
        if (naviPathImpl != null) {
            naviPathImpl.setType(i);
        }
    }

    public int getType() {
        NaviPathImpl naviPathImpl = this.mControl;
        if (naviPathImpl != null) {
            return naviPathImpl.getType();
        }
        return 0;
    }

    public void setPoint(POIForRequest pOIForRequest) {
        TypeHelper typeHelper;
        try {
            Method method = NaviPath.class.getMethod("setPoint", POIForRequest.class);
            IPOIForRequestImpl iPOIForRequestImpl = null;
            if (pOIForRequest != null && (typeHelper = this.mTypeHelper) != null) {
                iPOIForRequestImpl = (IPOIForRequestImpl) typeHelper.transfer(method, 0, pOIForRequest);
            }
            NaviPathImpl naviPathImpl = this.mControl;
            if (naviPathImpl != null) {
                naviPathImpl.setPoint(iPOIForRequestImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public POIForRequest getPoint() {
        IPOIForRequestImpl point;
        TypeHelper typeHelper;
        try {
            Method method = NaviPath.class.getMethod("getPoint", new Class[0]);
            NaviPathImpl naviPathImpl = this.mControl;
            if (naviPathImpl == null || (point = naviPathImpl.getPoint()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (POIForRequest) typeHelper.transfer(method, -1, (Object) point, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void setStrategy(int i) {
        NaviPathImpl naviPathImpl = this.mControl;
        if (naviPathImpl != null) {
            naviPathImpl.setStrategy(i);
        }
    }

    public int getStrategy() {
        NaviPathImpl naviPathImpl = this.mControl;
        if (naviPathImpl != null) {
            return naviPathImpl.getStrategy();
        }
        return 0;
    }

    public void setScene(@SceneFlagType.SceneFlagType1 int i) {
        NaviPathImpl naviPathImpl = this.mControl;
        if (naviPathImpl != null) {
            naviPathImpl.setScene(i);
        }
    }

    @SceneFlagType.SceneFlagType1
    public int getScene() {
        NaviPathImpl naviPathImpl = this.mControl;
        if (naviPathImpl != null) {
            return naviPathImpl.getScene();
        }
        return Integer.MIN_VALUE;
    }

    public void copy(NaviPath naviPath) {
        TypeHelper typeHelper;
        try {
            Method method = NaviPath.class.getMethod("copy", NaviPath.class);
            NaviPathImpl naviPathImpl = null;
            if (naviPath != null && (typeHelper = this.mTypeHelper) != null) {
                naviPathImpl = (NaviPathImpl) typeHelper.transfer(method, 0, naviPath);
            }
            NaviPathImpl naviPathImpl2 = this.mControl;
            if (naviPathImpl2 != null) {
                naviPathImpl2.copy(naviPathImpl);
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

    public synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            ReflexTool.invokeDeclMethodSafe(this.mControl, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mControl = null;
        }
        unbind();
    }
}
