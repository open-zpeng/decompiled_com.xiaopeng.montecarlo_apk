package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.FavoritePointLayerItemImpl;
import com.autonavi.gbl.layer.observer.IFavoritePointLayerItem;
import com.autonavi.gbl.layer.router.FavoritePointLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
import com.autonavi.gbl.user.behavior.model.FavoriteType;
@IntfAuto(target = FavoritePointLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class FavoritePointLayerItem extends PointLayerItem implements IFavoritePointLayerItem {
    private static String PACKAGE = ReflexTool.PN(FavoritePointLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private FavoritePointLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected FavoritePointLayerItem(long j, boolean z) {
        this(new FavoritePointLayerItemRouter("FavoritePointLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IFavoritePointLayerItem.class}, new Object[]{this});
    }

    public FavoritePointLayerItem(@FavoriteType.FavoriteType1 int i) {
        this(new FavoritePointLayerItemRouter("FavoritePointLayerItem", null, i));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IFavoritePointLayerItem.class}, new Object[]{this});
    }

    public FavoritePointLayerItem(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        super(favoritePointLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(favoritePointLayerItemImpl);
    }

    private void $constructor(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        if (favoritePointLayerItemImpl != null) {
            this.mService = favoritePointLayerItemImpl;
            this.mTargetId = String.format("FavoritePointLayerItem_%s_%d", String.valueOf(FavoritePointLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public FavoritePointLayerItemImpl getService() {
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

    public void setMFavoriteType(@FavoriteType.FavoriteType1 int i) {
        FavoritePointLayerItemImpl favoritePointLayerItemImpl = this.mService;
        if (favoritePointLayerItemImpl != null) {
            favoritePointLayerItemImpl.$explicit_setMFavoriteType(i);
        }
    }

    public static String getClassTypeName() {
        return FavoritePointLayerItemImpl.getClassTypeName();
    }

    @Override // com.autonavi.gbl.layer.observer.IFavoritePointLayerItem
    @FavoriteType.FavoriteType1
    public int getMFavoriteType() {
        FavoritePointLayerItemImpl favoritePointLayerItemImpl = this.mService;
        if (favoritePointLayerItemImpl != null) {
            return favoritePointLayerItemImpl.$explicit_getMFavoriteType();
        }
        return Integer.MIN_VALUE;
    }
}
