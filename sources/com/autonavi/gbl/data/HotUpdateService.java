package com.autonavi.gbl.data;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.impl.IHotUpdateServiceImpl;
import com.autonavi.gbl.data.model.DetailListParser;
import com.autonavi.gbl.data.model.HotUpdateCheckParam;
import com.autonavi.gbl.data.model.HotUpdateFileType;
import com.autonavi.gbl.data.model.MapNum;
import com.autonavi.gbl.data.model.impl.DetailListParserImpl;
import com.autonavi.gbl.data.observer.IHotUpdateCheckObserver;
import com.autonavi.gbl.data.observer.IHotUpdateFileObserver;
import com.autonavi.gbl.data.observer.IMapNumObserver;
import com.autonavi.gbl.data.observer.impl.IHotUpdateCheckObserverImpl;
import com.autonavi.gbl.data.observer.impl.IHotUpdateFileObserverImpl;
import com.autonavi.gbl.data.observer.impl.IMapNumObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
@IntfAuto(target = IHotUpdateServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class HotUpdateService implements IService {
    private static String PACKAGE = ReflexTool.PN(HotUpdateService.class);
    private IHotUpdateServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected HotUpdateService(long j, boolean z) {
        this((IHotUpdateServiceImpl) ReflexTool.invokeDeclConstructorSafe(IHotUpdateServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(HotUpdateService.class, this, this.mControl);
        }
    }

    public HotUpdateService(IHotUpdateServiceImpl iHotUpdateServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iHotUpdateServiceImpl);
    }

    private void $constructor(IHotUpdateServiceImpl iHotUpdateServiceImpl) {
        if (iHotUpdateServiceImpl != null) {
            this.mControl = iHotUpdateServiceImpl;
            this.mTargetId = String.format("HotUpdateService_%s_%d", String.valueOf(IHotUpdateServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IHotUpdateServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IHotUpdateServiceImpl iHotUpdateServiceImpl = this.mControl;
        if (iHotUpdateServiceImpl != null) {
            return iHotUpdateServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IHotUpdateServiceImpl iHotUpdateServiceImpl = this.mControl;
        if (iHotUpdateServiceImpl != null) {
            return iHotUpdateServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IHotUpdateServiceImpl iHotUpdateServiceImpl = this.mControl;
        if (iHotUpdateServiceImpl != null) {
            iHotUpdateServiceImpl.onCreate();
        }
    }

    public int init() {
        IHotUpdateServiceImpl iHotUpdateServiceImpl = this.mControl;
        if (iHotUpdateServiceImpl != null) {
            return iHotUpdateServiceImpl.init();
        }
        return Integer.MIN_VALUE;
    }

    public void unInit() {
        IHotUpdateServiceImpl iHotUpdateServiceImpl = this.mControl;
        if (iHotUpdateServiceImpl != null) {
            iHotUpdateServiceImpl.unInit();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IHotUpdateServiceImpl iHotUpdateServiceImpl = this.mControl;
        if (iHotUpdateServiceImpl != null) {
            return iHotUpdateServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public String getVersion() {
        IHotUpdateServiceImpl iHotUpdateServiceImpl = this.mControl;
        if (iHotUpdateServiceImpl != null) {
            return iHotUpdateServiceImpl.getVersion();
        }
        return null;
    }

    public void logSwitch(int i) {
        IHotUpdateServiceImpl iHotUpdateServiceImpl = this.mControl;
        if (iHotUpdateServiceImpl != null) {
            iHotUpdateServiceImpl.logSwitch(i);
        }
    }

    public DetailListParser initDataFill(String str) {
        DetailListParserImpl initDataFill;
        TypeHelper typeHelper;
        try {
            Method method = HotUpdateService.class.getMethod("initDataFill", String.class);
            IHotUpdateServiceImpl iHotUpdateServiceImpl = this.mControl;
            if (iHotUpdateServiceImpl == null || (initDataFill = iHotUpdateServiceImpl.initDataFill(str)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (DetailListParser) typeHelper.transfer(method, -1, (Object) initDataFill, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void abortRequestMapNum() {
        IHotUpdateServiceImpl iHotUpdateServiceImpl = this.mControl;
        if (iHotUpdateServiceImpl != null) {
            iHotUpdateServiceImpl.abortRequestMapNum();
        }
    }

    public int requestMapNum(MapNum mapNum, IMapNumObserver iMapNumObserver) {
        TypeHelper typeHelper;
        try {
            Method method = HotUpdateService.class.getMethod("requestMapNum", MapNum.class, IMapNumObserver.class);
            IMapNumObserverImpl iMapNumObserverImpl = null;
            if (iMapNumObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iMapNumObserverImpl = (IMapNumObserverImpl) typeHelper.transfer(method, 1, iMapNumObserver);
            }
            IHotUpdateServiceImpl iHotUpdateServiceImpl = this.mControl;
            if (iHotUpdateServiceImpl != null) {
                return iHotUpdateServiceImpl.requestMapNum(mapNum, iMapNumObserverImpl);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public void abortRequestHotUpdate(int i) {
        IHotUpdateServiceImpl iHotUpdateServiceImpl = this.mControl;
        if (iHotUpdateServiceImpl != null) {
            iHotUpdateServiceImpl.abortRequestHotUpdate(i);
        }
    }

    public int requestCheckHotUpdate(HotUpdateCheckParam hotUpdateCheckParam, IHotUpdateCheckObserver iHotUpdateCheckObserver) {
        TypeHelper typeHelper;
        try {
            Method method = HotUpdateService.class.getMethod("requestCheckHotUpdate", HotUpdateCheckParam.class, IHotUpdateCheckObserver.class);
            IHotUpdateCheckObserverImpl iHotUpdateCheckObserverImpl = null;
            if (iHotUpdateCheckObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iHotUpdateCheckObserverImpl = (IHotUpdateCheckObserverImpl) typeHelper.transfer(method, 1, iHotUpdateCheckObserver);
            }
            IHotUpdateServiceImpl iHotUpdateServiceImpl = this.mControl;
            if (iHotUpdateServiceImpl != null) {
                return iHotUpdateServiceImpl.requestCheckHotUpdate(hotUpdateCheckParam, iHotUpdateCheckObserverImpl);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int requestHotUpdateFile(@HotUpdateFileType.HotUpdateFileType1 int i, String str, IHotUpdateFileObserver iHotUpdateFileObserver) {
        TypeHelper typeHelper;
        try {
            Method method = HotUpdateService.class.getMethod("requestHotUpdateFile", Integer.TYPE, String.class, IHotUpdateFileObserver.class);
            IHotUpdateFileObserverImpl iHotUpdateFileObserverImpl = null;
            if (iHotUpdateFileObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iHotUpdateFileObserverImpl = (IHotUpdateFileObserverImpl) typeHelper.transfer(method, 2, iHotUpdateFileObserver);
            }
            IHotUpdateServiceImpl iHotUpdateServiceImpl = this.mControl;
            if (iHotUpdateServiceImpl != null) {
                return iHotUpdateServiceImpl.requestHotUpdateFile(i, str, iHotUpdateFileObserverImpl);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int saveHotUpdateFile(@HotUpdateFileType.HotUpdateFileType1 int i, String str) {
        IHotUpdateServiceImpl iHotUpdateServiceImpl = this.mControl;
        if (iHotUpdateServiceImpl != null) {
            return iHotUpdateServiceImpl.saveHotUpdateFile(i, str);
        }
        return Integer.MIN_VALUE;
    }

    public int resetFileVersion(@HotUpdateFileType.HotUpdateFileType1 int i) {
        IHotUpdateServiceImpl iHotUpdateServiceImpl = this.mControl;
        if (iHotUpdateServiceImpl != null) {
            return iHotUpdateServiceImpl.resetFileVersion(i);
        }
        return Integer.MIN_VALUE;
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
