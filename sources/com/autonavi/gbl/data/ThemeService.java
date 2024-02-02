package com.autonavi.gbl.data;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.impl.IThemeServiceImpl;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.model.OperationType;
import com.autonavi.gbl.data.model.Theme;
import com.autonavi.gbl.data.model.ThemeInitConfig;
import com.autonavi.gbl.data.observer.IDataInitObserver;
import com.autonavi.gbl.data.observer.IDataListObserver;
import com.autonavi.gbl.data.observer.IDownloadObserver;
import com.autonavi.gbl.data.observer.IImageObserver;
import com.autonavi.gbl.data.observer.impl.IDataInitObserverImpl;
import com.autonavi.gbl.data.observer.impl.IDataListObserverImpl;
import com.autonavi.gbl.data.observer.impl.IDownloadObserverImpl;
import com.autonavi.gbl.data.observer.impl.IImageObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IThemeServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class ThemeService implements IService {
    private static String PACKAGE = ReflexTool.PN(ThemeService.class);
    private IThemeServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected ThemeService(long j, boolean z) {
        this((IThemeServiceImpl) ReflexTool.invokeDeclConstructorSafe(IThemeServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(ThemeService.class, this, this.mControl);
        }
    }

    public ThemeService(IThemeServiceImpl iThemeServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iThemeServiceImpl);
    }

    private void $constructor(IThemeServiceImpl iThemeServiceImpl) {
        if (iThemeServiceImpl != null) {
            this.mControl = iThemeServiceImpl;
            this.mTargetId = String.format("ThemeService_%s_%d", String.valueOf(IThemeServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IThemeServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IThemeServiceImpl iThemeServiceImpl = this.mControl;
        if (iThemeServiceImpl != null) {
            return iThemeServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IThemeServiceImpl iThemeServiceImpl = this.mControl;
        if (iThemeServiceImpl != null) {
            return iThemeServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IThemeServiceImpl iThemeServiceImpl = this.mControl;
        if (iThemeServiceImpl != null) {
            iThemeServiceImpl.onCreate();
        }
    }

    public Theme getTheme(@DownLoadMode.DownLoadMode1 int i, int i2) {
        IThemeServiceImpl iThemeServiceImpl = this.mControl;
        if (iThemeServiceImpl != null) {
            return iThemeServiceImpl.getTheme(i, i2);
        }
        return null;
    }

    public Theme getTheme(@DownLoadMode.DownLoadMode1 int i, String str) {
        IThemeServiceImpl iThemeServiceImpl = this.mControl;
        if (iThemeServiceImpl != null) {
            return iThemeServiceImpl.getTheme(i, str);
        }
        return null;
    }

    public int init(ThemeInitConfig themeInitConfig, IDataInitObserver iDataInitObserver) {
        try {
            Method method = ThemeService.class.getMethod("init", ThemeInitConfig.class, IDataInitObserver.class);
            if (iDataInitObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IDataInitObserverImpl) typeHelper.transfer(method, 1, iDataInitObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.ThemeService.1
                    }));
                    return 0;
                }
            }
            IThemeServiceImpl iThemeServiceImpl = this.mControl;
            if (iThemeServiceImpl != null) {
                return iThemeServiceImpl.init(themeInitConfig, r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IThemeServiceImpl iThemeServiceImpl = this.mControl;
        if (iThemeServiceImpl != null) {
            return iThemeServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public void unInit() {
        IThemeServiceImpl iThemeServiceImpl = this.mControl;
        if (iThemeServiceImpl != null) {
            iThemeServiceImpl.unInit();
        }
    }

    public String getVersion() {
        IThemeServiceImpl iThemeServiceImpl = this.mControl;
        if (iThemeServiceImpl != null) {
            return iThemeServiceImpl.getVersion();
        }
        return null;
    }

    public int requestDataListCheck(@DownLoadMode.DownLoadMode1 int i, String str, IDataListObserver iDataListObserver) {
        try {
            Method method = ThemeService.class.getMethod("requestDataListCheck", Integer.TYPE, String.class, IDataListObserver.class);
            if (iDataListObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IDataListObserverImpl) typeHelper.transfer(method, 2, iDataListObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.ThemeService.2
                    }));
                    return 0;
                }
            }
            IThemeServiceImpl iThemeServiceImpl = this.mControl;
            if (iThemeServiceImpl != null) {
                return iThemeServiceImpl.requestDataListCheck(i, str, r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public void abortRequestDataListCheck(@DownLoadMode.DownLoadMode1 int i) {
        IThemeServiceImpl iThemeServiceImpl = this.mControl;
        if (iThemeServiceImpl != null) {
            iThemeServiceImpl.abortRequestDataListCheck(i);
        }
    }

    public ArrayList<Integer> getThemeIdList(@DownLoadMode.DownLoadMode1 int i) {
        IThemeServiceImpl iThemeServiceImpl = this.mControl;
        if (iThemeServiceImpl != null) {
            return iThemeServiceImpl.getThemeIdList(i);
        }
        return null;
    }

    public ArrayList<Integer> getThemeIdList(@DownLoadMode.DownLoadMode1 int i, String str) {
        IThemeServiceImpl iThemeServiceImpl = this.mControl;
        if (iThemeServiceImpl != null) {
            return iThemeServiceImpl.getThemeIdList(i, str);
        }
        return null;
    }

    public ArrayList<Theme> getThemeList(@DownLoadMode.DownLoadMode1 int i) {
        IThemeServiceImpl iThemeServiceImpl = this.mControl;
        if (iThemeServiceImpl != null) {
            return iThemeServiceImpl.getThemeList(i);
        }
        return null;
    }

    public ArrayList<Theme> getThemeList(@DownLoadMode.DownLoadMode1 int i, String str) {
        IThemeServiceImpl iThemeServiceImpl = this.mControl;
        if (iThemeServiceImpl != null) {
            return iThemeServiceImpl.getThemeList(i, str);
        }
        return null;
    }

    public int addNetDownloadObserver(IDownloadObserver iDownloadObserver) {
        try {
            Method method = ThemeService.class.getMethod("addNetDownloadObserver", IDownloadObserver.class);
            if (iDownloadObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IDownloadObserverImpl) typeHelper.transfer(method, 0, iDownloadObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.ThemeService.3
                    }));
                    return 0;
                }
            }
            IThemeServiceImpl iThemeServiceImpl = this.mControl;
            if (iThemeServiceImpl != null) {
                return iThemeServiceImpl.addNetDownloadObserver(r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int removeNetDownloadObserver(IDownloadObserver iDownloadObserver) {
        try {
            Method method = ThemeService.class.getMethod("removeNetDownloadObserver", IDownloadObserver.class);
            if (iDownloadObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IDownloadObserverImpl) typeHelper.transfer(method, 0, iDownloadObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.ThemeService.4
                    }));
                    return 0;
                }
            }
            IThemeServiceImpl iThemeServiceImpl = this.mControl;
            if (iThemeServiceImpl != null) {
                return iThemeServiceImpl.removeNetDownloadObserver(r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public void operate(@DownLoadMode.DownLoadMode1 int i, @OperationType.OperationType1 int i2, ArrayList<Integer> arrayList) {
        IThemeServiceImpl iThemeServiceImpl = this.mControl;
        if (iThemeServiceImpl != null) {
            iThemeServiceImpl.operate(i, i2, arrayList);
        }
    }

    public void operateWorkingQueue(@DownLoadMode.DownLoadMode1 int i, @OperationType.OperationType1 int i2) {
        IThemeServiceImpl iThemeServiceImpl = this.mControl;
        if (iThemeServiceImpl != null) {
            iThemeServiceImpl.operateWorkingQueue(i, i2);
        }
    }

    public int requestDataImage(@DownLoadMode.DownLoadMode1 int i, int i2, IImageObserver iImageObserver) {
        try {
            Method method = ThemeService.class.getMethod("requestDataImage", Integer.TYPE, Integer.TYPE, IImageObserver.class);
            if (iImageObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IImageObserverImpl) typeHelper.transfer(method, 2, iImageObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.ThemeService.5
                    }));
                    return 0;
                }
            }
            IThemeServiceImpl iThemeServiceImpl = this.mControl;
            if (iThemeServiceImpl != null) {
                return iThemeServiceImpl.requestDataImage(i, i2, r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public void abortRequestDataImage(@DownLoadMode.DownLoadMode1 int i, int i2) {
        IThemeServiceImpl iThemeServiceImpl = this.mControl;
        if (iThemeServiceImpl != null) {
            iThemeServiceImpl.abortRequestDataImage(i, i2);
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.ThemeService.6
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.ThemeService.7
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.ThemeService.8
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
