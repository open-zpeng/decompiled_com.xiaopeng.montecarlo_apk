package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.IBizSearchControlImpl;
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
@IntfAuto(target = IBizSearchControlImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizSearchControl extends BizControl {
    private static String PACKAGE = ReflexTool.PN(BizSearchControl.class);
    private IBizSearchControlImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizSearchControl(long j, boolean z) {
        this(new IBizSearchControlImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizSearchControl.class, this, this.mControl);
        }
    }

    public BizSearchControl(IBizSearchControlImpl iBizSearchControlImpl) {
        super(iBizSearchControlImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizSearchControlImpl);
    }

    private void $constructor(IBizSearchControlImpl iBizSearchControlImpl) {
        if (iBizSearchControlImpl != null) {
            this.mControl = iBizSearchControlImpl;
            this.mTargetId = String.format("BizSearchControl_%s_%d", String.valueOf(IBizSearchControlImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public IBizSearchControlImpl getControl() {
        return this.mControl;
    }

    public void updateSearchLine(ArrayList<BizLineBusinessInfo> arrayList) {
        IBizSearchControlImpl iBizSearchControlImpl = this.mControl;
        if (iBizSearchControlImpl != null) {
            iBizSearchControlImpl.updateSearchLine(arrayList);
        }
    }

    public void updateSearchPolygon(BizPolygonBusinessInfo bizPolygonBusinessInfo) {
        IBizSearchControlImpl iBizSearchControlImpl = this.mControl;
        if (iBizSearchControlImpl != null) {
            iBizSearchControlImpl.updateSearchPolygon(bizPolygonBusinessInfo);
        }
    }

    public void updateSearchPolygon(ArrayList<BizPolygonBusinessInfo> arrayList) {
        IBizSearchControlImpl iBizSearchControlImpl = this.mControl;
        if (iBizSearchControlImpl != null) {
            iBizSearchControlImpl.updateSearchPolygon(arrayList);
        }
    }

    public boolean updateSearchParentPoi(ArrayList<BizSearchParentPoint> arrayList) {
        IBizSearchControlImpl iBizSearchControlImpl = this.mControl;
        if (iBizSearchControlImpl != null) {
            return iBizSearchControlImpl.updateSearchParentPoi(arrayList);
        }
        return false;
    }

    public boolean updateSearchChildPoi(ArrayList<BizSearchChildPoint> arrayList) {
        IBizSearchControlImpl iBizSearchControlImpl = this.mControl;
        if (iBizSearchControlImpl != null) {
            return iBizSearchControlImpl.updateSearchChildPoi(arrayList);
        }
        return false;
    }

    public boolean updateSearchCentralPoi(ArrayList<BizPointBusinessInfo> arrayList) {
        IBizSearchControlImpl iBizSearchControlImpl = this.mControl;
        if (iBizSearchControlImpl != null) {
            return iBizSearchControlImpl.updateSearchCentralPoi(arrayList);
        }
        return false;
    }

    public boolean updateSearchExitEntrancePoi(ArrayList<BizSearchExitEntrancePoint> arrayList) {
        IBizSearchControlImpl iBizSearchControlImpl = this.mControl;
        if (iBizSearchControlImpl != null) {
            return iBizSearchControlImpl.updateSearchExitEntrancePoi(arrayList);
        }
        return false;
    }

    public boolean updateSearchBeginEndPoi(ArrayList<BizSearchBeginEndPoint> arrayList) {
        IBizSearchControlImpl iBizSearchControlImpl = this.mControl;
        if (iBizSearchControlImpl != null) {
            return iBizSearchControlImpl.updateSearchBeginEndPoi(arrayList);
        }
        return false;
    }

    public boolean updateSearchAlongRoutePoi(ArrayList<BizSearchAlongWayPoint> arrayList) {
        IBizSearchControlImpl iBizSearchControlImpl = this.mControl;
        if (iBizSearchControlImpl != null) {
            return iBizSearchControlImpl.updateSearchAlongRoutePoi(arrayList);
        }
        return false;
    }

    public boolean updateSearchAlongRoutePoiPop(ArrayList<BizSearchAlongWayPoint> arrayList) {
        IBizSearchControlImpl iBizSearchControlImpl = this.mControl;
        if (iBizSearchControlImpl != null) {
            return iBizSearchControlImpl.updateSearchAlongRoutePoiPop(arrayList);
        }
        return false;
    }

    public boolean updateSearchParkPoi(ArrayList<BizPointBusinessInfo> arrayList) {
        IBizSearchControlImpl iBizSearchControlImpl = this.mControl;
        if (iBizSearchControlImpl != null) {
            return iBizSearchControlImpl.updateSearchParkPoi(arrayList);
        }
        return false;
    }

    public boolean updateSearchPoiLabel(BizPointBusinessInfo bizPointBusinessInfo) {
        IBizSearchControlImpl iBizSearchControlImpl = this.mControl;
        if (iBizSearchControlImpl != null) {
            return iBizSearchControlImpl.updateSearchPoiLabel(bizPointBusinessInfo);
        }
        return false;
    }

    public boolean updateSearchChargeStation(ArrayList<BizSearchChargeStationInfo> arrayList) {
        IBizSearchControlImpl iBizSearchControlImpl = this.mControl;
        if (iBizSearchControlImpl != null) {
            return iBizSearchControlImpl.updateSearchChargeStation(arrayList);
        }
        return false;
    }

    public BaseLayer getSearchLayer(@BizSearchType.BizSearchType1 int i) {
        BaseLayerImpl searchLayer;
        TypeHelper typeHelper;
        try {
            Method method = BizSearchControl.class.getMethod("getSearchLayer", Integer.TYPE);
            IBizSearchControlImpl iBizSearchControlImpl = this.mControl;
            if (iBizSearchControlImpl == null || (searchLayer = iBizSearchControlImpl.getSearchLayer(i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BaseLayer) typeHelper.transfer(method, -1, (Object) searchLayer, true);
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
