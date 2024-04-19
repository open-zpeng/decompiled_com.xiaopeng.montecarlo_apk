package com.autonavi.gbl.user.syncsdk;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.user.behavior.model.FavoriteBaseItem;
import com.autonavi.gbl.user.behavior.model.FavoriteItem;
import com.autonavi.gbl.user.behavior.model.FavoriteType;
import com.autonavi.gbl.user.behavior.model.SimpleFavoriteItem;
import com.autonavi.gbl.user.model.BehaviorDataType;
import com.autonavi.gbl.user.syncsdk.impl.ISyncSdkServiceImpl;
import com.autonavi.gbl.user.syncsdk.model.SyncSdkServiceParam;
import com.autonavi.gbl.user.syncsdk.observer.ISyncSDKServiceObserver;
import com.autonavi.gbl.user.syncsdk.observer.impl.ISyncSDKServiceObserverImpl;
import com.autonavi.gbl.user.usertrack.model.HistoryRouteItem;
import com.autonavi.gbl.user.usertrack.model.SearchHistoryItem;
import com.autonavi.gbl.util.model.ErrorCode;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = ISyncSdkServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class SyncSdkService implements IService {
    private static String PACKAGE = ReflexTool.PN(SyncSdkService.class);
    private ISyncSdkServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected SyncSdkService(long j, boolean z) {
        this((ISyncSdkServiceImpl) ReflexTool.invokeDeclConstructorSafe(ISyncSdkServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(SyncSdkService.class, this, this.mControl);
        }
    }

    public SyncSdkService(ISyncSdkServiceImpl iSyncSdkServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iSyncSdkServiceImpl);
    }

    private void $constructor(ISyncSdkServiceImpl iSyncSdkServiceImpl) {
        if (iSyncSdkServiceImpl != null) {
            this.mControl = iSyncSdkServiceImpl;
            this.mTargetId = String.format("SyncSdkService_%s_%d", String.valueOf(ISyncSdkServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ISyncSdkServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
        if (iSyncSdkServiceImpl != null) {
            return iSyncSdkServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
        if (iSyncSdkServiceImpl != null) {
            return iSyncSdkServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
        if (iSyncSdkServiceImpl != null) {
            iSyncSdkServiceImpl.onCreate();
        }
    }

    public FavoriteItem getFavorite(String str, FavoriteBaseItem favoriteBaseItem) {
        ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
        if (iSyncSdkServiceImpl != null) {
            return iSyncSdkServiceImpl.getFavorite(str, favoriteBaseItem);
        }
        return null;
    }

    public ArrayList<SimpleFavoriteItem> getSimpleFavoriteList(String str, @FavoriteType.FavoriteType1 int i) {
        ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
        if (iSyncSdkServiceImpl != null) {
            return iSyncSdkServiceImpl.getSimpleFavoriteList(str, i);
        }
        return null;
    }

    public ArrayList<SearchHistoryItem> getSearchHistory(String str) {
        ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
        if (iSyncSdkServiceImpl != null) {
            return iSyncSdkServiceImpl.getSearchHistory(str);
        }
        return null;
    }

    public ArrayList<HistoryRouteItem> getHistoryRoute(String str) {
        ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
        if (iSyncSdkServiceImpl != null) {
            return iSyncSdkServiceImpl.getHistoryRoute(str);
        }
        return null;
    }

    @ErrorCode.ErrorCode1
    public int init(SyncSdkServiceParam syncSdkServiceParam) {
        ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
        if (iSyncSdkServiceImpl != null) {
            return iSyncSdkServiceImpl.init(syncSdkServiceParam);
        }
        return Integer.MIN_VALUE;
    }

    public void unInit() {
        ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
        if (iSyncSdkServiceImpl != null) {
            iSyncSdkServiceImpl.unInit();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
        if (iSyncSdkServiceImpl != null) {
            return iSyncSdkServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public String getVersion() {
        ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
        if (iSyncSdkServiceImpl != null) {
            return iSyncSdkServiceImpl.getVersion();
        }
        return null;
    }

    @ErrorCode.ErrorCode1
    public int addObserver(ISyncSDKServiceObserver iSyncSDKServiceObserver) {
        try {
            Method method = SyncSdkService.class.getMethod("addObserver", ISyncSDKServiceObserver.class);
            if (iSyncSDKServiceObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ISyncSDKServiceObserverImpl) typeHelper.transfer(method, 0, iSyncSDKServiceObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.syncsdk.SyncSdkService.1
                    }));
                    return Integer.MIN_VALUE;
                }
            }
            ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
            if (iSyncSdkServiceImpl != null) {
                return iSyncSdkServiceImpl.addObserver(r2);
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    public void removeObserver(ISyncSDKServiceObserver iSyncSDKServiceObserver) {
        try {
            Method method = SyncSdkService.class.getMethod("removeObserver", ISyncSDKServiceObserver.class);
            if (iSyncSDKServiceObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ISyncSDKServiceObserverImpl) typeHelper.transfer(method, 0, iSyncSDKServiceObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.syncsdk.SyncSdkService.2
                    }));
                }
            }
            ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
            if (iSyncSdkServiceImpl != null) {
                iSyncSdkServiceImpl.removeObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iSyncSDKServiceObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @ErrorCode.ErrorCode1
    public int setSDKLogLevel(int i) {
        ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
        if (iSyncSdkServiceImpl != null) {
            return iSyncSdkServiceImpl.setSDKLogLevel(i);
        }
        return Integer.MIN_VALUE;
    }

    public String getSDKVersion() {
        ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
        if (iSyncSdkServiceImpl != null) {
            return iSyncSdkServiceImpl.getSDKVersion();
        }
        return null;
    }

    @ErrorCode.ErrorCode1
    public int startSync() {
        ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
        if (iSyncSdkServiceImpl != null) {
            return iSyncSdkServiceImpl.startSync();
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int isSyncing() {
        ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
        if (iSyncSdkServiceImpl != null) {
            return iSyncSdkServiceImpl.isSyncing();
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int confirmMerge(boolean z) {
        ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
        if (iSyncSdkServiceImpl != null) {
            return iSyncSdkServiceImpl.confirmMerge(z);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int confirmMerge(@BehaviorDataType.BehaviorDataType1 int i, boolean z) {
        ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
        if (iSyncSdkServiceImpl != null) {
            return iSyncSdkServiceImpl.confirmMerge(i, z);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int deleteLocalSyncData(String str) {
        ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
        if (iSyncSdkServiceImpl != null) {
            return iSyncSdkServiceImpl.deleteLocalSyncData(str);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int clearLocalSyncData(String str) {
        ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
        if (iSyncSdkServiceImpl != null) {
            return iSyncSdkServiceImpl.clearLocalSyncData(str);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int cloneLocalSyncData(String str, String str2) {
        ISyncSdkServiceImpl iSyncSdkServiceImpl = this.mControl;
        if (iSyncSdkServiceImpl != null) {
            return iSyncSdkServiceImpl.cloneLocalSyncData(str, str2);
        }
        return Integer.MIN_VALUE;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.syncsdk.SyncSdkService.3
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.syncsdk.SyncSdkService.4
        }));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.user.syncsdk.observer.ISyncSDKServiceObserver")).iterator();
            while (it.hasNext()) {
                removeObserver((ISyncSDKServiceObserver) it.next());
            }
        }
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.syncsdk.SyncSdkService.5
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
