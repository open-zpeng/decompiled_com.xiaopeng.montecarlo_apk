package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.BizAGroupControl;
import com.autonavi.gbl.layer.model.BizAGroupBusinessInfo;
import com.autonavi.gbl.layer.model.BizAGroupType;
import com.autonavi.gbl.layer.model.BizPointBusinessInfo;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import java.util.ArrayList;
@IntfAuto(target = BizAGroupControl.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBizAGroupControlImpl extends IBizControlImpl {
    private static BindTable BIND_TABLE = new BindTable(IBizAGroupControlImpl.class);
    private transient long swigCPtr;

    private static native long IBizAGroupControlImpl_SWIGUpcast(long j);

    private static native boolean addAGroupMembersNative(long j, IBizAGroupControlImpl iBizAGroupControlImpl, ArrayList<BizAGroupBusinessInfo> arrayList);

    private static native void destroyNativeObj(long j);

    private static native long getAGroupLayerNative(long j, IBizAGroupControlImpl iBizAGroupControlImpl, int i);

    private static native boolean getPreviewRectNative(long j, IBizAGroupControlImpl iBizAGroupControlImpl, ArrayList<BizAGroupBusinessInfo> arrayList, long j2, RectDouble rectDouble);

    private static native boolean removeAGroupMemberNative(long j, IBizAGroupControlImpl iBizAGroupControlImpl, String str);

    private static native boolean setEndPointNative(long j, IBizAGroupControlImpl iBizAGroupControlImpl, long j2, BizPointBusinessInfo bizPointBusinessInfo);

    private static native boolean setMemberVisibleNative(long j, IBizAGroupControlImpl iBizAGroupControlImpl, String str, boolean z);

    private static native boolean updateAGroupMemberNative(long j, IBizAGroupControlImpl iBizAGroupControlImpl, long j2, BizAGroupBusinessInfo bizAGroupBusinessInfo);

    public IBizAGroupControlImpl(long j, boolean z) {
        super(IBizAGroupControlImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof IBizAGroupControlImpl) {
            return getUID(this) == getUID((IBizAGroupControlImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(IBizAGroupControlImpl iBizAGroupControlImpl) {
        long cPtr = getCPtr(iBizAGroupControlImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizAGroupControlImpl iBizAGroupControlImpl) {
        if (iBizAGroupControlImpl == null) {
            return 0L;
        }
        return iBizAGroupControlImpl.swigCPtr;
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

    public boolean addAGroupMembers(ArrayList<BizAGroupBusinessInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addAGroupMembersNative(j, this, arrayList);
    }

    public boolean updateAGroupMember(BizAGroupBusinessInfo bizAGroupBusinessInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateAGroupMemberNative(j, this, 0L, bizAGroupBusinessInfo);
    }

    public boolean removeAGroupMember(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeAGroupMemberNative(j, this, str);
    }

    public boolean setMemberVisible(String str, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setMemberVisibleNative(j, this, str, z);
    }

    public boolean setEndPoint(BizPointBusinessInfo bizPointBusinessInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setEndPointNative(j, this, 0L, bizPointBusinessInfo);
    }

    public RectDouble getPreviewRect(ArrayList<BizAGroupBusinessInfo> arrayList) {
        RectDouble rectDouble = new RectDouble();
        if (Boolean.valueOf(getPreviewRect(arrayList, rectDouble)).booleanValue()) {
            return rectDouble;
        }
        return null;
    }

    private boolean getPreviewRect(ArrayList<BizAGroupBusinessInfo> arrayList, RectDouble rectDouble) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPreviewRectNative(j, this, arrayList, 0L, rectDouble);
    }

    public BaseLayerImpl getAGroupLayer(@BizAGroupType.BizAGroupType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long aGroupLayerNative = getAGroupLayerNative(j, this, i);
        if (aGroupLayerNative == 0) {
            return null;
        }
        return new BaseLayerImpl(aGroupLayerNative, false);
    }
}
