package com.autonavi.gbl.lane;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.impl.ILaneNaviServiceImpl;
import com.autonavi.gbl.lane.model.LaneNaviParamType;
import com.autonavi.gbl.lane.observer.ILaneDigitalTrackObserver;
import com.autonavi.gbl.lane.observer.impl.ILaneDigitalTrackObserverImpl;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
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

    @Deprecated
    public static String getEngineVersion() {
        return ILaneNaviServiceImpl.getEngineVersion();
    }

    @Deprecated
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

    @Deprecated
    public boolean openShowOccpyLane(boolean z) {
        ILaneNaviServiceImpl iLaneNaviServiceImpl = this.mControl;
        if (iLaneNaviServiceImpl != null) {
            return iLaneNaviServiceImpl.openShowOccpyLane(z);
        }
        return false;
    }

    @Deprecated
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

    @Deprecated
    public boolean openCalcRoadPolygon(boolean z) {
        ILaneNaviServiceImpl iLaneNaviServiceImpl = this.mControl;
        if (iLaneNaviServiceImpl != null) {
            return iLaneNaviServiceImpl.openCalcRoadPolygon(z);
        }
        return false;
    }

    public boolean setOddShowNum(int i) {
        ILaneNaviServiceImpl iLaneNaviServiceImpl = this.mControl;
        if (iLaneNaviServiceImpl != null) {
            return iLaneNaviServiceImpl.setOddShowNum(i);
        }
        return false;
    }

    public int setParam(@LaneNaviParamType.LaneNaviParamType1 int i, String str) {
        ILaneNaviServiceImpl iLaneNaviServiceImpl = this.mControl;
        if (iLaneNaviServiceImpl != null) {
            return iLaneNaviServiceImpl.setParam(i, str);
        }
        return Integer.MIN_VALUE;
    }

    public void addObserver(ILaneDigitalTrackObserver iLaneDigitalTrackObserver) {
        TypeHelper typeHelper;
        try {
            Method method = LaneNaviService.class.getMethod("addObserver", ILaneDigitalTrackObserver.class);
            ILaneDigitalTrackObserverImpl iLaneDigitalTrackObserverImpl = null;
            if (iLaneDigitalTrackObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLaneDigitalTrackObserverImpl = (ILaneDigitalTrackObserverImpl) typeHelper.transfer(method, 0, iLaneDigitalTrackObserver);
            }
            ILaneNaviServiceImpl iLaneNaviServiceImpl = this.mControl;
            if (iLaneNaviServiceImpl != null) {
                iLaneNaviServiceImpl.addObserver(iLaneDigitalTrackObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeObserver(ILaneDigitalTrackObserver iLaneDigitalTrackObserver) {
        TypeHelper typeHelper;
        try {
            Method method = LaneNaviService.class.getMethod("removeObserver", ILaneDigitalTrackObserver.class);
            ILaneDigitalTrackObserverImpl iLaneDigitalTrackObserverImpl = null;
            if (iLaneDigitalTrackObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLaneDigitalTrackObserverImpl = (ILaneDigitalTrackObserverImpl) typeHelper.transfer(method, 0, iLaneDigitalTrackObserver);
            }
            ILaneNaviServiceImpl iLaneNaviServiceImpl = this.mControl;
            if (iLaneNaviServiceImpl != null) {
                iLaneNaviServiceImpl.removeObserver(iLaneDigitalTrackObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iLaneDigitalTrackObserver);
                }
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

    protected void clean() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.lane.observer.ILaneDigitalTrackObserver")).iterator();
            while (it.hasNext()) {
                removeObserver((ILaneDigitalTrackObserver) it.next());
            }
        }
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
