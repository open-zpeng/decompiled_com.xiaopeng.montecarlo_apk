package com.autonavi.gbl.util;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.impl.UITaskThreadInfoImpl;
import com.autonavi.gbl.util.observer.IUITaskThread;
import com.autonavi.gbl.util.observer.impl.IUITaskThreadImpl;
import java.lang.reflect.Method;
@IntfAuto(target = UITaskThreadInfoImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class UITaskThreadInfo {
    private static String PACKAGE = ReflexTool.PN(UITaskThreadInfo.class);
    private UITaskThreadInfoImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected UITaskThreadInfo(long j, boolean z) {
        this(new UITaskThreadInfoImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(UITaskThreadInfo.class, this, this.mControl);
        }
    }

    public UITaskThreadInfo() {
        this(new UITaskThreadInfoImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(UITaskThreadInfo.class, this, this.mControl);
        }
    }

    public UITaskThreadInfo(UITaskThreadInfoImpl uITaskThreadInfoImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(uITaskThreadInfoImpl);
    }

    private void $constructor(UITaskThreadInfoImpl uITaskThreadInfoImpl) {
        if (uITaskThreadInfoImpl != null) {
            this.mControl = uITaskThreadInfoImpl;
            this.mTargetId = String.format("UITaskThreadInfo_%s_%d", String.valueOf(UITaskThreadInfoImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected UITaskThreadInfoImpl getControl() {
        return this.mControl;
    }

    public void setEnableSetUIThread(boolean z) {
        UITaskThreadInfoImpl uITaskThreadInfoImpl = this.mControl;
        if (uITaskThreadInfoImpl != null) {
            uITaskThreadInfoImpl.setEnableSetUIThread(z);
        }
    }

    public boolean getEnableSetUIThread() {
        UITaskThreadInfoImpl uITaskThreadInfoImpl = this.mControl;
        if (uITaskThreadInfoImpl != null) {
            return uITaskThreadInfoImpl.getEnableSetUIThread();
        }
        return false;
    }

    public void setEnableExecutor(boolean z) {
        UITaskThreadInfoImpl uITaskThreadInfoImpl = this.mControl;
        if (uITaskThreadInfoImpl != null) {
            uITaskThreadInfoImpl.setEnableExecutor(z);
        }
    }

    public boolean getEnableExecutor() {
        UITaskThreadInfoImpl uITaskThreadInfoImpl = this.mControl;
        if (uITaskThreadInfoImpl != null) {
            return uITaskThreadInfoImpl.getEnableExecutor();
        }
        return false;
    }

    public void setExecutorId(long j) {
        UITaskThreadInfoImpl uITaskThreadInfoImpl = this.mControl;
        if (uITaskThreadInfoImpl != null) {
            uITaskThreadInfoImpl.setExecutorId(j);
        }
    }

    public long getExecutorId() {
        UITaskThreadInfoImpl uITaskThreadInfoImpl = this.mControl;
        if (uITaskThreadInfoImpl != null) {
            return uITaskThreadInfoImpl.getExecutorId();
        }
        return 0L;
    }

    public void setThreadId(long j) {
        UITaskThreadInfoImpl uITaskThreadInfoImpl = this.mControl;
        if (uITaskThreadInfoImpl != null) {
            uITaskThreadInfoImpl.setThreadId(j);
        }
    }

    public long getThreadId() {
        UITaskThreadInfoImpl uITaskThreadInfoImpl = this.mControl;
        if (uITaskThreadInfoImpl != null) {
            return uITaskThreadInfoImpl.getThreadId();
        }
        return 0L;
    }

    public void setUiThread(IUITaskThread iUITaskThread) {
        TypeHelper typeHelper;
        try {
            Method method = UITaskThreadInfo.class.getMethod("setUiThread", IUITaskThread.class);
            IUITaskThreadImpl iUITaskThreadImpl = null;
            if (iUITaskThread != null && (typeHelper = this.mTypeHelper) != null) {
                iUITaskThreadImpl = (IUITaskThreadImpl) typeHelper.transfer(method, 0, iUITaskThread);
            }
            UITaskThreadInfoImpl uITaskThreadInfoImpl = this.mControl;
            if (uITaskThreadInfoImpl != null) {
                uITaskThreadInfoImpl.setUiThread(iUITaskThreadImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public IUITaskThread getUiThread() {
        IUITaskThreadImpl uiThread;
        TypeHelper typeHelper;
        try {
            Method method = UITaskThreadInfo.class.getMethod("getUiThread", new Class[0]);
            UITaskThreadInfoImpl uITaskThreadInfoImpl = this.mControl;
            if (uITaskThreadInfoImpl == null || (uiThread = uITaskThreadInfoImpl.getUiThread()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (IUITaskThread) typeHelper.transfer(method, -1, (Object) uiThread, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
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
