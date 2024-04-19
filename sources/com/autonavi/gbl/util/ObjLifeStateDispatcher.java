package com.autonavi.gbl.util;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.impl.IObjLifeStateDispatcherImpl;
import com.autonavi.gbl.util.model.ObjLifeState;
import com.autonavi.gbl.util.observer.IObjLifeStateObserver;
import com.autonavi.gbl.util.observer.impl.IObjLifeStateObserverImpl;
import java.lang.reflect.Method;
@IntfAuto(target = IObjLifeStateDispatcherImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class ObjLifeStateDispatcher {
    private static String PACKAGE = ReflexTool.PN(ObjLifeStateDispatcher.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private IObjLifeStateDispatcherImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected ObjLifeStateDispatcher(long j, boolean z) {
        this(new IObjLifeStateDispatcherImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(ObjLifeStateDispatcher.class, this, this.mControl);
        }
    }

    public ObjLifeStateDispatcher(IObjLifeStateDispatcherImpl iObjLifeStateDispatcherImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iObjLifeStateDispatcherImpl);
    }

    private void $constructor(IObjLifeStateDispatcherImpl iObjLifeStateDispatcherImpl) {
        if (iObjLifeStateDispatcherImpl != null) {
            this.mControl = iObjLifeStateDispatcherImpl;
            this.mTargetId = String.format("ObjLifeStateDispatcher_%s_%d", String.valueOf(IObjLifeStateDispatcherImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IObjLifeStateDispatcherImpl getControl() {
        return this.mControl;
    }

    public static ObjLifeStateDispatcher getInstance() {
        try {
            Method method = ObjLifeStateDispatcher.class.getMethod("getInstance", new Class[0]);
            IObjLifeStateDispatcherImpl iObjLifeStateDispatcherImpl = IObjLifeStateDispatcherImpl.getInstance();
            if (iObjLifeStateDispatcherImpl != null) {
                TypeHelper typeHelper = gTypeHelper;
                r0 = typeHelper != null ? (ObjLifeStateDispatcher) typeHelper.transfer(method, -1, (Object) iObjLifeStateDispatcherImpl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.ObjLifeStateDispatcher.1
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public boolean addObserver(IObjLifeStateObserver iObjLifeStateObserver) {
        try {
            Method method = ObjLifeStateDispatcher.class.getMethod("addObserver", IObjLifeStateObserver.class);
            if (iObjLifeStateObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IObjLifeStateObserverImpl) typeHelper.transfer(method, 0, iObjLifeStateObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.ObjLifeStateDispatcher.2
                    }));
                    return false;
                }
            }
            IObjLifeStateDispatcherImpl iObjLifeStateDispatcherImpl = this.mControl;
            if (iObjLifeStateDispatcherImpl != null) {
                return iObjLifeStateDispatcherImpl.addObserver(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeObserver(IObjLifeStateObserver iObjLifeStateObserver) {
        try {
            Method method = ObjLifeStateDispatcher.class.getMethod("removeObserver", IObjLifeStateObserver.class);
            if (iObjLifeStateObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IObjLifeStateObserverImpl) typeHelper.transfer(method, 0, iObjLifeStateObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.ObjLifeStateDispatcher.3
                    }));
                    return false;
                }
            }
            IObjLifeStateDispatcherImpl iObjLifeStateDispatcherImpl = this.mControl;
            if (iObjLifeStateDispatcherImpl != null) {
                return iObjLifeStateDispatcherImpl.removeObserver(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public long getObserverCount() {
        IObjLifeStateDispatcherImpl iObjLifeStateDispatcherImpl = this.mControl;
        if (iObjLifeStateDispatcherImpl != null) {
            return iObjLifeStateDispatcherImpl.getObserverCount();
        }
        return 0L;
    }

    public void dispatchState(@ObjLifeState.ObjLifeState1 int i, long j, String str) {
        IObjLifeStateDispatcherImpl iObjLifeStateDispatcherImpl = this.mControl;
        if (iObjLifeStateDispatcherImpl != null) {
            iObjLifeStateDispatcherImpl.dispatchState(i, j, str);
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.ObjLifeStateDispatcher.4
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.ObjLifeStateDispatcher.5
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.ObjLifeStateDispatcher.6
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
