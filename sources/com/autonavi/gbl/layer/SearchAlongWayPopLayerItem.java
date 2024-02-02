package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.SearchAlongWayPopLayerItemImpl;
import com.autonavi.gbl.layer.model.AlongWayLabelType;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.model.BizSearchAlongWayPoint;
import com.autonavi.gbl.layer.model.SearchAlongWayExtraData;
import com.autonavi.gbl.layer.observer.ISearchAlongWayPopLayerItem;
import com.autonavi.gbl.layer.router.SearchAlongWayPopLayerItemRouter;
import com.autonavi.gbl.map.layer.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(target = SearchAlongWayPopLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class SearchAlongWayPopLayerItem extends QuadrantLayerItemImpl implements ISearchAlongWayPopLayerItem {
    private static String PACKAGE = ReflexTool.PN(SearchAlongWayPopLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private SearchAlongWayPopLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected SearchAlongWayPopLayerItem(long j, boolean z) {
        this(new SearchAlongWayPopLayerItemRouter("SearchAlongWayPopLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISearchAlongWayPopLayerItem.class}, new Object[]{this});
    }

    public SearchAlongWayPopLayerItem(@QuadrantType.QuadrantType1 int i, long j, BizSearchAlongWayPoint bizSearchAlongWayPoint, @AlongWayLabelType.AlongWayLabelType1 int i2) {
        this(new SearchAlongWayPopLayerItemRouter("SearchAlongWayPopLayerItem", null, i, j, bizSearchAlongWayPoint, i2));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISearchAlongWayPopLayerItem.class}, new Object[]{this});
    }

    public SearchAlongWayPopLayerItem(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        super(searchAlongWayPopLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(searchAlongWayPopLayerItemImpl);
    }

    private void $constructor(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        if (searchAlongWayPopLayerItemImpl != null) {
            this.mService = searchAlongWayPopLayerItemImpl;
            this.mTargetId = String.format("SearchAlongWayPopLayerItem_%s_%d", String.valueOf(SearchAlongWayPopLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public SearchAlongWayPopLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SearchAlongWayPopLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SearchAlongWayPopLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SearchAlongWayPopLayerItem.3
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
        return SearchAlongWayPopLayerItemImpl.getClassTypeName();
    }

    public void setMSearchType(int i) {
        SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl = this.mService;
        if (searchAlongWayPopLayerItemImpl != null) {
            searchAlongWayPopLayerItemImpl.$explicit_setMSearchType(i);
        }
    }

    public void setMTypeCode(int i) {
        SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl = this.mService;
        if (searchAlongWayPopLayerItemImpl != null) {
            searchAlongWayPopLayerItemImpl.$explicit_setMTypeCode(i);
        }
    }

    public void setMLabelType(@AlongWayLabelType.AlongWayLabelType1 int i) {
        SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl = this.mService;
        if (searchAlongWayPopLayerItemImpl != null) {
            searchAlongWayPopLayerItemImpl.$explicit_setMLabelType(i);
        }
    }

    public void setMDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl = this.mService;
        if (searchAlongWayPopLayerItemImpl != null) {
            searchAlongWayPopLayerItemImpl.$explicit_setMDirectionStyle(i);
        }
    }

    public void setMName(String str) {
        SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl = this.mService;
        if (searchAlongWayPopLayerItemImpl != null) {
            searchAlongWayPopLayerItemImpl.$explicit_setMName(str);
        }
    }

    public void setMExtraData(SearchAlongWayExtraData searchAlongWayExtraData) {
        SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl = this.mService;
        if (searchAlongWayPopLayerItemImpl != null) {
            searchAlongWayPopLayerItemImpl.$explicit_setMExtraData(searchAlongWayExtraData);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchAlongWayPopLayerItem
    public int getMSearchType() {
        SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl = this.mService;
        if (searchAlongWayPopLayerItemImpl != null) {
            return searchAlongWayPopLayerItemImpl.$explicit_getMSearchType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchAlongWayPopLayerItem
    public int getMTypeCode() {
        SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl = this.mService;
        if (searchAlongWayPopLayerItemImpl != null) {
            return searchAlongWayPopLayerItemImpl.$explicit_getMTypeCode();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchAlongWayPopLayerItem
    @AlongWayLabelType.AlongWayLabelType1
    public int getMLabelType() {
        SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl = this.mService;
        if (searchAlongWayPopLayerItemImpl != null) {
            return searchAlongWayPopLayerItemImpl.$explicit_getMLabelType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchAlongWayPopLayerItem
    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl = this.mService;
        if (searchAlongWayPopLayerItemImpl != null) {
            return searchAlongWayPopLayerItemImpl.$explicit_getMDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchAlongWayPopLayerItem
    public String getMName() {
        SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl = this.mService;
        if (searchAlongWayPopLayerItemImpl != null) {
            return searchAlongWayPopLayerItemImpl.$explicit_getMName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchAlongWayPopLayerItem
    public SearchAlongWayExtraData getMExtraData() {
        SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl = this.mService;
        if (searchAlongWayPopLayerItemImpl != null) {
            return searchAlongWayPopLayerItemImpl.$explicit_getMExtraData();
        }
        return null;
    }
}
