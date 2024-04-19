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
import com.autonavi.gbl.lane.impl.ILaneMockServiceImpl;
import com.autonavi.gbl.lane.model.LaneChangeDirection;
import java.lang.reflect.Method;
@IntfAuto(target = ILaneMockServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class LaneMockService {
    private static String PACKAGE = ReflexTool.PN(LaneMockService.class);
    private ILaneMockServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LaneMockService(long j, boolean z) {
        this(new ILaneMockServiceImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(LaneMockService.class, this, this.mControl);
        }
    }

    public LaneMockService(ILaneMockServiceImpl iLaneMockServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iLaneMockServiceImpl);
    }

    private void $constructor(ILaneMockServiceImpl iLaneMockServiceImpl) {
        if (iLaneMockServiceImpl != null) {
            this.mControl = iLaneMockServiceImpl;
            this.mTargetId = String.format("LaneMockService_%s_%d", String.valueOf(ILaneMockServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ILaneMockServiceImpl getControl() {
        return this.mControl;
    }

    public void start() {
        ILaneMockServiceImpl iLaneMockServiceImpl = this.mControl;
        if (iLaneMockServiceImpl != null) {
            iLaneMockServiceImpl.start();
        }
    }

    public void stop() {
        ILaneMockServiceImpl iLaneMockServiceImpl = this.mControl;
        if (iLaneMockServiceImpl != null) {
            iLaneMockServiceImpl.stop();
        }
    }

    public void setNaviPath(PathInfo pathInfo) {
        try {
            Method method = LaneMockService.class.getMethod("setNaviPath", PathInfo.class);
            if (pathInfo != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (PathInfoImpl) typeHelper.transfer(method, 0, pathInfo) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pathInfo == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneMockService.1
                    }));
                }
            }
            ILaneMockServiceImpl iLaneMockServiceImpl = this.mControl;
            if (iLaneMockServiceImpl != null) {
                iLaneMockServiceImpl.setNaviPath(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public boolean setPlaySpeed(float f) {
        ILaneMockServiceImpl iLaneMockServiceImpl = this.mControl;
        if (iLaneMockServiceImpl != null) {
            return iLaneMockServiceImpl.setPlaySpeed(f);
        }
        return false;
    }

    public boolean changeLane(@LaneChangeDirection.LaneChangeDirection1 int i) {
        ILaneMockServiceImpl iLaneMockServiceImpl = this.mControl;
        if (iLaneMockServiceImpl != null) {
            return iLaneMockServiceImpl.changeLane(i);
        }
        return false;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneMockService.2
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneMockService.3
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneMockService.4
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
