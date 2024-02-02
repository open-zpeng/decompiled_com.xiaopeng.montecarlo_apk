package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.EndAreaParentLayerItemImpl;
import com.autonavi.gbl.layer.model.RouteEndAreaDirection;
import com.autonavi.gbl.layer.observer.IEndAreaParentLayerItem;
import com.autonavi.gbl.layer.router.EndAreaParentLayerItemRouter;
import com.autonavi.gbl.map.layer.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(target = EndAreaParentLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class EndAreaParentLayerItem extends QuadrantLayerItemImpl implements IEndAreaParentLayerItem {
    private static String PACKAGE = ReflexTool.PN(EndAreaParentLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private EndAreaParentLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected EndAreaParentLayerItem(long j, boolean z) {
        this(new EndAreaParentLayerItemRouter("EndAreaParentLayerItem", (IEndAreaParentLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IEndAreaParentLayerItem.class}, new Object[]{this});
    }

    public EndAreaParentLayerItem(@QuadrantType.QuadrantType1 int i, long j) {
        this(new EndAreaParentLayerItemRouter("EndAreaParentLayerItem", (IEndAreaParentLayerItem) null, i, j));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IEndAreaParentLayerItem.class}, new Object[]{this});
    }

    public EndAreaParentLayerItem(@QuadrantType.QuadrantType1 int i) {
        this(new EndAreaParentLayerItemRouter("EndAreaParentLayerItem", null, i));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IEndAreaParentLayerItem.class}, new Object[]{this});
    }

    public EndAreaParentLayerItem(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        super(endAreaParentLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(endAreaParentLayerItemImpl);
    }

    private void $constructor(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        if (endAreaParentLayerItemImpl != null) {
            this.mService = endAreaParentLayerItemImpl;
            this.mTargetId = String.format("EndAreaParentLayerItem_%s_%d", String.valueOf(EndAreaParentLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public EndAreaParentLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.EndAreaParentLayerItem.1
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
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.EndAreaParentLayerItem.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.EndAreaParentLayerItem.3
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
        return EndAreaParentLayerItemImpl.getClassTypeName();
    }

    public void setMPoiName(String str) {
        EndAreaParentLayerItemImpl endAreaParentLayerItemImpl = this.mService;
        if (endAreaParentLayerItemImpl != null) {
            endAreaParentLayerItemImpl.$explicit_setMPoiName(str);
        }
    }

    public void setMTravelTime(long j) {
        EndAreaParentLayerItemImpl endAreaParentLayerItemImpl = this.mService;
        if (endAreaParentLayerItemImpl != null) {
            endAreaParentLayerItemImpl.$explicit_setMTravelTime(j);
        }
    }

    public void setMLeftEnergy(int i) {
        EndAreaParentLayerItemImpl endAreaParentLayerItemImpl = this.mService;
        if (endAreaParentLayerItemImpl != null) {
            endAreaParentLayerItemImpl.$explicit_setMLeftEnergy(i);
        }
    }

    public void setMOddNum(int i) {
        EndAreaParentLayerItemImpl endAreaParentLayerItemImpl = this.mService;
        if (endAreaParentLayerItemImpl != null) {
            endAreaParentLayerItemImpl.$explicit_setMOddNum(i);
        }
    }

    public void setMOddLength(double d) {
        EndAreaParentLayerItemImpl endAreaParentLayerItemImpl = this.mService;
        if (endAreaParentLayerItemImpl != null) {
            endAreaParentLayerItemImpl.$explicit_setMOddLength(d);
        }
    }

    public void setMDirection(@RouteEndAreaDirection.RouteEndAreaDirection1 int i) {
        EndAreaParentLayerItemImpl endAreaParentLayerItemImpl = this.mService;
        if (endAreaParentLayerItemImpl != null) {
            endAreaParentLayerItemImpl.$explicit_setMDirection(i);
        }
    }

    public void setMWeatherID(int i) {
        EndAreaParentLayerItemImpl endAreaParentLayerItemImpl = this.mService;
        if (endAreaParentLayerItemImpl != null) {
            endAreaParentLayerItemImpl.$explicit_setMWeatherID(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IEndAreaParentLayerItem
    public String getMPoiName() {
        EndAreaParentLayerItemImpl endAreaParentLayerItemImpl = this.mService;
        if (endAreaParentLayerItemImpl != null) {
            return endAreaParentLayerItemImpl.$explicit_getMPoiName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IEndAreaParentLayerItem
    public long getMTravelTime() {
        EndAreaParentLayerItemImpl endAreaParentLayerItemImpl = this.mService;
        if (endAreaParentLayerItemImpl != null) {
            return endAreaParentLayerItemImpl.$explicit_getMTravelTime();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.IEndAreaParentLayerItem
    public int getMLeftEnergy() {
        EndAreaParentLayerItemImpl endAreaParentLayerItemImpl = this.mService;
        if (endAreaParentLayerItemImpl != null) {
            return endAreaParentLayerItemImpl.$explicit_getMLeftEnergy();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IEndAreaParentLayerItem
    public int getMOddNum() {
        EndAreaParentLayerItemImpl endAreaParentLayerItemImpl = this.mService;
        if (endAreaParentLayerItemImpl != null) {
            return endAreaParentLayerItemImpl.$explicit_getMOddNum();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IEndAreaParentLayerItem
    public double getMOddLength() {
        EndAreaParentLayerItemImpl endAreaParentLayerItemImpl = this.mService;
        if (endAreaParentLayerItemImpl != null) {
            return endAreaParentLayerItemImpl.$explicit_getMOddLength();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.layer.observer.IEndAreaParentLayerItem
    @RouteEndAreaDirection.RouteEndAreaDirection1
    public int getMDirection() {
        EndAreaParentLayerItemImpl endAreaParentLayerItemImpl = this.mService;
        if (endAreaParentLayerItemImpl != null) {
            return endAreaParentLayerItemImpl.$explicit_getMDirection();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IEndAreaParentLayerItem
    public int getMWeatherID() {
        EndAreaParentLayerItemImpl endAreaParentLayerItemImpl = this.mService;
        if (endAreaParentLayerItemImpl != null) {
            return endAreaParentLayerItemImpl.$explicit_getMWeatherID();
        }
        return 0;
    }
}
