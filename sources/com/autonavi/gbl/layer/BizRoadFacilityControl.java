package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.guide.model.CruiseCongestionInfo;
import com.autonavi.gbl.guide.model.CruiseEventInfo;
import com.autonavi.gbl.guide.model.CruiseFacilityInfo;
import com.autonavi.gbl.guide.model.NaviCamera;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.guide.model.NaviIntervalCamera;
import com.autonavi.gbl.guide.model.NaviRoadFacility;
import com.autonavi.gbl.guide.model.SocolEventInfo;
import com.autonavi.gbl.guide.model.TrafficEventInfo;
import com.autonavi.gbl.guide.model.TrafficSignal;
import com.autonavi.gbl.layer.impl.CruiseCongestionLayerOption;
import com.autonavi.gbl.layer.impl.IBizRoadFacilityControl;
import com.autonavi.gbl.layer.model.BizLocalTrafficEventInfo;
import com.autonavi.gbl.layer.model.BizRoadFacilityType;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IBizRoadFacilityControl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizRoadFacilityControl extends BizControl {
    private static String PACKAGE = ReflexTool.PN(BizRoadFacilityControl.class);
    private IBizRoadFacilityControl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizRoadFacilityControl(long j, boolean z) {
        this(new IBizRoadFacilityControl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizRoadFacilityControl.class, this, this.mControl);
        }
    }

    public BizRoadFacilityControl(IBizRoadFacilityControl iBizRoadFacilityControl) {
        super(iBizRoadFacilityControl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizRoadFacilityControl);
    }

    private void $constructor(IBizRoadFacilityControl iBizRoadFacilityControl) {
        if (iBizRoadFacilityControl != null) {
            this.mControl = iBizRoadFacilityControl;
            this.mTargetId = String.format("BizRoadFacilityControl_%s_%d", String.valueOf(IBizRoadFacilityControl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public IBizRoadFacilityControl getControl() {
        return this.mControl;
    }

    public BaseLayer getFacilityLayer(@BizRoadFacilityType.BizRoadFacilityType1 int i) {
        BaseLayerImpl facilityLayer;
        try {
            Method method = BizRoadFacilityControl.class.getMethod("getFacilityLayer", Integer.TYPE);
            IBizRoadFacilityControl iBizRoadFacilityControl = this.mControl;
            if (iBizRoadFacilityControl != null && (facilityLayer = iBizRoadFacilityControl.getFacilityLayer(i)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, -1, (Object) facilityLayer, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizRoadFacilityControl.1
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void updateCruiseFacility(ArrayList<CruiseFacilityInfo> arrayList) {
        IBizRoadFacilityControl iBizRoadFacilityControl = this.mControl;
        if (iBizRoadFacilityControl != null) {
            iBizRoadFacilityControl.updateCruiseFacility(arrayList);
        }
    }

    public void updateCruiseCamera(ArrayList<CruiseFacilityInfo> arrayList) {
        IBizRoadFacilityControl iBizRoadFacilityControl = this.mControl;
        if (iBizRoadFacilityControl != null) {
            iBizRoadFacilityControl.updateCruiseCamera(arrayList);
        }
    }

    public void updateCruiseEvent(ArrayList<CruiseEventInfo> arrayList) {
        IBizRoadFacilityControl iBizRoadFacilityControl = this.mControl;
        if (iBizRoadFacilityControl != null) {
            iBizRoadFacilityControl.updateCruiseEvent(arrayList);
        }
    }

    public void updateCruiseCongestionEvent(ArrayList<SocolEventInfo> arrayList) {
        IBizRoadFacilityControl iBizRoadFacilityControl = this.mControl;
        if (iBizRoadFacilityControl != null) {
            iBizRoadFacilityControl.updateCruiseCongestionEvent(arrayList);
        }
    }

    public void updateGuideCamera(ArrayList<NaviCamera> arrayList) {
        IBizRoadFacilityControl iBizRoadFacilityControl = this.mControl;
        if (iBizRoadFacilityControl != null) {
            iBizRoadFacilityControl.updateGuideCamera(arrayList);
        }
    }

    public void enableDistanceRefresh(boolean z) {
        IBizRoadFacilityControl iBizRoadFacilityControl = this.mControl;
        if (iBizRoadFacilityControl != null) {
            iBizRoadFacilityControl.enableDistanceRefresh(z);
        }
    }

    public void updateGuideIntervalCamera(ArrayList<NaviIntervalCamera> arrayList) {
        IBizRoadFacilityControl iBizRoadFacilityControl = this.mControl;
        if (iBizRoadFacilityControl != null) {
            iBizRoadFacilityControl.updateGuideIntervalCamera(arrayList);
        }
    }

    public void updateGuideRoadFacility(ArrayList<NaviRoadFacility> arrayList) {
        IBizRoadFacilityControl iBizRoadFacilityControl = this.mControl;
        if (iBizRoadFacilityControl != null) {
            iBizRoadFacilityControl.updateGuideRoadFacility(arrayList);
        }
    }

    public void updateGuideTrafficEvent(ArrayList<TrafficEventInfo> arrayList, boolean z) {
        IBizRoadFacilityControl iBizRoadFacilityControl = this.mControl;
        if (iBizRoadFacilityControl != null) {
            iBizRoadFacilityControl.updateGuideTrafficEvent(arrayList, z);
        }
    }

    public void updateTrafficLight(ArrayList<TrafficSignal> arrayList) {
        IBizRoadFacilityControl iBizRoadFacilityControl = this.mControl;
        if (iBizRoadFacilityControl != null) {
            iBizRoadFacilityControl.updateTrafficLight(arrayList);
        }
    }

    public void updateNaviInfo(NaviInfo naviInfo) {
        IBizRoadFacilityControl iBizRoadFacilityControl = this.mControl;
        if (iBizRoadFacilityControl != null) {
            iBizRoadFacilityControl.updateNaviInfo(naviInfo);
        }
    }

    public void updateLocalTrafficEventInfo(ArrayList<BizLocalTrafficEventInfo> arrayList) {
        IBizRoadFacilityControl iBizRoadFacilityControl = this.mControl;
        if (iBizRoadFacilityControl != null) {
            iBizRoadFacilityControl.updateLocalTrafficEventInfo(arrayList);
        }
    }

    public void initCruiseCongestionLayerOption(CruiseCongestionLayerOption cruiseCongestionLayerOption) {
        IBizRoadFacilityControl iBizRoadFacilityControl = this.mControl;
        if (iBizRoadFacilityControl != null) {
            iBizRoadFacilityControl.initCruiseCongestionLayerOption(cruiseCongestionLayerOption);
        }
    }

    public int parseGuideCameraLayerProperty(String str) {
        IBizRoadFacilityControl iBizRoadFacilityControl = this.mControl;
        if (iBizRoadFacilityControl != null) {
            return iBizRoadFacilityControl.parseGuideCameraLayerProperty(str);
        }
        return 0;
    }

    public void enableCameraArrowCollision(boolean z) {
        IBizRoadFacilityControl iBizRoadFacilityControl = this.mControl;
        if (iBizRoadFacilityControl != null) {
            iBizRoadFacilityControl.enableCameraArrowCollision(z);
        }
    }

    public void updateCruiseCongestion(CruiseCongestionInfo cruiseCongestionInfo) {
        IBizRoadFacilityControl iBizRoadFacilityControl = this.mControl;
        if (iBizRoadFacilityControl != null) {
            iBizRoadFacilityControl.updateCruiseCongestion(cruiseCongestionInfo);
        }
    }

    public void enableCameraGrown(boolean z) {
        IBizRoadFacilityControl iBizRoadFacilityControl = this.mControl;
        if (iBizRoadFacilityControl != null) {
            iBizRoadFacilityControl.enableCameraGrown(z);
        }
    }

    @Override // com.autonavi.gbl.layer.BizControl
    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizRoadFacilityControl.2
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizRoadFacilityControl.3
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.layer.BizControl
    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizRoadFacilityControl.4
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
