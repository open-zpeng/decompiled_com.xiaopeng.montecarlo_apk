package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.observer.IMapDataProvider;
import com.autonavi.gbl.map.observer.MapDataProvider;
import com.autonavi.gbl.map.observer.impl.IMapDataProviderImpl;
@IntfAuto(target = MapDataProvider.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class MapDataProviderRouter extends IMapDataProviderImpl {
    private static BindTable BIND_TABLE = new BindTable(MapDataProviderRouter.class);
    private static String PACKAGE = ReflexTool.PN(MapDataProviderRouter.class);
    private TypeHelper mHelper;
    private IMapDataProvider mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IMapDataProvider iMapDataProvider) {
        if (iMapDataProvider != null) {
            this.mObserver = iMapDataProvider;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(MapDataProvider.class, iMapDataProvider, this);
            }
        }
    }

    private void $constructor(String str, IMapDataProvider iMapDataProvider) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IMapDataProviderImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iMapDataProvider);
    }

    public MapDataProviderRouter(String str, IMapDataProvider iMapDataProvider, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapDataProvider);
    }

    public MapDataProviderRouter(String str, IMapDataProvider iMapDataProvider) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapDataProvider);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.MapDataProviderRouter.1
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
    @Override // com.autonavi.gbl.map.observer.impl.IMapDataProviderImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.MapDataProviderRouter.2
        }));
        super.delete();
        unbind();
    }
}
