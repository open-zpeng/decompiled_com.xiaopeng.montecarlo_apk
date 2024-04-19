package com.autonavi.gbl.ehp;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.ehp.impl.IEHPServiceImpl;
import com.autonavi.gbl.ehp.model.EHPCar2XEvent;
import com.autonavi.gbl.ehp.model.EHPConfigType;
import com.autonavi.gbl.ehp.model.EHPInitParam;
import com.autonavi.gbl.ehp.observer.IEHPHdDataVersionObserver;
import com.autonavi.gbl.ehp.observer.IEHPOutputObserver;
import com.autonavi.gbl.ehp.observer.IGEhpAdasDataCallback;
import com.autonavi.gbl.ehp.observer.impl.IEHPHdDataVersionObserverImpl;
import com.autonavi.gbl.ehp.observer.impl.IEHPOutputObserverImpl;
import com.autonavi.gbl.ehp.observer.impl.IGEhpAdasDataCallbackImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.NetworkStatus;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IEHPServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class EHPService implements IService {
    private static String PACKAGE = ReflexTool.PN(EHPService.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private IEHPServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected EHPService(long j, boolean z) {
        this((IEHPServiceImpl) ReflexTool.invokeDeclConstructorSafe(IEHPServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(EHPService.class, this, this.mControl);
        }
    }

    public EHPService(IEHPServiceImpl iEHPServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iEHPServiceImpl);
    }

    private void $constructor(IEHPServiceImpl iEHPServiceImpl) {
        if (iEHPServiceImpl != null) {
            this.mControl = iEHPServiceImpl;
            this.mTargetId = String.format("EHPService_%s_%d", String.valueOf(IEHPServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IEHPServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IEHPServiceImpl iEHPServiceImpl = this.mControl;
        if (iEHPServiceImpl != null) {
            return iEHPServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IEHPServiceImpl iEHPServiceImpl = this.mControl;
        if (iEHPServiceImpl != null) {
            return iEHPServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IEHPServiceImpl iEHPServiceImpl = this.mControl;
        if (iEHPServiceImpl != null) {
            iEHPServiceImpl.onCreate();
        }
    }

    public static String getEngineVersion() {
        return IEHPServiceImpl.getEngineVersion();
    }

    public String getVersion() {
        IEHPServiceImpl iEHPServiceImpl = this.mControl;
        if (iEHPServiceImpl != null) {
            return iEHPServiceImpl.getVersion();
        }
        return null;
    }

    public boolean init(EHPInitParam eHPInitParam) {
        IEHPServiceImpl iEHPServiceImpl = this.mControl;
        if (iEHPServiceImpl != null) {
            return iEHPServiceImpl.init(eHPInitParam);
        }
        return false;
    }

    public void unInit() {
        IEHPServiceImpl iEHPServiceImpl = this.mControl;
        if (iEHPServiceImpl != null) {
            iEHPServiceImpl.unInit();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IEHPServiceImpl iEHPServiceImpl = this.mControl;
        if (iEHPServiceImpl != null) {
            return iEHPServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public void logSwitch(int i) {
        IEHPServiceImpl iEHPServiceImpl = this.mControl;
        if (iEHPServiceImpl != null) {
            iEHPServiceImpl.logSwitch(i);
        }
    }

    public void updateNetworkStatus(@NetworkStatus.NetworkStatus1 int i) {
        IEHPServiceImpl iEHPServiceImpl = this.mControl;
        if (iEHPServiceImpl != null) {
            iEHPServiceImpl.updateNetworkStatus(i);
        }
    }

    public void resetPredictiveTree() {
        IEHPServiceImpl iEHPServiceImpl = this.mControl;
        if (iEHPServiceImpl != null) {
            iEHPServiceImpl.resetPredictiveTree();
        }
    }

    public boolean addOutputObserver(IEHPOutputObserver iEHPOutputObserver) {
        try {
            Method method = EHPService.class.getMethod("addOutputObserver", IEHPOutputObserver.class);
            if (iEHPOutputObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IEHPOutputObserverImpl) typeHelper.transfer(method, 0, iEHPOutputObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $output == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.ehp.EHPService.1
                    }));
                    return false;
                }
            }
            IEHPServiceImpl iEHPServiceImpl = this.mControl;
            if (iEHPServiceImpl != null) {
                return iEHPServiceImpl.addOutputObserver(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeOutputObserver(IEHPOutputObserver iEHPOutputObserver) {
        try {
            Method method = EHPService.class.getMethod("removeOutputObserver", IEHPOutputObserver.class);
            if (iEHPOutputObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IEHPOutputObserverImpl) typeHelper.transfer(method, 0, iEHPOutputObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $output == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.ehp.EHPService.2
                    }));
                    return false;
                }
            }
            IEHPServiceImpl iEHPServiceImpl = this.mControl;
            if (iEHPServiceImpl != null) {
                boolean removeOutputObserver = iEHPServiceImpl.removeOutputObserver(r2);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iEHPOutputObserver);
                }
                return removeOutputObserver;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean clearOutputObserver() {
        IEHPServiceImpl iEHPServiceImpl = this.mControl;
        if (iEHPServiceImpl != null) {
            return iEHPServiceImpl.clearOutputObserver();
        }
        return false;
    }

    public boolean addHdDataVersionObserver(IEHPHdDataVersionObserver iEHPHdDataVersionObserver) {
        try {
            Method method = EHPService.class.getMethod("addHdDataVersionObserver", IEHPHdDataVersionObserver.class);
            if (iEHPHdDataVersionObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IEHPHdDataVersionObserverImpl) typeHelper.transfer(method, 0, iEHPHdDataVersionObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.ehp.EHPService.3
                    }));
                    return false;
                }
            }
            IEHPServiceImpl iEHPServiceImpl = this.mControl;
            if (iEHPServiceImpl != null) {
                return iEHPServiceImpl.addHdDataVersionObserver(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeHdDataVersionObserver(IEHPHdDataVersionObserver iEHPHdDataVersionObserver) {
        try {
            Method method = EHPService.class.getMethod("removeHdDataVersionObserver", IEHPHdDataVersionObserver.class);
            if (iEHPHdDataVersionObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IEHPHdDataVersionObserverImpl) typeHelper.transfer(method, 0, iEHPHdDataVersionObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.ehp.EHPService.4
                    }));
                    return false;
                }
            }
            IEHPServiceImpl iEHPServiceImpl = this.mControl;
            if (iEHPServiceImpl != null) {
                boolean removeHdDataVersionObserver = iEHPServiceImpl.removeHdDataVersionObserver(r2);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iEHPHdDataVersionObserver);
                }
                return removeHdDataVersionObserver;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public void inputMsg(String str) {
        IEHPServiceImpl iEHPServiceImpl = this.mControl;
        if (iEHPServiceImpl != null) {
            iEHPServiceImpl.inputMsg(str);
        }
    }

    public boolean setAutoUpdateRoute(boolean z) {
        IEHPServiceImpl iEHPServiceImpl = this.mControl;
        if (iEHPServiceImpl != null) {
            return iEHPServiceImpl.setAutoUpdateRoute(z);
        }
        return false;
    }

    public boolean isAutoUpdateRoute() {
        IEHPServiceImpl iEHPServiceImpl = this.mControl;
        if (iEHPServiceImpl != null) {
            return iEHPServiceImpl.isAutoUpdateRoute();
        }
        return false;
    }

    public long sendAdasDataRequest(IGEhpAdasDataCallback iGEhpAdasDataCallback) {
        try {
            Method method = EHPService.class.getMethod("sendAdasDataRequest", IGEhpAdasDataCallback.class);
            if (iGEhpAdasDataCallback != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (IGEhpAdasDataCallbackImpl) typeHelper.transfer(method, 0, iGEhpAdasDataCallback) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAdasDataCallback == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.ehp.EHPService.5
                    }));
                    return 0L;
                }
            }
            IEHPServiceImpl iEHPServiceImpl = this.mControl;
            if (iEHPServiceImpl != null) {
                return iEHPServiceImpl.sendAdasDataRequest(r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public boolean abortAdasDataRequest(long j) {
        IEHPServiceImpl iEHPServiceImpl = this.mControl;
        if (iEHPServiceImpl != null) {
            return iEHPServiceImpl.abortAdasDataRequest(j);
        }
        return false;
    }

    public boolean abortAdasDataAllRequest() {
        IEHPServiceImpl iEHPServiceImpl = this.mControl;
        if (iEHPServiceImpl != null) {
            return iEHPServiceImpl.abortAdasDataAllRequest();
        }
        return false;
    }

    public boolean updateCar2XEvents(ArrayList<EHPCar2XEvent> arrayList) {
        IEHPServiceImpl iEHPServiceImpl = this.mControl;
        if (iEHPServiceImpl != null) {
            return iEHPServiceImpl.updateCar2XEvents(arrayList);
        }
        return false;
    }

    public boolean setConfigValue(@EHPConfigType.EHPConfigType1 int i, int i2) {
        IEHPServiceImpl iEHPServiceImpl = this.mControl;
        if (iEHPServiceImpl != null) {
            return iEHPServiceImpl.setConfigValue(i, i2);
        }
        return false;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.ehp.EHPService.6
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.ehp.EHPService.7
        }));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.ehp.observer.IEHPOutputObserver")).iterator();
            while (it.hasNext()) {
                removeOutputObserver((IEHPOutputObserver) it.next());
            }
        }
        TypeHelper typeHelper2 = this.mTypeHelper;
        if (typeHelper2 != null) {
            Iterator it2 = ((HashSet) typeHelper2.getBindSet("com.autonavi.gbl.ehp.observer.IEHPHdDataVersionObserver")).iterator();
            while (it2.hasNext()) {
                removeHdDataVersionObserver((IEHPHdDataVersionObserver) it2.next());
            }
        }
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.ehp.EHPService.8
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
