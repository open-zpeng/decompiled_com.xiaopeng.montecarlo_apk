package com.autonavi.gbl.util;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.impl.BizTaskThreadInfoImpl;
import com.autonavi.gbl.util.observer.IRunTaskThread;
import com.autonavi.gbl.util.observer.impl.IRunTaskThreadImpl;
import java.lang.reflect.Method;
@IntfAuto(target = BizTaskThreadInfoImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class BizTaskThreadInfo {
    private static String PACKAGE = ReflexTool.PN(BizTaskThreadInfo.class);
    private BizTaskThreadInfoImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizTaskThreadInfo(long j, boolean z) {
        this(new BizTaskThreadInfoImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizTaskThreadInfo.class, this, this.mControl);
        }
    }

    public BizTaskThreadInfo() {
        this(new BizTaskThreadInfoImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizTaskThreadInfo.class, this, this.mControl);
        }
    }

    public BizTaskThreadInfo(BizTaskThreadInfoImpl bizTaskThreadInfoImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(bizTaskThreadInfoImpl);
    }

    private void $constructor(BizTaskThreadInfoImpl bizTaskThreadInfoImpl) {
        if (bizTaskThreadInfoImpl != null) {
            this.mControl = bizTaskThreadInfoImpl;
            this.mTargetId = String.format("BizTaskThreadInfo_%s_%d", String.valueOf(BizTaskThreadInfoImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected BizTaskThreadInfoImpl getControl() {
        return this.mControl;
    }

    public void setEnableExecutor(boolean z) {
        BizTaskThreadInfoImpl bizTaskThreadInfoImpl = this.mControl;
        if (bizTaskThreadInfoImpl != null) {
            bizTaskThreadInfoImpl.setEnableExecutor(z);
        }
    }

    public boolean getEnableExecutor() {
        BizTaskThreadInfoImpl bizTaskThreadInfoImpl = this.mControl;
        if (bizTaskThreadInfoImpl != null) {
            return bizTaskThreadInfoImpl.getEnableExecutor();
        }
        return false;
    }

    public void setExecutorId(long j) {
        BizTaskThreadInfoImpl bizTaskThreadInfoImpl = this.mControl;
        if (bizTaskThreadInfoImpl != null) {
            bizTaskThreadInfoImpl.setExecutorId(j);
        }
    }

    public long getExecutorId() {
        BizTaskThreadInfoImpl bizTaskThreadInfoImpl = this.mControl;
        if (bizTaskThreadInfoImpl != null) {
            return bizTaskThreadInfoImpl.getExecutorId();
        }
        return 0L;
    }

    public void setThreadId(long j) {
        BizTaskThreadInfoImpl bizTaskThreadInfoImpl = this.mControl;
        if (bizTaskThreadInfoImpl != null) {
            bizTaskThreadInfoImpl.setThreadId(j);
        }
    }

    public long getThreadId() {
        BizTaskThreadInfoImpl bizTaskThreadInfoImpl = this.mControl;
        if (bizTaskThreadInfoImpl != null) {
            return bizTaskThreadInfoImpl.getThreadId();
        }
        return 0L;
    }

    public void setBizThread(IRunTaskThread iRunTaskThread) {
        try {
            Method method = BizTaskThreadInfo.class.getMethod("setBizThread", IRunTaskThread.class);
            if (iRunTaskThread != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IRunTaskThreadImpl) typeHelper.transfer(method, 0, iRunTaskThread) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $value == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.BizTaskThreadInfo.1
                    }));
                }
            }
            BizTaskThreadInfoImpl bizTaskThreadInfoImpl = this.mControl;
            if (bizTaskThreadInfoImpl != null) {
                bizTaskThreadInfoImpl.setBizThread(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public IRunTaskThread getBizThread() {
        IRunTaskThreadImpl bizThread;
        try {
            Method method = BizTaskThreadInfo.class.getMethod("getBizThread", new Class[0]);
            BizTaskThreadInfoImpl bizTaskThreadInfoImpl = this.mControl;
            if (bizTaskThreadInfoImpl != null && (bizThread = bizTaskThreadInfoImpl.getBizThread()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (IRunTaskThread) typeHelper.transfer(method, -1, (Object) bizThread, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.BizTaskThreadInfo.2
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.BizTaskThreadInfo.3
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.BizTaskThreadInfo.4
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.BizTaskThreadInfo.5
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
