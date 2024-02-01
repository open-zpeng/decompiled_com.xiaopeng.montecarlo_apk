package com.autonavi.gbl.user.forcast;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.user.forcast.impl.IForcastServiceImpl;
import com.autonavi.gbl.user.forcast.model.ArrivedType;
import com.autonavi.gbl.user.forcast.model.EnergyCollect;
import com.autonavi.gbl.user.forcast.model.EnergyPoint;
import com.autonavi.gbl.user.forcast.model.ForcastArrivedParam;
import com.autonavi.gbl.user.forcast.model.ForcastInitParam;
import com.autonavi.gbl.user.forcast.model.OftenArrivedItem;
import com.autonavi.gbl.user.forcast.model.RoadType;
import com.autonavi.gbl.user.forcast.observer.IForcastServiceObserver;
import com.autonavi.gbl.user.forcast.observer.impl.IForcastServiceObserverImpl;
import com.autonavi.gbl.user.model.UserLoginInfo;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IForcastServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class ForcastService implements IService {
    private static String PACKAGE = ReflexTool.PN(ForcastService.class);
    private IForcastServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected ForcastService(long j, boolean z) {
        this((IForcastServiceImpl) ReflexTool.invokeDeclConstructorSafe(IForcastServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(ForcastService.class, this, this.mControl);
        }
    }

    public ForcastService(IForcastServiceImpl iForcastServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iForcastServiceImpl);
    }

    private void $constructor(IForcastServiceImpl iForcastServiceImpl) {
        if (iForcastServiceImpl != null) {
            this.mControl = iForcastServiceImpl;
            this.mTargetId = String.format("ForcastService_%s_%d", String.valueOf(IForcastServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IForcastServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IForcastServiceImpl iForcastServiceImpl = this.mControl;
        if (iForcastServiceImpl != null) {
            return iForcastServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IForcastServiceImpl iForcastServiceImpl = this.mControl;
        if (iForcastServiceImpl != null) {
            return iForcastServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IForcastServiceImpl iForcastServiceImpl = this.mControl;
        if (iForcastServiceImpl != null) {
            iForcastServiceImpl.onCreate();
        }
    }

    public int setLoginInfo(UserLoginInfo userLoginInfo) {
        IForcastServiceImpl iForcastServiceImpl = this.mControl;
        if (iForcastServiceImpl != null) {
            return iForcastServiceImpl.setLoginInfo(userLoginInfo);
        }
        return Integer.MIN_VALUE;
    }

    public int init(ForcastInitParam forcastInitParam) {
        IForcastServiceImpl iForcastServiceImpl = this.mControl;
        if (iForcastServiceImpl != null) {
            return iForcastServiceImpl.init(forcastInitParam);
        }
        return Integer.MIN_VALUE;
    }

    public void unInit() {
        IForcastServiceImpl iForcastServiceImpl = this.mControl;
        if (iForcastServiceImpl != null) {
            iForcastServiceImpl.unInit();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IForcastServiceImpl iForcastServiceImpl = this.mControl;
        if (iForcastServiceImpl != null) {
            return iForcastServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public String getVersion() {
        IForcastServiceImpl iForcastServiceImpl = this.mControl;
        if (iForcastServiceImpl != null) {
            return iForcastServiceImpl.getVersion();
        }
        return null;
    }

    public int addObserver(IForcastServiceObserver iForcastServiceObserver) {
        TypeHelper typeHelper;
        try {
            Method method = ForcastService.class.getMethod("addObserver", IForcastServiceObserver.class);
            IForcastServiceObserverImpl iForcastServiceObserverImpl = null;
            if (iForcastServiceObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iForcastServiceObserverImpl = (IForcastServiceObserverImpl) typeHelper.transfer(method, 0, iForcastServiceObserver);
            }
            IForcastServiceImpl iForcastServiceImpl = this.mControl;
            if (iForcastServiceImpl != null) {
                return iForcastServiceImpl.addObserver(iForcastServiceObserverImpl);
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    public void removeObserver(IForcastServiceObserver iForcastServiceObserver) {
        TypeHelper typeHelper;
        try {
            Method method = ForcastService.class.getMethod("removeObserver", IForcastServiceObserver.class);
            IForcastServiceObserverImpl iForcastServiceObserverImpl = null;
            if (iForcastServiceObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iForcastServiceObserverImpl = (IForcastServiceObserverImpl) typeHelper.transfer(method, 0, iForcastServiceObserver);
            }
            IForcastServiceImpl iForcastServiceImpl = this.mControl;
            if (iForcastServiceImpl != null) {
                iForcastServiceImpl.removeObserver(iForcastServiceObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iForcastServiceObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public int getOnlineForcastArrivedData(ForcastArrivedParam forcastArrivedParam) {
        IForcastServiceImpl iForcastServiceImpl = this.mControl;
        if (iForcastServiceImpl != null) {
            return iForcastServiceImpl.getOnlineForcastArrivedData(forcastArrivedParam);
        }
        return Integer.MIN_VALUE;
    }

    public ArrayList<OftenArrivedItem> getArrivedDataList(@ArrivedType.ArrivedType1 int i) {
        IForcastServiceImpl iForcastServiceImpl = this.mControl;
        if (iForcastServiceImpl != null) {
            return iForcastServiceImpl.getArrivedDataList(i);
        }
        return null;
    }

    public int addLocalArrivedData(@ArrivedType.ArrivedType1 int i, OftenArrivedItem oftenArrivedItem) {
        IForcastServiceImpl iForcastServiceImpl = this.mControl;
        if (iForcastServiceImpl != null) {
            return iForcastServiceImpl.addLocalArrivedData(i, oftenArrivedItem);
        }
        return Integer.MIN_VALUE;
    }

    public int delLocalArrivedData(@ArrivedType.ArrivedType1 int i, String str) {
        IForcastServiceImpl iForcastServiceImpl = this.mControl;
        if (iForcastServiceImpl != null) {
            return iForcastServiceImpl.delLocalArrivedData(i, str);
        }
        return Integer.MIN_VALUE;
    }

    public int topArrivedData(String str) {
        IForcastServiceImpl iForcastServiceImpl = this.mControl;
        if (iForcastServiceImpl != null) {
            return iForcastServiceImpl.topArrivedData(str);
        }
        return Integer.MIN_VALUE;
    }

    public int addEnergyPoint(@RoadType.RoadType1 int i, EnergyPoint energyPoint) {
        IForcastServiceImpl iForcastServiceImpl = this.mControl;
        if (iForcastServiceImpl != null) {
            return iForcastServiceImpl.addEnergyPoint(i, energyPoint);
        }
        return Integer.MIN_VALUE;
    }

    public EnergyCollect getEnergyCollection(@RoadType.RoadType1 int i, int i2) {
        IForcastServiceImpl iForcastServiceImpl = this.mControl;
        if (iForcastServiceImpl != null) {
            return iForcastServiceImpl.getEnergyCollection(i, i2);
        }
        return null;
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
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.user.forcast.observer.IForcastServiceObserver")).iterator();
            while (it.hasNext()) {
                removeObserver((IForcastServiceObserver) it.next());
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
