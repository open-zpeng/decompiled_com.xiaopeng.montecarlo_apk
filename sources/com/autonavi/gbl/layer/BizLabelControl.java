package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.guide.model.CruiseCongestionInfo;
import com.autonavi.gbl.guide.model.LaneInfo;
import com.autonavi.gbl.guide.model.MixForkInfo;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.layer.impl.IBizLabelControlImpl;
import com.autonavi.gbl.layer.model.BizLabelType;
import com.autonavi.gbl.layer.model.BizPointBusinessInfo;
import com.autonavi.gbl.layer.model.BizPopPointBusinessInfo;
import com.autonavi.gbl.layer.model.BizSearchAlongWayPoint;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.model.PointLightParam;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IBizLabelControlImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizLabelControl extends BizControl {
    private static String PACKAGE = ReflexTool.PN(BizLabelControl.class);
    private IBizLabelControlImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizLabelControl(long j, boolean z) {
        this(new IBizLabelControlImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizLabelControl.class, this, this.mControl);
        }
    }

    public BizLabelControl(IBizLabelControlImpl iBizLabelControlImpl) {
        super(iBizLabelControlImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizLabelControlImpl);
    }

    private void $constructor(IBizLabelControlImpl iBizLabelControlImpl) {
        if (iBizLabelControlImpl != null) {
            this.mControl = iBizLabelControlImpl;
            this.mTargetId = String.format("BizLabelControl_%s_%d", String.valueOf(IBizLabelControlImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public IBizLabelControlImpl getControl() {
        return this.mControl;
    }

    public void updateCruiseLane(LaneInfo laneInfo) {
        IBizLabelControlImpl iBizLabelControlImpl = this.mControl;
        if (iBizLabelControlImpl != null) {
            iBizLabelControlImpl.updateCruiseLane(laneInfo);
        }
    }

    public void updateCruiseCongestion(CruiseCongestionInfo cruiseCongestionInfo, int i, int i2, int i3) {
        IBizLabelControlImpl iBizLabelControlImpl = this.mControl;
        if (iBizLabelControlImpl != null) {
            iBizLabelControlImpl.updateCruiseCongestion(cruiseCongestionInfo, i, i2, i3);
        }
    }

    public void previewCruiseCongestion(CruiseCongestionInfo cruiseCongestionInfo, boolean z, boolean z2) {
        IBizLabelControlImpl iBizLabelControlImpl = this.mControl;
        if (iBizLabelControlImpl != null) {
            iBizLabelControlImpl.previewCruiseCongestion(cruiseCongestionInfo, z, z2);
        }
    }

    public void exitPreviewCruiseCongestion() {
        IBizLabelControlImpl iBizLabelControlImpl = this.mControl;
        if (iBizLabelControlImpl != null) {
            iBizLabelControlImpl.exitPreviewCruiseCongestion();
        }
    }

    public void updateNaviInfo(NaviInfo naviInfo) {
        IBizLabelControlImpl iBizLabelControlImpl = this.mControl;
        if (iBizLabelControlImpl != null) {
            iBizLabelControlImpl.updateNaviInfo(naviInfo);
        }
    }

    public void updateGuideMixForkInfo(ArrayList<MixForkInfo> arrayList) {
        IBizLabelControlImpl iBizLabelControlImpl = this.mControl;
        if (iBizLabelControlImpl != null) {
            iBizLabelControlImpl.updateGuideMixForkInfo(arrayList);
        }
    }

    public void updatePopAddViaPointInfo(ArrayList<BizSearchAlongWayPoint> arrayList) {
        IBizLabelControlImpl iBizLabelControlImpl = this.mControl;
        if (iBizLabelControlImpl != null) {
            iBizLabelControlImpl.updatePopAddViaPointInfo(arrayList);
        }
    }

    public void updatePopRemoveViaPointInfo(ArrayList<BizPopPointBusinessInfo> arrayList) {
        IBizLabelControlImpl iBizLabelControlImpl = this.mControl;
        if (iBizLabelControlImpl != null) {
            iBizLabelControlImpl.updatePopRemoveViaPointInfo(arrayList);
        }
    }

    public void updatePopTrafficEventInfo(ArrayList<BizPopPointBusinessInfo> arrayList) {
        IBizLabelControlImpl iBizLabelControlImpl = this.mControl;
        if (iBizLabelControlImpl != null) {
            iBizLabelControlImpl.updatePopTrafficEventInfo(arrayList);
        }
    }

    public void updatePopSearchPointInfo(ArrayList<BizPopPointBusinessInfo> arrayList) {
        IBizLabelControlImpl iBizLabelControlImpl = this.mControl;
        if (iBizLabelControlImpl != null) {
            iBizLabelControlImpl.updatePopSearchPointInfo(arrayList);
        }
    }

    public void updatePopEndAreaPointBoxInfo(ArrayList<BizPopPointBusinessInfo> arrayList) {
        IBizLabelControlImpl iBizLabelControlImpl = this.mControl;
        if (iBizLabelControlImpl != null) {
            iBizLabelControlImpl.updatePopEndAreaPointBoxInfo(arrayList);
        }
    }

    public void updateGpsPointsInfo(ArrayList<BizPointBusinessInfo> arrayList) {
        IBizLabelControlImpl iBizLabelControlImpl = this.mControl;
        if (iBizLabelControlImpl != null) {
            iBizLabelControlImpl.updateGpsPointsInfo(arrayList);
        }
    }

    public void updateDesLightBeamPoint(Coord3DDouble coord3DDouble) {
        IBizLabelControlImpl iBizLabelControlImpl = this.mControl;
        if (iBizLabelControlImpl != null) {
            iBizLabelControlImpl.updateDesLightBeamPoint(coord3DDouble);
        }
    }

    public void setDesLightBeamScale(float f, float f2) {
        IBizLabelControlImpl iBizLabelControlImpl = this.mControl;
        if (iBizLabelControlImpl != null) {
            iBizLabelControlImpl.setDesLightBeamScale(f, f2);
        }
    }

    public void updatePointLightParam(ArrayList<PointLightParam> arrayList) {
        IBizLabelControlImpl iBizLabelControlImpl = this.mControl;
        if (iBizLabelControlImpl != null) {
            iBizLabelControlImpl.updatePointLightParam(arrayList);
        }
    }

    public BaseLayer getLabelLayer(@BizLabelType.BizLabelType1 int i) {
        BaseLayerImpl labelLayer;
        TypeHelper typeHelper;
        try {
            Method method = BizLabelControl.class.getMethod("getLabelLayer", Integer.TYPE);
            IBizLabelControlImpl iBizLabelControlImpl = this.mControl;
            if (iBizLabelControlImpl == null || (labelLayer = iBizLabelControlImpl.getLabelLayer(i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BaseLayer) typeHelper.transfer(method, -1, (Object) labelLayer, true);
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
