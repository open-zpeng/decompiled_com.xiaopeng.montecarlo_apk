package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.impl.IBizAGroupControlImpl;
import com.autonavi.gbl.layer.model.BizAGroupBusinessInfo;
import com.autonavi.gbl.layer.model.BizAGroupType;
import com.autonavi.gbl.layer.model.BizPointBusinessInfo;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IBizAGroupControlImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizAGroupControl extends BizControl {
    private static String PACKAGE = ReflexTool.PN(BizAGroupControl.class);
    private IBizAGroupControlImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizAGroupControl(long j, boolean z) {
        this(new IBizAGroupControlImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizAGroupControl.class, this, this.mControl);
        }
    }

    public BizAGroupControl(IBizAGroupControlImpl iBizAGroupControlImpl) {
        super(iBizAGroupControlImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizAGroupControlImpl);
    }

    private void $constructor(IBizAGroupControlImpl iBizAGroupControlImpl) {
        if (iBizAGroupControlImpl != null) {
            this.mControl = iBizAGroupControlImpl;
            this.mTargetId = String.format("BizAGroupControl_%s_%d", String.valueOf(IBizAGroupControlImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public IBizAGroupControlImpl getControl() {
        return this.mControl;
    }

    public boolean addAGroupMembers(ArrayList<BizAGroupBusinessInfo> arrayList) {
        IBizAGroupControlImpl iBizAGroupControlImpl = this.mControl;
        if (iBizAGroupControlImpl != null) {
            return iBizAGroupControlImpl.addAGroupMembers(arrayList);
        }
        return false;
    }

    public boolean updateAGroupMember(BizAGroupBusinessInfo bizAGroupBusinessInfo) {
        IBizAGroupControlImpl iBizAGroupControlImpl = this.mControl;
        if (iBizAGroupControlImpl != null) {
            return iBizAGroupControlImpl.updateAGroupMember(bizAGroupBusinessInfo);
        }
        return false;
    }

    public boolean removeAGroupMember(String str) {
        IBizAGroupControlImpl iBizAGroupControlImpl = this.mControl;
        if (iBizAGroupControlImpl != null) {
            return iBizAGroupControlImpl.removeAGroupMember(str);
        }
        return false;
    }

    public boolean setMemberVisible(String str, boolean z) {
        IBizAGroupControlImpl iBizAGroupControlImpl = this.mControl;
        if (iBizAGroupControlImpl != null) {
            return iBizAGroupControlImpl.setMemberVisible(str, z);
        }
        return false;
    }

    public boolean setEndPoint(BizPointBusinessInfo bizPointBusinessInfo) {
        IBizAGroupControlImpl iBizAGroupControlImpl = this.mControl;
        if (iBizAGroupControlImpl != null) {
            return iBizAGroupControlImpl.setEndPoint(bizPointBusinessInfo);
        }
        return false;
    }

    public RectDouble getPreviewRect(ArrayList<BizAGroupBusinessInfo> arrayList) {
        IBizAGroupControlImpl iBizAGroupControlImpl = this.mControl;
        if (iBizAGroupControlImpl != null) {
            return iBizAGroupControlImpl.getPreviewRect(arrayList);
        }
        return null;
    }

    public BaseLayer getAGroupLayer(@BizAGroupType.BizAGroupType1 int i) {
        BaseLayerImpl aGroupLayer;
        TypeHelper typeHelper;
        try {
            Method method = BizAGroupControl.class.getMethod("getAGroupLayer", Integer.TYPE);
            IBizAGroupControlImpl iBizAGroupControlImpl = this.mControl;
            if (iBizAGroupControlImpl == null || (aGroupLayer = iBizAGroupControlImpl.getAGroupLayer(i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BaseLayer) typeHelper.transfer(method, -1, (Object) aGroupLayer, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    @Override // com.autonavi.gbl.layer.BizControl
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.layer.BizControl
    protected synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
