package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.impl.IBizAGroupControl;
import com.autonavi.gbl.layer.model.BizAGroupBusinessInfo;
import com.autonavi.gbl.layer.model.BizAGroupType;
import com.autonavi.gbl.layer.model.BizPointBusinessInfo;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IBizAGroupControl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizAGroupControl extends BizControl {
    private static String PACKAGE = ReflexTool.PN(BizAGroupControl.class);
    private IBizAGroupControl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizAGroupControl(long j, boolean z) {
        this(new IBizAGroupControl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizAGroupControl.class, this, this.mControl);
        }
    }

    public BizAGroupControl(IBizAGroupControl iBizAGroupControl) {
        super(iBizAGroupControl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizAGroupControl);
    }

    private void $constructor(IBizAGroupControl iBizAGroupControl) {
        if (iBizAGroupControl != null) {
            this.mControl = iBizAGroupControl;
            this.mTargetId = String.format("BizAGroupControl_%s_%d", String.valueOf(IBizAGroupControl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public IBizAGroupControl getControl() {
        return this.mControl;
    }

    public RectDouble getPreviewRect(ArrayList<BizAGroupBusinessInfo> arrayList) {
        IBizAGroupControl iBizAGroupControl = this.mControl;
        if (iBizAGroupControl != null) {
            return iBizAGroupControl.getPreviewRect(arrayList);
        }
        return null;
    }

    public boolean addAGroupMembers(ArrayList<BizAGroupBusinessInfo> arrayList) {
        IBizAGroupControl iBizAGroupControl = this.mControl;
        if (iBizAGroupControl != null) {
            return iBizAGroupControl.addAGroupMembers(arrayList);
        }
        return false;
    }

    public boolean updateAGroupMember(BizAGroupBusinessInfo bizAGroupBusinessInfo) {
        IBizAGroupControl iBizAGroupControl = this.mControl;
        if (iBizAGroupControl != null) {
            return iBizAGroupControl.updateAGroupMember(bizAGroupBusinessInfo);
        }
        return false;
    }

    public boolean removeAGroupMember(String str) {
        IBizAGroupControl iBizAGroupControl = this.mControl;
        if (iBizAGroupControl != null) {
            return iBizAGroupControl.removeAGroupMember(str);
        }
        return false;
    }

    public boolean setMemberVisible(String str, boolean z) {
        IBizAGroupControl iBizAGroupControl = this.mControl;
        if (iBizAGroupControl != null) {
            return iBizAGroupControl.setMemberVisible(str, z);
        }
        return false;
    }

    public boolean setEndPoint(BizPointBusinessInfo bizPointBusinessInfo) {
        IBizAGroupControl iBizAGroupControl = this.mControl;
        if (iBizAGroupControl != null) {
            return iBizAGroupControl.setEndPoint(bizPointBusinessInfo);
        }
        return false;
    }

    public BaseLayer getAGroupLayer(@BizAGroupType.BizAGroupType1 int i) {
        BaseLayerImpl aGroupLayer;
        try {
            Method method = BizAGroupControl.class.getMethod("getAGroupLayer", Integer.TYPE);
            IBizAGroupControl iBizAGroupControl = this.mControl;
            if (iBizAGroupControl != null && (aGroupLayer = iBizAGroupControl.getAGroupLayer(i)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, -1, (Object) aGroupLayer, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizAGroupControl.1
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    @Override // com.autonavi.gbl.layer.BizControl
    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizAGroupControl.2
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
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

    @Override // com.autonavi.gbl.layer.BizControl
    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizAGroupControl.3
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.layer.BizControl
    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizAGroupControl.4
        }));
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
