package com.autonavi.gbl.user.usertrack;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.user.model.BehaviorDataType;
import com.autonavi.gbl.user.syncsdk.model.SyncMode;
import com.autonavi.gbl.user.usertrack.impl.IUserTrackServiceImpl;
import com.autonavi.gbl.user.usertrack.model.BehaviorDurationType;
import com.autonavi.gbl.user.usertrack.model.BehaviorFileType;
import com.autonavi.gbl.user.usertrack.model.FootprintNaviRecordParam;
import com.autonavi.gbl.user.usertrack.model.FootprintSwitchReqType;
import com.autonavi.gbl.user.usertrack.model.HistoryRecvPoiItem;
import com.autonavi.gbl.user.usertrack.model.HistoryRecvRouteItem;
import com.autonavi.gbl.user.usertrack.model.HistoryRouteItem;
import com.autonavi.gbl.user.usertrack.model.SearchHistoryItem;
import com.autonavi.gbl.user.usertrack.observer.IGpsInfoGetter;
import com.autonavi.gbl.user.usertrack.observer.IUserTrackObserver;
import com.autonavi.gbl.user.usertrack.observer.impl.IGpsInfoGetterImpl;
import com.autonavi.gbl.user.usertrack.observer.impl.IUserTrackObserverImpl;
import com.autonavi.gbl.util.model.ErrorCode;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IUserTrackServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class UserTrackService implements IService {
    private static String PACKAGE = ReflexTool.PN(UserTrackService.class);
    private IUserTrackServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected UserTrackService(long j, boolean z) {
        this((IUserTrackServiceImpl) ReflexTool.invokeDeclConstructorSafe(IUserTrackServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(UserTrackService.class, this, this.mControl);
        }
    }

    public UserTrackService(IUserTrackServiceImpl iUserTrackServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iUserTrackServiceImpl);
    }

    private void $constructor(IUserTrackServiceImpl iUserTrackServiceImpl) {
        if (iUserTrackServiceImpl != null) {
            this.mControl = iUserTrackServiceImpl;
            this.mTargetId = String.format("UserTrackService_%s_%d", String.valueOf(IUserTrackServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IUserTrackServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            iUserTrackServiceImpl.onCreate();
        }
    }

    public int[] getBehaviorDataIds(@BehaviorDataType.BehaviorDataType1 int i) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.getBehaviorDataIds(i);
        }
        return null;
    }

    public int[] getIncompleteTrailIds(@BehaviorDataType.BehaviorDataType1 int i) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.getIncompleteTrailIds(i);
        }
        return null;
    }

    public ArrayList<HistoryRouteItem> getHistoryRoute() {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.getHistoryRoute();
        }
        return null;
    }

    public ArrayList<SearchHistoryItem> getSearchHistory() {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.getSearchHistory();
        }
        return null;
    }

    public ArrayList<HistoryRecvPoiItem> getHistoryRecvPoiList() {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.getHistoryRecvPoiList();
        }
        return null;
    }

    public ArrayList<HistoryRecvRouteItem> getHistoryRecvRouteList() {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.getHistoryRecvRouteList();
        }
        return null;
    }

    @ErrorCode.ErrorCode1
    public int init(IGpsInfoGetter iGpsInfoGetter) {
        try {
            Method method = UserTrackService.class.getMethod("init", IGpsInfoGetter.class);
            if (iGpsInfoGetter != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IGpsInfoGetterImpl) typeHelper.transfer(method, 0, iGpsInfoGetter) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $getter == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.usertrack.UserTrackService.1
                    }));
                    return Integer.MIN_VALUE;
                }
            }
            IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
            if (iUserTrackServiceImpl != null) {
                return iUserTrackServiceImpl.init(r2);
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    public void unInit() {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            iUserTrackServiceImpl.unInit();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public String getVersion() {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.getVersion();
        }
        return null;
    }

    @ErrorCode.ErrorCode1
    public int addObserver(IUserTrackObserver iUserTrackObserver) {
        try {
            Method method = UserTrackService.class.getMethod("addObserver", IUserTrackObserver.class);
            if (iUserTrackObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IUserTrackObserverImpl) typeHelper.transfer(method, 0, iUserTrackObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.usertrack.UserTrackService.2
                    }));
                    return Integer.MIN_VALUE;
                }
            }
            IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
            if (iUserTrackServiceImpl != null) {
                return iUserTrackServiceImpl.addObserver(r2);
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    public void removeObserver(IUserTrackObserver iUserTrackObserver) {
        try {
            Method method = UserTrackService.class.getMethod("removeObserver", IUserTrackObserver.class);
            if (iUserTrackObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IUserTrackObserverImpl) typeHelper.transfer(method, 0, iUserTrackObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.usertrack.UserTrackService.3
                    }));
                }
            }
            IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
            if (iUserTrackServiceImpl != null) {
                iUserTrackServiceImpl.removeObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iUserTrackObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public int startGpsTrack(String str, String str2, long j) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.startGpsTrack(str, str2, j);
        }
        return 0;
    }

    public int closeGpsTrack(String str, String str2) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.closeGpsTrack(str, str2);
        }
        return 0;
    }

    public int obtainGpsTrackDepInfo(String str, String str2) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.obtainGpsTrackDepInfo(str, str2);
        }
        return 0;
    }

    @ErrorCode.ErrorCode1
    public int addSearchHistory(SearchHistoryItem searchHistoryItem, @SyncMode.SyncMode1 int i) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.addSearchHistory(searchHistoryItem, i);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int clearSearchHistory(@SyncMode.SyncMode1 int i) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.clearSearchHistory(i);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int delSearchHistory(SearchHistoryItem searchHistoryItem, @SyncMode.SyncMode1 int i) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.delSearchHistory(searchHistoryItem, i);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int addHistoryRoute(HistoryRouteItem historyRouteItem, @SyncMode.SyncMode1 int i) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.addHistoryRoute(historyRouteItem, i);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int clearHistoryRoute(@SyncMode.SyncMode1 int i) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.clearHistoryRoute(i);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int delHistoryRoute(HistoryRouteItem historyRouteItem, @SyncMode.SyncMode1 int i) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.delHistoryRoute(historyRouteItem, i);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int setBehaviorData(@BehaviorDataType.BehaviorDataType1 int i, String str, String str2, @SyncMode.SyncMode1 int i2) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.setBehaviorData(i, str, str2, i2);
        }
        return Integer.MIN_VALUE;
    }

    public String getBehaviorData(@BehaviorDataType.BehaviorDataType1 int i, String str) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.getBehaviorData(i, str);
        }
        return null;
    }

    @ErrorCode.ErrorCode1
    public int clearBehaviorData(@BehaviorDataType.BehaviorDataType1 int i, @SyncMode.SyncMode1 int i2) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.clearBehaviorData(i, i2);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int delBehaviorData(@BehaviorDataType.BehaviorDataType1 int i, String str, @SyncMode.SyncMode1 int i2) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.delBehaviorData(i, str, i2);
        }
        return Integer.MIN_VALUE;
    }

    public String getBehaviorDataById(@BehaviorDataType.BehaviorDataType1 int i, int i2) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.getBehaviorDataById(i, i2);
        }
        return null;
    }

    public int getTotalDuration(@BehaviorDataType.BehaviorDataType1 int i) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.getTotalDuration(i);
        }
        return 0;
    }

    public int getTotalDistance(@BehaviorDataType.BehaviorDataType1 int i, @BehaviorDurationType.BehaviorDurationType1 int i2) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.getTotalDistance(i, i2);
        }
        return 0;
    }

    public String getFilePath(@BehaviorDataType.BehaviorDataType1 int i, String str, @BehaviorFileType.BehaviorFileType1 int i2) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.getFilePath(i, str, i2);
        }
        return null;
    }

    @ErrorCode.ErrorCode1
    public int footprintSwitch(@FootprintSwitchReqType.FootprintSwitchReqType1 int i) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.footprintSwitch(i);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int getFootprintSummary() {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.getFootprintSummary();
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int getFootprintNaviRecordList(FootprintNaviRecordParam footprintNaviRecordParam) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.getFootprintNaviRecordList(footprintNaviRecordParam);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int deleteFootprintNaviRecord(String str) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.deleteFootprintNaviRecord(str);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int addHistoryRecvPoi(HistoryRecvPoiItem historyRecvPoiItem, @SyncMode.SyncMode1 int i) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.addHistoryRecvPoi(historyRecvPoiItem, i);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int delHistoryRecvPoi(HistoryRecvPoiItem historyRecvPoiItem, @SyncMode.SyncMode1 int i) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.delHistoryRecvPoi(historyRecvPoiItem, i);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int clearHistoryRecvPoi(@SyncMode.SyncMode1 int i) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.clearHistoryRecvPoi(i);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int addHistoryRecvRoute(HistoryRecvRouteItem historyRecvRouteItem, @SyncMode.SyncMode1 int i) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.addHistoryRecvRoute(historyRecvRouteItem, i);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int delHistoryRecvRoute(HistoryRecvRouteItem historyRecvRouteItem, @SyncMode.SyncMode1 int i) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.delHistoryRecvRoute(historyRecvRouteItem, i);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int clearHistoryRecvRoute(@SyncMode.SyncMode1 int i) {
        IUserTrackServiceImpl iUserTrackServiceImpl = this.mControl;
        if (iUserTrackServiceImpl != null) {
            return iUserTrackServiceImpl.clearHistoryRecvRoute(i);
        }
        return Integer.MIN_VALUE;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.usertrack.UserTrackService.4
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.usertrack.UserTrackService.5
        }));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.user.usertrack.observer.IUserTrackObserver")).iterator();
            while (it.hasNext()) {
                removeObserver((IUserTrackObserver) it.next());
            }
        }
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.usertrack.UserTrackService.6
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
