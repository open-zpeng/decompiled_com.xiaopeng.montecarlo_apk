package com.autonavi.gbl.lane;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.impl.ILaneNaviServiceImpl;
import com.autonavi.gbl.lane.model.LanePlayModle;
import com.autonavi.gbl.lane.observer.ILaneNaviObserver;
import com.autonavi.gbl.lane.observer.impl.ILaneNaviObserverImpl;
import java.lang.reflect.Method;
@IntfAuto(target = ILaneNaviServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class LaneNaviService {
    private static String PACKAGE = ReflexTool.PN(LaneNaviService.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private ILaneNaviServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LaneNaviService(long j, boolean z) {
        this(new ILaneNaviServiceImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(LaneNaviService.class, this, this.mControl);
        }
    }

    public LaneNaviService(ILaneNaviServiceImpl iLaneNaviServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iLaneNaviServiceImpl);
    }

    private void $constructor(ILaneNaviServiceImpl iLaneNaviServiceImpl) {
        if (iLaneNaviServiceImpl != null) {
            this.mControl = iLaneNaviServiceImpl;
            this.mTargetId = String.format("LaneNaviService_%s_%d", String.valueOf(ILaneNaviServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ILaneNaviServiceImpl getControl() {
        return this.mControl;
    }

    public static String getEngineVersion() {
        return ILaneNaviServiceImpl.getEngineVersion();
    }

    public boolean openLaneWork(boolean z) {
        ILaneNaviServiceImpl iLaneNaviServiceImpl = this.mControl;
        if (iLaneNaviServiceImpl != null) {
            return iLaneNaviServiceImpl.openLaneWork(z);
        }
        return false;
    }

    public boolean enterLane(boolean z) {
        ILaneNaviServiceImpl iLaneNaviServiceImpl = this.mControl;
        if (iLaneNaviServiceImpl != null) {
            return iLaneNaviServiceImpl.enterLane(z);
        }
        return false;
    }

    public boolean openShowOccpyLane(boolean z) {
        ILaneNaviServiceImpl iLaneNaviServiceImpl = this.mControl;
        if (iLaneNaviServiceImpl != null) {
            return iLaneNaviServiceImpl.openShowOccpyLane(z);
        }
        return false;
    }

    public boolean openNaviLine(boolean z) {
        ILaneNaviServiceImpl iLaneNaviServiceImpl = this.mControl;
        if (iLaneNaviServiceImpl != null) {
            return iLaneNaviServiceImpl.openNaviLine(z);
        }
        return false;
    }

    public boolean setPersonNum(int i) {
        ILaneNaviServiceImpl iLaneNaviServiceImpl = this.mControl;
        if (iLaneNaviServiceImpl != null) {
            return iLaneNaviServiceImpl.setPersonNum(i);
        }
        return false;
    }

    public boolean openCalcRoadPolygon(boolean z) {
        ILaneNaviServiceImpl iLaneNaviServiceImpl = this.mControl;
        if (iLaneNaviServiceImpl != null) {
            return iLaneNaviServiceImpl.openCalcRoadPolygon(z);
        }
        return false;
    }

    public boolean setPlayModle(@LanePlayModle.LanePlayModle1 int i) {
        ILaneNaviServiceImpl iLaneNaviServiceImpl = this.mControl;
        if (iLaneNaviServiceImpl != null) {
            return iLaneNaviServiceImpl.setPlayModle(i);
        }
        return false;
    }

    public void addLaneNaviObserver(ILaneNaviObserver iLaneNaviObserver) {
        try {
            Method method = LaneNaviService.class.getMethod("addLaneNaviObserver", ILaneNaviObserver.class);
            if (iLaneNaviObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ILaneNaviObserverImpl) typeHelper.transfer(method, 0, iLaneNaviObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneNaviService.1
                    }));
                }
            }
            ILaneNaviServiceImpl iLaneNaviServiceImpl = this.mControl;
            if (iLaneNaviServiceImpl != null) {
                iLaneNaviServiceImpl.addLaneNaviObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeLaneNaviObserver(ILaneNaviObserver iLaneNaviObserver) {
        try {
            Method method = LaneNaviService.class.getMethod("removeLaneNaviObserver", ILaneNaviObserver.class);
            if (iLaneNaviObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ILaneNaviObserverImpl) typeHelper.transfer(method, 0, iLaneNaviObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneNaviService.2
                    }));
                }
            }
            ILaneNaviServiceImpl iLaneNaviServiceImpl = this.mControl;
            if (iLaneNaviServiceImpl != null) {
                iLaneNaviServiceImpl.removeLaneNaviObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneNaviService.3
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneNaviService.4
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneNaviService.5
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
