package com.autonavi.gbl.user.behavior.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
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

    private static native int syncFrequentDataNative(long j, IBehaviorServiceImpl iBehaviorServiceImpl);

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
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

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

    public int setLoginInfo(UserLoginInfo userLoginInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLoginInfoNative(j, this, 0L, userLoginInfo);
    }

    public int setConfig(@ConfigKey.ConfigKey1 int i, ConfigValue configValue, @SyncMode.SyncMode1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setConfigNative(j, this, i, 0L, configValue, i2);
    }

    public ConfigValue getConfig(@ConfigKey.ConfigKey1 int i) {
        ConfigValue configValue = new ConfigValue();
        if (Integer.valueOf(getConfig(i, configValue)).intValue() == 0) {
            return configValue;
        }
        return null;
    }

    private int getConfig(@ConfigKey.ConfigKey1 int i, ConfigValue configValue) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getConfigNative(j, this, i, 0L, configValue);
    }

    public String addFavorite(FavoriteItem favoriteItem, @SyncMode.SyncMode1 int i) {
        String[] strArr = new String[1];
        Integer.valueOf(addFavorite(favoriteItem, i, strArr));
        return strArr[0];
    }

    private int addFavorite(FavoriteItem favoriteItem, @SyncMode.SyncMode1 int i, String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addFavoriteNative(j, this, 0L, favoriteItem, i, strArr);
    }

    public int clearFavorite(@SyncMode.SyncMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return clearFavoriteNative(j, this, i);
    }

    public String delFavorite(FavoriteBaseItem favoriteBaseItem, @SyncMode.SyncMode1 int i) {
        String[] strArr = new String[1];
        Integer.valueOf(delFavorite(favoriteBaseItem, i, strArr));
        return strArr[0];
    }

    private int delFavorite(FavoriteBaseItem favoriteBaseItem, @SyncMode.SyncMode1 int i, String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return delFavoriteNative(j, this, 0L, favoriteBaseItem, i, strArr);
    }

    public String updateFavorite(FavoriteItem favoriteItem, @SyncMode.SyncMode1 int i) {
        String[] strArr = new String[1];
        Integer.valueOf(updateFavorite(favoriteItem, i, strArr));
        return strArr[0];
    }

    private int updateFavorite(FavoriteItem favoriteItem, @SyncMode.SyncMode1 int i, String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateFavoriteNative(j, this, 0L, favoriteItem, i, strArr);
    }

    public String topFavorite(FavoriteBaseItem favoriteBaseItem, boolean z, @SyncMode.SyncMode1 int i) {
        String[] strArr = new String[1];
        Integer.valueOf(topFavorite(favoriteBaseItem, z, i, strArr));
        return strArr[0];
    }

    private int topFavorite(FavoriteBaseItem favoriteBaseItem, boolean z, @SyncMode.SyncMode1 int i, String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return topFavoriteNative(j, this, 0L, favoriteBaseItem, z, i, strArr);
    }

    public FavoriteItem getFavorite(FavoriteBaseItem favoriteBaseItem) {
        FavoriteItem favoriteItem = new FavoriteItem();
        if (Integer.valueOf(getFavorite(favoriteBaseItem, favoriteItem)).intValue() == 0) {
            return favoriteItem;
        }
        return null;
    }

    private int getFavorite(FavoriteBaseItem favoriteBaseItem, FavoriteItem favoriteItem) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getFavoriteNative(j, this, 0L, favoriteBaseItem, 0L, favoriteItem);
    }

    public int getFavoriteListAsync(@FavoriteType.FavoriteType1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getFavoriteListAsyncNative(j, this, i, z);
    }

    public ArrayList<SimpleFavoriteItem> getSimpleFavoriteList(@FavoriteType.FavoriteType1 int i, boolean z) {
        ArrayList<SimpleFavoriteItem> arrayList = new ArrayList<>();
        if (Integer.valueOf(getSimpleFavoriteList(i, arrayList, z)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private int getSimpleFavoriteList(@FavoriteType.FavoriteType1 int i, ArrayList<SimpleFavoriteItem> arrayList, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSimpleFavoriteListNative(j, this, i, arrayList, z);
    }

    public int[] getSimpleFavoriteIds() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (Integer.valueOf(getSimpleFavoriteIds(arrayList)).intValue() != 0 || arrayList.size() <= 0) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = arrayList.get(i).intValue();
        }
        return iArr;
    }

    private int getSimpleFavoriteIds(ArrayList<Integer> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSimpleFavoriteIdsNative(j, this, arrayList);
    }

    public SimpleFavoriteItem getSimpleFavoriteById(int i) {
        SimpleFavoriteItem simpleFavoriteItem = new SimpleFavoriteItem();
        if (Integer.valueOf(getSimpleFavoriteById(i, simpleFavoriteItem)).intValue() == 0) {
            return simpleFavoriteItem;
        }
        return null;
    }

    private int getSimpleFavoriteById(int i, SimpleFavoriteItem simpleFavoriteItem) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSimpleFavoriteByIdNative(j, this, i, 0L, simpleFavoriteItem);
    }

    public String isFavorited(FavoriteBaseItem favoriteBaseItem) {
        String[] strArr = new String[1];
        Integer.valueOf(isFavorited(favoriteBaseItem, strArr));
        return strArr[0];
    }

    private int isFavorited(FavoriteBaseItem favoriteBaseItem, String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isFavoritedNative(j, this, 0L, favoriteBaseItem, strArr);
    }

    public String getItemId(int i, int i2, String str) {
        String[] strArr = new String[1];
        Integer.valueOf(getItemId(i, i2, str, strArr));
        return strArr[0];
    }

    private int getItemId(int i, int i2, String str, String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getItemIdNative(j, this, i, i2, str, strArr);
    }

    public VehicleInfo getCar(String str) {
        VehicleInfo vehicleInfo = new VehicleInfo();
        if (Integer.valueOf(getCar(str, vehicleInfo)).intValue() == 0) {
            return vehicleInfo;
        }
        return null;
    }

    private int getCar(String str, VehicleInfo vehicleInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCarNative(j, this, str, 0L, vehicleInfo);
    }

    public ArrayList<OftenArrivedItem> getFrequentItemList() {
        ArrayList<OftenArrivedItem> arrayList = new ArrayList<>();
        if (Integer.valueOf(getFrequentItemList(arrayList)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private int getFrequentItemList(ArrayList<OftenArrivedItem> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getFrequentItemListNative(j, this, arrayList);
    }

    public int setFrequentItemList(ArrayList<OftenArrivedItem> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setFrequentItemListNative(j, this, arrayList);
    }

    public int syncFrequentData() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return syncFrequentDataNative(j, this);
    }
}
