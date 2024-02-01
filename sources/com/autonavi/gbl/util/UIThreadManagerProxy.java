package com.autonavi.gbl.util;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
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

    protected void clean() {
    }

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

    public static boolean setUIThread(int i, UITaskThreadInfo uITaskThreadInfo) {
        TypeHelper typeHelper;
        try {
            Method method = UIThreadManagerProxy.class.getMethod("setUIThread", Integer.TYPE, UITaskThreadInfo.class);
            UITaskThreadInfoImpl uITaskThreadInfoImpl = null;
            if (uITaskThreadInfo != null && (typeHelper = gTypeHelper) != null) {
                uITaskThreadInfoImpl = (UITaskThreadInfoImpl) typeHelper.transfer(method, 1, uITaskThreadInfo);
            }
            return UIThreadManagerProxyImpl.setUIThread(i, uITaskThreadInfoImpl);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public static boolean removeUIThread(int i) {
        return UIThreadManagerProxyImpl.removeUIThread(i);
    }

    public static UITaskThreadInfo getUIThread(int i) {
        TypeHelper typeHelper;
        try {
            Method method = UIThreadManagerProxy.class.getMethod("getUIThread", Integer.TYPE);
            UITaskThreadInfoImpl uIThread = UIThreadManagerProxyImpl.getUIThread(i);
            if (uIThread == null || (typeHelper = gTypeHelper) == null) {
                return null;
            }
            return (UITaskThreadInfo) typeHelper.transfer(method, -1, (Object) uIThread, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static HashMap<Integer, UITaskThreadInfo> getAllUIThread() {
        TypeHelper typeHelper;
        try {
            Method method = UIThreadManagerProxy.class.getMethod("getAllUIThread", new Class[0]);
            HashMap<Integer, UITaskThreadInfoImpl> allUIThread = UIThreadManagerProxyImpl.getAllUIThread();
            if (allUIThread == null || (typeHelper = gTypeHelper) == null) {
                return null;
            }
            return (HashMap) typeHelper.transfer(method, -1, (Object) allUIThread, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static UITaskThreadInfo getUIThreadByMinID() {
        TypeHelper typeHelper;
        try {
            Method method = UIThreadManagerProxy.class.getMethod("getUIThreadByMinID", new Class[0]);
            UITaskThreadInfoImpl uIThreadByMinID = UIThreadManagerProxyImpl.getUIThreadByMinID();
            if (uIThreadByMinID == null || (typeHelper = gTypeHelper) == null) {
                return null;
            }
            return (UITaskThreadInfo) typeHelper.transfer(method, -1, (Object) uIThreadByMinID, true);
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
