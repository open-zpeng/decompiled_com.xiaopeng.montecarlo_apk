package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.BizCustomControl;
import com.autonavi.gbl.layer.model.BizCustomArrowInfo;
import com.autonavi.gbl.layer.model.BizCustomCircleInfo;
import com.autonavi.gbl.layer.model.BizCustomGradientPolygonInfo;
import com.autonavi.gbl.layer.model.BizCustomLineInfo;
import com.autonavi.gbl.layer.model.BizCustomPlaneInfo;
import com.autonavi.gbl.layer.model.BizCustomPointInfo;
import com.autonavi.gbl.layer.model.BizCustomPolygonInfo;
import com.autonavi.gbl.layer.model.BizCustomTypeArrow;
import com.autonavi.gbl.layer.model.BizCustomTypeCircle;
import com.autonavi.gbl.layer.model.BizCustomTypeLine;
import com.autonavi.gbl.layer.model.BizCustomTypePlane;
import com.autonavi.gbl.layer.model.BizCustomTypePoint;
import com.autonavi.gbl.layer.model.BizCustomTypePolygon;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import java.util.ArrayList;
@IntfAuto(target = BizCustomControl.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBizCustomControlImpl extends IBizControlImpl {
    private static BindTable BIND_TABLE = new BindTable(IBizCustomControlImpl.class);
    private transient long swigCPtr;

    private static native long IBizCustomControlImpl_SWIGUpcast(long j);

    private static native void addCustomArrowNative(long j, IBizCustomControlImpl iBizCustomControlImpl, ArrayList<BizCustomArrowInfo> arrayList, int i);

    private static native void addCustomCircleNative(long j, IBizCustomControlImpl iBizCustomControlImpl, ArrayList<BizCustomCircleInfo> arrayList, int i);

    private static native void addCustomGradientPolygonNative(long j, IBizCustomControlImpl iBizCustomControlImpl, ArrayList<BizCustomGradientPolygonInfo> arrayList, int i);

    private static native void addCustomLineNative(long j, IBizCustomControlImpl iBizCustomControlImpl, ArrayList<BizCustomLineInfo> arrayList, int i);

    private static native void addCustomPlaneNative(long j, IBizCustomControlImpl iBizCustomControlImpl, ArrayList<BizCustomPlaneInfo> arrayList, int i);

    private static native void addCustomPointNative(long j, IBizCustomControlImpl iBizCustomControlImpl, ArrayList<BizCustomPointInfo> arrayList, int i);

    private static native void addCustomPolygonNative(long j, IBizCustomControlImpl iBizCustomControlImpl, ArrayList<BizCustomPolygonInfo> arrayList, int i);

    private static native void destroyNativeObj(long j);

    private static native long getCustomLayerNative(long j, IBizCustomControlImpl iBizCustomControlImpl, long j2);

    private static native void updateCustomArrowNative(long j, IBizCustomControlImpl iBizCustomControlImpl, ArrayList<BizCustomArrowInfo> arrayList, int i);

    private static native void updateCustomCircleNative(long j, IBizCustomControlImpl iBizCustomControlImpl, ArrayList<BizCustomCircleInfo> arrayList, int i);

    private static native void updateCustomGradientPolygonNative(long j, IBizCustomControlImpl iBizCustomControlImpl, ArrayList<BizCustomGradientPolygonInfo> arrayList, int i);

    private static native void updateCustomLineNative(long j, IBizCustomControlImpl iBizCustomControlImpl, ArrayList<BizCustomLineInfo> arrayList, int i);

    private static native void updateCustomPlaneNative(long j, IBizCustomControlImpl iBizCustomControlImpl, ArrayList<BizCustomPlaneInfo> arrayList, int i);

    private static native void updateCustomPointNative(long j, IBizCustomControlImpl iBizCustomControlImpl, ArrayList<BizCustomPointInfo> arrayList, int i);

    private static native void updateCustomPolygonNative(long j, IBizCustomControlImpl iBizCustomControlImpl, ArrayList<BizCustomPolygonInfo> arrayList, int i);

    public IBizCustomControlImpl(long j, boolean z) {
        super(IBizCustomControlImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof IBizCustomControlImpl) {
            return getUID(this) == getUID((IBizCustomControlImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(IBizCustomControlImpl iBizCustomControlImpl) {
        long cPtr = getCPtr(iBizCustomControlImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizCustomControlImpl iBizCustomControlImpl) {
        if (iBizCustomControlImpl == null) {
            return 0L;
        }
        return iBizCustomControlImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
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

    public void updateCustomPoint(ArrayList<BizCustomPointInfo> arrayList, @BizCustomTypePoint.BizCustomTypePoint1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateCustomPointNative(j, this, arrayList, i);
    }

    public void addCustomPoint(ArrayList<BizCustomPointInfo> arrayList, @BizCustomTypePoint.BizCustomTypePoint1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addCustomPointNative(j, this, arrayList, i);
    }

    public void updateCustomLine(ArrayList<BizCustomLineInfo> arrayList, @BizCustomTypeLine.BizCustomTypeLine1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateCustomLineNative(j, this, arrayList, i);
    }

    public void addCustomLine(ArrayList<BizCustomLineInfo> arrayList, @BizCustomTypeLine.BizCustomTypeLine1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addCustomLineNative(j, this, arrayList, i);
    }

    public void updateCustomPolygon(ArrayList<BizCustomPolygonInfo> arrayList, @BizCustomTypePolygon.BizCustomTypePolygon1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateCustomPolygonNative(j, this, arrayList, i);
    }

    public void addCustomPolygon(ArrayList<BizCustomPolygonInfo> arrayList, @BizCustomTypePolygon.BizCustomTypePolygon1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addCustomPolygonNative(j, this, arrayList, i);
    }

    public void updateCustomCircle(ArrayList<BizCustomCircleInfo> arrayList, @BizCustomTypeCircle.BizCustomTypeCircle1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateCustomCircleNative(j, this, arrayList, i);
    }

    public void addCustomCircle(ArrayList<BizCustomCircleInfo> arrayList, @BizCustomTypeCircle.BizCustomTypeCircle1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addCustomCircleNative(j, this, arrayList, i);
    }

    public void updateCustomArrow(ArrayList<BizCustomArrowInfo> arrayList, @BizCustomTypeArrow.BizCustomTypeArrow1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateCustomArrowNative(j, this, arrayList, i);
    }

    public void addCustomArrow(ArrayList<BizCustomArrowInfo> arrayList, @BizCustomTypeArrow.BizCustomTypeArrow1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addCustomArrowNative(j, this, arrayList, i);
    }

    public void updateCustomPlane(ArrayList<BizCustomPlaneInfo> arrayList, @BizCustomTypePlane.BizCustomTypePlane1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateCustomPlaneNative(j, this, arrayList, i);
    }

    public void addCustomPlane(ArrayList<BizCustomPlaneInfo> arrayList, @BizCustomTypePlane.BizCustomTypePlane1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addCustomPlaneNative(j, this, arrayList, i);
    }

    public void updateCustomGradientPolygon(ArrayList<BizCustomGradientPolygonInfo> arrayList, @BizCustomTypePolygon.BizCustomTypePolygon1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateCustomGradientPolygonNative(j, this, arrayList, i);
    }

    public void addCustomGradientPolygon(ArrayList<BizCustomGradientPolygonInfo> arrayList, @BizCustomTypePolygon.BizCustomTypePolygon1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addCustomGradientPolygonNative(j, this, arrayList, i);
    }

    public BaseLayerImpl getCustomLayer(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        long customLayerNative = getCustomLayerNative(j2, this, j);
        if (customLayerNative == 0) {
            return null;
        }
        return new BaseLayerImpl(customLayerNative, false);
    }
}
