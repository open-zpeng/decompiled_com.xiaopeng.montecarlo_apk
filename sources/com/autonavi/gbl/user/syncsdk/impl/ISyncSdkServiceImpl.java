package com.autonavi.gbl.user.syncsdk.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.user.behavior.model.FavoriteBaseItem;
import com.autonavi.gbl.user.behavior.model.FavoriteItem;
import com.autonavi.gbl.user.behavior.model.FavoriteType;
import com.autonavi.gbl.user.behavior.model.SimpleFavoriteItem;
import com.autonavi.gbl.user.model.BehaviorDataType;
import com.autonavi.gbl.user.syncsdk.SyncSdkService;
import com.autonavi.gbl.user.syncsdk.model.SyncSdkServiceParam;
import com.autonavi.gbl.user.syncsdk.observer.impl.ISyncSDKServiceObserverImpl;
import com.autonavi.gbl.user.usertrack.model.HistoryRouteItem;
import com.autonavi.gbl.user.usertrack.model.SearchHistoryItem;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.util.ArrayList;
@IntfAuto(target = SyncSdkService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class ISyncSdkServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(ISyncSdkServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native int addObserverNative(long j, ISyncSdkServiceImpl iSyncSdkServiceImpl, long j2, ISyncSDKServiceObserverImpl iSyncSDKServiceObserverImpl);

    private static native int clearLocalSyncDataNative(long j, ISyncSdkServiceImpl iSyncSdkServiceImpl, String str);

    private static native int cloneLocalSyncDataNative(long j, ISyncSdkServiceImpl iSyncSdkServiceImpl, String str, String str2);

    private static native int confirmMerge1Native(long j, ISyncSdkServiceImpl iSyncSdkServiceImpl, int i, boolean z);

    private static native int confirmMergeNative(long j, ISyncSdkServiceImpl iSyncSdkServiceImpl, boolean z);

    private static native int deleteLocalSyncDataNative(long j, ISyncSdkServiceImpl iSyncSdkServiceImpl, String str);

    private static native void destroyNativeObj(long j);

    private static native int getFavoriteNative(long j, ISyncSdkServiceImpl iSyncSdkServiceImpl, String str, long j2, FavoriteBaseItem favoriteBaseItem, long j3, FavoriteItem favoriteItem);

    private static native int getHistoryRouteNative(long j, ISyncSdkServiceImpl iSyncSdkServiceImpl, String str, ArrayList<HistoryRouteItem> arrayList);

    private static native String getSDKVersionNative(long j, ISyncSdkServiceImpl iSyncSdkServiceImpl);

    private static native int getSearchHistoryNative(long j, ISyncSdkServiceImpl iSyncSdkServiceImpl, String str, ArrayList<SearchHistoryItem> arrayList);

    private static native int getSimpleFavoriteListNative(long j, ISyncSdkServiceImpl iSyncSdkServiceImpl, String str, int i, ArrayList<SimpleFavoriteItem> arrayList);

    private static native String getVersionNative(long j, ISyncSdkServiceImpl iSyncSdkServiceImpl);

    private static native int initNative(long j, ISyncSdkServiceImpl iSyncSdkServiceImpl, long j2, SyncSdkServiceParam syncSdkServiceParam);

    private static native int isInitNative(long j, ISyncSdkServiceImpl iSyncSdkServiceImpl);

    private static native int isSyncingNative(long j, ISyncSdkServiceImpl iSyncSdkServiceImpl);

    private static native void removeObserverNative(long j, ISyncSdkServiceImpl iSyncSdkServiceImpl, long j2, ISyncSDKServiceObserverImpl iSyncSDKServiceObserverImpl);

    private static native int setSDKLogLevelNative(long j, ISyncSdkServiceImpl iSyncSdkServiceImpl, int i);

    private static native int startSyncNative(long j, ISyncSdkServiceImpl iSyncSdkServiceImpl);

    private static native void unInitNative(long j, ISyncSdkServiceImpl iSyncSdkServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected ISyncSdkServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ISyncSdkServiceImpl) && getUID(this) == getUID((ISyncSdkServiceImpl) obj);
    }

    private static long getUID(ISyncSdkServiceImpl iSyncSdkServiceImpl) {
        long cPtr = getCPtr(iSyncSdkServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ISyncSdkServiceImpl iSyncSdkServiceImpl) {
        if (iSyncSdkServiceImpl == null) {
            return 0L;
        }
        return iSyncSdkServiceImpl.swigCPtr;
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

    public int init(SyncSdkServiceParam syncSdkServiceParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, 0L, syncSdkServiceParam);
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

    public int addObserver(ISyncSDKServiceObserverImpl iSyncSDKServiceObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addObserverNative(j, this, ISyncSDKServiceObserverImpl.getCPtr(iSyncSDKServiceObserverImpl), iSyncSDKServiceObserverImpl);
    }

    public void removeObserver(ISyncSDKServiceObserverImpl iSyncSDKServiceObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeObserverNative(j, this, ISyncSDKServiceObserverImpl.getCPtr(iSyncSDKServiceObserverImpl), iSyncSDKServiceObserverImpl);
    }

    public int setSDKLogLevel(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setSDKLogLevelNative(j, this, i);
    }

    public String getSDKVersion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSDKVersionNative(j, this);
    }

    public int startSync() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return startSyncNative(j, this);
    }

    public int isSyncing() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isSyncingNative(j, this);
    }

    public int confirmMerge(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return confirmMergeNative(j, this, z);
    }

    public int confirmMerge(@BehaviorDataType.BehaviorDataType1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return confirmMerge1Native(j, this, i, z);
    }

    public int deleteLocalSyncData(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return deleteLocalSyncDataNative(j, this, str);
    }

    public int clearLocalSyncData(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return clearLocalSyncDataNative(j, this, str);
    }

    public int cloneLocalSyncData(String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return cloneLocalSyncDataNative(j, this, str, str2);
    }

    public FavoriteItem getFavorite(String str, FavoriteBaseItem favoriteBaseItem) {
        FavoriteItem favoriteItem = new FavoriteItem();
        if (Integer.valueOf(getFavorite(str, favoriteBaseItem, favoriteItem)).intValue() == 0) {
            return favoriteItem;
        }
        return null;
    }

    private int getFavorite(String str, FavoriteBaseItem favoriteBaseItem, FavoriteItem favoriteItem) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getFavoriteNative(j, this, str, 0L, favoriteBaseItem, 0L, favoriteItem);
    }

    public ArrayList<SimpleFavoriteItem> getSimpleFavoriteList(String str, @FavoriteType.FavoriteType1 int i) {
        ArrayList<SimpleFavoriteItem> arrayList = new ArrayList<>();
        if (Integer.valueOf(getSimpleFavoriteList(str, i, arrayList)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private int getSimpleFavoriteList(String str, @FavoriteType.FavoriteType1 int i, ArrayList<SimpleFavoriteItem> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSimpleFavoriteListNative(j, this, str, i, arrayList);
    }

    public ArrayList<SearchHistoryItem> getSearchHistory(String str) {
        ArrayList<SearchHistoryItem> arrayList = new ArrayList<>();
        if (Integer.valueOf(getSearchHistory(str, arrayList)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private int getSearchHistory(String str, ArrayList<SearchHistoryItem> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSearchHistoryNative(j, this, str, arrayList);
    }

    public ArrayList<HistoryRouteItem> getHistoryRoute(String str) {
        ArrayList<HistoryRouteItem> arrayList = new ArrayList<>();
        if (Integer.valueOf(getHistoryRoute(str, arrayList)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private int getHistoryRoute(String str, ArrayList<HistoryRouteItem> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getHistoryRouteNative(j, this, str, arrayList);
    }
}
