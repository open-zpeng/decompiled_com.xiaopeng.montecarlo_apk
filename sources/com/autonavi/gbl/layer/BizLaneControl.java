package com.autonavi.gbl.layer;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.model.LaneNaviCamera;
import com.autonavi.gbl.lane.model.LaneNaviCongestionInfo;
import com.autonavi.gbl.lane.model.LanePathTrafficEventInfo;
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
public class BizLaneControl {
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

    protected IBizLaneControlImpl getControl() {
        return this.mControl;
    }

    public void setPriorityMode(@LanePriorityMode.LanePriorityMode1 int i) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.setPriorityMode(i);
        }
    }

    public void updateLaneGuideCamera(ArrayList<LaneNaviCamera> arrayList) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.updateLaneGuideCamera(arrayList);
        }
    }

    public void updateLaneGuideCongestion(LaneNaviCongestionInfo laneNaviCongestionInfo) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.updateLaneGuideCongestion(laneNaviCongestionInfo);
        }
    }

    public void updateLaneGuideEvent(LanePathTrafficEventInfo lanePathTrafficEventInfo) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.updateLaneGuideEvent(lanePathTrafficEventInfo);
        }
    }

    public void updateLaneGuideTurn(TurnBubbleInfo turnBubbleInfo) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.updateLaneGuideTurn(turnBubbleInfo);
        }
    }

    public void updateLaneGuideVia(ArrayList<TravelPoint> arrayList) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.updateLaneGuideVia(arrayList);
        }
    }

    public void updateViaPassIndex(long j) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.updateViaPassIndex(j);
        }
    }

    public void updateLaneGuideEnd(ArrayList<TravelPoint> arrayList) {
        IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
        if (iBizLaneControlImpl != null) {
            iBizLaneControlImpl.updateLaneGuideEnd(arrayList);
        }
    }

    public BaseLayer getLaneLayer(@BizLaneType.BizLaneType1 int i) {
        BaseLayerImpl laneLayer;
        try {
            Method method = BizLaneControl.class.getMethod("getLaneLayer", Integer.TYPE);
            IBizLaneControlImpl iBizLaneControlImpl = this.mControl;
            if (iBizLaneControlImpl != null && (laneLayer = iBizLaneControlImpl.getLaneLayer(i)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, -1, (Object) laneLayer, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizLaneControl.1
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizLaneControl.2
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizLaneControl.3
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizLaneControl.4
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
