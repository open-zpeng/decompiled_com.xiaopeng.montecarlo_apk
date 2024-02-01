package com.autonavi.gbl.data.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.ThemeService;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.model.OperationType;
import com.autonavi.gbl.data.model.Theme;
import com.autonavi.gbl.data.model.ThemeInitConfig;
import com.autonavi.gbl.data.observer.impl.IDataInitObserverImpl;
import com.autonavi.gbl.data.observer.impl.IDataListObserverImpl;
import com.autonavi.gbl.data.observer.impl.IDownloadObserverImpl;
import com.autonavi.gbl.data.observer.impl.IImageObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.util.ArrayList;
@IntfAuto(target = ThemeService.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IThemeServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IThemeServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void abortRequestDataImageNative(long j, IThemeServiceImpl iThemeServiceImpl, int i, int i2);

    private static native void abortRequestDataListCheckNative(long j, IThemeServiceImpl iThemeServiceImpl, int i);

    private static native int addNetDownloadObserverNative(long j, IThemeServiceImpl iThemeServiceImpl, long j2, IDownloadObserverImpl iDownloadObserverImpl);

    private static native void destroyNativeObj(long j);

    private static native boolean getTheme1Native(long j, IThemeServiceImpl iThemeServiceImpl, int i, String str, long j2, Theme theme);

    private static native ArrayList<Integer> getThemeIdList1Native(long j, IThemeServiceImpl iThemeServiceImpl, int i, String str);

    private static native ArrayList<Integer> getThemeIdListNative(long j, IThemeServiceImpl iThemeServiceImpl, int i);

    private static native ArrayList<Theme> getThemeList1Native(long j, IThemeServiceImpl iThemeServiceImpl, int i, String str);

    private static native ArrayList<Theme> getThemeListNative(long j, IThemeServiceImpl iThemeServiceImpl, int i);

    private static native boolean getThemeNative(long j, IThemeServiceImpl iThemeServiceImpl, int i, int i2, long j2, Theme theme);

    private static native String getVersionNative(long j, IThemeServiceImpl iThemeServiceImpl);

    private static native int initNative(long j, IThemeServiceImpl iThemeServiceImpl, long j2, ThemeInitConfig themeInitConfig, long j3, IDataInitObserverImpl iDataInitObserverImpl);

    private static native int isInitNative(long j, IThemeServiceImpl iThemeServiceImpl);

    private static native void operateNative(long j, IThemeServiceImpl iThemeServiceImpl, int i, int i2, ArrayList<Integer> arrayList);

    private static native void operateWorkingQueueNative(long j, IThemeServiceImpl iThemeServiceImpl, int i, int i2);

    private static native int removeNetDownloadObserverNative(long j, IThemeServiceImpl iThemeServiceImpl, long j2, IDownloadObserverImpl iDownloadObserverImpl);

    private static native int requestDataImageNative(long j, IThemeServiceImpl iThemeServiceImpl, int i, int i2, long j2, IImageObserverImpl iImageObserverImpl);

    private static native int requestDataListCheckNative(long j, IThemeServiceImpl iThemeServiceImpl, int i, String str, long j2, IDataListObserverImpl iDataListObserverImpl);

    private static native void unInitNative(long j, IThemeServiceImpl iThemeServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IThemeServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IThemeServiceImpl) && getUID(this) == getUID((IThemeServiceImpl) obj);
    }

    private static long getUID(IThemeServiceImpl iThemeServiceImpl) {
        long cPtr = getCPtr(iThemeServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IThemeServiceImpl iThemeServiceImpl) {
        if (iThemeServiceImpl == null) {
            return 0L;
        }
        return iThemeServiceImpl.swigCPtr;
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

    public int init(ThemeInitConfig themeInitConfig, IDataInitObserverImpl iDataInitObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, 0L, themeInitConfig, IDataInitObserverImpl.getCPtr(iDataInitObserverImpl), iDataInitObserverImpl);
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

    public void unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInitNative(j, this);
    }

    public String getVersion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVersionNative(j, this);
    }

    public int requestDataListCheck(@DownLoadMode.DownLoadMode1 int i, String str, IDataListObserverImpl iDataListObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestDataListCheckNative(j, this, i, str, IDataListObserverImpl.getCPtr(iDataListObserverImpl), iDataListObserverImpl);
    }

    public void abortRequestDataListCheck(@DownLoadMode.DownLoadMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        abortRequestDataListCheckNative(j, this, i);
    }

    public Theme getTheme(@DownLoadMode.DownLoadMode1 int i, int i2) {
        Theme theme = new Theme();
        if (Boolean.valueOf(getTheme(i, i2, theme)).booleanValue()) {
            return theme;
        }
        return null;
    }

    private boolean getTheme(@DownLoadMode.DownLoadMode1 int i, int i2, Theme theme) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getThemeNative(j, this, i, i2, 0L, theme);
    }

    public Theme getTheme(@DownLoadMode.DownLoadMode1 int i, String str) {
        Theme theme = new Theme();
        if (Boolean.valueOf(getTheme(i, str, theme)).booleanValue()) {
            return theme;
        }
        return null;
    }

    private boolean getTheme(@DownLoadMode.DownLoadMode1 int i, String str, Theme theme) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTheme1Native(j, this, i, str, 0L, theme);
    }

    public ArrayList<Integer> getThemeIdList(@DownLoadMode.DownLoadMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getThemeIdListNative(j, this, i);
    }

    public ArrayList<Integer> getThemeIdList(@DownLoadMode.DownLoadMode1 int i, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getThemeIdList1Native(j, this, i, str);
    }

    public ArrayList<Theme> getThemeList(@DownLoadMode.DownLoadMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getThemeListNative(j, this, i);
    }

    public ArrayList<Theme> getThemeList(@DownLoadMode.DownLoadMode1 int i, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getThemeList1Native(j, this, i, str);
    }

    public int addNetDownloadObserver(IDownloadObserverImpl iDownloadObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addNetDownloadObserverNative(j, this, IDownloadObserverImpl.getCPtr(iDownloadObserverImpl), iDownloadObserverImpl);
    }

    public int removeNetDownloadObserver(IDownloadObserverImpl iDownloadObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeNetDownloadObserverNative(j, this, IDownloadObserverImpl.getCPtr(iDownloadObserverImpl), iDownloadObserverImpl);
    }

    public void operate(@DownLoadMode.DownLoadMode1 int i, @OperationType.OperationType1 int i2, ArrayList<Integer> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        operateNative(j, this, i, i2, arrayList);
    }

    public void operateWorkingQueue(@DownLoadMode.DownLoadMode1 int i, @OperationType.OperationType1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        operateWorkingQueueNative(j, this, i, i2);
    }

    public int requestDataImage(@DownLoadMode.DownLoadMode1 int i, int i2, IImageObserverImpl iImageObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestDataImageNative(j, this, i, i2, IImageObserverImpl.getCPtr(iImageObserverImpl), iImageObserverImpl);
    }

    public void abortRequestDataImage(@DownLoadMode.DownLoadMode1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        abortRequestDataImageNative(j, this, i, i2);
    }
}
