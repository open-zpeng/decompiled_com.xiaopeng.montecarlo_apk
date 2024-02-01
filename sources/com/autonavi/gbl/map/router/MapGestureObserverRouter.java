package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.model.GestureAction;
import com.autonavi.gbl.map.observer.IMapGestureObserver;
import com.autonavi.gbl.map.observer.impl.IMapGestureObserverImpl;
@IntfAuto(target = IMapGestureObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class MapGestureObserverRouter extends IMapGestureObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(MapGestureObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(MapGestureObserverRouter.class);
    private TypeHelper mHelper;
    private IMapGestureObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IMapGestureObserver iMapGestureObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IMapGestureObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iMapGestureObserver;
    }

    protected MapGestureObserverRouter(String str, IMapGestureObserver iMapGestureObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapGestureObserver);
    }

    protected MapGestureObserverRouter(String str, IMapGestureObserver iMapGestureObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapGestureObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.observer.impl.IMapGestureObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapGestureObserverImpl
    public void onMotionEvent(long j, @GestureAction.GestureAction1 int i, long j2, long j3) {
        IMapGestureObserver iMapGestureObserver = this.mObserver;
        if (iMapGestureObserver != null) {
            iMapGestureObserver.onMotionEvent(j, i, j2, j3);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapGestureObserverImpl
    public void onMoveBegin(long j, long j2, long j3) {
        IMapGestureObserver iMapGestureObserver = this.mObserver;
        if (iMapGestureObserver != null) {
            iMapGestureObserver.onMoveBegin(j, j2, j3);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapGestureObserverImpl
    public void onMoveEnd(long j, long j2, long j3) {
        IMapGestureObserver iMapGestureObserver = this.mObserver;
        if (iMapGestureObserver != null) {
            iMapGestureObserver.onMoveEnd(j, j2, j3);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapGestureObserverImpl
    public void onMove(long j, long j2, long j3) {
        IMapGestureObserver iMapGestureObserver = this.mObserver;
        if (iMapGestureObserver != null) {
            iMapGestureObserver.onMove(j, j2, j3);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapGestureObserverImpl
    public void onMoveLocked(long j) {
        IMapGestureObserver iMapGestureObserver = this.mObserver;
        if (iMapGestureObserver != null) {
            iMapGestureObserver.onMoveLocked(j);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapGestureObserverImpl
    public void onScaleRotateBegin(long j, long j2, long j3) {
        IMapGestureObserver iMapGestureObserver = this.mObserver;
        if (iMapGestureObserver != null) {
            iMapGestureObserver.onScaleRotateBegin(j, j2, j3);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapGestureObserverImpl
    public void onScaleRotateEnd(long j, long j2, long j3) {
        IMapGestureObserver iMapGestureObserver = this.mObserver;
        if (iMapGestureObserver != null) {
            iMapGestureObserver.onScaleRotateEnd(j, j2, j3);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapGestureObserverImpl
    public void onScaleRotate(long j, long j2, long j3) {
        IMapGestureObserver iMapGestureObserver = this.mObserver;
        if (iMapGestureObserver != null) {
            iMapGestureObserver.onScaleRotate(j, j2, j3);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapGestureObserverImpl
    public void onPinchLocked(long j) {
        IMapGestureObserver iMapGestureObserver = this.mObserver;
        if (iMapGestureObserver != null) {
            iMapGestureObserver.onPinchLocked(j);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapGestureObserverImpl
    public void onLongPress(long j, long j2, long j3) {
        IMapGestureObserver iMapGestureObserver = this.mObserver;
        if (iMapGestureObserver != null) {
            iMapGestureObserver.onLongPress(j, j2, j3);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapGestureObserverImpl
    public boolean onDoublePress(long j, long j2, long j3) {
        IMapGestureObserver iMapGestureObserver = this.mObserver;
        if (iMapGestureObserver != null) {
            return iMapGestureObserver.onDoublePress(j, j2, j3);
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapGestureObserverImpl
    public boolean onSinglePress(long j, long j2, long j3, boolean z) {
        IMapGestureObserver iMapGestureObserver = this.mObserver;
        if (iMapGestureObserver != null) {
            return iMapGestureObserver.onSinglePress(j, j2, j3, z);
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapGestureObserverImpl
    public void onSliding(long j, float f, float f2) {
        IMapGestureObserver iMapGestureObserver = this.mObserver;
        if (iMapGestureObserver != null) {
            iMapGestureObserver.onSliding(j, f, f2);
        }
    }
}
