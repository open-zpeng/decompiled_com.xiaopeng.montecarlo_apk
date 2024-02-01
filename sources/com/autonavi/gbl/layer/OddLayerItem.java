package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.impl.OddLayerItemImpl;
import com.autonavi.gbl.layer.model.BizOddInfo;
import com.autonavi.gbl.layer.model.ODDPointType;
import com.autonavi.gbl.layer.observer.IOddLayerItem;
import com.autonavi.gbl.layer.router.OddLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = OddLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class OddLayerItem extends PointLayerItem implements IOddLayerItem {
    private static String PACKAGE = ReflexTool.PN(OddLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private OddLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected OddLayerItem(long j, boolean z) {
        this(new OddLayerItemRouter("OddLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IOddLayerItem.class}, new Object[]{this});
    }

    public OddLayerItem(@ODDPointType.ODDPointType1 int i, BizOddInfo bizOddInfo, RectDouble rectDouble, long j) {
        this(new OddLayerItemRouter("OddLayerItem", null, i, bizOddInfo, rectDouble, j));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IOddLayerItem.class}, new Object[]{this});
    }

    public OddLayerItem(OddLayerItemImpl oddLayerItemImpl) {
        super(oddLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(oddLayerItemImpl);
    }

    private void $constructor(OddLayerItemImpl oddLayerItemImpl) {
        if (oddLayerItemImpl != null) {
            this.mService = oddLayerItemImpl;
            this.mTargetId = String.format("OddLayerItem_%s_%d", String.valueOf(OddLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public OddLayerItemImpl getService() {
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
        return OddLayerItemImpl.getClassTypeName();
    }

    public void setMPointType(@ODDPointType.ODDPointType1 int i) {
        OddLayerItemImpl oddLayerItemImpl = this.mService;
        if (oddLayerItemImpl != null) {
            oddLayerItemImpl.$explicit_setMPointType(i);
        }
    }

    public void setMOddInfo(BizOddInfo bizOddInfo) {
        OddLayerItemImpl oddLayerItemImpl = this.mService;
        if (oddLayerItemImpl != null) {
            oddLayerItemImpl.$explicit_setMOddInfo(bizOddInfo);
        }
    }

    public void setMRect(RectDouble rectDouble) {
        OddLayerItemImpl oddLayerItemImpl = this.mService;
        if (oddLayerItemImpl != null) {
            oddLayerItemImpl.$explicit_setMRect(rectDouble);
        }
    }

    public void setOddIndex(long j) {
        OddLayerItemImpl oddLayerItemImpl = this.mService;
        if (oddLayerItemImpl != null) {
            oddLayerItemImpl.$explicit_setOddIndex(j);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IOddLayerItem
    @ODDPointType.ODDPointType1
    public int getMPointType() {
        OddLayerItemImpl oddLayerItemImpl = this.mService;
        if (oddLayerItemImpl != null) {
            return oddLayerItemImpl.$explicit_getMPointType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IOddLayerItem
    public BizOddInfo getMOddInfo() {
        OddLayerItemImpl oddLayerItemImpl = this.mService;
        if (oddLayerItemImpl != null) {
            return oddLayerItemImpl.$explicit_getMOddInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IOddLayerItem
    public RectDouble getMRect() {
        OddLayerItemImpl oddLayerItemImpl = this.mService;
        if (oddLayerItemImpl != null) {
            return oddLayerItemImpl.$explicit_getMRect();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IOddLayerItem
    public long getOddIndex() {
        OddLayerItemImpl oddLayerItemImpl = this.mService;
        if (oddLayerItemImpl != null) {
            return oddLayerItemImpl.$explicit_getOddIndex();
        }
        return 0L;
    }
}
