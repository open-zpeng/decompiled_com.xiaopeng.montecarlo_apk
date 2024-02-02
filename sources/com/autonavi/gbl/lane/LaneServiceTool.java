package com.autonavi.gbl.lane;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
import com.autonavi.gbl.lane.impl.ILaneServiceToolImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = ILaneServiceToolImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class LaneServiceTool {
    private static String PACKAGE = ReflexTool.PN(LaneServiceTool.class);
    private ILaneServiceToolImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LaneServiceTool(long j, boolean z) {
        this(new ILaneServiceToolImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(LaneServiceTool.class, this, this.mControl);
        }
    }

    public LaneServiceTool(ILaneServiceToolImpl iLaneServiceToolImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iLaneServiceToolImpl);
    }

    private void $constructor(ILaneServiceToolImpl iLaneServiceToolImpl) {
        if (iLaneServiceToolImpl != null) {
            this.mControl = iLaneServiceToolImpl;
            this.mTargetId = String.format("LaneServiceTool_%s_%d", String.valueOf(ILaneServiceToolImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ILaneServiceToolImpl getControl() {
        return this.mControl;
    }

    public ArrayList<Long> getPathCityList(PathInfo pathInfo) {
        PathInfoImpl pathInfoImpl;
        try {
            Method method = LaneServiceTool.class.getMethod("getPathCityList", PathInfo.class);
            if (pathInfo != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                pathInfoImpl = typeHelper != null ? (PathInfoImpl) typeHelper.transfer(method, 0, pathInfo) : null;
                if (pathInfoImpl == null) {
                    DebugTool.e("%s: $pathInfo == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneServiceTool.1
                    }));
                    return null;
                }
            } else {
                pathInfoImpl = null;
            }
            ILaneServiceToolImpl iLaneServiceToolImpl = this.mControl;
            if (iLaneServiceToolImpl != null) {
                return iLaneServiceToolImpl.getPathCityList(pathInfoImpl);
            }
            return null;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public boolean enableDynamicLevelUseExternalSpeed(boolean z) {
        ILaneServiceToolImpl iLaneServiceToolImpl = this.mControl;
        if (iLaneServiceToolImpl != null) {
            return iLaneServiceToolImpl.enableDynamicLevelUseExternalSpeed(z);
        }
        return false;
    }

    public boolean setDynamicLevelExternalSpeed(float f) {
        ILaneServiceToolImpl iLaneServiceToolImpl = this.mControl;
        if (iLaneServiceToolImpl != null) {
            return iLaneServiceToolImpl.setDynamicLevelExternalSpeed(f);
        }
        return false;
    }

    public String getProjectInfo() {
        ILaneServiceToolImpl iLaneServiceToolImpl = this.mControl;
        if (iLaneServiceToolImpl != null) {
            return iLaneServiceToolImpl.getProjectInfo();
        }
        return null;
    }

    public boolean setProjectInfo(String str) {
        ILaneServiceToolImpl iLaneServiceToolImpl = this.mControl;
        if (iLaneServiceToolImpl != null) {
            return iLaneServiceToolImpl.setProjectInfo(str);
        }
        return false;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneServiceTool.2
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneServiceTool.3
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneServiceTool.4
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
