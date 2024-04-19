package com.autonavi.gbl.route.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.route.model.WeatherLabelItem;
import com.autonavi.gbl.route.observer.IRouteWeatherObserver;
import com.autonavi.gbl.route.observer.impl.IRouteWeatherObserverImpl;
import java.util.ArrayList;
@IntfAuto(target = IRouteWeatherObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RouteWeatherObserverRouter extends IRouteWeatherObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteWeatherObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(RouteWeatherObserverRouter.class);
    private TypeHelper mHelper;
    private IRouteWeatherObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IRouteWeatherObserver iRouteWeatherObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IRouteWeatherObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iRouteWeatherObserver;
    }

    protected RouteWeatherObserverRouter(String str, IRouteWeatherObserver iRouteWeatherObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteWeatherObserver);
    }

    protected RouteWeatherObserverRouter(String str, IRouteWeatherObserver iRouteWeatherObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteWeatherObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.router.RouteWeatherObserverRouter.1
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
    @Override // com.autonavi.gbl.route.observer.impl.IRouteWeatherObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.router.RouteWeatherObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.route.observer.impl.IRouteWeatherObserverImpl
    public void onWeatherUpdated(long j, ArrayList<WeatherLabelItem> arrayList) {
        IRouteWeatherObserver iRouteWeatherObserver = this.mObserver;
        if (iRouteWeatherObserver != null) {
            iRouteWeatherObserver.onWeatherUpdated(j, arrayList);
        }
    }
}
