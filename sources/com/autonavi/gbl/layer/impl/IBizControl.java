package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.BizControl;
import com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl;
import com.autonavi.gbl.map.layer.observer.impl.ILayerClickObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.ILayerFocusChangeObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
@IntfAuto(target = BizControl.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IBizControl {
    private static BindTable BIND_TABLE = new BindTable(IBizControl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void addClickObserverNative(long j, IBizControl iBizControl, long j2, ILayerClickObserverImpl iLayerClickObserverImpl);

    private static native void addFocusChangeObserverNative(long j, IBizControl iBizControl, long j2, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl);

    private static native void clearAllItems1Native(long j, IBizControl iBizControl);

    private static native void clearAllItemsNative(long j, IBizControl iBizControl, long j2);

    private static native void clearFocusNative(long j, IBizControl iBizControl, long j2);

    private static native void destroyNativeObj(long j);

    private static native boolean matchBizControlNative(long j, IBizControl iBizControl, long j2);

    private static native void removeClickObserverNative(long j, IBizControl iBizControl, long j2, ILayerClickObserverImpl iLayerClickObserverImpl);

    private static native void removeFocusChangeObserverNative(long j, IBizControl iBizControl, long j2, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl);

    private static native void setClickableNative(long j, IBizControl iBizControl, long j2, boolean z);

    private static native void setFocusNative(long j, IBizControl iBizControl, long j2, String str, boolean z);

    private static native void setParamNative(long j, IBizControl iBizControl, long j2, IPrepareLayerParamImpl iPrepareLayerParamImpl);

    private static native void setStyleNative(long j, IBizControl iBizControl, long j2, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native void setVisible1Native(long j, IBizControl iBizControl, boolean z);

    private static native void setVisibleNative(long j, IBizControl iBizControl, long j2, boolean z);

    private static native void updateStyle1Native(long j, IBizControl iBizControl, long j2);

    private static native void updateStyleNative(long j, IBizControl iBizControl);

    public IBizControl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IBizControl) && getUID(this) == getUID((IBizControl) obj);
    }

    private static long getUID(IBizControl iBizControl) {
        long cPtr = getCPtr(iBizControl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizControl iBizControl) {
        if (iBizControl == null) {
            return 0L;
        }
        return iBizControl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setStyle(IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setStyleNative(j, this, IPrepareLayerStyleImpl.getCPtr(iPrepareLayerStyleImpl), iPrepareLayerStyleImpl);
    }

    public void setParam(IPrepareLayerParamImpl iPrepareLayerParamImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setParamNative(j, this, IPrepareLayerParamImpl.getCPtr(iPrepareLayerParamImpl), iPrepareLayerParamImpl);
    }

    public void updateStyle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateStyleNative(j, this);
    }

    public void updateStyle(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        updateStyle1Native(j2, this, j);
    }

    public boolean matchBizControl(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return matchBizControlNative(j2, this, j);
    }

    public void clearAllItems(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        clearAllItemsNative(j2, this, j);
    }

    public void clearAllItems() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearAllItems1Native(j, this);
    }

    public void setVisible(long j, boolean z) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setVisibleNative(j2, this, j, z);
    }

    public void setVisible(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setVisible1Native(j, this, z);
    }

    public void setClickable(long j, boolean z) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setClickableNative(j2, this, j, z);
    }

    public void setFocus(long j, String str, boolean z) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setFocusNative(j2, this, j, str, z);
    }

    public void clearFocus(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        clearFocusNative(j2, this, j);
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

    public void addFocusChangeObserver(ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addFocusChangeObserverNative(j, this, ILayerFocusChangeObserverImpl.getCPtr(iLayerFocusChangeObserverImpl), iLayerFocusChangeObserverImpl);
    }

    public void removeFocusChangeObserver(ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeFocusChangeObserverNative(j, this, ILayerFocusChangeObserverImpl.getCPtr(iLayerFocusChangeObserverImpl), iLayerFocusChangeObserverImpl);
    }
}
