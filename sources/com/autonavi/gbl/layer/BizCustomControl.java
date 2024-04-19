package com.autonavi.gbl.layer;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.IBizCustomControl;
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
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IBizCustomControl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizCustomControl extends BizControl {
    private static String PACKAGE = ReflexTool.PN(BizCustomControl.class);
    private IBizCustomControl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizCustomControl(long j, boolean z) {
        this(new IBizCustomControl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizCustomControl.class, this, this.mControl);
        }
    }

    public BizCustomControl(IBizCustomControl iBizCustomControl) {
        super(iBizCustomControl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizCustomControl);
    }

    private void $constructor(IBizCustomControl iBizCustomControl) {
        if (iBizCustomControl != null) {
            this.mControl = iBizCustomControl;
            this.mTargetId = String.format("BizCustomControl_%s_%d", String.valueOf(IBizCustomControl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public IBizCustomControl getControl() {
        return this.mControl;
    }

    public void updateCustomPoint(ArrayList<BizCustomPointInfo> arrayList, @BizCustomTypePoint.BizCustomTypePoint1 int i) {
        IBizCustomControl iBizCustomControl = this.mControl;
        if (iBizCustomControl != null) {
            iBizCustomControl.updateCustomPoint(arrayList, i);
        }
    }

    public void addCustomPoint(ArrayList<BizCustomPointInfo> arrayList, @BizCustomTypePoint.BizCustomTypePoint1 int i) {
        IBizCustomControl iBizCustomControl = this.mControl;
        if (iBizCustomControl != null) {
            iBizCustomControl.addCustomPoint(arrayList, i);
        }
    }

    public void updateCustomLine(ArrayList<BizCustomLineInfo> arrayList, @BizCustomTypeLine.BizCustomTypeLine1 int i) {
        IBizCustomControl iBizCustomControl = this.mControl;
        if (iBizCustomControl != null) {
            iBizCustomControl.updateCustomLine(arrayList, i);
        }
    }

    public void addCustomLine(ArrayList<BizCustomLineInfo> arrayList, @BizCustomTypeLine.BizCustomTypeLine1 int i) {
        IBizCustomControl iBizCustomControl = this.mControl;
        if (iBizCustomControl != null) {
            iBizCustomControl.addCustomLine(arrayList, i);
        }
    }

    public void updateCustomPolygon(ArrayList<BizCustomPolygonInfo> arrayList, @BizCustomTypePolygon.BizCustomTypePolygon1 int i) {
        IBizCustomControl iBizCustomControl = this.mControl;
        if (iBizCustomControl != null) {
            iBizCustomControl.updateCustomPolygon(arrayList, i);
        }
    }

    public void addCustomPolygon(ArrayList<BizCustomPolygonInfo> arrayList, @BizCustomTypePolygon.BizCustomTypePolygon1 int i) {
        IBizCustomControl iBizCustomControl = this.mControl;
        if (iBizCustomControl != null) {
            iBizCustomControl.addCustomPolygon(arrayList, i);
        }
    }

    public void updateCustomCircle(ArrayList<BizCustomCircleInfo> arrayList, @BizCustomTypeCircle.BizCustomTypeCircle1 int i) {
        IBizCustomControl iBizCustomControl = this.mControl;
        if (iBizCustomControl != null) {
            iBizCustomControl.updateCustomCircle(arrayList, i);
        }
    }

    public void addCustomCircle(ArrayList<BizCustomCircleInfo> arrayList, @BizCustomTypeCircle.BizCustomTypeCircle1 int i) {
        IBizCustomControl iBizCustomControl = this.mControl;
        if (iBizCustomControl != null) {
            iBizCustomControl.addCustomCircle(arrayList, i);
        }
    }

    public void updateCustomArrow(ArrayList<BizCustomArrowInfo> arrayList, @BizCustomTypeArrow.BizCustomTypeArrow1 int i) {
        IBizCustomControl iBizCustomControl = this.mControl;
        if (iBizCustomControl != null) {
            iBizCustomControl.updateCustomArrow(arrayList, i);
        }
    }

    public void addCustomArrow(ArrayList<BizCustomArrowInfo> arrayList, @BizCustomTypeArrow.BizCustomTypeArrow1 int i) {
        IBizCustomControl iBizCustomControl = this.mControl;
        if (iBizCustomControl != null) {
            iBizCustomControl.addCustomArrow(arrayList, i);
        }
    }

    public void updateCustomPlane(ArrayList<BizCustomPlaneInfo> arrayList, @BizCustomTypePlane.BizCustomTypePlane1 int i) {
        IBizCustomControl iBizCustomControl = this.mControl;
        if (iBizCustomControl != null) {
            iBizCustomControl.updateCustomPlane(arrayList, i);
        }
    }

    public void addCustomPlane(ArrayList<BizCustomPlaneInfo> arrayList, @BizCustomTypePlane.BizCustomTypePlane1 int i) {
        IBizCustomControl iBizCustomControl = this.mControl;
        if (iBizCustomControl != null) {
            iBizCustomControl.addCustomPlane(arrayList, i);
        }
    }

    public void updateCustomGradientPolygon(ArrayList<BizCustomGradientPolygonInfo> arrayList, @BizCustomTypePolygon.BizCustomTypePolygon1 int i) {
        IBizCustomControl iBizCustomControl = this.mControl;
        if (iBizCustomControl != null) {
            iBizCustomControl.updateCustomGradientPolygon(arrayList, i);
        }
    }

    public void addCustomGradientPolygon(ArrayList<BizCustomGradientPolygonInfo> arrayList, @BizCustomTypePolygon.BizCustomTypePolygon1 int i) {
        IBizCustomControl iBizCustomControl = this.mControl;
        if (iBizCustomControl != null) {
            iBizCustomControl.addCustomGradientPolygon(arrayList, i);
        }
    }

    public BaseLayer getCustomLayer(long j) {
        BaseLayerImpl customLayer;
        try {
            Method method = BizCustomControl.class.getMethod("getCustomLayer", Long.TYPE);
            IBizCustomControl iBizCustomControl = this.mControl;
            if (iBizCustomControl != null && (customLayer = iBizCustomControl.getCustomLayer(j)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, -1, (Object) customLayer, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizCustomControl.1
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizCustomControl.2
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizCustomControl.3
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.layer.BizControl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizCustomControl.4
        }));
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            ReflexTool.invokeDeclMethodSafe(this.mControl, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mControl = null;
        }
        unbind();
    }
}
