package com.autonavi.gbl.user.usertrack.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.user.model.BehaviorDataType;
import com.autonavi.gbl.user.syncsdk.model.SyncMode;
import com.autonavi.gbl.user.usertrack.UserTrackService;
import com.autonavi.gbl.user.usertrack.model.BehaviorDurationType;
import com.autonavi.gbl.user.usertrack.model.BehaviorFileType;
import com.autonavi.gbl.user.usertrack.model.FootprintNaviRecordParam;
import com.autonavi.gbl.user.usertrack.model.FootprintSwitchReqType;
import com.autonavi.gbl.user.usertrack.model.HistoryRecvPoiItem;
import com.autonavi.gbl.user.usertrack.model.HistoryRecvRouteItem;
import com.autonavi.gbl.user.usertrack.model.HistoryRouteItem;
import com.autonavi.gbl.user.usertrack.model.SearchHistoryItem;
import com.autonavi.gbl.user.usertrack.observer.impl.IGpsInfoGetterImpl;
import com.autonavi.gbl.user.usertrack.observer.impl.IUserTrackObserverImpl;
import com.autonavi.gbl.util.model.ErrorCode;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.util.ArrayList;
@IntfAuto(target = UserTrackService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IUserTrackServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IUserTrackServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native int addHistoryRecvPoiNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, long j2, HistoryRecvPoiItem historyRecvPoiItem, int i);

    private static native int addHistoryRecvRouteNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, long j2, HistoryRecvRouteItem historyRecvRouteItem, int i);

    private static native int addHistoryRouteNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, long j2, HistoryRouteItem historyRouteItem, int i);

    private static native int addObserverNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, long j2, IUserTrackObserverImpl iUserTrackObserverImpl);

    private static native int addSearchHistoryNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, long j2, SearchHistoryItem searchHistoryItem, int i);

    private static native int clearBehaviorDataNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, int i, int i2);

    private static native int clearHistoryRecvPoiNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, int i);

    private static native int clearHistoryRecvRouteNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, int i);

    private static native int clearHistoryRouteNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, int i);

    private static native int clearSearchHistoryNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, int i);

    private static native int closeGpsTrackNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, String str, String str2);

    private static native int delBehaviorDataNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, int i, String str, int i2);

    private static native int delHistoryRecvPoiNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, long j2, HistoryRecvPoiItem historyRecvPoiItem, int i);

    private static native int delHistoryRecvRouteNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, long j2, HistoryRecvRouteItem historyRecvRouteItem, int i);

    private static native int delHistoryRouteNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, long j2, HistoryRouteItem historyRouteItem, int i);

    private static native int delSearchHistoryNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, long j2, SearchHistoryItem searchHistoryItem, int i);

    private static native int deleteFootprintNaviRecordNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, String str);

    private static native void destroyNativeObj(long j);

    private static native int footprintSwitchNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, int i);

    private static native String getBehaviorDataByIdNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, int i, int i2);

    private static native int getBehaviorDataIdsNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, int i, ArrayList<Integer> arrayList);

    private static native String getBehaviorDataNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, int i, String str);

    private static native String getFilePathNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, int i, String str, int i2);

    private static native int getFootprintNaviRecordListNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, long j2, FootprintNaviRecordParam footprintNaviRecordParam);

    private static native int getFootprintSummaryNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl);

    private static native int getHistoryRecvPoiListNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, ArrayList<HistoryRecvPoiItem> arrayList);

    private static native int getHistoryRecvRouteListNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, ArrayList<HistoryRecvRouteItem> arrayList);

    private static native int getHistoryRouteNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, ArrayList<HistoryRouteItem> arrayList);

    private static native int getIncompleteTrailIdsNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, int i, ArrayList<Integer> arrayList);

    private static native int getSearchHistoryNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, ArrayList<SearchHistoryItem> arrayList);

    private static native int getTotalDistanceNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, int i, int i2);

    private static native int getTotalDurationNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, int i);

    private static native String getVersionNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl);

    private static native int initNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, long j2, IGpsInfoGetterImpl iGpsInfoGetterImpl);

    private static native int isInitNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl);

    private static native int obtainGpsTrackDepInfoNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, String str, String str2);

    private static native void removeObserverNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, long j2, IUserTrackObserverImpl iUserTrackObserverImpl);

    private static native int setBehaviorDataNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, int i, String str, String str2, int i2);

    private static native int startGpsTrackNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl, String str, String str2, long j2);

    private static native void unInitNative(long j, IUserTrackServiceImpl iUserTrackServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IUserTrackServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IUserTrackServiceImpl) && getUID(this) == getUID((IUserTrackServiceImpl) obj);
    }

    private static long getUID(IUserTrackServiceImpl iUserTrackServiceImpl) {
        long cPtr = getCPtr(iUserTrackServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IUserTrackServiceImpl iUserTrackServiceImpl) {
        if (iUserTrackServiceImpl == null) {
            return 0L;
        }
        return iUserTrackServiceImpl.swigCPtr;
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

    public int[] getBehaviorDataIds(@BehaviorDataType.BehaviorDataType1 int i) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (getBehaviorDataIds(i, arrayList) != 0 || arrayList.size() <= 0) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            iArr[i2] = arrayList.get(i2).intValue();
        }
        return iArr;
    }

    public int[] getIncompleteTrailIds(@BehaviorDataType.BehaviorDataType1 int i) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (getIncompleteTrailIds(i, arrayList) != 0 || arrayList.size() <= 0) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            iArr[i2] = arrayList.get(i2).intValue();
        }
        return iArr;
    }

    public ArrayList<HistoryRouteItem> getHistoryRoute() {
        ArrayList<HistoryRouteItem> arrayList = new ArrayList<>();
        if (getHistoryRoute(arrayList) != 0) {
            return null;
        }
        return arrayList;
    }

    public ArrayList<SearchHistoryItem> getSearchHistory() {
        ArrayList<SearchHistoryItem> arrayList = new ArrayList<>();
        if (getSearchHistory(arrayList) != 0) {
            return null;
        }
        return arrayList;
    }

    public ArrayList<HistoryRecvPoiItem> getHistoryRecvPoiList() {
        ArrayList<HistoryRecvPoiItem> arrayList = new ArrayList<>();
        if (getHistoryRecvPoiList(arrayList) != 0) {
            return null;
        }
        return arrayList;
    }

    public ArrayList<HistoryRecvRouteItem> getHistoryRecvRouteList() {
        ArrayList<HistoryRecvRouteItem> arrayList = new ArrayList<>();
        if (getHistoryRecvRouteList(arrayList) != 0) {
            return null;
        }
        return arrayList;
    }

    @ErrorCode.ErrorCode1
    public int init(IGpsInfoGetterImpl iGpsInfoGetterImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, IGpsInfoGetterImpl.getCPtr(iGpsInfoGetterImpl), iGpsInfoGetterImpl);
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

    @ErrorCode.ErrorCode1
    public int addObserver(IUserTrackObserverImpl iUserTrackObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addObserverNative(j, this, IUserTrackObserverImpl.getCPtr(iUserTrackObserverImpl), iUserTrackObserverImpl);
    }

    public void removeObserver(IUserTrackObserverImpl iUserTrackObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeObserverNative(j, this, IUserTrackObserverImpl.getCPtr(iUserTrackObserverImpl), iUserTrackObserverImpl);
    }

    public int startGpsTrack(String str, String str2, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return startGpsTrackNative(j2, this, str, str2, j);
    }

    public int closeGpsTrack(String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return closeGpsTrackNative(j, this, str, str2);
    }

    public int obtainGpsTrackDepInfo(String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return obtainGpsTrackDepInfoNative(j, this, str, str2);
    }

    @ErrorCode.ErrorCode1
    public int addSearchHistory(SearchHistoryItem searchHistoryItem, @SyncMode.SyncMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addSearchHistoryNative(j, this, 0L, searchHistoryItem, i);
    }

    @ErrorCode.ErrorCode1
    private int getSearchHistory(ArrayList<SearchHistoryItem> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSearchHistoryNative(j, this, arrayList);
    }

    @ErrorCode.ErrorCode1
    public int clearSearchHistory(@SyncMode.SyncMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return clearSearchHistoryNative(j, this, i);
    }

    @ErrorCode.ErrorCode1
    public int delSearchHistory(SearchHistoryItem searchHistoryItem, @SyncMode.SyncMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return delSearchHistoryNative(j, this, 0L, searchHistoryItem, i);
    }

    @ErrorCode.ErrorCode1
    public int addHistoryRoute(HistoryRouteItem historyRouteItem, @SyncMode.SyncMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addHistoryRouteNative(j, this, 0L, historyRouteItem, i);
    }

    @ErrorCode.ErrorCode1
    private int getHistoryRoute(ArrayList<HistoryRouteItem> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getHistoryRouteNative(j, this, arrayList);
    }

    @ErrorCode.ErrorCode1
    public int clearHistoryRoute(@SyncMode.SyncMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return clearHistoryRouteNative(j, this, i);
    }

    @ErrorCode.ErrorCode1
    public int delHistoryRoute(HistoryRouteItem historyRouteItem, @SyncMode.SyncMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return delHistoryRouteNative(j, this, 0L, historyRouteItem, i);
    }

    @ErrorCode.ErrorCode1
    public int setBehaviorData(@BehaviorDataType.BehaviorDataType1 int i, String str, String str2, @SyncMode.SyncMode1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setBehaviorDataNative(j, this, i, str, str2, i2);
    }

    public String getBehaviorData(@BehaviorDataType.BehaviorDataType1 int i, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getBehaviorDataNative(j, this, i, str);
    }

    @ErrorCode.ErrorCode1
    public int clearBehaviorData(@BehaviorDataType.BehaviorDataType1 int i, @SyncMode.SyncMode1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return clearBehaviorDataNative(j, this, i, i2);
    }

    @ErrorCode.ErrorCode1
    public int delBehaviorData(@BehaviorDataType.BehaviorDataType1 int i, String str, @SyncMode.SyncMode1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return delBehaviorDataNative(j, this, i, str, i2);
    }

    @ErrorCode.ErrorCode1
    private int getBehaviorDataIds(@BehaviorDataType.BehaviorDataType1 int i, ArrayList<Integer> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getBehaviorDataIdsNative(j, this, i, arrayList);
    }

    public String getBehaviorDataById(@BehaviorDataType.BehaviorDataType1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getBehaviorDataByIdNative(j, this, i, i2);
    }

    public int getTotalDuration(@BehaviorDataType.BehaviorDataType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTotalDurationNative(j, this, i);
    }

    public int getTotalDistance(@BehaviorDataType.BehaviorDataType1 int i, @BehaviorDurationType.BehaviorDurationType1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTotalDistanceNative(j, this, i, i2);
    }

    @ErrorCode.ErrorCode1
    private int getIncompleteTrailIds(@BehaviorDataType.BehaviorDataType1 int i, ArrayList<Integer> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getIncompleteTrailIdsNative(j, this, i, arrayList);
    }

    public String getFilePath(@BehaviorDataType.BehaviorDataType1 int i, String str, @BehaviorFileType.BehaviorFileType1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getFilePathNative(j, this, i, str, i2);
    }

    @ErrorCode.ErrorCode1
    public int footprintSwitch(@FootprintSwitchReqType.FootprintSwitchReqType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return footprintSwitchNative(j, this, i);
    }

    @ErrorCode.ErrorCode1
    public int getFootprintSummary() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getFootprintSummaryNative(j, this);
    }

    @ErrorCode.ErrorCode1
    public int getFootprintNaviRecordList(FootprintNaviRecordParam footprintNaviRecordParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getFootprintNaviRecordListNative(j, this, 0L, footprintNaviRecordParam);
    }

    @ErrorCode.ErrorCode1
    public int deleteFootprintNaviRecord(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return deleteFootprintNaviRecordNative(j, this, str);
    }

    @ErrorCode.ErrorCode1
    public int addHistoryRecvPoi(HistoryRecvPoiItem historyRecvPoiItem, @SyncMode.SyncMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addHistoryRecvPoiNative(j, this, 0L, historyRecvPoiItem, i);
    }

    @ErrorCode.ErrorCode1
    private int getHistoryRecvPoiList(ArrayList<HistoryRecvPoiItem> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getHistoryRecvPoiListNative(j, this, arrayList);
    }

    @ErrorCode.ErrorCode1
    public int delHistoryRecvPoi(HistoryRecvPoiItem historyRecvPoiItem, @SyncMode.SyncMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return delHistoryRecvPoiNative(j, this, 0L, historyRecvPoiItem, i);
    }

    @ErrorCode.ErrorCode1
    public int clearHistoryRecvPoi(@SyncMode.SyncMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return clearHistoryRecvPoiNative(j, this, i);
    }

    @ErrorCode.ErrorCode1
    public int addHistoryRecvRoute(HistoryRecvRouteItem historyRecvRouteItem, @SyncMode.SyncMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addHistoryRecvRouteNative(j, this, 0L, historyRecvRouteItem, i);
    }

    @ErrorCode.ErrorCode1
    private int getHistoryRecvRouteList(ArrayList<HistoryRecvRouteItem> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getHistoryRecvRouteListNative(j, this, arrayList);
    }

    @ErrorCode.ErrorCode1
    public int delHistoryRecvRoute(HistoryRecvRouteItem historyRecvRouteItem, @SyncMode.SyncMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return delHistoryRecvRouteNative(j, this, 0L, historyRecvRouteItem, i);
    }

    @ErrorCode.ErrorCode1
    public int clearHistoryRecvRoute(@SyncMode.SyncMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return clearHistoryRecvRouteNative(j, this, i);
    }
}
