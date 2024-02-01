package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.CollisionItemImpl;
import com.autonavi.gbl.map.model.PixelPoint;
import com.autonavi.gbl.map.observer.ICollisionItem;
import java.util.ArrayList;
@IntfAuto(target = ICollisionItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CollisionItemRouter extends CollisionItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CollisionItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(CollisionItemRouter.class);
    private TypeHelper mHelper;
    private ICollisionItem mObserver;
    private String mTargetId;

    private void $constructor(String str, ICollisionItem iCollisionItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CollisionItemImpl.getCPtr((CollisionItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCollisionItem;
    }

    protected CollisionItemRouter(String str, ICollisionItem iCollisionItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCollisionItem);
    }

    protected CollisionItemRouter(String str, ICollisionItem iCollisionItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCollisionItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ICollisionItem iCollisionItem = this.mObserver;
        if (iCollisionItem != null) {
            iCollisionItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ICollisionItem iCollisionItem = this.mObserver;
        if (iCollisionItem != null) {
            iCollisionItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ICollisionItem iCollisionItem = this.mObserver;
        if (iCollisionItem != null) {
            return iCollisionItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ICollisionItem iCollisionItem = this.mObserver;
        if (iCollisionItem != null) {
            iCollisionItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ICollisionItem iCollisionItem = this.mObserver;
        if (iCollisionItem != null) {
            return iCollisionItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ICollisionItem iCollisionItem = this.mObserver;
        if (iCollisionItem != null) {
            return iCollisionItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ICollisionItem iCollisionItem = this.mObserver;
        if (iCollisionItem != null) {
            return iCollisionItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ICollisionItem iCollisionItem = this.mObserver;
        if (iCollisionItem != null) {
            return iCollisionItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ICollisionItem iCollisionItem = this.mObserver;
        if (iCollisionItem != null) {
            iCollisionItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ICollisionItem iCollisionItem = this.mObserver;
        if (iCollisionItem != null) {
            return iCollisionItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ICollisionItem iCollisionItem = this.mObserver;
        if (iCollisionItem != null) {
            return iCollisionItem.canAreaCollision();
        }
        return false;
    }
}
