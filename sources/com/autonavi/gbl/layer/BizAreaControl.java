package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.layer.impl.IBizAreaControl;
import com.autonavi.gbl.layer.model.BizAreaType;
import com.autonavi.gbl.layer.model.BizCircleBusinessInfo;
import com.autonavi.gbl.layer.model.BizRouteEndAreaInfo;
import com.autonavi.gbl.layer.model.BizRouteRestrictInfo;
import com.autonavi.gbl.layer.model.RangeOnMapPolygonInfo;
import com.autonavi.gbl.layer.model.RouteEndAreaType;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.model.PolygonGradientPointInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IBizAreaControl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizAreaControl extends BizControl {
    private static String PACKAGE = ReflexTool.PN(BizAreaControl.class);
    private IBizAreaControl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizAreaControl(long j, boolean z) {
        this(new IBizAreaControl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizAreaControl.class, this, this.mControl);
        }
    }

    public BizAreaControl(IBizAreaControl iBizAreaControl) {
        super(iBizAreaControl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizAreaControl);
    }

    private void $constructor(IBizAreaControl iBizAreaControl) {
        if (iBizAreaControl != null) {
            this.mControl = iBizAreaControl;
            this.mTargetId = String.format("BizAreaControl_%s_%d", String.valueOf(IBizAreaControl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public IBizAreaControl getControl() {
        return this.mControl;
    }

    public void updateRangeOnMapPolygon(ArrayList<RangeOnMapPolygonInfo> arrayList) {
        IBizAreaControl iBizAreaControl = this.mControl;
        if (iBizAreaControl != null) {
            iBizAreaControl.updateRangeOnMapPolygon(arrayList);
        }
    }

    public void updateRangeOnMapCircle(BizCircleBusinessInfo bizCircleBusinessInfo) {
        IBizAreaControl iBizAreaControl = this.mControl;
        if (iBizAreaControl != null) {
            iBizAreaControl.updateRangeOnMapCircle(bizCircleBusinessInfo);
        }
    }

    public void updateRangeOnMapGradient(ArrayList<PolygonGradientPointInfo> arrayList, boolean z) {
        IBizAreaControl iBizAreaControl = this.mControl;
        if (iBizAreaControl != null) {
            iBizAreaControl.updateRangeOnMapGradient(arrayList, z);
        }
    }

    public void clearRangeOnMapLayer() {
        IBizAreaControl iBizAreaControl = this.mControl;
        if (iBizAreaControl != null) {
            iBizAreaControl.clearRangeOnMapLayer();
        }
    }

    public void updateRouteRestrict(BizRouteRestrictInfo bizRouteRestrictInfo) {
        IBizAreaControl iBizAreaControl = this.mControl;
        if (iBizAreaControl != null) {
            iBizAreaControl.updateRouteRestrict(bizRouteRestrictInfo);
        }
    }

    public void updateRouteEndArea(BizRouteEndAreaInfo bizRouteEndAreaInfo, RectInt rectInt) {
        IBizAreaControl iBizAreaControl = this.mControl;
        if (iBizAreaControl != null) {
            iBizAreaControl.updateRouteEndArea(bizRouteEndAreaInfo, rectInt);
        }
    }

    public void updateRouteEndAreaPreviewRect(RectInt rectInt) {
        IBizAreaControl iBizAreaControl = this.mControl;
        if (iBizAreaControl != null) {
            iBizAreaControl.updateRouteEndAreaPreviewRect(rectInt);
        }
    }

    public void clearRouteEndArea(@RouteEndAreaType.RouteEndAreaType1 int i) {
        IBizAreaControl iBizAreaControl = this.mControl;
        if (iBizAreaControl != null) {
            iBizAreaControl.clearRouteEndArea(i);
        }
    }

    public void setIndoorMaskingSwitch(boolean z) {
        IBizAreaControl iBizAreaControl = this.mControl;
        if (iBizAreaControl != null) {
            iBizAreaControl.setIndoorMaskingSwitch(z);
        }
    }

    public BaseLayer getAreaLayer(@BizAreaType.BizAreaType1 int i) {
        BaseLayerImpl areaLayer;
        try {
            Method method = BizAreaControl.class.getMethod("getAreaLayer", Integer.TYPE);
            IBizAreaControl iBizAreaControl = this.mControl;
            if (iBizAreaControl != null && (areaLayer = iBizAreaControl.getAreaLayer(i)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, -1, (Object) areaLayer, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizAreaControl.1
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizAreaControl.2
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizAreaControl.3
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.layer.BizControl
    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizAreaControl.4
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
