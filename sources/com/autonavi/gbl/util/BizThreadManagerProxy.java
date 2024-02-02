package com.autonavi.gbl.util;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.impl.BizTaskThreadInfoImpl;
import com.autonavi.gbl.util.impl.BizThreadManagerProxyImpl;
import java.lang.reflect.Method;
import java.util.HashMap;
@IntfAuto(target = BizThreadManagerProxyImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class BizThreadManagerProxy {
    private static String PACKAGE = ReflexTool.PN(BizThreadManagerProxy.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private BizThreadManagerProxyImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizThreadManagerProxy(long j, boolean z) {
        this(new BizThreadManagerProxyImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizThreadManagerProxy.class, this, this.mControl);
        }
    }

    public BizThreadManagerProxy() {
        this(new BizThreadManagerProxyImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizThreadManagerProxy.class, this, this.mControl);
        }
    }

    public BizThreadManagerProxy(BizThreadManagerProxyImpl bizThreadManagerProxyImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(bizThreadManagerProxyImpl);
    }

    private void $constructor(BizThreadManagerProxyImpl bizThreadManagerProxyImpl) {
        if (bizThreadManagerProxyImpl != null) {
            this.mControl = bizThreadManagerProxyImpl;
            this.mTargetId = String.format("BizThreadManagerProxy_%s_%d", String.valueOf(BizThreadManagerProxyImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected BizThreadManagerProxyImpl getControl() {
        return this.mControl;
    }

    public static BizTaskThreadInfo getBizThread(int i) {
        try {
            Method method = BizThreadManagerProxy.class.getMethod("getBizThread", Integer.TYPE);
            BizTaskThreadInfoImpl bizThread = BizThreadManagerProxyImpl.getBizThread(i);
            if (bizThread != null) {
                TypeHelper typeHelper = gTypeHelper;
                r0 = typeHelper != null ? (BizTaskThreadInfo) typeHelper.transfer(method, -1, (Object) bizThread, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.BizThreadManagerProxy.1
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static HashMap<Integer, BizTaskThreadInfo> getAllBizThread() {
        try {
            Method method = BizThreadManagerProxy.class.getMethod("getAllBizThread", new Class[0]);
            HashMap<Integer, BizTaskThreadInfoImpl> allBizThread = BizThreadManagerProxyImpl.getAllBizThread();
            if (allBizThread != null) {
                TypeHelper typeHelper = gTypeHelper;
                r0 = typeHelper != null ? (HashMap) typeHelper.transfer(method, -1, (Object) allBizThread, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.BizThreadManagerProxy.2
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static BizTaskThreadInfo getBizThreadByMinID() {
        try {
            Method method = BizThreadManagerProxy.class.getMethod("getBizThreadByMinID", new Class[0]);
            BizTaskThreadInfoImpl bizThreadByMinID = BizThreadManagerProxyImpl.getBizThreadByMinID();
            if (bizThreadByMinID != null) {
                TypeHelper typeHelper = gTypeHelper;
                r0 = typeHelper != null ? (BizTaskThreadInfo) typeHelper.transfer(method, -1, (Object) bizThreadByMinID, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.BizThreadManagerProxy.3
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static boolean setBizThread(int i, BizTaskThreadInfo bizTaskThreadInfo) {
        try {
            Method method = BizThreadManagerProxy.class.getMethod("setBizThread", Integer.TYPE, BizTaskThreadInfo.class);
            if (bizTaskThreadInfo != null) {
                TypeHelper typeHelper = gTypeHelper;
                r2 = typeHelper != null ? (BizTaskThreadInfoImpl) typeHelper.transfer(method, 1, bizTaskThreadInfo) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $info == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.BizThreadManagerProxy.4
                    }));
                }
            }
            return BizThreadManagerProxyImpl.setBizThread(i, r2);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public static boolean removeBizThread(int i) {
        return BizThreadManagerProxyImpl.removeBizThread(i);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.BizThreadManagerProxy.5
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.BizThreadManagerProxy.6
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.BizThreadManagerProxy.7
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
