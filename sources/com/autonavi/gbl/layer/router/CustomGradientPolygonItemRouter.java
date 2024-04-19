package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.CustomGradientPolygonItemImpl;
import com.autonavi.gbl.layer.observer.ICustomGradientPolygonItem;
import com.autonavi.gbl.map.impl.MapViewImpl;
@IntfAuto(target = ICustomGradientPolygonItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CustomGradientPolygonItemRouter extends CustomGradientPolygonItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CustomGradientPolygonItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(CustomGradientPolygonItemRouter.class);
    private TypeHelper mHelper;
    private ICustomGradientPolygonItem mObserver;
    private String mTargetId;

    private void $constructor(String str, ICustomGradientPolygonItem iCustomGradientPolygonItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CustomGradientPolygonItemImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCustomGradientPolygonItem;
    }

    protected CustomGradientPolygonItemRouter(String str, ICustomGradientPolygonItem iCustomGradientPolygonItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCustomGradientPolygonItem);
    }

    protected CustomGradientPolygonItemRouter(String str, ICustomGradientPolygonItem iCustomGradientPolygonItem, MapViewImpl mapViewImpl) {
        super(mapViewImpl);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCustomGradientPolygonItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CustomGradientPolygonItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.CustomGradientPolygonItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CustomGradientPolygonItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.CustomGradientPolygonItemImpl
    public void setMType(int i) {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            iCustomGradientPolygonItem.setMType(i);
        }
    }

    @Override // com.autonavi.gbl.layer.impl.CustomGradientPolygonItemImpl
    public int getMType() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.getMType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.CustomGradientPolygonItemImpl
    public void setMValue(String str) {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            iCustomGradientPolygonItem.setMValue(str);
        }
    }

    @Override // com.autonavi.gbl.layer.impl.CustomGradientPolygonItemImpl
    public String getMValue() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.getMValue();
        }
        return null;
    }
}
