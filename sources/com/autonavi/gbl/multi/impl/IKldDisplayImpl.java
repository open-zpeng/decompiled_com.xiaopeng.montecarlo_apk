package com.autonavi.gbl.multi.impl;

import android.view.Surface;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.impl.IBizAGroupControl;
import com.autonavi.gbl.layer.impl.IBizAreaControl;
import com.autonavi.gbl.layer.impl.IBizCarControl;
import com.autonavi.gbl.layer.impl.IBizCustomControl;
import com.autonavi.gbl.layer.impl.IBizFlyLineControlImpl;
import com.autonavi.gbl.layer.impl.IBizGuideEagleEyeControl;
import com.autonavi.gbl.layer.impl.IBizGuideRouteControl;
import com.autonavi.gbl.layer.impl.IBizLabelControl;
import com.autonavi.gbl.layer.impl.IBizRoadCrossControl;
import com.autonavi.gbl.layer.impl.IBizRoadFacilityControl;
import com.autonavi.gbl.layer.impl.IBizSearchControl;
import com.autonavi.gbl.layer.impl.IBizUserControl;
import com.autonavi.gbl.map.impl.MapDeviceImpl;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.multi.KldDisplay;
import com.autonavi.gbl.multi.model.DisplayType;
import com.autonavi.gbl.multi.observer.impl.IKldDisplayDataProviderImpl;
import com.autonavi.gbl.multi.observer.impl.IKldDisplayObserverImpl;
import com.autonavi.gbl.multi.observer.impl.IKldSceneObserverImpl;
@IntfAuto(target = KldDisplay.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IKldDisplayImpl {
    private static BindTable BIND_TABLE = new BindTable(IKldDisplayImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void appendSyncPropertyNative(long j, IKldDisplayImpl iKldDisplayImpl, int i, boolean z);

    private static native void destroyNativeObj(long j);

    private static native long getBizAGroupControlNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native long getBizAreaControlNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native long getBizCarControlNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native long getBizCustomControlNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native long getBizFlyLineControlNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native long getBizGuideEagleEyeControlNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native long getBizGuideRouteControlNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native long getBizLabelControlNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native long getBizRoadCrossControlNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native long getBizRoadFacilityControlNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native long getBizSearchControlNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native long getBizUserControlNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native long getDisplayCropNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native int getDisplayIdNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native void getDisplayNameNative(long j, IKldDisplayImpl iKldDisplayImpl, String[] strArr);

    private static native int getDisplayTypeNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native long getRelatedMapDeviceNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native long getRelatedMapViewNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native long getSceneContextNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native long getWindowFromSurfaceNative(long j, Surface surface);

    private static native boolean isRemoteDisplayNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native int pauseSceneNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native int popScene1Native(long j, IKldDisplayImpl iKldDisplayImpl, String str, boolean z);

    private static native int popSceneNative(long j, IKldDisplayImpl iKldDisplayImpl, boolean z);

    private static native void removeSyncPropertyNative(long j, IKldDisplayImpl iKldDisplayImpl, int i);

    private static native int resumeSceneNative(long j, IKldDisplayImpl iKldDisplayImpl);

    private static native void setDataProviderNative(long j, IKldDisplayImpl iKldDisplayImpl, long j2, IKldDisplayDataProviderImpl iKldDisplayDataProviderImpl);

    private static native void setDisplayObserverNative(long j, IKldDisplayImpl iKldDisplayImpl, long j2, IKldDisplayObserverImpl iKldDisplayObserverImpl);

    private static native void setSceneObserverNative(long j, IKldDisplayImpl iKldDisplayImpl, long j2, IKldSceneObserverImpl iKldSceneObserverImpl);

    private static native int startSceneNative(long j, IKldDisplayImpl iKldDisplayImpl, String str, long j2, CKldIntent cKldIntent, boolean z);

    public IKldDisplayImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IKldDisplayImpl) && getUID(this) == getUID((IKldDisplayImpl) obj);
    }

    private static long getUID(IKldDisplayImpl iKldDisplayImpl) {
        long cPtr = getCPtr(iKldDisplayImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IKldDisplayImpl iKldDisplayImpl) {
        if (iKldDisplayImpl == null) {
            return 0L;
        }
        return iKldDisplayImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
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

    public String getDisplayName() {
        String[] strArr = new String[1];
        getDisplayName(strArr);
        return strArr[0];
    }

    public int getDisplayId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDisplayIdNative(j, this);
    }

    @DisplayType.DisplayType1
    public int getDisplayType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDisplayTypeNative(j, this);
    }

    private void getDisplayName(String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getDisplayNameNative(j, this, strArr);
    }

    public boolean isRemoteDisplay() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isRemoteDisplayNative(j, this);
    }

    public MapViewImpl getRelatedMapView() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long relatedMapViewNative = getRelatedMapViewNative(j, this);
        if (relatedMapViewNative == 0) {
            return null;
        }
        return new MapViewImpl(relatedMapViewNative, false);
    }

    public MapDeviceImpl getRelatedMapDevice() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long relatedMapDeviceNative = getRelatedMapDeviceNative(j, this);
        if (relatedMapDeviceNative == 0) {
            return null;
        }
        return new MapDeviceImpl(relatedMapDeviceNative, false);
    }

    public IKldDisplayCrop getDisplayCrop() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long displayCropNative = getDisplayCropNative(j, this);
        if (displayCropNative == 0) {
            return null;
        }
        return new IKldDisplayCrop(displayCropNative, false);
    }

    public void appendSyncProperty(int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        appendSyncPropertyNative(j, this, i, z);
    }

    public void removeSyncProperty(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeSyncPropertyNative(j, this, i);
    }

    public CKldSceneContextImpl getSceneContext() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long sceneContextNative = getSceneContextNative(j, this);
        if (sceneContextNative == 0) {
            return null;
        }
        return new CKldSceneContextImpl(sceneContextNative, false);
    }

    public int pauseScene() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return pauseSceneNative(j, this);
    }

    public int resumeScene() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return resumeSceneNative(j, this);
    }

    public int startScene(String str, CKldIntent cKldIntent, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return startSceneNative(j, this, str, CKldIntent.getCPtr(cKldIntent), cKldIntent, z);
    }

    public int popScene(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return popSceneNative(j, this, z);
    }

    public int popScene(String str, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return popScene1Native(j, this, str, z);
    }

    public void setDataProvider(IKldDisplayDataProviderImpl iKldDisplayDataProviderImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setDataProviderNative(j, this, IKldDisplayDataProviderImpl.getCPtr(iKldDisplayDataProviderImpl), iKldDisplayDataProviderImpl);
    }

    public void setDisplayObserver(IKldDisplayObserverImpl iKldDisplayObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setDisplayObserverNative(j, this, IKldDisplayObserverImpl.getCPtr(iKldDisplayObserverImpl), iKldDisplayObserverImpl);
    }

    public void setSceneObserver(IKldSceneObserverImpl iKldSceneObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setSceneObserverNative(j, this, IKldSceneObserverImpl.getCPtr(iKldSceneObserverImpl), iKldSceneObserverImpl);
    }

    public static long getWindowFromSurface(Surface surface) {
        return getWindowFromSurfaceNative(0L, surface);
    }

    public IBizRoadFacilityControl getBizRoadFacilityControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizRoadFacilityControlNative = getBizRoadFacilityControlNative(j, this);
        if (bizRoadFacilityControlNative == 0) {
            return null;
        }
        return new IBizRoadFacilityControl(bizRoadFacilityControlNative, false);
    }

    public IBizLabelControl getBizLabelControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizLabelControlNative = getBizLabelControlNative(j, this);
        if (bizLabelControlNative == 0) {
            return null;
        }
        return new IBizLabelControl(bizLabelControlNative, false);
    }

    public IBizRoadCrossControl getBizRoadCrossControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizRoadCrossControlNative = getBizRoadCrossControlNative(j, this);
        if (bizRoadCrossControlNative == 0) {
            return null;
        }
        return new IBizRoadCrossControl(bizRoadCrossControlNative, false);
    }

    public IBizUserControl getBizUserControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizUserControlNative = getBizUserControlNative(j, this);
        if (bizUserControlNative == 0) {
            return null;
        }
        return new IBizUserControl(bizUserControlNative, false);
    }

    public IBizGuideRouteControl getBizGuideRouteControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizGuideRouteControlNative = getBizGuideRouteControlNative(j, this);
        if (bizGuideRouteControlNative == 0) {
            return null;
        }
        return new IBizGuideRouteControl(bizGuideRouteControlNative, false);
    }

    public IBizCarControl getBizCarControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizCarControlNative = getBizCarControlNative(j, this);
        if (bizCarControlNative == 0) {
            return null;
        }
        return new IBizCarControl(bizCarControlNative, false);
    }

    public IBizFlyLineControlImpl getBizFlyLineControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizFlyLineControlNative = getBizFlyLineControlNative(j, this);
        if (bizFlyLineControlNative == 0) {
            return null;
        }
        return new IBizFlyLineControlImpl(bizFlyLineControlNative, false);
    }

    public IBizAGroupControl getBizAGroupControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizAGroupControlNative = getBizAGroupControlNative(j, this);
        if (bizAGroupControlNative == 0) {
            return null;
        }
        return new IBizAGroupControl(bizAGroupControlNative, false);
    }

    public IBizAreaControl getBizAreaControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizAreaControlNative = getBizAreaControlNative(j, this);
        if (bizAreaControlNative == 0) {
            return null;
        }
        return new IBizAreaControl(bizAreaControlNative, false);
    }

    public IBizSearchControl getBizSearchControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizSearchControlNative = getBizSearchControlNative(j, this);
        if (bizSearchControlNative == 0) {
            return null;
        }
        return new IBizSearchControl(bizSearchControlNative, false);
    }

    public IBizGuideEagleEyeControl getBizGuideEagleEyeControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizGuideEagleEyeControlNative = getBizGuideEagleEyeControlNative(j, this);
        if (bizGuideEagleEyeControlNative == 0) {
            return null;
        }
        return new IBizGuideEagleEyeControl(bizGuideEagleEyeControlNative, false);
    }

    public IBizCustomControl getBizCustomControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizCustomControlNative = getBizCustomControlNative(j, this);
        if (bizCustomControlNative == 0) {
            return null;
        }
        return new IBizCustomControl(bizCustomControlNative, false);
    }
}
