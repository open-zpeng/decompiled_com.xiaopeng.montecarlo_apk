package com.autonavi.gbl.map.observer;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.observer.impl.IMapDataProviderImpl;
import com.autonavi.gbl.map.router.MapDataProviderRouter;
@IntfAuto(target = MapDataProviderRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class MapDataProvider implements IMapDataProvider {
    private static String PACKAGE = ReflexTool.PN(MapDataProvider.class);
    private boolean mHasDestroy;
    private IMapDataProviderImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected MapDataProvider(long j, boolean z) {
        this(new MapDataProviderRouter("MapDataProvider", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IMapDataProvider.class}, new Object[]{this});
    }

    public MapDataProvider() {
        this(new MapDataProviderRouter("MapDataProvider", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IMapDataProvider.class}, new Object[]{this});
    }

    public MapDataProvider(IMapDataProviderImpl iMapDataProviderImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(iMapDataProviderImpl);
    }

    private void $constructor(IMapDataProviderImpl iMapDataProviderImpl) {
        if (iMapDataProviderImpl != null) {
            this.mService = iMapDataProviderImpl;
            this.mTargetId = String.format("MapDataProvider_%s_%d", String.valueOf(IMapDataProviderImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    public IMapDataProviderImpl getService() {
        return this.mService;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.observer.MapDataProvider.1
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.observer.MapDataProvider.2
        }));
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.observer.MapDataProvider.3
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
            ReflexTool.invokeDeclMethodSafe(this.mService, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mService = null;
        }
        unbind();
    }
}
