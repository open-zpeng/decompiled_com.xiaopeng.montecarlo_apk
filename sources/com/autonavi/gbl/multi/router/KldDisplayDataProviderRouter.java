package com.autonavi.gbl.multi.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.model.DAY_STATUS;
import com.autonavi.gbl.map.model.DeviceAttribute;
import com.autonavi.gbl.map.model.EGLSurfaceAttr;
import com.autonavi.gbl.map.model.MapSkyboxParam;
import com.autonavi.gbl.multi.model.DisplayType;
import com.autonavi.gbl.multi.observer.IKldDisplayDataProvider;
import com.autonavi.gbl.multi.observer.impl.IKldDisplayDataProviderImpl;
@IntfAuto(target = IKldDisplayDataProvider.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class KldDisplayDataProviderRouter extends IKldDisplayDataProviderImpl {
    private static BindTable BIND_TABLE = new BindTable(KldDisplayDataProviderRouter.class);
    private static String PACKAGE = ReflexTool.PN(KldDisplayDataProviderRouter.class);
    private TypeHelper mHelper;
    private IKldDisplayDataProvider mObserver;
    private String mTargetId;

    private void $constructor(String str, IKldDisplayDataProvider iKldDisplayDataProvider) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IKldDisplayDataProviderImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iKldDisplayDataProvider;
    }

    protected KldDisplayDataProviderRouter(String str, IKldDisplayDataProvider iKldDisplayDataProvider, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iKldDisplayDataProvider);
    }

    protected KldDisplayDataProviderRouter(String str, IKldDisplayDataProvider iKldDisplayDataProvider) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iKldDisplayDataProvider);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.KldDisplayDataProviderRouter.1
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
    @Override // com.autonavi.gbl.multi.observer.impl.IKldDisplayDataProviderImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.KldDisplayDataProviderRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldDisplayDataProviderImpl
    public int onFetchDeviceAttr(@DisplayType.DisplayType1 int i, DeviceAttribute deviceAttribute) {
        IKldDisplayDataProvider iKldDisplayDataProvider = this.mObserver;
        if (iKldDisplayDataProvider != null) {
            return iKldDisplayDataProvider.onFetchDeviceAttr(i, deviceAttribute);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldDisplayDataProviderImpl
    public int onFetchSurfaceAttr(@DisplayType.DisplayType1 int i, EGLSurfaceAttr eGLSurfaceAttr) {
        IKldDisplayDataProvider iKldDisplayDataProvider = this.mObserver;
        if (iKldDisplayDataProvider != null) {
            return iKldDisplayDataProvider.onFetchSurfaceAttr(i, eGLSurfaceAttr);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldDisplayDataProviderImpl
    public int onFetchSkyBox(@DisplayType.DisplayType1 int i, @DAY_STATUS.DAY_STATUS1 int i2, MapSkyboxParam mapSkyboxParam) {
        IKldDisplayDataProvider iKldDisplayDataProvider = this.mObserver;
        if (iKldDisplayDataProvider != null) {
            return iKldDisplayDataProvider.onFetchSkyBox(i, i2, mapSkyboxParam);
        }
        return 0;
    }
}
