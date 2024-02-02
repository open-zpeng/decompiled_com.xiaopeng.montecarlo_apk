package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.SearchExitEntranceLayerItemImpl;
import com.autonavi.gbl.layer.observer.ISearchExitEntranceLayerItem;
import com.autonavi.gbl.layer.router.SearchExitEntranceLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = SearchExitEntranceLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class SearchExitEntranceLayerItem extends PointLayerItem implements ISearchExitEntranceLayerItem {
    private static String PACKAGE = ReflexTool.PN(SearchExitEntranceLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private SearchExitEntranceLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected SearchExitEntranceLayerItem(long j, boolean z) {
        this(new SearchExitEntranceLayerItemRouter("SearchExitEntranceLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISearchExitEntranceLayerItem.class}, new Object[]{this});
    }

    public SearchExitEntranceLayerItem(int i) {
        this(new SearchExitEntranceLayerItemRouter("SearchExitEntranceLayerItem", null, i));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISearchExitEntranceLayerItem.class}, new Object[]{this});
    }

    public SearchExitEntranceLayerItem(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        super(searchExitEntranceLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(searchExitEntranceLayerItemImpl);
    }

    private void $constructor(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        if (searchExitEntranceLayerItemImpl != null) {
            this.mService = searchExitEntranceLayerItemImpl;
            this.mTargetId = String.format("SearchExitEntranceLayerItem_%s_%d", String.valueOf(SearchExitEntranceLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public SearchExitEntranceLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SearchExitEntranceLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SearchExitEntranceLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SearchExitEntranceLayerItem.3
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
        return SearchExitEntranceLayerItemImpl.getClassTypeName();
    }

    public void setMType(int i) {
        SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl = this.mService;
        if (searchExitEntranceLayerItemImpl != null) {
            searchExitEntranceLayerItemImpl.$explicit_setMType(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchExitEntranceLayerItem
    public int getMType() {
        SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl = this.mService;
        if (searchExitEntranceLayerItemImpl != null) {
            return searchExitEntranceLayerItemImpl.$explicit_getMType();
        }
        return 0;
    }
}
