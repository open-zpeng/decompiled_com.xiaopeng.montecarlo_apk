package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.BizFlyLineControl;
import com.autonavi.gbl.layer.model.BizClickLabelType;
import com.autonavi.gbl.layer.model.BizFlyLineType;
import com.autonavi.gbl.layer.model.FlylineDrawMode;
import com.autonavi.gbl.map.impl.MixtureSharedBaseImpl;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.observer.impl.ILayerClickObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import java.util.ArrayList;
@IntfAuto(target = BizFlyLineControl.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBizFlyLineControlImpl extends MixtureSharedBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(IBizFlyLineControlImpl.class);
    private transient long swigCPtr;

    private static native long IBizFlyLineControlImpl_SWIGUpcast(long j);

    private static native void addClickObserverNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, long j2, ILayerClickObserverImpl iLayerClickObserverImpl);

    private static native void destroyNativeObj(long j);

    private static native int getBusinessTypeNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl);

    private static native boolean getClickLabelMoveMapNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl);

    private static native void getClickLabelTypeNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, int[] iArr);

    private static native boolean getClickableNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl);

    private static native void getDrawModeNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, int[] iArr);

    private static native long getFlylineLayerNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, int i);

    private static native long getStyleNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl);

    private static native void getVisible1Native(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, boolean[] zArr, boolean[] zArr2);

    private static native boolean getVisible1Native(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl);

    private static native boolean getVisibleNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, int i);

    private static native void hideOnceNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl);

    private static native boolean matchBizControlNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, long j2);

    private static native void removeClickObserverNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, long j2, ILayerClickObserverImpl iLayerClickObserverImpl);

    private static native void restoreVisibleNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl);

    private static native void saveVisibleNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl);

    private static native void setBusinessTypeNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, int i);

    private static native void setClickLabelInfoNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, long j2, BizClickLabelInfoImpl bizClickLabelInfoImpl);

    private static native void setClickLabelMoveMapNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, boolean z);

    private static native void setClickLabelTypeNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, int i);

    private static native void setClickableNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, boolean z);

    private static native void setStyleNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, long j2, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native void setTextScaleNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, float f);

    private static native void setVisible1Native(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, boolean z);

    private static native void setVisible2Native(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, int i, boolean z);

    private static native void setVisibleNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, boolean z, boolean z2);

    private static native void updateDrawModeNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl, int i, boolean z);

    private static native void updateStyleNative(long j, IBizFlyLineControlImpl iBizFlyLineControlImpl);

    public IBizFlyLineControlImpl(long j, boolean z) {
        super(IBizFlyLineControlImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof IBizFlyLineControlImpl) {
            return getUID(this) == getUID((IBizFlyLineControlImpl) obj);
        }
        return super.equals(obj);
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
        return getVisible1Native(j, this);
    }

    public boolean getVisible(@BizFlyLineType.BizFlyLineType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVisibleNative(j, this, i);
    }

    public ArrayList getVisible() {
        ArrayList arrayList = new ArrayList();
        boolean[] zArr = new boolean[1];
        boolean[] zArr2 = new boolean[1];
        getVisible(zArr, zArr2);
        arrayList.add(zArr);
        arrayList.add(zArr2);
        return arrayList;
    }

    private void getVisible(boolean[] zArr, boolean[] zArr2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getVisible1Native(j, this, zArr, zArr2);
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

    public int getDrawMode() {
        int[] iArr = new int[1];
        getDrawMode(iArr);
        return iArr[0];
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

    public int getClickLabelType() {
        int[] iArr = new int[1];
        getClickLabelType(iArr);
        return iArr[0];
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

    public void setClickLabelInfo(BizClickLabelInfoImpl bizClickLabelInfoImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setClickLabelInfoNative(j, this, BizClickLabelInfoImpl.getCPtr(bizClickLabelInfoImpl), bizClickLabelInfoImpl);
    }

    public void setTextScale(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setTextScaleNative(j, this, f);
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
