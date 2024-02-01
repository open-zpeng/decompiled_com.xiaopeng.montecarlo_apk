package com.autonavi.gbl.activation;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.activation.impl.IActivationModuleImpl;
import com.autonavi.gbl.activation.model.ActivateReturnParam;
import com.autonavi.gbl.activation.model.ActivationInitParam;
import com.autonavi.gbl.activation.model.ProjectType;
import com.autonavi.gbl.activation.observer.INetActivateObserver;
import com.autonavi.gbl.activation.observer.impl.INetActivateObserverImpl;
import java.lang.reflect.Method;
import java.util.HashSet;
@IntfAuto(target = IActivationModuleImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class ActivationModule {
    private static String PACKAGE = ReflexTool.PN(ActivationModule.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private IActivationModuleImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

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
        TypeHelper typeHelper;
        try {
            Method method = ActivationModule.class.getMethod("getInstance", new Class[0]);
            IActivationModuleImpl iActivationModuleImpl = IActivationModuleImpl.getInstance();
            if (iActivationModuleImpl == null || (typeHelper = gTypeHelper) == null) {
                return null;
            }
            return (ActivationModule) typeHelper.transfer(method, -1, (Object) iActivationModuleImpl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static void destroyInstance() {
        IActivationModuleImpl.destroyInstance();
    }

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
        HashSet hashSet;
        TypeHelper typeHelper;
        try {
            Method method = ActivationModule.class.getMethod("setNetActivateObserver", INetActivateObserver.class);
            TypeHelper typeHelper2 = this.mTypeHelper;
            if (typeHelper2 != null) {
                hashSet = (HashSet) typeHelper2.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iNetActivateObserver);
            INetActivateObserverImpl iNetActivateObserverImpl = null;
            if (iNetActivateObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iNetActivateObserverImpl = (INetActivateObserverImpl) typeHelper.transfer(method, 0, iNetActivateObserver);
            }
            IActivationModuleImpl iActivationModuleImpl = this.mControl;
            if (iActivationModuleImpl != null) {
                iActivationModuleImpl.setNetActivateObserver(iNetActivateObserverImpl);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 0, hashSet);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

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

    protected synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
