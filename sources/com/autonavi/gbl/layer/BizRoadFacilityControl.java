package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.guide.model.CruiseCongestionInfo;
import com.autonavi.gbl.guide.model.CruiseEventInfo;
import com.autonavi.gbl.guide.model.CruiseFacilityInfo;
import com.autonavi.gbl.guide.model.NaviCameraExt;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.guide.model.NaviRoadFacility;
import com.autonavi.gbl.guide.model.SocolEventInfo;
import com.autonavi.gbl.guide.model.TrafficEventInfo;
import com.autonavi.gbl.guide.model.TrafficLightCountdown;
import com.autonavi.gbl.guide.model.TrafficSignal;
import com.autonavi.gbl.layer.impl.IBizRoadFacilityControlImpl;
import com.autonavi.gbl.layer.model.BizLocalTrafficEventInfo;
import com.autonavi.gbl.layer.model.BizRoadFacilityType;
import com.autonavi.gbl.layer.model.CruiseCongestionLayerOption;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IBizRoadFacilityControlImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizRoadFacilityControl extends BizControl {
    private static String PACKAGE = ReflexTool.PN(BizRoadFacilityControl.class);
    private IBizRoadFacilityControlImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizRoadFacilityControl(long j, boolean z) {
        this(new IBizRoadFacilityControlImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizRoadFacilityControl.class, this, this.mControl);
        }
    }

    public BizRoadFacilityControl(IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl) {
        super(iBizRoadFacilityControlImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizRoadFacilityControlImpl);
    }

    private void $constructor(IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl) {
        if (iBizRoadFacilityControlImpl != null) {
            this.mControl = iBizRoadFacilityControlImpl;
            this.mTargetId = String.format("BizRoadFacilityControl_%s_%d", String.valueOf(IBizRoadFacilityControlImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public IBizRoadFacilityControlImpl getControl() {
        return this.mControl;
    }

    public BaseLayer getFacilityLayer(@BizRoadFacilityType.BizRoadFacilityType1 int i) {
        BaseLayerImpl facilityLayer;
        TypeHelper typeHelper;
        try {
            Method method = BizRoadFacilityControl.class.getMethod("getFacilityLayer", Integer.TYPE);
            IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl = this.mControl;
            if (iBizRoadFacilityControlImpl == null || (facilityLayer = iBizRoadFacilityControlImpl.getFacilityLayer(i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BaseLayer) typeHelper.transfer(method, -1, (Object) facilityLayer, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void updateCruiseFacility(ArrayList<CruiseFacilityInfo> arrayList) {
        IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl = this.mControl;
        if (iBizRoadFacilityControlImpl != null) {
            iBizRoadFacilityControlImpl.updateCruiseFacility(arrayList);
        }
    }

    public void updateCruiseCamera(ArrayList<CruiseFacilityInfo> arrayList) {
        IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl = this.mControl;
        if (iBizRoadFacilityControlImpl != null) {
            iBizRoadFacilityControlImpl.updateCruiseCamera(arrayList);
        }
    }

    public void updateCruiseEvent(ArrayList<CruiseEventInfo> arrayList) {
        IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl = this.mControl;
        if (iBizRoadFacilityControlImpl != null) {
            iBizRoadFacilityControlImpl.updateCruiseEvent(arrayList);
        }
    }

    public void updateCruiseCongestionEvent(ArrayList<SocolEventInfo> arrayList) {
        IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl = this.mControl;
        if (iBizRoadFacilityControlImpl != null) {
            iBizRoadFacilityControlImpl.updateCruiseCongestionEvent(arrayList);
        }
    }

    public void updateGuideCamera(ArrayList<NaviCameraExt> arrayList) {
        IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl = this.mControl;
        if (iBizRoadFacilityControlImpl != null) {
            iBizRoadFacilityControlImpl.updateGuideCamera(arrayList);
        }
    }

    public void enableDistanceRefresh(boolean z) {
        IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl = this.mControl;
        if (iBizRoadFacilityControlImpl != null) {
            iBizRoadFacilityControlImpl.enableDistanceRefresh(z);
        }
    }

    public void updateGuideRoadFacility(ArrayList<NaviRoadFacility> arrayList) {
        IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl = this.mControl;
        if (iBizRoadFacilityControlImpl != null) {
            iBizRoadFacilityControlImpl.updateGuideRoadFacility(arrayList);
        }
    }

    public void updateGuideTrafficEvent(ArrayList<TrafficEventInfo> arrayList, boolean z) {
        IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl = this.mControl;
        if (iBizRoadFacilityControlImpl != null) {
            iBizRoadFacilityControlImpl.updateGuideTrafficEvent(arrayList, z);
        }
    }

    public void updateTrafficLight(ArrayList<TrafficSignal> arrayList) {
        IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl = this.mControl;
        if (iBizRoadFacilityControlImpl != null) {
            iBizRoadFacilityControlImpl.updateTrafficLight(arrayList);
        }
    }

    public void updateTrafficLightCountdown(ArrayList<TrafficLightCountdown> arrayList) {
        IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl = this.mControl;
        if (iBizRoadFacilityControlImpl != null) {
            iBizRoadFacilityControlImpl.updateTrafficLightCountdown(arrayList);
        }
    }

    public void updateNaviInfo(NaviInfo naviInfo) {
        IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl = this.mControl;
        if (iBizRoadFacilityControlImpl != null) {
            iBizRoadFacilityControlImpl.updateNaviInfo(naviInfo);
        }
    }

    public void updateLocalTrafficEventInfo(ArrayList<BizLocalTrafficEventInfo> arrayList) {
        IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl = this.mControl;
        if (iBizRoadFacilityControlImpl != null) {
            iBizRoadFacilityControlImpl.updateLocalTrafficEventInfo(arrayList);
        }
    }

    public void initCruiseCongestionLayerOption(CruiseCongestionLayerOption cruiseCongestionLayerOption) {
        IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl = this.mControl;
        if (iBizRoadFacilityControlImpl != null) {
            iBizRoadFacilityControlImpl.initCruiseCongestionLayerOption(cruiseCongestionLayerOption);
        }
    }

    public int parseGuideCameraLayerProperty(String str) {
        IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl = this.mControl;
        if (iBizRoadFacilityControlImpl != null) {
            return iBizRoadFacilityControlImpl.parseGuideCameraLayerProperty(str);
        }
        return 0;
    }

    public void enableCameraArrowCollision(boolean z) {
        IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl = this.mControl;
        if (iBizRoadFacilityControlImpl != null) {
            iBizRoadFacilityControlImpl.enableCameraArrowCollision(z);
        }
    }

    public void updateCruiseCongestion(CruiseCongestionInfo cruiseCongestionInfo) {
        IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl = this.mControl;
        if (iBizRoadFacilityControlImpl != null) {
            iBizRoadFacilityControlImpl.updateCruiseCongestion(cruiseCongestionInfo);
        }
    }

    public void enableTrafficSignalLight(boolean z) {
        IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl = this.mControl;
        if (iBizRoadFacilityControlImpl != null) {
            iBizRoadFacilityControlImpl.enableTrafficSignalLight(z);
        }
    }

    public void enableCameraGrown(boolean z) {
        IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl = this.mControl;
        if (iBizRoadFacilityControlImpl != null) {
            iBizRoadFacilityControlImpl.enableCameraGrown(z);
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
