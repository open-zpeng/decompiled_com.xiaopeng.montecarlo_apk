package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.CommonLineLayerItemImpl;
import com.autonavi.gbl.layer.observer.ICommonLineLayerItem;
import com.autonavi.gbl.layer.router.CommonLineLayerItemRouter;
import com.autonavi.gbl.map.layer.LineLayerItem;
@IntfAuto(target = CommonLineLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class CommonLineLayerItem extends LineLayerItem implements ICommonLineLayerItem {
    private static String PACKAGE = ReflexTool.PN(CommonLineLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private CommonLineLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected CommonLineLayerItem(long j, boolean z) {
        this(new CommonLineLayerItemRouter("CommonLineLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICommonLineLayerItem.class}, new Object[]{this});
    }

    public CommonLineLayerItem(int i) {
        this(new CommonLineLayerItemRouter("CommonLineLayerItem", null, i));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICommonLineLayerItem.class}, new Object[]{this});
    }

    public CommonLineLayerItem(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        super(commonLineLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(commonLineLayerItemImpl);
    }

    private void $constructor(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        if (commonLineLayerItemImpl != null) {
            this.mService = commonLineLayerItemImpl;
            this.mTargetId = String.format("CommonLineLayerItem_%s_%d", String.valueOf(CommonLineLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public CommonLineLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
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
        return CommonLineLayerItemImpl.getClassTypeName();
    }

    public void setMType(int i) {
        CommonLineLayerItemImpl commonLineLayerItemImpl = this.mService;
        if (commonLineLayerItemImpl != null) {
            commonLineLayerItemImpl.$explicit_setMType(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ICommonLineLayerItem
    public int getMType() {
        CommonLineLayerItemImpl commonLineLayerItemImpl = this.mService;
        if (commonLineLayerItemImpl != null) {
            return commonLineLayerItemImpl.$explicit_getMType();
        }
        return 0;
    }
}
