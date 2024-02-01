package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.layer.impl.IBizAreaControlImpl;
import com.autonavi.gbl.layer.model.BizAreaType;
import com.autonavi.gbl.layer.model.BizCircleBusinessInfo;
import com.autonavi.gbl.layer.model.BizRouteEndAreaInfo;
import com.autonavi.gbl.layer.model.BizRouteEndAreasInfo;
import com.autonavi.gbl.layer.model.BizRouteRestrictInfo;
import com.autonavi.gbl.layer.model.RangeOnMapPolygonInfo;
import com.autonavi.gbl.layer.model.RouteEndAreaType;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.model.PolygonGradientPointInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IBizAreaControlImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizAreaControl extends BizControl {
    private static String PACKAGE = ReflexTool.PN(BizAreaControl.class);
    private IBizAreaControlImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizAreaControl(long j, boolean z) {
        this(new IBizAreaControlImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizAreaControl.class, this, this.mControl);
        }
    }

    public BizAreaControl(IBizAreaControlImpl iBizAreaControlImpl) {
        super(iBizAreaControlImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizAreaControlImpl);
    }

    private void $constructor(IBizAreaControlImpl iBizAreaControlImpl) {
        if (iBizAreaControlImpl != null) {
            this.mControl = iBizAreaControlImpl;
            this.mTargetId = String.format("BizAreaControl_%s_%d", String.valueOf(IBizAreaControlImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public IBizAreaControlImpl getControl() {
        return this.mControl;
    }

    public void updateRangeOnMapPolygon(ArrayList<RangeOnMapPolygonInfo> arrayList) {
        IBizAreaControlImpl iBizAreaControlImpl = this.mControl;
        if (iBizAreaControlImpl != null) {
            iBizAreaControlImpl.updateRangeOnMapPolygon(arrayList);
        }
    }

    public void updateRangeOnMapCircle(BizCircleBusinessInfo bizCircleBusinessInfo) {
        IBizAreaControlImpl iBizAreaControlImpl = this.mControl;
        if (iBizAreaControlImpl != null) {
            iBizAreaControlImpl.updateRangeOnMapCircle(bizCircleBusinessInfo);
        }
    }

    public void updateRangeOnMapGradient(ArrayList<PolygonGradientPointInfo> arrayList, boolean z) {
        IBizAreaControlImpl iBizAreaControlImpl = this.mControl;
        if (iBizAreaControlImpl != null) {
            iBizAreaControlImpl.updateRangeOnMapGradient(arrayList, z);
        }
    }

    public void clearRangeOnMapLayer() {
        IBizAreaControlImpl iBizAreaControlImpl = this.mControl;
        if (iBizAreaControlImpl != null) {
            iBizAreaControlImpl.clearRangeOnMapLayer();
        }
    }

    public void updateRouteRestrict(BizRouteRestrictInfo bizRouteRestrictInfo) {
        IBizAreaControlImpl iBizAreaControlImpl = this.mControl;
        if (iBizAreaControlImpl != null) {
            iBizAreaControlImpl.updateRouteRestrict(bizRouteRestrictInfo);
        }
    }

    @Deprecated
    public void updateRouteEndArea(BizRouteEndAreaInfo bizRouteEndAreaInfo, RectInt rectInt) {
        IBizAreaControlImpl iBizAreaControlImpl = this.mControl;
        if (iBizAreaControlImpl != null) {
            iBizAreaControlImpl.updateRouteEndArea(bizRouteEndAreaInfo, rectInt);
        }
    }

    public void updateRouteEndAreas(BizRouteEndAreasInfo bizRouteEndAreasInfo, RectInt rectInt) {
        IBizAreaControlImpl iBizAreaControlImpl = this.mControl;
        if (iBizAreaControlImpl != null) {
            iBizAreaControlImpl.updateRouteEndAreas(bizRouteEndAreasInfo, rectInt);
        }
    }

    public void updateRouteEndAreaPreviewRect(RectInt rectInt) {
        IBizAreaControlImpl iBizAreaControlImpl = this.mControl;
        if (iBizAreaControlImpl != null) {
            iBizAreaControlImpl.updateRouteEndAreaPreviewRect(rectInt);
        }
    }

    public void clearRouteEndArea(@RouteEndAreaType.RouteEndAreaType1 int i) {
        IBizAreaControlImpl iBizAreaControlImpl = this.mControl;
        if (iBizAreaControlImpl != null) {
            iBizAreaControlImpl.clearRouteEndArea(i);
        }
    }

    public void setIndoorMaskingSwitch(boolean z) {
        IBizAreaControlImpl iBizAreaControlImpl = this.mControl;
        if (iBizAreaControlImpl != null) {
            iBizAreaControlImpl.setIndoorMaskingSwitch(z);
        }
    }

    public BaseLayer getAreaLayer(@BizAreaType.BizAreaType1 int i) {
        BaseLayerImpl areaLayer;
        TypeHelper typeHelper;
        try {
            Method method = BizAreaControl.class.getMethod("getAreaLayer", Integer.TYPE);
            IBizAreaControlImpl iBizAreaControlImpl = this.mControl;
            if (iBizAreaControlImpl == null || (areaLayer = iBizAreaControlImpl.getAreaLayer(i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BaseLayer) typeHelper.transfer(method, -1, (Object) areaLayer, true);
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
