package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.IBizSearchControl;
import com.autonavi.gbl.layer.model.BizLineBusinessInfo;
import com.autonavi.gbl.layer.model.BizPointBusinessInfo;
import com.autonavi.gbl.layer.model.BizPolygonBusinessInfo;
import com.autonavi.gbl.layer.model.BizSearchAlongWayPoint;
import com.autonavi.gbl.layer.model.BizSearchBeginEndPoint;
import com.autonavi.gbl.layer.model.BizSearchChargeStationInfo;
import com.autonavi.gbl.layer.model.BizSearchChildPoint;
import com.autonavi.gbl.layer.model.BizSearchExitEntrancePoint;
import com.autonavi.gbl.layer.model.BizSearchParentPoint;
import com.autonavi.gbl.layer.model.BizSearchType;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IBizSearchControl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizSearchControl extends BizControl {
    private static String PACKAGE = ReflexTool.PN(BizSearchControl.class);
    private IBizSearchControl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizSearchControl(long j, boolean z) {
        this(new IBizSearchControl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizSearchControl.class, this, this.mControl);
        }
    }

    public BizSearchControl(IBizSearchControl iBizSearchControl) {
        super(iBizSearchControl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizSearchControl);
    }

    private void $constructor(IBizSearchControl iBizSearchControl) {
        if (iBizSearchControl != null) {
            this.mControl = iBizSearchControl;
            this.mTargetId = String.format("BizSearchControl_%s_%d", String.valueOf(IBizSearchControl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public IBizSearchControl getControl() {
        return this.mControl;
    }

    public void updateSearchLine(ArrayList<BizLineBusinessInfo> arrayList) {
        IBizSearchControl iBizSearchControl = this.mControl;
        if (iBizSearchControl != null) {
            iBizSearchControl.updateSearchLine(arrayList);
        }
    }

    public void updateSearchPolygon(BizPolygonBusinessInfo bizPolygonBusinessInfo) {
        IBizSearchControl iBizSearchControl = this.mControl;
        if (iBizSearchControl != null) {
            iBizSearchControl.updateSearchPolygon(bizPolygonBusinessInfo);
        }
    }

    public void updateSearchPolygon(ArrayList<BizPolygonBusinessInfo> arrayList) {
        IBizSearchControl iBizSearchControl = this.mControl;
        if (iBizSearchControl != null) {
            iBizSearchControl.updateSearchPolygon(arrayList);
        }
    }

    public boolean updateSearchParentPoi(ArrayList<BizSearchParentPoint> arrayList) {
        IBizSearchControl iBizSearchControl = this.mControl;
        if (iBizSearchControl != null) {
            return iBizSearchControl.updateSearchParentPoi(arrayList);
        }
        return false;
    }

    public boolean updateSearchChildPoi(ArrayList<BizSearchChildPoint> arrayList) {
        IBizSearchControl iBizSearchControl = this.mControl;
        if (iBizSearchControl != null) {
            return iBizSearchControl.updateSearchChildPoi(arrayList);
        }
        return false;
    }

    public boolean updateSearchCentralPoi(ArrayList<BizPointBusinessInfo> arrayList) {
        IBizSearchControl iBizSearchControl = this.mControl;
        if (iBizSearchControl != null) {
            return iBizSearchControl.updateSearchCentralPoi(arrayList);
        }
        return false;
    }

    public boolean updateSearchExitEntrancePoi(ArrayList<BizSearchExitEntrancePoint> arrayList) {
        IBizSearchControl iBizSearchControl = this.mControl;
        if (iBizSearchControl != null) {
            return iBizSearchControl.updateSearchExitEntrancePoi(arrayList);
        }
        return false;
    }

    public boolean updateSearchBeginEndPoi(ArrayList<BizSearchBeginEndPoint> arrayList) {
        IBizSearchControl iBizSearchControl = this.mControl;
        if (iBizSearchControl != null) {
            return iBizSearchControl.updateSearchBeginEndPoi(arrayList);
        }
        return false;
    }

    public boolean updateSearchAlongRoutePoi(ArrayList<BizSearchAlongWayPoint> arrayList) {
        IBizSearchControl iBizSearchControl = this.mControl;
        if (iBizSearchControl != null) {
            return iBizSearchControl.updateSearchAlongRoutePoi(arrayList);
        }
        return false;
    }

    public boolean updateSearchAlongRoutePoiPop(ArrayList<BizSearchAlongWayPoint> arrayList) {
        IBizSearchControl iBizSearchControl = this.mControl;
        if (iBizSearchControl != null) {
            return iBizSearchControl.updateSearchAlongRoutePoiPop(arrayList);
        }
        return false;
    }

    public boolean updateSearchParkPoi(ArrayList<BizPointBusinessInfo> arrayList) {
        IBizSearchControl iBizSearchControl = this.mControl;
        if (iBizSearchControl != null) {
            return iBizSearchControl.updateSearchParkPoi(arrayList);
        }
        return false;
    }

    public boolean updateSearchPoiLabel(BizPointBusinessInfo bizPointBusinessInfo) {
        IBizSearchControl iBizSearchControl = this.mControl;
        if (iBizSearchControl != null) {
            return iBizSearchControl.updateSearchPoiLabel(bizPointBusinessInfo);
        }
        return false;
    }

    public boolean updateSearchChargeStation(ArrayList<BizSearchChargeStationInfo> arrayList) {
        IBizSearchControl iBizSearchControl = this.mControl;
        if (iBizSearchControl != null) {
            return iBizSearchControl.updateSearchChargeStation(arrayList);
        }
        return false;
    }

    public BaseLayer getSearchLayer(@BizSearchType.BizSearchType1 int i) {
        BaseLayerImpl searchLayer;
        try {
            Method method = BizSearchControl.class.getMethod("getSearchLayer", Integer.TYPE);
            IBizSearchControl iBizSearchControl = this.mControl;
            if (iBizSearchControl != null && (searchLayer = iBizSearchControl.getSearchLayer(i)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, -1, (Object) searchLayer, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizSearchControl.1
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizSearchControl.2
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizSearchControl.3
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.layer.BizControl
    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizSearchControl.4
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
