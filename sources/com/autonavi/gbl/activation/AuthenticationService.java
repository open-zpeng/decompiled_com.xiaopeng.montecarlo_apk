package com.autonavi.gbl.activation;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.activation.impl.IAuthenticationServiceImpl;
import com.autonavi.gbl.activation.model.AuthenticationFunctionInfo;
import com.autonavi.gbl.activation.model.AuthenticationGoodsInfo;
import com.autonavi.gbl.activation.model.AuthenticationStatus;
import com.autonavi.gbl.activation.observer.IAuthenticationObserver;
import com.autonavi.gbl.activation.observer.impl.IAuthenticationObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IAuthenticationServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class AuthenticationService implements IService {
    private static String PACKAGE = ReflexTool.PN(AuthenticationService.class);
    private IAuthenticationServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected AuthenticationService(long j, boolean z) {
        this((IAuthenticationServiceImpl) ReflexTool.invokeDeclConstructorSafe(IAuthenticationServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(AuthenticationService.class, this, this.mControl);
        }
    }

    public AuthenticationService(IAuthenticationServiceImpl iAuthenticationServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iAuthenticationServiceImpl);
    }

    private void $constructor(IAuthenticationServiceImpl iAuthenticationServiceImpl) {
        if (iAuthenticationServiceImpl != null) {
            this.mControl = iAuthenticationServiceImpl;
            this.mTargetId = String.format("AuthenticationService_%s_%d", String.valueOf(IAuthenticationServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IAuthenticationServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IAuthenticationServiceImpl iAuthenticationServiceImpl = this.mControl;
        if (iAuthenticationServiceImpl != null) {
            return iAuthenticationServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IAuthenticationServiceImpl iAuthenticationServiceImpl = this.mControl;
        if (iAuthenticationServiceImpl != null) {
            return iAuthenticationServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IAuthenticationServiceImpl iAuthenticationServiceImpl = this.mControl;
        if (iAuthenticationServiceImpl != null) {
            iAuthenticationServiceImpl.onCreate();
        }
    }

    public int init() {
        IAuthenticationServiceImpl iAuthenticationServiceImpl = this.mControl;
        if (iAuthenticationServiceImpl != null) {
            return iAuthenticationServiceImpl.init();
        }
        return Integer.MIN_VALUE;
    }

    public void unInit() {
        IAuthenticationServiceImpl iAuthenticationServiceImpl = this.mControl;
        if (iAuthenticationServiceImpl != null) {
            iAuthenticationServiceImpl.unInit();
        }
    }

    public String getVersion() {
        IAuthenticationServiceImpl iAuthenticationServiceImpl = this.mControl;
        if (iAuthenticationServiceImpl != null) {
            return iAuthenticationServiceImpl.getVersion();
        }
        return null;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IAuthenticationServiceImpl iAuthenticationServiceImpl = this.mControl;
        if (iAuthenticationServiceImpl != null) {
            return iAuthenticationServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public void logSwitch(int i) {
        IAuthenticationServiceImpl iAuthenticationServiceImpl = this.mControl;
        if (iAuthenticationServiceImpl != null) {
            iAuthenticationServiceImpl.logSwitch(i);
        }
    }

    public ArrayList<AuthenticationGoodsInfo> getGoodsInfo() {
        IAuthenticationServiceImpl iAuthenticationServiceImpl = this.mControl;
        if (iAuthenticationServiceImpl != null) {
            return iAuthenticationServiceImpl.getGoodsInfo();
        }
        return null;
    }

    public ArrayList<AuthenticationFunctionInfo> getFunctionInfo() {
        IAuthenticationServiceImpl iAuthenticationServiceImpl = this.mControl;
        if (iAuthenticationServiceImpl != null) {
            return iAuthenticationServiceImpl.getFunctionInfo();
        }
        return null;
    }

    public ArrayList<AuthenticationGoodsInfo> getGoodsInfoById(int i) {
        IAuthenticationServiceImpl iAuthenticationServiceImpl = this.mControl;
        if (iAuthenticationServiceImpl != null) {
            return iAuthenticationServiceImpl.getGoodsInfoById(i);
        }
        return null;
    }

    @AuthenticationStatus.AuthenticationStatus1
    public int getPaymentStatus(int i) {
        IAuthenticationServiceImpl iAuthenticationServiceImpl = this.mControl;
        if (iAuthenticationServiceImpl != null) {
            return iAuthenticationServiceImpl.getPaymentStatus(i);
        }
        return Integer.MIN_VALUE;
    }

    public boolean addObserver(IAuthenticationObserver iAuthenticationObserver) {
        TypeHelper typeHelper;
        try {
            Method method = AuthenticationService.class.getMethod("addObserver", IAuthenticationObserver.class);
            IAuthenticationObserverImpl iAuthenticationObserverImpl = null;
            if (iAuthenticationObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iAuthenticationObserverImpl = (IAuthenticationObserverImpl) typeHelper.transfer(method, 0, iAuthenticationObserver);
            }
            IAuthenticationServiceImpl iAuthenticationServiceImpl = this.mControl;
            if (iAuthenticationServiceImpl != null) {
                return iAuthenticationServiceImpl.addObserver(iAuthenticationObserverImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeObserver(IAuthenticationObserver iAuthenticationObserver) {
        TypeHelper typeHelper;
        try {
            Method method = AuthenticationService.class.getMethod("removeObserver", IAuthenticationObserver.class);
            IAuthenticationObserverImpl iAuthenticationObserverImpl = null;
            if (iAuthenticationObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iAuthenticationObserverImpl = (IAuthenticationObserverImpl) typeHelper.transfer(method, 0, iAuthenticationObserver);
            }
            IAuthenticationServiceImpl iAuthenticationServiceImpl = this.mControl;
            if (iAuthenticationServiceImpl != null) {
                boolean removeObserver = iAuthenticationServiceImpl.removeObserver(iAuthenticationObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iAuthenticationObserver);
                }
                return removeObserver;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public int syncRequest() {
        IAuthenticationServiceImpl iAuthenticationServiceImpl = this.mControl;
        if (iAuthenticationServiceImpl != null) {
            return iAuthenticationServiceImpl.syncRequest();
        }
        return 0;
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.activation.observer.IAuthenticationObserver")).iterator();
            while (it.hasNext()) {
                removeObserver((IAuthenticationObserver) it.next());
            }
        }
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
