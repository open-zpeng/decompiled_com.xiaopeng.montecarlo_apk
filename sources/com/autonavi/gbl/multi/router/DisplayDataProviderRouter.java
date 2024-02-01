package com.autonavi.gbl.multi.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.model.DAY_STATUS;
import com.autonavi.gbl.map.model.DeviceAttribute;
import com.autonavi.gbl.map.model.EGLSurfaceAttr;
import com.autonavi.gbl.map.model.MapSkyboxParam;
import com.autonavi.gbl.multi.display.model.DisplayType;
import com.autonavi.gbl.multi.display.observer.IDisplayDataProvider;
import com.autonavi.gbl.multi.display.observer.impl.IDisplayDataProviderImpl;
@IntfAuto(target = IDisplayDataProvider.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class DisplayDataProviderRouter extends IDisplayDataProviderImpl {
    private static BindTable BIND_TABLE = new BindTable(DisplayDataProviderRouter.class);
    private static String PACKAGE = ReflexTool.PN(DisplayDataProviderRouter.class);
    private TypeHelper mHelper;
    private IDisplayDataProvider mObserver;
    private String mTargetId;

    private void $constructor(String str, IDisplayDataProvider iDisplayDataProvider) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IDisplayDataProviderImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iDisplayDataProvider;
    }

    protected DisplayDataProviderRouter(String str, IDisplayDataProvider iDisplayDataProvider, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDisplayDataProvider);
    }

    protected DisplayDataProviderRouter(String str, IDisplayDataProvider iDisplayDataProvider) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDisplayDataProvider);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.multi.display.observer.impl.IDisplayDataProviderImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.multi.display.observer.impl.IDisplayDataProviderImpl
    public int onFetchDeviceAttr(@DisplayType.DisplayType1 int i, DeviceAttribute deviceAttribute) {
        IDisplayDataProvider iDisplayDataProvider = this.mObserver;
        if (iDisplayDataProvider != null) {
            return iDisplayDataProvider.onFetchDeviceAttr(i, deviceAttribute);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.display.observer.impl.IDisplayDataProviderImpl
    public int onFetchSurfaceAttr(@DisplayType.DisplayType1 int i, EGLSurfaceAttr eGLSurfaceAttr) {
        IDisplayDataProvider iDisplayDataProvider = this.mObserver;
        if (iDisplayDataProvider != null) {
            return iDisplayDataProvider.onFetchSurfaceAttr(i, eGLSurfaceAttr);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.display.observer.impl.IDisplayDataProviderImpl
    public int onFetchSkyBox(@DisplayType.DisplayType1 int i, @DAY_STATUS.DAY_STATUS1 int i2, MapSkyboxParam mapSkyboxParam) {
        IDisplayDataProvider iDisplayDataProvider = this.mObserver;
        if (iDisplayDataProvider != null) {
            return iDisplayDataProvider.onFetchSkyBox(i, i2, mapSkyboxParam);
        }
        return 0;
    }
}
