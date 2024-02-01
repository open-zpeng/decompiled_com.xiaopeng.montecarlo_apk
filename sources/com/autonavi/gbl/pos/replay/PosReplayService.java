package com.autonavi.gbl.pos.replay;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.pos.PosService;
import com.autonavi.gbl.pos.impl.IPosServiceImpl;
import com.autonavi.gbl.pos.replay.impl.IPosReplayServiceImpl;
import com.autonavi.gbl.pos.replay.observer.IPosReplayObserver;
import com.autonavi.gbl.pos.replay.observer.impl.IPosReplayObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IPosReplayServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class PosReplayService implements IService {
    private static String PACKAGE = ReflexTool.PN(PosReplayService.class);
    private IPosReplayServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected PosReplayService(long j, boolean z) {
        this((IPosReplayServiceImpl) ReflexTool.invokeDeclConstructorSafe(IPosReplayServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(PosReplayService.class, this, this.mControl);
        }
    }

    public PosReplayService(IPosReplayServiceImpl iPosReplayServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iPosReplayServiceImpl);
    }

    private void $constructor(IPosReplayServiceImpl iPosReplayServiceImpl) {
        if (iPosReplayServiceImpl != null) {
            this.mControl = iPosReplayServiceImpl;
            this.mTargetId = String.format("PosReplayService_%s_%d", String.valueOf(IPosReplayServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IPosReplayServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IPosReplayServiceImpl iPosReplayServiceImpl = this.mControl;
        if (iPosReplayServiceImpl != null) {
            return iPosReplayServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IPosReplayServiceImpl iPosReplayServiceImpl = this.mControl;
        if (iPosReplayServiceImpl != null) {
            return iPosReplayServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IPosReplayServiceImpl iPosReplayServiceImpl = this.mControl;
        if (iPosReplayServiceImpl != null) {
            iPosReplayServiceImpl.onCreate();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IPosReplayServiceImpl iPosReplayServiceImpl = this.mControl;
        if (iPosReplayServiceImpl != null) {
            return iPosReplayServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public void setPosService(PosService posService) {
        TypeHelper typeHelper;
        try {
            Method method = PosReplayService.class.getMethod("setPosService", PosService.class);
            IPosServiceImpl iPosServiceImpl = null;
            if (posService != null && (typeHelper = this.mTypeHelper) != null) {
                iPosServiceImpl = (IPosServiceImpl) typeHelper.transfer(method, 0, posService);
            }
            IPosReplayServiceImpl iPosReplayServiceImpl = this.mControl;
            if (iPosReplayServiceImpl != null) {
                iPosReplayServiceImpl.setPosService(iPosServiceImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setLocPath(String str) {
        IPosReplayServiceImpl iPosReplayServiceImpl = this.mControl;
        if (iPosReplayServiceImpl != null) {
            iPosReplayServiceImpl.setLocPath(str);
        }
    }

    public void setReplaySpeedTime(long j) {
        IPosReplayServiceImpl iPosReplayServiceImpl = this.mControl;
        if (iPosReplayServiceImpl != null) {
            iPosReplayServiceImpl.setReplaySpeedTime(j);
        }
    }

    public void start() {
        IPosReplayServiceImpl iPosReplayServiceImpl = this.mControl;
        if (iPosReplayServiceImpl != null) {
            iPosReplayServiceImpl.start();
        }
    }

    public void stop() {
        IPosReplayServiceImpl iPosReplayServiceImpl = this.mControl;
        if (iPosReplayServiceImpl != null) {
            iPosReplayServiceImpl.stop();
        }
    }

    public void pause() {
        IPosReplayServiceImpl iPosReplayServiceImpl = this.mControl;
        if (iPosReplayServiceImpl != null) {
            iPosReplayServiceImpl.pause();
        }
    }

    public void resume() {
        IPosReplayServiceImpl iPosReplayServiceImpl = this.mControl;
        if (iPosReplayServiceImpl != null) {
            iPosReplayServiceImpl.resume();
        }
    }

    public void addPosReplayObserver(IPosReplayObserver iPosReplayObserver) {
        TypeHelper typeHelper;
        try {
            Method method = PosReplayService.class.getMethod("addPosReplayObserver", IPosReplayObserver.class);
            IPosReplayObserverImpl iPosReplayObserverImpl = null;
            if (iPosReplayObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosReplayObserverImpl = (IPosReplayObserverImpl) typeHelper.transfer(method, 0, iPosReplayObserver);
            }
            IPosReplayServiceImpl iPosReplayServiceImpl = this.mControl;
            if (iPosReplayServiceImpl != null) {
                iPosReplayServiceImpl.addPosReplayObserver(iPosReplayObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removePosReplayObserver(IPosReplayObserver iPosReplayObserver) {
        TypeHelper typeHelper;
        try {
            Method method = PosReplayService.class.getMethod("removePosReplayObserver", IPosReplayObserver.class);
            IPosReplayObserverImpl iPosReplayObserverImpl = null;
            if (iPosReplayObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosReplayObserverImpl = (IPosReplayObserverImpl) typeHelper.transfer(method, 0, iPosReplayObserver);
            }
            IPosReplayServiceImpl iPosReplayServiceImpl = this.mControl;
            if (iPosReplayServiceImpl != null) {
                iPosReplayServiceImpl.removePosReplayObserver(iPosReplayObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iPosReplayObserver);
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

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.pos.replay.observer.IPosReplayObserver")).iterator();
            while (it.hasNext()) {
                removePosReplayObserver((IPosReplayObserver) it.next());
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
