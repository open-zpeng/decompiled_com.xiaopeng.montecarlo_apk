package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.SearchChargeStationLayerItemImpl;
import com.autonavi.gbl.layer.model.BizChargeStationInfo;
import com.autonavi.gbl.layer.model.BizSearchChargeStationInfo;
import com.autonavi.gbl.layer.observer.ISearchChargeStationLayerItem;
import com.autonavi.gbl.layer.router.SearchChargeStationLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
import com.autonavi.gbl.map.layer.model.Visible3V;
@IntfAuto(target = SearchChargeStationLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class SearchChargeStationLayerItem extends PointLayerItem implements ISearchChargeStationLayerItem {
    private static String PACKAGE = ReflexTool.PN(SearchChargeStationLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private SearchChargeStationLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected SearchChargeStationLayerItem(long j, boolean z) {
        this(new SearchChargeStationLayerItemRouter("SearchChargeStationLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISearchChargeStationLayerItem.class}, new Object[]{this});
    }

    public SearchChargeStationLayerItem(BizSearchChargeStationInfo bizSearchChargeStationInfo) {
        this(new SearchChargeStationLayerItemRouter("SearchChargeStationLayerItem", null, bizSearchChargeStationInfo));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISearchChargeStationLayerItem.class}, new Object[]{this});
    }

    public SearchChargeStationLayerItem(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        super(searchChargeStationLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(searchChargeStationLayerItemImpl);
    }

    private void $constructor(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        if (searchChargeStationLayerItemImpl != null) {
            this.mService = searchChargeStationLayerItemImpl;
            this.mTargetId = String.format("SearchChargeStationLayerItem_%s_%d", String.valueOf(SearchChargeStationLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public SearchChargeStationLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SearchChargeStationLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SearchChargeStationLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SearchChargeStationLayerItem.3
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
        return SearchChargeStationLayerItemImpl.getClassTypeName();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.observer.ICollisionItem
    public void resetOnVisible(boolean z) {
        SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl = this.mService;
        if (searchChargeStationLayerItemImpl != null) {
            searchChargeStationLayerItemImpl.$explicit_resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.observer.ICollisionItem
    public void applyOnVisible() {
        SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl = this.mService;
        if (searchChargeStationLayerItemImpl != null) {
            searchChargeStationLayerItemImpl.$explicit_applyOnVisible();
        }
    }

    public void setMChargeStationInfo(BizChargeStationInfo bizChargeStationInfo) {
        SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl = this.mService;
        if (searchChargeStationLayerItemImpl != null) {
            searchChargeStationLayerItemImpl.$explicit_setMChargeStationInfo(bizChargeStationInfo);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.observer.ICollisionItem, com.autonavi.gbl.layer.observer.IRouteBlockLayerItem
    public void onVisible(boolean z) {
        SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl = this.mService;
        if (searchChargeStationLayerItemImpl != null) {
            searchChargeStationLayerItemImpl.$explicit_onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.observer.ICollisionItem, com.autonavi.gbl.layer.observer.ISearchChargeStationLayerItem
    public boolean getOnVisible() {
        SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl = this.mService;
        if (searchChargeStationLayerItemImpl != null) {
            return searchChargeStationLayerItemImpl.$explicit_getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchChargeStationLayerItem
    public void onVisible3V(Visible3V visible3V) {
        SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl = this.mService;
        if (searchChargeStationLayerItemImpl != null) {
            searchChargeStationLayerItemImpl.$explicit_onVisible3V(visible3V);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchChargeStationLayerItem
    public Visible3V getOnVisible3V() {
        SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl = this.mService;
        if (searchChargeStationLayerItemImpl != null) {
            return searchChargeStationLayerItemImpl.$explicit_getOnVisible3V();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchChargeStationLayerItem
    public BizChargeStationInfo getMChargeStationInfo() {
        SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl = this.mService;
        if (searchChargeStationLayerItemImpl != null) {
            return searchChargeStationLayerItemImpl.$explicit_getMChargeStationInfo();
        }
        return null;
    }
}
