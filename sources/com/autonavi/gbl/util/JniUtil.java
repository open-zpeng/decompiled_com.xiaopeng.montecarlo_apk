package com.autonavi.gbl.util;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.impl.IJniUtilImpl;
import com.autonavi.gbl.util.observer.IJniExceptionObserver;
import com.autonavi.gbl.util.observer.impl.IJniExceptionObserverImpl;
import java.lang.reflect.Method;
@IntfAuto(target = IJniUtilImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class JniUtil {
    private static String PACKAGE = ReflexTool.PN(JniUtil.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private IJniUtilImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected JniUtil(long j, boolean z) {
        this(new IJniUtilImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(JniUtil.class, this, this.mControl);
        }
    }

    public JniUtil(IJniUtilImpl iJniUtilImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iJniUtilImpl);
    }

    private void $constructor(IJniUtilImpl iJniUtilImpl) {
        if (iJniUtilImpl != null) {
            this.mControl = iJniUtilImpl;
            this.mTargetId = String.format("JniUtil_%s_%d", String.valueOf(IJniUtilImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IJniUtilImpl getControl() {
        return this.mControl;
    }

    public static JniUtil getInstance() {
        TypeHelper typeHelper;
        try {
            Method method = JniUtil.class.getMethod("getInstance", new Class[0]);
            IJniUtilImpl iJniUtilImpl = IJniUtilImpl.getInstance();
            if (iJniUtilImpl == null || (typeHelper = gTypeHelper) == null) {
                return null;
            }
            return (JniUtil) typeHelper.transfer(method, -1, (Object) iJniUtilImpl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public boolean addObserver(IJniExceptionObserver iJniExceptionObserver) {
        TypeHelper typeHelper;
        try {
            Method method = JniUtil.class.getMethod("addObserver", IJniExceptionObserver.class);
            IJniExceptionObserverImpl iJniExceptionObserverImpl = null;
            if (iJniExceptionObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iJniExceptionObserverImpl = (IJniExceptionObserverImpl) typeHelper.transfer(method, 0, iJniExceptionObserver);
            }
            IJniUtilImpl iJniUtilImpl = this.mControl;
            if (iJniUtilImpl != null) {
                return iJniUtilImpl.addObserver(iJniExceptionObserverImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeObserver(IJniExceptionObserver iJniExceptionObserver) {
        TypeHelper typeHelper;
        try {
            Method method = JniUtil.class.getMethod("removeObserver", IJniExceptionObserver.class);
            IJniExceptionObserverImpl iJniExceptionObserverImpl = null;
            if (iJniExceptionObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iJniExceptionObserverImpl = (IJniExceptionObserverImpl) typeHelper.transfer(method, 0, iJniExceptionObserver);
            }
            IJniUtilImpl iJniUtilImpl = this.mControl;
            if (iJniUtilImpl != null) {
                return iJniUtilImpl.removeObserver(iJniExceptionObserverImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
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
