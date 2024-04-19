package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.ICollisionItemImpl;
import com.autonavi.gbl.map.model.PixelPoint;
import com.autonavi.gbl.map.observer.ICollisionItem;
import java.util.ArrayList;
@IntfAuto(target = ICollisionItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CollisionItemRouter extends ICollisionItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CollisionItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(CollisionItemRouter.class);
    private TypeHelper mHelper;
    private ICollisionItem mObserver;
    private String mTargetId;

    private void $constructor(String str, ICollisionItem iCollisionItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICollisionItemImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
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
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.CollisionItemRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.CollisionItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        ICollisionItem iCollisionItem = this.mObserver;
        if (iCollisionItem != null) {
            iCollisionItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ICollisionItem iCollisionItem = this.mObserver;
        if (iCollisionItem != null) {
            iCollisionItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        ICollisionItem iCollisionItem = this.mObserver;
        if (iCollisionItem != null) {
            return iCollisionItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        ICollisionItem iCollisionItem = this.mObserver;
        if (iCollisionItem != null) {
            iCollisionItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ICollisionItem iCollisionItem = this.mObserver;
        if (iCollisionItem != null) {
            return iCollisionItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ICollisionItem iCollisionItem = this.mObserver;
        if (iCollisionItem != null) {
            return iCollisionItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ICollisionItem iCollisionItem = this.mObserver;
        if (iCollisionItem != null) {
            return iCollisionItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ICollisionItem iCollisionItem = this.mObserver;
        if (iCollisionItem != null) {
            return iCollisionItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ICollisionItem iCollisionItem = this.mObserver;
        if (iCollisionItem != null) {
            iCollisionItem.setAreaCollision(z);
        }
    }
}
