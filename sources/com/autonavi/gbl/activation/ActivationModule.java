package com.autonavi.gbl.activation;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.activation.impl.IActivationModuleImpl;
import com.autonavi.gbl.activation.model.ActivateErrorCode;
import com.autonavi.gbl.activation.model.ActivateReturnParam;
import com.autonavi.gbl.activation.model.ActivationInitParam;
import com.autonavi.gbl.activation.model.ProjectType;
import com.autonavi.gbl.activation.observer.INetActivateObserver;
import com.autonavi.gbl.activation.observer.impl.INetActivateObserverImpl;
import com.autonavi.gbl.util.model.ErrorCode;
import java.lang.reflect.Method;
@IntfAuto(target = IActivationModuleImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class ActivationModule {
    private static String PACKAGE = ReflexTool.PN(ActivationModule.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private IActivationModuleImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected ActivationModule(long j, boolean z) {
        this(new IActivationModuleImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(ActivationModule.class, this, this.mControl);
        }
    }

    public ActivationModule(IActivationModuleImpl iActivationModuleImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iActivationModuleImpl);
    }

    private void $constructor(IActivationModuleImpl iActivationModuleImpl) {
        if (iActivationModuleImpl != null) {
            this.mControl = iActivationModuleImpl;
            this.mTargetId = String.format("ActivationModule_%s_%d", String.valueOf(IActivationModuleImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IActivationModuleImpl getControl() {
        return this.mControl;
    }

    public static ActivationModule getInstance() {
        try {
            Method method = ActivationModule.class.getMethod("getInstance", new Class[0]);
            IActivationModuleImpl iActivationModuleImpl = IActivationModuleImpl.getInstance();
            if (iActivationModuleImpl != null) {
                TypeHelper typeHelper = gTypeHelper;
                r0 = typeHelper != null ? (ActivationModule) typeHelper.transfer(method, -1, (Object) iActivationModuleImpl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.activation.ActivationModule.1
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static void destroyInstance() {
        IActivationModuleImpl.destroyInstance();
    }

    @ErrorCode.ErrorCode1
    public int init(ActivationInitParam activationInitParam) {
        IActivationModuleImpl iActivationModuleImpl = this.mControl;
        if (iActivationModuleImpl != null) {
            return iActivationModuleImpl.init(activationInitParam);
        }
        return Integer.MIN_VALUE;
    }

    public void unInit() {
        IActivationModuleImpl iActivationModuleImpl = this.mControl;
        if (iActivationModuleImpl != null) {
            iActivationModuleImpl.unInit();
        }
    }

    public void setNetActivateObserver(INetActivateObserver iNetActivateObserver) {
        try {
            Method method = ActivationModule.class.getMethod("setNetActivateObserver", INetActivateObserver.class);
            if (iNetActivateObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (INetActivateObserverImpl) typeHelper.transfer(method, 0, iNetActivateObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.activation.ActivationModule.2
                    }));
                }
            }
            IActivationModuleImpl iActivationModuleImpl = this.mControl;
            if (iActivationModuleImpl != null) {
                iActivationModuleImpl.setNetActivateObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @ActivateErrorCode.ActivateErrorCode1
    public int getActivateStatus() {
        IActivationModuleImpl iActivationModuleImpl = this.mControl;
        if (iActivationModuleImpl != null) {
            return iActivationModuleImpl.getActivateStatus();
        }
        return Integer.MIN_VALUE;
    }

    public ActivateReturnParam manualActivate(String str, String str2) {
        IActivationModuleImpl iActivationModuleImpl = this.mControl;
        if (iActivationModuleImpl != null) {
            return iActivationModuleImpl.manualActivate(str, str2);
        }
        return null;
    }

    @ErrorCode.ErrorCode1
    public int netActivate(String str) {
        IActivationModuleImpl iActivationModuleImpl = this.mControl;
        if (iActivationModuleImpl != null) {
            return iActivationModuleImpl.netActivate(str);
        }
        return Integer.MIN_VALUE;
    }

    public ActivateReturnParam backDoorActivate(String str) {
        IActivationModuleImpl iActivationModuleImpl = this.mControl;
        if (iActivationModuleImpl != null) {
            return iActivationModuleImpl.backDoorActivate(str);
        }
        return null;
    }

    public String digitCompletion(String str) {
        IActivationModuleImpl iActivationModuleImpl = this.mControl;
        if (iActivationModuleImpl != null) {
            return iActivationModuleImpl.digitCompletion(str);
        }
        return null;
    }

    public void setProjectType(@ProjectType.ProjectType1 int i) {
        IActivationModuleImpl iActivationModuleImpl = this.mControl;
        if (iActivationModuleImpl != null) {
            iActivationModuleImpl.setProjectType(i);
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.activation.ActivationModule.3
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.activation.ActivationModule.4
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.activation.ActivationModule.5
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
