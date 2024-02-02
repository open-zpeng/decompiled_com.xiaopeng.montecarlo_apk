package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.PopPointLayerItemImpl;
import com.autonavi.gbl.layer.observer.IPopPointLayerItem;
import com.autonavi.gbl.layer.router.PopPointLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = PopPointLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class PopPointLayerItem extends PointLayerItem implements IPopPointLayerItem {
    private static String PACKAGE = ReflexTool.PN(PopPointLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private PopPointLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected PopPointLayerItem(long j, boolean z) {
        this(new PopPointLayerItemRouter("PopPointLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IPopPointLayerItem.class}, new Object[]{this});
    }

    public PopPointLayerItem(String str) {
        this(new PopPointLayerItemRouter("PopPointLayerItem", null, str));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IPopPointLayerItem.class}, new Object[]{this});
    }

    public PopPointLayerItem(PopPointLayerItemImpl popPointLayerItemImpl) {
        super(popPointLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(popPointLayerItemImpl);
    }

    private void $constructor(PopPointLayerItemImpl popPointLayerItemImpl) {
        if (popPointLayerItemImpl != null) {
            this.mService = popPointLayerItemImpl;
            this.mTargetId = String.format("PopPointLayerItem_%s_%d", String.valueOf(PopPointLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public PopPointLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.PopPointLayerItem.1
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.PopPointLayerItem.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.PopPointLayerItem.3
        });
        objArr[1] = String.valueOf(this.mService != null);
        DebugTool.d("%s: mService=%s", objArr);
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
        return PopPointLayerItemImpl.getClassTypeName();
    }

    public void setMText(String str) {
        PopPointLayerItemImpl popPointLayerItemImpl = this.mService;
        if (popPointLayerItemImpl != null) {
            popPointLayerItemImpl.$explicit_setMText(str);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IPopPointLayerItem
    public String getMText() {
        PopPointLayerItemImpl popPointLayerItemImpl = this.mService;
        if (popPointLayerItemImpl != null) {
            return popPointLayerItemImpl.$explicit_getMText();
        }
        return null;
    }
}
