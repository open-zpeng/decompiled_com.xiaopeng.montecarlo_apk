package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.SearchAlongWayLayerItemImpl;
import com.autonavi.gbl.layer.model.AlongWayLabelType;
import com.autonavi.gbl.layer.model.SearchAlongWayExtraData;
import com.autonavi.gbl.layer.model.SearchAlongwayType;
import com.autonavi.gbl.layer.observer.ISearchAlongWayLayerItem;
import com.autonavi.gbl.layer.router.SearchAlongWayLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = SearchAlongWayLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class SearchAlongWayLayerItem extends PointLayerItem implements ISearchAlongWayLayerItem {
    private static String PACKAGE = ReflexTool.PN(SearchAlongWayLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private SearchAlongWayLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected SearchAlongWayLayerItem(long j, boolean z) {
        this(new SearchAlongWayLayerItemRouter("SearchAlongWayLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISearchAlongWayLayerItem.class}, new Object[]{this});
    }

    public SearchAlongWayLayerItem(SearchAlongWayExtraData searchAlongWayExtraData, @SearchAlongwayType.SearchAlongwayType1 int i, @AlongWayLabelType.AlongWayLabelType1 int i2, int i3, String str) {
        this(new SearchAlongWayLayerItemRouter("SearchAlongWayLayerItem", null, searchAlongWayExtraData, i, i2, i3, str));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISearchAlongWayLayerItem.class}, new Object[]{this});
    }

    public SearchAlongWayLayerItem(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        super(searchAlongWayLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(searchAlongWayLayerItemImpl);
    }

    private void $constructor(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        if (searchAlongWayLayerItemImpl != null) {
            this.mService = searchAlongWayLayerItemImpl;
            this.mTargetId = String.format("SearchAlongWayLayerItem_%s_%d", String.valueOf(SearchAlongWayLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public SearchAlongWayLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SearchAlongWayLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SearchAlongWayLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SearchAlongWayLayerItem.3
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
        return SearchAlongWayLayerItemImpl.getClassTypeName();
    }

    public void setMSearchType(@SearchAlongwayType.SearchAlongwayType1 int i) {
        SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl = this.mService;
        if (searchAlongWayLayerItemImpl != null) {
            searchAlongWayLayerItemImpl.$explicit_setMSearchType(i);
        }
    }

    public void setMLabelType(@AlongWayLabelType.AlongWayLabelType1 int i) {
        SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl = this.mService;
        if (searchAlongWayLayerItemImpl != null) {
            searchAlongWayLayerItemImpl.$explicit_setMLabelType(i);
        }
    }

    public void setMTypeCode(int i) {
        SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl = this.mService;
        if (searchAlongWayLayerItemImpl != null) {
            searchAlongWayLayerItemImpl.$explicit_setMTypeCode(i);
        }
    }

    public void setMName(String str) {
        SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl = this.mService;
        if (searchAlongWayLayerItemImpl != null) {
            searchAlongWayLayerItemImpl.$explicit_setMName(str);
        }
    }

    public void setMExtraData(SearchAlongWayExtraData searchAlongWayExtraData) {
        SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl = this.mService;
        if (searchAlongWayLayerItemImpl != null) {
            searchAlongWayLayerItemImpl.$explicit_setMExtraData(searchAlongWayExtraData);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchAlongWayLayerItem
    @SearchAlongwayType.SearchAlongwayType1
    public int getMSearchType() {
        SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl = this.mService;
        if (searchAlongWayLayerItemImpl != null) {
            return searchAlongWayLayerItemImpl.$explicit_getMSearchType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchAlongWayLayerItem
    @AlongWayLabelType.AlongWayLabelType1
    public int getMLabelType() {
        SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl = this.mService;
        if (searchAlongWayLayerItemImpl != null) {
            return searchAlongWayLayerItemImpl.$explicit_getMLabelType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchAlongWayLayerItem
    public int getMTypeCode() {
        SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl = this.mService;
        if (searchAlongWayLayerItemImpl != null) {
            return searchAlongWayLayerItemImpl.$explicit_getMTypeCode();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchAlongWayLayerItem
    public String getMName() {
        SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl = this.mService;
        if (searchAlongWayLayerItemImpl != null) {
            return searchAlongWayLayerItemImpl.$explicit_getMName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchAlongWayLayerItem
    public SearchAlongWayExtraData getMExtraData() {
        SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl = this.mService;
        if (searchAlongWayLayerItemImpl != null) {
            return searchAlongWayLayerItemImpl.$explicit_getMExtraData();
        }
        return null;
    }
}
