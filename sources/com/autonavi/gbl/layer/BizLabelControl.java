package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.guide.model.CruiseCongestionInfo;
import com.autonavi.gbl.guide.model.LaneInfo;
import com.autonavi.gbl.guide.model.MixForkInfo;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.layer.impl.IBizLabelControl;
import com.autonavi.gbl.layer.model.BizLabelType;
import com.autonavi.gbl.layer.model.BizPointBusinessInfo;
import com.autonavi.gbl.layer.model.BizPopPointBusinessInfo;
import com.autonavi.gbl.layer.model.BizSearchAlongWayPoint;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.model.PointLightParam;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IBizLabelControl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizLabelControl extends BizControl {
    private static String PACKAGE = ReflexTool.PN(BizLabelControl.class);
    private IBizLabelControl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizLabelControl(long j, boolean z) {
        this(new IBizLabelControl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizLabelControl.class, this, this.mControl);
        }
    }

    public BizLabelControl(IBizLabelControl iBizLabelControl) {
        super(iBizLabelControl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizLabelControl);
    }

    private void $constructor(IBizLabelControl iBizLabelControl) {
        if (iBizLabelControl != null) {
            this.mControl = iBizLabelControl;
            this.mTargetId = String.format("BizLabelControl_%s_%d", String.valueOf(IBizLabelControl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public IBizLabelControl getControl() {
        return this.mControl;
    }

    public void updateCruiseLane(LaneInfo laneInfo) {
        IBizLabelControl iBizLabelControl = this.mControl;
        if (iBizLabelControl != null) {
            iBizLabelControl.updateCruiseLane(laneInfo);
        }
    }

    public void updateCruiseCongestion(CruiseCongestionInfo cruiseCongestionInfo, int i, int i2, int i3) {
        IBizLabelControl iBizLabelControl = this.mControl;
        if (iBizLabelControl != null) {
            iBizLabelControl.updateCruiseCongestion(cruiseCongestionInfo, i, i2, i3);
        }
    }

    public void previewCruiseCongestion(CruiseCongestionInfo cruiseCongestionInfo, boolean z, boolean z2) {
        IBizLabelControl iBizLabelControl = this.mControl;
        if (iBizLabelControl != null) {
            iBizLabelControl.previewCruiseCongestion(cruiseCongestionInfo, z, z2);
        }
    }

    public void exitPreviewCruiseCongestion() {
        IBizLabelControl iBizLabelControl = this.mControl;
        if (iBizLabelControl != null) {
            iBizLabelControl.exitPreviewCruiseCongestion();
        }
    }

    public void updateNaviInfo(NaviInfo naviInfo) {
        IBizLabelControl iBizLabelControl = this.mControl;
        if (iBizLabelControl != null) {
            iBizLabelControl.updateNaviInfo(naviInfo);
        }
    }

    public void updateGuideMixForkInfo(ArrayList<MixForkInfo> arrayList) {
        IBizLabelControl iBizLabelControl = this.mControl;
        if (iBizLabelControl != null) {
            iBizLabelControl.updateGuideMixForkInfo(arrayList);
        }
    }

    public void updatePopAddViaPointInfo(ArrayList<BizSearchAlongWayPoint> arrayList) {
        IBizLabelControl iBizLabelControl = this.mControl;
        if (iBizLabelControl != null) {
            iBizLabelControl.updatePopAddViaPointInfo(arrayList);
        }
    }

    public void updatePopRemoveViaPointInfo(ArrayList<BizPopPointBusinessInfo> arrayList) {
        IBizLabelControl iBizLabelControl = this.mControl;
        if (iBizLabelControl != null) {
            iBizLabelControl.updatePopRemoveViaPointInfo(arrayList);
        }
    }

    public void updatePopTrafficEventInfo(ArrayList<BizPopPointBusinessInfo> arrayList) {
        IBizLabelControl iBizLabelControl = this.mControl;
        if (iBizLabelControl != null) {
            iBizLabelControl.updatePopTrafficEventInfo(arrayList);
        }
    }

    public void updatePopSearchPointInfo(ArrayList<BizPopPointBusinessInfo> arrayList) {
        IBizLabelControl iBizLabelControl = this.mControl;
        if (iBizLabelControl != null) {
            iBizLabelControl.updatePopSearchPointInfo(arrayList);
        }
    }

    public void updatePopEndAreaPointBoxInfo(ArrayList<BizPopPointBusinessInfo> arrayList) {
        IBizLabelControl iBizLabelControl = this.mControl;
        if (iBizLabelControl != null) {
            iBizLabelControl.updatePopEndAreaPointBoxInfo(arrayList);
        }
    }

    public void updateGpsPointsInfo(ArrayList<BizPointBusinessInfo> arrayList) {
        IBizLabelControl iBizLabelControl = this.mControl;
        if (iBizLabelControl != null) {
            iBizLabelControl.updateGpsPointsInfo(arrayList);
        }
    }

    public void updateDesLightBeamPoint(Coord3DDouble coord3DDouble) {
        IBizLabelControl iBizLabelControl = this.mControl;
        if (iBizLabelControl != null) {
            iBizLabelControl.updateDesLightBeamPoint(coord3DDouble);
        }
    }

    public void setDesLightBeamScale(float f, float f2) {
        IBizLabelControl iBizLabelControl = this.mControl;
        if (iBizLabelControl != null) {
            iBizLabelControl.setDesLightBeamScale(f, f2);
        }
    }

    public void updatePointLightParam(ArrayList<PointLightParam> arrayList) {
        IBizLabelControl iBizLabelControl = this.mControl;
        if (iBizLabelControl != null) {
            iBizLabelControl.updatePointLightParam(arrayList);
        }
    }

    public BaseLayer getLabelLayer(@BizLabelType.BizLabelType1 int i) {
        BaseLayerImpl labelLayer;
        try {
            Method method = BizLabelControl.class.getMethod("getLabelLayer", Integer.TYPE);
            IBizLabelControl iBizLabelControl = this.mControl;
            if (iBizLabelControl != null && (labelLayer = iBizLabelControl.getLabelLayer(i)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, -1, (Object) labelLayer, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizLabelControl.1
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizLabelControl.2
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizLabelControl.3
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.layer.BizControl
    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizLabelControl.4
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
