package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.SearchParentLayerItemImpl;
import com.autonavi.gbl.layer.model.PoiParentType;
import com.autonavi.gbl.layer.observer.ISearchParentLayerItem;
import com.autonavi.gbl.layer.router.SearchParentLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = SearchParentLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class SearchParentLayerItem extends PointLayerItem implements ISearchParentLayerItem {
    private static String PACKAGE = ReflexTool.PN(SearchParentLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private SearchParentLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected SearchParentLayerItem(long j, boolean z) {
        this(new SearchParentLayerItemRouter("SearchParentLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISearchParentLayerItem.class}, new Object[]{this});
    }

    public SearchParentLayerItem(@PoiParentType.PoiParentType1 int i, int i2, int i3, String str, String str2, String str3) {
        this(new SearchParentLayerItemRouter("SearchParentLayerItem", null, i, i2, i3, str, str2, str3));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISearchParentLayerItem.class}, new Object[]{this});
    }

    public SearchParentLayerItem(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        super(searchParentLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(searchParentLayerItemImpl);
    }

    private void $constructor(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        if (searchParentLayerItemImpl != null) {
            this.mService = searchParentLayerItemImpl;
            this.mTargetId = String.format("SearchParentLayerItem_%s_%d", String.valueOf(SearchParentLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public SearchParentLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SearchParentLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SearchParentLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.SearchParentLayerItem.3
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
        return SearchParentLayerItemImpl.getClassTypeName();
    }

    public void setPoiType(@PoiParentType.PoiParentType1 int i) {
        SearchParentLayerItemImpl searchParentLayerItemImpl = this.mService;
        if (searchParentLayerItemImpl != null) {
            searchParentLayerItemImpl.$explicit_setPoiType(i);
        }
    }

    public void setTypeCode(int i) {
        SearchParentLayerItemImpl searchParentLayerItemImpl = this.mService;
        if (searchParentLayerItemImpl != null) {
            searchParentLayerItemImpl.$explicit_setTypeCode(i);
        }
    }

    public void setMIndex(int i) {
        SearchParentLayerItemImpl searchParentLayerItemImpl = this.mService;
        if (searchParentLayerItemImpl != null) {
            searchParentLayerItemImpl.$explicit_setMIndex(i);
        }
    }

    public void setMText(String str) {
        SearchParentLayerItemImpl searchParentLayerItemImpl = this.mService;
        if (searchParentLayerItemImpl != null) {
            searchParentLayerItemImpl.$explicit_setMText(str);
        }
    }

    public void setPoiName(String str) {
        SearchParentLayerItemImpl searchParentLayerItemImpl = this.mService;
        if (searchParentLayerItemImpl != null) {
            searchParentLayerItemImpl.$explicit_setPoiName(str);
        }
    }

    public void setMMarkerBGRes(String str) {
        SearchParentLayerItemImpl searchParentLayerItemImpl = this.mService;
        if (searchParentLayerItemImpl != null) {
            searchParentLayerItemImpl.$explicit_setMMarkerBGRes(str);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchParentLayerItem
    @PoiParentType.PoiParentType1
    public int getPoiType() {
        SearchParentLayerItemImpl searchParentLayerItemImpl = this.mService;
        if (searchParentLayerItemImpl != null) {
            return searchParentLayerItemImpl.$explicit_getPoiType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchParentLayerItem
    public int getTypeCode() {
        SearchParentLayerItemImpl searchParentLayerItemImpl = this.mService;
        if (searchParentLayerItemImpl != null) {
            return searchParentLayerItemImpl.$explicit_getTypeCode();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchParentLayerItem
    public int getMIndex() {
        SearchParentLayerItemImpl searchParentLayerItemImpl = this.mService;
        if (searchParentLayerItemImpl != null) {
            return searchParentLayerItemImpl.$explicit_getMIndex();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchParentLayerItem
    public String getMText() {
        SearchParentLayerItemImpl searchParentLayerItemImpl = this.mService;
        if (searchParentLayerItemImpl != null) {
            return searchParentLayerItemImpl.$explicit_getMText();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchParentLayerItem
    public String getPoiName() {
        SearchParentLayerItemImpl searchParentLayerItemImpl = this.mService;
        if (searchParentLayerItemImpl != null) {
            return searchParentLayerItemImpl.$explicit_getPoiName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchParentLayerItem
    public String getMMarkerBGRes() {
        SearchParentLayerItemImpl searchParentLayerItemImpl = this.mService;
        if (searchParentLayerItemImpl != null) {
            return searchParentLayerItemImpl.$explicit_getMMarkerBGRes();
        }
        return null;
    }
}
