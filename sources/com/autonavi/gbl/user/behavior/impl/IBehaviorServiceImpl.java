package com.autonavi.gbl.user.behavior.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.user.behavior.BehaviorService;
import com.autonavi.gbl.user.behavior.model.BehaviorServiceParam;
import com.autonavi.gbl.user.behavior.model.ConfigKey;
import com.autonavi.gbl.user.behavior.model.ConfigValue;
import com.autonavi.gbl.user.behavior.model.FavoriteBaseItem;
import com.autonavi.gbl.user.behavior.model.FavoriteItem;
import com.autonavi.gbl.user.behavior.model.FavoriteType;
import com.autonavi.gbl.user.behavior.model.SimpleFavoriteItem;
import com.autonavi.gbl.user.behavior.model.VehicleInfo;
import com.autonavi.gbl.user.behavior.observer.impl.IBehaviorServiceObserverImpl;
import com.autonavi.gbl.user.forcast.model.OftenArrivedItem;
import com.autonavi.gbl.user.model.UserLoginInfo;
import com.autonavi.gbl.user.syncsdk.model.SyncMode;
import com.autonavi.gbl.util.model.ErrorCode;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.util.ArrayList;
@IntfAuto(target = BehaviorService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBehaviorServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IBehaviorServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native int addFavoriteNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, long j2, FavoriteItem favoriteItem, int i, String[] strArr);

    private static native int addObserverNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, long j2, IBehaviorServiceObserverImpl iBehaviorServiceObserverImpl);

    private static native int clearFavoriteNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, int i);

    private static native int delFavoriteNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, long j2, FavoriteBaseItem favoriteBaseItem, int i, String[] strArr);

    private static native void destroyNativeObj(long j);

    private static native int getCarNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, String str, long j2, VehicleInfo vehicleInfo);

    private static native int getConfigNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, int i, long j2, ConfigValue configValue);

    private static native int getFavoriteListAsyncNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, int i, boolean z);

    private static native int getFavoriteNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, long j2, FavoriteBaseItem favoriteBaseItem, long j3, FavoriteItem favoriteItem);

    private static native int getFrequentItemListNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, ArrayList<OftenArrivedItem> arrayList);

    private static native int getItemIdNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, int i, int i2, String str, String[] strArr);

    private static native int getSimpleFavoriteByIdNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, int i, long j2, SimpleFavoriteItem simpleFavoriteItem);

    private static native int getSimpleFavoriteIdsNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, ArrayList<Integer> arrayList);

    private static native int getSimpleFavoriteListNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, int i, ArrayList<SimpleFavoriteItem> arrayList, boolean z);

    private static native String getVersionNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl);

    private static native int initNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, long j2, BehaviorServiceParam behaviorServiceParam);

    private static native int isFavoritedNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, long j2, FavoriteBaseItem favoriteBaseItem, String[] strArr);

    private static native int isInitNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl);

    private static native void logSwitchNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, int i);

    private static native void removeObserverNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, long j2, IBehaviorServiceObserverImpl iBehaviorServiceObserverImpl);

    private static native int setConfigNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, int i, long j2, ConfigValue configValue, int i2);

    private static native int setFrequentItemListNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, ArrayList<OftenArrivedItem> arrayList);

    private static native int setLoginInfoNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, long j2, UserLoginInfo userLoginInfo);

    private static native int topFavoriteNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, long j2, FavoriteBaseItem favoriteBaseItem, boolean z, int i, String[] strArr);

    private static native void unInitNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl);

    private static native int updateFavoriteNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl, long j2, FavoriteItem favoriteItem, int i, String[] strArr);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IBehaviorServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IBehaviorServiceImpl) && getUID(this) == getUID((IBehaviorServiceImpl) obj);
    }

    private static long getUID(IBehaviorServiceImpl iBehaviorServiceImpl) {
        long cPtr = getCPtr(iBehaviorServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBehaviorServiceImpl iBehaviorServiceImpl) {
        if (iBehaviorServiceImpl == null) {
            return 0L;
        }
        return iBehaviorServiceImpl.swigCPtr;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        return this.swigCPtr;
    }

    protected synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public ConfigValue getConfig(@ConfigKey.ConfigKey1 int i) {
        ConfigValue configValue = new ConfigValue();
        if (getConfig(i, configValue) != 0) {
            return null;
        }
        return configValue;
    }

    public String addFavorite(FavoriteItem favoriteItem, @SyncMode.SyncMode1 int i) {
        String[] strArr = new String[1];
        if (addFavorite(favoriteItem, i, strArr) != 0) {
            return null;
        }
        return strArr[0];
    }

    public String updateFavorite(FavoriteItem favoriteItem, @SyncMode.SyncMode1 int i) {
        String[] strArr = new String[1];
        if (updateFavorite(favoriteItem, i, strArr) != 0) {
            return null;
        }
        return strArr[0];
    }

    public String delFavorite(FavoriteBaseItem favoriteBaseItem, @SyncMode.SyncMode1 int i) {
        String[] strArr = new String[1];
        if (delFavorite(favoriteBaseItem, i, strArr) != 0) {
            return null;
        }
        return strArr[0];
    }

    public String topFavorite(FavoriteBaseItem favoriteBaseItem, boolean z, @SyncMode.SyncMode1 int i) {
        String[] strArr = new String[1];
        if (topFavorite(favoriteBaseItem, z, i, strArr) != 0) {
            return null;
        }
        return strArr[0];
    }

    public String isFavorited(FavoriteBaseItem favoriteBaseItem) {
        String[] strArr = new String[1];
        if (isFavorited(favoriteBaseItem, strArr) != 0) {
            return null;
        }
        return strArr[0];
    }

    public FavoriteItem getFavorite(FavoriteBaseItem favoriteBaseItem) {
        FavoriteItem favoriteItem = new FavoriteItem();
        if (getFavorite(favoriteBaseItem, favoriteItem) != 0) {
            return null;
        }
        return favoriteItem;
    }

    public ArrayList<SimpleFavoriteItem> getSimpleFavoriteList(@FavoriteType.FavoriteType1 int i, boolean z) {
        ArrayList<SimpleFavoriteItem> arrayList = new ArrayList<>();
        if (getSimpleFavoriteList(i, arrayList, z) != 0) {
            return null;
        }
        return arrayList;
    }

    public int[] getSimpleFavoriteIds() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (getSimpleFavoriteIds(arrayList) != 0 || arrayList.size() <= 0) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = arrayList.get(i).intValue();
        }
        return iArr;
    }

    public SimpleFavoriteItem getSimpleFavoriteById(int i) {
        SimpleFavoriteItem simpleFavoriteItem = new SimpleFavoriteItem();
        if (getSimpleFavoriteById(i, simpleFavoriteItem) != 0) {
            return null;
        }
        return simpleFavoriteItem;
    }

    public String getItemId(int i, int i2, String str) {
        String[] strArr = new String[1];
        if (getItemId(i, i2, str, strArr) != 0) {
            return null;
        }
        return strArr[0];
    }

    public VehicleInfo getCar(String str) {
        VehicleInfo vehicleInfo = new VehicleInfo();
        if (getCar(str, vehicleInfo) != 0) {
            return null;
        }
        return vehicleInfo;
    }

    public ArrayList<OftenArrivedItem> getFrequentItemList() {
        ArrayList<OftenArrivedItem> arrayList = new ArrayList<>();
        if (getFrequentItemList(arrayList) != 0) {
            return null;
        }
        return arrayList;
    }

    @ErrorCode.ErrorCode1
    public int init(BehaviorServiceParam behaviorServiceParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, 0L, behaviorServiceParam);
    }

    public void unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInitNative(j, this);
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isInitNative(j, this);
    }

    public String getVersion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVersionNative(j, this);
    }

    public void logSwitch(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        logSwitchNative(j, this, i);
    }

    @ErrorCode.ErrorCode1
    public int addObserver(IBehaviorServiceObserverImpl iBehaviorServiceObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addObserverNative(j, this, IBehaviorServiceObserverImpl.getCPtr(iBehaviorServiceObserverImpl), iBehaviorServiceObserverImpl);
    }

    public void removeObserver(IBehaviorServiceObserverImpl iBehaviorServiceObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeObserverNative(j, this, IBehaviorServiceObserverImpl.getCPtr(iBehaviorServiceObserverImpl), iBehaviorServiceObserverImpl);
    }

    @ErrorCode.ErrorCode1
    public int setLoginInfo(UserLoginInfo userLoginInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLoginInfoNative(j, this, 0L, userLoginInfo);
    }

    @ErrorCode.ErrorCode1
    public int setConfig(@ConfigKey.ConfigKey1 int i, ConfigValue configValue, @SyncMode.SyncMode1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setConfigNative(j, this, i, 0L, configValue, i2);
    }

    @ErrorCode.ErrorCode1
    private int getConfig(@ConfigKey.ConfigKey1 int i, ConfigValue configValue) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getConfigNative(j, this, i, 0L, configValue);
    }

    @ErrorCode.ErrorCode1
    private int addFavorite(FavoriteItem favoriteItem, @SyncMode.SyncMode1 int i, String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addFavoriteNative(j, this, 0L, favoriteItem, i, strArr);
    }

    @ErrorCode.ErrorCode1
    public int clearFavorite(@SyncMode.SyncMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return clearFavoriteNative(j, this, i);
    }

    @ErrorCode.ErrorCode1
    private int delFavorite(FavoriteBaseItem favoriteBaseItem, @SyncMode.SyncMode1 int i, String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return delFavoriteNative(j, this, 0L, favoriteBaseItem, i, strArr);
    }

    @ErrorCode.ErrorCode1
    private int updateFavorite(FavoriteItem favoriteItem, @SyncMode.SyncMode1 int i, String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateFavoriteNative(j, this, 0L, favoriteItem, i, strArr);
    }

    @ErrorCode.ErrorCode1
    private int topFavorite(FavoriteBaseItem favoriteBaseItem, boolean z, @SyncMode.SyncMode1 int i, String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return topFavoriteNative(j, this, 0L, favoriteBaseItem, z, i, strArr);
    }

    @ErrorCode.ErrorCode1
    private int getFavorite(FavoriteBaseItem favoriteBaseItem, FavoriteItem favoriteItem) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getFavoriteNative(j, this, 0L, favoriteBaseItem, 0L, favoriteItem);
    }

    @ErrorCode.ErrorCode1
    public int getFavoriteListAsync(@FavoriteType.FavoriteType1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getFavoriteListAsyncNative(j, this, i, z);
    }

    @ErrorCode.ErrorCode1
    private int getSimpleFavoriteList(@FavoriteType.FavoriteType1 int i, ArrayList<SimpleFavoriteItem> arrayList, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSimpleFavoriteListNative(j, this, i, arrayList, z);
    }

    @ErrorCode.ErrorCode1
    private int getSimpleFavoriteIds(ArrayList<Integer> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSimpleFavoriteIdsNative(j, this, arrayList);
    }

    @ErrorCode.ErrorCode1
    private int getSimpleFavoriteById(int i, SimpleFavoriteItem simpleFavoriteItem) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSimpleFavoriteByIdNative(j, this, i, 0L, simpleFavoriteItem);
    }

    @ErrorCode.ErrorCode1
    private int isFavorited(FavoriteBaseItem favoriteBaseItem, String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isFavoritedNative(j, this, 0L, favoriteBaseItem, strArr);
    }

    @ErrorCode.ErrorCode1
    private int getItemId(int i, int i2, String str, String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getItemIdNative(j, this, i, i2, str, strArr);
    }

    @ErrorCode.ErrorCode1
    private int getCar(String str, VehicleInfo vehicleInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCarNative(j, this, str, 0L, vehicleInfo);
    }

    @ErrorCode.ErrorCode1
    private int getFrequentItemList(ArrayList<OftenArrivedItem> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getFrequentItemListNative(j, this, arrayList);
    }

    @ErrorCode.ErrorCode1
    public int setFrequentItemList(ArrayList<OftenArrivedItem> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setFrequentItemListNative(j, this, arrayList);
    }
}
