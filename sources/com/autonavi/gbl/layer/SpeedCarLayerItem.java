package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.SpeedCarLayerItemImpl;
import com.autonavi.gbl.layer.observer.ISpeedCarLayerItem;
import com.autonavi.gbl.layer.router.SpeedCarLayerItemRouter;
import com.autonavi.gbl.map.layer.NaviPointLayerItem;
@IntfAuto(target = SpeedCarLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class SpeedCarLayerItem extends NaviPointLayerItem implements ISpeedCarLayerItem {
    private static String PACKAGE = ReflexTool.PN(SpeedCarLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private SpeedCarLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected SpeedCarLayerItem(long j, boolean z) {
        this(new SpeedCarLayerItemRouter("SpeedCarLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISpeedCarLayerItem.class}, new Object[]{this});
    }

    public SpeedCarLayerItem(boolean z) {
        this(new SpeedCarLayerItemRouter("SpeedCarLayerItem", null, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISpeedCarLayerItem.class}, new Object[]{this});
    }

    public SpeedCarLayerItem(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        super(speedCarLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(speedCarLayerItemImpl);
    }

    private void $constructor(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        if (speedCarLayerItemImpl != null) {
            this.mService = speedCarLayerItemImpl;
            this.mTargetId = String.format("SpeedCarLayerItem_%s_%d", String.valueOf(SpeedCarLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.NaviPointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public SpeedCarLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.NaviPointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SpeedCarLayerItem.1
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
    @Override // com.autonavi.gbl.map.layer.NaviPointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SpeedCarLayerItem.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.NaviPointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.NaviPointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SpeedCarLayerItem.3
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
        return SpeedCarLayerItemImpl.getClassTypeName();
    }

    public void setBBackGround(boolean z) {
        SpeedCarLayerItemImpl speedCarLayerItemImpl = this.mService;
        if (speedCarLayerItemImpl != null) {
            speedCarLayerItemImpl.$explicit_setBBackGround(z);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ISpeedCarLayerItem
    public boolean getBBackGround() {
        SpeedCarLayerItemImpl speedCarLayerItemImpl = this.mService;
        if (speedCarLayerItemImpl != null) {
            return speedCarLayerItemImpl.$explicit_getBBackGround();
        }
        return false;
    }
}
