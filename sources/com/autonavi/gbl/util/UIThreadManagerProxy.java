package com.autonavi.gbl.util;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.impl.UITaskThreadInfoImpl;
import com.autonavi.gbl.util.impl.UIThreadManagerProxyImpl;
import java.lang.reflect.Method;
import java.util.HashMap;
@IntfAuto(target = UIThreadManagerProxyImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class UIThreadManagerProxy {
    private static String PACKAGE = ReflexTool.PN(UIThreadManagerProxy.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private UIThreadManagerProxyImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected UIThreadManagerProxy(long j, boolean z) {
        this(new UIThreadManagerProxyImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(UIThreadManagerProxy.class, this, this.mControl);
        }
    }

    public UIThreadManagerProxy() {
        this(new UIThreadManagerProxyImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(UIThreadManagerProxy.class, this, this.mControl);
        }
    }

    public UIThreadManagerProxy(UIThreadManagerProxyImpl uIThreadManagerProxyImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(uIThreadManagerProxyImpl);
    }

    private void $constructor(UIThreadManagerProxyImpl uIThreadManagerProxyImpl) {
        if (uIThreadManagerProxyImpl != null) {
            this.mControl = uIThreadManagerProxyImpl;
            this.mTargetId = String.format("UIThreadManagerProxy_%s_%d", String.valueOf(UIThreadManagerProxyImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected UIThreadManagerProxyImpl getControl() {
        return this.mControl;
    }

    public static UITaskThreadInfo getUIThread(int i) {
        try {
            Method method = UIThreadManagerProxy.class.getMethod("getUIThread", Integer.TYPE);
            UITaskThreadInfoImpl uIThread = UIThreadManagerProxyImpl.getUIThread(i);
            if (uIThread != null) {
                TypeHelper typeHelper = gTypeHelper;
                r0 = typeHelper != null ? (UITaskThreadInfo) typeHelper.transfer(method, -1, (Object) uIThread, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.UIThreadManagerProxy.1
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static HashMap<Integer, UITaskThreadInfo> getAllUIThread() {
        try {
            Method method = UIThreadManagerProxy.class.getMethod("getAllUIThread", new Class[0]);
            HashMap<Integer, UITaskThreadInfoImpl> allUIThread = UIThreadManagerProxyImpl.getAllUIThread();
            if (allUIThread != null) {
                TypeHelper typeHelper = gTypeHelper;
                r0 = typeHelper != null ? (HashMap) typeHelper.transfer(method, -1, (Object) allUIThread, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.UIThreadManagerProxy.2
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static UITaskThreadInfo getUIThreadByMinID() {
        try {
            Method method = UIThreadManagerProxy.class.getMethod("getUIThreadByMinID", new Class[0]);
            UITaskThreadInfoImpl uIThreadByMinID = UIThreadManagerProxyImpl.getUIThreadByMinID();
            if (uIThreadByMinID != null) {
                TypeHelper typeHelper = gTypeHelper;
                r0 = typeHelper != null ? (UITaskThreadInfo) typeHelper.transfer(method, -1, (Object) uIThreadByMinID, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.UIThreadManagerProxy.3
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static boolean setUIThread(int i, UITaskThreadInfo uITaskThreadInfo) {
        try {
            Method method = UIThreadManagerProxy.class.getMethod("setUIThread", Integer.TYPE, UITaskThreadInfo.class);
            if (uITaskThreadInfo != null) {
                TypeHelper typeHelper = gTypeHelper;
                r2 = typeHelper != null ? (UITaskThreadInfoImpl) typeHelper.transfer(method, 1, uITaskThreadInfo) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $info == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.UIThreadManagerProxy.4
                    }));
                }
            }
            return UIThreadManagerProxyImpl.setUIThread(i, r2);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public static boolean removeUIThread(int i) {
        return UIThreadManagerProxyImpl.removeUIThread(i);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.UIThreadManagerProxy.5
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.UIThreadManagerProxy.6
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.UIThreadManagerProxy.7
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
