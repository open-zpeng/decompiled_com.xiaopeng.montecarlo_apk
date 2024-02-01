package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.BizControl;
import com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl;
import com.autonavi.gbl.map.impl.MixtureSharedBaseImpl;
import com.autonavi.gbl.map.layer.observer.impl.ILayerClickObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.ILayerFocusChangeObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
@IntfAuto(target = BizControl.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBizControlImpl extends MixtureSharedBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(IBizControlImpl.class);
    private transient long swigCPtr;

    private static native long IBizControlImpl_SWIGUpcast(long j);

    private static native void addClickObserverNative(long j, IBizControlImpl iBizControlImpl, long j2, ILayerClickObserverImpl iLayerClickObserverImpl);

    private static native void addFocusChangeObserverNative(long j, IBizControlImpl iBizControlImpl, long j2, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl);

    private static native void clearAllItems1Native(long j, IBizControlImpl iBizControlImpl);

    private static native void clearAllItemsNative(long j, IBizControlImpl iBizControlImpl, long j2);

    private static native void clearFocusNative(long j, IBizControlImpl iBizControlImpl, long j2);

    private static native void destroyNativeObj(long j);

    private static native boolean getClickableNative(long j, IBizControlImpl iBizControlImpl, long j2);

    private static native boolean getFocusNative(long j, IBizControlImpl iBizControlImpl, long j2, String str);

    private static native long getStyleNative(long j, IBizControlImpl iBizControlImpl);

    private static native boolean getVisible1Native(long j, IBizControlImpl iBizControlImpl);

    private static native boolean getVisibleNative(long j, IBizControlImpl iBizControlImpl, long j2);

    private static native boolean matchBizControlNative(long j, IBizControlImpl iBizControlImpl, long j2);

    private static native void removeClickObserverNative(long j, IBizControlImpl iBizControlImpl, long j2, ILayerClickObserverImpl iLayerClickObserverImpl);

    private static native void removeFocusChangeObserverNative(long j, IBizControlImpl iBizControlImpl, long j2, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl);

    private static native void restoreVisibleNative(long j, IBizControlImpl iBizControlImpl);

    private static native void saveVisibleNative(long j, IBizControlImpl iBizControlImpl);

    private static native void setClickableNative(long j, IBizControlImpl iBizControlImpl, long j2, boolean z);

    private static native void setFocusNative(long j, IBizControlImpl iBizControlImpl, long j2, String str, boolean z);

    private static native void setParamNative(long j, IBizControlImpl iBizControlImpl, long j2, IPrepareLayerParamImpl iPrepareLayerParamImpl);

    private static native void setStyle1Native(long j, IBizControlImpl iBizControlImpl, long j2, long j3, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native void setStyleNative(long j, IBizControlImpl iBizControlImpl, long j2, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native void setVisible1Native(long j, IBizControlImpl iBizControlImpl, boolean z);

    private static native void setVisibleNative(long j, IBizControlImpl iBizControlImpl, long j2, boolean z);

    private static native void updateStyle1Native(long j, IBizControlImpl iBizControlImpl, long j2);

    private static native void updateStyleNative(long j, IBizControlImpl iBizControlImpl);

    public IBizControlImpl(long j, boolean z) {
        super(IBizControlImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof IBizControlImpl) {
            return getUID(this) == getUID((IBizControlImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(IBizControlImpl iBizControlImpl) {
        long cPtr = getCPtr(iBizControlImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizControlImpl iBizControlImpl) {
        if (iBizControlImpl == null) {
            return 0L;
        }
        return iBizControlImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public void setStyle(IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setStyleNative(j, this, IPrepareLayerStyleImpl.getCPtr(iPrepareLayerStyleImpl), iPrepareLayerStyleImpl);
    }

    public void setStyle(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setStyle1Native(j2, this, j, IPrepareLayerStyleImpl.getCPtr(iPrepareLayerStyleImpl), iPrepareLayerStyleImpl);
    }

    public IPrepareLayerStyleImpl getStyle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long styleNative = getStyleNative(j, this);
        if (styleNative == 0) {
            return null;
        }
        return new IPrepareLayerStyleImpl(styleNative, false);
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

    public boolean getVisible(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return getVisibleNative(j2, this, j);
    }

    public boolean getVisible() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVisible1Native(j, this);
    }

    public void setVisible(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setVisible1Native(j, this, z);
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

    public void setClickable(long j, boolean z) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setClickableNative(j2, this, j, z);
    }

    public boolean getClickable(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return getClickableNative(j2, this, j);
    }

    public void setFocus(long j, String str, boolean z) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setFocusNative(j2, this, j, str, z);
    }

    public boolean getFocus(long j, String str) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return getFocusNative(j2, this, j, str);
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
