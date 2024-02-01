package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.SearchChildLayerItemImpl;
import com.autonavi.gbl.layer.observer.ISearchChildLayerItem;
import com.autonavi.gbl.layer.router.SearchChildLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = SearchChildLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class SearchChildLayerItem extends PointLayerItem implements ISearchChildLayerItem {
    private static String PACKAGE = ReflexTool.PN(SearchChildLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private SearchChildLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected SearchChildLayerItem(long j, boolean z) {
        this(new SearchChildLayerItemRouter("SearchChildLayerItem", (ISearchChildLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISearchChildLayerItem.class}, new Object[]{this});
    }

    public SearchChildLayerItem(int i, String str) {
        this(new SearchChildLayerItemRouter("SearchChildLayerItem", (ISearchChildLayerItem) null, i, str));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISearchChildLayerItem.class}, new Object[]{this});
    }

    public SearchChildLayerItem(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        super(searchChildLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(searchChildLayerItemImpl);
    }

    private void $constructor(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        if (searchChildLayerItemImpl != null) {
            this.mService = searchChildLayerItemImpl;
            this.mTargetId = String.format("SearchChildLayerItem_%s_%d", String.valueOf(SearchChildLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public SearchChildLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
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
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
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
        return SearchChildLayerItemImpl.getClassTypeName();
    }

    public void setMChildType(int i) {
        SearchChildLayerItemImpl searchChildLayerItemImpl = this.mService;
        if (searchChildLayerItemImpl != null) {
            searchChildLayerItemImpl.$explicit_setMChildType(i);
        }
    }

    public void setMShortName(String str) {
        SearchChildLayerItemImpl searchChildLayerItemImpl = this.mService;
        if (searchChildLayerItemImpl != null) {
            searchChildLayerItemImpl.$explicit_setMShortName(str);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchChildLayerItem
    public int getMChildType() {
        SearchChildLayerItemImpl searchChildLayerItemImpl = this.mService;
        if (searchChildLayerItemImpl != null) {
            return searchChildLayerItemImpl.$explicit_getMChildType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ISearchChildLayerItem
    public String getMShortName() {
        SearchChildLayerItemImpl searchChildLayerItemImpl = this.mService;
        if (searchChildLayerItemImpl != null) {
            return searchChildLayerItemImpl.$explicit_getMShortName();
        }
        return null;
    }
}
