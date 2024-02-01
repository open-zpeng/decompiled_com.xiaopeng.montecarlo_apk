package com.autonavi.gbl.lane;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.lane.impl.ILaneMockServiceImpl;
import com.autonavi.gbl.lane.model.LaneChangeDirection;
import com.autonavi.gbl.lane.observer.ILaneMockObserver;
import com.autonavi.gbl.lane.observer.impl.ILaneMockObserverImpl;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
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

    @Deprecated
    public void setNaviPath(PathInfo pathInfo) {
        ILaneMockServiceImpl iLaneMockServiceImpl = this.mControl;
        if (iLaneMockServiceImpl != null) {
            iLaneMockServiceImpl.setNaviPath(pathInfo);
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

    public void addLaneMockObserver(ILaneMockObserver iLaneMockObserver) {
        TypeHelper typeHelper;
        try {
            Method method = LaneMockService.class.getMethod("addLaneMockObserver", ILaneMockObserver.class);
            ILaneMockObserverImpl iLaneMockObserverImpl = null;
            if (iLaneMockObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLaneMockObserverImpl = (ILaneMockObserverImpl) typeHelper.transfer(method, 0, iLaneMockObserver);
            }
            ILaneMockServiceImpl iLaneMockServiceImpl = this.mControl;
            if (iLaneMockServiceImpl != null) {
                iLaneMockServiceImpl.addLaneMockObserver(iLaneMockObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeLaneMockObserver(ILaneMockObserver iLaneMockObserver) {
        TypeHelper typeHelper;
        try {
            Method method = LaneMockService.class.getMethod("removeLaneMockObserver", ILaneMockObserver.class);
            ILaneMockObserverImpl iLaneMockObserverImpl = null;
            if (iLaneMockObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLaneMockObserverImpl = (ILaneMockObserverImpl) typeHelper.transfer(method, 0, iLaneMockObserver);
            }
            ILaneMockServiceImpl iLaneMockServiceImpl = this.mControl;
            if (iLaneMockServiceImpl != null) {
                iLaneMockServiceImpl.removeLaneMockObserver(iLaneMockObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iLaneMockObserver);
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
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.lane.observer.ILaneMockObserver")).iterator();
            while (it.hasNext()) {
                removeLaneMockObserver((ILaneMockObserver) it.next());
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
