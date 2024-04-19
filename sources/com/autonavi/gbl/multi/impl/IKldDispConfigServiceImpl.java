package com.autonavi.gbl.multi.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.multi.KldDispConfigService;
import com.autonavi.gbl.multi.model.DisplayType;
import com.autonavi.gbl.multi.observer.impl.DisplayConfigBaseImpl;
import com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl;
import com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl;
import com.autonavi.gbl.multi.observer.impl.RenderConfigBaseImpl;
import com.autonavi.gbl.multi.observer.impl.SurfaceConfigBaseImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.util.ArrayList;
@IntfAuto(target = KldDispConfigService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IKldDispConfigServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IKldDispConfigServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native long getConfigItem1Native(long j, IKldDispConfigServiceImpl iKldDispConfigServiceImpl, String str, String str2);

    private static native long getConfigItemNative(long j, IKldDispConfigServiceImpl iKldDispConfigServiceImpl, String str, String str2);

    private static native long getDispConfigItemByNameNative(long j, IKldDispConfigServiceImpl iKldDispConfigServiceImpl, String str);

    private static native long getDispConfigItemByTypeNative(long j, IKldDispConfigServiceImpl iKldDispConfigServiceImpl, int i);

    private static native long[] getDispListNative(long j, IKldDispConfigServiceImpl iKldDispConfigServiceImpl);

    private static native long getMapConfigItemNative(long j, IKldDispConfigServiceImpl iKldDispConfigServiceImpl, String str);

    private static native long getRenderConfigItemNative(long j, IKldDispConfigServiceImpl iKldDispConfigServiceImpl, String str);

    private static native long getSurfaceConfigItemNative(long j, IKldDispConfigServiceImpl iKldDispConfigServiceImpl, String str);

    private static native int initNative(long j, IKldDispConfigServiceImpl iKldDispConfigServiceImpl, String str);

    private static native int isInitNative(long j, IKldDispConfigServiceImpl iKldDispConfigServiceImpl);

    private static native int parseJsonConfigNative(long j, IKldDispConfigServiceImpl iKldDispConfigServiceImpl, String str);

    private static native int registerDisplayConfigBaseNative(long j, IKldDispConfigServiceImpl iKldDispConfigServiceImpl, String str, String str2);

    private static native int registerDisplaySceneConfigBaseNative(long j, IKldDispConfigServiceImpl iKldDispConfigServiceImpl, String str, String str2);

    private static native int registerMapConfigBaseNative(long j, IKldDispConfigServiceImpl iKldDispConfigServiceImpl, String str, String str2);

    private static native int registerRenderConfigBaseNative(long j, IKldDispConfigServiceImpl iKldDispConfigServiceImpl, String str, String str2);

    private static native int registerSurfaceConfigBaseNative(long j, IKldDispConfigServiceImpl iKldDispConfigServiceImpl, String str, String str2);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IKldDispConfigServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IKldDispConfigServiceImpl) && getUID(this) == getUID((IKldDispConfigServiceImpl) obj);
    }

    private static long getUID(IKldDispConfigServiceImpl iKldDispConfigServiceImpl) {
        long cPtr = getCPtr(iKldDispConfigServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IKldDispConfigServiceImpl iKldDispConfigServiceImpl) {
        if (iKldDispConfigServiceImpl == null) {
            return 0L;
        }
        return iKldDispConfigServiceImpl.swigCPtr;
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

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isInitNative(j, this);
    }

    public int registerSurfaceConfigBase(String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return registerSurfaceConfigBaseNative(j, this, str, str2);
    }

    public int registerDisplaySceneConfigBase(String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return registerDisplaySceneConfigBaseNative(j, this, str, str2);
    }

    public int registerDisplayConfigBase(String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return registerDisplayConfigBaseNative(j, this, str, str2);
    }

    public int registerRenderConfigBase(String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return registerRenderConfigBaseNative(j, this, str, str2);
    }

    public int registerMapConfigBase(String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return registerMapConfigBaseNative(j, this, str, str2);
    }

    public int parseJsonConfig(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return parseJsonConfigNative(j, this, str);
    }

    public int init(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, str);
    }

    public IKldConfigItemBaseImpl getConfigItem(String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long configItemNative = getConfigItemNative(j, this, str, str2);
        if (configItemNative == 0) {
            return null;
        }
        return new IKldConfigItemBaseImpl(configItemNative, false);
    }

    public IKldConfigItemBaseImpl getConfigItem1(String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long configItem1Native = getConfigItem1Native(j, this, str, str2);
        if (configItem1Native == 0) {
            return null;
        }
        return new IKldConfigItemBaseImpl(configItem1Native, false);
    }

    public ArrayList<DisplayConfigBaseImpl> getDispList() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        ArrayList<DisplayConfigBaseImpl> arrayList = null;
        long[] dispListNative = getDispListNative(j, this);
        if (dispListNative != null) {
            arrayList = new ArrayList<>();
            for (long j2 : dispListNative) {
                arrayList.add(new DisplayConfigBaseImpl(j2, false));
            }
        }
        return arrayList;
    }

    public DisplayConfigBaseImpl getDispConfigItemByType(@DisplayType.DisplayType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long dispConfigItemByTypeNative = getDispConfigItemByTypeNative(j, this, i);
        if (dispConfigItemByTypeNative == 0) {
            return null;
        }
        return new DisplayConfigBaseImpl(dispConfigItemByTypeNative, false);
    }

    public DisplayConfigBaseImpl getDispConfigItemByName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long dispConfigItemByNameNative = getDispConfigItemByNameNative(j, this, str);
        if (dispConfigItemByNameNative == 0) {
            return null;
        }
        return new DisplayConfigBaseImpl(dispConfigItemByNameNative, false);
    }

    public MapConfigBaseImpl getMapConfigItem(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long mapConfigItemNative = getMapConfigItemNative(j, this, str);
        if (mapConfigItemNative == 0) {
            return null;
        }
        return new MapConfigBaseImpl(mapConfigItemNative, false);
    }

    public RenderConfigBaseImpl getRenderConfigItem(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long renderConfigItemNative = getRenderConfigItemNative(j, this, str);
        if (renderConfigItemNative == 0) {
            return null;
        }
        return new RenderConfigBaseImpl(renderConfigItemNative, false);
    }

    public SurfaceConfigBaseImpl getSurfaceConfigItem(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long surfaceConfigItemNative = getSurfaceConfigItemNative(j, this, str);
        if (surfaceConfigItemNative == 0) {
            return null;
        }
        return new SurfaceConfigBaseImpl(surfaceConfigItemNative, false);
    }
}
