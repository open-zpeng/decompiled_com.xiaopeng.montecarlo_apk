package com.autonavi.gbl.map.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.CollisionItemImpl;
import com.autonavi.gbl.map.impl.ICollisonRemoveObseverImpl;
import com.autonavi.gbl.map.observer.ICollisionItem;
import com.autonavi.gbl.map.observer.ICollisonRemoveObsever;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = ICollisonRemoveObsever.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CollisonRemoveObseverRouter extends ICollisonRemoveObseverImpl {
    private static BindTable BIND_TABLE = new BindTable(CollisonRemoveObseverRouter.class);
    private static String PACKAGE = ReflexTool.PN(CollisonRemoveObseverRouter.class);
    private TypeHelper mHelper;
    private ICollisonRemoveObsever mObserver;
    private String mTargetId;

    private void $constructor(String str, ICollisonRemoveObsever iCollisonRemoveObsever) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICollisonRemoveObseverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCollisonRemoveObsever;
    }

    protected CollisonRemoveObseverRouter(String str, ICollisonRemoveObsever iCollisonRemoveObsever, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCollisonRemoveObsever);
    }

    protected CollisonRemoveObseverRouter(String str, ICollisonRemoveObsever iCollisonRemoveObsever) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCollisonRemoveObsever);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.impl.ICollisonRemoveObseverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.impl.ICollisonRemoveObseverImpl
    public void removeCollisionItems(ArrayList<CollisionItemImpl> arrayList) {
        TypeHelper typeHelper;
        try {
            Method method = CollisonRemoveObseverRouter.class.getMethod("removeCollisionItems", ArrayList.class);
            ArrayList<ICollisionItem> arrayList2 = null;
            if (arrayList != null && (typeHelper = this.mHelper) != null) {
                arrayList2 = (ArrayList) typeHelper.transfer(method, 0, (ArrayList) arrayList);
            }
            ICollisonRemoveObsever iCollisonRemoveObsever = this.mObserver;
            if (iCollisonRemoveObsever != null) {
                iCollisonRemoveObsever.removeCollisionItems(arrayList2);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.impl.ICollisonRemoveObseverImpl
    public void onRecoverCollisonItem(CollisionItemImpl collisionItemImpl) {
        TypeHelper typeHelper;
        try {
            Method method = CollisonRemoveObseverRouter.class.getMethod("onRecoverCollisonItem", CollisionItemImpl.class);
            ICollisionItem iCollisionItem = null;
            if (collisionItemImpl != null && (typeHelper = this.mHelper) != null) {
                iCollisionItem = (ICollisionItem) typeHelper.transfer(method, 0, collisionItemImpl);
            }
            ICollisonRemoveObsever iCollisonRemoveObsever = this.mObserver;
            if (iCollisonRemoveObsever != null) {
                iCollisonRemoveObsever.onRecoverCollisonItem(iCollisionItem);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }
}
