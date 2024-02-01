package com.autonavi.gbl.consis.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.ChannelService;
import com.autonavi.gbl.consis.model.ChannelInitParam;
import com.autonavi.gbl.consis.model.CustomChannelMessageParam;
import com.autonavi.gbl.consis.observer.impl.IChannelMessageObserverImpl;
import com.autonavi.gbl.consis.observer.impl.IChannelObserverImpl;
import com.autonavi.gbl.consis.observer.impl.IChannelProxyAdapterImpl;
import com.autonavi.gbl.consis.observer.impl.IChannelProxyObserverImpl;
import com.autonavi.gbl.consis.observer.impl.IConsisMessageAdapterImpl;
import com.autonavi.gbl.consis.observer.impl.IConsisObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
@IntfAuto(target = ChannelService.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IChannelServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IChannelServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native boolean addChannelNative(long j, IChannelServiceImpl iChannelServiceImpl, String str, long j2, IChannelMessageObserverImpl iChannelMessageObserverImpl);

    private static native int addChannelProxyNative(long j, IChannelServiceImpl iChannelServiceImpl, long j2, IChannelProxyAdapterImpl iChannelProxyAdapterImpl);

    private static native boolean addObserver1Native(long j, IChannelServiceImpl iChannelServiceImpl, long j2, IChannelObserverImpl iChannelObserverImpl);

    private static native boolean addObserver2Native(long j, IChannelServiceImpl iChannelServiceImpl, long j2, IConsisObserverImpl iConsisObserverImpl);

    private static native boolean addObserverNative(long j, IChannelServiceImpl iChannelServiceImpl, long j2, IChannelProxyObserverImpl iChannelProxyObserverImpl);

    private static native int connectChannelNative(long j, IChannelServiceImpl iChannelServiceImpl, String str, int i);

    private static native void destroyNativeObj(long j);

    private static native String getSdkNameNative(long j, IChannelServiceImpl iChannelServiceImpl);

    private static native int handleMessageNative(long j, IChannelServiceImpl iChannelServiceImpl, byte[] bArr, long j2, IChannelProxyAdapterImpl iChannelProxyAdapterImpl);

    private static native int initNative(long j, IChannelServiceImpl iChannelServiceImpl, long j2, ChannelInitParam channelInitParam);

    private static native int isInitNative(long j, IChannelServiceImpl iChannelServiceImpl);

    private static native boolean isMasterNative(long j, IChannelServiceImpl iChannelServiceImpl);

    private static native boolean removeChannelNative(long j, IChannelServiceImpl iChannelServiceImpl, String str);

    private static native int removeChannelProxyNative(long j, IChannelServiceImpl iChannelServiceImpl, long j2, IChannelProxyAdapterImpl iChannelProxyAdapterImpl);

    private static native boolean removeObserver1Native(long j, IChannelServiceImpl iChannelServiceImpl, long j2, IChannelObserverImpl iChannelObserverImpl);

    private static native boolean removeObserver2Native(long j, IChannelServiceImpl iChannelServiceImpl, long j2, IConsisObserverImpl iConsisObserverImpl);

    private static native boolean removeObserverNative(long j, IChannelServiceImpl iChannelServiceImpl, long j2, IChannelProxyObserverImpl iChannelProxyObserverImpl);

    private static native boolean sendMessageNative(long j, IChannelServiceImpl iChannelServiceImpl, long j2, CustomChannelMessageParam customChannelMessageParam);

    private static native long setAdapterNative(long j, IChannelServiceImpl iChannelServiceImpl, long j2, IConsisMessageAdapterImpl iConsisMessageAdapterImpl);

    private static native void unInitNative(long j, IChannelServiceImpl iChannelServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IChannelServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IChannelServiceImpl) && getUID(this) == getUID((IChannelServiceImpl) obj);
    }

    private static long getUID(IChannelServiceImpl iChannelServiceImpl) {
        long cPtr = getCPtr(iChannelServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IChannelServiceImpl iChannelServiceImpl) {
        if (iChannelServiceImpl == null) {
            return 0L;
        }
        return iChannelServiceImpl.swigCPtr;
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

    public int init(ChannelInitParam channelInitParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, 0L, channelInitParam);
    }

    public void unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInitNative(j, this);
    }

    public int connectChannel(String str, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return connectChannelNative(j, this, str, i);
    }

    public boolean isMaster() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isMasterNative(j, this);
    }

    public String getSdkName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSdkNameNative(j, this);
    }

    public boolean addChannel(String str, IChannelMessageObserverImpl iChannelMessageObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addChannelNative(j, this, str, IChannelMessageObserverImpl.getCPtr(iChannelMessageObserverImpl), iChannelMessageObserverImpl);
    }

    public boolean removeChannel(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeChannelNative(j, this, str);
    }

    public boolean sendMessage(CustomChannelMessageParam customChannelMessageParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendMessageNative(j, this, 0L, customChannelMessageParam);
    }

    public int addChannelProxy(IChannelProxyAdapterImpl iChannelProxyAdapterImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addChannelProxyNative(j, this, IChannelProxyAdapterImpl.getCPtr(iChannelProxyAdapterImpl), iChannelProxyAdapterImpl);
    }

    public int removeChannelProxy(IChannelProxyAdapterImpl iChannelProxyAdapterImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeChannelProxyNative(j, this, IChannelProxyAdapterImpl.getCPtr(iChannelProxyAdapterImpl), iChannelProxyAdapterImpl);
    }

    public int handleMessage(byte[] bArr, IChannelProxyAdapterImpl iChannelProxyAdapterImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return handleMessageNative(j, this, bArr, IChannelProxyAdapterImpl.getCPtr(iChannelProxyAdapterImpl), iChannelProxyAdapterImpl);
    }

    public IChannelMsgSyncControllerImpl setAdapter(IConsisMessageAdapterImpl iConsisMessageAdapterImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long adapterNative = setAdapterNative(j, this, IConsisMessageAdapterImpl.getCPtr(iConsisMessageAdapterImpl), iConsisMessageAdapterImpl);
        if (adapterNative == 0) {
            return null;
        }
        return new IChannelMsgSyncControllerImpl(adapterNative, false);
    }

    public boolean addObserver(IChannelProxyObserverImpl iChannelProxyObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addObserverNative(j, this, IChannelProxyObserverImpl.getCPtr(iChannelProxyObserverImpl), iChannelProxyObserverImpl);
    }

    public boolean removeObserver(IChannelProxyObserverImpl iChannelProxyObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeObserverNative(j, this, IChannelProxyObserverImpl.getCPtr(iChannelProxyObserverImpl), iChannelProxyObserverImpl);
    }

    public boolean addObserver(IChannelObserverImpl iChannelObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addObserver1Native(j, this, IChannelObserverImpl.getCPtr(iChannelObserverImpl), iChannelObserverImpl);
    }

    public boolean removeObserver(IChannelObserverImpl iChannelObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeObserver1Native(j, this, IChannelObserverImpl.getCPtr(iChannelObserverImpl), iChannelObserverImpl);
    }

    public boolean addObserver(IConsisObserverImpl iConsisObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addObserver2Native(j, this, IConsisObserverImpl.getCPtr(iConsisObserverImpl), iConsisObserverImpl);
    }

    public boolean removeObserver(IConsisObserverImpl iConsisObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeObserver2Native(j, this, IConsisObserverImpl.getCPtr(iConsisObserverImpl), iConsisObserverImpl);
    }
}
