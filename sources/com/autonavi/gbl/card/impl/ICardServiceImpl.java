package com.autonavi.gbl.card.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.card.CardService;
import com.autonavi.gbl.card.model.CardInitParam;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.map.model.MapEngineID;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
@IntfAuto(target = CardService.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICardServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(ICardServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native void destroyTextureManagerNative(long j, ICardServiceImpl iCardServiceImpl, long j2, ITextureManagerImpl iTextureManagerImpl);

    private static native void enableOperateTextureNative(long j, ICardServiceImpl iCardServiceImpl, int i, boolean z);

    private static native long getTextureManagerNative(long j, ICardServiceImpl iCardServiceImpl, long j2, MapViewImpl mapViewImpl, long j3, CardInitParam cardInitParam);

    private static native int isInitNative(long j, ICardServiceImpl iCardServiceImpl);

    private static native void setDebugFileSaveModeNative(long j, ICardServiceImpl iCardServiceImpl, boolean z, String str);

    private static native void setDebugMode1Native(long j, ICardServiceImpl iCardServiceImpl, boolean z);

    private static native void setDebugModeNative(long j, ICardServiceImpl iCardServiceImpl, boolean z, int i);

    private static native boolean setStrategyTypeNative(long j, ICardServiceImpl iCardServiceImpl, int i, int i2);

    private static native void unInitNative(long j, ICardServiceImpl iCardServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected ICardServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICardServiceImpl) && getUID(this) == getUID((ICardServiceImpl) obj);
    }

    private static long getUID(ICardServiceImpl iCardServiceImpl) {
        long cPtr = getCPtr(iCardServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICardServiceImpl iCardServiceImpl) {
        if (iCardServiceImpl == null) {
            return 0L;
        }
        return iCardServiceImpl.swigCPtr;
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

    public void setDebugMode(boolean z, @MapEngineID.MapEngineID1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setDebugModeNative(j, this, z, i);
    }

    public void setDebugMode(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setDebugMode1Native(j, this, z);
    }

    public void setDebugFileSaveMode(boolean z, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setDebugFileSaveModeNative(j, this, z, str);
    }

    public ITextureManagerImpl getTextureManager(MapViewImpl mapViewImpl, CardInitParam cardInitParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long textureManagerNative = getTextureManagerNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl, 0L, cardInitParam);
        if (textureManagerNative == 0) {
            return null;
        }
        return new ITextureManagerImpl(textureManagerNative, false);
    }

    public void destroyTextureManager(ITextureManagerImpl iTextureManagerImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        destroyTextureManagerNative(j, this, ITextureManagerImpl.getCPtr(iTextureManagerImpl), iTextureManagerImpl);
    }

    public boolean setStrategyType(@MapEngineID.MapEngineID1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setStrategyTypeNative(j, this, i, i2);
    }

    public void enableOperateTexture(@MapEngineID.MapEngineID1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableOperateTextureNative(j, this, i, z);
    }
}
