package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.BizAGroupControl;
import com.autonavi.gbl.layer.model.BizAGroupBusinessInfo;
import com.autonavi.gbl.layer.model.BizAGroupType;
import com.autonavi.gbl.layer.model.BizPointBusinessInfo;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import java.util.ArrayList;
@IntfAuto(target = BizAGroupControl.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IBizAGroupControl extends IBizControl {
    private static BindTable BIND_TABLE = new BindTable(IBizAGroupControl.class);
    private transient long swigCPtr;

    private static native long IBizAGroupControl_SWIGUpcast(long j);

    private static native boolean addAGroupMembersNative(long j, IBizAGroupControl iBizAGroupControl, ArrayList<BizAGroupBusinessInfo> arrayList);

    private static native void destroyNativeObj(long j);

    private static native long getAGroupLayerNative(long j, IBizAGroupControl iBizAGroupControl, int i);

    private static native boolean getPreviewRectNative(long j, IBizAGroupControl iBizAGroupControl, ArrayList<BizAGroupBusinessInfo> arrayList, long j2, RectDouble rectDouble);

    private static native boolean removeAGroupMemberNative(long j, IBizAGroupControl iBizAGroupControl, String str);

    private static native boolean setEndPointNative(long j, IBizAGroupControl iBizAGroupControl, long j2, BizPointBusinessInfo bizPointBusinessInfo);

    private static native boolean setMemberVisibleNative(long j, IBizAGroupControl iBizAGroupControl, String str, boolean z);

    private static native boolean updateAGroupMemberNative(long j, IBizAGroupControl iBizAGroupControl, long j2, BizAGroupBusinessInfo bizAGroupBusinessInfo);

    public IBizAGroupControl(long j, boolean z) {
        super(IBizAGroupControl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControl
    public boolean equals(Object obj) {
        if (obj instanceof IBizAGroupControl) {
            return getUID(this) == getUID((IBizAGroupControl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(IBizAGroupControl iBizAGroupControl) {
        long cPtr = getCPtr(iBizAGroupControl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizAGroupControl iBizAGroupControl) {
        if (iBizAGroupControl == null) {
            return 0L;
        }
        return iBizAGroupControl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.IBizControl
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public RectDouble getPreviewRect(ArrayList<BizAGroupBusinessInfo> arrayList) {
        RectDouble rectDouble = new RectDouble();
        if (getPreviewRect(arrayList, rectDouble)) {
            return rectDouble;
        }
        return null;
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
