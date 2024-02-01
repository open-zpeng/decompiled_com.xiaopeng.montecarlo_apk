package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.guide.model.CruiseFacilityType;
import com.autonavi.gbl.layer.impl.CruiseFacilityLayerItemImpl;
import com.autonavi.gbl.layer.model.BizCruiseFacilityInfo;
import com.autonavi.gbl.layer.observer.ICruiseFacilityLayerItem;
import com.autonavi.gbl.layer.router.CruiseFacilityLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
import java.util.ArrayList;
@IntfAuto(target = CruiseFacilityLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class CruiseFacilityLayerItem extends PointLayerItem implements ICruiseFacilityLayerItem {
    private static String PACKAGE = ReflexTool.PN(CruiseFacilityLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private CruiseFacilityLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected CruiseFacilityLayerItem(long j, boolean z) {
        this(new CruiseFacilityLayerItemRouter("CruiseFacilityLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICruiseFacilityLayerItem.class}, new Object[]{this});
    }

    public CruiseFacilityLayerItem(@CruiseFacilityType.CruiseFacilityType1 int i, int i2, int i3) {
        this(new CruiseFacilityLayerItemRouter("CruiseFacilityLayerItem", null, i, i2, i3));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICruiseFacilityLayerItem.class}, new Object[]{this});
    }

    public CruiseFacilityLayerItem(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        super(cruiseFacilityLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(cruiseFacilityLayerItemImpl);
    }

    private void $constructor(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        if (cruiseFacilityLayerItemImpl != null) {
            this.mService = cruiseFacilityLayerItemImpl;
            this.mTargetId = String.format("CruiseFacilityLayerItem_%s_%d", String.valueOf(CruiseFacilityLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public CruiseFacilityLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mService != null) {
            if (this.mTypeHelper != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                TypeHelper.unbindAllTarget(ReflexTool.PN(this.mService.getClass()), this.mService);
            }
            this.mService = null;
        }
        unbind();
    }

    public static String getClassTypeName() {
        return CruiseFacilityLayerItemImpl.getClassTypeName();
    }

    public void setMType(@CruiseFacilityType.CruiseFacilityType1 int i) {
        CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl = this.mService;
        if (cruiseFacilityLayerItemImpl != null) {
            cruiseFacilityLayerItemImpl.$explicit_setMType(i);
        }
    }

    public void setMSpeed(int i) {
        CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl = this.mService;
        if (cruiseFacilityLayerItemImpl != null) {
            cruiseFacilityLayerItemImpl.$explicit_setMSpeed(i);
        }
    }

    public void setMDistance(int i) {
        CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl = this.mService;
        if (cruiseFacilityLayerItemImpl != null) {
            cruiseFacilityLayerItemImpl.$explicit_setMDistance(i);
        }
    }

    public void setMFacilityList(ArrayList<BizCruiseFacilityInfo> arrayList) {
        CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl = this.mService;
        if (cruiseFacilityLayerItemImpl != null) {
            cruiseFacilityLayerItemImpl.$explicit_setMFacilityList(arrayList);
        }
    }

    public void setIndex(int i) {
        CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl = this.mService;
        if (cruiseFacilityLayerItemImpl != null) {
            cruiseFacilityLayerItemImpl.$explicit_setIndex(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ICruiseFacilityLayerItem
    @CruiseFacilityType.CruiseFacilityType1
    public int getMType() {
        CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl = this.mService;
        if (cruiseFacilityLayerItemImpl != null) {
            return cruiseFacilityLayerItemImpl.$explicit_getMType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ICruiseFacilityLayerItem
    public int getMSpeed() {
        CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl = this.mService;
        if (cruiseFacilityLayerItemImpl != null) {
            return cruiseFacilityLayerItemImpl.$explicit_getMSpeed();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ICruiseFacilityLayerItem
    public int getMDistance() {
        CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl = this.mService;
        if (cruiseFacilityLayerItemImpl != null) {
            return cruiseFacilityLayerItemImpl.$explicit_getMDistance();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ICruiseFacilityLayerItem
    public ArrayList<BizCruiseFacilityInfo> getMFacilityList() {
        CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl = this.mService;
        if (cruiseFacilityLayerItemImpl != null) {
            return cruiseFacilityLayerItemImpl.$explicit_getMFacilityList();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.ICruiseFacilityLayerItem
    public int getIndex() {
        CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl = this.mService;
        if (cruiseFacilityLayerItemImpl != null) {
            return cruiseFacilityLayerItemImpl.$explicit_getIndex();
        }
        return 0;
    }
}
