package com.autonavi.gbl.multi.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.consis.impl.IChannelMsgSyncControllerImpl;
import com.autonavi.gbl.consis.observer.impl.IChannelConnectObserverImpl;
import com.autonavi.gbl.consis.observer.impl.IChannelMsgObserverImpl;
import com.autonavi.gbl.consis.observer.impl.IChannelMsgTransferImpl;
import com.autonavi.gbl.consis.observer.impl.IChannelTransProxyImpl;
import com.autonavi.gbl.map.model.DeviceAttribute;
import com.autonavi.gbl.map.model.EGLSurfaceAttr;
import com.autonavi.gbl.map.observer.impl.IBLMapViewProxyImpl;
import com.autonavi.gbl.multi.KldDisplayService;
import com.autonavi.gbl.multi.model.DisplayAttr;
import com.autonavi.gbl.multi.model.DisplayType;
import com.autonavi.gbl.multi.observer.impl.IKldDisplayDataProviderImpl;
import com.autonavi.gbl.multi.observer.impl.IKldDisplayObserverImpl;
import com.autonavi.gbl.multi.observer.impl.IKldRemoteDispObserverImpl;
import com.autonavi.gbl.multi.observer.impl.IKldSceneObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.util.ArrayList;
@IntfAuto(target = KldDisplayService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IKldDisplayServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IKldDisplayServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native int appendChannelTransProxyNative(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, long j2, IChannelTransProxyImpl iChannelTransProxyImpl);

    private static native long createDisplay1Native(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, int i, long j2, DisplayAttr displayAttr, long j3, DeviceAttribute deviceAttribute, long j4, EGLSurfaceAttr eGLSurfaceAttr, long j5, IKldDisplayObserverImpl iKldDisplayObserverImpl, long j6, IBLMapViewProxyImpl iBLMapViewProxyImpl);

    private static native long createDisplay2Native(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, int i, long j2, DisplayAttr displayAttr, long j3, DeviceAttribute deviceAttribute, long j4, EGLSurfaceAttr eGLSurfaceAttr, long j5, IKldDisplayObserverImpl iKldDisplayObserverImpl);

    private static native long createDisplayNative(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, int i, long j2, DisplayAttr displayAttr, long j3, IKldDisplayDataProviderImpl iKldDisplayDataProviderImpl, long j4, IKldDisplayObserverImpl iKldDisplayObserverImpl);

    private static native long createMainDisplay1Native(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, long j2, DisplayAttr displayAttr, long j3, DeviceAttribute deviceAttribute, long j4, EGLSurfaceAttr eGLSurfaceAttr, long j5, IKldDisplayObserverImpl iKldDisplayObserverImpl, long j6, IKldSceneObserverImpl iKldSceneObserverImpl);

    private static native long createMainDisplay2Native(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, long j2, DisplayAttr displayAttr, long j3, IKldDisplayDataProviderImpl iKldDisplayDataProviderImpl, long j4, IKldDisplayObserverImpl iKldDisplayObserverImpl);

    private static native long createMainDisplayNative(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, long j2, DisplayAttr displayAttr, long j3, DeviceAttribute deviceAttribute, long j4, EGLSurfaceAttr eGLSurfaceAttr, long j5, IKldDisplayObserverImpl iKldDisplayObserverImpl, long j6, IKldSceneObserverImpl iKldSceneObserverImpl, long j7, IBLMapViewProxyImpl iBLMapViewProxyImpl);

    private static native void destroyAllDisplaysNative(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl);

    private static native void destroyDisplayNative(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, long j2, IKldDisplayImpl iKldDisplayImpl);

    private static native void destroyNativeObj(long j);

    private static native long getDisplayByIdNative(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, long j2);

    private static native long getDisplayByNameNative(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, String str);

    private static native long getDisplayByTypeNative(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, int i);

    private static native void getDisplayListsNative(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, ArrayList<IKldDisplayImpl> arrayList);

    private static native void getDisplayNameByTypeNative(int i, String[] strArr);

    private static native int getDisplayTypeByNameNative(String str);

    private static native int init1Native(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, boolean z, String str, int i);

    private static native int initNative(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, boolean z, boolean z2);

    private static native int isInitNative(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl);

    private static native int removeChannelProxyNative(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, long j2, IChannelTransProxyImpl iChannelTransProxyImpl);

    private static native boolean sendCustomDataNative(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, long j2, ChannelParcelImpl channelParcelImpl, long j3, IChannelTransProxyImpl iChannelTransProxyImpl);

    private static native void setChannelConnectObserverNative(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, long j2, IChannelConnectObserverImpl iChannelConnectObserverImpl);

    private static native long setDataTransferNative(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, long j2, IChannelMsgTransferImpl iChannelMsgTransferImpl);

    private static native boolean setExtraDataReceiverNative(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, long j2, IChannelMsgObserverImpl iChannelMsgObserverImpl);

    private static native boolean setExtraDataSenderNative(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, long j2, IChannelMsgObserverImpl iChannelMsgObserverImpl);

    private static native void setRemoteDisplayObserverNative(long j, IKldDisplayServiceImpl iKldDisplayServiceImpl, long j2, IKldRemoteDispObserverImpl iKldRemoteDispObserverImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IKldDisplayServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IKldDisplayServiceImpl) && getUID(this) == getUID((IKldDisplayServiceImpl) obj);
    }

    private static long getUID(IKldDisplayServiceImpl iKldDisplayServiceImpl) {
        long cPtr = getCPtr(iKldDisplayServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IKldDisplayServiceImpl iKldDisplayServiceImpl) {
        if (iKldDisplayServiceImpl == null) {
            return 0L;
        }
        return iKldDisplayServiceImpl.swigCPtr;
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

    public static String getDisplayNameByType(@DisplayType.DisplayType1 int i) {
        String[] strArr = new String[1];
        getDisplayNameByType(i, strArr);
        return strArr[0];
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

    public IKldDisplayImpl createMainDisplay(DisplayAttr displayAttr, DeviceAttribute deviceAttribute, EGLSurfaceAttr eGLSurfaceAttr, IKldDisplayObserverImpl iKldDisplayObserverImpl, IKldSceneObserverImpl iKldSceneObserverImpl, IBLMapViewProxyImpl iBLMapViewProxyImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createMainDisplayNative = createMainDisplayNative(j, this, 0L, displayAttr, 0L, deviceAttribute, 0L, eGLSurfaceAttr, IKldDisplayObserverImpl.getCPtr(iKldDisplayObserverImpl), iKldDisplayObserverImpl, IKldSceneObserverImpl.getCPtr(iKldSceneObserverImpl), iKldSceneObserverImpl, IBLMapViewProxyImpl.getCPtr(iBLMapViewProxyImpl), iBLMapViewProxyImpl);
        if (createMainDisplayNative == 0) {
            return null;
        }
        return new IKldDisplayImpl(createMainDisplayNative, false);
    }

    public IKldDisplayImpl createMainDisplay(DisplayAttr displayAttr, DeviceAttribute deviceAttribute, EGLSurfaceAttr eGLSurfaceAttr, IKldDisplayObserverImpl iKldDisplayObserverImpl, IKldSceneObserverImpl iKldSceneObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createMainDisplay1Native = createMainDisplay1Native(j, this, 0L, displayAttr, 0L, deviceAttribute, 0L, eGLSurfaceAttr, IKldDisplayObserverImpl.getCPtr(iKldDisplayObserverImpl), iKldDisplayObserverImpl, IKldSceneObserverImpl.getCPtr(iKldSceneObserverImpl), iKldSceneObserverImpl);
        if (createMainDisplay1Native == 0) {
            return null;
        }
        return new IKldDisplayImpl(createMainDisplay1Native, false);
    }

    public IKldDisplayImpl createMainDisplay(DisplayAttr displayAttr, IKldDisplayDataProviderImpl iKldDisplayDataProviderImpl, IKldDisplayObserverImpl iKldDisplayObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createMainDisplay2Native = createMainDisplay2Native(j, this, 0L, displayAttr, IKldDisplayDataProviderImpl.getCPtr(iKldDisplayDataProviderImpl), iKldDisplayDataProviderImpl, IKldDisplayObserverImpl.getCPtr(iKldDisplayObserverImpl), iKldDisplayObserverImpl);
        if (createMainDisplay2Native == 0) {
            return null;
        }
        return new IKldDisplayImpl(createMainDisplay2Native, false);
    }

    public IKldDisplayImpl createDisplay(@DisplayType.DisplayType1 int i, DisplayAttr displayAttr, IKldDisplayDataProviderImpl iKldDisplayDataProviderImpl, IKldDisplayObserverImpl iKldDisplayObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createDisplayNative = createDisplayNative(j, this, i, 0L, displayAttr, IKldDisplayDataProviderImpl.getCPtr(iKldDisplayDataProviderImpl), iKldDisplayDataProviderImpl, IKldDisplayObserverImpl.getCPtr(iKldDisplayObserverImpl), iKldDisplayObserverImpl);
        if (createDisplayNative == 0) {
            return null;
        }
        return new IKldDisplayImpl(createDisplayNative, false);
    }

    public IKldDisplayImpl createDisplay(@DisplayType.DisplayType1 int i, DisplayAttr displayAttr, DeviceAttribute deviceAttribute, EGLSurfaceAttr eGLSurfaceAttr, IKldDisplayObserverImpl iKldDisplayObserverImpl, IBLMapViewProxyImpl iBLMapViewProxyImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createDisplay1Native = createDisplay1Native(j, this, i, 0L, displayAttr, 0L, deviceAttribute, 0L, eGLSurfaceAttr, IKldDisplayObserverImpl.getCPtr(iKldDisplayObserverImpl), iKldDisplayObserverImpl, IBLMapViewProxyImpl.getCPtr(iBLMapViewProxyImpl), iBLMapViewProxyImpl);
        if (createDisplay1Native == 0) {
            return null;
        }
        return new IKldDisplayImpl(createDisplay1Native, false);
    }

    public IKldDisplayImpl createDisplay(@DisplayType.DisplayType1 int i, DisplayAttr displayAttr, DeviceAttribute deviceAttribute, EGLSurfaceAttr eGLSurfaceAttr, IKldDisplayObserverImpl iKldDisplayObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createDisplay2Native = createDisplay2Native(j, this, i, 0L, displayAttr, 0L, deviceAttribute, 0L, eGLSurfaceAttr, IKldDisplayObserverImpl.getCPtr(iKldDisplayObserverImpl), iKldDisplayObserverImpl);
        if (createDisplay2Native == 0) {
            return null;
        }
        return new IKldDisplayImpl(createDisplay2Native, false);
    }

    public void destroyDisplay(IKldDisplayImpl iKldDisplayImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        destroyDisplayNative(j, this, IKldDisplayImpl.getCPtr(iKldDisplayImpl), iKldDisplayImpl);
    }

    public void destroyAllDisplays() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        destroyAllDisplaysNative(j, this);
    }

    public void setRemoteDisplayObserver(IKldRemoteDispObserverImpl iKldRemoteDispObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRemoteDisplayObserverNative(j, this, IKldRemoteDispObserverImpl.getCPtr(iKldRemoteDispObserverImpl), iKldRemoteDispObserverImpl);
    }

    public int init(boolean z, boolean z2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, z, z2);
    }

    public int init(boolean z, String str, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return init1Native(j, this, z, str, i);
    }

    public IKldDisplayImpl getDisplayByType(@DisplayType.DisplayType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long displayByTypeNative = getDisplayByTypeNative(j, this, i);
        if (displayByTypeNative == 0) {
            return null;
        }
        return new IKldDisplayImpl(displayByTypeNative, false);
    }

    public IKldDisplayImpl getDisplayById(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        long displayByIdNative = getDisplayByIdNative(j2, this, j);
        if (displayByIdNative == 0) {
            return null;
        }
        return new IKldDisplayImpl(displayByIdNative, false);
    }

    public IKldDisplayImpl getDisplayByName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long displayByNameNative = getDisplayByNameNative(j, this, str);
        if (displayByNameNative == 0) {
            return null;
        }
        return new IKldDisplayImpl(displayByNameNative, false);
    }

    private void getDisplayLists(ArrayList<IKldDisplayImpl> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getDisplayListsNative(j, this, arrayList);
    }

    @DisplayType.DisplayType1
    public static int getDisplayTypeByName(String str) {
        return getDisplayTypeByNameNative(str);
    }

    private static void getDisplayNameByType(@DisplayType.DisplayType1 int i, String[] strArr) {
        getDisplayNameByTypeNative(i, strArr);
    }

    public int appendChannelTransProxy(IChannelTransProxyImpl iChannelTransProxyImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return appendChannelTransProxyNative(j, this, IChannelTransProxyImpl.getCPtr(iChannelTransProxyImpl), iChannelTransProxyImpl);
    }

    public int removeChannelProxy(IChannelTransProxyImpl iChannelTransProxyImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeChannelProxyNative(j, this, IChannelTransProxyImpl.getCPtr(iChannelTransProxyImpl), iChannelTransProxyImpl);
    }

    public boolean setExtraDataSender(IChannelMsgObserverImpl iChannelMsgObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setExtraDataSenderNative(j, this, IChannelMsgObserverImpl.getCPtr(iChannelMsgObserverImpl), iChannelMsgObserverImpl);
    }

    public boolean setExtraDataReceiver(IChannelMsgObserverImpl iChannelMsgObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setExtraDataReceiverNative(j, this, IChannelMsgObserverImpl.getCPtr(iChannelMsgObserverImpl), iChannelMsgObserverImpl);
    }

    public IChannelMsgSyncControllerImpl setDataTransfer(IChannelMsgTransferImpl iChannelMsgTransferImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long dataTransferNative = setDataTransferNative(j, this, IChannelMsgTransferImpl.getCPtr(iChannelMsgTransferImpl), iChannelMsgTransferImpl);
        if (dataTransferNative == 0) {
            return null;
        }
        return new IChannelMsgSyncControllerImpl(dataTransferNative, false);
    }

    public void setChannelConnectObserver(IChannelConnectObserverImpl iChannelConnectObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setChannelConnectObserverNative(j, this, IChannelConnectObserverImpl.getCPtr(iChannelConnectObserverImpl), iChannelConnectObserverImpl);
    }

    public boolean sendCustomData(ChannelParcelImpl channelParcelImpl, IChannelTransProxyImpl iChannelTransProxyImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendCustomDataNative(j, this, ChannelParcelImpl.getCPtr(channelParcelImpl), channelParcelImpl, IChannelTransProxyImpl.getCPtr(iChannelTransProxyImpl), iChannelTransProxyImpl);
    }
}
