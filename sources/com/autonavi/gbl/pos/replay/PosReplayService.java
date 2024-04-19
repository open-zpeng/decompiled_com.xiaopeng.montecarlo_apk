package com.autonavi.gbl.pos.replay;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
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
        try {
            Method method = PosReplayService.class.getMethod("setPosService", PosService.class);
            if (posService != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosServiceImpl) typeHelper.transfer(method, 0, posService) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $posService == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.replay.PosReplayService.1
                    }));
                }
            }
            IPosReplayServiceImpl iPosReplayServiceImpl = this.mControl;
            if (iPosReplayServiceImpl != null) {
                iPosReplayServiceImpl.setPosService(r1);
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
        try {
            Method method = PosReplayService.class.getMethod("addPosReplayObserver", IPosReplayObserver.class);
            if (iPosReplayObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosReplayObserverImpl) typeHelper.transfer(method, 0, iPosReplayObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.replay.PosReplayService.2
                    }));
                }
            }
            IPosReplayServiceImpl iPosReplayServiceImpl = this.mControl;
            if (iPosReplayServiceImpl != null) {
                iPosReplayServiceImpl.addPosReplayObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removePosReplayObserver(IPosReplayObserver iPosReplayObserver) {
        try {
            Method method = PosReplayService.class.getMethod("removePosReplayObserver", IPosReplayObserver.class);
            if (iPosReplayObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosReplayObserverImpl) typeHelper.transfer(method, 0, iPosReplayObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.replay.PosReplayService.3
                    }));
                }
            }
            IPosReplayServiceImpl iPosReplayServiceImpl = this.mControl;
            if (iPosReplayServiceImpl != null) {
                iPosReplayServiceImpl.removePosReplayObserver(r1);
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
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.replay.PosReplayService.4
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.replay.PosReplayService.5
        }));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.pos.replay.observer.IPosReplayObserver")).iterator();
            while (it.hasNext()) {
                removePosReplayObserver((IPosReplayObserver) it.next());
            }
        }
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.replay.PosReplayService.6
        }));
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
