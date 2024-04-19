package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.BizFlyLineControl;
import com.autonavi.gbl.layer.model.BizClickLabelType;
import com.autonavi.gbl.layer.model.BizFlyLineType;
import com.autonavi.gbl.layer.model.FlylineDrawMode;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.observer.impl.ILayerClickObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
@IntfAuto(target = BizFlyLineControl.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IBizFlyLineControlImpl {
    private static BindTable BIND_TABLE = new BindTable(IBizFlyLineControlImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void addClickObserverNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, long j2, ILayerClickObserverImpl iLayerClickObserverImpl);

    private static native void destroyNativeObj(long j);

    private static native int getBusinessTypeNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl);

    private static native boolean getClickLabelMoveMapNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl);

    private static native void getClickLabelTypeNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, int[] iArr);

    private static native boolean getClickableNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl);

    private static native void getDrawModeNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, int[] iArr);

    private static native long getFlylineLayerNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, int i);

    private static native boolean getVisible1Native(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, int i);

    private static native void getVisible2Native(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, boolean[] zArr, boolean[] zArr2);

    private static native boolean getVisibleNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl);

    private static native void hideOnceNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl);

    private static native boolean matchBizControlNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, long j2);

    private static native void removeClickObserverNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, long j2, ILayerClickObserverImpl iLayerClickObserverImpl);

    private static native void restoreVisibleNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl);

    private static native void saveVisibleNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl);

    private static native void setBusinessTypeNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, int i);

    private static native void setClickLabelMoveMapNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, boolean z);

    private static native void setClickLabelTypeNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, int i);

    private static native void setClickableNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, boolean z);

    private static native void setStyleNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, long j2, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native void setVisible1Native(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, boolean z);

    private static native void setVisible2Native(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, int i, boolean z);

    private static native void setVisibleNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, boolean z, boolean z2);

    private static native void updateDrawModeNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, int i, boolean z);

    private static native void updateStyleNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl);

    public IBizFlyLineControlImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IBizFlyLineControlImpl) && getUID(this) == getUID((IBizFlyLineControlImpl) obj);
    }

    private static long getUID(IBizFlyLineControlImpl iBizFlyLineControlImpl) {
        long cPtr = getCPtr(iBizFlyLineControlImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizFlyLineControlImpl iBizFlyLineControlImpl) {
        if (iBizFlyLineControlImpl == null) {
            return 0L;
        }
        return iBizFlyLineControlImpl.swigCPtr;
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

    @FlylineDrawMode.FlylineDrawMode1
    public int getDrawMode() {
        int[] iArr = new int[1];
        getDrawMode(iArr);
        return iArr[0];
    }

    @BizClickLabelType.BizClickLabelType1
    public int getClickLabelType() {
        int[] iArr = new int[1];
        getDrawMode(iArr);
        return iArr[0];
    }

    public boolean[] getVisible() {
        boolean[] zArr = new boolean[1];
        boolean[] zArr2 = new boolean[1];
        getVisible(zArr, zArr2);
        return new boolean[]{zArr[0], zArr2[0]};
    }

    public void setStyle(IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setStyleNative(j, this, IPrepareLayerStyleImpl.getCPtr(iPrepareLayerStyleImpl), iPrepareLayerStyleImpl);
    }

    public void updateStyle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateStyleNative(j, this);
    }

    public boolean matchBizControl(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return matchBizControlNative(j2, this, j);
    }

    public BaseLayerImpl getFlylineLayer(@BizFlyLineType.BizFlyLineType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long flylineLayerNative = getFlylineLayerNative(j, this, i);
        if (flylineLayerNative == 0) {
            return null;
        }
        return new BaseLayerImpl(flylineLayerNative, false);
    }

    public void setVisible(boolean z, boolean z2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setVisibleNative(j, this, z, z2);
    }

    public void setVisible(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setVisible1Native(j, this, z);
    }

    public void setVisible(@BizFlyLineType.BizFlyLineType1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setVisible2Native(j, this, i, z);
    }

    public boolean getVisible1() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVisibleNative(j, this);
    }

    public boolean getVisible(@BizFlyLineType.BizFlyLineType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVisible1Native(j, this, i);
    }

    private void getVisible(boolean[] zArr, boolean[] zArr2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getVisible2Native(j, this, zArr, zArr2);
    }

    public void saveVisible() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        saveVisibleNative(j, this);
    }

    public void restoreVisible() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        restoreVisibleNative(j, this);
    }

    public void updateDrawMode(@FlylineDrawMode.FlylineDrawMode1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateDrawModeNative(j, this, i, z);
    }

    private void getDrawMode(int[] iArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getDrawModeNative(j, this, iArr);
    }

    public void setClickLabelMoveMap(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setClickLabelMoveMapNative(j, this, z);
    }

    public boolean getClickLabelMoveMap() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getClickLabelMoveMapNative(j, this);
    }

    public void setClickLabelType(@BizClickLabelType.BizClickLabelType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setClickLabelTypeNative(j, this, i);
    }

    private void getClickLabelType(int[] iArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getClickLabelTypeNative(j, this, iArr);
    }

    public void hideOnce() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        hideOnceNative(j, this);
    }

    public void setClickable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setClickableNative(j, this, z);
    }

    public boolean getClickable() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getClickableNative(j, this);
    }

    public void setBusinessType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setBusinessTypeNative(j, this, i);
    }

    public int getBusinessType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getBusinessTypeNative(j, this);
    }

    public void addClickObserver(ILayerClickObserverImpl iLayerClickObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addClickObserverNative(j, this, ILayerClickObserverImpl.getCPtr(iLayerClickObserverImpl), iLayerClickObserverImpl);
    }

    public void removeClickObserver(ILayerClickObserverImpl iLayerClickObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeClickObserverNative(j, this, ILayerClickObserverImpl.getCPtr(iLayerClickObserverImpl), iLayerClickObserverImpl);
    }
}
