package com.autonavi.gbl.util;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.impl.LogIntfImpl;
import com.autonavi.gbl.util.model.LogModuleConfig;
import com.autonavi.gbl.util.model.LogModuleType;
import com.autonavi.gbl.util.observer.IRuntimeInfoObserver;
import com.autonavi.gbl.util.observer.impl.RuntimeInfoObserverImpl;
import java.lang.reflect.Method;
@IntfAuto(target = LogIntfImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class LogIntf {
    private static String PACKAGE = ReflexTool.PN(LogIntf.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private LogIntfImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected LogIntf(long j, boolean z) {
        this(new LogIntfImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(LogIntf.class, this, this.mControl);
        }
    }

    public LogIntf() {
        this(new LogIntfImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(LogIntf.class, this, this.mControl);
        }
    }

    public LogIntf(LogIntfImpl logIntfImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(logIntfImpl);
    }

    private void $constructor(LogIntfImpl logIntfImpl) {
        if (logIntfImpl != null) {
            this.mControl = logIntfImpl;
            this.mTargetId = String.format("LogIntf_%s_%d", String.valueOf(LogIntfImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected LogIntfImpl getControl() {
        return this.mControl;
    }

    public static void configModule(int i, LogModuleConfig logModuleConfig) {
        LogIntfImpl.configModule(i, logModuleConfig);
    }

    public static boolean setRuntimeInfoObserver(@LogModuleType.LogModuleType1 int i, IRuntimeInfoObserver iRuntimeInfoObserver) {
        TypeHelper typeHelper;
        try {
            Method method = LogIntf.class.getMethod("setRuntimeInfoObserver", Integer.TYPE, IRuntimeInfoObserver.class);
            RuntimeInfoObserverImpl runtimeInfoObserverImpl = null;
            if (iRuntimeInfoObserver != null && (typeHelper = gTypeHelper) != null) {
                runtimeInfoObserverImpl = (RuntimeInfoObserverImpl) typeHelper.transfer(method, 1, iRuntimeInfoObserver);
            }
            return LogIntfImpl.setRuntimeInfoObserver(i, runtimeInfoObserverImpl);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public static void setModuleSwitch(boolean z) {
        LogIntfImpl.setModuleSwitch(z);
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
