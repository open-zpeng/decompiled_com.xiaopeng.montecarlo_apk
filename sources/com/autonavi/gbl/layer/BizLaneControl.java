package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.model.LaneNaviBubbleInfo;
import com.autonavi.gbl.lane.model.LaneNaviCamera;
import com.autonavi.gbl.lane.model.LaneNaviCongestionInfo;
import com.autonavi.gbl.lane.model.LaneNaviInfo;
import com.autonavi.gbl.lane.model.LaneOddInfo;
import com.autonavi.gbl.lane.model.LanePathTrafficEventInfo;
import com.autonavi.gbl.lane.model.SpecialLaneBubbleInfo;
import com.autonavi.gbl.lane.model.TravelPoint;
import com.autonavi.gbl.lane.model.TurnBubbleInfo;
import com.autonavi.gbl.layer.impl.IBizLaneControlImpl;
import com.autonavi.gbl.layer.model.BizLaneType;
import com.autonavi.gbl.layer.model.LanePriorityMode;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IBizLaneControlImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizLaneControl extends BizControl {
    private static String PACKAGE = ReflexTool.PN(BizLaneControl.class);
    private IBizLaneControlImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizLaneControl(long j, boolean z) {
        this(new IBizLaneControlImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizLaneControl.class, this, this.mControl);
        }
    }

    public BizLaneControl(IBizLaneControlImpl iBizLaneControlImpl) {
        super(iBizLaneControlImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizLaneControlImpl);
    }

    private void $constructor(IBizLaneControlImpl iBizLaneControlImpl) {
        if (iBizLaneControlImpl != null) {
            this.mControl = iBizLaneControlImpl;
            this.mTargetId = String.format("BizLaneControl_%s_%d", String.valueOf(IBizLaneControlImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public IBizLaneControlImpl getControl() {
        return this.mControl;
    }

    @Deprecated
    public void setPriorityMode(@LanePriorityMode.LanePriorityMode1 int i) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.setPriorityMode(i);
        }
    }

    public BaseLayer getLaneLayer(@BizLaneType.BizLaneType1 int i) {
        BaseLayerImpl laneLayer;
        TypeHelper typeHelper;
        try {
            Method method = BizLaneControl.class.getMethod("getLaneLayer", Integer.TYPE);
            IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
            if (iBizLaneControlImpl == null || (laneLayer = iBizLaneControlImpl.getLaneLayer(i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BaseLayer) typeHelper.transfer(method, -1, (Object) laneLayer, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    @Deprecated
    public void updateLaneGuideCamera(ArrayList<LaneNaviCamera> arrayList) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.updateLaneGuideCamera(arrayList);
        }
    }

    @Deprecated
    public void updateLaneGuideCongestion(LaneNaviCongestionInfo laneNaviCongestionInfo) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.updateLaneGuideCongestion(laneNaviCongestionInfo);
        }
    }

    @Deprecated
    public void updateLaneGuideEvent(LanePathTrafficEventInfo lanePathTrafficEventInfo) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.updateLaneGuideEvent(lanePathTrafficEventInfo);
        }
    }

    @Deprecated
    public void updateLaneGuideTurn(TurnBubbleInfo turnBubbleInfo) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.updateLaneGuideTurn(turnBubbleInfo);
        }
    }

    @Deprecated
    public void updateLaneGuideVia(ArrayList<TravelPoint> arrayList) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.updateLaneGuideVia(arrayList);
        }
    }

    @Deprecated
    public void updateViaPassIndex(long j) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.updateViaPassIndex(j);
        }
    }

    @Deprecated
    public void updateLaneGuideEnd(ArrayList<TravelPoint> arrayList) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.updateLaneGuideEnd(arrayList);
        }
    }

    @Deprecated
    public void updateLaneGuideOdd(ArrayList<LaneOddInfo> arrayList) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.updateLaneGuideOdd(arrayList);
        }
    }

    @Deprecated
    public void updateLaneGuideBus(SpecialLaneBubbleInfo specialLaneBubbleInfo) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.updateLaneGuideBus(specialLaneBubbleInfo);
        }
    }

    @Deprecated
    public void updateLaneGuideHov(SpecialLaneBubbleInfo specialLaneBubbleInfo) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.updateLaneGuideHov(specialLaneBubbleInfo);
        }
    }

    @Deprecated
    public void updateLaneGuideSolidLine(ArrayList<LaneNaviBubbleInfo> arrayList) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.updateLaneGuideSolidLine(arrayList);
        }
    }

    @Deprecated
    public void updateLaneNaviInfo(LaneNaviInfo laneNaviInfo) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.updateLaneNaviInfo(laneNaviInfo);
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
