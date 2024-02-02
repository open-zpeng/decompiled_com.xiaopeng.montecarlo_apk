package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.SearchBeginEndLayerItemImpl;
import com.autonavi.gbl.layer.observer.ISearchBeginEndLayerItem;
import com.autonavi.gbl.layer.router.SearchBeginEndLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = SearchBeginEndLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class SearchBeginEndLayerItem extends PointLayerItem implements ISearchBeginEndLayerItem {
    private static String PACKAGE = ReflexTool.PN(SearchBeginEndLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private SearchBeginEndLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected SearchBeginEndLayerItem(long j, boolean z) {
        this(new SearchBeginEndLayerItemRouter("SearchBeginEndLayerItem", (ISearchBeginEndLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISearchBeginEndLayerItem.class}, new Object[]{this});
    }

    public SearchBeginEndLayerItem(int i, int i2) {
        this(new SearchBeginEndLayerItemRouter("SearchBeginEndLayerItem", (ISearchBeginEndLayerItem) null, i, i2));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISearchBeginEndLayerItem.class}, new Object[]{this});
    }

    public SearchBeginEndLayerItem(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        super(searchBeginEndLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(searchBeginEndLayerItemImpl);
    }

    private void $constructor(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        if (searchBeginEndLayerItemImpl != null) {
            this.mService = searchBeginEndLayerItemImpl;
            this.mTargetId = String.format("SearchBeginEndLayerItem_%s_%d", String.valueOf(SearchBeginEndLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public SearchBeginEndLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SearchBeginEndLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SearchBeginEndLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SearchBeginEndLayerItem.3
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
        return SearchBeginEndLayerItemImpl.getClassTypeName();
    }

    public void setMPointType(int i) {
        SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl = this.mService;
        if (searchBeginEndLayerItemImpl != null) {
            searchBeginEndLayerItemImpl.$explicit_setMPointType(i);
        }
    }

    public void setMPointCount(int i) {
        SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl = this.mService;
        if (searchBeginEndLayerItemImpl != null) {
            searchBeginEndLayerItemImpl.$explicit_setMPointCount(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchBeginEndLayerItem
    public int getMPointType() {
        SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl = this.mService;
        if (searchBeginEndLayerItemImpl != null) {
            return searchBeginEndLayerItemImpl.$explicit_getMPointType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchBeginEndLayerItem
    public int getMPointCount() {
        SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl = this.mService;
        if (searchBeginEndLayerItemImpl != null) {
            return searchBeginEndLayerItemImpl.$explicit_getMPointCount();
        }
        return 0;
    }
}
