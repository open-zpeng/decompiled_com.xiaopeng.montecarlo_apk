package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.path.model.TrafficStatus;
import com.autonavi.gbl.layer.impl.CruiseCongestionPromptLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.ICruiseCongestionPromptLayerItem;
import com.autonavi.gbl.layer.router.CruiseCongestionPromptLayerItemRouter;
import com.autonavi.gbl.map.layer.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(target = CruiseCongestionPromptLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class CruiseCongestionPromptLayerItem extends QuadrantLayerItem implements ICruiseCongestionPromptLayerItem {
    private static String PACKAGE = ReflexTool.PN(CruiseCongestionPromptLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private CruiseCongestionPromptLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected CruiseCongestionPromptLayerItem(long j, boolean z) {
        this(new CruiseCongestionPromptLayerItemRouter("CruiseCongestionPromptLayerItem", (ICruiseCongestionPromptLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICruiseCongestionPromptLayerItem.class}, new Object[]{this});
    }

    public CruiseCongestionPromptLayerItem(@QuadrantType.QuadrantType1 int i, long j) {
        this(new CruiseCongestionPromptLayerItemRouter("CruiseCongestionPromptLayerItem", (ICruiseCongestionPromptLayerItem) null, i, j));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICruiseCongestionPromptLayerItem.class}, new Object[]{this});
    }

    public CruiseCongestionPromptLayerItem(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        super(cruiseCongestionPromptLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(cruiseCongestionPromptLayerItemImpl);
    }

    private void $constructor(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        if (cruiseCongestionPromptLayerItemImpl != null) {
            this.mService = cruiseCongestionPromptLayerItemImpl;
            this.mTargetId = String.format("CruiseCongestionPromptLayerItem_%s_%d", String.valueOf(CruiseCongestionPromptLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public CruiseCongestionPromptLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
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
        return CruiseCongestionPromptLayerItemImpl.getClassTypeName();
    }

    public void setMEtaTime(int i) {
        CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl = this.mService;
        if (cruiseCongestionPromptLayerItemImpl != null) {
            cruiseCongestionPromptLayerItemImpl.$explicit_setMEtaTime(i);
        }
    }

    public void setMLength(int i) {
        CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl = this.mService;
        if (cruiseCongestionPromptLayerItemImpl != null) {
            cruiseCongestionPromptLayerItemImpl.$explicit_setMLength(i);
        }
    }

    public void setMEnterTime(long j) {
        CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl = this.mService;
        if (cruiseCongestionPromptLayerItemImpl != null) {
            cruiseCongestionPromptLayerItemImpl.$explicit_setMEnterTime(j);
        }
    }

    public void setMEnterCarPos(Coord2DDouble coord2DDouble) {
        CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl = this.mService;
        if (cruiseCongestionPromptLayerItemImpl != null) {
            cruiseCongestionPromptLayerItemImpl.$explicit_setMEnterCarPos(coord2DDouble);
        }
    }

    public void setMCongestionEndPos(Coord2DDouble coord2DDouble) {
        CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl = this.mService;
        if (cruiseCongestionPromptLayerItemImpl != null) {
            cruiseCongestionPromptLayerItemImpl.$explicit_setMCongestionEndPos(coord2DDouble);
        }
    }

    public void setMCongestionStatus(@TrafficStatus.TrafficStatus1 int i) {
        CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl = this.mService;
        if (cruiseCongestionPromptLayerItemImpl != null) {
            cruiseCongestionPromptLayerItemImpl.$explicit_setMCongestionStatus(i);
        }
    }

    public void setMDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl = this.mService;
        if (cruiseCongestionPromptLayerItemImpl != null) {
            cruiseCongestionPromptLayerItemImpl.$explicit_setMDirectionStyle(i);
        }
    }

    public void setMCongestionDetail(String str) {
        CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl = this.mService;
        if (cruiseCongestionPromptLayerItemImpl != null) {
            cruiseCongestionPromptLayerItemImpl.$explicit_setMCongestionDetail(str);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ICruiseCongestionPromptLayerItem
    public int getMEtaTime() {
        CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl = this.mService;
        if (cruiseCongestionPromptLayerItemImpl != null) {
            return cruiseCongestionPromptLayerItemImpl.$explicit_getMEtaTime();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ICruiseCongestionPromptLayerItem
    public int getMLength() {
        CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl = this.mService;
        if (cruiseCongestionPromptLayerItemImpl != null) {
            return cruiseCongestionPromptLayerItemImpl.$explicit_getMLength();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ICruiseCongestionPromptLayerItem
    public long getMEnterTime() {
        CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl = this.mService;
        if (cruiseCongestionPromptLayerItemImpl != null) {
            return cruiseCongestionPromptLayerItemImpl.$explicit_getMEnterTime();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.ICruiseCongestionPromptLayerItem
    public Coord2DDouble getMEnterCarPos() {
        CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl = this.mService;
        if (cruiseCongestionPromptLayerItemImpl != null) {
            return cruiseCongestionPromptLayerItemImpl.$explicit_getMEnterCarPos();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.ICruiseCongestionPromptLayerItem
    public Coord2DDouble getMCongestionEndPos() {
        CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl = this.mService;
        if (cruiseCongestionPromptLayerItemImpl != null) {
            return cruiseCongestionPromptLayerItemImpl.$explicit_getMCongestionEndPos();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.ICruiseCongestionPromptLayerItem
    @TrafficStatus.TrafficStatus1
    public int getMCongestionStatus() {
        CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl = this.mService;
        if (cruiseCongestionPromptLayerItemImpl != null) {
            return cruiseCongestionPromptLayerItemImpl.$explicit_getMCongestionStatus();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ICruiseCongestionPromptLayerItem
    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl = this.mService;
        if (cruiseCongestionPromptLayerItemImpl != null) {
            return cruiseCongestionPromptLayerItemImpl.$explicit_getMDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ICruiseCongestionPromptLayerItem
    public String getMCongestionDetail() {
        CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl = this.mService;
        if (cruiseCongestionPromptLayerItemImpl != null) {
            return cruiseCongestionPromptLayerItemImpl.$explicit_getMCongestionDetail();
        }
        return null;
    }
}
