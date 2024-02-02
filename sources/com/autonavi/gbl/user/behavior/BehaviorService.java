package com.autonavi.gbl.user.behavior;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.user.behavior.impl.IBehaviorServiceImpl;
import com.autonavi.gbl.user.behavior.model.BehaviorServiceParam;
import com.autonavi.gbl.user.behavior.model.ConfigKey;
import com.autonavi.gbl.user.behavior.model.ConfigValue;
import com.autonavi.gbl.user.behavior.model.FavoriteBaseItem;
import com.autonavi.gbl.user.behavior.model.FavoriteItem;
import com.autonavi.gbl.user.behavior.model.FavoriteType;
import com.autonavi.gbl.user.behavior.model.SimpleFavoriteItem;
import com.autonavi.gbl.user.behavior.model.VehicleInfo;
import com.autonavi.gbl.user.behavior.observer.IBehaviorServiceObserver;
import com.autonavi.gbl.user.behavior.observer.impl.IBehaviorServiceObserverImpl;
import com.autonavi.gbl.user.forcast.model.OftenArrivedItem;
import com.autonavi.gbl.user.model.UserLoginInfo;
import com.autonavi.gbl.user.syncsdk.model.SyncMode;
import com.autonavi.gbl.util.model.ErrorCode;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IBehaviorServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class BehaviorService implements IService {
    private static String PACKAGE = ReflexTool.PN(BehaviorService.class);
    private IBehaviorServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BehaviorService(long j, boolean z) {
        this((IBehaviorServiceImpl) ReflexTool.invokeDeclConstructorSafe(IBehaviorServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BehaviorService.class, this, this.mControl);
        }
    }

    public BehaviorService(IBehaviorServiceImpl iBehaviorServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBehaviorServiceImpl);
    }

    private void $constructor(IBehaviorServiceImpl iBehaviorServiceImpl) {
        if (iBehaviorServiceImpl != null) {
            this.mControl = iBehaviorServiceImpl;
            this.mTargetId = String.format("BehaviorService_%s_%d", String.valueOf(IBehaviorServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IBehaviorServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            iBehaviorServiceImpl.onCreate();
        }
    }

    public ConfigValue getConfig(@ConfigKey.ConfigKey1 int i) {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.getConfig(i);
        }
        return null;
    }

    public String addFavorite(FavoriteItem favoriteItem, @SyncMode.SyncMode1 int i) {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.addFavorite(favoriteItem, i);
        }
        return null;
    }

    public String updateFavorite(FavoriteItem favoriteItem, @SyncMode.SyncMode1 int i) {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.updateFavorite(favoriteItem, i);
        }
        return null;
    }

    public String delFavorite(FavoriteBaseItem favoriteBaseItem, @SyncMode.SyncMode1 int i) {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.delFavorite(favoriteBaseItem, i);
        }
        return null;
    }

    public String topFavorite(FavoriteBaseItem favoriteBaseItem, boolean z, @SyncMode.SyncMode1 int i) {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.topFavorite(favoriteBaseItem, z, i);
        }
        return null;
    }

    public String isFavorited(FavoriteBaseItem favoriteBaseItem) {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.isFavorited(favoriteBaseItem);
        }
        return null;
    }

    public FavoriteItem getFavorite(FavoriteBaseItem favoriteBaseItem) {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.getFavorite(favoriteBaseItem);
        }
        return null;
    }

    public ArrayList<SimpleFavoriteItem> getSimpleFavoriteList(@FavoriteType.FavoriteType1 int i, boolean z) {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.getSimpleFavoriteList(i, z);
        }
        return null;
    }

    public int[] getSimpleFavoriteIds() {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.getSimpleFavoriteIds();
        }
        return null;
    }

    public SimpleFavoriteItem getSimpleFavoriteById(int i) {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.getSimpleFavoriteById(i);
        }
        return null;
    }

    public String getItemId(int i, int i2, String str) {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.getItemId(i, i2, str);
        }
        return null;
    }

    public VehicleInfo getCar(String str) {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.getCar(str);
        }
        return null;
    }

    public ArrayList<OftenArrivedItem> getFrequentItemList() {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.getFrequentItemList();
        }
        return null;
    }

    @ErrorCode.ErrorCode1
    public int init(BehaviorServiceParam behaviorServiceParam) {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.init(behaviorServiceParam);
        }
        return Integer.MIN_VALUE;
    }

    public void unInit() {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            iBehaviorServiceImpl.unInit();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public String getVersion() {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.getVersion();
        }
        return null;
    }

    public void logSwitch(int i) {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            iBehaviorServiceImpl.logSwitch(i);
        }
    }

    @ErrorCode.ErrorCode1
    public int addObserver(IBehaviorServiceObserver iBehaviorServiceObserver) {
        try {
            Method method = BehaviorService.class.getMethod("addObserver", IBehaviorServiceObserver.class);
            if (iBehaviorServiceObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IBehaviorServiceObserverImpl) typeHelper.transfer(method, 0, iBehaviorServiceObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.behavior.BehaviorService.1
                    }));
                    return Integer.MIN_VALUE;
                }
            }
            IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
            if (iBehaviorServiceImpl != null) {
                return iBehaviorServiceImpl.addObserver(r2);
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    public void removeObserver(IBehaviorServiceObserver iBehaviorServiceObserver) {
        try {
            Method method = BehaviorService.class.getMethod("removeObserver", IBehaviorServiceObserver.class);
            if (iBehaviorServiceObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IBehaviorServiceObserverImpl) typeHelper.transfer(method, 0, iBehaviorServiceObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.behavior.BehaviorService.2
                    }));
                }
            }
            IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
            if (iBehaviorServiceImpl != null) {
                iBehaviorServiceImpl.removeObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iBehaviorServiceObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @ErrorCode.ErrorCode1
    public int setLoginInfo(UserLoginInfo userLoginInfo) {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.setLoginInfo(userLoginInfo);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int setConfig(@ConfigKey.ConfigKey1 int i, ConfigValue configValue, @SyncMode.SyncMode1 int i2) {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.setConfig(i, configValue, i2);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int clearFavorite(@SyncMode.SyncMode1 int i) {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.clearFavorite(i);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int getFavoriteListAsync(@FavoriteType.FavoriteType1 int i, boolean z) {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.getFavoriteListAsync(i, z);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int setFrequentItemList(ArrayList<OftenArrivedItem> arrayList) {
        IBehaviorServiceImpl iBehaviorServiceImpl = this.mControl;
        if (iBehaviorServiceImpl != null) {
            return iBehaviorServiceImpl.setFrequentItemList(arrayList);
        }
        return Integer.MIN_VALUE;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.behavior.BehaviorService.3
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.behavior.BehaviorService.4
        }));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.user.behavior.observer.IBehaviorServiceObserver")).iterator();
            while (it.hasNext()) {
                removeObserver((IBehaviorServiceObserver) it.next());
            }
        }
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.behavior.BehaviorService.5
        }));
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
