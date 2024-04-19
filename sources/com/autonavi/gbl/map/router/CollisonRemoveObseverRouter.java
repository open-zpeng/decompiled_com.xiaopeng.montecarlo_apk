package com.autonavi.gbl.map.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.ICollisionItemImpl;
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
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.CollisonRemoveObseverRouter.1
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
    @Override // com.autonavi.gbl.map.impl.ICollisonRemoveObseverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.CollisonRemoveObseverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.impl.ICollisonRemoveObseverImpl
    public void removeCollisionItems(ArrayList<ICollisionItemImpl> arrayList) {
        try {
            Method method = CollisonRemoveObseverRouter.class.getMethod("removeCollisionItems", ArrayList.class);
            if (arrayList != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (ArrayList) typeHelper.transfer(method, 0, (ArrayList) arrayList) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $vecItems == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.CollisonRemoveObseverRouter.3
                    }));
                }
            }
            ICollisonRemoveObsever iCollisonRemoveObsever = this.mObserver;
            if (iCollisonRemoveObsever != null) {
                iCollisonRemoveObsever.removeCollisionItems(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.impl.ICollisonRemoveObseverImpl
    public void onRecoverCollisonItem(ICollisionItemImpl iCollisionItemImpl) {
        try {
            Method method = CollisonRemoveObseverRouter.class.getMethod("onRecoverCollisonItem", ICollisionItemImpl.class);
            if (iCollisionItemImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (ICollisionItem) typeHelper.transfer(method, 0, iCollisionItemImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pItem == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.CollisonRemoveObseverRouter.4
                    }));
                }
            }
            ICollisonRemoveObsever iCollisonRemoveObsever = this.mObserver;
            if (iCollisonRemoveObsever != null) {
                iCollisonRemoveObsever.onRecoverCollisonItem(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }
}
