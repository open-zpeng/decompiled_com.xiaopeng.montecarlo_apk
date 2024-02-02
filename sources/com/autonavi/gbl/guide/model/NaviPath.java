package com.autonavi.gbl.guide.model;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.option.POIForRequest;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.impl.IPOIForRequestImpl;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
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
        try {
            Method method = NaviPath.class.getMethod("setVecPaths", ArrayList.class);
            if (arrayList != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ArrayList) typeHelper.transfer(method, 0, (ArrayList) arrayList) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $value == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.model.NaviPath.1
                    }));
                }
            }
            NaviPathImpl naviPathImpl = this.mControl;
            if (naviPathImpl != null) {
                naviPathImpl.setVecPaths(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public ArrayList<PathInfo> getVecPaths() {
        ArrayList<PathInfoImpl> vecPaths;
        try {
            Method method = NaviPath.class.getMethod("getVecPaths", new Class[0]);
            NaviPathImpl naviPathImpl = this.mControl;
            if (naviPathImpl != null && (vecPaths = naviPathImpl.getVecPaths()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (ArrayList) typeHelper.transfer(method, -1, (ArrayList) vecPaths, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.model.NaviPath.2
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
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
        try {
            Method method = NaviPath.class.getMethod("setPoint", POIForRequest.class);
            if (pOIForRequest != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPOIForRequestImpl) typeHelper.transfer(method, 0, pOIForRequest) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $value == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.model.NaviPath.3
                    }));
                }
            }
            NaviPathImpl naviPathImpl = this.mControl;
            if (naviPathImpl != null) {
                naviPathImpl.setPoint(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public POIForRequest getPoint() {
        IPOIForRequestImpl point;
        try {
            Method method = NaviPath.class.getMethod("getPoint", new Class[0]);
            NaviPathImpl naviPathImpl = this.mControl;
            if (naviPathImpl != null && (point = naviPathImpl.getPoint()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (POIForRequest) typeHelper.transfer(method, -1, (Object) point, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.model.NaviPath.4
                    }));
                }
            }
            return r0;
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

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.model.NaviPath.5
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
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

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.model.NaviPath.6
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.model.NaviPath.7
        }));
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
