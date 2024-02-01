package com.autonavi.gbl.multi.display.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.multi.display.MultiDisplayService;
import com.autonavi.gbl.multi.display.model.DisplayCreateParam;
import com.autonavi.gbl.multi.display.model.DisplayType;
import com.autonavi.gbl.multi.display.observer.impl.IRemoteDisplayObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.util.ArrayList;
@IntfAuto(target = MultiDisplayService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IMultiDisplayServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IMultiDisplayServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native boolean addObserverNative(long j, IMultiDisplayServiceImpl iMultiDisplayServiceImpl, long j2, IRemoteDisplayObserverImpl iRemoteDisplayObserverImpl);

    private static native long createDisplayNative(long j, IMultiDisplayServiceImpl iMultiDisplayServiceImpl, long j2, DisplayCreateParam displayCreateParam);

    private static native void destroyDisplayNative(long j, IMultiDisplayServiceImpl iMultiDisplayServiceImpl, long j2, IDisplayImpl iDisplayImpl);

    private static native void destroyNativeObj(long j);

    private static native long[] getAllDisplaysNative(long j, IMultiDisplayServiceImpl iMultiDisplayServiceImpl);

    private static native long getDisplay1Native(long j, IMultiDisplayServiceImpl iMultiDisplayServiceImpl, long j2);

    private static native long getDisplay2Native(long j, IMultiDisplayServiceImpl iMultiDisplayServiceImpl, String str);

    private static native long getDisplayNative(long j, IMultiDisplayServiceImpl iMultiDisplayServiceImpl, int i);

    private static native int isInitNative(long j, IMultiDisplayServiceImpl iMultiDisplayServiceImpl);

    private static native boolean removeObserverNative(long j, IMultiDisplayServiceImpl iMultiDisplayServiceImpl, long j2, IRemoteDisplayObserverImpl iRemoteDisplayObserverImpl);

    private static native void unInitNative(long j, IMultiDisplayServiceImpl iMultiDisplayServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IMultiDisplayServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IMultiDisplayServiceImpl) && getUID(this) == getUID((IMultiDisplayServiceImpl) obj);
    }

    private static long getUID(IMultiDisplayServiceImpl iMultiDisplayServiceImpl) {
        long cPtr = getCPtr(iMultiDisplayServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IMultiDisplayServiceImpl iMultiDisplayServiceImpl) {
        if (iMultiDisplayServiceImpl == null) {
            return 0L;
        }
        return iMultiDisplayServiceImpl.swigCPtr;
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

    public IDisplayImpl createDisplay(DisplayCreateParam displayCreateParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createDisplayNative = createDisplayNative(j, this, 0L, displayCreateParam);
        if (createDisplayNative == 0) {
            return null;
        }
        return new IDisplayImpl(createDisplayNative, false);
    }

    public void destroyDisplay(IDisplayImpl iDisplayImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        destroyDisplayNative(j, this, IDisplayImpl.getCPtr(iDisplayImpl), iDisplayImpl);
    }

    public IDisplayImpl getDisplay(@DisplayType.DisplayType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long displayNative = getDisplayNative(j, this, i);
        if (displayNative == 0) {
            return null;
        }
        return new IDisplayImpl(displayNative, false);
    }

    public IDisplayImpl getDisplay(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        long display1Native = getDisplay1Native(j2, this, j);
        if (display1Native == 0) {
            return null;
        }
        return new IDisplayImpl(display1Native, false);
    }

    public IDisplayImpl getDisplay(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long display2Native = getDisplay2Native(j, this, str);
        if (display2Native == 0) {
            return null;
        }
        return new IDisplayImpl(display2Native, false);
    }

    public ArrayList<IDisplayImpl> getAllDisplays() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        ArrayList<IDisplayImpl> arrayList = null;
        long[] allDisplaysNative = getAllDisplaysNative(j, this);
        if (allDisplaysNative != null) {
            arrayList = new ArrayList<>();
            for (long j2 : allDisplaysNative) {
                arrayList.add(new IDisplayImpl(j2, false));
            }
        }
        return arrayList;
    }

    public boolean addObserver(IRemoteDisplayObserverImpl iRemoteDisplayObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addObserverNative(j, this, IRemoteDisplayObserverImpl.getCPtr(iRemoteDisplayObserverImpl), iRemoteDisplayObserverImpl);
    }

    public boolean removeObserver(IRemoteDisplayObserverImpl iRemoteDisplayObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeObserverNative(j, this, IRemoteDisplayObserverImpl.getCPtr(iRemoteDisplayObserverImpl), iRemoteDisplayObserverImpl);
    }
}
