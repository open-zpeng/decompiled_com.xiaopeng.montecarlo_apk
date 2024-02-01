package com.autonavi.gbl.util;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
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

    protected void clean() {
    }

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
        TypeHelper typeHelper;
        try {
            Method method = ObjLifeStateDispatcher.class.getMethod("getInstance", new Class[0]);
            IObjLifeStateDispatcherImpl iObjLifeStateDispatcherImpl = IObjLifeStateDispatcherImpl.getInstance();
            if (iObjLifeStateDispatcherImpl == null || (typeHelper = gTypeHelper) == null) {
                return null;
            }
            return (ObjLifeStateDispatcher) typeHelper.transfer(method, -1, (Object) iObjLifeStateDispatcherImpl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public boolean addObserver(IObjLifeStateObserver iObjLifeStateObserver) {
        TypeHelper typeHelper;
        try {
            Method method = ObjLifeStateDispatcher.class.getMethod("addObserver", IObjLifeStateObserver.class);
            IObjLifeStateObserverImpl iObjLifeStateObserverImpl = null;
            if (iObjLifeStateObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iObjLifeStateObserverImpl = (IObjLifeStateObserverImpl) typeHelper.transfer(method, 0, iObjLifeStateObserver);
            }
            IObjLifeStateDispatcherImpl iObjLifeStateDispatcherImpl = this.mControl;
            if (iObjLifeStateDispatcherImpl != null) {
                return iObjLifeStateDispatcherImpl.addObserver(iObjLifeStateObserverImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeObserver(IObjLifeStateObserver iObjLifeStateObserver) {
        TypeHelper typeHelper;
        try {
            Method method = ObjLifeStateDispatcher.class.getMethod("removeObserver", IObjLifeStateObserver.class);
            IObjLifeStateObserverImpl iObjLifeStateObserverImpl = null;
            if (iObjLifeStateObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iObjLifeStateObserverImpl = (IObjLifeStateObserverImpl) typeHelper.transfer(method, 0, iObjLifeStateObserver);
            }
            IObjLifeStateDispatcherImpl iObjLifeStateDispatcherImpl = this.mControl;
            if (iObjLifeStateDispatcherImpl != null) {
                return iObjLifeStateDispatcherImpl.removeObserver(iObjLifeStateObserverImpl);
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

    public synchronized void delete() {
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
